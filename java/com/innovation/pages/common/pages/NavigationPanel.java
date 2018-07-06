package com.innovation.pages.common.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.misc.TableHandler;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.common.objects.OR_NavigationPanel;

/**
 * @author haiderm - This class will store all the locators and methods of the Navigation panel.
 */

public class NavigationPanel
{

	WebDriver			driver;
	LoggingControl		loggingcontrol		= new LoggingControl ();
	OR_NavigationPanel	orNavigationPanel	= null;
	OR_ControlPanel		orControlPanel		= null;

	public NavigationPanel (WebDriver driver)
	{
		this.driver = driver;
		orNavigationPanel = PageFactory.initElements (driver, OR_NavigationPanel.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	/** Desktop view **/
	/** General span / panel **/
	public void expandGeneralSpan ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlGeneral));
		orNavigationPanel.pnlGeneral.click ();
	}

	// Personal inbox
	public void clickPersonalInbox ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkPersonalInbox));
		orNavigationPanel.lnkPersonalInbox.click ();
	}

	// Team inbox
	public void clickTeamInbox ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkTeamInbox));
		orNavigationPanel.lnkTeamInbox.click ();
	}

	// Authorizations
	public void clickAuthorizations ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkAuthorizations));
		orNavigationPanel.lnkAuthorizations.click ();
	}

	// Tracking grid
	public void clickTrackingGrid ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkTrackingGrid));
		orNavigationPanel.lnkTrackingGrid.click ();
	}

	// Team management
	public void clickTeamManagement ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkTeamManagement));
		orNavigationPanel.lnkTeamManagement.click ();
	}

	// Leave management
	public void clickLeaveManagement ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkLeaveManagement));
		orNavigationPanel.lnkLeaveManagement.click ();
	}

	// Work management
	public void clickWorkManagement ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkWorkManagement));
		orNavigationPanel.lnkWorkManagement.click ();
	}

	// User activity log
	public void clickUserActivityLog ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkUserActivityLog));
		orNavigationPanel.lnkUserActivityLog.click ();
	}

	/** Claims span / panel **/
	public void expandClaimsSpan ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		SeleniumWaiter.elementIsLoaded (orNavigationPanel.pnlClaims);
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlClaims));
		orNavigationPanel.pnlClaims.click ();
	}

	// Litigation
	public void clickLitigation ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkLitigation));
		orNavigationPanel.lnkLitigation.click ();
	}

	// Subrogation
	public void clickSubrogation ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkSubrogation));
		orNavigationPanel.lnkSubrogation.click ();
	}

	// Event management
	public void clickEventManagement ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkEventManagement));
		orNavigationPanel.lnkEventManagement.click ();
	}

	// SIU
	public void clickSIU ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkSIU));
		orNavigationPanel.lnkSIU.click ();
	}

	// Salvage management
	public void clickSalvageManagement ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkSalvageManagement));
		orNavigationPanel.lnkSalvageManagement.click ();
	}

	// MOJ Claims
	public void clickMOJClaims ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getLongWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkMOJClaims));
		orNavigationPanel.lnkMOJClaims.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// MOJ Summary
	public void clickMOJSummary ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkMOJSummary));
		orNavigationPanel.lnkMOJSummary.click ();
	}

	/** Business administration span / panel **/
	public void expandBusinessAdministrationSpan ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlBusinessAdministration));
		orNavigationPanel.pnlBusinessAdministration.click ();
	}

	// Currency administration
	public void clickCurrencyAdministration ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkCurrencyAdministration));
		orNavigationPanel.lnkCurrencyAdministration.click ();
	}

	// Document administration
	public void clickDocumentAdministration ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkDocumentaAministration));
		orNavigationPanel.lnkDocumentaAministration.click ();
	}

	// Document indexing
	public void clickDocumentIndexing ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkDocumentIndexing));
		orNavigationPanel.lnkDocumentIndexing.click ();
	}

	// Password administration
	public void clickPasswordAdministration ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkPasswordAdministration));
		orNavigationPanel.lnkPasswordAdministration.click ();
	}

	// CMS exceptions
	public void clickCMSExceptions ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkCMSExceptions));
		orNavigationPanel.lnkCMSExceptions.click ();
	}

	/** Policy span / panel **/
	public void expandPolicySpan ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlPolicy));
		orNavigationPanel.pnlPolicy.click ();
	}

	// Renewal activities
	public void clickRenewalActivities ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkRenewalActivities));
		orNavigationPanel.lnkRenewalActivities.click ();
	}

	// Renewal exceptions
	public void clickRenewalExceptions ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkRenewalExceptions));
		orNavigationPanel.lnkRenewalExceptions.click ();
	}

	// Locked quote/policy
	public void clickLockedQuotePolicy ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkLockedQuotePolicy));
		orNavigationPanel.lnkLockedQuotePolicy.click ();
	}

	// Event moratoriums
	public void clickEventMoratoriums ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkEventMoratoriums));
		orNavigationPanel.lnkEventMoratoriums.click ();
	}

	/** Billing Span / panel **/
	public void expandBillingSpan ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlBilling));
		orNavigationPanel.pnlBilling.click ();
	}

	// Direct billing
	public void clickDirectBilling ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkDirectBilling));
		orNavigationPanel.lnkDirectBilling.click ();
	}

	// Agency billing
	public void clickAgencyBilling ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkAgencyBilling));
		orNavigationPanel.lnkAgencyBilling.click ();
	}

	// Accounts receivable
	public void clickAccountsReceivable ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkAccountsReceivable));
		orNavigationPanel.lnkAccountsReceivable.click ();
	}

	// Make a payment
	public void clickMakeAPayment ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkMakeAPayment));
		orNavigationPanel.lnkMakeAPayment.click ();
	}

	// Multiple cheque list
	public void clickMultipleChequeList ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkMultipleChequeList));
		orNavigationPanel.lnkMultipleChequeList.click ();
	}

	// Receipt list
	public void clickReceiptList ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkReceiptList));
		orNavigationPanel.lnkReceiptList.click ();
	}

	// EFT list
	public void clickEFTList ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkEFTList));
		orNavigationPanel.lnkEFTList.click ();
	}

	// Daily payment summary
	public void clickDailyPaymentSummary ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkDailyPaymentSummary));
		orNavigationPanel.lnkDailyPaymentSummary.click ();
	}

	// Processor detail
	public void clickProcessorDetail ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkProcessorDetail));
		orNavigationPanel.lnkProcessorDetail.click ();
	}

	// Post dated due
	public void clickPostDatedDue ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkPostDatedDue));
		orNavigationPanel.lnkPostDatedDue.click ();
	}

	// Bank deposit
	public void clickBankDeposit ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkBankDeposit));
		orNavigationPanel.lnkBankDeposit.click ();
	}

	// Accounts payable
	public void clickAccountsPayable ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkAccountsPayable));
		orNavigationPanel.lnkAccountsPayable.click ();
	}

	// Create requisition
	public void clickCreateRequisition ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkCreateRequisition));
		orNavigationPanel.lnkCreateRequisition.click ();
	}

	// Requisition list
	public void clickRequisitionList ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkRequisitionList));
		orNavigationPanel.lnkRequisitionList.click ();
	}

	// Check run list
	public void clickCheckRunList ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkCheckRunList));
		orNavigationPanel.lnkCheckRunList.click ();
	}

	// Check list
	public void clickCheckList ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkCheckList));
		orNavigationPanel.lnkCheckList.click ();
	}

	// Extract checks
	public void clickExtractCheques ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkExtractCheques));
		orNavigationPanel.lnkExtractCheques.click ();
	}

	public void clickExtractChecks ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkExtractChecks));
		orNavigationPanel.lnkExtractChecks.click ();
	}

	// Process Commission
	public void clickProcessCommission ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkProcessCommission));
		orNavigationPanel.lnkProcessCommission.click ();
	}

	// Next activities
	public void clickNextActivities ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkNextActivities));
		orNavigationPanel.lnkNextActivities.click ();
	}

	// Unlock
	public void clickUnlock ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkUnlock));
		orNavigationPanel.lnkUnlock.click ();
	}

	/** Supplier management / panel **/
	public void expandSupplierManagementSpan ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlSupplierManagement));
		orNavigationPanel.pnlSupplierManagement.click ();
	}

	// Supplier search
	public void clickSupplierSearch ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkSupplierSearch));
		orNavigationPanel.lnkSupplierSearch.click ();
	}

	// Master fee management
	public void clickMasterFeeManagement ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkMasterFeeManagement));
		orNavigationPanel.lnkMasterFeeManagement.click ();
	}

	// Master salvage management
	public void clickMasterSalvageManagement ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkMasterSalvageManagement));
		orNavigationPanel.lnkMasterSalvageManagement.click ();
	}

	/** Agent management span / panel **/
	public void expandAgentManagementSpan ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlAgentManagement));
		orNavigationPanel.pnlAgentManagement.click ();
	}

	// Search
	public void clickSearch ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkSearch));
		orNavigationPanel.lnkSearch.click ();
	}

	// View agent
	public void clickViewAgent ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkViewAgent));
		orNavigationPanel.lnkViewAgent.click ();
	}

	// Company management
	public void clickCompanyManagement ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkCompanyManagement));
		orNavigationPanel.lnkCompanyManagement.click ();
	}

	// Profile management
	public void clickProfileManagement ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkProfileManagement));
		orNavigationPanel.lnkProfileManagement.click ();
	}

	// Licence management
	public void clickLicenceManagement (String strRegion)
	{

		if (strRegion.equals ("UK"))
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkLicenceManagement));
			orNavigationPanel.lnkLicenceManagement.click ();
		}
		else if (strRegion.equals ("USA"))
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkLicenseManagement));
			orNavigationPanel.lnkLicenseManagement.click ();
		}
	}

	// Portfolio management
	public void clickPortfolioManagement ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkPortfolioManagement));
		orNavigationPanel.lnkPortfolioManagement.click ();
	}

	/** Financials span / panel **/
	public void expandFinancialsSpan ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlFinancials));
		orNavigationPanel.pnlFinancials.click ();
	}

	// Financial audit trail
	public void clickFinancialAuditTrail ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkFinancialAuditTrail));
		orNavigationPanel.lnkFinancialAuditTrail.click ();
	}

	// Financial reports
	public void clickFinancialReports ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkFinancialReports));
		orNavigationPanel.lnkFinancialReports.click ();
	}

	// View reports
	public void clickViewReports ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkViewReports));
		orNavigationPanel.lnkViewReports.click ();
	}

	// Unreconciled items
	public void clickUnreconciledItems ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkUnreconciledItems));
		orNavigationPanel.lnkUnreconciledItems.click ();
	}

	// End of year rollover
	public void clickEndOfYearRollover ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkEndOfYearRollover));
		orNavigationPanel.lnkEndOfYearRollover.click ();
	}

	// Batch Administration
	public void clickBatchAdministration ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkBatchAdministration));
		orNavigationPanel.lnkBatchAdministration.click ();
	}

	// Expands Functions menu in Navigation panel under left accordion menu in
	// Claims BO
	public void expandBOFunctionsSpan ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlBOFunctions));
		orNavigationPanel.pnlBOFunctions.click ();
	}

	// Clicks on Validation link under Functions menu in Navigation panel in Claims
	// BO
	public void clickValidation ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkValidation));
		orNavigationPanel.lnkValidation.click ();
	}

	// Expands Litigation option for Property claim under left accordion menu in
	// Claims BO
	public void expandBOLitigationSpan ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlBOLitigation));
		orNavigationPanel.pnlBOLitigation.click ();
	}

	// Clicks on Details option under Litigation menu for Property claim under Left
	// accordion menu
	public void clickDetailsLitigation ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkDetailsLitigation));
		orNavigationPanel.lnkDetailsLitigation.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void clickBOFinancialsSpan ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlBOFinancials));
		orNavigationPanel.pnlBOFinancials.click ();
	}

	public void clickLogPayment ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkLogPayment));
		orNavigationPanel.lnkLogPayment.click ();
	}

	public void clickManageReserve ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkManageReserve));
		orNavigationPanel.lnkManageReserve.click ();
	}

	public void clickBodilyInjurySpan ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlBOBodilyInjury));
		orNavigationPanel.pnlBOBodilyInjury.click ();
	}

	public void clickMOJActions ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		// It happens at times that Bodily injury span is not expanded when Bodily injury feature is opened. This try-catch is used
		// to handle it. It checks if (span is expanded and) MOJ actions link is displayed it clicks it otherwise it first opens
		// Bodily injury span and then clicks on MOJ actions link
		try
		{
			if (orNavigationPanel.lnkMOJActions.isDisplayed ())
			{
				wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkMOJActions));
				orNavigationPanel.lnkMOJActions.click ();
			}
		}
		catch (Exception e)
		{
			wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlBOBodilyInjury));
			orNavigationPanel.pnlBOBodilyInjury.click ();
			wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkMOJActions));
			orNavigationPanel.lnkMOJActions.click ();
		}

	}

	public void clickMOJCommunications ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkMOJCommunications));
		orNavigationPanel.lnkMOJCommunications.click ();
	}

	public void expandBOSIUSpan ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlBOSIU));
		orNavigationPanel.pnlBOSIU.click ();
	}

	public void clickSIUSpotlight ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkSIUSpotlight));
		orNavigationPanel.lnkSIUSpotlight.click ();
	}

	public void clickManageSIUReferral ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkManageSIUReferral));
		orNavigationPanel.lnkManageSIUReferral.click ();
	}

	public void clickVehicleActionsUpdate ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlVehicleActions));

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

		orNavigationPanel.pnlVehicleActions.click ();
		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		load.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkVehicleUpdate));

		orNavigationPanel.lnkVehicleUpdate.click ();
	}

	// Clicks on Policy link under Functions menu in Navigation panel in Claims
	// BO
	public void clickBOPolicy ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkBOPolicy));
		orNavigationPanel.lnkBOPolicy.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void expandBOPropertyDamageSpan ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlPropertyDamageActions));
		orNavigationPanel.pnlPropertyDamageActions.click ();
	}

	public void clickAddNewItem ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkAddNewItem));
		orNavigationPanel.lnkAddNewItem.click ();
	}

	public void clickMaintainCoverages ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlVehicleActions));

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

		// We have to validate the data completeness before clicking on Maintain
		// Coverages

		TableHandler orrisklisttable = new TableHandler (driver);
		boolean boolRiskListCheck = orrisklisttable.verifyTableHasData ("MultiLine_RiskList");

		if (boolRiskListCheck == true)
		{
			boolean strRiskStatus = orrisklisttable.checkTableHasRecords ("MultiLine_RiskList", "Active", "All");

			if (strRiskStatus == true)
			{

				WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
				load.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlVehicleActions));
				orNavigationPanel.pnlVehicleActions.click ();
				WebDriverWait loadagain = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
				loadagain.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkMaintainCovers));
				orNavigationPanel.lnkMaintainCovers.click ();

			}
			else
				System.out.println ("Risk is not active");
		}

	}

	public void clickSupplier ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkSupplier));
		orNavigationPanel.lnkSupplier.click ();
	}

	public void clickEstimate ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkEstimate));
		orNavigationPanel.lnkEstimate.click ();
		try
		{
			WebDriverWait waitAlert = new WebDriverWait (driver, GlobalWaitTime.getShortWaitTime ());
			if (waitAlert.until (ExpectedConditions.alertIsPresent ()) != null)
			{

				Alert alert = driver.switchTo ().alert ();
				alert.accept ();
			}
		}
		catch (Exception e)
		{
			// exception handling
		}
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void expandBOCorrespondenceSpan ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlCorrespondence));
		orNavigationPanel.pnlCorrespondence.click ();
	}

	public void clickCorrespondenceSummary ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkCorrespondenceSummary));
		orNavigationPanel.lnkCorrespondenceSummary.click ();
	}

	public void expandBOCommunicationSpan ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlCommunication));
		orNavigationPanel.pnlCommunication.click ();
	}

	public void clickManageCorrespondence ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkManageCorrespondence));
		orNavigationPanel.lnkManageCorrespondence.click ();
	}

	public void expandViewPolicy (String strRegionValue)
	{
		if (strRegionValue.contains ("USA"))
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlViewPolicy));
			orNavigationPanel.pnlViewPolicy.click ();
		}
		else if (strRegionValue.contains ("UK"))
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlViewPolicy_UK));
			orNavigationPanel.pnlViewPolicy_UK.click ();

		}
	}

	public void clickDirectBillingForPolicy ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkDirectBillingForPolicy));
		orNavigationPanel.lnkDirectBillingForPolicy.click ();
	}

	public void expandDirectBillingActions ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.pnlDirectBillingActions));
		orNavigationPanel.pnlDirectBillingActions.click ();
	}

	public void clickMaintainNextActivity ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orNavigationPanel.lnkMaintainNextActivity));
		orNavigationPanel.lnkMaintainNextActivity.click ();
	}

}
