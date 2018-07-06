package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs This captures the page elements for the Policy Preliminary Questions screen.
 * 
 */
public class OR_PolicyPropertyHub
{
	/**
	 * @param args
	 */

	// Add new drop down - select "Homeowners"
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Property_RiskType")
	public WebElement	ddlAddNew;

	// Check for the text Property search
	@CacheLookup
	@FindBy(how = How.ID, using = "expDivProperty.Search")
	public WebElement	txaPropertySearch;

	// Use existing address drop down.
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PropertySearch_UseExisting")
	public WebElement	ddlUseExistingAddress;

	// Add button
	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_PropertyHub_LocationAdd")
	public WebElement	btnAdd;

	// Progress Bar
	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgress;

	// Proceed Next Button
	@CacheLookup
	@FindBy(how = How.ID, using = "flowBtnContinue")
	public WebElement	btnProceedNext;

	// EditDetails button of property
	@CacheLookup
	@FindBy(how = How.ID, using = "btnEditDetails")
	public WebElement	btnEditPropertyDetails;

	// Table of existing property
	@CacheLookup
	@FindBy(how = How.ID, using = "tblProperty")
	public WebElement	tblPropertyDetails;

}
