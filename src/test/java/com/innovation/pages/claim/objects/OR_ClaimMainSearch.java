package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
*  @author Qasim Alam. This captures the page elements for Main Search screen in Home/Auto LOB.
*   
*/
public class OR_ClaimMainSearch
{

	// This element is used to select 'Claim' radio button under Search For section

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@value=\"Claim\"] ")
	public WebElement		rdoSearchForClaim;

	// This element is used to select 'Policy' radio button under Search For section
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@value=\"Policy\"] ")
	public WebElement		rdoSearchForPolicy;

	// This element is used to select 'Client' radio button under Search For section
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@value=\"Client\"] ")
	public WebElement		rdoSearchForClient;

	// This element is used to select 'Search By' drop down list

	@FindBy(how = How.ID, using = "selSearchType")
	public WebElement		ddlSearchBy;

	// This element is used to enter Claim Number

	@FindBy(how = How.ID, using = "CLM_SC_500_ClaimNumber")
	public WebElement		txtClaimNo;

	// This element is used to enter Policy Number

	@FindBy(how = How.ID, using = "CLM_SC_099_PolicyNumber")
	public WebElement		txtPolicyNo;

	// This element is used to enter data in Number Plate text file

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_VRN")
	public WebElement		txtNumberPlate;

	// This element is used to enter date in Loss date field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_IncidentDate_2")
	public WebElement		txtLossDate;

	// This element is used to enter data in Reference number field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_ClientNum")
	public WebElement		txtReferenceNumber;

	// This element is used to enter data in Reference number field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_NIN")
	public WebElement		txtNiNumber;

	// This element is used to enter data in Reference number field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_VIN")
	public WebElement		txtVIN;

	// This element is used to enter data in Reference number field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_VIN")
	public WebElement		txtClientNumber;

	// This element is used to click on 'Search' button

	@FindBy(how = How.ID, using = "Search")
	public WebElement		btnSearch;

	// This element is used to click on 'Open' button

	@CacheLookup

	@FindBy(how = How.XPATH, using = "//*[@value=\"Open\"] ")
	public WebElement		btnOpenClaim;

	@CacheLookup
	@FindBy(how = How.ID, using = "tblPolicySearch")
	public WebElement		tblPolicySearch;

	@CacheLookup
	@FindBy(how = How.ID, using = "tblClaimSearch")
	public WebElement		tblClaimSearch;

	@CacheLookup
	@FindBy(how = How.NAME, using = "DPA_CheckStatusIndicator")
	public List<WebElement>	rdoDPACheckPassed;

	@CacheLookup
	@FindBy(how = How.ID, using = "DPA_FailureReason")
	public WebElement		ddlDPAFailureReason;

	@CacheLookup
	@FindBy(how = How.ID, using = "selPolicyAction")
	public WebElement		ddlActions;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@value=\"Go\"] ")
	public WebElement		btnGO;

	@FindBy(how = How.ID, using = "igLightbox")
	public WebElement		dlgDuplicateClaim;

	@FindBy(how = How.ID, using = "dupeClaimAdd")
	public WebElement		btnDuplicateClaimAdd;

	@CacheLookup
	@FindBy(how = How.ID, using = "dupeClaimLBCancel")
	public WebElement		btnDuplicateClaimCancel;

	@FindBy(how = How.ID, using = "igUserInteractResponseYes")
	public WebElement		btnResetYes;

	@FindBy(how = How.ID, using = "igUserInteractResponseNo")
	public WebElement		btnResetNo;

	@FindBy(how = How.XPATH, using = "//*[@id='userControl_quickSearchIcon']")
	public WebElement		imgSearch;

	@FindBy(how = How.LINK_TEXT, using = "Claim search")
	public WebElement		btnClaimSearch;

	@FindBy(how = How.LINK_TEXT, using = "Policy search")
	public WebElement		btnPolicySearch;

	@FindBy(how = How.LINK_TEXT, using = "Policy client search")
	public WebElement		btnPolicyClientSearch;

	@CacheLookup
	@FindBy(how = How.ID, using = "Claim_IncidentDate")
	public WebElement		dtIncidentDate;
}
