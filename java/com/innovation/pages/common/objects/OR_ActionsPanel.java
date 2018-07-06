/**
 * 
 */
package com.innovation.pages.common.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs & haiderm - This captures the page elements for Actions panel.
 * 
 */
public class OR_ActionsPanel
{

	/** Desktop view **/
	// Edit account
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Edit account")
	public WebElement	lnkEditAccount;

	// Change brand
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Change brand")
	public WebElement	lnkChangeBrand;

	/** Client view **/
	// Add Quote
	// @CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Add quote")
	public WebElement	lnkAddQuote;

	// Add Policy
	// @CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Add policy")
	public WebElement	lnkAddPolicy;

	// Add document
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Add document")
	public WebElement	lnkAddDocument;

	// Add task
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Add task")
	public WebElement	lnkAddTask;

	// Add note
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Add note")
	public WebElement	lnkAddNote;

	// Email
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Email")
	public WebElement	lnkEmail;

	// SMS
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "SMS")
	public WebElement	lnkSMS;

	/** Quote / Policy view **/
	// Exit quote
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Exit quote")
	public WebElement	lnkExitQuote;

	// Buy (Quote)
	// @CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Buy")
	public WebElement	lnkBuy;

	// Save as incomplete
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Save as incomplete")
	public WebElement	lnkSaveAsIncomplete;

	// Cancel transaction
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Cancel transaction")
	public WebElement	lnkCancelTransaction;

	// External reports
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "External reports")
	public WebElement	lnkExternalReports;

	// Complete quote
	// @CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Complete quote")
	public WebElement	lnkCompleteQuote;

	// Copy quote
	// @CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Copy quote")
	public WebElement	lnkCopyQuote;

	// Save awaiting payment
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Save awaiting payment")
	public WebElement	lnkSaveAwaitingPayment;

	// Save scratch pad
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Save scratch pad")
	public WebElement	lnkSaveScratchPad;

	// Exit policy
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Exit policy")
	public WebElement	lnkExitPolicy;

	// Make a payment
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Make a payment")
	public WebElement	lnkMakeAPayment;

	// Copy policy
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Copy policy")
	public WebElement	lnkCopyPolicy;

	// Quote a change
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Quote a change")
	public WebElement	lnkQuoteAChange;

	// Amend policy
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Amend policy")
	public WebElement	lnkAmendPolicy;

	// Cancel policy

	@FindBy(how = How.LINK_TEXT, using = "Cancel policy")
	public WebElement	lnkCancelPolicy;

	// Reinstate policy
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Reinstate policy")
	public WebElement	lnkReinstatepolicy;

	// Roll off transaction
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Roll off transaction")
	public WebElement	lnkRollOffTransaction;

	/** Claims view **/
	// Add claim - no policy
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Add claim - no policy")
	public WebElement	lnkAddClaimNoPolicy;

	// Claim summary
	@FindBy(how = How.LINK_TEXT, using = "Claim summary")
	public WebElement	lnkClaimSummary;

	// Cancel claim
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Cancel claim")
	public WebElement	lnkCancelClaim;

	// View coverages
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "View coverages")
	public WebElement	lnkViewCoverages;

	// Pend claim
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Pend claim")
	public WebElement	lnkPendClaim;

	// View excesses
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "View excesses")
	public WebElement	lnkViewExcesses;

	// View reserves
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "View reserves")
	public WebElement	lnkViewReserves;

	// Add complaint
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Add complaint")
	public WebElement	lnkAddComplaint;

	// Exit claim
	@CacheLookup
	@FindBy(how = How.CSS, using = "#LHS_actionsDiv > table > tbody > tr:nth-child(1) > td > div.igActionContentSpacing > a")
	public WebElement	lnkExitClaim;

	// Policy Actions link on Policy summary
	@CacheLookup
	@FindBy(how = How.CSS, using = "#navMenuPOLPROC > div:nth-child(2) > span")
	public WebElement	lnkPropertyActions;

	// Update Property link on policy summary
	@CacheLookup
	@FindBy(how = How.CSS, using = "#navMenuPOLPROC > div:nth-child(2) > a")
	public WebElement	lnkPropertyUpdate;

	// Policy Actions link on Policy summary for US
	@CacheLookup
	@FindBy(how = How.CSS, using = "#navMenuPOLPROC > div:nth-child(3) > span")
	public WebElement	lnkPropertyAction;

	// Update Property link on policy summary for US
	@CacheLookup
	@FindBy(how = How.CSS, using = "#navMenuPOLPROC > div:nth-child(3) > a")
	public WebElement	lnkUpdateProperty;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	barProgress;

}
