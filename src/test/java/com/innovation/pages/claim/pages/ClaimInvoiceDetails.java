package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimInvoiceDetails;
import com.innovation.pages.common.objects.OR_ControlPanel;

/*
 * @author  Alamq - this class stores all the locators and methods on 'Invoice Management' frame accessible through BO Navigation panel > Supplier > Invoice Management  
 *  
 */

public class ClaimInvoiceDetails
{
	WebDriver				driver;
	LoggingControl			loggingcontrol			= new LoggingControl ();
	OR_ClaimInvoiceDetails	orClaimInvoiceDetails	= null;
	OR_ControlPanel			orControlPanel			= null;

	public ClaimInvoiceDetails (WebDriver driver)
	{
		this.driver = driver;
		orClaimInvoiceDetails = PageFactory.initElements (driver, OR_ClaimInvoiceDetails.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	public void typeEngineerInvoiceDetailFee ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailFee));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailFee.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailFee.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setEngineerInvoiceDetailFee (String txtEngineerInvoiceDetailFee)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailFee));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailFee.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailFee.sendKeys (txtEngineerInvoiceDetailFee);
	}

	public void typeEngineerInvoiceDetailPhotographs ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailPhotographs));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailPhotographs.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailPhotographs.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setEngineerInvoiceDetailPhotographs (String txtEngineerInvoiceDetailPhotographs)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailPhotographs));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailPhotographs.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailPhotographs.sendKeys (txtEngineerInvoiceDetailPhotographs);
	}

	public void typeEngineerInvoiceDetailMileageTravel ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailMileageTravel));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailMileageTravel.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailMileageTravel.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setEngineerInvoiceDetailMileageTravel (String txtEngineerInvoiceDetailMileageTravel)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailMileageTravel));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailMileageTravel.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailMileageTravel.sendKeys (txtEngineerInvoiceDetailMileageTravel);
	}

	public void typeEngineerInvoiceDetailOtherCosts ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailOtherCosts));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailOtherCosts.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailOtherCosts.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setEngineerInvoiceDetailOtherCosts (String txtEngineerInvoiceDetailOtherCosts)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailOtherCosts));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailOtherCosts.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailOtherCosts.sendKeys (txtEngineerInvoiceDetailOtherCosts);
	}

	public void typeEngineerInvoiceDetailContributions ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailContributions));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailContributions.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailContributions.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setEngineerInvoiceDetailContributions (String txtEngineerInvoiceDetailContributions)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailContributions));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailContributions.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailContributions.sendKeys (txtEngineerInvoiceDetailContributions);
	}

	public void typeEngineerInvoiceDetailTotalTax ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailTotalTax));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailTotalTax.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailTotalTax.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setEngineerInvoiceDetailTotalTax (String txtEngineerInvoiceDetailTotalTax)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailTotalTax));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailTotalTax.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailTotalTax.sendKeys (txtEngineerInvoiceDetailTotalTax);
	}

	public void typeEngineerInvoiceDetailTotalAmount ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailTotalAmount));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailTotalAmount.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailTotalAmount.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setEngineerInvoiceDetailTotalAmount (String txtEngineerInvoiceDetailTotalAmount)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailTotalAmount));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailTotalAmount.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailTotalAmount.sendKeys (txtEngineerInvoiceDetailTotalAmount);
	}

	public void typeEngineerInvoiceDetailNetPayableToVendor ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailNetPayableToVendor));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailNetPayableToVendor.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailNetPayableToVendor.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setEngineerInvoiceDetailNetPayableToVendor (String txtEngineerInvoiceDetailNetPayableToVendor)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtEngineerInvoiceDetailNetPayableToVendor));

		orClaimInvoiceDetails.txtEngineerInvoiceDetailNetPayableToVendor.click ();
		orClaimInvoiceDetails.txtEngineerInvoiceDetailNetPayableToVendor.sendKeys (txtEngineerInvoiceDetailNetPayableToVendor);
	}

	// select a random element from the list
	public void selectGlassInvoiceDetailPartType ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlGlassInvoiceDetailPartType));

		orClaimInvoiceDetails.ddlGlassInvoiceDetailPartType.click ();
		Select oGlassInvoiceDetailPartType = new Select (orClaimInvoiceDetails.ddlGlassInvoiceDetailPartType);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oGlassInvoiceDetailPartType.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oGlassInvoiceDetailPartType.selectByIndex (index);
	}

	// select a specified value
	public void selectGlassInvoiceDetailPartType (String ddlGlassInvoiceDetailPartType)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlGlassInvoiceDetailPartType));

		orClaimInvoiceDetails.ddlGlassInvoiceDetailPartType.click ();
		Select oGlassInvoiceDetailPartType = new Select (orClaimInvoiceDetails.ddlGlassInvoiceDetailPartType);
		oGlassInvoiceDetailPartType.selectByVisibleText (ddlGlassInvoiceDetailPartType);
	}

	public void typeGlassInvoiceDetailPartNumber ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailPartNumber));

		orClaimInvoiceDetails.txtGlassInvoiceDetailPartNumber.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailPartNumber.sendKeys (RandomLetters.produceRandomString (30));
	}

	// fill with specified text
	public void setGlassInvoiceDetailPartNumber (String txtGlassInvoiceDetailPartNumber)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailPartNumber));

		orClaimInvoiceDetails.txtGlassInvoiceDetailPartNumber.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailPartNumber.sendKeys (txtGlassInvoiceDetailPartNumber);
	}

	public void typeGlassInvoiceDetailLabourTotal ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailLabourTotal));

		orClaimInvoiceDetails.txtGlassInvoiceDetailLabourTotal.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailLabourTotal.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setGlassInvoiceDetailLabourTotal (String txtGlassInvoiceDetailLabourTotal)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailLabourTotal));

		orClaimInvoiceDetails.txtGlassInvoiceDetailLabourTotal.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailLabourTotal.sendKeys (txtGlassInvoiceDetailLabourTotal);
	}

	public void typeGlassInvoiceDetailPartsTotal ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailPartsTotal));

		orClaimInvoiceDetails.txtGlassInvoiceDetailPartsTotal.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailPartsTotal.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setGlassInvoiceDetailPartsTotal (String txtGlassInvoiceDetailPartsTotal)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailPartsTotal));

		orClaimInvoiceDetails.txtGlassInvoiceDetailPartsTotal.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailPartsTotal.sendKeys (txtGlassInvoiceDetailPartsTotal);
	}

	public void typeGlassInvoiceDetailOtherCosts ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailOtherCosts));

		orClaimInvoiceDetails.txtGlassInvoiceDetailOtherCosts.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailOtherCosts.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setGlassInvoiceDetailOtherCosts (String txtGlassInvoiceDetailOtherCosts)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailOtherCosts));

		orClaimInvoiceDetails.txtGlassInvoiceDetailOtherCosts.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailOtherCosts.sendKeys (txtGlassInvoiceDetailOtherCosts);
	}

	public void typeGlassInvoiceDetailContributions ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailContributions));

		orClaimInvoiceDetails.txtGlassInvoiceDetailContributions.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailContributions.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setGlassInvoiceDetailContributions (String txtGlassInvoiceDetailContributions)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailContributions));

		orClaimInvoiceDetails.txtGlassInvoiceDetailContributions.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailContributions.sendKeys (txtGlassInvoiceDetailContributions);
	}

	public void typeGlassInvoiceDetailTotalTax ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailTotalTax));

		orClaimInvoiceDetails.txtGlassInvoiceDetailTotalTax.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailTotalTax.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setGlassInvoiceDetailTotalTax (String txtGlassInvoiceDetailTotalTax)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailTotalTax));

		orClaimInvoiceDetails.txtGlassInvoiceDetailTotalTax.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailTotalTax.sendKeys (txtGlassInvoiceDetailTotalTax);
	}

	// click the checkbox
	public void clickGlassInvoiceDetailRegistered ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.chkGlassInvoiceDetailRegistered));

		orClaimInvoiceDetails.chkGlassInvoiceDetailRegistered.click ();
	}

	// select a specified state
	public void selectGlassInvoiceDetailRegistered (boolean selected)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.chkGlassInvoiceDetailRegistered));

		// only call the click method if the state requires a click
		if (selected && !orClaimInvoiceDetails.chkGlassInvoiceDetailRegistered.isSelected () ||
			!selected && orClaimInvoiceDetails.chkGlassInvoiceDetailRegistered.isSelected ())
			orClaimInvoiceDetails.chkGlassInvoiceDetailRegistered.click ();
	}

	public void typeGlassInvoiceDetailDeductible ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailDeductible));

		orClaimInvoiceDetails.txtGlassInvoiceDetailDeductible.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailDeductible.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setGlassInvoiceDetailDeductible (String txtGlassInvoiceDetailDeductible)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailDeductible));

		orClaimInvoiceDetails.txtGlassInvoiceDetailDeductible.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailDeductible.sendKeys (txtGlassInvoiceDetailDeductible);
	}

	// click the checkbox
	public void clickGlassInvoiceDetailApplicable ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.chkGlassInvoiceDetailApplicable));

		orClaimInvoiceDetails.chkGlassInvoiceDetailApplicable.click ();
	}

	// select a specified state
	public void selectGlassInvoiceDetailApplicable (boolean selected)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.chkGlassInvoiceDetailApplicable));

		// only call the click method if the state requires a click
		if (selected && !orClaimInvoiceDetails.chkGlassInvoiceDetailApplicable.isSelected () ||
			!selected && orClaimInvoiceDetails.chkGlassInvoiceDetailApplicable.isSelected ())
			orClaimInvoiceDetails.chkGlassInvoiceDetailApplicable.click ();
	}

	public void typeGlassInvoiceDetailTotalAmount ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailTotalAmount));

		orClaimInvoiceDetails.txtGlassInvoiceDetailTotalAmount.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailTotalAmount.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setGlassInvoiceDetailTotalAmount (String txtGlassInvoiceDetailTotalAmount)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailTotalAmount));

		orClaimInvoiceDetails.txtGlassInvoiceDetailTotalAmount.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailTotalAmount.sendKeys (txtGlassInvoiceDetailTotalAmount);
	}

	public void typeGlassInvoiceDetailNetPayableToVendor ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailNetPayableToVendor));

		orClaimInvoiceDetails.txtGlassInvoiceDetailNetPayableToVendor.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailNetPayableToVendor.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setGlassInvoiceDetailNetPayableToVendor (String txtGlassInvoiceDetailNetPayableToVendor)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtGlassInvoiceDetailNetPayableToVendor));

		orClaimInvoiceDetails.txtGlassInvoiceDetailNetPayableToVendor.click ();
		orClaimInvoiceDetails.txtGlassInvoiceDetailNetPayableToVendor.sendKeys (txtGlassInvoiceDetailNetPayableToVendor);
	}

	// select a random element from the list
	public void selectPayee ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlPayee));

		orClaimInvoiceDetails.ddlPayee.click ();
		Select oPayee = new Select (orClaimInvoiceDetails.ddlPayee);

		// Select a random Payee from the returned list
		List<WebElement> selections = oPayee.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oPayee.selectByIndex (index);
	}

	// select a specified value
	public void selectPayee (String ddlPayee)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlPayee));

		orClaimInvoiceDetails.ddlPayee.click ();
		Select oPayee = new Select (orClaimInvoiceDetails.ddlPayee);
		oPayee.selectByVisibleText (ddlPayee);
	}

	// select a random element from the list
	public void selectClaimant ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlClaimant));

		orClaimInvoiceDetails.ddlClaimant.click ();
		Select oClaimant = new Select (orClaimInvoiceDetails.ddlClaimant);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oClaimant.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oClaimant.selectByIndex (index);
	}

	// select a specified value
	public void selectClaimant (String ddlClaimant)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlClaimant));

		orClaimInvoiceDetails.ddlClaimant.click ();
		Select oClaimant = new Select (orClaimInvoiceDetails.ddlClaimant);
		oClaimant.selectByVisibleText (ddlClaimant);
	}

	public void typeInvNo ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtInvNo));

		orClaimInvoiceDetails.txtInvNo.sendKeys (RandomNumbers.produceRandomNumber (6));
	}

	// fill with specified text
	public void setInvNo (String txtInvNo)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtInvNo));

		orClaimInvoiceDetails.txtInvNo.click ();
		orClaimInvoiceDetails.txtInvNo.sendKeys (txtInvNo);
	}

	public void typeInvDate ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtInvDate));

		orClaimInvoiceDetails.txtInvDate.click ();
		orClaimInvoiceDetails.txtInvDate.sendKeys (RandomLetters.produceRandomString (999));
	}

	// fill with specified text
	public void setInvDate (String txtInvDate)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtInvDate));

		orClaimInvoiceDetails.txtInvDate.click ();
		orClaimInvoiceDetails.txtInvDate.sendKeys (txtInvDate);
	}

	public void typeInvRecDate ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtInvRecDate));

		orClaimInvoiceDetails.txtInvRecDate.click ();
		orClaimInvoiceDetails.txtInvRecDate.sendKeys (RandomLetters.produceRandomString (999));
	}

	// fill with specified text
	public void setInvRecDate (String txtInvRecDate)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtInvRecDate));

		orClaimInvoiceDetails.txtInvRecDate.click ();
		orClaimInvoiceDetails.txtInvRecDate.sendKeys (txtInvRecDate);
	}

	// select a random element from the list
	public void selectInvoiceType ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlInvoiceType));

		orClaimInvoiceDetails.ddlInvoiceType.click ();
		Select oInvoiceType = new Select (orClaimInvoiceDetails.ddlInvoiceType);

		// Select a random invoice Type from the returned list
		List<WebElement> selections = oInvoiceType.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oInvoiceType.selectByIndex (index);
	}

	// select a specified value
	public void selectInvoiceType (String ddlInvoiceType)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlInvoiceType));

		orClaimInvoiceDetails.ddlInvoiceType.click ();
		Select oInvoiceType = new Select (orClaimInvoiceDetails.ddlInvoiceType);
		oInvoiceType.selectByVisibleText (ddlInvoiceType);
	}

	public void typeInvNetTotal ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtInvNetTotal));

		orClaimInvoiceDetails.txtInvNetTotal.click ();
		orClaimInvoiceDetails.txtInvNetTotal.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setInvNetTotal (String txtInvNetTotal)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtInvNetTotal));

		orClaimInvoiceDetails.txtInvNetTotal.click ();
		orClaimInvoiceDetails.txtInvNetTotal.sendKeys (txtInvNetTotal);
	}

	public void typeInvGST ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtInvGST));

		orClaimInvoiceDetails.txtInvGST.click ();
		orClaimInvoiceDetails.txtInvGST.sendKeys (RandomLetters.produceRandomString (10));
	}

	// fill with specified text
	public void setInvGST (String txtInvGST)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtInvGST));

		orClaimInvoiceDetails.txtInvGST.click ();
		orClaimInvoiceDetails.txtInvGST.sendKeys (txtInvGST);
	}

	public void typeClaimItems ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtClaimItems));

		orClaimInvoiceDetails.txtClaimItems.click ();
		orClaimInvoiceDetails.txtClaimItems.sendKeys (RandomLetters.produceRandomString (999));
	}

	// fill with specified text
	public void setClaimItems (String txtClaimItems)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.txtClaimItems));

		orClaimInvoiceDetails.txtClaimItems.click ();
		orClaimInvoiceDetails.txtClaimItems.sendKeys (txtClaimItems);
	}

	// select a random element from the list
	public void selectInvoiceTypeClone ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlInvoiceTypeClone));

		orClaimInvoiceDetails.ddlInvoiceTypeClone.click ();
		Select oInvoiceTypeClone = new Select (orClaimInvoiceDetails.ddlInvoiceTypeClone);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oInvoiceTypeClone.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oInvoiceTypeClone.selectByIndex (index);
	}

	// select a specified value
	public void selectInvoiceTypeClone (String ddlInvoiceTypeClone)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlInvoiceTypeClone));

		orClaimInvoiceDetails.ddlInvoiceTypeClone.click ();
		Select oInvoiceTypeClone = new Select (orClaimInvoiceDetails.ddlInvoiceTypeClone);
		oInvoiceTypeClone.selectByVisibleText (ddlInvoiceTypeClone);
	}

	// select a random element from the list
	public void selectCLMSCBOInvoiceType ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlCLMSCBOInvoiceType));

		orClaimInvoiceDetails.ddlCLMSCBOInvoiceType.click ();
		Select oCLMSCBOInvoiceType = new Select (orClaimInvoiceDetails.ddlCLMSCBOInvoiceType);

		// Select a random InvoiceType from the returned list
		List<WebElement> selections = oCLMSCBOInvoiceType.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oCLMSCBOInvoiceType.selectByIndex (index);
	}

	// select a specified value
	public void selectCLMSCBOInvoiceType (String ddlCLMSCBOInvoiceType)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlCLMSCBOInvoiceType));

		orClaimInvoiceDetails.ddlCLMSCBOInvoiceType.click ();
		Select oCLMSCBOInvoiceType = new Select (orClaimInvoiceDetails.ddlCLMSCBOInvoiceType);
		oCLMSCBOInvoiceType.selectByVisibleText (ddlCLMSCBOInvoiceType);
	}

	// select a random element from the list
	public void selectCLMSCBOInvoiceTypeProperty ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlCLMSCBOInvoiceTypeProperty));

		orClaimInvoiceDetails.ddlCLMSCBOInvoiceTypeProperty.click ();
		Select oCLMSCBOInvoiceTypeProperty = new Select (orClaimInvoiceDetails.ddlCLMSCBOInvoiceTypeProperty);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oCLMSCBOInvoiceTypeProperty.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oCLMSCBOInvoiceTypeProperty.selectByIndex (index);
	}

	// select a specified value
	public void selectCLMSCBOInvoiceTypeProperty (String ddlCLMSCBOInvoiceTypeProperty)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlCLMSCBOInvoiceTypeProperty));

		orClaimInvoiceDetails.ddlCLMSCBOInvoiceTypeProperty.click ();
		Select oCLMSCBOInvoiceTypeProperty = new Select (orClaimInvoiceDetails.ddlCLMSCBOInvoiceTypeProperty);
		oCLMSCBOInvoiceTypeProperty.selectByVisibleText (ddlCLMSCBOInvoiceTypeProperty);
	}

	// select a random element from the list
	public void selectCLMSCBOSatisfactionRating ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlCLMSCBOSatisfactionRating));

		orClaimInvoiceDetails.ddlCLMSCBOSatisfactionRating.click ();
		Select oCLMSCBOSatisfactionRating = new Select (orClaimInvoiceDetails.ddlCLMSCBOSatisfactionRating);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oCLMSCBOSatisfactionRating.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oCLMSCBOSatisfactionRating.selectByIndex (index);
	}

	// select a specified value
	public void selectCLMSCBOSatisfactionRating (String ddlCLMSCBOSatisfactionRating)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlCLMSCBOSatisfactionRating));

		orClaimInvoiceDetails.ddlCLMSCBOSatisfactionRating.click ();
		Select oCLMSCBOSatisfactionRating = new Select (orClaimInvoiceDetails.ddlCLMSCBOSatisfactionRating);
		oCLMSCBOSatisfactionRating.selectByVisibleText (ddlCLMSCBOSatisfactionRating);
	}

	public void typeCLMSCBOAdditionalFeedback ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.taCLMSCBOAdditionalFeedback));

		orClaimInvoiceDetails.taCLMSCBOAdditionalFeedback.click ();
		orClaimInvoiceDetails.taCLMSCBOAdditionalFeedback.sendKeys (RandomLetters.produceRandomString (999));
	}

	// fill with specified text
	public void setCLMSCBOAdditionalFeedback (String taCLMSCBOAdditionalFeedback)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.taCLMSCBOAdditionalFeedback));

		orClaimInvoiceDetails.taCLMSCBOAdditionalFeedback.click ();
		orClaimInvoiceDetails.taCLMSCBOAdditionalFeedback.sendKeys (taCLMSCBOAdditionalFeedback);
	}

	// click the checkbox
	public void clickRepairInvoiceDetailSatisfactionNote ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.chkRepairInvoiceDetailSatisfactionNote));

		orClaimInvoiceDetails.chkRepairInvoiceDetailSatisfactionNote.click ();
	}

	// select a specified state
	public void selectRepairInvoiceDetailSatisfactionNote (boolean selected)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.chkRepairInvoiceDetailSatisfactionNote));

		// only call the click method if the state requires a click
		if (selected && !orClaimInvoiceDetails.chkRepairInvoiceDetailSatisfactionNote.isSelected () ||
			!selected && orClaimInvoiceDetails.chkRepairInvoiceDetailSatisfactionNote.isSelected ())
			orClaimInvoiceDetails.chkRepairInvoiceDetailSatisfactionNote.click ();
	}

	// click the checkbox
	public void clickRepairInvoiceDetailChargesInvoice ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.chkRepairInvoiceDetailChargesInvoice));

		orClaimInvoiceDetails.chkRepairInvoiceDetailChargesInvoice.click ();
	}

	// select a specified state
	public void selectRepairInvoiceDetailChargesInvoice (boolean selected)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.chkRepairInvoiceDetailChargesInvoice));

		// only call the click method if the state requires a click
		if (selected && !orClaimInvoiceDetails.chkRepairInvoiceDetailChargesInvoice.isSelected () ||
			!selected && orClaimInvoiceDetails.chkRepairInvoiceDetailChargesInvoice.isSelected ())
			orClaimInvoiceDetails.chkRepairInvoiceDetailChargesInvoice.click ();
	}

	// click the checkbox
	public void clickRepairInvoiceDetailEngineersAuthority ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.chkRepairInvoiceDetailEngineersAuthority));

		orClaimInvoiceDetails.chkRepairInvoiceDetailEngineersAuthority.click ();
	}

	// select a specified state
	public void selectRepairInvoiceDetailEngineersAuthority (boolean selected)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.chkRepairInvoiceDetailEngineersAuthority));

		// only call the click method if the state requires a click
		if (selected && !orClaimInvoiceDetails.chkRepairInvoiceDetailEngineersAuthority.isSelected () ||
			!selected && orClaimInvoiceDetails.chkRepairInvoiceDetailEngineersAuthority.isSelected ())
			orClaimInvoiceDetails.chkRepairInvoiceDetailEngineersAuthority.click ();
	}

	public void typeRepairInvoiceDetailComments ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.taRepairInvoiceDetailComments));

		orClaimInvoiceDetails.taRepairInvoiceDetailComments.click ();
		orClaimInvoiceDetails.taRepairInvoiceDetailComments.sendKeys (RandomLetters.produceRandomString (999));
	}

	// fill with specified text
	public void setRepairInvoiceDetailComments (String taRepairInvoiceDetailComments)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.taRepairInvoiceDetailComments));

		orClaimInvoiceDetails.taRepairInvoiceDetailComments.click ();
		orClaimInvoiceDetails.taRepairInvoiceDetailComments.sendKeys (taRepairInvoiceDetailComments);
	}

	// select a random element from the list
	public void selectReasonforAdjusting ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlReasonforAdjusting));

		orClaimInvoiceDetails.ddlReasonforAdjusting.click ();
		Select oReasonforAdjusting = new Select (orClaimInvoiceDetails.ddlReasonforAdjusting);

		// Select a random Reason for adjusting from the returned list
		List<WebElement> selections = oReasonforAdjusting.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oReasonforAdjusting.selectByIndex (index);
	}

	// select a specified value
	public void selectReasonforAdjusting (String ddlReasonforAdjusting)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.ddlReasonforAdjusting));

		orClaimInvoiceDetails.ddlReasonforAdjusting.click ();
		Select oReasonforAdjusting = new Select (orClaimInvoiceDetails.ddlReasonforAdjusting);
		oReasonforAdjusting.selectByVisibleText (ddlReasonforAdjusting);
	}

	// fill with specified text
	public void clickSave ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.btnSave));

		orClaimInvoiceDetails.btnSave.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void selectInvoiceTable (String strInvoiceType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.tblInvoiceType));
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.returnRowInTable ("CLM_SC_BO_3553_InvoiceTable", strInvoiceType);
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Click on "Make Payment" button
	public void clickMakePayment ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInvoiceDetails.btnMakePayment));

		orClaimInvoiceDetails.btnMakePayment.click ();

	}

}
