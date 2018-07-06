package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Alamq- This captures the page elements for the Requisition List screen.
 * 
 */
public class OR_PolicyRequisitionList
{

	@CacheLookup
	@FindBy(how = How.ID, using = "reqDetails_RejectionReason")
	public WebElement	ddlReqDetailsRejectionReason;

	@CacheLookup
	@FindBy(how = How.ID, using = "InPaymentView")
	public WebElement	fldInPaymentView;

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

	@CacheLookup
	@FindBy(how = How.ID, using = "ReqList_ReqType")
	public WebElement	ddlReqListReqType;

	@CacheLookup
	@FindBy(how = How.ID, using = "ReqList_ProcBranch")
	public WebElement	ddlReqListProcBranch;

	@CacheLookup
	@FindBy(how = How.ID, using = "ReqList_SearchBy")
	public WebElement	ddlReqListSearchBy;

	@CacheLookup
	@FindBy(how = How.ID, using = "ReqList_FromDate")
	public WebElement	txtReqListFromDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "ReqList_SearchBy_Value")
	public WebElement	txtSearchByValue;

	@FindBy(how = How.ID, using = "btnSearch")
	public WebElement	btnSearch;

	@CacheLookup
	@FindBy(how = How.ID, using = "ReqList_IncAuthReject")
	public WebElement	chkReqListIncAuthReject;

	@CacheLookup
	@FindBy(how = How.NAME, using = "ReqList_Print_List")
	public WebElement	btnReqListPrintList;

	@CacheLookup
	@FindBy(how = How.NAME, using = "ReqList_Auth_List")
	public WebElement	btnReqListAuthList;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnAuthorize")
	public WebElement	btnAuthorize;

	@FindBy(how = How.ID, using = "tblReqList")
	public WebElement	tblRequisitionList;

}
