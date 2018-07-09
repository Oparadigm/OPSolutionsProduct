/**
 * 
 */
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
import com.innovation.pages.client.pages.AddIndividualClient;
import com.innovation.pages.client.pages.ClientSummary;
import com.innovation.pages.common.pages.ActionsPanel;
import com.innovation.pages.common.pages.ChangeBrand;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.HomeScreen;
import com.innovation.pages.common.pages.LoginPage;
import com.innovation.pages.common.pages.ManageCorrespondence;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.pages.policy.pages.PolicyClientSearch;
import com.innovation.pages.policy.pages.PolicyCoverages;
import com.innovation.pages.policy.pages.PolicyLosses;
import com.innovation.pages.policy.pages.PolicyPreliminaryQuestions;
import com.innovation.pages.policy.pages.PolicyPropertyHub;
import com.innovation.pages.policy.pages.PolicyResidentialDetails;
import com.innovation.pages.policy.pages.PolicyStartDetails;
import com.innovation.pages.policy.pages.PolicySummary;



public class TEST_AddHomeownerQuote extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strState", "strCompany", "strClientState", "strSubCompany",
			"strHomeLob", "strHomeRiskType" })
	@Test

	public void addHomeownerQuote (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,
			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue, @Optional("United Kingdom") String strState,
			@Optional("8880") String strCompany, @Optional("GB") String strClientState, @Optional("880") String strSubCompany,
			@Optional("Homeowners - UK Property") String strHomeLob, @Optional("Homeowners") String strHomeRiskType) throws Exception
	{

		// Variables used in this scenario
		String strSelectBrand = strEnvironmentBrand;
		String strRegion = strRegionValue;
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";

		// Navigate to 1insurer Application
		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		SeleniumWaiter seleniumWaiter = new SeleniumWaiter (driver);
		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		HomeScreen home = new HomeScreen (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
		PolicyClientSearch policyclientsearch = new PolicyClientSearch (driver);
		AddIndividualClient addIndividualclient = new AddIndividualClient (driver);
		ActionsPanel actionspanel = new ActionsPanel (driver);
		PolicyStartDetails policystartdetails = new PolicyStartDetails (driver);
		PolicyPreliminaryQuestions policypreliminaryquestions = new PolicyPreliminaryQuestions (driver);
		PolicyPropertyHub policypropertyHub = new PolicyPropertyHub (driver);
		PolicyResidentialDetails policyresidentialdetails = new PolicyResidentialDetails (driver);
		PolicyLosses policylosses = new PolicyLosses (driver);
		PolicyCoverages policycoverages = new PolicyCoverages (driver);
		PolicySummary policysummary = new PolicySummary (driver);
		ClientSummary clientsummary = new ClientSummary (driver);
		NavigationPanel navigationpanel = new NavigationPanel (driver);
		ManageCorrespondence managecorrespondence = new ManageCorrespondence (driver);
		ControlPanel control = new ControlPanel (driver);
		StopWatch stopwatch = new StopWatch ();

		// Login Page
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		login.typeUserNamePassword ("user", "username", "password", "UserName.xml", strEnvironmentName);

		// Login Timing
		TransactionTimer.start (stopwatch);
		login.clickLoginButton ();
		TransactionTimer.stop (stopwatch, "Login", driver, strEnvironmentName);

		// Check Previous Session Work items
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		previoussessionworkitems.clickRestoreAllAndApply ();

		// Change Brand
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.clickChangeBrand ();
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.selectBrand (strSelectBrand);
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		brandscheme.saveBrand ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Enter Search
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickOnSearch ();
		home.clickOnPolicyClientSearch ();
		TransactionTimer.stop (stopwatch, "Policy Client Search", driver, strEnvironmentName);

		// Policy Client Search
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policyclientsearch.typeClientLastName ();
		policyclientsearch.typeClientFirstName ();
		policyclientsearch.typeClientZipCode ("S");
		policyclientsearch.clickSearchButton ();
		TransactionTimer.start (stopwatch);
		policyclientsearch.clickNewIndividualButton ();
		TransactionTimer.stop (stopwatch, "Add Individual Client", driver, strEnvironmentName);

		// Add Individual Page
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		addIndividualclient.selectTitle ();
		addIndividualclient.typeEmail ();
		addIndividualclient.typeHomePhoneNo ();
		addIndividualclient.typeZIPCode (strRegion);
		addIndividualclient.clickZipCodeSearchIcon ();
		addIndividualclient.SearchCriteriaDropDown ();
		addIndividualclient.typeDOB (strRegion);
		addIndividualclient.selectGender ();
		addIndividualclient.selectMaritalStatus ();
		addIndividualclient.selectOccupation ();
		addIndividualclient.selectLanguage (strRegionValue);
		addIndividualclient.clickPrivacyAgreement ();
		addIndividualclient.validatePrivacyAgreement ();
		addIndividualclient.privacyAgreementAcceptance ();
		TransactionTimer.start (stopwatch);
		addIndividualclient.clickNext ();
		addIndividualclient.clickYes ();
		TransactionTimer.stop (stopwatch, "Client Summary", driver, strEnvironmentName);

		// Actions Panel
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		actionspanel.clickAddQuote ();
		TransactionTimer.stop (stopwatch, "Policy Start Details", driver, strEnvironmentName);

		// Policy Start Details

		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policystartdetails.selectRegion (strState);
		policystartdetails.selectLOB (strHomeLob);
		policystartdetails.typeAgent (strEnvironmentName, strCompany, strClientState, strSubCompany);
		TransactionTimer.start (stopwatch);
		TransactionTimer.stop (stopwatch, "Preliminary Questions", driver, strEnvironmentName);

		// Preliminary Questions
		// Ever been declared bankrupt
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policypreliminaryquestions.selectHomePreliminaryQuestions (strRegion);
		TransactionTimer.start (stopwatch);
		policypreliminaryquestions.clickProceedButton ();
		TransactionTimer.stop (stopwatch, "Policy Property Hub", driver, strEnvironmentName);

		// Policy Property Hub
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policypropertyHub.selectRiskType (strHomeRiskType);
		policypropertyHub.selectUseExistingAddress ();
		TransactionTimer.start (stopwatch);
		policypropertyHub.clickAddButton ();
		TransactionTimer.stop (stopwatch, "Policy residential Details", driver, strEnvironmentName);

		// Policy Residential Details
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policyresidentialdetails.selectRiskDetails (strRegionValue);
		TransactionTimer.start (stopwatch);
		policyresidentialdetails.clickProceedNext ();
		TransactionTimer.stop (stopwatch, "Policy Property Hub", driver, strEnvironmentName);

		// Policy Property Hub
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		policypropertyHub.clickProceedNext ();
		TransactionTimer.stop (stopwatch, "Policy Losses", driver, strEnvironmentName);

		// Policy Losses
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		policylosses.clickProceedNext ();
		TransactionTimer.stop (stopwatch, "Policy Coverages", driver, strEnvironmentName);

		// Policy Coverage's
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policycoverages.selectCoverages (strRegion);
		policycoverages.clickCalculateButton ();
		policycoverages.checkPremium ();
		TransactionTimer.start (stopwatch);
		policycoverages.clickProceedNext ();
		TransactionTimer.stop (stopwatch, "Policy Summary", driver, strEnvironmentName);

		// Policy Summary
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		String strBillPlan = policysummary.returnBillPlan (strCompany, strEnvironmentName, strSubCompany);
		policysummary.selectBillPlan (strBillPlan);
		policysummary.clickSelectButton ();
		policysummary.checkQutoePolicyNo ();
		String strPolicyNumber = control.getQuotePolicyNumber ();
		TransactionTimer.start (stopwatch);
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		actionspanel.clickCompleteQuote ();
		TransactionTimer.stop (stopwatch, "Complete Quote", driver, strEnvironmentName);

		// Home Screen
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickOnDesktop ();
		TransactionTimer.stop (stopwatch, "Loading Desktop", driver, strEnvironmentName);

		clientsummary.searchIncompleteTrancation (strPolicyNumber, strEnvironmentName);

		navigationpanel.expandBOCommunicationSpan ();
		navigationpanel.clickManageCorrespondence ();

		managecorrespondence.selectRandomDocuments ();
		managecorrespondence.clickView ();
		managecorrespondence.typeDocumentName ();
		managecorrespondence.closeDocument ();

		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}

}
