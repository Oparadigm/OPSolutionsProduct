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
import com.innovation.pages.claim.pages.ClaimAddParty;
import com.innovation.pages.claim.pages.ClaimClaimSummary;
import com.innovation.pages.claim.pages.ClaimClaimantDetails;
import com.innovation.pages.claim.pages.ClaimIncidentDetails;
import com.innovation.pages.claim.pages.ClaimInitialDetails;
import com.innovation.pages.claim.pages.ClaimItemManagementDetails;
import com.innovation.pages.claim.pages.ClaimLogPaymentAddress;
import com.innovation.pages.claim.pages.ClaimLogPaymentAnalysis;
import com.innovation.pages.claim.pages.ClaimLogPaymentClaimPayment;
import com.innovation.pages.claim.pages.ClaimLogPaymentParty;
import com.innovation.pages.claim.pages.ClaimLogPaymentPayee;
import com.innovation.pages.claim.pages.ClaimLogPaymentSummary;
import com.innovation.pages.claim.pages.ClaimMainSearch;
import com.innovation.pages.claim.pages.ClaimPartyHub;
import com.innovation.pages.claim.pages.ClaimPolicyDetails;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
//import com.innovation.regression.Hooks;


public class TEST_AddWithPolicyHomeownerClaimWithTP extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void addWithPolicyHomeownerClaimWithTP (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
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
		String strLOB = "Add property claim";
		String strDuplicateClaimAction = "Add";
		String strClaimType = "Damage to premises liability";
		String strCCTVAvailable = "Yes";
		String strValue = "Home";
		String strPartiesInvolved = "Yes";
		String strWitnesses = "Yes";
		String strAdditionalDetails = "Claim arising out of use of any motor vehicle";
		String strNumberOfChildren = "2";
		String strAccompaniedByAdult = "No";
		String strPropertyOwner = "Friend";
		String strPropertyMaintenance = "Never";
		String strMaintainedBy = "Unknown";
		String strAnimalType = "Snake";
		String strAnimalOwner = "Relative";
		String strDamagePreviously = "Yes";
		String strVicioustemperament = "Unknown";
		String strIncidentCondition = "Icy";
		String strHazardSign = "No";
		String strPartyIndicator = "Third party";
		String strSubRole = "Third party property owner";
		String strVATRegisteredStatus = "Yes";
		String strPropertyDamageStatus = "Yes";
		String strCoverage = "Property owner's liability";
		String strItemType = "Liabilities";
		String strItem = "Property damage";
		String strAmountClaimed = "2000";
		String strFullfilmentRoute = "Cash settle";
		String strEmailClaimSummary = "No";
		String strSIUReferralOverrideReason = "SIU Closed - Proceed with claim";
		String strSIUClosureReason = "Closed - Proceed with the claim";
		String strReserveType = "Loss - Payment";
		String strPaymentCode = "Random";
		String strPaymentAmount = "Random";
		String strPaymentType = "Partial";
		String strPayee = "Third party property owner";
		String strParty = "Third party property owner";
		String strPaymentMethod = "Cheque";

		// Setup
		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
		HomeScreen home = new HomeScreen (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
		NavigationPanel navigationPanel = new NavigationPanel (driver);
		ClaimInitialDetails claiminitialdetails = new ClaimInitialDetails (driver);
		ClaimPolicyDetails claimpolicydetails = new ClaimPolicyDetails (driver);
		ClaimIncidentDetails claimincidentdetails = new ClaimIncidentDetails (driver);
		ClaimPartyHub claimpartyhub = new ClaimPartyHub (driver);
		ClaimAddParty claimaddparty = new ClaimAddParty (driver);
		ClaimClaimantDetails claimclaimantdetails = new ClaimClaimantDetails (driver);
		ClaimItemManagementDetails claimitemmanagmentdetails = new ClaimItemManagementDetails (driver);
		ClaimClaimSummary claimsummary = new ClaimClaimSummary (driver);
		ClaimLogPaymentParty claimLogPaymentParty = new ClaimLogPaymentParty (driver);
		ClaimLogPaymentAnalysis claimLogPaymentAnalysis = new ClaimLogPaymentAnalysis (driver);
		ClaimLogPaymentPayee claimLogPaymentPayee = new ClaimLogPaymentPayee (driver);
		ClaimLogPaymentAddress claimLogPaymentAddress = new ClaimLogPaymentAddress (driver);
		ClaimLogPaymentClaimPayment claimLogPaymentClaimPayment = new ClaimLogPaymentClaimPayment (driver);
		ClaimLogPaymentSummary claimLogPaymentSummary = new ClaimLogPaymentSummary (driver);
		StopWatch stopwatch = new StopWatch ();
		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
		ClaimMainSearch claimmainsearch = new ClaimMainSearch (driver);

		// Login Page
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
		TransactionTimer.stop (stopwatch, "Personal Inbox", driver, strEnvironmentName);

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

		// Search the Policy number and add Home owner claim
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimmainsearch.selectSearchBy (strSearchBy);
		claimmainsearch.fetchHomePolicyBldgAndContCovers (strEnvironmentName, strCompany);
		claimmainsearch.selectDPACheckStatus (strDPACheckStatus);
		claimmainsearch.selectAction (strLOB);
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
		claimpolicydetails.clickEventManagementNo ();
		TransactionTimer.stop (stopwatch, "Incident Details", driver, strEnvironmentName);

		// Enter Claim Incident Details
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimincidentdetails.selectCCTV (strCCTVAvailable);
		claimincidentdetails.typeCCTVDetails ();
		claimincidentdetails.selectRiskRecord (strValue);
		claimincidentdetails.typeLastOccupied (strRegion);
		claimincidentdetails.typeLastFurnished (strRegion);
		claimincidentdetails.selectPartiesInvolved (strPartiesInvolved);
		claimincidentdetails.selectWitnesses (strWitnesses);
		claimincidentdetails.selectAdditionalDetails (strAdditionalDetails);
		claimincidentdetails.typeNumberOfChildren (strNumberOfChildren);
		claimincidentdetails.selectAccompaniedByAdult (strAccompaniedByAdult);
		claimincidentdetails.selectPropertyOwner (strPropertyOwner);
		claimincidentdetails.selectPropertyMaintenance (strPropertyMaintenance);
		claimincidentdetails.selectMaintainedBy (strMaintainedBy);
		claimincidentdetails.selectAnimalType (strAnimalType);
		claimincidentdetails.typeBreed ();
		claimincidentdetails.selectAnimalOwner (strAnimalOwner);
		claimincidentdetails.selectDamagePreviously (strDamagePreviously);
		claimincidentdetails.selectViciousTemperament (strVicioustemperament);
		claimincidentdetails.typeSlipIncident ();
		claimincidentdetails.selectIncidentCondition (strIncidentCondition);
		claimincidentdetails.selectHazardSign (strHazardSign);
		claimincidentdetails.typeIncidentNotification (strRegion);
		claimincidentdetails.clickSave ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Party Hub", driver, strEnvironmentName);

		// Click on Add Party button on Party Hub
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		claimpartyhub.addParty ();
		TransactionTimer.stop (stopwatch, "Add Party", driver, strEnvironmentName);

		// Add a new third party through Add Party frame
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimaddparty.typeFirstNameNew ();
		claimaddparty.typeLastNameNew ();
		claimaddparty.searchPartyByNameAndContact ();
		claimaddparty.selectPartyIndicatorNew (strPartyIndicator);
		claimaddparty.selectTitle ();
		claimaddparty.selectSubRoleNew (strSubRole);
		claimaddparty.addSubRoleNew ();
		TransactionTimer.start (stopwatch);
		claimaddparty.addPartyNew ();
		TransactionTimer.stop (stopwatch, "Claimant Details", driver, strEnvironmentName);

		// Enter Claimant Details
		claimclaimantdetails.selectGender ();
		claimclaimantdetails.selectOccupation ();
		claimclaimantdetails.selectPreferredLanguage ();
		claimclaimantdetails.selectBestContactMethod ();
		claimclaimantdetails.selectBestContactTime ();
		claimclaimantdetails.addAddress (strRegion);
		claimclaimantdetails.typeComments ();
		claimclaimantdetails.selectVATRegistered (strVATRegisteredStatus);
		// Enter data on Claim tab
		claimclaimantdetails.selectClaimTab ();
		claimclaimantdetails.selectPropertyDamage (strPropertyDamageStatus);
		TransactionTimer.start (stopwatch);
		controlpanel.clickSave ();
		TransactionTimer.stop (stopwatch, "Party Hub", driver, strEnvironmentName);

		// Navigate forward from Party Hub screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Item Management", driver, strEnvironmentName);

		// Enter Item Management
		// Adding item against Property owner's liability coverage
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimitemmanagmentdetails.selectCoverage (strCoverage);
		claimitemmanagmentdetails.selectItemType (strItemType);
		claimitemmanagmentdetails.selectItem (strItem);
		// Third party is selected from Owned by dropdown using getPartyName() method
		claimitemmanagmentdetails.selectOwnedByForTPCover (claimaddparty.getPartyName ());
		claimitemmanagmentdetails.typeAmountClaimed (strAmountClaimed);
		claimitemmanagmentdetails.selectFullfilmentRoute (strFullfilmentRoute);
		claimitemmanagmentdetails.clickSave ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Claim Summary", driver, strEnvironmentName);

		// Enter Claim Summary
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimsummary.selectEmailClaimSummary (strEmailClaimSummary);

		String strClaimNumber = claimsummary.getClaimNumber ();
		System.out.println ("Home Claim = " + strClaimNumber);
		TransactionTimer.start (stopwatch);
		claimsummary.clickFlowCompleted ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Enter Claim Search
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickOnSearch ();
		home.clickOnClaimSearch ();
		TransactionTimer.stop (stopwatch, "Claim Search", driver, strEnvironmentName);

		claimmainsearch.selectSearchBy ("Reference number");
		claimmainsearch.SelectClaim ();
		claimmainsearch.typeClaimNumber (strClaimNumber);
		claimmainsearch.clickOnSearch ();
		claimmainsearch.selectClaimRow ();
		TransactionTimer.start (stopwatch);
		claimmainsearch.clickOnOpen ();
		TransactionTimer.stop (stopwatch, "Claim Summary - BO", driver, strEnvironmentName);

		// Resolve Coverage issues if any
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimsummary.checkAndResolveCoverageIssues ();

		// Close SIU feature if it exists on the claim
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimsummary.checkAndCloseSIUFeature (strSIUReferralOverrideReason, strSIUClosureReason);

		// click on log payment accordion
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		navigationPanel.clickBOFinancialsSpan ();
		TransactionTimer.start (stopwatch);
		navigationPanel.clickLogPayment ();
		TransactionTimer.stop (stopwatch, "Log payment - Party", driver, strEnvironmentName);

		// Payment Log party frame
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		// Third party is passed as party for payment
		claimLogPaymentParty.selectPaymentParty (claimaddparty.getPartyName ());
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Analysis", driver, strEnvironmentName);

		// Payment log analysis screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimLogPaymentAnalysis.selectRisk ();
		claimLogPaymentAnalysis.selectCoverageFeature ();
		claimLogPaymentAnalysis.selectReserveType (strReserveType);
		claimLogPaymentAnalysis.selectPaymentCode (strPaymentCode);
		claimLogPaymentAnalysis.typePaymentAmount (strPaymentAmount);
		claimLogPaymentAnalysis.typeExcessAmount ();
		claimLogPaymentAnalysis.selectPaymentType (strPaymentType);
		claimLogPaymentAnalysis.clickAddPayment ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Payee", driver, strEnvironmentName);

		// Payment log Payee screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimLogPaymentPayee.selectPayee (strPayee);
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Address", driver, strEnvironmentName);

		// Payment log Address Screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimLogPaymentAddress.selectPartyForAddress (strParty);
		claimLogPaymentAddress.selectPartyAddress ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Claim Payment", driver, strEnvironmentName);

		// Payment log Claim payment screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimLogPaymentClaimPayment.selectPaymentMethod (strPaymentMethod);
		claimLogPaymentClaimPayment.selectDeliveryMethod ();
		claimLogPaymentClaimPayment.typeAccountNo ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Summary", driver, strEnvironmentName);

		// Payment log Payment Summary screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		claimLogPaymentSummary.clickFlowCompleted ();
		TransactionTimer.stop (stopwatch, "Financial summary", driver, strEnvironmentName);

		// Signing out
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}
}
