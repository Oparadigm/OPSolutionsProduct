package com.innovation.regression.base.claims.regression;

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
import com.innovation.pages.claim.pages.ClaimClaimSummary;
import com.innovation.pages.claim.pages.ClaimInitialDetails;
import com.innovation.pages.claim.pages.ClaimItemManagementDetails;
import com.innovation.pages.claim.pages.ClaimMainSearch;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;



public class TEST_AddWithPolicyHomeownerWaterEscapeClaim extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void addWithPolicyHomeownerWaterEscapeClaim (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue, @Optional("8880") String strCompany)
			throws Exception
	{

		// Following variables are used as parameters in the test script
		String strSelectBrand = strEnvironmentBrand;
		String strRegion = strRegionValue;
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";
		String strLoginElement = "user";
		String strLoginNodeUsername = "username";
		String strLoginNodePassword = "password";
		String strLoginXMLFileName = "UserName.xml";
		String strSearchBy = "Reference number";
		String strDPACheckStatus = "Yes";
		String strAction = "Add property claim – fast track";
		String strDuplicateClaimAction = "Add";
		String strClaimType = "Water escape";
		String strCoverage = "Random";
		String strItemType = "Random";
		String strNumberOfRooms = "1";
		String strPriority = "High";
		String strFullfilmentRoute = "Supplier replace";
		String strEmailClaimSummary = "No";

		// Setup
		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		HomeScreen home = new HomeScreen (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
		ClaimMainSearch claimmainsearch = new ClaimMainSearch (driver);
		ClaimInitialDetails claiminitialdetails = new ClaimInitialDetails (driver);
		ClaimItemManagementDetails itemmanagmentdetails = new ClaimItemManagementDetails (driver);
		ClaimClaimSummary claimsummary = new ClaimClaimSummary (driver);
		StopWatch stopwatch = new StopWatch ();
		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);

		// Login Page
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		login.typeUserNamePassword (strLoginElement, strLoginNodeUsername, strLoginNodePassword, strLoginXMLFileName, strEnvironmentName);

		// Login Timing
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		login.clickLoginButton ();
		TransactionTimer.stop (stopwatch, "Login", driver, strEnvironmentName);

		// Check Previous Session Work items
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		previoussessionworkitems.clickRestoreAllAndApply ();
		TransactionTimer.stop (stopwatch, "Claim Search", driver, strEnvironmentName);

		// Change Brand
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.clickChangeBrand ();
		brandscheme.selectBrand (strSelectBrand);
		TransactionTimer.start (stopwatch);
		brandscheme.saveBrand ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Enter Claim Search
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickOnSearch ();
		home.clickOnClaimSearch ();
		TransactionTimer.stop (stopwatch, "Claim Search", driver, strEnvironmentName);

		// Search the Policy number and add Homeowner claim
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimmainsearch.selectSearchBy (strSearchBy);
		claimmainsearch.fetchHomePolicyBldgAndContCovers (strEnvironmentName, strCompany);
		claimmainsearch.selectDPACheckStatus (strDPACheckStatus);
		claimmainsearch.selectAction (strAction);
		claimmainsearch.typeIncidentDate (strRegion);
		TransactionTimer.start (stopwatch);
		claimmainsearch.clickOnGo (strDuplicateClaimAction);
		TransactionTimer.stop (stopwatch, "Initial Details", driver, strEnvironmentName);

		// Enter Claim Initial Details
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claiminitialdetails.selectBestContactTime ();
		claiminitialdetails.selectClaimType (strClaimType);
		claiminitialdetails.selectIncidentCause ();
		claiminitialdetails.typeIncidentTime ();
		claiminitialdetails.selectSeverLoss ();
		claiminitialdetails.typeIncidentDescription ();
		claiminitialdetails.typeReferenceNumber ();
		claiminitialdetails.typeLocationDescription ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Policy Details", driver, strEnvironmentName);

		// Navigate forward from Policy Details frame
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		// claimpolicydetails.clickEventManagementNo ();
		TransactionTimer.stop (stopwatch, "Incident Details", driver, strEnvironmentName);

		// Enter Item Management
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		itemmanagmentdetails.selectCoverage (strCoverage);
		itemmanagmentdetails.selectItemType (strItemType);
		itemmanagmentdetails.typeItemDetails ();
		itemmanagmentdetails.selectNumberOfRoom (strNumberOfRooms);
		itemmanagmentdetails.selectPriority (strPriority);
		itemmanagmentdetails.typeDateLastUsed (strRegion);
		itemmanagmentdetails.selectFullfilmentRoute (strFullfilmentRoute);
		itemmanagmentdetails.clickSave ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Claim Summary", driver, strEnvironmentName);

		// Enter Claim Summary
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimsummary.selectEmailClaimSummary (strEmailClaimSummary);
		TransactionTimer.start (stopwatch);
		claimsummary.clickFlowCompleted ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Signing out
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}
}
