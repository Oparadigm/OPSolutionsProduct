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
import com.innovation.pages.claim.objects.OR_ClaimLogPaymentAnalysis;
import com.innovation.pages.common.objects.OR_ControlPanel;

/*
 * @author  Kamal - this class stores all the locators and methods on Analysis frame in Claims BO Log Payment flow. 
 * 
 */

public class ClaimLogPaymentAnalysis
{
	WebDriver					driver;
	String						strAmountClaimed			= "";
	OR_ClaimLogPaymentAnalysis	orClaimLogPaymentAnalysis	= null;
	OR_ControlPanel				orControlPanel				= null;

	public String getPaymentAmount ()
	{
		return strAmountClaimed;
	}

	public void setPaymentAmount (String strAmountClaimed)
	{
		this.strAmountClaimed = strAmountClaimed;
	}

	public ClaimLogPaymentAnalysis (WebDriver driver)
	{
		this.driver = driver;
		orClaimLogPaymentAnalysis = PageFactory.initElements (driver, OR_ClaimLogPaymentAnalysis.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	public void selectRisk ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentAnalysis.ddlRisk));

		Select oRisk = new Select (orClaimLogPaymentAnalysis.ddlRisk);

		List<WebElement> selections = oRisk.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oRisk.selectByIndex (intIndex);

	}

	public void selectCoverageFeature ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentAnalysis.ddlCoverageFeature));

		Select oCoverage = new Select (orClaimLogPaymentAnalysis.ddlCoverageFeature);

		List<WebElement> selections = oCoverage.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oCoverage.selectByIndex (intIndex);

	}

	public void selectReserveType (String strReserveType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentAnalysis.ddlReserveType));

		orClaimLogPaymentAnalysis.ddlReserveType.click ();
		Select oType = new Select (orClaimLogPaymentAnalysis.ddlReserveType);
		oType.selectByVisibleText (strReserveType);

		// this pop-up only seems to appear over a slow connection for IGGS;
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Pass "Random" to enter a random payment code or pass the value of Payment code
	public void selectPaymentCode (String strPaymentCode)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		// This waits until this dynamic dropdown is populated with the values
		// based on Reserve type selected. It waits for the first blank value to be
		// present in the dropdown as we are not sure what other values will
		// populate as they depend upon Reserve type value selected.
		// Commonly used option elementToBeClickable did not work here
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimLogPaymentAnalysis.ddlPaymentCode, " "));

		orClaimLogPaymentAnalysis.ddlPaymentCode.click ();

		if (strPaymentCode.equalsIgnoreCase ("Random"))
		{

			Select oPCode = new Select (orClaimLogPaymentAnalysis.ddlPaymentCode);

			List<WebElement> selections = oPCode.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oPCode.selectByIndex (intIndex);

			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		}
		else
		{
			orClaimLogPaymentAnalysis.ddlPaymentCode.sendKeys (strPaymentCode);
			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		}
	}

	// Pass "Random" to enter a random payment amount or pass the value of
	// payment amount e.g. "500"
	public void typePaymentAmount (String strPaymentAmount)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentAnalysis.txtPaymentAmount));

		if (strPaymentAmount.equalsIgnoreCase ("Random"))
		{
			orClaimLogPaymentAnalysis.txtPaymentAmount.click ();
			// Amount entered is saved as to be used on Claim payment frame in the flow.
			strAmountClaimed = String.valueOf (RandomNumbers.randomNumberGenerator (100, 200));
			orClaimLogPaymentAnalysis.txtPaymentAmount.sendKeys (strAmountClaimed);
		}
		else
		{
			orClaimLogPaymentAnalysis.txtPaymentAmount.click ();
			orClaimLogPaymentAnalysis.txtPaymentAmount.sendKeys (strPaymentAmount);
			// Amount entered is saved as to be used on Claim payment frame in
			// the flow
			strAmountClaimed = strPaymentAmount;
		}
	}

	public void typeExcessAmount ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		String strExcessAmount = orClaimLogPaymentAnalysis.txtExcessAmount.getAttribute ("value");
		if (strExcessAmount.equalsIgnoreCase (""))
		{
			wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentAnalysis.txtExcessAmount));
			orClaimLogPaymentAnalysis.txtExcessAmount.click ();
			// A value greater than 0 sometimes exceeds than the excess on the claim and is not handled yet so 0 is being entered at
			// the moment. This will be updated later on.
			orClaimLogPaymentAnalysis.txtExcessAmount.sendKeys ("0");
			// orClaimLogPaymentAnalysis.txtExcessAmount.sendKeys (String.valueOf (RandomNumbers.randomNumberGenerator (50, 100)));
		}

	}

	public void selectPaymentType (String strPaymentType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentAnalysis.ddlPaymentType));

		orClaimLogPaymentAnalysis.ddlPaymentType.click ();
		Select oPaymentType = new Select (orClaimLogPaymentAnalysis.ddlPaymentType);
		oPaymentType.selectByVisibleText (strPaymentType);
		orClaimLogPaymentAnalysis.ddlPaymentType.click ();

	}

	public void clickAddPayment ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentAnalysis.btnAddPayment));

		orClaimLogPaymentAnalysis.btnAddPayment.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	public void selectNonStandardPayment ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentAnalysis.ddlNonStandardPayment));

		orClaimLogPaymentAnalysis.ddlNonStandardPayment.click ();
		Select oNonStandardPayment = new Select (orClaimLogPaymentAnalysis.ddlNonStandardPayment);

		List<WebElement> selections = oNonStandardPayment.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oNonStandardPayment.selectByIndex (intIndex);
		orClaimLogPaymentAnalysis.ddlNonStandardPayment.click ();
	}

}
