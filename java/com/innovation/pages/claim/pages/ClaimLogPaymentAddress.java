package com.innovation.pages.claim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimLogPaymentAddress;
import com.innovation.pages.common.objects.OR_ControlPanel;

/*@author  Kamal - this class stores all the locators and methods on Address frame in Claims BO Log Payment flow 
 * 
 */

public class ClaimLogPaymentAddress
{
	WebDriver					driver;
	OR_ClaimLogPaymentAddress	orClaimLogPaymentAddress	= null;
	OR_ControlPanel				orControlPanel				= null;

	public ClaimLogPaymentAddress (WebDriver driver)
	{
		this.driver = driver;
		orClaimLogPaymentAddress = PageFactory.initElements (driver, OR_ClaimLogPaymentAddress.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	public void selectPartyForAddress (String strRowText)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentAddress.tblPartyForAddress));

		// Calling function from TableHandler misc class to click on a row in
		// the table based on parameters. Pass table id from frame HTML into
		// strTableName parameter. strRowText parameter should be a cell's
		// unique value from the table to click on.
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.returnRowInTable ("tblPayeeList", strRowText);
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	public void selectPartyAddress ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentAddress.tblPartyAddress));

		// Calling function from TableHandler misc class to click on a random
		// row in the table
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.clickRandomTableRow ("CLM_SC_BO__AddressList");

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

}
