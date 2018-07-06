/**
 * 
 */
package com.innovation.pages.common.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author alamq - This captures the page elements for Control Panel buttons
 *
 */
public class OR_ControlPanel
{

	// Next Button

	@FindBy(how = How.CLASS_NAME, using = "igFlowNext")
	public WebElement	btnNext;

	// Previous Button
	// @CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igFlowPrevious")
	public WebElement	btnPrevious;

	// Save Button
	// @CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igFlowApply")
	public WebElement	btnSave;

	// Reset Button
	@CacheLookup
	@FindBy(how = How.ID, using = "igFlowResetBtn")
	public WebElement	btnReset;

	@FindBy(how = How.ID, using = "igLightbox")
	public WebElement	dlgYesNoPopUp;

	// Reset dialogue box selection as No
	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseNo")
	public WebElement	dlgNo;

	// Reset dialogue box selection as Yes
	// @CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseYes")
	public WebElement	dlgYes;

	// Cancel Button
	@CacheLookup
	@FindBy(how = How.CSS, using = "#controlpanel > table > tbody > tr > td:nth-child(2) > div:nth-child(2) > button")
	public WebElement	btnCancel;

	// Quote/Policy Number
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"title\"]/h1[1]")
	public WebElement	numQuotePolicy;

	// @CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	barProgress;

	// Edit button on Claims frames to bring frame fields in editable mode from
	// read-only mode
	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igFlowEdit")
	public WebElement	btnEdit;

	// Confirm pop up
	// @CacheLookup
	@FindBy(how = How.ID, using = "igLightbox")
	public WebElement	dlgConfirmPopup;

	// OK button on Confirm pop up
	// @CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseOK")
	public WebElement	btnOKConfirm;

	// Cancel button on Confirm pop up
	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseCancel")
	public WebElement	btnCancelConfirm;

	// Finish Transaction Button
	// @CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igFlowFinished")
	public WebElement	btnFinish;

	@FindBy(how = How.CLASS_NAME, using = "jPag-next")
	public WebElement	btnNextPageInTable;

}
