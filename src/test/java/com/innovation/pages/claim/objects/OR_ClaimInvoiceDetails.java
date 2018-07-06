package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author alamq - defining the objects for 'Invoice Details' frame accessible through BO Navigation panel > Supplier > Invoice Management
 *  
 */

public class OR_ClaimInvoiceDetails
{
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_EngineerInvoiceDetail_Fee_30f")
	public WebElement	txtEngineerInvoiceDetailFee;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_EngineerInvoiceDetail_Photographs_30f")
	public WebElement	txtEngineerInvoiceDetailPhotographs;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_EngineerInvoiceDetail_MileageTravel_30f")
	public WebElement	txtEngineerInvoiceDetailMileageTravel;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_EngineerInvoiceDetail_OtherCosts_30f")
	public WebElement	txtEngineerInvoiceDetailOtherCosts;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_EngineerInvoiceDetail_Contributions_30f")
	public WebElement	txtEngineerInvoiceDetailContributions;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_EngineerInvoiceDetail_TotalTax_30f")
	public WebElement	txtEngineerInvoiceDetailTotalTax;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_EngineerInvoiceDetail_TotalAmount_30f")
	public WebElement	txtEngineerInvoiceDetailTotalAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_EngineerInvoiceDetail_NetPayableToVendor_30f")
	public WebElement	txtEngineerInvoiceDetailNetPayableToVendor;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_JobType_${cfragmentID}_1")
	public List<WebElement>	rdoGlassInvoiceDetailJobType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_PartType_30g")
	public WebElement	ddlGlassInvoiceDetailPartType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_PartNumber_30g")
	public WebElement	txtGlassInvoiceDetailPartNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_LabourTotal_30g")
	public WebElement	txtGlassInvoiceDetailLabourTotal;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_PartsTotal_30g")
	public WebElement	txtGlassInvoiceDetailPartsTotal;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_OtherCosts_30g")
	public WebElement	txtGlassInvoiceDetailOtherCosts;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_Contributions_30g")
	public WebElement	txtGlassInvoiceDetailContributions;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_TotalTax_30g")
	public WebElement	txtGlassInvoiceDetailTotalTax;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_Registered_30g")
	public WebElement	chkGlassInvoiceDetailRegistered;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_Deductible_30g")
	public WebElement	txtGlassInvoiceDetailDeductible;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_Applicable_30g")
	public WebElement	chkGlassInvoiceDetailApplicable;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_TotalAmount_30g")
	public WebElement	txtGlassInvoiceDetailTotalAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_GlassInvoiceDetail_NetPayableToVendor_30g")
	public WebElement	txtGlassInvoiceDetailNetPayableToVendor;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_3553_Payee_30b")
	public WebElement	ddlPayee;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_3553_Claimant_30b")
	public WebElement	ddlClaimant;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_3553_InvNo_30b")
	public WebElement	txtInvNo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_3553_InvDate_30b")
	public WebElement	txtInvDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_3553_InvRecDate_30b")
	public WebElement	txtInvRecDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_3553_InvoiceType_30b")
	public WebElement	ddlInvoiceType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_3553_InvNetTotal_30b")
	public WebElement	txtInvNetTotal;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_3553_InvGST_30b")
	public WebElement	txtInvGST;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_3553_ClaimItems_30b")
	public WebElement	txtClaimItems;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_3553_InvoiceTypeClone_30b")
	public WebElement	ddlInvoiceTypeClone;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_InvoiceType_30j")
	public WebElement	ddlCLMSCBOInvoiceType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_InvoiceTypeProperty_30j")
	public WebElement	ddlCLMSCBOInvoiceTypeProperty;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_JobCompleted_30j")
	public List<WebElement>	rdoCLMSCBOJobCompleted;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_InterimBill_30j")
	public List<WebElement>	rdoCLMSCBOInterimBill;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_SatisfactionRating_30j")
	public WebElement	ddlCLMSCBOSatisfactionRating;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_AdditionalFeedback_30j")
	public WebElement	taCLMSCBOAdditionalFeedback;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_BO_3553_RepairInvoiceDetail_SatisfactionNote_30d")
	public WebElement	chkRepairInvoiceDetailSatisfactionNote;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_BO_3553_RepairInvoiceDetail_ChargesInvoice_30d")
	public WebElement	chkRepairInvoiceDetailChargesInvoice;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_BO_3553_RepairInvoiceDetail_EngineersAuthority_30d")
	public WebElement	chkRepairInvoiceDetailEngineersAuthority;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_BO_3553_RepairInvoiceDetail_Comments_30d")
	public WebElement	taRepairInvoiceDetailComments;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_ReasonforAdjusting_30d")
	public WebElement	ddlReasonforAdjusting;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_SaveButton_30h")
	public WebElement	btnSave;
	
	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_InvoiceTable")
	public WebElement	tblInvoiceType;

	@FindBy(how = How.ID, using = "CLM_SC_BO_3553_MakePaymentButton_30h")
	public WebElement	btnMakePayment;
	
}
