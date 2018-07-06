/**
 * 
 */
package com.innovation.pages.policy.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.DatabaseData;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.TableHandler;
import com.innovation.pages.policy.objects.OR_PolicyClientSearch;
import com.innovation.sql.client.ClientSQL;

/**
 * @author lushs
 *
 */
public class PolicyClientSearch
{

	WebDriver				driver;
	OR_PolicyClientSearch	orPolicyClientSearch	= null;

	public PolicyClientSearch (WebDriver driver)
	{
		this.driver = driver;
		orPolicyClientSearch = PageFactory.initElements (driver, OR_PolicyClientSearch.class);
	}

	public void typeClientLastName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyClientSearch.txtLastNameField));
		orPolicyClientSearch.txtLastNameField.click ();
		// This calls the RandomLetters Class, alter the size of the string by adjusting
		// the length integer
		orPolicyClientSearch.txtLastNameField.sendKeys (RandomLetters.produceRandomString (6));
	}

	public void typeClientFirstName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyClientSearch.txtFirstNameField));
		orPolicyClientSearch.txtFirstNameField.click ();
		// This calls the RandomLetters Class, alter the size of the string by adjusting
		// the length integer
		orPolicyClientSearch.txtFirstNameField.sendKeys (RandomLetters.produceRandomString (8));
	}

	public void typeClientZipCode (String strZipCode)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyClientSearch.txtZipCodeField));
		orPolicyClientSearch.txtZipCodeField.click ();
		orPolicyClientSearch.txtZipCodeField.sendKeys (strZipCode);
	}

	public void clickSearchButton ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyClientSearch.btnSearch));
		orPolicyClientSearch.btnSearch.click ();
	}

	public void clickNewIndividualButton ()
	{
		// This will wait for up to 10 seconds for the New Individual button to become
		// clickable.
		// As soon as the New Individual button becomes clickable the webdriver will
		// perform next action.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyClientSearch.btnNewIndividual));
		orPolicyClientSearch.btnNewIndividual.click ();
	}

	// public void searchExistingClient (String strFirstName, String strLastName, String strpostCode)
	//
	// {
	// // This function will search the existing client in the system by individual
	// // client first and surname with the
	// // other search criterias
	//
	// TableHandler tblClient = new TableHandler (driver);
	// WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
	// orPolicyClientSearch.txtFirstNameField.sendKeys (strFirstName);
	// orPolicyClientSearch.txtLastNameField.sendKeys (strLastName);
	//
	// orPolicyClientSearch.txtZipCodeField.sendKeys (strpostCode);
	// wait.until (ExpectedConditions.elementToBeClickable (orPolicyClientSearch.btnSearch));
	// orPolicyClientSearch.btnSearch.click ();
	//
	// wait.until (ExpectedConditions.invisibilityOf (orPolicyClientSearch.prgProgressBar));
	//
	// String strFullName = strFirstName + " " + strLastName;
	//
	// tblClient.returnRowInTable ("tblClientSearch", strFullName);
	//
	// wait.until (ExpectedConditions.elementToBeClickable (orPolicyClientSearch.btnViewClient));
	// orPolicyClientSearch.btnViewClient.click ();
	//
	// }

	public void searchExistingClients (String strEnvironmentName, String strCompany, String strState) throws Exception
	{
		TableHandler tblClient = new TableHandler (driver);
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		String strSQLQuery = ClientSQL.returnExistingClient (strCompany, strState);
		List<String> ClientName_DB = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		String strInsuredFirstName_DB = ClientName_DB.get (2);
		orPolicyClientSearch.txtFirstNameField.sendKeys (strInsuredFirstName_DB);
		String strInsuredLastName_DB = ClientName_DB.get (3);
		orPolicyClientSearch.txtLastNameField.sendKeys (strInsuredLastName_DB);

		String strPostCode_DB = ClientName_DB.get (4);
		orPolicyClientSearch.txtZipCodeField.sendKeys (strPostCode_DB);

		wait.until (ExpectedConditions.elementToBeClickable (orPolicyClientSearch.btnSearch));
		orPolicyClientSearch.btnSearch.click ();

		wait.until (ExpectedConditions.invisibilityOf (orPolicyClientSearch.prgProgressBar));

		String strFullName = strInsuredFirstName_DB + " " + strInsuredLastName_DB;
		tblClient.returnRowInTable ("tblClientSearch", strFullName);

		wait.until (ExpectedConditions.elementToBeClickable (orPolicyClientSearch.btnViewClient));
		orPolicyClientSearch.btnViewClient.click ();

	}

	public String selectExistingCompanyClients (String strEnvironmentName, String strCompany, String strState) throws Exception
	{

		String strSQLQuery = ClientSQL.returnExistingCompanyClient (strCompany, strState);
		List<String> CompanyClientName_DB = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		String strCompanyClientName_DB = CompanyClientName_DB.get (0);
		orPolicyClientSearch.txtCompanyField.sendKeys (strCompanyClientName_DB);

		String strCompanyClientPostCode_DB = CompanyClientName_DB.get (1);
		orPolicyClientSearch.txtZipCodeField.sendKeys (strCompanyClientPostCode_DB);

		return strCompanyClientName_DB;
	}

}
