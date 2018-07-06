package com.innovation.pages.claim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimSIUSpotlight;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.common.pages.ControlPanel;

/*
 * @author  Rizwan - this class stores all the locators and methods on 'SIU Spotlight' frame accessible through Claims BO Navigation panel > SIU menu.
 * 
 */

public class ClaimSIUSpotlight
{
	WebDriver				driver;
	OR_ClaimSIUSpotlight	orClaimSIUSpotlight	= null;
	OR_ControlPanel			orControlPanel		= null;

	public ClaimSIUSpotlight (WebDriver driver)
	{
		this.driver = driver;
		orClaimSIUSpotlight = PageFactory.initElements (driver, OR_ClaimSIUSpotlight.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);

	}

	public void closeSIUFeature (String strSIUClosureReason)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		TableHandler tablehandler = new TableHandler (driver);

		do
		{

			tablehandler.returnRowInTable ("tblReferrals", "Active");
			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

			selectReferralStatus (strSIUClosureReason);
			typeReason ();

			ControlPanel controlpanel = new ControlPanel (driver);
			controlpanel.clickSave ();
			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

		} while (tablehandler.checkTableHasRecords ("tblReferrals", "Active", "All") == true);

	}

	public void selectReferralStatus (String strSIUClosureReason)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimSIUSpotlight.ddlReferralStatus));

		orClaimSIUSpotlight.ddlReferralStatus.click ();
		orClaimSIUSpotlight.ddlReferralStatus.sendKeys (strSIUClosureReason);
		orClaimSIUSpotlight.ddlReferralStatus.click ();

	}

	public void typeReason ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimSIUSpotlight.txtReason));

		orClaimSIUSpotlight.txtReason.click ();
		orClaimSIUSpotlight.txtReason.sendKeys ("SIU status update reason " + RandomLetters.produceRandomString (5));
	}

}
