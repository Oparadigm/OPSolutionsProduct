package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Rizwan - defining the objects for 'MOJ Claims' frame accessible through Desktop > Navigation panel > Claims 
 *  
 */

public class OR_ClaimMOJClaims
{

	@FindBy(how = How.ID, using = "CLM_SC_RefreshData_10a")
	public WebElement		btnRefreshData;

	@FindBy(how = How.ID, using = "CLM_SC_CNF_DateFrom")
	public WebElement		txtFrom;

	@FindBy(how = How.ID, using = "CLM_SC_FetchData")
	public WebElement		btnApply;

	@FindBy(how = How.CLASS_NAME, using = "igErrorType")
	public WebElement		lblErrorType;

	@FindBy(how = How.LINK_TEXT, using = "CNF Ref no.")
	public WebElement		lnkCNFRefNo;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_ClaimStatusFilter_10a")
	public List<WebElement>	rdoFilterBy;

	@FindBy(how = How.ID, using = "CLM_SC_MOJClaims")
	public WebElement		tblMOJClaims;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_ViewCNFButton")
	public WebElement		btnViewCNF;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJClaimAction")
	public WebElement		ddlAction;

	@FindBy(how = How.ID, using = "CLM_SC_InsurerMatchedClaim")
	public WebElement		lblInsurerMatchedClaim;

	@FindBy(how = How.ID, using = "CLM_SC_InsurerClaimNum")
	public WebElement		txtClaimNumber;

	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_FetchClaimants")
	public WebElement		btnFetchClaimants;

	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_ClaimantsList")
	public WebElement		ddlClaimant;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionCancel")
	public WebElement		btnCancel;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_AcceptCNF")
	public WebElement		btnAcceptCNF;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJClaimActionUser")
	public WebElement		ddlUser;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJSaveUser")
	public WebElement		btnSave;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJInsurerName")
	public WebElement		txtInsurerSearch;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJSearchCompensator")
	public WebElement		btnSearch;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJInsurerList")
	public WebElement		ddlInsurers;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionReassignCancel")
	public WebElement		btnCancelReassign;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionReassignCNF")
	public WebElement		btnReassignCNF;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJClaimRejectionReason")
	public WebElement		ddlRejectionReason;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_RejectCNF")
	public WebElement		btnRejectCNF;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_OpenClaim")
	public WebElement		btnOpenClaim;

}
