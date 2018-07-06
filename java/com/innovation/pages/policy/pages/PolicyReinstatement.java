/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;

import com.innovation.misc.GlobalWaitTime;

import com.innovation.pages.policy.objects.OR_PolicyReinstatement;

/**
 * @author Tahir - This class stores all the locators and methods of the Policy Reinstatement screen
 */

public class PolicyReinstatement
{

	WebDriver				driver;
	OR_PolicyReinstatement	orPolicyReinstatement	= null;

	public PolicyReinstatement (WebDriver driver)
	{
		this.driver = driver;
		orPolicyReinstatement = PageFactory.initElements (driver, OR_PolicyReinstatement.class);
	}

	public void processReinstatement (String strCancelledReason, String strLocation, int intDays, int intMonths, int intYear)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyReinstatement.prgProgress));
		wait.until (ExpectedConditions.visibilityOf (orPolicyReinstatement.tlepolicyTitle));

		if (strCancelledReason.equals ("Non-Payment"))
		{
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyReinstatement.dptReinstatementEffectiveDte));

			orPolicyReinstatement.dptReinstatementEffectiveDte.click ();
			orPolicyReinstatement.dptReinstatementEffectiveDte.sendKeys (CalenderDate.returnDesiredDate (strLocation, intDays, intMonths, intYear));
			wait.until (ExpectedConditions.visibilityOf (orPolicyReinstatement.btnProcess));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyReinstatement.btnProcess));
			orPolicyReinstatement.btnProcess.click ();

		}
		else
		{
			System.out.println ("Your Policy is Reinstated");
			intDays = 0;
			intMonths = 0;
			intYear = 0;

		}
	}
}
