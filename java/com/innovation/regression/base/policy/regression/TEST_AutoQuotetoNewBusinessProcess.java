package com.innovation.regression.base.policy.regression;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innovation.configuration.DriverManager;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.InsurerSetup;
import com.innovation.misc.RandomNumbers;
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
import com.innovation.pages.common.pages.PreviousSessionWorkItems;
import com.innovation.pages.policy.pages.PolicyBillingDetails;
import com.innovation.pages.policy.pages.PolicyClientSearch;
import com.innovation.pages.policy.pages.PolicyCoverages;
import com.innovation.pages.policy.pages.PolicyDriverDetails;
import com.innovation.pages.policy.pages.PolicyDriverUsage;
import com.innovation.pages.policy.pages.PolicyHouseholdMembers;
import com.innovation.pages.policy.pages.PolicyPreliminaryQuestions;
import com.innovation.pages.policy.pages.PolicyStartDetails;
import com.innovation.pages.policy.pages.PolicySummary;
import com.innovation.pages.policy.pages.PolicyVehicleHub;
import com.innovation.pages.policy.pages.QuoteSummary;

/**
 * @author M.Tahir- Regression test script covering UK Add Client and Add Policy
 *
 */

public class TEST_AutoQuotetoNewBusinessProcess extends DriverManager
{

	@Parameters({ "strBrowser", "strEnvironmentName", "strEnvironmentBrand", "strRegionValue", "strState", "strCompany", "strClientState", "strSubCompany",
			"strRiskType", "strAutoLob" })
	@Test

	public void AutoQuotetoNewBusinessProcess (@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName,

			@Optional("Model Office UK") String strEnvironmentBrand, @Optional("UK") String strRegionValue, @Optional("United Kingdom") String strState,

			@Optional("8880") String strCompany, @Optional("GB") String strClientState, @Optional("880") String strSubCompany,
			@Optional("Car") String strRiskType, @Optional("Automobile - UK Auto") String strAutoLob) throws Exception

	{

		// Variables used in this scenario
		String strSelectBrand = strEnvironmentBrand;
		String strURL = "URL";
		String strUrlXML = "UrlBrowser.xml";
		String strLoginElement = "user";
		String strLoginNodeUsername = "username";
		String strLoginNodePassword = "password";
		String strLoginXMLFileName = "UserName.xml";
		String strBankAccount = "Bank Account";
		String strAccountNumber = RandomNumbers.produceRandomNumber (8);
		String strSortCode = "000099";
		String strReceipt = "cash";

		// Setup
		// Navigate to 1insurer Application

		WebDriver driver = getDriver (strBrowser);
		InsurerSetup setup = new InsurerSetup (driver);
		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);

		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
		LoginPage login = new LoginPage (driver);
		PreviousSessionWorkItems previoussessionworkitems = new PreviousSessionWorkItems (driver);
		ChangeBrand brandscheme = new ChangeBrand (driver);
		HomeScreen home = new HomeScreen (driver);
		PolicyClientSearch policyclientsearch = new PolicyClientSearch (driver);
		AddIndividualClient addIndividualclient = new AddIndividualClient (driver);
		ActionsPanel actionspanel = new ActionsPanel (driver);
		PolicyStartDetails policystartdetails = new PolicyStartDetails (driver);
		PolicyHouseholdMembers policyhouseholds = new PolicyHouseholdMembers (driver);
		PolicyPreliminaryQuestions policypreliminaryquestions = new PolicyPreliminaryQuestions (driver);
		PolicyDriverDetails policydriver = new PolicyDriverDetails (driver);
		ClientSummary clientsummary = new ClientSummary (driver);
		PolicyVehicleHub policyvehicle = new PolicyVehicleHub (driver);
		PolicyDriverUsage driverusage = new PolicyDriverUsage (driver);
		PolicyCoverages policycoverages = new PolicyCoverages (driver);
		PolicySummary policysummary = new PolicySummary (driver);
		ControlPanel control = new ControlPanel (driver);
		QuoteSummary quotesummary = new QuoteSummary (driver);
		PolicyBillingDetails billingdetails = new PolicyBillingDetails (driver);
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
		previoussessionworkitems.clickRestoreAllAndApply ();

		// // Change Brand
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.clickChangeBrand ();
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.selectBrand (strSelectBrand);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		brandscheme.saveBrand ();
		TransactionTimer.stop (stopwatch, "Desktop", driver, strEnvironmentName);

		// Enter Search
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		home.clickOnSearch ();
		home.clickOnPolicyClientSearch ();
		TransactionTimer.stop (stopwatch, "Policy Client Search", driver, strEnvironmentName);

		// Policy Client Search
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policyclientsearch.typeClientLastName ();
		policyclientsearch.typeClientFirstName ();
		policyclientsearch.typeClientZipCode ("S");
		policyclientsearch.clickSearchButton ();
		TransactionTimer.start (stopwatch);
		policyclientsearch.clickNewIndividualButton ();
		TransactionTimer.stop (stopwatch, "Add Individual Client", driver, strEnvironmentName);

		// Add Individual Client
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		addIndividualclient.selectTitle ();
		addIndividualclient.typeEmail ();
		addIndividualclient.typeHomePhoneNo ();
		addIndividualclient.typeZIPCode (strRegionValue);
		addIndividualclient.clickZipCodeSearchIcon ();
		addIndividualclient.SearchCriteriaDropDown ();
		addIndividualclient.typeDOB (strRegionValue);
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
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		actionspanel.clickAddQuote ();
		TransactionTimer.stop (stopwatch, "Policy Start Details", driver, strEnvironmentName);

		// Policy Start Details

		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policystartdetails.selectRegion (strState);
		policystartdetails.selectLOB (strAutoLob);
		policystartdetails.typeAgent (strEnvironmentName, strCompany, strClientState, strSubCompany);
		TransactionTimer.start (stopwatch);
		TransactionTimer.stop (stopwatch, "HouseholdMembers", driver, strEnvironmentName);

		// Household Members
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policyhouseholds.checkHouseHold ();
		TransactionTimer.start (stopwatch);
		TransactionTimer.stop (stopwatch, "Preliminary Questions", driver, strEnvironmentName);

		// Preliminary Questions
		// Accident Losses
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);

		// Bank Corrupt
		policypreliminaryquestions.selectAutoPreliminaryQuestions (strRegionValue);

		// Continue
		TransactionTimer.start (stopwatch);
		policypreliminaryquestions.clickProceedButton ();
		TransactionTimer.stop (stopwatch, "Policy Drivers Hub", driver, strEnvironmentName);

		// Save As Incomplete on Policy Driver Hub
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		// This string has a quote policy number of a transaction
		String strQuotePolicyNumber = control.getQuotePolicyNumber ();
		actionspanel.clickSaveAsIncomplete ();

		// Enter the Incomplete Transaction Number in the GlobalSearch
		clientsummary.searchIncompleteTrancation (strQuotePolicyNumber, strEnvironmentName);

		TransactionTimer.stop (stopwatch, "Client Summary", driver, strEnvironmentName);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		// Incomplete Quote/Policy Summary Screen
		policysummary.checkQutoePolicyStatus ();
		// Validate the Incomplete Quote
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		quotesummary.checkQuoteValidationIssues ();

		// Policy Driver Hub
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		policydriver.checkDriverList (strEnvironmentBrand);
		TransactionTimer.stop (stopwatch, "Policy Vehicle Hub", driver, strEnvironmentName);

		// // Policy Vehicle Hub
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		policyvehicle.checkVehicleExists (strRiskType);
		policyvehicle.performVehicleSearch (strRegionValue);
		policyvehicle.enterVehicleDetails (strRegionValue);
		TransactionTimer.stop (stopwatch, "Vehicle List", driver, strEnvironmentName);
		control.clickNext ();
		// Vehicle List
		TransactionTimer.start (stopwatch);
		control.clickNext ();
		policyvehicle.validateGarageLocationError (strRegionValue);
		TransactionTimer.stop (stopwatch, "Driver Usage", driver, strEnvironmentName);

		// // Driver Usage
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		driverusage.selectDriverType ();
		control.clickNext ();

		// // Policy Coverage's
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		policycoverages.selectAutoCoverages (strRegionValue);
		policycoverages.clickCalculateButton ();
		policycoverages.checkPremium ();
		TransactionTimer.start (stopwatch);
		policycoverages.clickProceedNext ();
		TransactionTimer.stop (stopwatch, "Policy/Quote Summary", driver, strEnvironmentName);

		// // Policy/Quote Summary
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		String strBillPlan = policysummary.returnBillPlan (strCompany, strEnvironmentName, strSubCompany);
		policysummary.selectBillPlan (strBillPlan);
		policysummary.clickSelectButton ();
		TransactionTimer.stop (stopwatch, "Policy Summary", driver, strEnvironmentName);
		actionspanel.clickBuy ();
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());

		control.clickNext ();
		TransactionTimer.stop (stopwatch, "Billing Details", driver, strEnvironmentName);

		// Billing Details
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		TransactionTimer.start (stopwatch);
		billingdetails.makePayment (strBillPlan, strBankAccount, strAccountNumber, strSortCode, strReceipt);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		control.clickNext ();

		// Billing Details Complete Transaction
		TransactionTimer.stop (stopwatch, "Commit Transaction", driver, strEnvironmentName);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		billingdetails.completeTransaction ();
		TransactionTimer.start (stopwatch);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		home.clickSignOut ();
		TransactionTimer.stop (stopwatch, "Sign Out", driver, strEnvironmentName);
		clearCookies (strBrowser);
		SeleniumPageCoverage.printPageCoverage ();

	}

}
