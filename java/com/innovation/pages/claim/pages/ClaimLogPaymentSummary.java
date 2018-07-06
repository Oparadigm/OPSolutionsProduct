package com.innovation.pages.claim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.claim.objects.OR_ClaimLogPaymentSummary;
import com.innovation.pages.common.objects.OR_ControlPanel;

/*@author  Kamal - this class stores all the locators and methods on Summary frame in Claims BO Log Payment flow. 
 * 
 */

public class ClaimLogPaymentSummary
{
	WebDriver					driver;
	OR_ClaimLogPaymentSummary	orClaimLogPaymentSummary	= null;
	OR_ControlPanel	orControlPanel	= null;

	public ClaimLogPaymentSummary (WebDriver driver)
	{
		this.driver = driver;
		orClaimLogPaymentSummary = PageFactory.initElements (driver, OR_ClaimLogPaymentSummary.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	public void clickFlowCompleted ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentSummary.btnFlowCompleted));
		orClaimLogPaymentSummary.btnFlowCompleted.click ();
		
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		
		
	}

}
