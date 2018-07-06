package com.innovation.pages.client.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.TableHandler;
import com.innovation.pages.client.objects.OR_ClientSummary;

/**
 * @author Rizwan. This class stores all the locators and methods in Client
 *         Summary frame.
 *
 */
public class ClientSummary {
	WebDriver driver;
	OR_ClientSummary orClientSummary = null;

	public ClientSummary(WebDriver driver) {
		this.driver = driver;
		orClientSummary = PageFactory.initElements(driver, OR_ClientSummary.class);
	}

	// Methods for Billing summary tab on Client Summary frame

	// This selects Billing summary tab
	public void selectBillingSummaryTab() {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.tabBillingSummary));

		orClientSummary.tabBillingSummary.click();
	}

	// This selects a random record from Billing account details table
	public void selectRandomBillingRecord() {
		// Calling function from TableHandler misc class to click on a random
		// row in the table
		TableHandler tablehandler = new TableHandler(driver);
		tablehandler.clickRandomTableRow("tblBillAccount");
	}

	public void clickViewBillingDetails() {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.btnViewBillingDetails));

		orClientSummary.btnViewBillingDetails.click();
	}

	// Methods for Quotes / Policies tab on Client Summary frame

	public void selectQuotesPoliciesTab() {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.tabQuotesPolicies));

		orClientSummary.tabQuotesPolicies.click();
	}

	public void selectRandomPolicyRecord() {
		// Calling function from TableHandler misc class to click on a random
		// row in the table
		TableHandler tablehandler = new TableHandler(driver);
		tablehandler.clickRandomTableRow("tblPolicyRecords");
	}

	public void selectPolicyAction(String strPolicyAction) {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.ddlPolicyAction));

		orClientSummary.ddlPolicyAction.click();
		orClientSummary.ddlPolicyAction.sendKeys(strPolicyAction);
		orClientSummary.ddlPolicyAction.click();
	}

	public void clickGoPolicy() {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.btnPolicyGo));

		orClientSummary.btnPolicyGo.click();
	}

	public void selectRandomQuoteRecord() {
		// Calling function from TableHandler misc class to click on a random
		// row in the table
		TableHandler tablehandler = new TableHandler(driver);
		tablehandler.clickRandomTableRow("tblQuoteRecords");
	}

	public void selectQuoteAction(String strQuoteAction) {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.ddlQuoteAction));

		orClientSummary.ddlQuoteAction.click();
		orClientSummary.ddlQuoteAction.sendKeys(strQuoteAction);
		orClientSummary.ddlQuoteAction.click();
	}

	public void clickGoQuote() {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.btnQuoteGo));

		orClientSummary.btnQuoteGo.click();
	}

	// Methods for Claims tab on Client Summary frame

	public void selectClaimsTab() {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.tabClaims));

		orClientSummary.tabClaims.click();
	}

	public void selectRandomClaimRecord() {
		// Calling function from TableHandler misc class to click on a random
		// row in the table
		TableHandler tablehandler = new TableHandler(driver);
		tablehandler.clickRandomTableRow("tblClaimRecords");
	}

	public void clickViewClaim() {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.btnViewClaim));

		orClientSummary.btnViewClaim.click();
	}

	// Methods for Tasks tab on Client Summary frame

	public void selectTasksTab() {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.tabTasks));

		orClientSummary.tabTasks.click();
	}

	public void selectRandomTaskToDo() {
		// Calling function from TableHandler misc class to click on a random
		// row in the table
		TableHandler tablehandler = new TableHandler(driver);
		tablehandler.clickRandomTableRow("SC_TodoList");
	}

	// Methods for Communication tab on Client Summary frame

	public void selectCommunicationsTab() {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.tabCommunications));

		orClientSummary.tabCommunications.click();
	}

	public void selectRandomCommunicationRecord() {
		// Calling function from TableHandler misc class to click on a random
		// row in the table
		TableHandler tablehandler = new TableHandler(driver);
		tablehandler.clickRandomTableRow("ComunicationTable");
	}

	public void searchIncompleteTrancation(String strQuotePolicyNumber, String strEnvironmentName) {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.invisibilityOf(orClientSummary.prgProgress));
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.txtQuickSearch));
		wait.until(ExpectedConditions.elementToBeClickable(orClientSummary.imgQuickSearchIcon));

		orClientSummary.txtQuickSearch.sendKeys(strQuotePolicyNumber);

		orClientSummary.imgQuickSearchIcon.click();
		wait.until(ExpectedConditions.invisibilityOf(orClientSummary.prgProgress));
	}
}
