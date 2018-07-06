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
import com.innovation.pages.client.pages.ClientSummary;
import com.innovation.pages.common.pages.ActionsPanel;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.pages.policy.pages.PolicyBillingDetails;
import com.innovation.pages.policy.pages.PolicyClientSearch;
import com.innovation.pages.policy.pages.PolicyConfirmRequisition;
import com.innovation.pages.policy.pages.PolicyCoverages;
import com.innovation.pages.policy.pages.PolicyDirectBillingView;
import com.innovation.pages.policy.pages.PolicyEndorsements;
import com.innovation.pages.policy.pages.PolicyExtractCheques;
import com.innovation.pages.policy.pages.PolicyInitiateRequisition;
import com.innovation.pages.policy.pages.PolicyInterestedParty;
import com.innovation.pages.policy.pages.PolicyLosses;
import com.innovation.pages.policy.pages.PolicyPreliminaryQuestions;
import com.innovation.pages.policy.pages.PolicyPropertyHub;
import com.innovation.pages.policy.pages.PolicyRequisitionDetails;
import com.innovation.pages.policy.pages.PolicyRequisitionList;
import com.innovation.pages.policy.pages.PolicyResidentialDetails;
import com.innovation.pages.policy.pages.PolicyStartDetails;
import com.innovation.pages.policy.pages.PolicySummary;

/**
 * @author M.Tahir- Regression test script covering Straight New Business Process
 *
 */

public class TEST_HomeownersStraightNewBusiness extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany", "strClientState", "strSubCompany", "strState",
			"strHomeLob", "strHomeRiskType" })
	@Test
	public void HomeownersStraightNewBusiness (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue, @Optional("8880") String strCompany,
			@Optional("GB") String strClientState, @Optional("880") String strSubCompany, @Optional("United Kingdom") String strState,
			@Optional("Homeowners - UK Property") String strHomeLob, @Optional("Homeowners") String strHomeRiskType) throws Exception
	{

		// Variables used as parameters in scenario
		String strRegion = strRegionValue;
		String strSelectBrand = strEnvironmentBrand;
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";
		String strLoginElement = "user";
		String strLoginNodeUsername = "username";
		String strLoginNodePassword = "password";
		String strLoginXMLFileName = "UserName.xml";
		String strReceipt = "cash";
		String strRequisitionType = "Direct bill";
		String strRequisitionReason = "Premium refund";
		String strDisbursementMethod = "Automatic Cheque";
		String ddlReqListReqType = "Direct bill";
		String ddlReqListSearchBy = "Requisition number";
		String strBillPlan = "Annual Card";
		String strAPChkPrntBnkAcct = "UK region bank account-12345678";
		String strAPChkPrntStBrnch = "Premier Processing Branch";

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
		PolicyInterestedParty interestedparty = new PolicyInterestedParty (driver);
		PolicyLosses policylosses = new PolicyLosses (driver);
		PolicyCoverages policycoverages = new PolicyCoverages (driver);
		PolicyEndorsements policyendorsements = new PolicyEndorsements (driver);
		PolicySummary policysummary = new PolicySummary (driver);
		PolicyBillingDetails billingdetails = new PolicyBillingDetails (driver);
		PolicyDirectBillingView directbillingview = new PolicyDirectBillingView (driver);
		PolicyInitiateRequisition initiaterequisition = new PolicyInitiateRequisition (driver);
		PolicyRequisitionDetails requisitiondetails = new PolicyRequisitionDetails (driver);
		PolicyConfirmRequisition confirmrequisition = new PolicyConfirmRequisition (driver);
		PolicyRequisitionList requisitionlist = new PolicyRequisitionList (driver);
		PolicyExtractCheques extractcheques = new PolicyExtractCheques (driver);
		ClientSummary clientsummary = new ClientSummary (driver);
		ControlPanel control = new ControlPanel (driver);
		NavigationPanel navigationpanel = new NavigationPanel (driver);
		StopWatch stopwatch = new StopWatch ();

		// Login Page
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		login.getUsersFromDatabase (strEnvironmentName);
		login.typeUserNamePassword (strLoginElement, strLoginNodeUsername, strLoginNodePassword, strLoginXMLFileName, strEnvironmentName);

		// Login Timing
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		login.clickLoginButton ();
		TransactionTimer.stop (stopwatch, "Login", driver, strEnvironmentName);

		// Check Previous Session Work items

		previoussessionworkitems.clickRestoreAllAndApply ();

		// // Change Brand
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.clickChangeBrand ();
		brandscheme.selectBrand (strSelectBrand);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.saveBrand ();

		// Enter Search
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		home.clickOnSearch ();
		home.clickOnPolicyClientSearch ();
		TransactionTimer.stop (stopwatch, "Policy Client Search", driver, strEnvironmentName);

		// Policy Client Search
		policyclientsearch.searchExistingClients (strEnvironmentName, strCompany, strClientState);

		// Actions Panel
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		actionspanel.clickAddPolicy ();
		TransactionTimer.stop (stopwatch, "Policy Start Details", driver, strEnvironmentName);

		// Policy Start Details
		// policystartdetails.selectRegion (strRegion);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policystartdetails.selectRegion (strState);
		policystartdetails.selectLOB (strHomeLob);
		policystartdetails.typeAgent (strEnvironmentName, strCompany, strClientState, strSubCompany);
		TransactionTimer.start (stopwatch);
		TransactionTimer.stop (stopwatch, "Preliminary Questions", driver, strEnvironmentName);

		// Preliminary Questions
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policypreliminaryquestions.selectHomePreliminaryQuestions (strRegionValue);
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
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

		// Policy Interested Party
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		interestedparty.proceedNext ();
		TransactionTimer.stop (stopwatch, "Policy Losses", driver, strEnvironmentName);
		// Policy Losses

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policylosses.clickProceedNext ();
		TransactionTimer.stop (stopwatch, "Policy Coverages", driver, strEnvironmentName);

		// Policy Coverage's
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policycoverages.selectCoverages (strRegion);
		policycoverages.clickCalculateButton ();
		policycoverages.checkPremium ();
		TransactionTimer.start (stopwatch);
		policycoverages.clickProceedNext ();
		TransactionTimer.stop (stopwatch, "Policy Endorsements", driver, strEnvironmentName);

		// Policy Endorsements
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policyendorsements.selectEndorsementsRow ();
		TransactionTimer.start (stopwatch);
		policyendorsements.proceedContinue ();
		TransactionTimer.stop (stopwatch, "Policy Summary", driver, strEnvironmentName);

		// Policy Summary
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policysummary.selectBillPlan (strBillPlan);
		policysummary.clickSelectButton ();
		policysummary.checkQutoePolicyNo ();
		String strPolicyNumber = control.getQuotePolicyNumber ();
		TransactionTimer.start (stopwatch);
		policysummary.proceedContinue ();
		TransactionTimer.stop (stopwatch, "Billing Details", driver, strEnvironmentName);

		// Billing Details
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);

		billingdetails.makeOverPamentforRefund (strReceipt);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		control.clickNext ();

		// Billing Details Complete Transaction

		TransactionTimer.stop (stopwatch, "Commit Transaction", driver, strEnvironmentName);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		billingdetails.completeTransaction ();

		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());

		clientsummary.searchIncompleteTrancation (strPolicyNumber, strEnvironmentName);
		TransactionTimer.stop (stopwatch, "Policy Summary", driver, strEnvironmentName);

		navigationpanel.expandViewPolicy (strRegionValue);
		navigationpanel.clickDirectBilling ();
		Double dblfinalValue = directbillingview.VerifyCarryForwardAmount ();

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickOnDesktop ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		navigationpanel.expandBillingSpan ();

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		navigationpanel.clickAccountsPayable ();
		TransactionTimer.stop (stopwatch, "Initiate requisition", driver, strEnvironmentName);

		initiaterequisition.selectReqHeaderReqType (strRequisitionType);
		initiaterequisition.typeReqHeaderPolNum (strPolicyNumber);
		initiaterequisition.clickGo ();
		initiaterequisition.selectAPRRInPaymentOf (strRequisitionReason);
		initiaterequisition.selectAPRRDisbMetd (strDisbursementMethod);

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		initiaterequisition.clickContinue ();
		TransactionTimer.stop (stopwatch, "Requisition Detail", driver, strEnvironmentName);

		requisitiondetails.typeRefundAmount (dblfinalValue);

		TransactionTimer.start (stopwatch);
		initiaterequisition.clickContinue ();
		TransactionTimer.stop (stopwatch, "Requisition Detail", driver, strEnvironmentName);

		String strRequisitionNumber = confirmrequisition.VerifyAPRequisitionNumber ();
		control.clickFinishTransaction ();

		TransactionTimer.start (stopwatch);
		navigationpanel.clickRequisitionList ();
		TransactionTimer.stop (stopwatch, "Requisition List", driver, strEnvironmentName);

		requisitionlist.selectReqListReqType (ddlReqListReqType);
		requisitionlist.selectReqListProcBranch ("8880-Premier Processing Branch");
		requisitionlist.selectReqListSearchBy (ddlReqListSearchBy);
		requisitionlist.setSearchByValue (strRequisitionNumber);
		requisitionlist.clickSearchButton ();
		requisitionlist.selectRequisitionRecord (strRequisitionNumber);
		requisitionlist.clickAuthorize ();

		TransactionTimer.start (stopwatch);
		navigationpanel.clickExtractCheques ();
		TransactionTimer.stop (stopwatch, "Extracts Cheques", driver, strEnvironmentName);

		extractcheques.selectAPChkPrntBnkAcct (strAPChkPrntBnkAcct);
		extractcheques.selectAPChkPrntStBrnch (strAPChkPrntStBrnch);

		extractcheques.clickProcess ();

		control.clickOKConfirm ();

		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}

}
