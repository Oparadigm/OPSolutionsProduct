package com.innovation.regression.base.feature.regression.sprint35;

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
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.regression.base.feature.regression.common.InsurerClaimActionsForMOJ;
import com.innovation.soap.connection.MOJConstants;
import com.innovation.soap.regression.moj.MOJMethods;

/**
 * @author haiderm - Sprint 35 - Regression Test AT-219035: To verify that if counter offer message is successful, relevant tasks
 *         should be created and completed accordingly
 * 
 * @Pre-req CNF should be in Stage2SettlementPackDecision
 * 
 * @ExpectedResults Stage 2.2 Settlement pack received task should be automatically completed
 * 
 *                  a new task, Awaiting Claimant Representative response” should be generated with due date 3 weeks, 4 weeks
 *                  deadline
 * 
 */
public class TEST_AT219035_Stage2SettlementPackCounterOfferDecisionRelevantTasks extends DriverManager
{
	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void testForAT219035 (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
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
		String strActivityEngineGuid = MOJConstants.MOJ_ACTIVITYENGINEGUID;
		String strUpdatedActivityEngineGuid;
		String strIsInterimPaymentNeededValue = "0";
		String strCRUDeductions = "0";
		String strGrossValueAgreed = "No";
		double dblDifferenceOfOfferedAndClaimed = 50;
		String strContributoryDeductions = "1";
		String strSettlementPackDecision = "Counter offer";
		String strInterimPaymentAmounts = "0";
		String strClaimStatusNew = "Stage 2 settlement pack counter offer decision";
		String strDaysRemainingInCurrentPhase = "3";
		String strCurrentDate;
		String strTaskDueDate;
		int intDueDateDays = 15; // 3 weeks
		int intDeadlineDateDays = 5; // 4 weeks
		String strNewTaskDescription = "Awaiting claimant representative response";

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
		ClaimMOJSummary mojsummary = new ClaimMOJSummary (driver);
		NavigationPanel navigationpanel = new NavigationPanel (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
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
		strUpdatedActivityEngineGuid = mojmethods.getMOJClaimStatus (strMOJClaimNumber, strActivityEngineGuid);

		// Acknowledge Liability is admitted - CR service action
		strUpdatedActivityEngineGuid = mojmethods.acknowledgeLiabilityAdmitted (strMOJClaimNumber, strUpdatedActivityEngineGuid);

		// Set Interim Payment Not Needed - CR service action
		mojmethods.setInterimPaymentNeeded (strMOJClaimNumber, strUpdatedActivityEngineGuid, strIsInterimPaymentNeededValue);

		// Get MOJ Claim Status - CR service action
		strUpdatedActivityEngineGuid = mojmethods.getMOJClaimStatus (strMOJClaimNumber, strActivityEngineGuid);

		// Add Stage 2 Sender Policy Framework (SPF) - CR service action
		mojmethods.addStage2SPFRequest (strMOJClaimNumber, strUpdatedActivityEngineGuid);

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

		// Click on Stage 2 settlement tab
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		mojactions.clickSettlementTab ();

		// Counter offer Stage 2 Settlement pack
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		mojactions.typeCRUReferenceNumberStage2Settlement ();
		mojactions.selectSettlementPackDecision (strSettlementPackDecision);
		mojactions.typeCRUDeductionsStage2Settlement (strCRUDeductions);
		mojactions.typeInterimPaymentAmounts (strInterimPaymentAmounts);
		mojactions.processIncompleteStage2LossRequests (strCRUDeductions, strGrossValueAgreed, dblDifferenceOfOfferedAndClaimed, strContributoryDeductions);
		mojactions.clickSendDecisionStage2Settlement ();
		controlpanel.clickYes ();

		// Validate Claim's status and Days remaining in current phase after countering offer Stage 2 Settlement pack
		mojactions.validateClaimStatusNew (strClaimStatusNew);
		mojactions.validateDaysRemainingInCurrentPhaseNew (strDaysRemainingInCurrentPhase);

		// Navigate onto MOJ summary frame
		TransactionTimer.start (stopwatch);
		navigationpanel.clickMOJSummary ();
		TransactionTimer.stop (stopwatch, "MOJ Summary", driver, strEnvironmentName);

		// Check "Awaiting claimant representative response" task is generated in To Do List
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		mojsummary.validateTaskGeneration (strNewTaskDescription);

		// Check Due date, Deadline date and Details for "Awaiting claimant representative response" task
		mojsummary.selectToDoTask (strNewTaskDescription);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strCurrentDate = CalenderDate.returnCurrentDate (strRegionValue);
		strTaskDueDate = mojsummary.returnTaskDueDate ();
		mojsummary.validateTaskDueDate (strEnvironmentName, strCompany, strRegionValue, strCurrentDate, intDueDateDays);
		mojsummary.validateTaskDeadlineDate (strEnvironmentName, strCompany, strRegionValue, strTaskDueDate, intDeadlineDateDays);

		// Signing out
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}
}
