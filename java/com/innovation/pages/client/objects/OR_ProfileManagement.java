package com.innovation.pages.client.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author haiderm - This captures the page elements for the Agent Profile Management screen.
 *
 */

public class OR_ProfileManagement
{

	// Agent Number
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Agent")
	public WebElement	txtAgent;

	// Agent Suffix
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AgentSuffix")
	public WebElement	ddlSuffix;

	// Agent Search Icon
	@CacheLookup
	@FindBy(how = How.ID, using = "AgentSearchIcon")
	public WebElement	imgSuffixSearch;

	// Agent Name
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AgentName")
	public WebElement	lblAgentName;

	// Add Agent Profile
	@CacheLookup
	@FindBy(how = How.ID, using = "btnLOBAdd")
	public WebElement	btnProfileAdd;

	// Company
	// @CacheLookup
	@FindBy(how = How.ID, using = "SC_Company")
	public WebElement	ddlCompany;

	// Company Select Image
	// @CacheLookup
	@FindBy(how = How.ID, using = "dhx_img_SC_Company")
	public WebElement	imgCompany;

	// Region
	// @CacheLookup
	@FindBy(how = How.ID, using = "SC_State")
	public WebElement	ddlRegion;

	// Region Select Image
	// @CacheLookup
	@FindBy(how = How.ID, using = "dhx_img_SC_State")
	public WebElement	imgRegion;

	// Profile
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ProfileList")
	public WebElement	ddlProfile;

	// Active to
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ProfileActiveTo")
	public WebElement	dtpProfileActiveTo;

	// Active from
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ProfileActiveFrom")
	public WebElement	dtpProfileActiveFrom;

	// Assign
	@CacheLookup
	@FindBy(how = How.ID, using = "btnLOBDetailAdd")
	public WebElement	btnProfileDetailAssign;

	// Progress bar
	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgressBar;

}
