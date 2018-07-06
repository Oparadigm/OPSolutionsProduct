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
import com.innovation.pages.claim.pages.ClaimMOJSummary;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.regression.base.feature.regression.common.InsurerClaimActionsForMOJ;
import com.innovation.soap.connection.MOJConstants;
import com.innovation.soap.regression.moj.MOJMethods;

/**
 * @author Rizwan - Sprint 32 - Regression Test AT-217499: To verify the audit generated upon successful MOJ Exit Process of CNF
 *         with status InterimPaymentDecision
 * @PreReq MOJ Claim status should be in “Interim payment decision”
 * 
 * @ExpectedResults An MOJ audit should be generated that CNF has exited process and detailing the reason for exit selected.
 */
public class TEST_AT217499_ExitProcess_AuditGenerated extends DriverManager
{
	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void testAT217499ExitProcessAuditGenerated (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue, @Optional("8880") String strCompany)
			throws Exception
	{
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";
		String strLoginElement = "user";
		String strLoginNodeUsername = "username";
		String strLoginNodePassword = "password";
		String strLoginXMLFileName = "UserName.xml";
		String strMOJClaimNumber;
		String strInsurerClaimNumber;
		String strActivityEngineGuid = MOJConstants.MOJ_ACTIVITYENGINEGUID;
		String strIsInterimPaymentNeededValue = "1";
		String strUpdatedActivityEngineGuid;
		String strLatestActivityEngineGuid;
		String strDaysRemainingInCurrentPhase;
		String strReasonToExit;
		String strAuditGenerated;

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
		ClaimMOJSummary mojsummary = new ClaimMOJSummary (driver);
		ClaimMOJActions mojactions = new ClaimMOJActions (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
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
		brandscheme.selectBrand (strEnvironmentBrand);
		TransactionTimer.start (stopwatch);
		brandscheme.saveBrand ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Generate MOJ Claim Number via SOAP Service
		MOJMethods mojmethods = new MOJMethods ();
		strMOJClaimNumber = mojmethods.getMOJClaimNumber ();

		// Create 1insurer Claim Number to associate MOJ Claim with
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strInsurerClaimNumber = insurerclaimactions.createMotorClaimWithTPBI (strEnvironmentName, strCompany, strRegionValue);

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
		mojmethods.addInterimSPFRequest (strMOJClaimNumber, strLatestActivityEngineGuid);

		// Search Claim in insurer application to which MOJ Claim is associated
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

		// Access BI Frame from Features tab
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimsummary.selectBodilyInjuryFeature ();
		TransactionTimer.start (stopwatch);
		claimsummary.openFeature ();
		TransactionTimer.stop (stopwatch, "BI Feature", driver, strEnvironmentName);

		// Click on “MOJ Actions” link from BI navigational panel
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		navigationpanel.clickMOJActions ();
		TransactionTimer.stop (stopwatch, "MOJ Actions", driver, strEnvironmentName);

		// Verify the Pre-Req is met, only then perform main regression steps
		String strClaimStatusNew = "Interim Payment decision";
		mojactions.validateClaimStatusNew (strClaimStatusNew);

		// Click Exit process button
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		mojactions.clickExitProcess ();

		// Enter mandatory information
		mojactions.selectReasonToExit ();
		strReasonToExit = mojactions.returnReasonToExit ();
		mojactions.typeExitComments ();
		mojactions.clickSaveExitProcess ();

		// Popup will appear with <cancel> and <Confirm> buttons
		// Step 6: Click OK
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		controlpanel.clickOKConfirm ();

		// Perform validation on Interim settlement frame

		// Check claim current status
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strClaimStatusNew = "Exit process";
		mojactions.validateClaimStatusNew (strClaimStatusNew);

		// Check days remaining in current phase
		strDaysRemainingInCurrentPhase = "";
		mojactions.validateDaysRemainingInCurrentPhaseNew (strDaysRemainingInCurrentPhase);
		// Perform validation on MOJ summary frame

		// Navigate onto MOJ summary frame
		TransactionTimer.start (stopwatch);
		navigationpanel.clickMOJSummary ();
		TransactionTimer.stop (stopwatch, "MOJ Summary", driver, strEnvironmentName);

		// Check audit record "The claim has exited from the MOJ process due to
		// reason....." is generated in Audit records list
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strAuditGenerated = "The claim has exited from the MOJ process due to reason - " + strReasonToExit;
		mojsummary.validateAuditGeneration (strAuditGenerated);

		// Signing out
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		SeleniumPageCoverage.printPageCoverage ();

	}
}
