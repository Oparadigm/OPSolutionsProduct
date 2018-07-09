package com.innovation.regression.base.policy.regression;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import com.innovation.pages.client.pages.ClientSummary;
import com.innovation.pages.common.pages.ActionsPanel;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.pages.policy.pages.PolicyBillingDetails;
import com.innovation.pages.policy.pages.PolicyBillingMaintainNextActivity;
import com.innovation.pages.policy.pages.PolicyClientSearch;
import com.innovation.pages.policy.pages.PolicyCoverages;
import com.innovation.pages.policy.pages.PolicyInterestedParty;
import com.innovation.pages.policy.pages.PolicyLosses;
import com.innovation.pages.policy.pages.PolicyPreliminaryQuestions;
import com.innovation.pages.policy.pages.PolicyPropertyHub;
import com.innovation.pages.policy.pages.PolicyResidentialDetails;
import com.innovation.pages.policy.pages.PolicyStartDetails;
import com.innovation.pages.policy.pages.PolicySummary;



public class TEST_HomeownersCreateQuoteAndBuyQuote extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany", "strClientState", "strSubCompany", "strState",
			"strHomeLob", "strHomeRiskType" })

	@Test
	public void HomeownersCreateQuoteAndBuyQuote (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue, @Optional("8880") String strCompany,
			@Optional("GB") String strClientState, @Optional("880") String strSubCompany, @Optional("United Kingdom") String strState,
			@Optional("Homeowners - UK Property") String strHomeLob, @Optional("Homeowners") String strHomeRiskType) throws Exception
	{

		// Variables used as parameters in scenario
		String strSelectBrand = strEnvironmentBrand;
		String strRegion = strRegionValue;
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";
		String strLoginElement = "user";
		String strLoginNodeUsername = "username";
		String strLoginNodePassword = "password";
		String strLoginXMLFileName = "UserName.xml";
		String strBillPlan = "Annual Card";
		String strReceiptType = "Cash";

		// Setup
		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		HomeScreen home = new HomeScreen (driver);
		PolicyClientSearch policyclientsearch = new PolicyClientSearch (driver);
		ActionsPanel actionspanel = new ActionsPanel (driver);
		PolicyStartDetails policystartdetails = new PolicyStartDetails (driver);
		PolicyPreliminaryQuestions policypreliminaryquestions = new PolicyPreliminaryQuestions (driver);
		PolicyPropertyHub policypropertyHub = new PolicyPropertyHub (driver);
		PolicyResidentialDetails policyresidentialdetails = new PolicyResidentialDetails (driver);
		PolicyLosses policylosses = new PolicyLosses (driver);
		PolicyCoverages policycoverages = new PolicyCoverages (driver);
		ActionsPanel actionsPanel = new ActionsPanel (driver);
		PolicySummary policysummary = new PolicySummary (driver);
		ClientSummary clientsummary = new ClientSummary (driver);
		PolicyBillingDetails billingdetails = new PolicyBillingDetails (driver);
		PolicyBillingMaintainNextActivity billingactivities = new PolicyBillingMaintainNextActivity (driver);
		ControlPanel control = new ControlPanel (driver);
		NavigationPanel navigate = new NavigationPanel (driver);
		StopWatch stopwatch = new StopWatch ();

		// Login Page
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		login.getUsersFromDatabase (strEnvironmentName);
		login.typeUserNamePassword (strLoginElement, strLoginNodeUsername, strLoginNodePassword, strLoginXMLFileName, strEnvironmentName);

		// Login Timing
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		login.clickLoginButton ();
		TransactionTimer.stop (stopwatch, "Restore/clear", driver, strEnvironmentName);

		// Check Previous Session Work items
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		previoussessionworkitems.clickRestoreAllAndApply ();
		TransactionTimer.stop (stopwatch, "Change brand", driver, strEnvironmentName);

		// // Change Brand
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.clickChangeBrand ();
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.selectBrand (strSelectBrand);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		brandscheme.saveBrand ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Enter Search

		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		home.clickOnSearch ();
		home.clickOnPolicyClientSearch ();
		TransactionTimer.stop (stopwatch, "Policy Client Search", driver, strEnvironmentName);

		// Policy Client Search
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policyclientsearch.searchExistingClients (strEnvironmentName, strCompany, strClientState);
		TransactionTimer.stop (stopwatch, "Policy Client Search", driver, strEnvironmentName);
		// Actions Panel

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		actionspanel.clickAddQuote ();
		TransactionTimer.stop (stopwatch, "Policy Start Details", driver, strEnvironmentName);

		// Policy Start Details

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policystartdetails.selectRegion (strState);
		policystartdetails.selectLOB (strHomeLob);
		TransactionTimer.start (stopwatch);
		policystartdetails.typeAgent (strEnvironmentName, strCompany, strClientState, strSubCompany);
		TransactionTimer.stop (stopwatch, "Preliminary Questions", driver, strEnvironmentName);

		// Preliminary Questions
		// Ever been declared bankrupt
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		policypreliminaryquestions.selectHomePreliminaryQuestions (strRegion);
		TransactionTimer.start (stopwatch);
		policypreliminaryquestions.clickProceedButton ();
		TransactionTimer.stop (stopwatch, "Policy Property Hub", driver, strEnvironmentName);

		// Policy Property Hub
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policypropertyHub.selectRiskType (strHomeRiskType);
		policypropertyHub.selectUseExistingAddress ();
		TransactionTimer.start (stopwatch);
		policypropertyHub.clickAddButton ();
		TransactionTimer.stop (stopwatch, "Policy residential Details", driver, strEnvironmentName);

		// Policy Residential Details
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policyresidentialdetails.selectRiskDetails (strRegionValue);

		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policyresidentialdetails.clickProceedNext ();
		TransactionTimer.stop (stopwatch, "Policy Property Hub", driver, strEnvironmentName);

		// Policy Property Hub

		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policypropertyHub.clickProceedNext ();
		TransactionTimer.stop (stopwatch, "Policy Interested Party", driver, strEnvironmentName);

		// Policy Losses
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policylosses.selectRiskRow (strHomeRiskType);
		policylosses.clickRiskAddLoss ();
		policylosses.selectLossDescription ();
		policylosses.typeLossAmount ();
		policylosses.typeLossDate (strRegion);
		policylosses.clickDetailsAddLoss ();
		TransactionTimer.start (stopwatch);
		control.clickNext ();
		TransactionTimer.stop (stopwatch, "Policy Coverages", driver, strEnvironmentName);

		// Policy Coverage's
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policycoverages.selectCoverages (strRegion);
		policycoverages.clickCalculateButton ();
		policycoverages.checkPremium ();
		TransactionTimer.start (stopwatch);
		policycoverages.clickProceedNext ();
		TransactionTimer.stop (stopwatch, "Quote Summary", driver, strEnvironmentName);

		// Policy Summary
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policysummary.selectBillPlan (strBillPlan);
		policysummary.clickSelectButton ();
		policysummary.checkQutoePolicyNo ();
		TransactionTimer.start (stopwatch);
		actionsPanel.clickBuy ();
		TransactionTimer.stop (stopwatch, "Policy Summary", driver, strEnvironmentName);

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		actionspanel.clickUpdatePolicy (strRegion);
		TransactionTimer.stop (stopwatch, "Property Hub", driver, strEnvironmentName);

		// Edit Property Details

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policypropertyHub.selecExistingProperty (strHomeRiskType);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		policypropertyHub.clickEditDetails ();
		TransactionTimer.stop (stopwatch, "Residential Details", driver, strEnvironmentName);

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policyresidentialdetails.UpdateResidentialDetails (strRegion);
		TransactionTimer.start (stopwatch);
		control.clickNext ();
		TransactionTimer.stop (stopwatch, "Property Hub", driver, strEnvironmentName);

		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		control.clickNext ();
		TransactionTimer.stop (stopwatch, "Interested Party Details", driver, strEnvironmentName);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		PolicyInterestedParty policyInterestedParty = new PolicyInterestedParty (driver);
		policyInterestedParty.selectIPRow (strHomeRiskType);
		policyInterestedParty.AddInterestedParty ("abc", strEnvironmentName, strCompany, strClientState);
		TransactionTimer.start (stopwatch);
		control.clickNext ();

		// Losses Frame
		TransactionTimer.stop (stopwatch, "Losses Details", driver, strEnvironmentName);
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		control.clickNext ();

		// Coverages Frame
		TransactionTimer.stop (stopwatch, "Coverages", driver, strEnvironmentName);
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policycoverages.UpdateHomeCoverage (strRegion);
		policycoverages.clickCalculateButton ();
		control.clickNext ();

		// Endorsements Frame
		TransactionTimer.stop (stopwatch, "Endorsement", driver, strEnvironmentName);
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		control.clickNext ();

		TransactionTimer.stop (stopwatch, "Policy Summary", driver, strEnvironmentName);
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		String strPolicyNumber = control.getQuotePolicyNumber ();
		control.clickNext ();

		TransactionTimer.stop (stopwatch, "Billing Details", driver, strEnvironmentName);
		TransactionTimer.start (stopwatch);

		// Billing Details

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());

		TransactionTimer.start (stopwatch);
		billingdetails.selectProceedWithoutPayment ();
		control.clickNext ();
		TransactionTimer.stop (stopwatch, "Client Summary", driver, strEnvironmentName);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		clientsummary.searchIncompleteTrancation (strPolicyNumber, strEnvironmentName);
		TransactionTimer.stop (stopwatch, "Policy Summary", driver, strEnvironmentName);

		// From here the flow will enter into the Policy View > Direct Billing

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		navigate.expandViewPolicy (strRegionValue);
		navigate.clickDirectBillingForPolicy ();
		navigate.expandDirectBillingActions ();
		navigate.clickMaintainNextActivity ();
		TransactionTimer.stop (stopwatch, "Maintain next activity", driver, strEnvironmentName);

		// We apply billing next activity here on Maintain Next Activity Frame
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		billingactivities.applyBillingNextActivitiesUK (strRegionValue, strBillPlan, strReceiptType);
		TransactionTimer.stop (stopwatch, "Make a payment", driver, strEnvironmentName);
		control.clickFinishTransaction ();

		// Sign out application
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}

}
