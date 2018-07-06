package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Tahir - This captures the page elements for the Policy Amendment
 *         summary screen.
 * 
 */
public class OR_PolicyAmendmentSummary {

	// Risk List and Amendment Information

	@CacheLookup
	@FindBy(how = How.ID, using = "expDivInnovation.Policy.Wrapup.PolicySummary")
	public WebElement pnlPolicySummaryDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "expDivPremiumSummary.Premium.Summary")
	public WebElement pnlPremiumSummaryDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "expDivBillingSummary.Billing.Summary")
	public WebElement pnlBillingSummary;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement Progressbar;

}
