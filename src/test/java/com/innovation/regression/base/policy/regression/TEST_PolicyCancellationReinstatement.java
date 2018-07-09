package com.innovation.regression.base.policy.regression;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innovation.configuration.DriverManager;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.InsurerSetup;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.SeleniumPageCoverage;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.misc.TransactionTimer;
import com.innovation.pages.common.pages.ActionsPanel;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.pages.policy.pages.PolicyCancellation;
import com.innovation.pages.policy.pages.PolicyReinstatement;
import com.innovation.pages.policy.pages.PolicySummary;



public class TEST_PolicyCancellationReinstatement extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strState", "strCompany" })
	@Test
	public void PolicyCancellationReinstatement (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue, @Optional("United Kingdom") String strState,
			@Optional("8880") String strCompany) throws Exception
	{

		// Variables used in this scenario
		String strSelectBrand = strEnvironmentBrand;
		String strLocation = strRegionValue;
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";
		String strLoginElement = "user";
		String strLoginNodeUsername = "username";
		String strLoginNodePassword = "password";
		String strLoginXMLFileName = "UserName.xml";
		// Set the Days as defined in the Scenario
		int intCancellationDays = 15;
		// Set the Month as defined in the scenario
		int intMonth = 0;
		// Define the Year of the scenario
		int intYear = 0;

		int intReinstatementDays = RandomNumbers.randomNumberGenerator (1, 10);

		// Setup
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
		PolicyCancellation cancelpolicy = new PolicyCancellation (driver);
		PolicyReinstatement reinstatepolicy = new PolicyReinstatement (driver);
		PolicySummary policysummary = new PolicySummary (driver);
		HomeScreen home = new HomeScreen (driver);
		ActionsPanel actionspanel = new ActionsPanel (driver);
		ControlPanel control = new ControlPanel (driver);
		StopWatch stopwatch = new StopWatch ();

		// Login Page
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		login.getUsersFromDatabase (strEnvironmentName);
		login.typeUserNamePassword (strLoginElement, strLoginNodeUsername, strLoginNodePassword, strLoginXMLFileName, strEnvironmentName);

		// Login Timing
		TransactionTimer.start (stopwatch);
		login.clickLoginButton ();
		TransactionTimer.stop (stopwatch, "Login", driver, strEnvironmentName);

		// Check Previous Session Work items
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		previoussessionworkitems.clickRestoreAllAndApply ();

		// // Change Brand
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.clickChangeBrand ();
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.selectBrand (strSelectBrand);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.saveBrand ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Select Random LOB for Cancellation Process
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		String strLOB = cancelpolicy.selectRandomLOB ();

		// Enter Search through quick search
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		String strPolicytoCancel = cancelpolicy.getPolicy (strEnvironmentName, strCompany, strLOB);

		TransactionTimer.stop (stopwatch, "Policy Summary Screen", driver, strEnvironmentName);

		// string strPolicyto Cancel will present the active policy number
		// for cancellation

		cancelpolicy.searchPolicytoCancel (strPolicytoCancel);

		// From Policy Summary screen, click on the cancel policy link on the actions
		// panel
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		actionspanel.clickCancelPolicy ();
		TransactionTimer.stop (stopwatch, "Policy Cancellation", driver, strEnvironmentName);

		// we call the following function to set the cancellation date
		cancelpolicy.setCancellationDate (strLocation, intCancellationDays, intMonth, intYear);

		// from the following function we will select the cancellation reason
		String strCancelledReason = cancelpolicy.setCancellationReason ();
		// after selection of all the parameters for the cancellation of a policy user
		// will hit Process button
		cancelpolicy.processCancellation ();
		// Now after process the cancellation commit the cancellation transaction
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		cancelpolicy.commitCancellation (strPolicytoCancel);
		TransactionTimer.stop (stopwatch, "Policy Summary", driver, strEnvironmentName);

		// Policy Summary
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		policysummary.checkPolicyStatus ();
		policysummary.checkQutoePolicyNo ();

		// Reinstate the Policy
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		actionspanel.clickReinstatePolicy ();
		// Process the Reinstatement
		reinstatepolicy.processReinstatement (strCancelledReason, strLocation, intReinstatementDays, intMonth, intYear);

		control.clickFinishTransaction ();
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}

}
