package com.innovation.pages.claim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimValidation;
import com.innovation.pages.common.objects.OR_ActionsPanel;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.common.pages.ControlPanel;

/*
 * @author  Kamal - this class stores all the locators and methods on Validation frame accessible through Claims BO Navigation panel > Functions menu.
 * 
 */

public class ClaimValidation
{
	WebDriver			driver;
	OR_ClaimValidation	orClaimValidation	= null;
	OR_ControlPanel		orControlPanel		= null;
	OR_ActionsPanel		orActionsPanel		= null;

	public ClaimValidation (WebDriver driver)
	{
		this.driver = driver;
		orClaimValidation = PageFactory.initElements (driver, OR_ClaimValidation.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
		orActionsPanel = PageFactory.initElements (driver, OR_ActionsPanel.class);
	}

	// This selects each of validation exception from Validation exception table one by one and resolves them
	public void resolveValidationExceptions ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		TableHandler tablehandler = new TableHandler (driver);
		ControlPanel controlpanel = new ControlPanel (driver);

		// do-while loop executes until all active records are processed
		do
		{
			// This clicks on a row in Validation exception table that is an active record
			tablehandler.returnRowInTable ("CLM_SC_BO_0034_ValidationExceptions", "Active");
			selectResolutionReason ("Coverage added");
			clickUpdateResolutionReason ();

			wait.until (ExpectedConditions.visibilityOf (orControlPanel.dlgConfirmPopup));
			controlpanel.clickOKConfirm ();
			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		} while (tablehandler.checkTableHasRecords ("CLM_SC_BO_0034_ValidationExceptions", "Active", "All") == true);

		controlpanel.clickSave ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

		// Click on Claim summary link
		orActionsPanel.lnkClaimSummary.click ();
	}

	public void selectResolutionReason (String strResolutionReason)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimValidation.ddlResolutionReason));

		orClaimValidation.ddlResolutionReason.click ();
		Select oResolutionReason = new Select (orClaimValidation.ddlResolutionReason);
		oResolutionReason.selectByVisibleText (strResolutionReason);
		orClaimValidation.ddlResolutionReason.click ();

	}

	public void clickUpdateResolutionReason ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimValidation.btnUpdateResolutionReason));
		orClaimValidation.btnUpdateResolutionReason.click ();
	}

}
