package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs This captures the page elements for the Policy Start Details screen.
 *
 */
public class OR_PolicyStartDetails
{
	/**
	 * @param args
	 */

	// Effective Date
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_QuoteStartDetails_PolicyStartsWhen")
	public WebElement	dtpEffectiveDate;

	// Company
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_QuoteStartDetails_Company")
	public WebElement	ddlCompany;

	// Region
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_QuoteStartDetails_Province")
	public WebElement	ddlRegion;

	// Line of Business
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_QuoteStartDetails_LOB")
	public WebElement	ddlLOB;

	// Term
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_QuoteStartDetails_Term")
	public WebElement	ddlTerm;

	// Agent
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_QuoteStartDetails_Agent")
	public WebElement	txtAgent;

	// Producing Agent
	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GettingStarted_Agentlookup")
	public WebElement	btnLookUp;

	// Producing Agent
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_QuoteStartDetails_Producer")
	public WebElement	ddlProducingAgent;

	// Renewal Date
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_QuoteStartDetails_RenewalDate")
	public WebElement	dtpRenewalDate;

	// First Insured Date
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_QuoteStartDetails_FirstUsedDate")
	public WebElement	dtpFirstInsuredDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgressBar;

	// First Insured Date
	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igFlowNext")
	public WebElement	btnProceed;
}
