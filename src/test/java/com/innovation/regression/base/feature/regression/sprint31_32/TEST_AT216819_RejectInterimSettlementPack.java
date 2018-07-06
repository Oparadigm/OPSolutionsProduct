package com.innovation.regression.base.feature.regression.sprint31_32;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innovation.configuration.DriverManager;
import com.innovation.misc.CalenderDate;
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
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.regression.base.feature.regression.common.InsurerClaimActionsForMOJ;
import com.innovation.soap.connection.MOJConstants;
import com.innovation.soap.regression.moj.MOJMethods;

/**
 * @author Rizwan. Regression test script covers rejection of interim settlement pack on MOJ claim. It validates calim's status and
 *         state of 'Reject request' button before rejecting interim settlement pack. After rejecting Interim settlement pack, it
 *         validates claim's current status, days remaining in current phase, outcome, date of outcome, tasks generated, tasks
 *         completed and audits generated.
 *
 */

public class TEST_AT216819_RejectInterimSettlementPack extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void rejectInterimSettlementPack (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue, @Optional("8880") String strCompany)
			throws Exception
	{

		// Following variables are used as parameters in the test script
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";
		String strLoginElement = "user";
		String strLoginNodeUsername = "username";
		String strLoginNodePassword = "password";
		String strLoginXMLFileName = "UserName.xml";
		String strActivityEngineGuid = MOJConstants.MOJ_ACTIVITYENGINEGUID;
		String strIsInterimPaymentNeededValue = "1";
		String strClaimStatusNew;
		String strNewTaskGenerated;
		String strTaskCompleted;
		String strCurrentDate;
		String strTaskDueDate;
		String strAuditGenerated;

		// Setup
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
		ClaimMOJSummary mojsummary = new ClaimMOJSummary (driver);
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
		String strMOJClaimNumber = mojmethods.getMOJClaimNumber ();

		// Create 1insurer Claim Number to associate MOJ Claim with
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		String strInsurerClaimNumber = insurerclaimactions.createMotorClaimWithTPBI (strEnvironmentName, strCompany, strRegionValue);

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
		String strUpdatedActivityEngineGuid = mojmethods.acknowledgeLiabilityAdmitted (strMOJClaimNumber, strActivityEngineGuid);

		// Set Interim Payment Needed - CR service action
		String strLatestActivityEngineGuid = mojmethods.setInterimPaymentNeeded (strMOJClaimNumber, strUpdatedActivityEngineGuid,
				strIsInterimPaymentNeededValue);

		// Add Interim Sender Policy Framework (SPF) - CR service action
		mojmethods.addInterimSPFRequest (strMOJClaimNumber, strLatestActivityEngineGuid);

		// Search Claim in insurer application to which MOJ Claim is
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

		// Click on Interim settlement tab
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		mojactions.clickSettlementTab ();

		// Verify the Pre-Req is met, only then perform main regression steps
		strClaimStatusNew = "Interim Payment decision";
		mojactions.validateClaimStatusNew (strClaimStatusNew);

		// Check Reject request button is enabled
		mojactions.validateRejectRequestButtonEnabled ();

		// Click on Reject request button
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		mojactions.clickRejectRequest ();
		mojactions.typeRejectionComments ();
		mojactions.clickSaveRejectRequest ();
		mojactions.clickConfirm ();

		// Perform validation on Interim settlement frame

		// Check claim current status to be "Interim settlement pack rejected"
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strClaimStatusNew = "Interim settlement pack rejected";
		mojactions.validateClaimStatusNew (strClaimStatusNew);

		// Check days remaining in current phase
		String strDaysRemainingInCurrentPhase = "";
		mojactions.validateDaysRemainingInCurrentPhaseNew (strDaysRemainingInCurrentPhase);

		// Check Outcome after Reject request
		String strOutcome = "Rejected";
		mojactions.validateOutcome (strOutcome);

		// Check Date of outcome
		// String strDateOfOutcome = CalenderDate.returnCurrentDate (strRegionValue);
		// mojactions.validateDateOfOutcome (strDateOfOutcome);

		// Perform validation on MOJ Summary frame

		// Navigate onto MOJ summary frame
		TransactionTimer.start (stopwatch);
		navigationpanel.clickMOJSummary ();
		TransactionTimer.stop (stopwatch, "MOJ Summary", driver, strEnvironmentName);

		// Check "Awaiting Claimant Representative response" task is
		// generated in To Do List
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strNewTaskGenerated = "Awaiting claimant representative response";
		mojsummary.validateTaskGeneration (strNewTaskGenerated);

		// Check Due date and Deadline date for "Awaiting claimant representative
		// response" task
		mojsummary.selectToDoTask (strNewTaskGenerated);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strCurrentDate = CalenderDate.returnCurrentDate (strRegionValue);
		strTaskDueDate = mojsummary.returnTaskDueDate ();
		int intDueDateDays = 15;
		int intDeadlineDateDays = 5;
		mojsummary.validateTaskDueDate (strEnvironmentName, strCompany, strRegionValue, strCurrentDate, intDueDateDays);
		mojsummary.validateTaskDeadlineDate (strEnvironmentName, strCompany, strRegionValue, strTaskDueDate, intDeadlineDateDays);

		// Check "Interim settlement pack review" task is completed in
		// Completed activities List
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strTaskCompleted = "Interim settlement pack review";
		mojsummary.validateTaskCompleted (strTaskCompleted);

		// Check audit record "Interim settlement pack review" is generated
		// in Audit records list
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strAuditGenerated = "Interim settlement pack review";
		mojsummary.validateAuditGeneration (strAuditGenerated);

		// Check audit record "Interim settlement request 1 rejected" is
		// generated in Audit records list
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strAuditGenerated = "Interim settlement request 1 rejected";
		mojsummary.validateAuditGeneration (strAuditGenerated);

		// Signing out
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();
	}
}
