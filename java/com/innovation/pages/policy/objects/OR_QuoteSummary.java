package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Tahir - This captures the page elements for the Policy summary
 *         screen.
 * 
 */
public class OR_QuoteSummary {

	// Quote Number
	@CacheLookup
	@FindBy(how = How.ID, using = "ValidationIssueList")
	public WebElement tblValidationIssues;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement prgProgress;

}
