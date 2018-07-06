
package com.innovation.pages.claim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.claim.objects.OR_ClaimIncidentDetails;
import com.innovation.pages.claim.objects.OR_ClaimPolicyDetails;
import com.innovation.pages.common.objects.OR_ControlPanel;

/*@author  Kamran Mahmood  This will capture Methods of claims policy details screen
 * 
 */

public class ClaimPolicyDetails
{
	WebDriver				driver;
	OR_ClaimPolicyDetails		orClaimPolicyDetails		= null;
	OR_ControlPanel				orControlPanel				= null;
	OR_ClaimIncidentDetails		orClaimIncidentDetails		= null;

	public ClaimPolicyDetails (WebDriver driver)
	{
		this.driver = driver;
		orClaimPolicyDetails = PageFactory.initElements (driver, OR_ClaimPolicyDetails.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
		orClaimIncidentDetails = PageFactory.initElements (driver, OR_ClaimIncidentDetails.class);
	}

	public void clickRisksTab ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPolicyDetails.tabRisks));
		orClaimPolicyDetails.tabRisks.click ();
	}

	public void clickPolicyHolderTab ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPolicyDetails.tabPolicyHolder));
		orClaimPolicyDetails.tabPolicyHolder.click ();
	}

	public void clickBrokerDetailsTab ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPolicyDetails.tabBrokerDetails));
		orClaimPolicyDetails.tabBrokerDetails.click ();
	}

	public void clickClaimsHistorysTab ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPolicyDetails.tabClaimHistory));
		orClaimPolicyDetails.tabClaimHistory.click ();
	}

	public void clickEventMangementTab ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPolicyDetails.tabEventManagement));
		orClaimPolicyDetails.tabEventManagement.click ();
	}

	public void clickAddButtonOfEventMangement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPolicyDetails.btnAdd));
		orClaimPolicyDetails.btnAdd.click ();
	}

	public void clickClearButtonOfEventManagement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPolicyDetails.btnClear));
		orClaimPolicyDetails.btnClear.click ();
	}
	
	// This clicks on Yes button on Event management pop up if the pop up is displayed
		public void clickEventManagementYes ()
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			
			wait.until (ExpectedConditions.or (ExpectedConditions.visibilityOf (orControlPanel.dlgConfirmPopup),
					ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.txaIncidentDescription)));
			
			if (orControlPanel.dlgConfirmPopup.isDisplayed ())
			{
				wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.dlgYes));
				orControlPanel.dlgYes.click ();

				wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
			}
		}
		
	// This clicks on No button on Event management pop up if the pop up is displayed
	public void clickEventManagementNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		
		wait.until (ExpectedConditions.or (ExpectedConditions.visibilityOf (orControlPanel.dlgConfirmPopup),
				ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.txaIncidentDescription)));
		
		if (orControlPanel.dlgConfirmPopup.isDisplayed ())
		{
			wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.dlgNo));
			orControlPanel.dlgNo.click ();

			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		}
	}
	
	

}
