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
import com.innovation.pages.claim.pages.ClaimIncidentDetailsAuto;
import com.innovation.pages.claim.pages.ClaimInitialDetailsAuto;
import com.innovation.pages.claim.pages.ClaimLogPaymentAddress;
import com.innovation.pages.claim.pages.ClaimLogPaymentAnalysis;
import com.innovation.pages.claim.pages.ClaimLogPaymentClaimPayment;
import com.innovation.pages.claim.pages.ClaimLogPaymentParty;
import com.innovation.pages.claim.pages.ClaimLogPaymentPayee;
import com.innovation.pages.claim.pages.ClaimLogPaymentSummary;
import com.innovation.pages.claim.pages.ClaimMainSearch;
import com.innovation.pages.claim.pages.ClaimPolicyDetailsAuto;
import com.innovation.pages.claim.pages.ClaimVehicleDetails;
import com.innovation.pages.claim.pages.ClaimVehicleDriver;
import com.innovation.pages.common.pages.ActionsPanel;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.ManageCorrespondence;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;



public class TEST_AddWithPolicyMotorTheftClaim extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void addWithPolicyMotorTheftClaim (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
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
		String strClaimType = "Theft or attempted theft";
		String strIncidentCause = "From insured vehicle";
		String strEmailClaimSummary = "No";
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
		String strFurtherDetails = "From locked garage";
		String strInsuredDisposition = "Random";
		String strCCTVAvailable = "Yes";
		String strReportedBy = "Policyholder";
		String strPaymentParty = "Random";
		String strReserveType = "Expense - Payment";
		String strPaymentCode = "Random";
		String strPaymentType = "Final";
		String strRowText = "Claimant";
		String strPaymentMethod = "Cheque";
		String strPaymentAmount = "Random";
		String strpayeeRowText = "Policyholder";
		String strTheftReportedToPolice = "Yes";
		String strAccidentFollowingTheft = "No";
		String strLocked = "Yes";
		String strAlarmEnabled = "No";
		String strSuspectsKnown = "Yes";
		String strLocks = "No";
		String strIgnition = "Yes";
		String strDashboard = "Yes";
		String strSideGlass = "No";
		String strParts = "Yes";
		String strPartsStolen = "No";
		String strSelectBrand = strEnvironmentBrand;
		String strFeature = "Claim";

		// Setup
		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		HomeScreen home = new HomeScreen (driver);
		ActionsPanel actionpanel = new ActionsPanel (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
		ClaimInitialDetailsAuto initialdetailsauto = new ClaimInitialDetailsAuto (driver);
		ClaimPolicyDetailsAuto claimpolicydetailsauto = new ClaimPolicyDetailsAuto (driver);
		ClaimVehicleDriver claimvehicledriver = new ClaimVehicleDriver (driver);
		ClaimClaimSummary claimsummary = new ClaimClaimSummary (driver);
		ClaimVehicleDetails vehicledetails = new ClaimVehicleDetails (driver);
		ClaimIncidentDetailsAuto claimincidentdetails = new ClaimIncidentDetailsAuto (driver);
		ClaimLogPaymentAddress logpaymentaddress = new ClaimLogPaymentAddress (driver);
		ClaimLogPaymentAnalysis logpaymentanalysis = new ClaimLogPaymentAnalysis (driver);
		ClaimLogPaymentPayee logpaymentpayee = new ClaimLogPaymentPayee (driver);
		ClaimLogPaymentClaimPayment logpaymentclaimpayment = new ClaimLogPaymentClaimPayment (driver);
		ClaimLogPaymentSummary logpaymentsummary = new ClaimLogPaymentSummary (driver);
		ClaimLogPaymentParty logpaymentparty = new ClaimLogPaymentParty (driver);
		NavigationPanel navigationPanel = new NavigationPanel (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
		ClaimMainSearch claimmainsearch = new ClaimMainSearch (driver);
		ManageCorrespondence correspondencesummary = new ManageCorrespondence (driver);
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
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.selectBrand (strSelectBrand);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		brandscheme.saveBrand ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Enter Claim Search
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickOnSearch ();
		home.clickOnClaimSearch ();
		TransactionTimer.stop (stopwatch, "Claim Search", driver, strEnvironmentName);

		// Search the Policy number and add with policy Auto claim
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimmainsearch.selectSearchBy (strSearchBy);
		claimmainsearch.fetchAutoPolicyWithComprehensiveCover (strEnvironmentName, strCompany);
		claimmainsearch.selectDPACheckStatus (strDPACheckStatus);
		claimmainsearch.selectAction (strLOB);
		claimmainsearch.typeIncidentDate (strRegion);
		TransactionTimer.start (stopwatch);
		claimmainsearch.clickOnGo (strDuplicateClaimAction);
		TransactionTimer.stop (stopwatch, "Initial Details", driver, strEnvironmentName);

		// Enter Details in Incident details frame
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
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
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Policy Details", driver, strEnvironmentName);

		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		claimpolicydetailsauto.clickEventManagementNo ();
		TransactionTimer.stop (stopwatch, "Incident Details", driver, strEnvironmentName);

		// Enter Details in Incident Details frame
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimincidentdetails.selectFurtherDetails (strFurtherDetails);
		claimincidentdetails.selectInsuredDisposition (strInsuredDisposition);
		claimincidentdetails.typeIncidentDescription ();
		claimincidentdetails.selectCCTVAvailable (strCCTVAvailable);
		claimincidentdetails.typeCCTVDetails ();
		claimincidentdetails.selectTheftReportedToPolice (strTheftReportedToPolice);
		claimincidentdetails.typeTheftDateReported (strRegion);
		claimincidentdetails.typeTheftReportNo ();
		claimincidentdetails.selectAccidentFollowingTheft (strAccidentFollowingTheft);
		claimincidentdetails.selectLocked (strLocked);
		claimincidentdetails.selectAlarmEnabled (strAlarmEnabled);
		claimincidentdetails.selectSuspectsKnown (strSuspectsKnown);
		claimincidentdetails.selectLocks (strLocks);
		claimincidentdetails.selectIgnition (strIgnition);
		claimincidentdetails.selectDashboard (strDashboard);
		claimincidentdetails.selectSideGlass (strSideGlass);
		claimincidentdetails.selectParts (strParts);
		claimincidentdetails.selectPartsStolen (strPartsStolen);
		claimincidentdetails.typeVehicleDamageDetails ();

		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Vehicle/Driver Details", driver, strEnvironmentName);

		// Select Vehicle/Driver in Vehicle/Driver frame
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimvehicledriver.selectRandomVehicleRecord ();
		claimvehicledriver.selectRandomDriverRecord ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Vehicle Details", driver, strEnvironmentName);

		// Enter Details in Vehicle Details frame
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
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
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Party Hub", driver, strEnvironmentName);

		// Navigate forward from Party Hub screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Claim Summary", driver, strEnvironmentName);

		// Enter Details in Claim Summary frame in FNOL
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimsummary.selectEmailClaimSummary (strEmailClaimSummary);
		String strClaimNumber = claimsummary.getClaimNumber ();
		System.out.println ("Auto Claim = " + strClaimNumber);
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

		// View the document in Correspondence section

		navigationPanel.expandBOCorrespondenceSpan ();
		TransactionTimer.start (stopwatch);
		navigationPanel.clickCorrespondenceSummary ();
		TransactionTimer.stop (stopwatch, "Correspondence frame", driver, strEnvironmentName);

		correspondencesummary.selectRandomDocuments ();
		correspondencesummary.clickView ();
		correspondencesummary.closeDocument ();

		actionpanel.clickClaimSummary ();

		TransactionTimer.start (stopwatch);
		claimsummary.selectFeature (strFeature);
		TransactionTimer.start (stopwatch);

		// click on log payment accordion
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		navigationPanel.clickBOFinancialsSpan ();
		TransactionTimer.stop (stopwatch, "Party frame", driver, strEnvironmentName);
		navigationPanel.clickLogPayment ();

		// Enter details in Party frame of Log Payment process

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentparty.selectPaymentParty (strPaymentParty);

		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Analysis Frame", driver, strEnvironmentName);

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
		TransactionTimer.stop (stopwatch, "Log Payment - Payee Frame", driver, strEnvironmentName);

		// Enter details in Payee frame of Log Payment process

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());

		logpaymentpayee.selectPayee (strpayeeRowText);
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Address Frame", driver, strEnvironmentName);

		// Enter details in Address frame of Log Payment process

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentaddress.selectPartyForAddress (strRowText);
		logpaymentaddress.selectPartyAddress ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Claim Payment Frame", driver, strEnvironmentName);

		// Enter details in Claim payment frame of Log Payment process

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		logpaymentclaimpayment.selectPaymentMethod (strPaymentMethod);
		logpaymentclaimpayment.selectDeliveryMethod ();
		logpaymentclaimpayment.typeAccountNo ();

		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Log Payment - Summary Frame", driver, strEnvironmentName);

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
