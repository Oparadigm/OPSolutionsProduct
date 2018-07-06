package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Tahir This captures the page elements for the Billing Maintain Next Activity screen.
 *
 */
public class OR_PolicyBillingMaintainNextActivity
{
	/**
	 * @param args
	 */

	@CacheLookup
	@FindBy(how = How.ID, using = "btnEditActivity")
	public WebElement	btnEditNextActivity;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnSkipActivity")
	public WebElement	btnSkipNextActivity;

	@FindBy(how = How.ID, using = "btnApplyActivity")
	public WebElement	btnSApplyNextActivity;

	@CacheLookup
	@FindBy(how = How.ID, using = "tblNextActivity")
	public WebElement	tblMaintainNextActivity;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[.='Submit']")
	public WebElement	btnSubmit;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgressBar;

	// First Insured Date
	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igFlowNext")
	public WebElement	btnProceed;
}
