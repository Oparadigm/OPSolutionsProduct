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
import com.innovation.pages.claim.pages.ClaimAddEmergencyServices;
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
import com.innovation.pages.claim.pages.ClaimPartyHub;
import com.innovation.pages.claim.pages.ClaimPolicyDetails;
import com.innovation.pages.claim.pages.ClaimSupplierSearch;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;

/**
 * @author alamq. Regression test script covering UK Add With-Policy Homeowner Fire Claim
 * @author alamq - Added payment flow to complete the flow Rizwan - Enhanced test script as per feedback from Claims BA
 */

public class TEST_AddWithPolicyHomeownerFireClaim extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void addWithPolicyHomeownerFireClaim (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
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
		String strClaimType = "Fire";
		String strCCTVAvailable = "Yes";
		String strDamageContained = "Yes";
		String strVacantProperty = "No";
		String strPropertySecure = "Yes";
		String strPropertySafe = "Yes";
		String strOrganisedRepaired = "No";
		String strAlreadyRepaired = "No";
		String strReportedToFire = "Yes";
		String strReportedToPoliceFire = "Yes";
		String strCausedByThirdParty = "No";
		String strValue = "Home";
		String strOrigin = "Attic";
		String strAvailabelRooms = "Attic";
		String strPropertOccupiedFire = "Yes";
		String strElectricalWorkDone = "Yes";
		String strServicesAvailable = "Yes";
		String strPropertyUninhabitable = "Yes";
		String strAssistanceRequired = "Yes";
		String strAssociPartyTypePolice = "Police";
		String strAssociPartyTypeFire = "Fire services";
		String strCoverage = "Buildings";
		String strItemType = "Random";
		String strPartOfSet = "Yes";
		String strItemAge = "Unknown";
		String strItemLocation = "Unknown";
		String strNumberOfRooms = "Unknown";
		String strPriority = "High";
		String strItemUsed = "Private";
		String strItemServiced = "No";
		String strUnderWarranty = "Yes";
		String strAmountClaimed = "200";
		String strAmountSource = "Other";
		String strFullfilmentRoute = "Supplier replace";
		String strEmailClaimSummary = "No";
		String strSIUReferralOverrideReason = "SIU Closed - Proceed with claim";
		String strSIUClosureReason = "Closed - Proceed with the claim";
		String strPaymentParty = "Random";
		String strReserveType = "Loss - Payment";
		String strPaymentCode = "Random";
		String strPaymentAmount = "1100";
		String strPaymentType = "Partial";
		String strPayee = "Claimant";
		String strParty = "Claimant";
		String strPaymentMethod = "Cheque";

		// Setup
		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		HomeScreen home = new HomeScreen (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
		NavigationPanel navigationpanel = new NavigationPanel (driver);
		ClaimInitialDetails claiminitialdetails = new ClaimInitialDetails (driver);
		ClaimPolicyDetails claimpolicydetails = new ClaimPolicyDetails (driver);
		ClaimIncidentDetails claimincidentdetails = new ClaimIncidentDetails (driver);
		ClaimPartyHub claimpartyhub = new ClaimPartyHub (driver);
		ClaimAddEmergencyServices addemergencyservices = new ClaimAddEmergencyServices (driver);
		ClaimSupplierSearch claimsuppliersearch = new ClaimSupplierSearch (driver);
		ClaimItemManagementDetails itemmanagmentdetails = new ClaimItemManagementDetails (driver);
		ClaimClaimSummary claimsummary = new ClaimClaimSummary (driver);
		ClaimLogPaymentParty logpaymentparty = new ClaimLogPaymentParty (driver);
		ClaimLogPaymentAnalysis logpaymentanalysis = new ClaimLogPaymentAnalysis (driver);
		ClaimLogPaymentPayee logpaymentpayee = new ClaimLogPaymentPayee (driver);
		ClaimLogPaymentAddress logpaymentaddress = new ClaimLogPaymentAddress (driver);
		ClaimLogPaymentClaimPayment logpaymentclaimpayment = new ClaimLogPaymentClaimPayment (driver);
		ClaimLogPaymentSummary logpaymentsummary = new ClaimLogPaymentSummary (driver);
		StopWatch stopwatch = new StopWatch ();
		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
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
		claimincidentdetails.typeNotificationDate (strRegion);
		claimincidentdetails.typeIncidentNotificationTime (claiminitialdetails.getIncidentTime ());
		claimincidentdetails.typeHowIncidentNotice ();
		claimincidentdetails.typeMitigationAction ();
		claimincidentdetails.selectDamageContained (strDamageContained);
		claimincidentdetails.selectVacantProperty (strVacantProperty);
		claimincidentdetails.selectPropertySecure (strPropertySecure);
		claimincidentdetails.selectPropertySafe (strPropertySafe);
		claimincidentdetails.selectAlreadyRepaired (strAlreadyRepaired);
		claimincidentdetails.selectOrganisedRepaired (strOrganisedRepaired);
		claimincidentdetails.selectReportedToFire (strReportedToFire);
		claimincidentdetails.selectReportedToPoliceFire (strReportedToPoliceFire);
		claimincidentdetails.typeDateReportedFire (strRegion);
		claimincidentdetails.typePoliceReportNumberFire ();
		claimincidentdetails.selectCausedByThirdParty (strCausedByThirdParty);
		// Enter Risk information
		claimincidentdetails.selectRiskRecord (strValue);
		claimincidentdetails.selectOriginFire (strOrigin);
		claimincidentdetails.selectAvailabelRooms (strAvailabelRooms);
		claimincidentdetails.clickSelectRoom ();
		claimincidentdetails.selectPropertyOccupiedFire (strPropertOccupiedFire);
		claimincidentdetails.typePropertyOccupiedFire ();
		claimincidentdetails.typePersonDiscoveredDamageFire ();
		claimincidentdetails.typePersonAccessedPropertyFire ();
		claimincidentdetails.selectElectricalWorkDone (strElectricalWorkDone);
		claimincidentdetails.typeElectricalWorkDetailsFire ();
		claimincidentdetails.selectServicesAvailable (strServicesAvailable);
		claimincidentdetails.selectAssistanceRequired (strAssistanceRequired);
		claimincidentdetails.selectPropertyUninhabitable (strPropertyUninhabitable);
		claimincidentdetails.typePropertyDetails ();
		claimincidentdetails.clickSave ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Party Hub", driver, strEnvironmentName);

		// Add Emergency Services Police

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		claimpartyhub.addEmergencyService ();
		TransactionTimer.stop (stopwatch, "Add Party", driver, strEnvironmentName);

		addemergencyservices.clickSupplierSearch ();

		claimsuppliersearch.selectType (strAssociPartyTypePolice);
		claimsuppliersearch.selectSearchType ("Open");
		TransactionTimer.start (stopwatch);
		claimsuppliersearch.clickSearchSupplier ();
		TransactionTimer.stop (stopwatch, "Associated parties search results load time", driver, strEnvironmentName);
		claimsuppliersearch.selectSupplier ();
		claimsuppliersearch.clickAssociateSupplier ();
		claimsuppliersearch.navigateBackSupplierSearch ();

		TransactionTimer.start (stopwatch);
		controlpanel.clickSave ();
		TransactionTimer.stop (stopwatch, "Party Hub", driver, strEnvironmentName);

		// Add Emergency Services fire services

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		claimpartyhub.addEmergencyService ();
		TransactionTimer.stop (stopwatch, "Add Party", driver, strEnvironmentName);

		addemergencyservices.clickSupplierSearch ();

		claimsuppliersearch.selectType (strAssociPartyTypeFire);
		claimsuppliersearch.selectSearchType ("Open");
		TransactionTimer.start (stopwatch);
		claimsuppliersearch.clickSearchSupplier ();
		TransactionTimer.stop (stopwatch, "Associated parties search results load time", driver, strEnvironmentName);
		claimsuppliersearch.selectSupplier ();
		claimsuppliersearch.clickAssociateSupplier ();
		claimsuppliersearch.navigateBackSupplierSearch ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickSave ();
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
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
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

		// click on log payment according
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		navigationpanel.clickBOFinancialsSpan ();
		TransactionTimer.start (stopwatch);
		navigationpanel.clickLogPayment ();
		TransactionTimer.stop (stopwatch, "Log payment - Party", driver, strEnvironmentName);

		// Payment Log party frame
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentparty.selectPaymentParty (strPaymentParty);
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Analysis", driver, strEnvironmentName);

		// Payment log analysis screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentanalysis.selectRisk ();
		logpaymentanalysis.selectCoverageFeature ();
		logpaymentanalysis.selectReserveType (strReserveType);
		logpaymentanalysis.selectPaymentCode (strPaymentCode);
		logpaymentanalysis.typePaymentAmount (strPaymentAmount);
		logpaymentanalysis.typeExcessAmount ();
		logpaymentanalysis.selectPaymentType (strPaymentType);
		logpaymentanalysis.clickAddPayment ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Payee", driver, strEnvironmentName);

		// Payment log Payee screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentpayee.selectPayee (strPayee);
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Address", driver, strEnvironmentName);

		// Payment log Address Screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentaddress.selectPartyForAddress (strParty);
		logpaymentaddress.selectPartyAddress ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Claim Payment", driver, strEnvironmentName);

		// Payment log Claim payment screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentclaimpayment.selectPaymentMethod (strPaymentMethod);
		logpaymentclaimpayment.selectDeliveryMethod ();
		logpaymentclaimpayment.typeAccountNo ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Summary", driver, strEnvironmentName);

		// Payment log Payment Summary screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		logpaymentsummary.clickFlowCompleted ();
		TransactionTimer.stop (stopwatch, "Financial Summary", driver, strEnvironmentName);

		// Signing out
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}
}
