package com.innovation.pages.claim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimManageSIUReferral;
import com.innovation.pages.common.objects.OR_ActionsPanel;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.common.pages.ControlPanel;

/*
 * @author  Rizwan - this class stores all the locators and methods on 'Manage SIU referral/update score' frame accessible through Claims BO Navigation panel > SIU menu.
 * 
 */

public class ClaimManageSIUReferral
{
	WebDriver					driver;
	OR_ClaimManageSIUReferral	orClaimManageSIUReferral	= null;
	OR_ControlPanel				orControlPanel				= null;
	OR_ActionsPanel				orActionsPanel				= null;

	public ClaimManageSIUReferral (WebDriver driver)
	{
		this.driver = driver;
		orClaimManageSIUReferral = PageFactory.initElements (driver, OR_ClaimManageSIUReferral.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
		orActionsPanel = PageFactory.initElements (driver, OR_ActionsPanel.class);
	}

	// This selects a record from SIU summary table that has a non-zero SIU score. It then selects each of associated active reasons
	// from SIU referral
	// details table and removes them all one by one. It then repeats the process for all records in SIU summary table with non-zero
	// score
	public void removeSIUReferrals (String strSIUReferralOverrideReason)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		TableHandler tablehandler = new TableHandler (driver);
		ControlPanel controlpanel = new ControlPanel (driver);
		controlpanel.clickEditFrame ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

		// Get no. of rows in SIU summary table
		int intSIUSummaryRows = orClaimManageSIUReferral.tblSIUSummaryRows.size ();

		// Loop each of row to check if it has score greater than zero then select it
		for (int i = 3; i <= intSIUSummaryRows; i++)
		{

			String strScore = driver
					.findElement (By.xpath ("/html/body/form/div[12]/span[1]/div[2]/table/tbody/tr/td/div/div[1]/table/tbody/tr[" + i + "]/td[3]")).getText ();

			if (strScore.equalsIgnoreCase ("0"))
			{

			}
			else
			{
				// This clicks on the row in SIU summary table when score is greater than zero
				driver.findElement (By.xpath ("/html/body/form/div[12]/span[1]/div[2]/table/tbody/tr/td/div/div[1]/table/tbody/tr[" + i + "]/td[3]")).click ();
				wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

				// This do-while loop executes until all active records from SIU referral details table are processed
				do
				{
					// This clicks on a row in SIU referral details table that is an active record
					tablehandler.returnRowInTable ("CLM_SC_BO_0151_SIUSelected", "Active");

					selectOverrideReason (strSIUReferralOverrideReason);
					typeAdditionalInfo ();
					clickRemoveReason ();
					wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

				} while (tablehandler.checkTableHasRecords ("CLM_SC_BO_0151_SIUSelected", "Active", "All") == true);

			}
		}

	}

	public void selectOverrideReason (String strSIUReferralOverrideReason)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimManageSIUReferral.ddlOverrideReason));

		orClaimManageSIUReferral.ddlOverrideReason.click ();
		orClaimManageSIUReferral.ddlOverrideReason.sendKeys (strSIUReferralOverrideReason);
		orClaimManageSIUReferral.ddlOverrideReason.click ();

	}

	public void typeAdditionalInfo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimManageSIUReferral.txaAdditionalInfo));

		orClaimManageSIUReferral.txaAdditionalInfo.click ();
		orClaimManageSIUReferral.txaAdditionalInfo.sendKeys ("Test Reason " + RandomLetters.produceRandomString (5));
	}

	public void clickRemoveReason ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimManageSIUReferral.btnRemoveReason));

		orClaimManageSIUReferral.btnRemoveReason.click ();
	}

}
