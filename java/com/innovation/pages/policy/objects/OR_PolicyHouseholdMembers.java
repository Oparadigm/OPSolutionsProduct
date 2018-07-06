package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Tahir This captures the page elements for the Policy Start Details
 *         screen.
 *
 */
public class OR_PolicyHouseholdMembers {
	/**
	 * @param args
	 */

	// Page Title
	@CacheLookup
	@FindBy(how = How.ID, using = "policyTitle")
	public WebElement tlepage;

	// Household List
	@CacheLookup
	@FindBy(how = How.ID, using = "tblHouseholdList")
	public WebElement tblHouseholdList;

	// Progress Bar
	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement prgProgress;
}
