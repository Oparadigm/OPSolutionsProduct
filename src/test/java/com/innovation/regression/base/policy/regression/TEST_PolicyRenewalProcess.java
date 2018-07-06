package com.innovation.regression.base.policy.regression;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innovation.configuration.DriverManager;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.InsurerSetup;
import com.innovation.misc.SeleniumPageCoverage;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.misc.TransactionTimer;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.pages.policy.pages.PolicyRenewals;

/**
 * @author M.Tahir- Regression test script covering Amendments Flow
 */

public class TEST_PolicyRenewalProcess extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strState", "strCompany" })
	@Test
	public void PolicyRenewalProcess (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue, @Optional("United Kingdom") String strState,
			@Optional("8880") String strCompany) throws Exception
	{

		// Variables used in this scenario
		String strSelectBrand = strEnvironmentBrand;
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";
		String strLoginElement = "user";
		String strLoginNodeUsername = "username";
		String strLoginNodePassword = "password";
		String strLoginXMLFileName = "UserName.xml";

		// Setup
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
		PolicyRenewals renewpolicy = new PolicyRenewals (driver);
		NavigationPanel policyrenewalactivities = new NavigationPanel (driver);

		// PolicySummary policysummary = new PolicySummary (driver);
		HomeScreen home = new HomeScreen (driver);
		// ControlPanel control = new ControlPanel (driver);
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

		// select the LOB
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		String strSelectedLOB = renewpolicy.selectRandomLOB (strEnvironmentBrand);
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Navigate to the Policy Renewal Activity Frame
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		policyrenewalactivities.expandPolicySpan ();
		policyrenewalactivities.clickRenewalActivities ();
		TransactionTimer.stop (stopwatch, "Renewal Activities", driver, strEnvironmentName);

		// Enter Policy Number to get the Policy Renewal Activities
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		String strPolicytoRenew = renewpolicy.getPolicy (strEnvironmentName, strCompany, strSelectedLOB);
		renewpolicy.searchPolicyRenewalActivity (strPolicytoRenew);
		renewpolicy.processRenewals (strRegionValue, strPolicytoRenew, strEnvironmentName, strEnvironmentBrand);
		TransactionTimer.stop (stopwatch, "Policy Summary Screen", driver, strEnvironmentName);

		// After the Renewal Process has been completed script will search the same policy and navigate to the
		// policy summary screen

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}

}
