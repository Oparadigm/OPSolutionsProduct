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
import com.innovation.pages.claim.pages.ClaimEstimateList;
import com.innovation.pages.claim.pages.ClaimEstimateSummary;
import com.innovation.pages.claim.pages.ClaimIncidentDetailsAuto;
import com.innovation.pages.claim.pages.ClaimInitialDetailsAuto;
import com.innovation.pages.claim.pages.ClaimInvoiceDetails;
import com.innovation.pages.claim.pages.ClaimLogPaymentAddress;
import com.innovation.pages.claim.pages.ClaimLogPaymentAnalysis;
import com.innovation.pages.claim.pages.ClaimLogPaymentClaimPayment;
import com.innovation.pages.claim.pages.ClaimLogPaymentPayee;
import com.innovation.pages.claim.pages.ClaimLogPaymentSummary;
import com.innovation.pages.claim.pages.ClaimMainSearch;
import com.innovation.pages.claim.pages.ClaimPartyHub;
import com.innovation.pages.claim.pages.ClaimPolicyDetailsAuto;
import com.innovation.pages.claim.pages.ClaimSupplierSearch;
import com.innovation.pages.claim.pages.ClaimVehicleDetails;
import com.innovation.pages.claim.pages.ClaimVehicleDriver;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;



public class TEST_AddWithPolicyMotorClaimWithTP extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void addWithPolicyMotorClaimWithTP (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue, @Optional("8880") String strCompany)
			throws Exception
	{

		// Following variables are used as parameters in the test script
		String strRegion = strRegionValue;
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";
		String strLoginElement = "user";
		String strLoginNodeUsername = "username";
		String strLoginNodePassword = "password";
		String strLoginXMLFileName = "UserName.xml";
		String strSearchBy = "Reference number";
		String strDPACheckStatus = "Yes";
		String strLOB = "Add motor claim";
		String strDuplicateClaimAction = "Add";
		String strPartyIndicatorNew = "Third party";
		String strSubRoleNew = "Third party vehicle owner";
		String strVehicleDamage = "Yes";
		String strCycle = "Yes";
		String strMotorcycle = "No";
		String strPropertyDamage = "No";
		String strSubro = "Yes";
		String strProHandling = "Yes";
		String strAnimalInjury = "Yes";
		String strPersonalInjury = "Yes";
		String strServicesRejected = "No";
		String strDrivingForEmployer = "Yes";
		String strPermissionGiven = "Yes";
		String strSeatBeltWorn = "Yes";
		String strConvictions = "Yes";
		String strMedicalCondition = "No";
		String strAlcoholDrugInvolved = "Yes";
		String strClaimType = "Accident";
		String strIncidentCause = "Vehicle collision whilst reversing";
		String strEmailClaimSummary = "No";
		String strSIUReferralOverrideReason = "SIU Closed - Proceed with claim";
		String strSIUClosureReason = "Closed - Proceed with the claim";
		String strMIAFTRSearch = "Yes";
		String strVehicleMoving = "Yes";
		String strVehicleDriveable = "Yes";
		String strRepairsComplete = "Yes";
		String strSecure = "Yes";
		String strPermissionToDrive = "Yes";
		String strClaimingForDamage = "Yes";
		String strSettlementRoute = "R";
		String strMechanic = "Yes";
		String strInterior = "No";
		String strICE = "Yes";
		String strUnderBody = "No";
		String strWheel = "Yes";
		String strGlass = "No";
		String strAssociPartyType = "Repairer";
		String strSearchType = "Open";
		String strFurtherDetails = "TP strikes stationary PH";
		String strInsuredDisposition = "Random";
		String strReportedBy = "Policyholder";
		String strFeature = "Insured vehicle damage";
		String strRepairAuthorisatonType = "Approved - standard";
		String strEstimateInitial = "Initial";
		String strEstimateRevised = "Revised";
		String strInvoiceType = "Repair";
		String strSelectBrand = strEnvironmentBrand;
		String strReserveType = "Loss - Payment";
		String strPaymentCode = "Random";
		String strPaymentType = "Final";
		String strRowText = "Third party vehicle owner";
		String strPaymentMethod = "Cheque";
		String strpayeeRowText = "Third party vehicle owner";

		// Setup
		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);
		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		HomeScreen home = new HomeScreen (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
		SeleniumWaiter seleniumWaiter = new SeleniumWaiter (driver);
		ClaimInitialDetailsAuto initialdetailsauto = new ClaimInitialDetailsAuto (driver);
		ClaimPolicyDetailsAuto claimpolicydetailsauto = new ClaimPolicyDetailsAuto (driver);
		ClaimPartyHub claimpartyhub = new ClaimPartyHub (driver);
		ClaimAddParty claimaddparty = new ClaimAddParty (driver);
		ClaimClaimantDetails claimclaimantdetails = new ClaimClaimantDetails (driver);
		ClaimVehicleDriver claimvehicledriver = new ClaimVehicleDriver (driver);
		ClaimClaimSummary claimsummary = new ClaimClaimSummary (driver);
		ClaimVehicleDetails vehicledetails = new ClaimVehicleDetails (driver);
		ClaimIncidentDetailsAuto claimincidentdetails = new ClaimIncidentDetailsAuto (driver);
		NavigationPanel navigationPanel = new NavigationPanel (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
		ClaimEstimateList estimatelist = new ClaimEstimateList (driver);
		ClaimEstimateSummary estimatesummary = new ClaimEstimateSummary (driver);
		ClaimInvoiceDetails claiminvoicedetails = new ClaimInvoiceDetails (driver);
		ClaimSupplierSearch claimsuppliersearch = new ClaimSupplierSearch (driver);
		ClaimMainSearch claimmainsearch = new ClaimMainSearch (driver);
		ClaimLogPaymentAddress logpaymentaddress = new ClaimLogPaymentAddress (driver);
		ClaimLogPaymentAnalysis logpaymentanalysis = new ClaimLogPaymentAnalysis (driver);
		ClaimLogPaymentPayee logpaymentpayee = new ClaimLogPaymentPayee (driver);
		ClaimLogPaymentClaimPayment logpaymentclaimpayment = new ClaimLogPaymentClaimPayment (driver);
		ClaimLogPaymentSummary logpaymentsummary = new ClaimLogPaymentSummary (driver);
		StopWatch stopwatch = new StopWatch ();

		// Login Page
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		login.typeUserNamePassword (strLoginElement, strLoginNodeUsername, strLoginNodePassword, strLoginXMLFileName, strEnvironmentName);

		// Login Timing
		TransactionTimer.start (stopwatch);
		login.clickLoginButton ();
		TransactionTimer.stop (stopwatch, "Login", driver, strEnvironmentName);

		// Check Previous Session Work items
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		previoussessionworkitems.clickRestoreAllAndApply ();
		TransactionTimer.stop (stopwatch, "Claim Search", driver, strEnvironmentName);

		// Change Brand
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.clickChangeBrand ();
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.selectBrand (strSelectBrand);
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		brandscheme.saveBrand ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Enter Claim Search
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickOnSearch ();
		home.clickOnClaimSearch ();
		TransactionTimer.stop (stopwatch, "Claim Search", driver, strEnvironmentName);

		// Search the Policy number and add with policy Auto claim
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimmainsearch.selectSearchBy (strSearchBy);
		claimmainsearch.fetchAutoPolicyWithComprehensiveCover (strEnvironmentName, strCompany);
		claimmainsearch.selectDPACheckStatus (strDPACheckStatus);
		claimmainsearch.selectAction (strLOB);
		claimmainsearch.typeIncidentDate (strRegion);
		TransactionTimer.start (stopwatch);
		claimmainsearch.clickOnGo (strDuplicateClaimAction);
		TransactionTimer.stop (stopwatch, "Initial Details", driver, strEnvironmentName);

		// Enter Details in Incident details frame
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		initialdetailsauto.selectReportedBy (strReportedBy);
		initialdetailsauto.selectBestContactTime ();
		initialdetailsauto.selectClaimType (strClaimType);
		initialdetailsauto.selectIncidentCause (strIncidentCause);
		initialdetailsauto.typeIncidentTime ();
		initialdetailsauto.typeReferenceNumber ();
		initialdetailsauto.typeZIPCode (strRegionValue);
		initialdetailsauto.clickZipCodeSearchIcon ();
		initialdetailsauto.selectAddress ();
		initialdetailsauto.typeLocationDescription ();

		// Click next to the Policy Details frame
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Policy Details", driver, strEnvironmentName);

		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		claimpolicydetailsauto.clickEventManagementNo ();
		TransactionTimer.stop (stopwatch, "Incident Details", driver, strEnvironmentName);

		// Enter Details in Incident Details frame
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimincidentdetails.selectFurtherDetails (strFurtherDetails);
		claimincidentdetails.selectInsuredDisposition (strInsuredDisposition);
		claimincidentdetails.typeIncidentDescription ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Vehicle/Driver Details", driver, strEnvironmentName);

		// Select Vehicle/Driver in Vehicle/Driver frame
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimvehicledriver.selectRandomVehicleRecord ();
		claimvehicledriver.selectRandomDriverRecord ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Vehicle Details", driver, strEnvironmentName);

		// Enter Details in Vehicle Details frame
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		vehicledetails.selectVehicleCategory ();
		vehicledetails.typeCurrentMileage ();
		vehicledetails.typeEngineSize ();
		vehicledetails.typeNoOfDoor ();
		vehicledetails.typeOwner ();
		vehicledetails.selectMIAFTRSearch (strMIAFTRSearch);
		vehicledetails.selectActualUse ();
		vehicledetails.typeNoOfPassenger ();
		vehicledetails.selectVehicleMoving (strVehicleMoving);
		vehicledetails.selectVehicleDriveable (strVehicleDriveable);
		vehicledetails.selectRepairsComplete (strRepairsComplete);
		vehicledetails.selectSecure (strSecure);
		vehicledetails.selectPermissionToDrive (strPermissionToDrive);
		vehicledetails.selectAppraisaltab ();
		vehicledetails.selectSuppliertab ();
		vehicledetails.selectPropertytab ();
		vehicledetails.selectDamagetab ();
		vehicledetails.selectClaimingForDamage (strClaimingForDamage);
		vehicledetails.selectSettlementRoute (strSettlementRoute);
		vehicledetails.clickMinorDamageArrow1 ();
		vehicledetails.clickMajorDamageArrow1 ();
		vehicledetails.selectMechanic (strMechanic);
		vehicledetails.selectInterior (strInterior);
		vehicledetails.selectICE (strICE);
		vehicledetails.selectUnderBody (strUnderBody);
		vehicledetails.selectWheel (strWheel);
		vehicledetails.selectGlass (strGlass);
		vehicledetails.typeComments ();
		vehicledetails.selectVehicletab ();

		// Search Supplier and Associate Supplier with Claim

		vehicledetails.selectSuppliertab ();
		vehicledetails.clickSupplierSearch ();
		claimsuppliersearch.selectType (strAssociPartyType);
		claimsuppliersearch.selectSearchType (strSearchType);
		claimsuppliersearch.clickSearchSupplier ();
		claimsuppliersearch.selectSupplier ();
		claimsuppliersearch.clickInstructSupplier ();
		claimsuppliersearch.navigateBackSupplierSearch ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Party Hub", driver, strEnvironmentName);

		// Click on Add Party button on Party Hub
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		claimpartyhub.addParty ();
		TransactionTimer.stop (stopwatch, "Add Party", driver, strEnvironmentName);

		// Add a new third party through Add Party frame
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimaddparty.typeFirstNameNew ();
		claimaddparty.typeLastNameNew ();
		claimaddparty.searchPartyByNameAndContact ();
		claimaddparty.selectPartyIndicatorNew (strPartyIndicatorNew);
		claimaddparty.selectTitle ();
		claimaddparty.selectSubRoleNew (strSubRoleNew);
		claimaddparty.addSubRoleNew ();
		TransactionTimer.start (stopwatch);
		claimaddparty.addPartyNew ();
		TransactionTimer.stop (stopwatch, "Claimant Details", driver, strEnvironmentName);

		// Enter Claimant Details
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimclaimantdetails.selectGender ();
		claimclaimantdetails.selectOccupation ();
		claimclaimantdetails.selectPreferredLanguage ();
		claimclaimantdetails.selectBestContactMethod ();
		claimclaimantdetails.selectBestContactTime ();
		claimclaimantdetails.addAddress (strRegion);
		claimclaimantdetails.typeComments ();
		claimclaimantdetails.selectClaimTab ();

		claimclaimantdetails.selectVehicleDamage (strVehicleDamage);
		claimclaimantdetails.selectCycle (strCycle);
		claimclaimantdetails.selectMotorcycle (strMotorcycle);
		claimclaimantdetails.selectPropertyDamage (strPropertyDamage);
		claimclaimantdetails.selectSubrogationOpportunity (strSubro);
		claimclaimantdetails.selectProactiveHandling (strProHandling);
		claimclaimantdetails.selectAnimalInjury (strAnimalInjury);
		claimclaimantdetails.selectPersonalInjury (strPersonalInjury);
		claimclaimantdetails.selectServicesRejected (strServicesRejected);
		claimclaimantdetails.selectDrivingForEmployer (strDrivingForEmployer);
		claimclaimantdetails.selectPermissionGiven (strPermissionGiven);
		claimclaimantdetails.selectSeatBeltWorn (strSeatBeltWorn);
		claimclaimantdetails.selectConvictions (strConvictions);
		claimclaimantdetails.selectMedicalCondition (strMedicalCondition);
		claimclaimantdetails.selectAlcoholDrugInvolved (strAlcoholDrugInvolved);

		TransactionTimer.start (stopwatch);
		controlpanel.clickSave ();
		TransactionTimer.stop (stopwatch, "Party Hub", driver, strEnvironmentName);

		// Navigate forward from Party Hub screen
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Claim Summary", driver, strEnvironmentName);

		// Enter Details in Claim Summary frame in FNOL
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimsummary.selectEmailClaimSummary (strEmailClaimSummary);
		String strClaimNumber = claimsummary.getClaimNumber ();
		System.out.println ("Auto Claim = " + strClaimNumber);
		// Complete the FNOL flow
		TransactionTimer.start (stopwatch);
		claimsummary.clickFlowCompleted ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Enter Claim Search
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
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
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimsummary.checkAndResolveCoverageIssues ();

		// Close SIU feature if it exists on the claim
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimsummary.checkAndCloseSIUFeature (strSIUReferralOverrideReason, strSIUClosureReason);
		TransactionTimer.start (stopwatch);
		claimsummary.selectFeature (strFeature);
		TransactionTimer.start (stopwatch);
		claimsummary.openFeature ();
		TransactionTimer.stop (stopwatch, "Insured Vehicle Damage", driver, strEnvironmentName);
		navigationPanel.clickSupplier ();
		claimsuppliersearch.selectSupplierBO ();
		TransactionTimer.start (stopwatch);
		claimsuppliersearch.clickSelectSupplierBO ();
		TransactionTimer.stop (stopwatch, "IVD - Supplier", driver, strEnvironmentName);

		TransactionTimer.start (stopwatch);
		navigationPanel.clickEstimate ();
		TransactionTimer.stop (stopwatch, "Estimate Details", driver, strEnvironmentName);

		estimatelist.clickAddEstimateAuto ();
		estimatesummary.selectSupplierName ();
		estimatesummary.selectEstimatingSystemAuto ();
		estimatesummary.typeMiscellaneousLabourHours ();
		estimatesummary.typeTowing ();
		TransactionTimer.start (stopwatch);
		estimatesummary.clickSaveAuto ();
		TransactionTimer.stop (stopwatch, "Initial Estimate", driver, strEnvironmentName);
		estimatelist.selectEstimatesType (strEstimateInitial);
		estimatesummary.typeReferenceNumber ();
		estimatesummary.typeRepairAuthorisationDate (strRegion);
		estimatesummary.selectRepairAuthorisatonType (strRepairAuthorisatonType);
		TransactionTimer.start (stopwatch);
		estimatesummary.clickSaveAuto ();
		estimatesummary.clickYesPopUp ();

		TransactionTimer.stop (stopwatch, "Revised Estimate", driver, strEnvironmentName);

		estimatelist.selectEstimatesType (strEstimateRevised);
		TransactionTimer.start (stopwatch);
		estimatesummary.clickCreateInvoice ();
		TransactionTimer.stop (stopwatch, "Invoice Management - Invoice", driver, strEnvironmentName);
		estimatesummary.clickYesPopUp ();
		claiminvoicedetails.typeInvNo ();
		claiminvoicedetails.clickSave ();

		claiminvoicedetails.selectInvoiceTable (strInvoiceType);
		TransactionTimer.start (stopwatch);
		claiminvoicedetails.clickMakePayment ();
		TransactionTimer.stop (stopwatch, "Log payment - Party", driver, strEnvironmentName);

		// Enter details in Party frame of Log Payment process

		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Analysis Frame", driver, strEnvironmentName);

		// Enter details in Analysis frame of Log Payment process

		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentanalysis.selectRisk ();
		logpaymentanalysis.selectCoverageFeature ();
		logpaymentanalysis.selectReserveType (strReserveType);
		logpaymentanalysis.selectPaymentCode (strPaymentCode);
		logpaymentanalysis.selectPaymentType (strPaymentType);
		logpaymentanalysis.clickAddPayment ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Payee Frame", driver, strEnvironmentName);

		// Enter details in Payee frame of Log Payment process

		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());

		logpaymentpayee.selectPayee (strpayeeRowText);
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Address Frame", driver, strEnvironmentName);

		// Enter details in Address frame of Log Payment process

		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentaddress.selectPartyForAddress (strRowText);
		logpaymentaddress.selectPartyAddress ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Claim Payment Frame", driver, strEnvironmentName);

		// Enter details in Claim payment frame of Log Payment process

		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentclaimpayment.selectPaymentMethod (strPaymentMethod);
		logpaymentclaimpayment.selectDeliveryMethod ();
		logpaymentclaimpayment.typeAccountNo ();

		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Summary Frame", driver, strEnvironmentName);

		// Complete the Log Payment process

		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		logpaymentsummary.clickFlowCompleted ();
		TransactionTimer.stop (stopwatch, "Financial Summary", driver, strEnvironmentName);

		// Signing out
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}
}
