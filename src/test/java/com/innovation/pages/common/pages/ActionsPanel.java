/**
 * 
 */
package com.innovation.pages.common.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.pages.common.objects.OR_ActionsPanel;

/**
 * @author lushs & haiderm - This class will store all the locators and methods of the Actions panel.
 */

public class ActionsPanel
{

	WebDriver		driver;

	LoggingControl	loggingcontrol	= new LoggingControl ();
	OR_ActionsPanel	orActionsPanel	= null;

	public ActionsPanel (WebDriver driver)
	{
		this.driver = driver;
		orActionsPanel = PageFactory.initElements (driver, OR_ActionsPanel.class);
	}

	/** Desktop view **/
	// Edit account
	public void clickEditAccount ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkEditAccount));
		orActionsPanel.lnkEditAccount.click ();

	}

	// Change brand
	public void clickChangeBrand ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkChangeBrand));
		orActionsPanel.lnkChangeBrand.click ();

	}

	/** Client view **/
	// Add Quote
	public void clickAddQuote ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkAddQuote));
		orActionsPanel.lnkAddQuote.click ();

	}

	// Add Policy
	public void clickAddPolicy ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkAddPolicy));
		orActionsPanel.lnkAddPolicy.click ();

	}

	// Add document
	public void clickAddDocument ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkAddDocument));
		orActionsPanel.lnkAddDocument.click ();

	}

	// Add task
	public void clickAddTask ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkAddTask));
		orActionsPanel.lnkAddTask.click ();

	}

	// Add note
	public void clickAddNote ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkAddNote));
		orActionsPanel.lnkAddNote.click ();

	}

	// Email
	public void clickEmail ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkEmail));
		orActionsPanel.lnkEmail.click ();

	}

	// SMS
	public void clickSMS ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkSMS));
		orActionsPanel.lnkSMS.click ();

	}

	/** Quote view **/
	// Exit quote
	public void clickExitQuote ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkExitQuote));
		orActionsPanel.lnkExitQuote.click ();

	}

	// Buy (Quote)
	public void clickBuy ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orActionsPanel.barProgress));
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkBuy));
		orActionsPanel.lnkBuy.click ();
		wait.until (ExpectedConditions.invisibilityOf (orActionsPanel.barProgress));
	}

	// Save as incomplete
	public void clickSaveAsIncomplete ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkSaveAsIncomplete));
		orActionsPanel.lnkSaveAsIncomplete.click ();

	}

	// Cancel transaction
	public void clickCancelTransaction ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkCancelTransaction));
		orActionsPanel.lnkCancelTransaction.click ();

	}

	// External reports
	public void clickExternalReports ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkExternalReports));
		orActionsPanel.lnkExternalReports.click ();

	}

	// Complete quote
	public void clickCompleteQuote ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOf (orActionsPanel.lnkCompleteQuote));
		orActionsPanel.lnkCompleteQuote.click ();

	}

	// Copy quote
	public void clickCopyQuote ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkCopyQuote));
		orActionsPanel.lnkCopyQuote.click ();

	}

	// Save awaiting payment
	public void clickSaveAwaitingPayment ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkSaveAwaitingPayment));
		orActionsPanel.lnkSaveAwaitingPayment.click ();

	}

	// Save scratch pad
	public void clickSaveScratchPad ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkSaveScratchPad));
		orActionsPanel.lnkSaveScratchPad.click ();

	}

	// Exit policy
	public void clickExitPolicy ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkExitPolicy));
		orActionsPanel.lnkExitPolicy.click ();

	}

	// Make a payment
	public void clickMakeAPayment ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkMakeAPayment));
		orActionsPanel.lnkMakeAPayment.click ();

	}

	// Copy policy
	public void clickCopyPolicy ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkCopyPolicy));
		orActionsPanel.lnkCopyPolicy.click ();

	}

	// Quote a change
	public void clickQuoteAChange ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkQuoteAChange));
		orActionsPanel.lnkQuoteAChange.click ();

	}

	// Amend policy
	public void clickAmendPolicy ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkAmendPolicy));
		orActionsPanel.lnkAmendPolicy.click ();

	}

	// Cancel policy
	public void clickCancelPolicy ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orActionsPanel.barProgress));
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkCancelPolicy));

		orActionsPanel.lnkCancelPolicy.click ();

	}

	// Reinstate policy

	public void clickReinstatePolicy ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orActionsPanel.barProgress));
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkReinstatepolicy));

		orActionsPanel.lnkReinstatepolicy.click ();

	}

	// Roll off transaction
	public void clickRollOffTransaction ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkRollOffTransaction));
		orActionsPanel.lnkRollOffTransaction.click ();

	}

	/** Claims view **/
	// Add claim - no policy
	public void clickAddClaimNoPolicy ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkAddClaimNoPolicy));
		orActionsPanel.lnkAddClaimNoPolicy.click ();

	}

	// Claim summary
	public void clickClaimSummary ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkClaimSummary));
		orActionsPanel.lnkClaimSummary.click ();
		try
		{
			// Long timeOut = 8L;
			WebDriverWait waitAlert = new WebDriverWait (driver, 8);
			if (waitAlert.until (ExpectedConditions.alertIsPresent ()) != null)
			{

				Alert alert = driver.switchTo ().alert ();
				alert.accept ();
			}
		}
		catch (Exception e)
		{

		}

	}

	// Cancel claim
	public void clickCancelClaim ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkCancelClaim));
		orActionsPanel.lnkCancelClaim.click ();

	}

	// View coverages
	public void clickViewCoverages ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkViewCoverages));
		orActionsPanel.lnkViewCoverages.click ();

	}

	// Pend claim
	public void clickPendClaim ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkPendClaim));
		orActionsPanel.lnkPendClaim.click ();

	}

	// View excesses
	public void clickViewExcesses ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkViewExcesses));
		orActionsPanel.lnkViewExcesses.click ();

	}

	// View reserves
	public void clickViewReserves ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkViewReserves));
		orActionsPanel.lnkViewReserves.click ();

	}

	// Add complaint
	public void clickAddComplaint ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkAddComplaint));
		orActionsPanel.lnkAddComplaint.click ();

	}

	// Exit claim
	public void clickExitClaim ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkExitClaim));
		orActionsPanel.lnkExitClaim.click ();

	}

	/*
	 * @author Kamran Adding policy actions
	 */

	public void clickUpdatePolicy (String strRegion)
	{

		if (strRegion.equals ("UK"))
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.visibilityOf (orActionsPanel.lnkPropertyActions));
			orActionsPanel.lnkPropertyActions.click ();
			wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkPropertyUpdate));
			orActionsPanel.lnkPropertyUpdate.click ();
		}
		else if (strRegion.equals ("USA") || strRegion.equals ("US"))
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.visibilityOf (orActionsPanel.lnkPropertyAction));
			orActionsPanel.lnkPropertyAction.click ();
			wait.until (ExpectedConditions.elementToBeClickable (orActionsPanel.lnkUpdateProperty));
			orActionsPanel.lnkUpdateProperty.click ();

		}
	}

	// Keeping all methods from SCOT LUSH in case PageFactory doesn't work in
	// scenarios.
	/*
	 * public void clickAddQuote() { // This will wait for up to 10 seconds for the Add Quote button to become // available.
	 * Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
	 * wait.until(ExpectedConditions.elementToBeClickable(orActionsPanel.lnkAddQuote ()));
	 * 
	 * Actions actions = new Actions(driver); actions.moveToElement(orActionsPanel.lnkAddQuote()).click().perform(); //
	 * orActionsPanel.lnkAddQuote ().click (); }
	 * 
	 * public void clickAddClaimNoPolicy() { // This will wait for up to 10 seconds for the Add Quote button to become // available.
	 * Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
	 * wait.until(ExpectedConditions.elementToBeClickable(orActionsPanel. lnkAddClaimNoPolicy()));
	 * 
	 * Actions actions = new Actions(driver); actions.moveToElement(orActionsPanel.lnkAddClaimNoPolicy()).click().perform() ; //
	 * orActionsPanel.lnkAddClaimNoPolicy ().click (); }
	 * 
	 * public void clickCompleteQuote() { // This will wait for up to 30 seconds for the Complete Quote button to become //
	 * available. Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
	 * wait.until(ExpectedConditions.elementToBeClickable(orActionsPanel. lnkCompleteQuote()));
	 * 
	 * Actions actions = new Actions(driver); actions.moveToElement(orActionsPanel.lnkCompleteQuote()).click().perform(); //
	 * orActionsPanel.lnkCompleteQuote ().click (); }
	 */

}
