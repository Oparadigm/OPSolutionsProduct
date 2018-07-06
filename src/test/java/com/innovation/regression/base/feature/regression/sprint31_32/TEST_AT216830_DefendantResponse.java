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
 * @author haiderm - Sprint 31 - Regression Test AT-216830: To Verify the successful defendant response addition against the
 *         selected loss on interim settlement tab when Gross not agreed
 * @Pre-req MOJ Claim status should be in “Interim payment decision” status Net value claimed and Gross value offered are any
 *          different/same values with % Contributory deductions as 0.
 * 
 * @ExpectedResults System should make the 'Comments' text area as mandatory. System should show missing mandatory error message
 *                  against Comments field. Defendant response should be saved success fully showing complete indicator as tick mark
 *
 */
public class TEST_AT216830_DefendantResponse extends DriverManager
{
	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void testForAT216830 (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
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
		String strMOJClaimNumber;
		String strInsurerClaimNumber;
		String strMOJClaimStatus;
		String strActivityEngineGuid = MOJConstants.MOJ_ACTIVITYENGINEGUID;
		String strUpdatedActivityEngineGuid;
		String strLatestActivityEngineGuid;
		String strCRUDeductions = "0";
		String strIsInterimPaymentNeededValue = "1";
		String strGrossValueAgreed = "No";
		String strValueOffered = "0";
		String strExpectedWarningMessages = "Please ensure that all required fields have been entered correctly." + '\n' + '\n' +
			"CRU Deductions - is mandatory ; it must match the required format" + '\n' + "Gross value agreed - is mandatory" + '\n' +
			"Gross value offered £ - is mandatory ; it must match the required format";

		String strDefendantCommentsWarningMessage = "Please ensure that all required fields have been entered correctly." + '\n' + '\n' +
			"Comments - is mandatory";

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
		strMOJClaimStatus = mojmethods.addInterimSPFRequest (strMOJClaimNumber, strLatestActivityEngineGuid);

		// Verify the Pre-Req is met, only then perform main regression steps

		if (strMOJClaimStatus.equalsIgnoreCase ("Interim Payment decision"))
		{
			// Step 1: Search Claim in insurer application to which MOJ Claim is
			// associated
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

			// Step 4: Click on Interim settlement tab
			seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
			mojactions.clickSettlementTab ();
			seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());

			// Expected results - Database Validation, Frontend UI Validation,
			// Backend
			// Validation
			// Step 5: Validate mandatory fields warning messages appear
			mojactions.clickIncompleteInterimLossRequest ();
			mojactions.clickLossSave ();
			if (mojactions.validateErrorStrings (strExpectedWarningMessages) == true)
			{

				System.out.println ("Please ensure that all required fields have been entered correctly.");
				System.out.println ("CRU Deductions - is mandatory ; it must match the required format");
				System.out.println ("Gross value agreed - is mandatory");
				System.out.println ("Gross value offered £ - is mandatory ; it must match the required format");
			}
			else
			{
				throw new TestCaseValidationFailed ();
			}

			// Step 6: Enter mandatory information
			seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
			mojactions.typeCRUReferenceNumber ();

			seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
			mojactions.typeCRUReferenceNumber ();

			mojactions.typeCRUDeductions (strCRUDeductions);
			mojactions.selectGrossValueAgreed (strGrossValueAgreed);
			mojactions.typeGrossValueOffered (strValueOffered);
			mojactions.clickLossSave ();

			// Step 7: System should show missing mandatory error message
			// against Comments field.
			if (mojactions.validateErrorStrings (strDefendantCommentsWarningMessage) == true)
			{
				System.out.println ("Please ensure that all required fields have been entered correctly.");
				System.out.println ("Comments - is mandatory");

			}
			else
			{
				throw new TestCaseValidationFailed ();
			}

			// Step 8: User enter comments in the comments text area and clicks
			// to save.
			mojactions.typeDefendantComments ();
			mojactions.clickLossSave ();

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
