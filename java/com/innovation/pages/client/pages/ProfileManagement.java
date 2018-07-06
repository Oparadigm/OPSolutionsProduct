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
import com.innovation.pages.client.objects.OR_ProfileManagement;

/**
 * @author haiderm - This class will store all the locators and methods of the Agent Profile Management screen
 */

public class ProfileManagement
{

	WebDriver				driver;
	OR_ProfileManagement	orProfileManagement	= null;

	public ProfileManagement (WebDriver driver)
	{
		this.driver = driver;
		orProfileManagement = PageFactory.initElements (driver, OR_ProfileManagement.class);
	}

	// Agent No
	public void typeAgent (String strAgentNo)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orProfileManagement.txtAgent));
		orProfileManagement.txtAgent.click ();
		orProfileManagement.txtAgent.sendKeys (strAgentNo);
	}

	// Suffix
	public void selectSuffix (String strSuffix)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orProfileManagement.ddlSuffix));
		orProfileManagement.ddlSuffix.click ();
		Select oSuffix = new Select (orProfileManagement.ddlSuffix);
		oSuffix.selectByVisibleText (strSuffix);
	}

	// Suffix Search Icon
	public void clickSuffixSearchIcon ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orProfileManagement.imgSuffixSearch));
		orProfileManagement.imgSuffixSearch.click ();
	}

	// Add
	public void clickProfileAddButton ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orProfileManagement.btnProfileAdd));
		orProfileManagement.btnProfileAdd.click ();
	}

	// Company
	public void selectCompany (String strSelectCompany, String strRegion, String strSelectState) throws InterruptedException
	{
		// GlobalWaitTime.setIntWaitTime (80);
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orProfileManagement.ddlCompany));
		orProfileManagement.imgCompany.click ();
		Thread.sleep (2000);
		orProfileManagement.ddlCompany.sendKeys (strSelectCompany);
		Thread.sleep (2000);
		orProfileManagement.ddlCompany.click ();
		orProfileManagement.ddlCompany.sendKeys (Keys.ENTER);

		try
		{

			boolean blnIsStateVisible = orProfileManagement.imgRegion.isDisplayed ();
			WebDriverWait wait1 = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait1.until (ExpectedConditions.elementToBeClickable (orProfileManagement.ddlRegion));
			orProfileManagement.imgRegion.click ();
			orProfileManagement.ddlRegion.sendKeys (strSelectState);
			orProfileManagement.ddlRegion.click ();
			orProfileManagement.ddlRegion.sendKeys (Keys.ENTER);

		}
		catch (NoSuchElementException ignored)
		{

		}

	}

	// Region
	public void selectRegion (String strSelectState)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orProfileManagement.ddlRegion));
		orProfileManagement.imgRegion.click ();
		orProfileManagement.ddlRegion.sendKeys (strSelectState);
		orProfileManagement.ddlRegion.click ();
		orProfileManagement.ddlRegion.sendKeys (Keys.ENTER);
	}

	// Active from
	public void typeProfileActiveFrom (String strRegion)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orProfileManagement.dtpProfileActiveFrom));
		orProfileManagement.dtpProfileActiveFrom.click ();
		orProfileManagement.dtpProfileActiveFrom.sendKeys (CalenderDate.returnDesiredDate (strRegion, -5, 0, 0));
	}

	// Profile
	public void selectProfile (String strSelectProfile)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orProfileManagement.ddlProfile));
		orProfileManagement.ddlProfile.click ();
		Select oSelectProfile = new Select (orProfileManagement.ddlProfile);
		oSelectProfile.selectByVisibleText (strSelectProfile);
	}

	// Add Profile details
	public void clickProfileDetailAssign ()
	{
		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		load.until (ExpectedConditions.invisibilityOf (orProfileManagement.prgProgressBar));

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orProfileManagement.btnProfileDetailAssign));
		orProfileManagement.btnProfileDetailAssign.click ();

	}

}
