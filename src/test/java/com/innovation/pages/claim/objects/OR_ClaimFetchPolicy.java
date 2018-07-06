package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Rizwan. This captures the page elements for Claim's Back Office Fetch Policy screen in Home LOBs.
 *   
 */
public class OR_ClaimFetchPolicy
{

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2707_FetchPolicyNum_90a")
	public WebElement	txtPolicyNo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2707_FetchPolicyButton_90a")
	public WebElement	btnFetchPolicy;

	// This element captures the progress bar that appears when Search button is clicked
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgressBar;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@type=\"checkbox\"]")
	public WebElement	chkClaimingFor;

}
