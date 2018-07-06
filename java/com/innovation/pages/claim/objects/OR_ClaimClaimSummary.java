package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author alamq. This captures the page elements for the New Claim Summary screen for Home LOB.
 *
 */
public class OR_ClaimClaimSummary
{

	// This element is used to click on "Claim Status" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_035_Status_10a")
	public WebElement		ddlClaimStatus;

	// This element is used to select "Override Owner" radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_035_OverrideOwnerChk_10a")
	public List<WebElement>	rdoOverrideOwner;

	// This element is used to select "New Owner" drop down value
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_035_OverrideOwner_10a")
	public WebElement		ddlNewOwner;

	// This element is used to select "Coverage issue" drop down value
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_035_PotentialCoverageIssue_10a")
	public WebElement		ddlCoverageIssue;

	// This element is used to select "Email Claim Summary" radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_035_SendMailChk_10a")
	public List<WebElement>	rdoEmailClaimSummary;

	// This element is used to enter data in "Email"
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_035_SummaryEmailAddr_10a")
	public WebElement		ddlEmail;

	// This element is used to select "NCD Impacted" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_035_NCD_Impacted_10a")
	public List<WebElement>	rdoNcdImpacted;

	// This element is used to select "Excess Confirmed to Policyholder" radio
	// button.
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_ExcessConfirmedIndicator_10a")
	public List<WebElement>	rdoExcessConfirmed;

	// This element will get claim number
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"title\"]/h1[1]")
	public WebElement		numClaim;

	// This element is used to click on "Claim Plan" section
	@CacheLookup
	@FindBy(how = How.ID, using = "tabSelectorDiv_1")
	public WebElement		pnlClaimPlan;

	// This element is used to click on "Reserve" section
	@CacheLookup
	@FindBy(how = How.ID, using = "tabSelectorDiv_2")
	public WebElement		pnlReserves;

	// This element is used to click on "Other" section
	@CacheLookup
	@FindBy(how = How.ID, using = "tabSelectorDiv_3")
	public WebElement		pnlOther;

	// This element is used to select "Flow Completed" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "FNOL_FlowFinished")
	public WebElement		btnFlowCompleted;

	// Below are the objects defined for Claim summary Back-office frame.

	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0008_CoverageIssues_10a")
	public WebElement		lblCoverageIssues;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0232_Liability_10a")
	public WebElement		lblLiabilityAssessment;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0008_SIUSummary_10a")
	public WebElement		lblSIUSummary;

	// Features table on BO Claim summary frame
	@CacheLookup
	@FindBy(how = How.ID, using = "tblFeatureList")
	public WebElement		tblFeatureList;

	// This is Open button on the pop up to open the feature
	@CacheLookup
	@FindBy(how = How.ID, using = "btn_Feature_Open")
	public WebElement		btnOpenFeature;

}
