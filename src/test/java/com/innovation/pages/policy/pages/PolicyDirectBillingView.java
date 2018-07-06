/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.pages.policy.objects.OR_PolicyDirectBillingView;
import com.innovation.pages.common.objects.OR_ControlPanel;

/**
 * @author Qasim
 *
 */
public class PolicyDirectBillingView
{

	WebDriver					driver;
	OR_PolicyDirectBillingView	ordirectbillingview	= null;
	OR_ControlPanel				orcontrolpanel		= null;

	public PolicyDirectBillingView (WebDriver driver)
	{
		this.driver = driver;
		ordirectbillingview = PageFactory.initElements (driver, OR_PolicyDirectBillingView.class);
	}

	public Double VerifyCarryForwardAmount ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		//wait.until (isTrue);
		String strCarryForwardAmount = ordirectbillingview.lblCarryForwardAmount.getText ();
		Double carryForward = Double.valueOf (strCarryForwardAmount);
		double finalvalue = Math.abs (carryForward);
		System.out.println ("This is carry forward amount = " + finalvalue);
		
		return finalvalue;
	}

}
