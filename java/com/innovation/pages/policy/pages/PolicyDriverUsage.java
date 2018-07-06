/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.policy.objects.OR_PolicyDriverUsage;

/**
 * @author Kamran Mahmood
 *
 */
public class PolicyDriverUsage
{

	WebDriver				driver;
	OR_PolicyDriverUsage	orPolicyDriverUsage	= null;

	public PolicyDriverUsage (WebDriver driver)
	{
		this.driver = driver;
		orPolicyDriverUsage = PageFactory.initElements (driver, OR_PolicyDriverUsage.class);
	}

	public void selectDriverType ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyDriverUsage.ddlDriverType));
		Select oSelectAgentType = new Select (orPolicyDriverUsage.ddlDriverType);
		oSelectAgentType.selectByVisibleText ("Primary driver");
	}
}
