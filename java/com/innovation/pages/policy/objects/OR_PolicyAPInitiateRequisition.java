package com.innovation.pages.policy.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Alamq - This captures the page elements for the Policy Initiate Requisition screen.
 * 
 */
public class OR_PolicyAPInitiateRequisition
{

	@CacheLookup
	@FindBy(how = How.ID, using = "AP_RRInPaymentOf")
	public WebElement		ddlAPRRInPaymentOf;

	@CacheLookup
	@FindBy(how = How.ID, using = "AP_RRSolDisbMetd")
	public WebElement		chkAPRRSolDisbMetd;

	@CacheLookup
	@FindBy(how = How.ID, using = "AP_RRDisbMetd")
	public WebElement		ddlAPRRDisbMetd;

	@CacheLookup
	@FindBy(how = How.ID, using = "AP_RRIssuedby")
	public WebElement		ddlAPRRIssuedby;

	@CacheLookup
	@FindBy(how = How.ID, using = "AP_RRcheckNum")
	public WebElement		txtAPRRcheckNum;

	@CacheLookup
	@FindBy(how = How.ID, using = "AP_RRDistribution")
	public WebElement		ddlAPRRDistribution;

	@CacheLookup
	@FindBy(how = How.ID, using = "AP_RRIssuedate")
	public WebElement		txtAPRRIssuedate;

	@CacheLookup
	@FindBy(how = How.ID, using = "AP_RRHolddate")
	public WebElement		txtAPRRHolddate;

	@CacheLookup
	@FindBy(how = How.ID, using = "AP_RRcDistribution")
	public WebElement		ddlAPRRcDistribution;

	@CacheLookup
	@FindBy(how = How.ID, using = "AP_RRcHolddate")
	public WebElement		txtAPRRcHolddate;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AccountType_Radio")
	public List<WebElement>	rdoSCAccountTypeRadio;

	@CacheLookup
	@FindBy(how = How.ID, using = "BNKAccount_AcctType")
	public WebElement		ddlBNKAccountAcctType;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AccountNumber")
	public WebElement		txtSCAccountNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_BSBNumber")
	public WebElement		txtSCBSBNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "PayeeDetails_OverrideName")
	public WebElement		taPayeeDetailsOverrideName;

	@CacheLookup
	@FindBy(how = How.ID, using = "ReqHeader_ReqType")
	public WebElement		ddlRequisitionType;

	@CacheLookup
	@FindBy(how = How.ID, using = "ReqHeader_PolNum")
	public WebElement		txtPolicyNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "ReqHeader_Agent")
	public WebElement		txtReqHeaderAgent;

	@CacheLookup
	@FindBy(how = How.ID, using = "ReqHeader_AgentSuffix")
	public WebElement		ddlReqHeaderAgentSuffix;

	@CacheLookup
	@FindBy(how = How.ID, using = "Withholdings_1099")
	public WebElement		chkWithholdings1099;

	@CacheLookup
	@FindBy(how = How.ID, using = "Withholdings_WithholdType")
	public WebElement		ddlWithholdingsWithholdType;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_LastName")
	public WebElement		txtSCClientSearchLastName;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_FirstName")
	public WebElement		txtSCClientSearchFirstName;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_CompanyName")
	public WebElement		txtSCClientSearchCompanyName;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_City")
	public WebElement		txtSCClientSearchCity;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_PostCode")
	public WebElement		txtSCClientSearchPostCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_PhoneNum")
	public WebElement		txtSCClientSearchPhoneNum;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_SSN")
	public WebElement		txtSCClientSearchSSN;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_TaxID")
	public WebElement		txtSCClientSearchTaxID;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnGo")
	public WebElement		btnGo;

	@FindBy(how = How.ID, using = "btnContinue")
	public WebElement		btnContinue;

}
