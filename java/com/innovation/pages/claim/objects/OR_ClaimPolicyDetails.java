package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Kamran Mahmood  This will capture page elements of claims policy details screen
 */

public class OR_ClaimPolicyDetails
{

	// Tabs on the policy frame

	@CacheLookup
	@FindBy(how = How.ID, using = "tabSelectorDiv_1")
	public WebElement	tabRisks;

	@CacheLookup
	@FindBy(how = How.ID, using = "tabSelectorDiv_2")
	public WebElement	tabPolicyHolder;

	@CacheLookup
	@FindBy(how = How.ID, using = "tabSelectorDiv_3")
	public WebElement	tabBrokerDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "tabSelectorDiv_4")
	public WebElement	tabClaimHistory;

	@CacheLookup
	@FindBy(how = How.ID, using = "tabSelectorDiv_5")
	public WebElement	tabEventManagement;

	// fields on the claims history tab

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_AddLossDetails_30a")
	public WebElement	btnAddClaimHistory;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_ClaimNumber_30a")
	public WebElement	txtClaimNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_IncidentDate_30a")
	public WebElement	txtincidentdate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_PerilCode_30a")
	public WebElement	lstTypeOfClaim;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_LossCause_30a")
	public WebElement	lstIncidentType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_Insurer_30a")
	public WebElement	txtInsurer;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_NCD_Impacted_30a")
	public WebElement	rdoNCDImpacted;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_Status_30a")
	public WebElement	lstStatus;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_Amount_30a")
	public WebElement	txtAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_Source_30a")
	public WebElement	lstSource;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_AddLossDetails_30a")
	public WebElement	btnAdd;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_ClearLoss_30a")
	public WebElement	btnClear;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_012_SaveLoss_30a")
	public WebElement	btnSave;

}
