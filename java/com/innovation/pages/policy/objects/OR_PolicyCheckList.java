package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Qasim - This captures the page elements for the Check List screen.
 * 
 */
public class OR_PolicyCheckList
{

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CheckList_DateFrom")
	public WebElement	txtSCCheckListDateFrom;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CheckList_SearchBy")
	public WebElement	ddlSCCheckListSearchBy;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CheckList_CancelReason")
	public WebElement	ddlSCCheckListCancelReason;

	@CacheLookup
	@FindBy(how = How.ID, using = "reqDetails_NewMailAdd")
	public WebElement	ddlReqDetailsNewMailAdd;

	@CacheLookup
	@FindBy(how = How.ID, using = "SoleDisbView")
	public WebElement	fldSoleDisbView;

	@CacheLookup
	@FindBy(how = How.ID, using = "DistView")
	public WebElement	fldDistView;

	@CacheLookup
	@FindBy(how = How.ID, using = "HoldDateView")
	public WebElement	fldHoldDateView;

}
