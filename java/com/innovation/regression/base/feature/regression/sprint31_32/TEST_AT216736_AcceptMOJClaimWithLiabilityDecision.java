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
import com.innovation.pages.claim.pages.ClaimMOJActions;
import com.innovation.pages.claim.pages.ClaimMOJSummary;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.regression.base.feature.regression.common.InsurerClaimActionsForMOJ;
import com.innovation.soap.regression.moj.MOJMethods;

/**
 * @author Rizwan. Regression test script covers accepting MOJ claim and taking article 75 and liability decisions. It validates
 *         calim's status, days remaining in current phase, state of buttons on the frame, tasks generated, tasks completed and
 *         audits generated each time after claim is accepted, after article 75 decision is taken and then after liability decision
 *         is taken.
 *
 */

public class TEST_AT216736_AcceptMOJClaimWithLiabilityDecision extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void acceptMOJClaimWithLiabilityDecision (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
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
		String strClaimStatusNew;
		String strDaysRemainingInCurrentPhase;
		String strNewTaskGenerated;
		String strTaskCompleted;
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

		// Navigate onto MOJ actions frame
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		navigationpanel.clickBodilyInjurySpan ();
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		navigationpanel.clickMOJActions ();
		TransactionTimer.stop (stopwatch, "MOJ actions", driver, strEnvironmentName);

		// Perform validation after Accepting MOJ claim

		// Check claim current status to be "Article 75 decision"
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strClaimStatusNew = "Article 75 decision";
		mojactions.validateClaimStatusNew (strClaimStatusNew);

		// Check days remaining in "Article 75 decision" phase
		strDaysRemainingInCurrentPhase = "2";
		mojactions.validateDaysRemainingInCurrentPhaseNew (strDaysRemainingInCurrentPhase);

		// Check Article 75 decision button is enabled
		mojactions.validateArticle75DecisionButtonEnabled ();

		// Perform validation on MOJ Summary frame

		// Navigate onto MOJ summary frame
		TransactionTimer.start (stopwatch);
		navigationpanel.clickMOJSummary ();
		TransactionTimer.stop (stopwatch, "MOJ Summary", driver, strEnvironmentName);

		// Check "Article 75 decision required" task is generated in To Do List
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strNewTaskGenerated = "Article 75 decision required";
		mojsummary.validateTaskGeneration (strNewTaskGenerated);

		// Check audit record "Claim accepted" is generated in Audit records
		// list
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strAuditGenerated = "Claim accepted";
		mojsummary.validateAuditGeneration (strAuditGenerated);

		// Contract Bodily injury span so that it could be expanded in next
		// steps in the function
		navigationpanel.clickBodilyInjurySpan ();

		// Apply Article75
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		insurerclaimactions.applyArticle75 (strEnvironmentName);

		// Perform validations after applying Article 75 decision

		// Check claim current status to be "Liability decision"
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strClaimStatusNew = "Liability decision";
		mojactions.validateClaimStatusNew (strClaimStatusNew);

		// Check days remaining in current phase
		strDaysRemainingInCurrentPhase = "3";
		mojactions.validateDaysRemainingInCurrentPhaseNew (strDaysRemainingInCurrentPhase);

		// Check Liability decision button is enabled
		mojactions.validateLiabilityDecisionButtonEnabled ();

		// Perform validation on MOJ Summary frame

		// Navigate onto MOJ summary frame
		TransactionTimer.start (stopwatch);
		navigationpanel.clickMOJSummary ();
		TransactionTimer.stop (stopwatch, "MOJ Summary", driver, strEnvironmentName);

		// Check "Liability decision" task is generated in To Do List
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strNewTaskGenerated = "Liability decision";
		mojsummary.validateTaskGeneration (strNewTaskGenerated);

		// Check "Article 75 decision required" task is completed in Completed
		// activities List
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strTaskCompleted = "Article 75 decision required";
		mojsummary.validateTaskCompleted (strTaskCompleted);

		// Check audit record "Article 75 decision sent – Article 75 does apply"
		// is generated in Audit records list
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strAuditGenerated = "Article 75 decision sent – Article 75 does apply";
		mojsummary.validateAuditGeneration (strAuditGenerated);

		// Navigate onto MOJ actions frame for Liability decision below
		TransactionTimer.start (stopwatch);
		navigationpanel.clickMOJActions ();
		TransactionTimer.stop (stopwatch, "MOJ Actions", driver, strEnvironmentName);

		// Take Liability Decision
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		insurerclaimactions.takeLiabilityDecision ();

		// Perform validation after applying Liability decision

		// Check claim current status to be "Liability admitted"
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strClaimStatusNew = "Liability admitted";
		mojactions.validateClaimStatusNew (strClaimStatusNew);

		// Check days remaining in current phase
		strDaysRemainingInCurrentPhase = "";
		mojactions.validateDaysRemainingInCurrentPhaseNew (strDaysRemainingInCurrentPhase);

		// Perform validation on MOJ Summary frame

		// Navigate onto MOJ summary frame
		TransactionTimer.start (stopwatch);
		navigationpanel.clickMOJSummary ();
		TransactionTimer.stop (stopwatch, "MOJ Summary", driver, strEnvironmentName);

		// Check "Awaiting Claimant Representative response" task is generated
		// in To Do List
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strNewTaskGenerated = "Awaiting claimant representative response";
		mojsummary.validateTaskGeneration (strNewTaskGenerated);

		// Check "Article 75 decision required" task is completed in Completed
		// activities List
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strTaskCompleted = "Article 75 decision required";
		mojsummary.validateTaskCompleted (strTaskCompleted);

		// Check audit record "Liability decision sent - Admitted" is generated
		// in Audit records list
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		strAuditGenerated = "Liability decision sent - Admitted";
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
