package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.RandomNumbers;
import com.innovation.pages.claim.objects.OR_ClaimLogPaymentClaimPayment;
import com.innovation.pages.common.objects.OR_ControlPanel;

/*@author  Kamal - this class stores all the locators and methods on Claim payment frame in Claims BO Log Payment flow. 
 * 
 */

public class ClaimLogPaymentClaimPayment
{
	WebDriver						driver;
	OR_ClaimLogPaymentClaimPayment	orClaimLogPaymentClaimPayment	= null;
	OR_ControlPanel					orControlPanel					= null;

	public ClaimLogPaymentClaimPayment (WebDriver driver)
	{
		this.driver = driver;
		orClaimLogPaymentClaimPayment = PageFactory.initElements (driver, OR_ClaimLogPaymentClaimPayment.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	public void selectPaymentMethod (String strPaymentMethod)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.ddlPaymentMethod));

		orClaimLogPaymentClaimPayment.ddlPaymentMethod.click ();
		Select oPMethod = new Select (orClaimLogPaymentClaimPayment.ddlPaymentMethod);
		oPMethod.selectByVisibleText (strPaymentMethod);
		orClaimLogPaymentClaimPayment.ddlPaymentMethod.click ();

	}

	// Selects account number when payment method has been selected as BACS
	public void selectAccountNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.ddlAccountNoBACS));

		Select oAccountNo = new Select (orClaimLogPaymentClaimPayment.ddlAccountNoBACS);

		List<WebElement> selections = oAccountNo.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oAccountNo.selectByIndex (intIndex);

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	public void selectDeliveryMethod ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.ddlDeliveryMethod));

		Select oDeliveryMethod = new Select (orClaimLogPaymentClaimPayment.ddlDeliveryMethod);
		List<WebElement> selections = oDeliveryMethod.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oDeliveryMethod.selectByIndex (intIndex);
	}

	public void typeAccountNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		if (orClaimLogPaymentClaimPayment.txtAccountNo.isEnabled ())
		{
			wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.txtAccountNo));

			orClaimLogPaymentClaimPayment.txtAccountNo.click ();
			orClaimLogPaymentClaimPayment.txtAccountNo.sendKeys (RandomNumbers.produceRandomNumber (8));

		}
	}

	public void typeChequeNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.txtChequeNo));

		orClaimLogPaymentClaimPayment.txtChequeNo.click ();
		orClaimLogPaymentClaimPayment.txtChequeNo.sendKeys (RandomNumbers.produceRandomNumber (8));
	}

	public void typeChequeDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.dtpChequeDate));
		orClaimLogPaymentClaimPayment.dtpChequeDate.click ();
		orClaimLogPaymentClaimPayment.dtpChequeDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typeFromDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.dtpFromDate));
		orClaimLogPaymentClaimPayment.dtpFromDate.click ();
		orClaimLogPaymentClaimPayment.dtpFromDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typeToDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.dtpToDate));
		orClaimLogPaymentClaimPayment.dtpToDate.click ();
		orClaimLogPaymentClaimPayment.dtpToDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typeReferenceId ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.txtReferenceId));

		orClaimLogPaymentClaimPayment.txtReferenceId.click ();
		orClaimLogPaymentClaimPayment.txtReferenceId.sendKeys ("REF" + RandomNumbers.produceRandomNumber (4));
	}

	public void typeInvoiceId ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.txtInvoiceId));

		orClaimLogPaymentClaimPayment.txtInvoiceId.click ();
		orClaimLogPaymentClaimPayment.txtInvoiceId.sendKeys ("INV" + RandomNumbers.produceRandomNumber (4));
	}

	public void typeMemo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.txaMemo));

		orClaimLogPaymentClaimPayment.txaMemo.click ();
		orClaimLogPaymentClaimPayment.txaMemo.sendKeys (
				"This memo detail is being added as random text: " + RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	public void clickMoreDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.btnMoreDetails));
		orClaimLogPaymentClaimPayment.btnMoreDetails.click ();
	}

	public void typeServiceDescription ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.txtServiceDescription));

		orClaimLogPaymentClaimPayment.txtServiceDescription.click ();
		orClaimLogPaymentClaimPayment.txtServiceDescription.sendKeys ("SD " + RandomLetters.produceRandomString (5));
	}

	public void typePaymentDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.dtpPaymentDate));
		orClaimLogPaymentClaimPayment.dtpPaymentDate.click ();
		orClaimLogPaymentClaimPayment.dtpPaymentDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typeAmountClaimed (String srtAmountClaimed)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.txtAmountClaimed));

		orClaimLogPaymentClaimPayment.txtAmountClaimed.click ();
		orClaimLogPaymentClaimPayment.txtAmountClaimed.sendKeys (srtAmountClaimed);
	}

	public void clickAddPaymentDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentClaimPayment.btnAddPaymentDetails));
		orClaimLogPaymentClaimPayment.btnAddPaymentDetails.click ();
	}

}
