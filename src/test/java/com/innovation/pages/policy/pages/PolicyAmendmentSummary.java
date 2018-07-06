/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;

import com.innovation.pages.policy.objects.OR_PolicyAmendmentSummary;

/**
 * @author Tahir - This class stores all the locators and methods of the Policy
 *         summary screen
 */

public class PolicyAmendmentSummary {

	WebDriver driver;
	OR_PolicyAmendmentSummary orPolicyAmendmentSummary = null;

	public PolicyAmendmentSummary(WebDriver driver) {
		this.driver = driver;
		orPolicyAmendmentSummary = PageFactory.initElements(driver, OR_PolicyAmendmentSummary.class);
	}

	public void validateAmendmentSummary() {

		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.invisibilityOf(orPolicyAmendmentSummary.Progressbar));

		wait.until(ExpectedConditions.visibilityOf(orPolicyAmendmentSummary.pnlPolicySummaryDetails));
		wait.until(ExpectedConditions.visibilityOf(orPolicyAmendmentSummary.pnlPremiumSummaryDetails));
		wait.until(ExpectedConditions.visibilityOf(orPolicyAmendmentSummary.pnlBillingSummary));

		String strPolicySummaryDetails = orPolicyAmendmentSummary.pnlPolicySummaryDetails.getText();
		String strPremiumSummaryDetails = orPolicyAmendmentSummary.pnlPremiumSummaryDetails.getText();
		String strBillingSummaryDetails = orPolicyAmendmentSummary.pnlBillingSummary.getText();

		if (strPolicySummaryDetails.contains("Policy summary details")
				&& strPremiumSummaryDetails.contains("Premium summary")
				&& strBillingSummaryDetails.contains("Billing summary")) {

			System.out.println("You are on Amendment Summary Please Proceed Next");

		}
	}
}
