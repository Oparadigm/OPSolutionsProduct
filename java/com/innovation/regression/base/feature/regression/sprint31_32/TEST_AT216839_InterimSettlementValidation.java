package com.innovation.regression.base.feature.regression.sprint31_32;

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
import com.innovation.pages.claim.pages.ClaimMOJActions;
import com.innovation.pages.claim.pages.ClaimMOJClaims;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.regression.base.feature.regression.common.InsurerClaimActionsForMOJ;
import com.innovation.soap.connection.MOJConstants;
import com.innovation.soap.customexceptions.TestCaseValidationFailed;
import com.innovation.soap.regression.moj.MOJMethods;

/**
 * @author haiderm - Sprint 31 - Regression Test AT-216839: To verify that when Stage 2.2 settlement pack has been received from the
 *         CR, stage 2 settlement tab should be displayed
 * @Pre-req MOJ Claim status should be created and accepted from Insurer MOJ Claim “Stage 2 Settlement Pack Form” is sent by CR
 * 
 * @ExpectedResults Stage 2.2 Settlement tab on the MOJ actions screen should be displayed
 *
 */
public class TEST_AT216839_InterimSettlementValidation extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void testForAT216839 (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue, @Optional("8880") String strCompany)
			throws Exception
	{

		// Variables used in this scenario
		String strElementEnv = strEnvironmentName;
		String strSelectBrand = strEnvironmentBrand;
		String strRegion = strRegionValue;
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";
		String strLoginElement = "user";
		String strLoginNodeUsername = "username";
		String strLoginNodePassword = "password";
		String strLoginXMLFileName = "UserName.xml";
		String strActivityEngineGuid = MOJConstants.MOJ_ACTIVITYENGINEGUID;
		String strIsInterimPaymentNeededValue = "1";
		String strMOJClaimNumber;
		String strInsurerClaimNumber;
		String strUpdatedActivityEngineGuid;
		String strLatestActivityEngineGuid;
		String strPhaseCacheName = MOJConstants.MOJ_PHASECACHENAME;

		// Setup
		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);
		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		HomeScreen home = new HomeScreen (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
		InsurerClaimActionsForMOJ insurerclaimactions = new InsurerClaimActionsForMOJ (driver);
		ClaimClaimSummary claimsummary = new ClaimClaimSummary (driver);
		ClaimMOJClaims mojclaims = new ClaimMOJClaims (driver);
		ClaimMOJActions mojactions = new ClaimMOJActions (driver);
		NavigationPanel navigationpanel = new NavigationPanel (driver);
		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
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

		// Generate MOJ Claim Number via SOAP Service
		MOJMethods mojmethods = new MOJMethods ();
		strMOJClaimNumber = mojmethods.getMOJClaimNumber ();

		// Create 1insurer Claim Number to associate MOJ Claim with
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strInsurerClaimNumber = insurerclaimactions.createMotorClaimWithTPBI (strElementEnv, strCompany, strRegion);

		// Associate and Accept CNF in 1insurer
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		insurerclaimactions.acceptMOJClaim (strMOJClaimNumber, strInsurerClaimNumber, strEnvironmentName);

		// Apply Article75
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		insurerclaimactions.applyArticle75 (strEnvironmentName);

		// Take Liability Decision
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		insurerclaimactions.takeLiabilityDecision ();

		// Get MOJ Claim Status - CR service action
		strActivityEngineGuid = mojmethods.getMOJClaimStatus (strMOJClaimNumber, strActivityEngineGuid);

		// Acknowledge Liability is admitted - CR service action
		strUpdatedActivityEngineGuid = mojmethods.acknowledgeLiabilityAdmitted (strMOJClaimNumber, strActivityEngineGuid);

		// Set Interim Payment Needed - CR service action
		strLatestActivityEngineGuid = mojmethods.setInterimPaymentNeeded (strMOJClaimNumber, strUpdatedActivityEngineGuid, strIsInterimPaymentNeededValue);

		// Add Interim Sender Policy Framework (SPF) - CR service action
		strPhaseCacheName = mojmethods.addInterimSPFRequest (strMOJClaimNumber, strLatestActivityEngineGuid);

		// Verify the Pre-Req is met, only then perform main regression steps

		if (strPhaseCacheName.equalsIgnoreCase ("Interim Payment decision"))
		{
			// Step 1: Search Claim in insurer application to which MOJ Claim is associated
			home.clickOnDesktop ();
			seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
			navigationpanel.expandClaimsSpan ();
			TransactionTimer.start (stopwatch);
			navigationpanel.clickMOJClaims ();
			TransactionTimer.stop (stopwatch, "MOJ Claims", driver, strEnvironmentName);

			// Refresh / Pull CR changes
			seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
			mojclaims.clickRefreshData (strEnvironmentName);

			// Open COM / 1insurer Claim
			seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
			home.typeQuickSearch (strInsurerClaimNumber);
			home.clickQuickSearch ();

			// Step 2: Access BI Frame from Features tab
			seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
			claimsummary.selectBodilyInjuryFeature ();
			TransactionTimer.start (stopwatch);
			claimsummary.openFeature ();
			TransactionTimer.stop (stopwatch, "BI Feature", driver, strEnvironmentName);

			// Step 3: Click on “MOJ Actions” link from BI navigational panel
			seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
			TransactionTimer.start (stopwatch);
			navigationpanel.clickMOJActions ();
			TransactionTimer.stop (stopwatch, "MOJ Actions", driver, strEnvironmentName);

			// Expected results / Validation
			// Interim settlement tab should be displayed
			seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
			if (mojactions.validateInterimSettlement () == true)
			{
				seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
				mojactions.clickSettlementTab ();
				seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
				System.out.println ("Interim settlement tab is :" + "displaying");

			}
			else
			{
				throw new TestCaseValidationFailed ();
			}

			// Signing out
			seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
			TransactionTimer.start (stopwatch);
			home.clickSignOut ();
			TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
			clearCookies (strBrowser);
			SeleniumPageCoverage.printPageCoverage ();

		}
	}
}
