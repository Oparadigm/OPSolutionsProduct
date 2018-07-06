package com.innovation.pages.client.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author haiderm - This captures the page elements for the Agent License Management screen.
 *
 */

public class OR_LicenceManagement
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

	// Add Agent Licence
	@CacheLookup
	@FindBy(how = How.ID, using = "btnLicenseAdd")
	public WebElement	btnLicenceAdd;

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

	// Add Licence Number
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_LicenseNo")
	public WebElement	txtLicenceNo;

	// Active from
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_LicenseActiveFrom")
	public WebElement	dtpLicenceActiveFrom;

	// Active to
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_LicenseActiveTo")
	public WebElement	dtpLicenceActiveTo;

	// Due date
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_LicenseDueDate")
	public WebElement	dtpLicenceDueDate;

	// Paid
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Paid")
	public WebElement	ddlLicencePaid;

	// Free
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Fee")
	public WebElement	txtlicenceFee;

	// CEU attained
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CEU")
	public WebElement	txtCEUattained;

	// CEU required
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CEUReq")
	public WebElement	txtCEUrequired;

	// Cancellation date
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Cancellation")
	public WebElement	dtpCancellationDate;

	// Add licence details
	@CacheLookup
	@FindBy(how = How.ID, using = "btnLicenseDetailAdd")
	public WebElement	btnLicenseDetailsAdd;

}
