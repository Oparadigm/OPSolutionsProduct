
package com.innovation.pages.claim.objects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * @author Alamq. This captures the page elements for the "Work Status" screen in BO. 
 * 
 */
public class OR_ClaimWorkStatus
{
	
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0074_NewClaimStatus_30a")
	public WebElement	ddlNewClaimStatus;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0074_Reason_30a")
	public WebElement	ddlReason;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0074_DuplicateClaimNumber_30a")
	public WebElement	txtDuplicateClaimNumber;

	@FindBy(how = How.ID, using = "CLM_SC_BO_0075_ChangeStatus_50a")
	public WebElement	btnChangeStatus;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0074_ViewHistory_30a")
	public WebElement	btnViewHistory;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0075_Cancel_30a")
	public WebElement	btnCancel;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_BO_0075_NewStatus_40a")
	public WebElement	ddlNewStatus;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0075_Reason_40a")
	public WebElement	ddlReason40a;

	@FindBy(how = How.ID, using = "CLM_SC_BO_0076_NewStatus_50a")
	public WebElement	ddlNewStatus50a;

	@FindBy(how = How.ID, using = "CLM_SC_BO_0076_Reason_50a")
	public WebElement	ddlReason50a;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0076_DuplicateClaimNumber_50a")
	public WebElement	txtDuplicateClaimNumber50a;

	@FindBy(how = How.NAME, using = "CLM_SC_BO_0096_AttachTo_20a")
	public WebElement	rdoClaim;

	@FindBy(how = How.ID, using = "CLM_SC_BO_0096_Feature_20a")
	public WebElement	ddlFeature;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_TeamTypeCombo")
	public WebElement	ddlTeamType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0196_TeamCombo")
	public WebElement	ddlTeam;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_AssignmentCombo")
	public WebElement	ddlAssignment;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0196_UserCombo")
	public WebElement	ddlUser;
	
	@FindBy(how = How.ID, using = "igUserInteractResponseYes")
	public WebElement	btnYes;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseNo")
	public WebElement	btnNo;
		
}
