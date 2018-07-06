package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.TableHandler;
import com.innovation.pages.policy.objects.OR_PolicyAgentSearch;

/*@Author Kamran Mahmood - This will contains methods of Agent search screen
 * 
 */
public class PolicyAgentSearch
{
	WebDriver				driver;
	LoggingControl			loggingcontrol		= new LoggingControl ();
	OR_PolicyAgentSearch	orPolicyAgentSearch	= null;

	public PolicyAgentSearch (WebDriver driver)
	{
		this.driver = driver;
		orPolicyAgentSearch = PageFactory.initElements (driver, OR_PolicyAgentSearch.class);
	}

	public void typeLastName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.txtLastNameField));
		orPolicyAgentSearch.txtLastNameField.click ();
		orPolicyAgentSearch.txtLastNameField.sendKeys (RandomLetters.produceRandomString (5));
	}

	public void typeFirstName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.txtFirstNameField));
		orPolicyAgentSearch.txtFirstNameField.click ();
		orPolicyAgentSearch.txtFirstNameField.sendKeys (RandomLetters.produceRandomString (5));

	}

	public void clickNameContactRadioButton ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.rdnameContact));
		orPolicyAgentSearch.rdnameContact.click ();

	}

	public void clickReferenceNumberRadioButton ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.rdreferencenumber));
		orPolicyAgentSearch.rdreferencenumber.click ();

	}

	public void typeCompanyName ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable ((orPolicyAgentSearch.txtCompanyNameField)));

		orPolicyAgentSearch.txtCompanyNameField.click ();
		orPolicyAgentSearch.txtCompanyNameField.sendKeys (RandomLetters.produceRandomString (3));

	}

	public void typeTownCity ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.txtTownField));
		orPolicyAgentSearch.txtTownField.click ();
		orPolicyAgentSearch.txtTownField.sendKeys (RandomLetters.produceRandomString (4));

	}

	public void typePostCode ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.txtZipCodeField));
		orPolicyAgentSearch.txtZipCodeField.click ();
		orPolicyAgentSearch.txtZipCodeField.sendKeys (RandomNumbers.produceRandomNumber (3));

	}

	public void typeContactNumber ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.txtContactNumberField));
		orPolicyAgentSearch.txtContactNumberField.click ();
		orPolicyAgentSearch.txtContactNumberField.sendKeys (RandomNumbers.produceRandomNumber (9));
	}

	public void clickSearchButton ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.btnSearch));
		// Actions searchButton = new Actions (driver);
		// searchButton.moveToElement (orPolicyAgentSearch.btnSearch).click ().perform ();
		orPolicyAgentSearch.btnSearch.click ();
	}

	public void clickClearButton ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.btnClear));
		orPolicyAgentSearch.btnClear.click ();

	}

	public void typeAgentNumber (String strAgent)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.txtAgnetNumberField));
		orPolicyAgentSearch.txtAgnetNumberField.click ();
		orPolicyAgentSearch.txtAgnetNumberField.sendKeys (strAgent);

	}

	public void typeGroupCode (String strGroupCode)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.txtGroupCodeField));
		orPolicyAgentSearch.txtGroupCodeField.click ();
		orPolicyAgentSearch.txtGroupCodeField.sendKeys (strGroupCode);

	}

	public void selectAgentType (String strAgentType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.ddlAgentType));
		orPolicyAgentSearch.ddlAgentType.click ();

		Select oAgentType = new Select (orPolicyAgentSearch.ddlAgentType);
		oAgentType.selectByVisibleText (strAgentType);

	}

	public void typeAgentGroupCode (String strAgentGroupCode)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.txtGroupCode));
		orPolicyAgentSearch.txtGroupCode.click ();
		orPolicyAgentSearch.txtGroupCode.sendKeys (strAgentGroupCode);

	}

	public void clickAssignButton ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.btnAssign));
		orPolicyAgentSearch.btnAssign.click ();

	}

	public void selectClientRow ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		load.until (ExpectedConditions.invisibilityOf (orPolicyAgentSearch.barProgress));
		String strCompanyName = orPolicyAgentSearch.txtCompanyNameField.getAttribute ("value");
		wait.until (ExpectedConditions.textToBePresentInElement (orPolicyAgentSearch.tbClientList, strCompanyName));

		// This will create a new instance of TableHandler class and click on desired row
		TableHandler selectRownfromTable = new TableHandler (driver);
		strCompanyName.trim ();
		String strTableName = "tblClientList".trim ();
		selectRownfromTable.returnRowInTable (strTableName, strCompanyName);

	}

	public void clickNewCompany ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgentSearch.btnNewCompany));
		orPolicyAgentSearch.btnNewCompany.click ();

	}

}
