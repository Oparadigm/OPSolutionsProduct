package com.innovation.regressionsuite.ZAPTest.copy;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innovation.configuration.DriverManager;
import com.innovation.data.XMLDataReader;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.InsurerSetup;
import com.innovation.misc.SeleniumPageCoverage;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.misc.TransactionTimer;
import com.innovation.pages.client.pages.AddIndividualClient;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.pages.policy.pages.PolicyClientSearch;

/**
 * @author lushs
 *
 */

public class TEST_ZAPManualVerifyAddIndividualClient extends DriverManager
{
	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue" })
	@Test
	public void verifyAddIndividualClient (@Optional("CHROME_ZAP") String strBrowser, @Optional("Bungo") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue) throws Exception
	{

		// Opens ZAP, may need to adjust the installation path in ZAPInstallPortFileLocations.xml
		// Only start ZAP in the script if disabled in the DriverManager.java class
		// ZAP.OpenZAP();

		// Increase or decrease the default 30 seconds global timeout if required
		// GlobalWaitTime.setIntWaitTime (40);

		// Clear all user LOGONFAILURECOUNT

		String strSelectBrand = strEnvironmentBrand;
		String strRegion = strRegionValue;
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";
		String strLoginElement = "user";
		String strLoginNodeUsername = "username";
		String strLoginNodePassword = "password";
		String strLoginXMLFileName = "UserName.xml";

		// Gets the Application URL to set the ZAP Target and passes it to the DriverManager.java class.
		// Otherwise it would use the hard coded target URL defined in the ZAPInstallPortFileLocations.xml.
		XMLDataReader returnXMLString = new XMLDataReader ();
		String strEndPoint = returnXMLString.ReturnXMLNode (strEnvironmentName, strURL, strUrlXML);
		DriverManager.setEndPoint (strEndPoint);

		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		LoginPage login = new LoginPage (driver);
		HomeScreen home = new HomeScreen (driver);
		// HibernateSearch search = new HibernateSearch (driver);
		PolicyClientSearch policyclientsearch = new PolicyClientSearch (driver);
		AddIndividualClient addIndividualclient = new AddIndividualClient (driver);
		StopWatch stopwatch = new StopWatch ();
		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);

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

		// Change Brand
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.clickChangeBrand ();
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.selectBrand (strSelectBrand);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		brandscheme.saveBrand ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Enter Search
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickOnSearch ();
		home.clickOnPolicyClientSearch ();
		TransactionTimer.stop (stopwatch, "Policy Client Search", driver, strEnvironmentName);

		// Policy Client Search
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policyclientsearch.typeClientLastName ();
		policyclientsearch.typeClientFirstName ();
		policyclientsearch.typeClientZipCode ("S");
		policyclientsearch.clickSearchButton ();
		TransactionTimer.start (stopwatch);
		policyclientsearch.clickNewIndividualButton ();
		TransactionTimer.stop (stopwatch, "Add Individual Client", driver, strEnvironmentName);

		// Add Individual Page
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		addIndividualclient.selectTitle ();
		addIndividualclient.typeEmail ();
		addIndividualclient.typeHomePhoneNo ();
		addIndividualclient.typeZIPCode (strRegion);
		addIndividualclient.clickZipCodeSearchIcon ();
		addIndividualclient.SearchCriteriaDropDown ();
		addIndividualclient.typeDOB (strRegion);
		addIndividualclient.selectGender ();
		addIndividualclient.selectMaritalStatus ();
		addIndividualclient.selectOccupation ();
		addIndividualclient.selectLanguage (strRegionValue);
		addIndividualclient.clickPrivacyAgreement ();
		addIndividualclient.validatePrivacyAgreement ();
		addIndividualclient.privacyAgreementAcceptance ();
		TransactionTimer.start (stopwatch);
		addIndividualclient.clickNext ();
		addIndividualclient.clickYes ();
		TransactionTimer.stop (stopwatch, "Client Summary", driver, strEnvironmentName);

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

		// This calls the ZAP class here you can set the following options:
		// Spider the application - disabled as we will run handle this manually.
		// Only enable these options if these have been disabled in the DriverManager.java class
		// Active Scan - would start an invasive test to find vulnerabilities - disabled
		// as we will run handle this manually.
		// Write out the ZAP XML Report - the directory is set in the
		// ZAPInstallPortFileLocations.xml
		// Write out the ZAP HTML Report - the directory is set in the
		// ZAPInstallPortFileLocations.xml
		// Close the ZAP Application - may want to comment this out if we want to
		// manually run an active scan after
		// capturing the various flows after running the test suite.

		// ZAP.SpiderTarget(endPoint);
		// ZAP.ActiveScanTarget(endPoint);
		// ZAP.writeXMLReportZAP();
		// ZAP.writeXMLReportZAP();
		// ZAP.CloseZAP();

	}

}
