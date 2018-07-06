package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OR_ClaimComplaintsManagement
{

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_NewButton_20a")
	public WebElement	btnAddComplaint;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplainantName_20c")
	public WebElement	ddlName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComunicatedBy_20c")
	public WebElement	ddlCommunicatedBy;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ReferenceNumber_20c")
	public WebElement	txtReferenceNo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplaintProductType_20c")
	public WebElement	ddlProductType;

	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_743_ComplaintType_20c")
	public WebElement	cboType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplaintType_20c")
	public WebElement	cboTypeValues;

	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_743_ComplaintCategory_20c")
	public WebElement	cboCategory;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplaintCategory_20c")
	public WebElement	cboCategoryValues;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplaintRegulatoryIndicator_20c")
	public WebElement	ddlRegulatoryIndicator;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_Against_20c")
	public WebElement	txtAgainst;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplaintROOTCAUSECODE_20c")
	public WebElement	ddlRootCause;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplaintHowReceived_20c")
	public WebElement	ddlHowReceived;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_DateAcknowledged_20c")
	public WebElement	dtpDateAcknowledged;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_Summary_20c")
	public WebElement	txaSummary;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplaintStatus_20c")
	public WebElement	ddlStatus;

	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_743_ActionTaken_20c")
	public WebElement	cboCurrentStage;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ActionTaken_20c")
	public WebElement	cboCurrentStageValues;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplaintOwingTeam_20c")
	public WebElement	ddlOwningTeam;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplaintOwner_20c")
	public WebElement	ddlOwner;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_DetailsUpdate_20c")
	public WebElement	txaAddDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplaintHowResolved_20c")
	public WebElement	ddlHowResolved;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ResolutionDate_20c")
	public WebElement	dtpResolutionDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplaintOUTCOMECODE_20c")
	public WebElement	ddlOutcome;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_CompensationPaid_20c")
	public WebElement	txtCompensationPaid;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_ComplaintOutcome_20c")
	public WebElement	txaAdditionalDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_SaveButton_20c")
	public WebElement	btnSaveDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_743_CancelButton_20c")
	public WebElement	btnCancelDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseYes")
	public WebElement	btnCancelYes;

	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseNo")
	public WebElement	btnCancelNo;

}
