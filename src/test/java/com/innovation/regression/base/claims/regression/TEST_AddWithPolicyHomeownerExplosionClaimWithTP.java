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
import com.innovation.pages.claim.pages.ClaimLitigation;
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


public class TEST_AddWithPolicyHomeownerExplosionClaimWithTP extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void addWithPolicyHomeownerExplosionClaimWithTP (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue, @Optional("8880") String strCompany)
			throws Exception
	{

		// Following variables are used as parameters in the test script
		String strSelectBrand = strEnvironmentBrand;
		String strRegion = strRegionValue;
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";
		String strElementLogin = "user";
		String strNodeUsername = "username";
		String strNodePassword = "password";
		String strXMLFileNameLogin = "UserName.xml";
		String strElementDOB = "dateofbirth";
		String strNodeDOB = "dateofbirth";
		String strXMLFileNameDOB = "UKDateOfBirth.xml";
		String strSearchBy = "Reference number";
		String strDPACheckStatus = "Yes";
		String strLOB = "Add property claim";
		String strDuplicateClaimAction = "Add";
		String strClaimType = "Explosion";
		String strCCTVAvailable = "Yes";
		String strReportedToFireDept = "Yes";
		String strRiskTypeValue = "Home";
		String strPartyIndicator = "Third party";
		String strTPSubRole1 = "Third party property owner";
		String strTPSubRole2 = "Third party vehicle owner";
		String strVATRegisteredStatus = "Yes";
		String strAccountNo = "12345678";
		String strSortCode = "000099";
		String strCardType = "Visa";
		String strCardNumber = "4111111111111111";
		String strExpiryMonth = "12";
		String strExpiryYear = "2019";
		String strPropertyDamage = "Yes";
		String strSubroOpportunity = "Yes";
		String strPersonalInjury = "Yes";
		String strAssociPartyType = "Representative";
		String strCoverageB = "Buildings";
		String strCoverageC = "Contents";
		String strItemTypeBC = "Random";
		String strPartOfSet = "Yes";
		String strItemAge = "Unknown";
		String strItemLocation = "Unknown";
		String strNumberOfRooms = "Unknown";
		String strPriority = "High";
		String strItemUsed = "Private";
		String strItemServiced = "No";
		String strUnderWarranty = "Yes";
		String strAmountClaimed = "2000";
		String strAmountSource = "Other";
		String strFullfilmentRouteFP = "Supplier replace";
		String strSupplierType = "Repairer";
		String strCoverageP = "Property owner's liability";
		String strItemTypeL = "Liabilities";
		String strItem = "Injury";
		String strFullfilmentRouteTP = "Cash settle";
		String strEmailClaimSummary = "No";
		String strSIUReferralOverrideReason = "SIU Closed - Proceed with claim";
		String strSIUClosureReason = "Closed - Proceed with the claim";
		String strTitleOfAction = "FP vs TP";
		String strLitigationCategory = "Random";
		String strSection152 = "Yes";
		String strDefectiveService = "Yes";
		String strLitigationReason = "Random";
		String strDefenceRequired = "Yes";
		String strExtended = "Yes";
		String strCPRType = "Random";
		String strRequested = "Yes";
		String strResponse = "Yes";
		String strPartyType = "Random";
		String strLitigationAction = "Random";
		String strLitigationStatus = "Active";
		String strLitigationOutcome = "Random";
		String strOfferType = "Random";
		String strOffer = "Random";
		String strOfferStatus = "Random";

		// Setup
		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
		HomeScreen home = new HomeScreen (driver);
		NavigationPanel navigationpanel = new NavigationPanel (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
		ClaimInitialDetails claiminitialdetails = new ClaimInitialDetails (driver);
		ClaimPolicyDetails claimpolicydetails = new ClaimPolicyDetails (driver);
		ClaimIncidentDetails claimincidentdetails = new ClaimIncidentDetails (driver);
		ClaimPartyHub claimpartyhub = new ClaimPartyHub (driver);
		ClaimAddParty claimaddparty = new ClaimAddParty (driver);
		ClaimClaimantDetails claimclaimantdetails = new ClaimClaimantDetails (driver);
		ClaimSupplierSearch claimsuppliersearch = new ClaimSupplierSearch (driver);
		ClaimItemManagementDetails itemmanagmentdetails = new ClaimItemManagementDetails (driver);
		ClaimClaimSummary claimsummary = new ClaimClaimSummary (driver);
		ClaimLitigation claimlitigation = new ClaimLitigation (driver);
		StopWatch stopwatch = new StopWatch ();
		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
		ClaimMainSearch claimmainsearch = new ClaimMainSearch (driver);

		// Login Page
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		login.typeUserNamePassword (strElementLogin, strNodeUsername, strNodePassword, strXMLFileNameLogin, strEnvironmentName);

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
		home.clickOnClaimSearch ();
		TransactionTimer.stop (stopwatch, "Claim Search", driver, strEnvironmentName);

		// Search homeowner policy from the database and initiate property claim against
		// it
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
		claimincidentdetails.selectCCTV (strCCTVAvailable);
		claimincidentdetails.typeCCTVDetails ();
		claimincidentdetails.selectReportedToFireDeptStorm (strReportedToFireDept);
		// Enter Risk information
		claimincidentdetails.selectRiskRecord (strRiskTypeValue);
		claimincidentdetails.typeLastOccupied (strRegion);
		claimincidentdetails.typeLastFurnished (strRegion);
		claimincidentdetails.selectFireOrigin ();
		claimincidentdetails.selectLocation ();
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
		claimaddparty.selectSubRoleNew (strTPSubRole1);
		claimaddparty.addSubRoleNew ();
		claimaddparty.selectSubRoleNew (strTPSubRole2);
		claimaddparty.addSubRoleNew ();
		TransactionTimer.start (stopwatch);
		claimaddparty.addPartyNew ();
		TransactionTimer.stop (stopwatch, "Claimant Details", driver, strEnvironmentName);

		// Enter Third Party/Claimant Details
		// Information tab
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimclaimantdetails.typeNationalInsuranceNumber ();
		claimclaimantdetails.selectGender ();
		claimclaimantdetails.typeDateOfBirth (strElementDOB, strNodeDOB, strXMLFileNameDOB);
		claimclaimantdetails.selectOccupation ();
		claimclaimantdetails.selectPreferredLanguage ();
		claimclaimantdetails.selectBestContactMethod ();
		claimclaimantdetails.selectBestContactTime ();
		claimclaimantdetails.typeComments ();
		claimclaimantdetails.selectVATRegistered (strVATRegisteredStatus);
		claimclaimantdetails.addAddress (strRegion);
		claimclaimantdetails.addEmail (strRegion);
		claimclaimantdetails.addPhoneFax (strRegion);
		seleniumwaiter.waitForMe (GlobalWaitTime.getLongWaitTime ());
		claimclaimantdetails.addBankAccount (strAccountNo, strSortCode);
		claimclaimantdetails.addCreditCard (strCardType, strCardNumber, strExpiryMonth, strExpiryYear);
		// Claim tab
		claimclaimantdetails.selectClaimTab ();
		claimclaimantdetails.selectPropertyDamage (strPropertyDamage);
		claimclaimantdetails.selectSubrogationOpportunity (strSubroOpportunity);
		claimclaimantdetails.typeSubrogationReason ();
		claimclaimantdetails.selectPersonalInjury (strPersonalInjury);
		// Injury questionnaire tab
		claimclaimantdetails.selectInjuryQuestionnaireTab ();
		claimclaimantdetails.selectExtentOfInjry ();
		claimclaimantdetails.selectTimeOffWork ();
		claimclaimantdetails.typeTimeOffWorkDetails ();
		claimclaimantdetails.selectImpactOnSocialLife ();
		claimclaimantdetails.typeImpactOnSocialLifeDetails ();
		claimclaimantdetails.clickSaveInjuryQuestion ();
		// Associated parties tab
		claimclaimantdetails.selectAssociatedPartiesTab ();
		TransactionTimer.start (stopwatch);
		claimclaimantdetails.clickSearchAssociatedParty ();
		TransactionTimer.stop (stopwatch, "Supplier search", driver, strEnvironmentName);
		claimsuppliersearch.selectType (strAssociPartyType);

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
		// Adding item against Builidings coverage
		itemmanagmentdetails.selectCoverage (strCoverageB);
		itemmanagmentdetails.selectItemType (strItemTypeBC);
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
		itemmanagmentdetails.selectFullfilmentRoute (strFullfilmentRouteFP);
		itemmanagmentdetails.clickSave ();
		// Adding item against Contents coverage
		itemmanagmentdetails.selectCoverage (strCoverageC);
		itemmanagmentdetails.selectItemType (strItemTypeBC);
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
		itemmanagmentdetails.selectFullfilmentRoute (strFullfilmentRouteFP);
		itemmanagmentdetails.clickSave ();
		// Instructing supplier against a claim item
		itemmanagmentdetails.selectRandomClaimItem ();
		TransactionTimer.start (stopwatch);
		itemmanagmentdetails.clickSupplierSearch ();
		TransactionTimer.stop (stopwatch, "Supplier search", driver, strEnvironmentName);
		claimsuppliersearch.selectType (strSupplierType);
		claimsuppliersearch.selectSearchType ("Open");
		claimsuppliersearch.clickSearchSupplier ();
		claimsuppliersearch.selectSupplier ();
		claimsuppliersearch.clickInstructSupplier ();
		claimsuppliersearch.navigateBackSupplierSearch ();
		// Adding item against Property owner's liability coverage
		itemmanagmentdetails.selectCoverage (strCoverageP);
		itemmanagmentdetails.selectItemType (strItemTypeL);
		itemmanagmentdetails.selectItem (strItem);
		// Third party is selected from Owned by dropdown using getPartyName() method
		itemmanagmentdetails.selectOwnedByForTPCover (claimaddparty.getPartyName ());
		itemmanagmentdetails.typeAmountClaimed (strAmountClaimed);
		itemmanagmentdetails.selectFullfilmentRoute (strFullfilmentRouteTP);
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

		// Add Litigation details
		// Entering data on Management tab
		navigationpanel.expandBOLitigationSpan ();
		TransactionTimer.start (stopwatch);
		navigationpanel.clickDetailsLitigation ();
		TransactionTimer.stop (stopwatch, "BO - Litigation", driver, strEnvironmentName);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		controlpanel.clickEditFrame ();
		claimlitigation.selectManagementTab ();
		claimlitigation.clickAddLitigation ();
		claimlitigation.typeTitleOfAction (strTitleOfAction);
		claimlitigation.selectLitigationCategory (strLitigationCategory);
		claimlitigation.typeCourtClaimNo ();
		claimlitigation.typeDateIssued (strRegion);
		claimlitigation.typeDateServed (strRegion);
		claimlitigation.selectSection152 (strSection152);
		claimlitigation.selectDefectiveService (strDefectiveService);
		claimlitigation.selectLitigationReason (strLitigationReason);
		claimlitigation.selectDefenceRequired (strDefenceRequired);
		claimlitigation.typeDefenceDueDate (strRegion);
		claimlitigation.selectExtended (strExtended);
		claimlitigation.typeExtendedReason ();
		claimlitigation.selectType (strCPRType);
		claimlitigation.selectRequested (strRequested);
		claimlitigation.typeDateRequested (strRegion);
		claimlitigation.typeDateExpected (strRegion);
		claimlitigation.selectResponse (strResponse);
		claimlitigation.clickSaveLitigation ();
		// Entering data on WIP tab
		claimlitigation.selectWIPTab ();
		claimlitigation.selectLitigationRecord ();
		claimlitigation.clickAddParty ();
		claimlitigation.selectPartyName (claimaddparty.getPartyName ());
		claimlitigation.selectPartyType (strPartyType);
		claimlitigation.selectPartyRepresentative ();
		claimlitigation.typeDateInstructed (strRegion);
		claimlitigation.selectAction (strLitigationAction);
		claimlitigation.selectStatus (strLitigationStatus);
		claimlitigation.selectOutcome (strLitigationOutcome);
		claimlitigation.typeOutcomeDate (strRegion);
		claimlitigation.clickSavePartyDetails ();
		claimlitigation.selectPartyRecord ();
		// Adding Offer details
		claimlitigation.clickAddOffer ();
		claimlitigation.selectOfferType (strOfferType);
		claimlitigation.selectOffer (strOffer);
		claimlitigation.selectOfferStatus (strOfferStatus);
		claimlitigation.typeSplitPercentage ();
		claimlitigation.typeAmount ();
		claimlitigation.clickSaveOfferDetails ();
		// Adding Evaluation details
		claimlitigation.clickAddEvalutation ();
		claimlitigation.typeEvaluationDate (strRegion);
		claimlitigation.typeVehicleAmount ();
		claimlitigation.typePropertyAmount ();
		claimlitigation.typeSpecialAmount ();
		claimlitigation.typeGeneralDamageAmount ();
		claimlitigation.typeInterestAmount ();
		claimlitigation.typeOwnCostsAmount ();
		claimlitigation.typeClaimantCostsAmount ();
		claimlitigation.typeLiabilityPercentage ();
		claimlitigation.clickSaveEvaluationDetails ();

		// Signing out
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}
}
