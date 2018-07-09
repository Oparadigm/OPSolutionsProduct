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
import com.innovation.pages.claim.pages.ClaimAddClaimNoPolicy;
import com.innovation.pages.claim.pages.ClaimAddParty;
import com.innovation.pages.claim.pages.ClaimClaimSummary;
import com.innovation.pages.claim.pages.ClaimFetchPolicy;
import com.innovation.pages.claim.pages.ClaimIncidentDetails;
import com.innovation.pages.claim.pages.ClaimInitialDetails;
import com.innovation.pages.claim.pages.ClaimItemManagementDetails;
import com.innovation.pages.claim.pages.ClaimMainSearch;
import com.innovation.pages.common.pages.ActionsPanel;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;



public class TEST_AddNoPolicyHomeownerClaim extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strCompany" })
	@Test
	public void addNoPolicyHomeownerClaim (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
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
		String strLineOfBusiness = "Add property claim";
		String strClaimType = "Accidental damage";
		String strDamageContained = "Yes";
		String strAlreadyRepaired = "No";
		String strOrganisedRepaired = "No";
		String strCausedByThirdParty = "No";
		String strCCTVAvailable = "Yes";
		String strEmailClaimSummary = "No";
		String strCoverage = "Buildings";
		String strItemType = "Building items";
		String strItem = "Property damage";
		String strAmountClaimed = "2000";
		String strFullfilmentRoute = "Cash settle";

		// Setup
		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		ActionsPanel actionspanel = new ActionsPanel (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
		NavigationPanel navigationPanel = new NavigationPanel (driver);
		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		HomeScreen home = new HomeScreen (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
		ClaimAddClaimNoPolicy addclaimnopolicy = new ClaimAddClaimNoPolicy (driver);
		ClaimMainSearch claimmainsearch = new ClaimMainSearch (driver);
		ClaimInitialDetails claiminitialdetails = new ClaimInitialDetails (driver);
		ClaimIncidentDetails claimincidentdetails = new ClaimIncidentDetails (driver);
		ClaimAddParty claimaddparty = new ClaimAddParty (driver);
		ClaimItemManagementDetails claimitemmanagmentdetails = new ClaimItemManagementDetails (driver);
		ClaimClaimSummary claimsummary = new ClaimClaimSummary (driver);
		ClaimFetchPolicy fetchpolicy = new ClaimFetchPolicy (driver);
		StopWatch stopwatch = new StopWatch ();
		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);

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

		// Initiate No-Policy Claim
		actionspanel.clickAddClaimNoPolicy ();

		// Enter Add claim - no policy
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		addclaimnopolicy.typeLossDate (strRegion);
		addclaimnopolicy.selectLineOfBusiness (strLineOfBusiness);
		TransactionTimer.start (stopwatch);
		addclaimnopolicy.clickCreate ();
		TransactionTimer.stop (stopwatch, "Initial Details", driver, strEnvironmentName);

		// Enter Claim Initial Details
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claiminitialdetails.selectReportedBy ();
		claiminitialdetails.selectTitle ();
		claiminitialdetails.typeFirstName ();
		claiminitialdetails.typeLastName ();
		claiminitialdetails.selectAreaCode (strRegionValue);
		claiminitialdetails.typePhoneNumber ();
		claiminitialdetails.typePhoneExt ();
		claiminitialdetails.selectBestContactTime ();
		claiminitialdetails.selectClaimType (strClaimType);
		claiminitialdetails.selectIncidentCause ();
		claiminitialdetails.typeIncidentTime ();
		claiminitialdetails.selectSeverLoss ();
		claiminitialdetails.typeIncidentDescription ();
		claiminitialdetails.typeReferenceNumber ();
		claiminitialdetails.typeZIPCode (strRegionValue);
		claiminitialdetails.clickZipCodeSearchIcon ();
		claiminitialdetails.selectAddress ();
		claiminitialdetails.typeLocationDescription ();
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Incident Details", driver, strEnvironmentName);

		// Enter Claim Incident Details
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		claimincidentdetails.typeNotificationDate (strRegion);
		claimincidentdetails.typeIncidentNotificationTime (claiminitialdetails.getIncidentTime ());
		claimincidentdetails.typeHowIncidentNotice ();
		claimincidentdetails.selectDamageContained (strDamageContained);
		claimincidentdetails.selectCCTV (strCCTVAvailable);
		claimincidentdetails.typeCCTVDetails ();
		claimincidentdetails.typeMitigationAction ();
		claimincidentdetails.selectAlreadyRepaired (strAlreadyRepaired);
		claimincidentdetails.selectOrganisedRepaired (strOrganisedRepaired);
		claimincidentdetails.selectCausedByThirdParty (strCausedByThirdParty);
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Party Hub", driver, strEnvironmentName);

		// Enter Party Hub
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		controlpanel.clickNext ();
		TransactionTimer.stop (stopwatch, "Claim summary", driver, strEnvironmentName);

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

		// Navigation to Function --> Policy frame
		navigationPanel.expandBOFunctionsSpan ();
		navigationPanel.clickBOPolicy ();

		// Fetch latest Homeowner Policy in Policy frame
		controlpanel.clickEditFrame ();
		fetchpolicy.typeHomePolicyWithQuery (strEnvironmentName, strCompany);
		fetchpolicy.ClickfetchPolicy ();
		fetchpolicy.selectClaimingFor ();
		controlpanel.clickSave ();

		// Adding new Item by navigating to Property damage --> Add new item
		actionspanel.clickClaimSummary ();
		navigationPanel.expandBOPropertyDamageSpan ();
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		navigationPanel.clickAddNewItem ();

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
		claimitemmanagmentdetails.moveAllToItemMgmt ();
		claimitemmanagmentdetails.clickOK ();

		actionspanel.clickClaimSummary ();
		navigationPanel.clickBOFinancialsSpan ();
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		navigationPanel.clickManageReserve ();

		// Signing out
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}

}
