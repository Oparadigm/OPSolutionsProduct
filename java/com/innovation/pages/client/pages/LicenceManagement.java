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
import com.innovation.misc.RandomCount;
import com.innovation.misc.RandomNumbers;
import com.innovation.pages.client.objects.OR_LicenceManagement;

/**
 * @author haiderm - This class will store all the locators and methods of the Agent Licence Management screen
 */

public class LicenceManagement
{

	WebDriver				driver;
	OR_LicenceManagement	orLicenceManagement	= null;

	public LicenceManagement (WebDriver driver)
	{
		this.driver = driver;
		orLicenceManagement = PageFactory.initElements (driver, OR_LicenceManagement.class);
	}

	// Agent No
	public void typeAgent (String strAgentNo)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.txtAgent));
		orLicenceManagement.txtAgent.click ();
		orLicenceManagement.txtAgent.sendKeys (strAgentNo);
	}

	// Suffix
	public void selectSuffix (String strSuffix)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.ddlSuffix));
		orLicenceManagement.ddlSuffix.click ();
		Select oSuffix = new Select (orLicenceManagement.ddlSuffix);
		oSuffix.selectByVisibleText (strSuffix);
	}

	// Suffix Search Icon
	public void clickSuffixSearchIcon ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.imgSuffixSearch));
		orLicenceManagement.imgSuffixSearch.click ();
	}

	// Add
	public void clickLicenceAddButton ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.btnLicenceAdd));
		orLicenceManagement.btnLicenceAdd.click ();
	}

	// Company
	public void selectCompany (String strSelectCompany, String strRegion, String strSelectState) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.ddlCompany));
		orLicenceManagement.imgCompany.click ();
		Thread.sleep (1000);
		orLicenceManagement.ddlCompany.sendKeys (strSelectCompany);
		Thread.sleep (1000);
		orLicenceManagement.ddlCompany.click ();
		orLicenceManagement.ddlCompany.sendKeys (Keys.ENTER);

		try
		{

			boolean blnIsStateVisible = orLicenceManagement.imgRegion.isDisplayed ();
			WebDriverWait wait1 = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait1.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.ddlRegion));
			orLicenceManagement.imgRegion.click ();
			orLicenceManagement.ddlRegion.sendKeys (strSelectState);
			orLicenceManagement.ddlRegion.click ();
			orLicenceManagement.ddlRegion.sendKeys (Keys.ENTER);

		}
		catch (NoSuchElementException ignored)
		{

		}

	}

	// Region
	public void selectRegion (String strSelectRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.ddlRegion));
		orLicenceManagement.imgRegion.click ();
		orLicenceManagement.ddlRegion.sendKeys (strSelectRegion);
		orLicenceManagement.ddlRegion.click ();
		orLicenceManagement.ddlRegion.sendKeys (Keys.ENTER);
	}

	// Licence No

	public void typeLicenceNo ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.txtLicenceNo));
		orLicenceManagement.txtLicenceNo.click ();
		orLicenceManagement.txtLicenceNo.sendKeys (RandomNumbers.produceRandomNumber (9));
	}

	// Active from
	public void typeLicenceActiveFrom (String strRegion)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.dtpLicenceActiveFrom));
		orLicenceManagement.dtpLicenceActiveFrom.click ();
		orLicenceManagement.dtpLicenceActiveFrom.sendKeys (CalenderDate.returnDesiredDate (strRegion, -5, 0, 0));
	}

	// Active to
	public void typeLicenceActiveTo (String strRegion)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.dtpLicenceActiveTo));
		orLicenceManagement.dtpLicenceActiveTo.click ();
		orLicenceManagement.dtpLicenceActiveTo.sendKeys (CalenderDate.returnDesiredDate (strRegion, 1, 1, 5));

	}

	// Due date
	public void typeLicenceDueDate (String strRegion)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.dtpLicenceDueDate));
		orLicenceManagement.dtpLicenceDueDate.click ();
		orLicenceManagement.dtpLicenceDueDate.sendKeys (CalenderDate.returnDesiredDate (strRegion, 1, 1, 5));

	}

	// Paid
	public void selectPaid ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.ddlLicencePaid));
		orLicenceManagement.ddlLicencePaid.click ();
		Select oSelectPaid = new Select (orLicenceManagement.ddlLicencePaid);
		int intIndex = RandomCount.selectRandomItem (oSelectPaid);
		oSelectPaid.selectByIndex (intIndex);
	}

	// Fee
	public void typeFee ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.txtlicenceFee));
		orLicenceManagement.txtlicenceFee.click ();
		orLicenceManagement.txtlicenceFee.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	// CEU attained
	public void typeCEUattained ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.txtCEUattained));
		orLicenceManagement.txtCEUattained.click ();
		orLicenceManagement.txtCEUattained.sendKeys (RandomNumbers.produceRandomNumber (5));
	}

	// CEU required
	public void typeCEUrequired ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.txtCEUrequired));
		orLicenceManagement.txtCEUrequired.click ();
		orLicenceManagement.txtCEUrequired.sendKeys (RandomNumbers.produceRandomNumber (5));
	}

	// Cancellation date
	public void typeCancellationDate (String strRegion)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.dtpCancellationDate));
		orLicenceManagement.dtpCancellationDate.click ();
		orLicenceManagement.dtpCancellationDate.sendKeys (CalenderDate.returnDesiredDate (strRegion, 1, 2, 5));

	}

	// Add Licence details
	public void clickLicenceDetailAddButton ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLicenceManagement.btnLicenseDetailsAdd));
		orLicenceManagement.btnLicenseDetailsAdd.click ();
	}

}
