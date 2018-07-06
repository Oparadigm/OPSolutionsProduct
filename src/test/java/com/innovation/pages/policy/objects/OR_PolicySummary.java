package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs & haiderm - This captures the page elements for the Policy summary screen.
 * 
 */
public class OR_PolicySummary
{

	// Quote Number
	@CacheLookup
	@FindBy(how = How.ID, using = "QTE_SC_Number_31")
	public WebElement	lblQuoteNumber;

	// Available bill plans table - Annual Direct Debit

	@FindBy(how = How.ID, using = "BILLPLANDESC")
	public WebElement	tblBillPlanDesc;

	@CacheLookup
	@FindBy(how = How.ID, using = "ANDD")
	public WebElement	tblAnnualDirectDebit;

	// Available bill plans table - Annual Card
	@CacheLookup
	@FindBy(how = How.ID, using = "CARD")
	public WebElement	tblAnnualCard;

	// Available bill plans table - Temp Agency Bill plan
	@CacheLookup
	@FindBy(how = How.ID, using = "DAGT")
	public WebElement	tblTempAgencyBillPlan;

	// Available bill plans table - Monthly Direct Debit
	@CacheLookup
	@FindBy(how = How.ID, using = "MNDD")
	public WebElement	tblMonthlyDirectDebit;

	// Available Bill Plans for Model Office US
	@CacheLookup
	@FindBy(how = How.ID, using = "1PAY")
	public WebElement	tblOnePay;

	@CacheLookup
	@FindBy(how = How.ID, using = "AGT")
	public WebElement	tblAgentBillPlan;

	@CacheLookup
	@FindBy(how = How.ID, using = "MDIR")
	public WebElement	tblMonthlyDirectBill;

	@CacheLookup
	@FindBy(how = How.ID, using = "MEFT")
	public WebElement	tblMonthlyEFT;

	@CacheLookup
	@FindBy(how = How.ID, using = "QDIR")
	public WebElement	tblQuarterlyDirectBill;

	@CacheLookup
	@FindBy(how = How.ID, using = "QEFT")
	public WebElement	tblQuarterlyEFT;

	// Select Button
	@CacheLookup
	@FindBy(how = How.ID, using = "btnMultiBillPlanOptions_Select")
	public WebElement	btnSelect;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgressbar;

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igFlowNext")
	public WebElement	btnProceedNext;

	// Transaction Status
	@CacheLookup
	@FindBy(how = How.ID, using = "lblQuoteStatus")
	public WebElement	lblTransactionStatus;

	@CacheLookup
	@FindBy(how = How.ID, using = "lblPolStatus")
	public WebElement	lblPolicyTransactionStatus;

	// Billing and Premium Section

	@CacheLookup
	@FindBy(how = How.ID, using = "lblAmountDue")
	public WebElement	lblAmountDueNow;

}
