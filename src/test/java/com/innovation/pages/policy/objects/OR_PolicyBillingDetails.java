package com.innovation.pages.policy.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author haiderm - This captures the page elements for the Policy Billing details screen.
 */

public class OR_PolicyBillingDetails
{

	/** Page Hidden values **/
	// Client Number or Client Sequence Number
	@FindBy(how = How.ID, using = "SC_MailingAddress_MailingClient")
	public WebElement		hdnClientNumber;

	/*** Billing client details section ***/

	// Billing client name
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Billing_BillingClientName")
	public WebElement		lblBillingClientName;

	// Billing client address
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Billing_BillingAddress")
	public WebElement		lblBillingClientAddress;

	// Insured's name
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientNameList")
	public WebElement		ddlInsuredName;

	// Billing address
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_BillingAddressList")
	public WebElement		ddlBillingAddress;

	// Add Client
	@CacheLookup
	@FindBy(how = How.ID, using = "btnAddClient")
	public WebElement		btnAddClient;

	// Maintain address
	@CacheLookup
	@FindBy(how = How.ID, using = "btnMaintain")
	public WebElement		btnMaintainAddress;

	/*** Account selection section ***/

	// Account selection
	@CacheLookup
	@FindBy(how = How.ID, using = "sectionSpan_xmlAssembled80")
	public List<WebElement>	pnlAccountSelection;

	// Account type
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AccountType_Radio")
	public List<WebElement>	rdoAccountType;

	// Bank account type
	@CacheLookup
	@FindBy(how = How.ID, using = "BNKAccount_AcctType")
	public WebElement		ddlBankAccountType;

	// Account number
	@CacheLookup
	@FindBy(how = How.ID, using = "AccountNumber")
	public WebElement		txtAccountNumber;

	// Sort code
	@CacheLookup
	@FindBy(how = How.ID, using = "BSBNumber")
	public WebElement		txtSortCode;

	// Add
	@CacheLookup
	@FindBy(how = How.ID, using = "btnAddAccount")
	public WebElement		btnAccountAdd;

	// Bank Account Details Pop-up

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"igLightbox\"]/div[1]/table/tbody/tr[1]/td[1]/h2")
	public WebElement		lgtPopUpBankAccount;

	@CacheLookup
	@FindBy(how = How.ID, using = "imgVerified")
	public WebElement		imgAccountStatus;

	// Close: Pop up
	@CacheLookup
	@FindBy(how = How.ID, using = "igLightboxContent")
	public List<WebElement>	lgtPopupClose;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnBankValidationClose")
	public WebElement		btnPopupClose;

	// Override
	@CacheLookup
	@FindBy(how = How.ID, using = "chkOverride")
	public WebElement		chkOverride;

	// Account selection table
	@CacheLookup
	@FindBy(how = How.ID, using = "tblAccountSelection")
	public WebElement		tblAccountSelection;

	// Assign
	@CacheLookup
	@FindBy(how = How.ID, using = "btnAcctSelAssign")
	public WebElement		btnAccountAssign;

	/*** Cybersource section ***/

	/** Billing information **/
	// First Name
	@CacheLookup
	@FindBy(how = How.ID, using = "bill_to_forename")
	public WebElement		txtFirstName;

	// Last Name
	@CacheLookup
	@FindBy(how = How.ID, using = "bill_to_surname")
	public WebElement		txtLastName;

	// Address line1
	@CacheLookup
	@FindBy(how = How.ID, using = "bill_to_address_line1")
	public WebElement		txtAddressLine1;

	// Address line2
	@CacheLookup
	@FindBy(how = How.ID, using = "bill_to_address_line2")
	public WebElement		txtAddressLine2;

	// City
	@CacheLookup
	@FindBy(how = How.ID, using = "bill_to_address_city")
	public WebElement		txtAddressCity;

	// Country
	@CacheLookup
	@FindBy(how = How.ID, using = "bill_to_address_country")
	public WebElement		txtAddressCountry;

	// State
	@CacheLookup
	@FindBy(how = How.ID, using = "bill_to_address_state")
	public WebElement		txtAddressState;

	// Zip code / Postal code
	@CacheLookup
	@FindBy(how = How.ID, using = "bill_to_address_postal_code")
	public WebElement		txtPostalCode;

	/** Payment details **/
	// Card type
	@CacheLookup
	@FindBy(how = How.NAME, using = "card_type")
	public List<WebElement>	rdoCardType;

	// Card Number
	@CacheLookup
	@FindBy(how = How.ID, using = "card_number")
	public WebElement		txtCardNumber;

	// Expiration date month
	@CacheLookup
	@FindBy(how = How.ID, using = "card_expiry_month")
	public WebElement		ddlExpirationMonth;

	// Expiration date year
	@CacheLookup
	@FindBy(how = How.ID, using = "card_expiry_year")
	public WebElement		ddlExpirationYear;

	// Next / Commit
	@CacheLookup
	@FindBy(how = How.NAME, using = "commit")
	public WebElement		btnNext;

	// Cancel
	@CacheLookup
	@FindBy(how = How.CSS, using = "#payment_details > input.left.cancelbutton")
	public WebElement		btnCancel;

	/** Review your Order **/
	// Edit address
	@CacheLookup
	@FindBy(how = How.CSS, using = "#main > div > div > div:nth-child(3) > div:nth-child(1) > div > fieldset > form > input.smallbutton")
	public WebElement		btnEditAddress;

	// Edit details
	@CacheLookup
	@FindBy(how = How.CSS, using = "#main > div > div > div:nth-child(4) > div > div > fieldset > form > input.smallbutton")
	public WebElement		btnEditDetails;

	// Back button
	@CacheLookup
	@FindBy(how = How.CSS, using = "#main > div > div > div:nth-child(5) > form > input.left")
	public WebElement		btnBack;

	// Finish button
	@CacheLookup
	@FindBy(how = How.CSS, using = "#main > div > div > div:nth-child(5) > form > input.right.complete")
	public WebElement		btnFinish;

	// Pay
	@CacheLookup
	@FindBy(how = How.CSS, using = "#main > div > div.review_container.group > div:nth-child(5) > form > input.right.complete.pay_button")
	public WebElement		btnPay;

	// Cancel order
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Cancel Order")
	public WebElement		lnkCancelOrder;

	// Cancel order pop up
	@CacheLookup
	@FindBy(how = How.CSS,
			using = "#review > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.no-close.ui-draggable.ui-resizable.ui-dialog-buttons > div.ui-dialog-buttonpane.ui-widget-content.ui-helper-clearfix > div > button:nth-child(1)")
	public WebElement		btnYes;

	@CacheLookup
	@FindBy(how = How.CSS,
			using = "#review > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.no-close.ui-draggable.ui-resizable.ui-dialog-buttons > div.ui-dialog-buttonpane.ui-widget-content.ui-helper-clearfix > div > button:nth-child(2)")
	public WebElement		btnNo;

	/*** Make Payment section ***/

	// Proceed without payment
	@CacheLookup
	@FindBy(how = How.ID, using = "pWoPayment")
	public WebElement		chkProceedWithoutPayment;

	// Receipt type
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentType_Combo")
	public WebElement		ddlReceiptType;

	// Received from
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentCash_RecivedFrom")
	public WebElement		txtReceivedFrom;

	/** When Receipt type = Cheque **/
	// Cheque Number
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentCheque_Number")
	public WebElement		txtChequeNumber;

	// Sort Code / Transit Number
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentCheque_TransitNum")
	public WebElement		txtTransitNumber;

	/** When Receipt type = Credit/ debit card **/
	// Existing account
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientAccount_Combo_333")
	public WebElement		ddlExisitingAccount;

	// New account
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientAccount_Radio_new")
	public WebElement		rdoNewAccount;

	// Store credit card details
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePayment_UseCreditCard")
	public List<WebElement>	rdoStoreCreditCardDetails;

	/** Receipt type = Cash **/
	// Current balance o/s
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_CAD_222")
	public WebElement		rdoCurrentBalance_Cash;

	// Total balance o/s
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_TAD_222")
	public WebElement		rdoTotalBalance_Cash;

	// Last billed amount
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_LBA_222")
	public WebElement		rdoLastBilledAmount_Cash;

	// Other
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_OAM_222")
	public WebElement		rdoOther_Cash;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePayment_Other_222")
	public WebElement		txtOther_Cash;

	/** Receipt type = Cheque **/
	// Current balance o/s
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_CAD_444")
	public WebElement		rdoCurrentBalance_Cheque;

	// Total balance o/s
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_TAD_444")
	public WebElement		rdoTotalBalance_Cheque;

	// Last billed amount
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_LBA_444")
	public WebElement		rdoLastBilledAmount_Cheque;

	// Other
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_OAM_444")
	public WebElement		rdoOther_Cheque;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePayment_Other_444")
	public WebElement		txtOther_Cheque;

	/** Receipt type = CC **/
	// Current balance o/s
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_CAD_333")
	public WebElement		rdoCurrentBalance_CC;

	// Total balance o/s
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_TAD_333")
	public WebElement		rdoTotalBalance_CC;

	// Last billed amount
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_LBA_333")
	public WebElement		rdoLastBilledAmount_CC;

	// Other
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_OAM_333")
	public WebElement		rdoOther_CC;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePayment_Other_333")
	public WebElement		txtOther_CC;

	// Reset
	@CacheLookup
	@FindBy(how = How.CSS, using = "#MakePaymentResetDiv > div > button")
	public WebElement		btnReset;

	// Confirmation Light box
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"igLightbox\"]/div[1]/table/tbody/tr[1]/td[1]/h2")
	public WebElement		popupConfirmation;

	@FindBy(how = How.XPATH, using = "//*[@id=\"igLightbox\"]/div[2]/table/tbody/tr/td[2]/label")
	public WebElement		lblReceiptNumber;

	// Confirmation Light box
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"SC_MakePaymentAmountFields_Amount_222\"]/table/tbody/tr/td[2]/label")
	public WebElement		labelCurrentBalance;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"igLightboxContent\"]/div[2]/button")
	public WebElement		btnComplete;

	// Generic
	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement		prgProgressbar;

}
