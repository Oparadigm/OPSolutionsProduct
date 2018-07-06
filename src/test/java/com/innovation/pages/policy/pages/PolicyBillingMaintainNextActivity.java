/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.TableHandler;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.policy.objects.OR_PolicyBillingMaintainNextActivity;

/**
 * @author Tahir
 *
 */
public class PolicyBillingMaintainNextActivity
{

	WebDriver								driver;
	OR_PolicyBillingMaintainNextActivity	orPolicyBillingMaintainNextActivity	= null;

	public PolicyBillingMaintainNextActivity (WebDriver driver)
	{
		this.driver = driver;
		orPolicyBillingMaintainNextActivity = PageFactory.initElements (driver, OR_PolicyBillingMaintainNextActivity.class);

	}

	// this method is optional depending on if the value is visible on the screen.
	public void applyBillingNextActivitiesForRenewals (String strEnvironmentBrand)
	{
		TableHandler maintainnextactivitytable = new TableHandler (driver);

		if (strEnvironmentBrand.contains ("Model Office"))
		{

			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.invisibilityOf (orPolicyBillingMaintainNextActivity.prgProgressBar));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingMaintainNextActivity.tblMaintainNextActivity));

			// Boolean boolRenewalActivityRecord = maintainnextactivitytable.checkTableHasRecords ("tblNextActivity", "Renewal
			// billing process", "All");

			if (maintainnextactivitytable.checkTableHasRecords ("tblNextActivity", "Renewal billing process", "All") == true)
			{

				maintainnextactivitytable.returnRowInTable ("tblNextActivity", "Rollover");
				orPolicyBillingMaintainNextActivity.btnSApplyNextActivity.click ();
				wait.until (ExpectedConditions.invisibilityOf (orPolicyBillingMaintainNextActivity.prgProgressBar));
				maintainnextactivitytable.returnRowInTable ("tblNextActivity", "Indicates billing process one");
				orPolicyBillingMaintainNextActivity.btnSApplyNextActivity.click ();

			}
		}
	}

	// Annual Card Bill Plan - Apply Next Ativities

	public void AnnualCardBillingActivities (String strRegionValue)
	{

		TableHandler tablehandle = new TableHandler (driver);
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingMaintainNextActivity.tblMaintainNextActivity));
		tablehandle.returnRowInTableWithText ("tblNextActivity", "RMDLAT - Final renewal reminder");

		orPolicyBillingMaintainNextActivity.btnSApplyNextActivity.click ();

	}

	// The Following function will validate and apply the Billing Next activities as per the selected Bill plan

	public void applyBillingNextActivitiesUK (String strRegionValue, String strBillPlan, String strReceiptType)
	{

		PolicyBillingDetails billingdetails = new PolicyBillingDetails (driver);
		NavigationPanel navigate = new NavigationPanel (driver);
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		if (strRegionValue.contains ("UK") && strBillPlan.contains ("Annual Card"))
		{
			this.AnnualCardBillingActivities (strRegionValue);
			navigate.clickMakeAPayment ();
			wait.until (ExpectedConditions.invisibilityOf (orPolicyBillingMaintainNextActivity.prgProgressBar));
			billingdetails.selectReceiptType (strReceiptType);
			billingdetails.selectCurrentBalance (strReceiptType);
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingMaintainNextActivity.btnSubmit));
			orPolicyBillingMaintainNextActivity.btnSubmit.click ();

		}

	}

	public void clickProceedButton ()
	{
		System.out.println ("Test");

	}

}
