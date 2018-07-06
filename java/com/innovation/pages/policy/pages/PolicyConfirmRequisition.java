/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.misc.TableHandler;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicyConfirmRequisition;

/**
 * @author Qasim
 *
 */
public class PolicyConfirmRequisition
{

	WebDriver					driver;
	OR_PolicyConfirmRequisition	orPolicyConfirmRequisition	= null;
	OR_ControlPanel orControlPanel = null;

	public PolicyConfirmRequisition (WebDriver driver)
	{
		this.driver = driver;
		orPolicyConfirmRequisition = PageFactory.initElements (driver, OR_PolicyConfirmRequisition.class);
	}

	public String VerifyAPRequisitionNumber ()
	{
		SeleniumWaiter seleniumWaiter = new SeleniumWaiter (driver);
		String strRequisitionNumber = orPolicyConfirmRequisition.txtAPRequisitionNumber.getText ();
		System.out.println ("This is Account Payable Requisition Number = " + strRequisitionNumber);
		seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		
		return strRequisitionNumber;
	}

	
	
}
