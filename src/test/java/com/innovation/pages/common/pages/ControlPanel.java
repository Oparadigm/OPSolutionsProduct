/**
 * 
 */
package com.innovation.pages.common.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.common.objects.OR_ControlPanel;

/**
 * @author alamq This class will store all the locators and methods of the Control Panel buttons.
 */

public class ControlPanel
{

	WebDriver		driver;
	OR_ControlPanel	orControlPanel	= null;

	public ControlPanel (WebDriver driver)
	{
		this.driver = driver;
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	// Click on "Next" button

	public void clickNext ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		// wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.btnNext));

		orControlPanel.btnNext.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Click on "previous" button

	public void clickPrevious ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.btnPrevious));
		orControlPanel.btnPrevious.click ();
	}

	// Click on "Save" button

	public void clickSave ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.btnSave));
		orControlPanel.btnSave.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	// Click on "Reset" button

	public void clickReset ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.btnReset));
		orControlPanel.btnReset.click ();
	}

	// Select "Yes" on Dialogue box

	public void clickYes ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOf (orControlPanel.dlgYesNoPopUp));
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.dlgYes));
		orControlPanel.dlgYes.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Select "No" on Dialogue box

	public void clickNo ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.dlgNo));
		orControlPanel.dlgNo.click ();
	}

	// Click on "Cancel" button

	public void clickCancel ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.btnCancel));
		orControlPanel.btnCancel.click ();
	}

	public String getQuotePolicyNumber ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.numQuotePolicy));
		String strQuotePolicyNumber = orControlPanel.numQuotePolicy.getText ();
		String strfetchNumber = StringUtils.substringAfterLast (strQuotePolicyNumber, "/");
		System.out.println (strfetchNumber);

		return strfetchNumber;

	}

	// Click on the Edit button in Claims frames to bring the frames in editable
	// mode.
	public void clickEditFrame ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.btnEdit));
		orControlPanel.btnEdit.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Click on OK button on Confirm pop up
	public void clickOKConfirm ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.btnOKConfirm));
		orControlPanel.btnOKConfirm.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Click on Cancel button on Confirm pop up
	public void clickCancelConfirm ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.btnCancelConfirm));
		orControlPanel.btnCancelConfirm.click ();

	}

	public void clickFinishTransaction ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.btnFinish));
		orControlPanel.btnFinish.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// This clicks on Next button that is displayed in tables to view data on next pages of table
	public void clickNextPageInTable ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.btnNextPageInTable));
		orControlPanel.btnNextPageInTable.click ();

	}

	// wait for element especially table result

	public boolean retryingFindClick (WebElement orControlPanel)
	{
		boolean result = false;
		int intValidationAttempt = 0;

		while (intValidationAttempt < 2)
		{

			try
			{
				orControlPanel.isDisplayed ();
				result = true;
				break;
			}
			catch (StaleElementReferenceException e)
			{
			}
			intValidationAttempt++;
		}
		return result;
	}

}
