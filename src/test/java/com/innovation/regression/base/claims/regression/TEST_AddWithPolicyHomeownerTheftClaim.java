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
import com.innovation.pages.claim.pages.ClaimClaimSummary;
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
import com.innovation.pages.claim.pages.ClaimPolicyDetails;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;


public class TEST_AddWithPolicyHomeownerTheftClaim extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void addWithPolicyHomeownerTheftClaim (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
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
		String strClaimType = "Theft or attempted theft";
		String strDamageContained = "Yes";
		String strVacantProperty = "Yes";
		String strCCTVAvailable = "Yes";
		String strReportedToFireDeptStorm = "No";
		String strReportedToPoliceStorm = "Yes";
		String strPropertySecure = "Yes";
		String strPropertySafe = "Yes";
		String strAlreadyRepaired = "Yes";
		String strOrganisedRepaired = "Yes";
		String strCausedByThirdParty = "No";
		String strRiskTypeValue = "Home";
		String strPropertyOccupiedFire = "Yes";
		String strUnauthorisedOccupants = "No";
		String strAvailabelRooms = "Main house";
		String strSecuritySystem = "Yes";
		String strServicesAvailable = "Yes";
		String strPropertyUninhabitable = "No";
		String strAssistanceRequired = "No";
		String strCoverage = "Contents";
		String strItemType = "Random";
		String strItem = "Random";
		String strPartOfSet = "No";
		String strItemAge = "Unknown";
		String strItemLocation = "Main house";
		String strNumberOfRooms = "None";
		String strPriority = "High";
		String strItemUsed = "Private";
		String strItemServiced = "No";
		String strUnderWarranty = "Yes";
		String strAmountClaimed = "2000";
		String strAmountSource = "Original receipt";
		String strFullfilmentRoute = "Cash settle";
		String strEmailClaimSummary = "No";
		String strSIUReferralOverrideReason = "SIU Closed - Proceed with claim";
		String strSIUClosureReason = "Closed - Proceed with the claim";
		String strPaymentParty = "Random";
		String strReserveType = "Loss - Payment";
		String strPaymentCode = "Random";
		String strPaymentAmount = "1200";
		String strPaymentType = "Partial";
		String strPayee = "Claimant";
		String strRowText = "Claimant";
		String strPaymentMethod = "Cheque";

		// Setup
		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		HomeScreen home = new HomeScreen (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
		NavigationPanel navigationpanel = new NavigationPanel (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
		ClaimMainSearch claimmainsearch = new ClaimMainSearch (driver);
		ClaimInitialDetails claiminitialdetails = new ClaimInitialDetails (driver);
		ClaimPolicyDetails claimpolicydetails = new ClaimPolicyDetails (driver);
		ClaimIncidentDetails claimincidentdetails = new ClaimIncidentDetails (driver);
		ClaimItemManagementDetails itemmanagmentdetails = new ClaimItemManagementDetails (driver);
		ClaimClaimSummary claimsummary = new ClaimClaimSummary (driver);
		ClaimLogPaymentAnalysis logpaymentanalysis = new ClaimLogPaymentAnalysis (driver);
		ClaimLogPaymentPayee logpaymentpayee = new ClaimLogPaymentPayee (driver);
		ClaimLogPaymentAddress logpaymentaddress = new ClaimLogPaymentAddress (driver);
		ClaimLogPaymentClaimPayment logpaymentclaimpayment = new ClaimLogPaymentClaimPayment (driver);
		ClaimLogPaymentSummary logpaymentsummary = new ClaimLogPaymentSummary (driver);
		ClaimLogPaymentParty logpaymentparty = new ClaimLogPaymentParty (driver);
		StopWatch stopwatch = new StopWatch ();
		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);

		// Login Page
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		login.typeUserNamePassword (strLoginElement, strLoginNodeUsername, strLoginNodePassword, strLoginXMLFileName, strEnvironmentName);

		// Login Timing
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		login.clickLoginButton ();
		TransactionTimer.stop (stopwatch, "Login", driver, strEnvironmentName);

		// Check Previous Session Work Items
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
		home.clickOnSearch ();
		home.clickOnClaimSearch ();
		TransactionTimer.stop (stopwatch, "Claim Search", driver, strEnvironmentName);

		// Search the latest homeowner policy from the database and initiate
		// property claim against it
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
		// Enter Sub Section Claim details
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimincidentdetails.typeNotificationDate (strRegion);
		claimincidentdetails.typeIncidentNotificationTime (claiminitialdetails.getIncidentTime ());
		claimincidentdetails.typeHowIncidentNotice ();
		claimincidentdetails.selectDamageContained (strDamageContained);
		claimincidentdetails.selectVacantProperty (strVacantProperty);
		claimincidentdetails.typeVacantLength ();
		claimincidentdetails.selectCCTV (strCCTVAvailable);
		claimincidentdetails.typeCCTVDetails ();
		claimincidentdetails.selectReportedToFireDeptStorm (strReportedToFireDeptStorm);
		claimincidentdetails.selectReportedToPoliceStorm (strReportedToPoliceStorm);
		claimincidentdetails.typeDateReportedStorm (strRegion);
		claimincidentdetails.typePoliceReportNoStorm ();
		claimincidentdetails.typeMitigationAction ();
		claimincidentdetails.selectPropertySecure (strPropertySecure);
		claimincidentdetails.selectPropertySafe (strPropertySafe);
		claimincidentdetails.selectAlreadyRepaired (strAlreadyRepaired);
		claimincidentdetails.typeSupplierDetails ();
		claimincidentdetails.typeRepairAmount ();
		claimincidentdetails.selectOrganisedRepaired (strOrganisedRepaired);
		claimincidentdetails.typeSupplierOrganisedDetails ();
		claimincidentdetails.selectCausedByThirdParty (strCausedByThirdParty);
		// Enter Risk information
		claimincidentdetails.selectRiskRecord (strRiskTypeValue);
		claimincidentdetails.selectPropertyOccupiedFire (strPropertyOccupiedFire);
		claimincidentdetails.typePropertyOccupiedFire ();
		claimincidentdetails.typePersonDiscoveredDamageFire ();
		claimincidentdetails.typePersonAccessedPropertyFire ();
		claimincidentdetails.selectUnauthorisedOccupantsTheft (strUnauthorisedOccupants);
		claimincidentdetails.selectAvailabelRooms (strAvailabelRooms);
		claimincidentdetails.clickSelectRoom ();
		claimincidentdetails.selectPointOfEntryTheft ();
		claimincidentdetails.selectPointOfExitTheft ();
		claimincidentdetails.selectEntryMethodTheft ();
		claimincidentdetails.selectSecuritySystemTheft (strSecuritySystem);
		claimincidentdetails.typeLastActivatedDateTheft (strRegion);
		claimincidentdetails.typeLastActivatedTimeTheft (claiminitialdetails.getIncidentTime ());
		claimincidentdetails.selectSecuritySystemTypeTheft ();
		claimincidentdetails.selectServicesAvailable (strServicesAvailable);
		claimincidentdetails.selectPropertyUninhabitable (strPropertyUninhabitable);
		claimincidentdetails.selectAssistanceRequired (strAssistanceRequired);
		claimincidentdetails.clickSave ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Party Hub", driver, strEnvironmentName);

		// Navigate forward from Party Hub screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Item Management", driver, strEnvironmentName);

		// Enter Item Management
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		itemmanagmentdetails.selectCoverage (strCoverage);
		itemmanagmentdetails.selectItemType (strItemType);
		itemmanagmentdetails.selectItem (strItem);
		itemmanagmentdetails.typeItemDetails ();
		itemmanagmentdetails.selectPartOfSet (strPartOfSet);
		itemmanagmentdetails.selectItemAge (strItemAge);
		itemmanagmentdetails.selectItemLocation (strItemLocation);
		itemmanagmentdetails.selectNumberOfRoom (strNumberOfRooms);
		itemmanagmentdetails.selectPriority (strPriority);
		itemmanagmentdetails.typeDateLastUsed (strRegion);
		itemmanagmentdetails.selectItemUsed (strItemUsed);
		itemmanagmentdetails.selectItemServiced (strItemServiced);
		itemmanagmentdetails.selectUnderWarranty (strUnderWarranty);
		itemmanagmentdetails.typeAmountClaimed (strAmountClaimed);
		itemmanagmentdetails.selectSourceOfAmount (strAmountSource);
		itemmanagmentdetails.typePurchasePrice ();
		itemmanagmentdetails.typeWherePurchased ();
		itemmanagmentdetails.selectFullfilmentRoute (strFullfilmentRoute);
		itemmanagmentdetails.clickSave ();
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
		claimmainsearch.SelectClient ();
		claimmainsearch.SelectPolicy ();
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
		navigationpanel.clickBOFinancialsSpan ();
		TransactionTimer.start (stopwatch);
		navigationpanel.clickLogPayment ();
		TransactionTimer.stop (stopwatch, "Log payment - Party", driver, strEnvironmentName);

		// Enter details in Party frame of LogPayment process

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentparty.selectPaymentParty (strPaymentParty);
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Analysis", driver, strEnvironmentName);

		// Enter details in Analysis frame of Log Payment process
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentanalysis.selectRisk ();
		logpaymentanalysis.selectCoverageFeature ();
		logpaymentanalysis.selectReserveType (strReserveType);
		logpaymentanalysis.selectPaymentCode (strPaymentCode);
		logpaymentanalysis.getPaymentAmount ();
		logpaymentanalysis.typePaymentAmount (strPaymentAmount);
		logpaymentanalysis.typeExcessAmount ();
		logpaymentanalysis.selectPaymentType (strPaymentType);
		logpaymentanalysis.clickAddPayment ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Payee", driver, strEnvironmentName);

		// Enter details in Payee frame of Log Payment process
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentpayee.selectPayee (strPayee);
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Address", driver, strEnvironmentName);

		// Enter details in Address frame of Log Payment process
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentaddress.selectPartyForAddress (strRowText);
		logpaymentaddress.selectPartyAddress ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Claim Payment", driver, strEnvironmentName);

		// Enter details in Claim payment frame of Log Payment process

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentclaimpayment.selectPaymentMethod (strPaymentMethod);
		logpaymentclaimpayment.selectDeliveryMethod ();
		logpaymentclaimpayment.typeAccountNo ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Summary", driver, strEnvironmentName);

		// Complete the Log Payment process
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		logpaymentsummary.clickFlowCompleted ();
		TransactionTimer.stop (stopwatch, "Financial Summary", driver, strEnvironmentName);

		// Signing out
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}
}
