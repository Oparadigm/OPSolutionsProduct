package com.innovation.regression.base.feature.regression.common;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.misc.TransactionTimer;
import com.innovation.pages.claim.pages.ClaimAddParty;
import com.innovation.pages.claim.pages.ClaimClaimSummary;
import com.innovation.pages.claim.pages.ClaimClaimantDetails;
import com.innovation.pages.claim.pages.ClaimIncidentDetailsAuto;
import com.innovation.pages.claim.pages.ClaimInitialDetailsAuto;
import com.innovation.pages.claim.pages.ClaimMOJActions;
import com.innovation.pages.claim.pages.ClaimMOJClaims;
import com.innovation.pages.claim.pages.ClaimMainSearch;
import com.innovation.pages.claim.pages.ClaimPartyHub;
import com.innovation.pages.claim.pages.ClaimPolicyDetailsAuto;
import com.innovation.pages.claim.pages.ClaimVehicleDetails;
import com.innovation.pages.claim.pages.ClaimVehicleDriver;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.NavigationPanel;

/**
 * @author haiderm - This class contains a method that returns 1insurer claim number specific to MOJ interface.
 *
 */

public class InsurerClaimActionsForMOJ
{

	WebDriver	driver;
	String		strInsurerClaimNumber					= null;
	String		strElementPC							= "postcode";
	String		strNodePC								= "postcode";
	String		strXMLFileNamePC						= "Postcode.xml";
	String		strSearchBy								= "Reference number";
	String		strDPACheckStatus						= "Yes";
	String		strLOB									= "Add motor claim";
	String		strDuplicateClaimAction					= "Add";
	String		strReportedBy							= "Policyholder";
	String		strClaimType							= "Accident";
	String		strIncidentCause						= "Vehicle collision whilst reversing";
	String		strFurtherDetails						= "PH strikes stationary TP";
	String		strInsuredDisposition					= "Random";
	String		strVehicleMoving						= "Yes";
	String		strVehicleDriveable						= "Yes";
	String		strClaimingForDamage					= "Yes";
	String		strSettlementRoute						= "R";
	String		strMechanic								= "Yes";
	String		strInterior								= "Yes";
	String		strPartyIndicatorNew					= "Third party";
	String		strSubRoleNew							= "Third party vehicle owner";
	String		strVehicleDamage						= "Yes";
	String		strProHandling							= "Yes";
	String		strPersonalInjury						= "Yes";
	String		strServicesRejected						= "No";
	String		strDrivingForEmployer					= "Yes";
	String		strPermissionGiven						= "Yes";
	String		strSeatBeltWorn							= "Yes";
	String		strConvictions							= "Yes";
	String		strMedicalCondition						= "No";
	String		strAlcoholDrugInvolved					= "Yes";
	String		strEmailClaimSummary					= "No";
	String		strClaimAction							= "Accept";
	String		strClaimant								= "Random";
	String		strFilterBy								= "All";
	String		strArticle75Decision					= "Article 75 applies";
	String		strInsurerCapacity						= "RTA insurer";
	String		strLiability							= "Admitted";
	String		strInsurerPreparedToProvideRehab		= "Yes";
	String		strInsurerProvidedRehab					= "No";
	String		strCountry								= "UK";
	String		strInsurerInstructedAlternativeVehicle	= "No";
	String		strInsurerOrganisedRepairs				= "No";
	String		strRegionValue							= "UK";
	String		strCurrentDate;

	public InsurerClaimActionsForMOJ (WebDriver driver)
	{
		this.driver = driver;

	}

	public String createMotorClaimWithTPBI (String strEnvironmentName, String strCompany, String strRegion) throws Exception
	{

		HomeScreen home = new HomeScreen (driver);
		ClaimMainSearch claimmainsearch = new ClaimMainSearch (driver);
		ClaimInitialDetailsAuto initialdetailsauto = new ClaimInitialDetailsAuto (driver);
		ClaimPolicyDetailsAuto claimpolicydetailsauto = new ClaimPolicyDetailsAuto (driver);
		ClaimIncidentDetailsAuto claimincidentdetails = new ClaimIncidentDetailsAuto (driver);
		ClaimVehicleDriver claimvehicledriver = new ClaimVehicleDriver (driver);
		ClaimVehicleDetails vehicledetails = new ClaimVehicleDetails (driver);
		ClaimPartyHub claimpartyhub = new ClaimPartyHub (driver);
		ClaimAddParty claimaddparty = new ClaimAddParty (driver);
		ClaimClaimantDetails claimclaimantdetails = new ClaimClaimantDetails (driver);
		ClaimClaimSummary claimsummary = new ClaimClaimSummary (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
		SeleniumWaiter seleniumWaiter = new SeleniumWaiter (driver);
		StopWatch stopwatch = new StopWatch ();

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
		initialdetailsauto.typeZIPCode (strRegionValue);
		initialdetailsauto.clickZipCodeSearchIcon ();
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		initialdetailsauto.selectAddress ();
		initialdetailsauto.typeLocationDescription ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Policy Details", driver, strEnvironmentName);

		// Navigate forward from POlicy details frame
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		claimpolicydetailsauto.clickEventManagementNo ();
		TransactionTimer.stop (stopwatch, "Incident Details", driver, strEnvironmentName);

		// Enter Details in Incident Details frame
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimincidentdetails.selectFurtherDetails (strFurtherDetails);
		claimincidentdetails.selectInsuredDisposition (strInsuredDisposition);
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
		vehicledetails.selectActualUse ();
		vehicledetails.selectVehicleMoving (strVehicleMoving);
		vehicledetails.selectVehicleDriveable (strVehicleDriveable);
		vehicledetails.selectDamagetab ();
		vehicledetails.selectClaimingForDamage (strClaimingForDamage);
		vehicledetails.selectSettlementRoute (strSettlementRoute);
		vehicledetails.clickMinorDamageArrow1 ();
		vehicledetails.clickMajorDamageArrow1 ();
		vehicledetails.selectMechanic (strMechanic);
		vehicledetails.selectInterior (strInterior);
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
		claimclaimantdetails.selectPreferredLanguage ();
		claimclaimantdetails.selectBestContactMethod ();
		claimclaimantdetails.selectBestContactTime ();
		claimclaimantdetails.addAddress (strRegion);
		claimclaimantdetails.selectClaimTab ();
		claimclaimantdetails.selectVehicleDamage (strVehicleDamage);
		claimclaimantdetails.selectProactiveHandling (strProHandling);
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

		// Getting 1insurer claim number
		strInsurerClaimNumber = claimsummary.getClaimNumber ();
		TransactionTimer.start (stopwatch);
		claimsummary.clickFlowCompleted ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		return strInsurerClaimNumber;
	}

	public void acceptMOJClaim (String strMOJClaimNumber, String strInsurerClaimNumber, String strEnvironmentName) throws Exception
	{
		SeleniumWaiter seleniumWaiter = new SeleniumWaiter (driver);
		StopWatch stopwatch = new StopWatch ();
		ClaimMOJClaims mojclaims = new ClaimMOJClaims (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
		NavigationPanel navigationpanel = new NavigationPanel (driver);

		// Associate 1insurer Claim with MOJ Claim
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		navigationpanel.expandClaimsSpan ();
		mojclaims.selectMOJClaimForAcceptance (strEnvironmentName, strMOJClaimNumber);
		mojclaims.selectAction (strClaimAction);
		mojclaims.typeClaimNumber (strInsurerClaimNumber);
		mojclaims.clickFetchClaimants ();
		mojclaims.selectClaimant (strClaimant);

		// Accept CNF
		mojclaims.clickAcceptCNF ();
		controlpanel.clickYes ();
		mojclaims.selectFilterBy (strFilterBy);
		strCurrentDate = CalenderDate.returnCurrentDate (strRegionValue);
		mojclaims.typeFrom (strCurrentDate);
		mojclaims.clickApply ();
		mojclaims.clickCNFRefNo ();
		mojclaims.selectMOJClaim (strMOJClaimNumber);
		TransactionTimer.start (stopwatch);
		mojclaims.clickOpenClaim ();
		TransactionTimer.stop (stopwatch, "BO - Claim summary", driver, strEnvironmentName);

	}

	public void applyArticle75 (String strEnvironmentName)
	{
		SeleniumWaiter seleniumWaiter = new SeleniumWaiter (driver);
		ClaimMOJActions mojactions = new ClaimMOJActions (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
		NavigationPanel navigationpanel = new NavigationPanel (driver);
		StopWatch stopwatch = new StopWatch ();

		// Apply Article 75 - must be called after accpetMOJClaim method
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		navigationpanel.clickBodilyInjurySpan ();
		TransactionTimer.start (stopwatch);
		navigationpanel.clickMOJActions ();
		TransactionTimer.stop (stopwatch, "MOJ Actions", driver, strEnvironmentName);
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		mojactions.selectArticle75Decision (strArticle75Decision);
		mojactions.clickArticle75Decision ();
		controlpanel.clickYes ();

	}

	public void takeLiabilityDecision ()
	{
		SeleniumWaiter seleniumWaiter = new SeleniumWaiter (driver);
		ClaimMOJActions mojactions = new ClaimMOJActions (driver);
		ControlPanel controlpanel = new ControlPanel (driver);

		// Take Liability Decision - must be called after applyArticle75 method
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		mojactions.selectInsurerCapacity (strInsurerCapacity);
		mojactions.selectLiability (strLiability);
		mojactions.typeContactName ();
		mojactions.typeSurName ();
		mojactions.typeTelephoneNo ();
		mojactions.typeEmailAddress ();
		mojactions.selectInsurerPreparedToProvideRehab (strInsurerPreparedToProvideRehab);
		mojactions.selectInsurerProvidedRehab (strInsurerProvidedRehab);
		mojactions.selectInsurerInstructedAlternativeVehicle (strInsurerInstructedAlternativeVehicle);
		mojactions.selectInsurerOrganisedRepairs (strInsurerOrganisedRepairs);
		mojactions.typeHouseName ();
		mojactions.typeNumber ();
		mojactions.typeStreet1 ();
		mojactions.typeStreet2 ();
		mojactions.typeDistrict ();
		mojactions.typeTown ();
		mojactions.typeCounty ();
		mojactions.typeCountry (strCountry);
		mojactions.typePostcode ();
		mojactions.clickLiabilityDecision ();
		controlpanel.clickYes ();
	}
}
