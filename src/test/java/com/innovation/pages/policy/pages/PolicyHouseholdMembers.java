/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicyHouseholdMembers;

/**
 * @author lushs
 *
 */
public class PolicyHouseholdMembers
{

	WebDriver					driver;

	OR_PolicyHouseholdMembers	orPolicyHouseholdMembers;

	public PolicyHouseholdMembers (WebDriver driver)
	{
		this.driver = driver;
		orPolicyHouseholdMembers = PageFactory.initElements (driver, OR_PolicyHouseholdMembers.class);

	}

	public void checkHouseHold ()
	{

		ControlPanel control = new ControlPanel (driver);
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyHouseholdMembers.prgProgress));

		wait.until (ExpectedConditions.visibilityOf (orPolicyHouseholdMembers.tlepage));

		orPolicyHouseholdMembers.tlepage.isDisplayed ();

		// Now get the title of the page that has been appeared in the flow

		String strPageTitle = orPolicyHouseholdMembers.tlepage.getText ();

		if (strPageTitle.contains ("Household members "))
		{

			control.clickNext ();

		}

	}

}
