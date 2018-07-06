/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.pages.policy.objects.OR_PolicyRequisitionDetails;

/**
 * @author Qasim - This class stores all the locators and methods of the Policy Requisition Details screen
 */

public class PolicyRequisitionDetails
{

	WebDriver					driver;
	OR_PolicyRequisitionDetails	orPolicyRequisitionDetails	= null;
	LoggingControl				loggingcontrol				= new LoggingControl ();
	

	public PolicyRequisitionDetails (WebDriver driver)
	{
		this.driver = driver;
		orPolicyRequisitionDetails = PageFactory.initElements (driver, OR_PolicyRequisitionDetails.class);
		
	}

	// type Refund Amount
	public void typeRefundAmount (Double finalvalue)
	{
		
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionDetails.txtRefundAmount));
		
		orPolicyRequisitionDetails.txtRefundAmount.sendKeys (String.valueOf (finalvalue));
		
	}


}
