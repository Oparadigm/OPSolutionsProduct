package com.innovation.pages.client.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author haiderm - This captures the page elements for the Agent Company Management screen.
 *
 */

public class OR_CompanyManagement
{

	// Agent Number
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Agent")
	public WebElement	txtAgent;

	// Agent Suffix
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AgentSuffix")
	public WebElement	ddlSuffix;

	// Suffix Search Icon
	@CacheLookup
	@FindBy(how = How.ID, using = "AgentSearchIcon")
	public WebElement	imgSuffixSearch;

	// Agent Name
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AgentName")
	public WebElement	lblAgentName;

	// Add Agent Company
	@CacheLookup
	@FindBy(how = How.ID, using = "btnCompAdd")
	public WebElement	btnCompanyAdd;

	// Company
	// @CacheLookup
	@FindBy(how = How.ID, using = "SC_Company")
	public WebElement	ddlCompany;

	// Company Select Image
	// @CacheLookup
	@FindBy(how = How.ID, using = "dhx_img_SC_Company")
	public WebElement	imgCompany;

	// State
	// @CacheLookup
	@FindBy(how = How.ID, using = "SC_State")
	public WebElement	ddlState;

	// State Select Image
	// @CacheLookup
	@FindBy(how = How.ID, using = "dhx_img_SC_State")
	public WebElement	imgState;

	// Branch
	// @CacheLookup
	@FindBy(how = How.ID, using = "SC_Branch")
	public WebElement	ddlBranch;

	// Branch Select Image
	// @CacheLookup
	@FindBy(how = How.ID, using = "dhx_img_SC_Branch")
	public WebElement	imgBranch;

	// Comscale
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Comscale")
	public WebElement	ddlComscale;

	// Policy process
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PolicyProcess")
	public WebElement	ddlPolicyProcess;

	// Active from
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CompanyActiveFrom")
	public WebElement	dtpCompanyActiveFrom;

	// Active to
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CompanyActiveTo")
	public WebElement	dtpCompanyActiveTo;

	// Overriding agent
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_OverAgent")
	public WebElement	txtOrverridingAgent;

	// Run off indicator
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ROI")
	public WebElement	ddlRunOffIndicator;

	// Overriding agent suffix
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_OverAgentSuf")
	public WebElement	ddlOverridingAgentSuffix;

	// Add company details
	@CacheLookup
	@FindBy(how = How.ID, using = "btnCompanyDetailAdd")
	public WebElement	btnCompanyDetailAdd;

}
