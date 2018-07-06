package com.innovation.regression.base.common.regression;

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
import com.innovation.pages.client.pages.AddCompanyClient;
import com.innovation.pages.client.pages.AddIndividualClient;
import com.innovation.pages.client.pages.CompanyManagement;
import com.innovation.pages.client.pages.LicenceManagement;
import com.innovation.pages.client.pages.ProfileManagement;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.pages.policy.pages.PolicyAgenDetails;
import com.innovation.pages.policy.pages.PolicyAgentSearch;

/*Regression script will create a company client and then assign it to as agent. Will enter Agent details with company, profile and license details 
 * 
 */

public class TEST_AddAgentWithCompanyClientTest extends DriverManager
{
	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "srtProcessingBranch", "strWritingCompany", "strBranch",
			"strAgentType", "strState" })
	@Test
	public void addAgentWithCompanyClient (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue,
			@Optional("8880-Premier Processing Branch") String srtProcessingBranch, @Optional("Premier Writing Company") String strWritingCompany,
			@Optional("Premier Branch") String strBranch, @Optional("Independent") String strAgentType, @Optional("United Kingdom") String strState)
			throws Exception
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
		String strSelectAgentType = "Agent";
		String strSelectSuffix = "Personal lines";
		String strSelectAgenttype = strAgentType;
		String srtSelectAgentDetailsBranch = srtProcessingBranch;
		String srtSelectAgentStatus = "Active";
		String strSelectCompany = strWritingCompany;
		String strSelectState = strState;
		String strSelecttBranch = strBranch;
		String strAgentCommision = "No commission";
		String strSelectProfile = "ALL";
		String strRunOfIndicator = "Can process new business";

		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);
		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		HomeScreen home = new HomeScreen (driver);
		AddCompanyClient addCompanyClient = new AddCompanyClient (driver);
		AddIndividualClient addIndividualclient = new AddIndividualClient (driver);
		StopWatch stopwatch = new StopWatch ();
		NavigationPanel navigationPanel = new NavigationPanel (driver);
		ChangeBrand changeBrand = new ChangeBrand (driver);

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
		TransactionTimer.stop (stopwatch, "home", driver, strEnvironmentName);

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		changeBrand.clickChangeBrand ();
		changeBrand.selectBrand (strSelectBrand);
		TransactionTimer.start (stopwatch);
		changeBrand.saveBrand ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);
		// This will select Agent Management with search an agent link

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		navigationPanel.expandAgentManagementSpan ();
		TransactionTimer.start (stopwatch);
		navigationPanel.clickSearch ();
		TransactionTimer.stop (stopwatch, "Agent Search", driver, strEnvironmentName);

		// Agent Search Screen
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		PolicyAgentSearch policyAgentSearch = new PolicyAgentSearch (driver);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policyAgentSearch.typeCompanyName ();
		policyAgentSearch.typePostCode ();
		policyAgentSearch.clickSearchButton ();
		TransactionTimer.start (stopwatch);
		policyAgentSearch.clickNewCompany ();
		TransactionTimer.stop (stopwatch, "Add Company Client", driver, strEnvironmentName);
		/*
		 * This will add Company client in system
		 */

		// Contact Details

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		addCompanyClient.typeCompanyName ();
		addCompanyClient.typeHomeEmail ();
		addCompanyClient.typeOfficeEmail ();
		addCompanyClient.typeHomePhone ();
		addCompanyClient.typeMobilePhone ();
		addCompanyClient.typeOfficePhone ();
		addCompanyClient.typeOfficePhoneExtension ();
		addCompanyClient.typeFaxNumber ();
		// Address Details of Company Client
		addCompanyClient.selectCountry (strRegion);
		addCompanyClient.typeZipCodeToSearch (strRegion);
		addCompanyClient.clickImgSearch ();
		addCompanyClient.selectAddressResults ();
		// Client Details of Company Client
		addCompanyClient.typeContactPerson ();
		// addCompanyClient.clickVATRegistered ();
		// addCompanyClient.clickWithHolding ();
		addCompanyClient.selectReferDecline ();
		addCompanyClient.clickCheckBoxPersonOfInterest ();
		addCompanyClient.selectIntroductionType ();
		addCompanyClient.selectIntroductionCode ();
		// addCompanyClient.clickMareketingResearch ();
		// addCompanyClient.clickProductService ();
		addIndividualclient.clickPrivacyAgreement ();
		addIndividualclient.validatePrivacyAgreement ();
		addIndividualclient.privacyAgreementAcceptance ();
		TransactionTimer.start (stopwatch);
		addCompanyClient.clickNextButton ();
		TransactionTimer.stop (stopwatch, "Agent Search", driver, strEnvironmentName);

		// This will select added client row to assign as an agent

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policyAgentSearch.clickSearchButton ();
		policyAgentSearch.selectClientRow ();
		policyAgentSearch.selectAgentType (strSelectAgentType);
		TransactionTimer.start (stopwatch);
		policyAgentSearch.clickAssignButton ();
		TransactionTimer.stop (stopwatch, "Agent Details", driver, strEnvironmentName);

		// Agent Details frame fields entered below
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		PolicyAgenDetails policyAgenDetails = new PolicyAgenDetails (driver);
		policyAgenDetails.selectSuffix (strSelectSuffix);
		policyAgenDetails.selectAgentType (strSelectAgenttype);
		policyAgenDetails.dtpEffetiveDate (strRegion);
		policyAgenDetails.selectBranch (srtSelectAgentDetailsBranch);
		policyAgenDetails.selectAgentADE ();
		policyAgenDetails.selectCreditDate ();
		policyAgenDetails.selectRenewalList ();
		policyAgenDetails.selectAutoRenewal ();
		policyAgenDetails.selectIndexOverride ();
		policyAgenDetails.selectCreditTerm ();
		policyAgenDetails.selectMatchingOrder ();
		policyAgenDetails.selectTeam ();
		policyAgenDetails.selectDisplayOrder ();
		policyAgenDetails.selectClientStmt ();
		policyAgenDetails.selectADE ();
		policyAgenDetails.selectStatus (srtSelectAgentStatus);
		policyAgenDetails.selectNoticeTo ();
		policyAgenDetails.selectNoticeFreq ();
		TransactionTimer.start (stopwatch);
		policyAgenDetails.clickContinue ();
		TransactionTimer.stop (stopwatch, "Main Menu Agent Search", driver, strEnvironmentName);

		// Comment out below code until we have solution of igSupportDHTMLCombo there is base backlog for this

		// This will select Company Management link to assign company for Agent to work // on
		TransactionTimer.start (stopwatch);
		navigationPanel.clickCompanyManagement ();
		TransactionTimer.stop (stopwatch, "Company Management", driver, strEnvironmentName);
		// This will select fields on Company Management screen

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		CompanyManagement companyManagement = new CompanyManagement (driver);
		companyManagement.clickCompanyAddButton ();
		companyManagement.selectCompany (strSelectCompany, strRegion, strSelectState);
		companyManagement.selectBranch (strSelecttBranch);
		companyManagement.selectComscale (strAgentCommision);
		companyManagement.selectPolicyProcess (srtSelectAgentDetailsBranch);
		companyManagement.typeCompanyActiveFrom (strRegion);
		companyManagement.selectRunOffIndicator (strRunOfIndicator);
		TransactionTimer.start (stopwatch);
		companyManagement.clickCompanyDetailAddButton ();
		TransactionTimer.stop (stopwatch, "Main Menu Agent Search", driver, strEnvironmentName);

		// This will select Profile Management link to assign company for Agent to work // on
		TransactionTimer.start (stopwatch);
		navigationPanel.clickProfileManagement ();
		TransactionTimer.stop (stopwatch, "Profile Management", driver, strEnvironmentName);
		// This will select fields on Profile Management screen

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		ProfileManagement profileManagement = new ProfileManagement (driver);
		profileManagement.clickProfileAddButton ();
		profileManagement.selectCompany (strSelectCompany, strRegion, strSelectState);
		profileManagement.typeProfileActiveFrom (strRegion);
		profileManagement.selectProfile (strSelectProfile);
		TransactionTimer.start (stopwatch);
		profileManagement.clickProfileDetailAssign ();
		TransactionTimer.stop (stopwatch, "License  Management", driver, strEnvironmentName);

		// This will select License Management link to assign company for Agent to work // on
		TransactionTimer.start (stopwatch);
		navigationPanel.clickLicenceManagement (strRegion);
		TransactionTimer.stop (stopwatch, "License  Management", driver, strEnvironmentName);

		// This will select fields on License Management screen

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		LicenceManagement licenceManagement = new LicenceManagement (driver);
		licenceManagement.clickLicenceAddButton ();
		licenceManagement.selectCompany (strSelectCompany, strRegion, strSelectState);
		licenceManagement.typeLicenceNo ();
		licenceManagement.typeLicenceActiveFrom (strRegion);
		licenceManagement.typeLicenceActiveTo (strRegion);
		licenceManagement.typeLicenceDueDate (strRegion);
		licenceManagement.selectPaid ();
		licenceManagement.typeFee ();
		licenceManagement.typeCEUattained ();
		licenceManagement.typeCEUrequired ();
		TransactionTimer.start (stopwatch);
		licenceManagement.clickLicenceDetailAddButton ();
		TransactionTimer.stop (stopwatch, "home", driver, strEnvironmentName);

		// home.clickOnDesktop ();

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "signout", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}

}
