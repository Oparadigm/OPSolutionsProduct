package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomNumbers;
import com.innovation.pages.claim.objects.OR_ClaimLogPaymentParty;

/*
 * @author  Kamal - this class stores all the locators and methods on Party frame in Claims BO Log Payment flow.
 * 
 */

public class ClaimLogPaymentParty
{
	WebDriver				driver;
	OR_ClaimLogPaymentParty	orClaimLogPaymentParty	= null;

	public ClaimLogPaymentParty (WebDriver driver)
	{
		this.driver = driver;
		orClaimLogPaymentParty = PageFactory.initElements (driver, OR_ClaimLogPaymentParty.class);
	}

	// Pass party name to select or 'Random' to select a party randomly
	public void selectPaymentParty (String strPaymentParty)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentParty.ddlSelectParty));

		if (strPaymentParty.equalsIgnoreCase ("Random"))
		{
			orClaimLogPaymentParty.ddlSelectParty.click ();
			Select oPaymentParty = new Select (orClaimLogPaymentParty.ddlSelectParty);
			List<WebElement> selections = oPaymentParty.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oPaymentParty.selectByIndex (intIndex);
			orClaimLogPaymentParty.ddlSelectParty.click ();
		}
		else
		{
			orClaimLogPaymentParty.ddlSelectParty.click ();
			orClaimLogPaymentParty.ddlSelectParty.sendKeys (strPaymentParty);
			orClaimLogPaymentParty.ddlSelectParty.click ();
		}

	}

}
