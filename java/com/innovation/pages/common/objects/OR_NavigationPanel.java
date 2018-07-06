package com.innovation.pages.common.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author haiderm - This captures the page elements for Navigation panel
 * 
 */

public class OR_NavigationPanel
{

	/** Desktop view **/
	/** General span / panel **/
	@FindBy(how = How.XPATH, using = "//span[.='General']")
	public WebElement	pnlGeneral;

	// Personal inbox
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Personal inbox")
	public WebElement	lnkPersonalInbox;

	// Team inbox
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Team inbox")
	public WebElement	lnkTeamInbox;

	// Authorizations
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Authorizations")
	public WebElement	lnkAuthorizations;

	// Tracking grid
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Tracking grid")
	public WebElement	lnkTrackingGrid;

	// Team management
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Team management")
	public WebElement	lnkTeamManagement;

	// Leave management
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Leave management")
	public WebElement	lnkLeaveManagement;

	// Work management
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Work management")
	public WebElement	lnkWorkManagement;

	// User activity log
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "User activity log")
	public WebElement	lnkUserActivityLog;

	/** Claims span / panel **/
	@FindBy(how = How.XPATH, using = "//span[.='Claims']")
	public WebElement	pnlClaims;

	// Litigation
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Litigation")
	public WebElement	lnkLitigation;

	// Subrogation
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Subrogation")
	public WebElement	lnkSubrogation;

	// Event management
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Event management")
	public WebElement	lnkEventManagement;

	// SIU
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "SIU")
	public WebElement	lnkSIU;

	// Salvage management
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Salvage management")
	public WebElement	lnkSalvageManagement;

	// MOJ Claims
	@FindBy(how = How.LINK_TEXT, using = "MOJ Claims")
	public WebElement	lnkMOJClaims;

	// MOJ Summary
	@FindBy(how = How.LINK_TEXT, using = "MOJ summary")
	public WebElement	lnkMOJSummary;

	/** Business administration span / panel **/
	@FindBy(how = How.XPATH, using = "//span[.='Business administration']")
	public WebElement	pnlBusinessAdministration;

	// Currency administration
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Currency administration")
	public WebElement	lnkCurrencyAdministration;

	// Document administration
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Document administration")
	public WebElement	lnkDocumentaAministration;

	// Document indexing
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Document indexing")
	public WebElement	lnkDocumentIndexing;

	// Password administration
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Password administration")
	public WebElement	lnkPasswordAdministration;

	// CMS exceptions
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "CMS exceptions")
	public WebElement	lnkCMSExceptions;

	/** Policy span / panel **/
	@FindBy(how = How.XPATH, using = "//span[.='Policy']")
	public WebElement	pnlPolicy;

	// Renewal activities
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Renewal activities")
	public WebElement	lnkRenewalActivities;

	// Renewal exceptions
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Renewal exceptions")
	public WebElement	lnkRenewalExceptions;

	// Locked quote/policy
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Locked quote/policy")
	public WebElement	lnkLockedQuotePolicy;

	// Event moratoriums
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Event moratoriums")
	public WebElement	lnkEventMoratoriums;

	/** Billing Span / panel **/
	@FindBy(how = How.XPATH, using = "//span[.='Billing']")
	public WebElement	pnlBilling;

	// Direct billing
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Direct billing")
	public WebElement	lnkDirectBilling;

	// Agency billing
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Agency billing")
	public WebElement	lnkAgencyBilling;

	// Accounts receivable
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Accounts receivable")
	public WebElement	lnkAccountsReceivable;

	// Make a payment
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Make a payment")
	public WebElement	lnkMakeAPayment;

	// Multiple cheque list
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Multiple cheque list")
	public WebElement	lnkMultipleChequeList;

	// Receipt list
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Receipt list")
	public WebElement	lnkReceiptList;

	// EFT list
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "EFT list")
	public WebElement	lnkEFTList;

	// Daily payment summary
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Daily payment summary")
	public WebElement	lnkDailyPaymentSummary;

	// Processor detail
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Processor detail")
	public WebElement	lnkProcessorDetail;

	// Post dated due
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Post dated due")
	public WebElement	lnkPostDatedDue;

	// Bank deposit
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Bank deposit")
	public WebElement	lnkBankDeposit;

	// Accounts Payable Accordion
	@FindBy(how = How.LINK_TEXT, using = "Accounts payable")
	public WebElement	lnkAccountsPayable;

	// Create requisition
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Create requisition")
	public WebElement	lnkCreateRequisition;

	// Requisition list
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Requisition list")
	public WebElement	lnkRequisitionList;

	// Check run list
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Check run list")
	public WebElement	lnkCheckRunList;

	// Check list
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Check list")
	public WebElement	lnkCheckList;

	// Extract checks
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Extract cheques")
	public WebElement	lnkExtractCheques;

	// Extract checks
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Extract checks")
	public WebElement	lnkExtractChecks;

	
	// Process Commission
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Process Commission")
	public WebElement	lnkProcessCommission;

	// Next activities
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Next activities")
	public WebElement	lnkNextActivities;

	// Unlock
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Unlock")
	public WebElement	lnkUnlock;

	/** Supplier management / panel **/
	@FindBy(how = How.XPATH, using = "//span[.='Supplier management']")
	public WebElement	pnlSupplierManagement;

	// Supplier search
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Supplier search")
	public WebElement	lnkSupplierSearch;

	// Master fee management
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Master fee management")
	public WebElement	lnkMasterFeeManagement;

	// Master salvage management
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Master salvage management")
	public WebElement	lnkMasterSalvageManagement;

	/** Agent management span / panel **/
	@FindBy(how = How.XPATH, using = "//span[.='Agent management']")
	public WebElement	pnlAgentManagement;

	// Search
	@CacheLookup
	@FindBy(how = How.CSS, using = "a[href*='AG_FR_AgentSearch']")
	public WebElement	lnkSearch;

	// View agent
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "View agent")
	public WebElement	lnkViewAgent;

	// Company management
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Company management")
	public WebElement	lnkCompanyManagement;

	// Profile management
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Profile management")
	public WebElement	lnkProfileManagement;

	// Licence management
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Licence management")
	public WebElement	lnkLicenceManagement;

	// For US Region
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "License management")
	public WebElement	lnkLicenseManagement;

	// Portfolio management
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Portfolio management")
	public WebElement	lnkPortfolioManagement;

	/** Financials span / panel **/
	@FindBy(how = How.XPATH, using = "//span[.='Financials']")
	public WebElement	pnlFinancials;

	// Financial audit trail
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Financial audit trail")
	public WebElement	lnkFinancialAuditTrail;

	// Financial reports
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Financial reports")
	public WebElement	lnkFinancialReports;

	// View reports
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "View reports")
	public WebElement	lnkViewReports;

	// Unreconciled items
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Unreconciled items")
	public WebElement	lnkUnreconciledItems;

	// End of year rollover
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "End of year rollover")
	public WebElement	lnkEndOfYearRollover;

	// Batch Administration
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Batch Administration")
	public WebElement	lnkBatchAdministration;

	// Functions menu in Navigation panel under left accordion menu in Claims BO
	@FindBy(how = How.XPATH, using = "//span[.='Functions']")
	public WebElement	pnlBOFunctions;

	// Validation option in Navigation panel>Functions under left accordion menu
	// in
	// Claims BO for Property claim
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Validation")
	public WebElement	lnkValidation;

	// Litigation option for Property claim under left accordion menu in Claims
	// BO
	@FindBy(how = How.XPATH, using = "//span[.='Litigation']")
	public WebElement	pnlBOLitigation;

	// Details option under Litigation menu for Property claim under Left
	// accordion
	// menu
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Details")
	public WebElement	lnkDetailsLitigation;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[.='Financials']")
	public WebElement	pnlBOFinancials;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Log payment")
	public WebElement	lnkLogPayment;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Manage reserves")
	public WebElement	lnkManageReserve;

	// @CacheLookup
	@FindBy(how = How.XPATH, using = "//span[.='Bodily injury']")
	public WebElement	pnlBOBodilyInjury;

	@FindBy(how = How.LINK_TEXT, using = "MOJ actions")
	public WebElement	lnkMOJActions;

	// This is used to click on 'Moj Communication' link under Navigation panel for
	// Bodily Injury feature
	// @CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "MOJ communications")
	public WebElement	lnkMOJCommunications;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[.='SIU']")
	public WebElement	pnlBOSIU;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Manage SIU referral/update score")
	public WebElement	lnkManageSIUReferral;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Spotlight")
	public WebElement	lnkSIUSpotlight;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[.='Vehicle actions']")
	public WebElement	pnlVehicleActions;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Policy")
	public WebElement	lnkBOPolicy;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[.='Property damage']")
	public WebElement	pnlPropertyDamageActions;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Add new item")
	public WebElement	lnkAddNewItem;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Update")
	public WebElement	lnkVehicleUpdate;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Maintain coverages")
	public WebElement	lnkMaintainCovers;

	// This element is used to click on Vehicle Damage --> Supplier link under
	// Navigation panel for IVD feature
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Suppliers")
	public WebElement	lnkSupplier;

	// This element is used to click on Supplier --> Estimate link under Navigation
	// panel for IVD feature
	@FindBy(how = How.LINK_TEXT, using = "Estimate")
	public WebElement	lnkEstimate;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[.='Correspondence']")
	public WebElement	pnlCorrespondence;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Summary")
	public WebElement	lnkCorrespondenceSummary;

	// This element is used to click on Communication --> Manage Correspondence link under Navigation panel for Policy BO

	@FindBy(how = How.XPATH, using = "//span[.='Communication']")
	public WebElement	pnlCommunication;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Manage correspondence")
	public WebElement	lnkManageCorrespondence;

	// The following element is used to click on the Direct Billing Actions via Direct Billing Span on Policy Summary Screen

	// View Policy Accordion

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[.='View Policy']")
	public WebElement	pnlViewPolicy;

	// The following View Policy Accordion Link is for MOUK region
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[.='View policy']")
	public WebElement	pnlViewPolicy_UK;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Direct billing")
	public WebElement	lnkDirectBillingForPolicy;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[.='Direct bill actions']")
	public WebElement	pnlDirectBillingActions;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Maintain next activity")
	public WebElement	lnkMaintainNextActivity;

}
