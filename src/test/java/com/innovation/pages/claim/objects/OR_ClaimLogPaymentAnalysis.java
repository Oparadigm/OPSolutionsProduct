package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Kamal - defining the objects for Analysis frame in Claims BO Log Payment flow 
 *  
 */

public class OR_ClaimLogPaymentAnalysis
{

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0111_Risk_50a")
	public WebElement	ddlRisk;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0111_CoverageCombined_50a")
	public WebElement	ddlCoverageFeature;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0111_ReserveType_50a")
	public WebElement	ddlReserveType;

	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0111_PaymentCode_50a")
	public WebElement	ddlPaymentCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0111_Amount_50a")
	public WebElement	txtPaymentAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0111_DeductibleApplied_50a")
	public WebElement	txtExcessAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0111_PaymentType_50a")
	public WebElement	ddlPaymentType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0111_LinePaymentAdd_50a")
	public WebElement	btnAddPayment;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0111_LinePaymentClear_50a")
	public WebElement	btnClearDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0111_NonStandardPayment_50a")
	public WebElement	ddlNonStandardPayment;
}
