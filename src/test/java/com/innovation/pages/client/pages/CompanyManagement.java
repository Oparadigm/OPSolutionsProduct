package com.innovation.pages.client.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.client.objects.OR_CompanyManagement;

/**
 * @author haiderm - This class will store all the locators and methods of the Agent Company Management screen
 */

public class CompanyManagement
{

	WebDriver				driver;
	OR_CompanyManagement	orCompanyManagement	= null;

	public CompanyManagement (WebDriver driver)
	{
		this.driver = driver;
		orCompanyManagement = PageFactory.initElements (driver, OR_CompanyManagement.class);
	}

	// Agent No
	public void typeAgent (String strAgentNo)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.txtAgent));
		orCompanyManagement.txtAgent.click ();
		orCompanyManagement.txtAgent.sendKeys (strAgentNo);
	}

	// Suffix
	public void selectSuffix (String strSuffix)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.ddlSuffix));
		orCompanyManagement.ddlSuffix.click ();
		Select oSuffix = new Select (orCompanyManagement.ddlSuffix);
		oSuffix.selectByVisibleText (strSuffix);
	}

	// Suffix Search Icon
	public void clickSuffixSearchIcon ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.imgSuffixSearch));
		orCompanyManagement.imgSuffixSearch.click ();
	}

	// Add
	public void clickCompanyAddButton ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.btnCompanyAdd));
		orCompanyManagement.btnCompanyAdd.click ();
	}

	// Company
	public void selectCompany (String strSelectCompany, String strRegion, String strSelectState) throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.ddlCompany));
		orCompanyManagement.imgCompany.click ();
		Thread.sleep (1000);
		orCompanyManagement.ddlCompany.sendKeys (strSelectCompany);
		Thread.sleep (1000);
		orCompanyManagement.ddlCompany.click ();

		orCompanyManagement.ddlCompany.sendKeys (Keys.ENTER);

		// This catch is to deal with region being specific on configuration
		try
		{

			boolean blnIsStateVisible = orCompanyManagement.imgState.isDisplayed ();
			WebDriverWait wait1 = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait1.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.ddlState));
			orCompanyManagement.imgState.click ();
			orCompanyManagement.ddlState.sendKeys (strSelectState);
			orCompanyManagement.ddlState.click ();
			orCompanyManagement.ddlState.sendKeys (Keys.ENTER);

		}
		catch (NoSuchElementException ignored)
		{

		}

	}

	// State
	public void selectState (String strSelectState)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.ddlState));
		orCompanyManagement.imgState.click ();
		orCompanyManagement.ddlState.sendKeys (strSelectState);
		orCompanyManagement.ddlState.click ();
		orCompanyManagement.ddlState.sendKeys (Keys.ENTER);

	}

	// Branch
	public void selectBranch (String strSelectBranch) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.ddlBranch));
		orCompanyManagement.imgBranch.click ();
		Thread.sleep (1000);
		orCompanyManagement.ddlBranch.sendKeys (strSelectBranch);
		orCompanyManagement.ddlBranch.click ();
		orCompanyManagement.ddlBranch.sendKeys (Keys.ENTER);

	}

	// Comscale
	public void selectComscale (String strSelectComscale)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.ddlComscale));
		orCompanyManagement.ddlBranch.click ();
		Select oSelectComscale = new Select (orCompanyManagement.ddlComscale);
		oSelectComscale.selectByVisibleText (strSelectComscale);
	}

	// Policy process
	public void selectPolicyProcess (String strSelectPolicyProcess)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.ddlPolicyProcess));
		orCompanyManagement.ddlPolicyProcess.click ();
		Select oSelectPolicyProcess = new Select (orCompanyManagement.ddlPolicyProcess);
		oSelectPolicyProcess.selectByVisibleText (strSelectPolicyProcess);
	}

	// Active from
	public void typeCompanyActiveFrom (String strRegion)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.dtpCompanyActiveFrom));
		orCompanyManagement.dtpCompanyActiveFrom.click ();
		orCompanyManagement.dtpCompanyActiveFrom.sendKeys (CalenderDate.returnDesiredDate (strRegion, -5, 0, 0));
	}

	// Run off indicator
	public void selectRunOffIndicator (String strRunOffIndicator)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.ddlRunOffIndicator));
		orCompanyManagement.ddlRunOffIndicator.click ();
		Select oRunOffIndicator = new Select (orCompanyManagement.ddlRunOffIndicator);
		oRunOffIndicator.selectByVisibleText (strRunOffIndicator);
	}

	// Overriding suffix
	public void selectOverridingAgentSuffix (String strOverridingAgent)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.ddlOverridingAgentSuffix));
		orCompanyManagement.ddlOverridingAgentSuffix.click ();
		Select oOverridingAgent = new Select (orCompanyManagement.ddlOverridingAgentSuffix);
		oOverridingAgent.selectByVisibleText (strOverridingAgent);
	}

	// Add Company details
	public void clickCompanyDetailAddButton ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orCompanyManagement.btnCompanyDetailAdd));
		orCompanyManagement.btnCompanyDetailAdd.click ();
	}

}
