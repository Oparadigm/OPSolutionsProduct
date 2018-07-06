/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.common.pages.ActionsPanel;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.pages.policy.objects.OR_QuoteSummary;

/**
 * @author Tahir - This class stores all the locators and methods of the Policy
 *         summary screen
 */

public class QuoteSummary {

	WebDriver driver;
	OR_QuoteSummary orQuoteSummary = null;

	public QuoteSummary(WebDriver driver) {
		this.driver = driver;
		orQuoteSummary = PageFactory.initElements(driver, OR_QuoteSummary.class);
	}

	public void checkQuoteValidationIssues() {

		NavigationPanel navigate = new NavigationPanel(driver);
		ActionsPanel panel = new ActionsPanel(driver);

		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.invisibilityOf(orQuoteSummary.prgProgress));

		wait.until(ExpectedConditions.elementToBeClickable(orQuoteSummary.tblValidationIssues));

		// ValidationIssueList is the ID of the Policy Validation Issues Table
		int tableRows = driver.findElements(By.xpath("//*[@id='" + "ValidationIssueList" + "']" + "/tbody/tr")).size();

		if (tableRows >= 1) {
			navigate.clickVehicleActionsUpdate();

		} else {

			panel.clickCompleteQuote();

		}

	}

}
