package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Kamal - defining the objects for Claim payment frame in Claims BO Log Payment flow. 
 */

public class OR_ClaimLogPaymentClaimPayment
{

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO__PaymentMethod_30a")
	public WebElement	ddlPaymentMethod;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_013_SelectedAccount_30a")
	public WebElement	ddlAccountNoBACS;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO__DeliveryMethod_30a")
	public WebElement	ddlDeliveryMethod;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO__AccountNo_30a")
	public WebElement	txtAccountNo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_ChequeNo_30a")
	public WebElement	txtChequeNo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_ChequeDate_30a")
	public WebElement	dtpChequeDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO__FromDate_30a")
	public WebElement	dtpFromDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO__ToDate_30a")
	public WebElement	dtpToDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO__ReferenceId_30a")
	public WebElement	txtReferenceId;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO__InvoiceId_30a")
	public WebElement	txtInvoiceId;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO__Memo_30a")
	public WebElement	txaMemo;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"igLegend30a\"]/table[2]/tbody/tr/td[2]/div/button")
	public WebElement	btnMoreDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0110_ServiceDescription_30b")
	public WebElement	txtServiceDescription;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0110_Date_30b")
	public WebElement	dtpPaymentDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0110_AmountClaimed_30b")
	public WebElement	txtAmountClaimed;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0110_PaymentExplanationAdd_30b")
	public WebElement	btnAddPaymentDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0110_PaymentExplanationClear_30b")
	public WebElement	btnClearPaymentDetails;

}
