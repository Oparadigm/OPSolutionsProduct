package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/* @Author Kamran Mahmood - This will capture page elements of Agent search page 
 * 
 */

public class OR_PolicyAgentSearch
{

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@value='nameContact']")
	public WebElement	rdnameContact;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@value='refNum']")
	public WebElement	rdreferencenumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AgentSearch_LastName")
	public WebElement	txtLastNameField;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AgentSearch_FirstName")
	public WebElement	txtFirstNameField;

	// @CacheLookup
	@FindBy(how = How.ID, using = "SC_AgentSearch_CompanyName")
	public WebElement	txtCompanyNameField;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AgentSearch_Town")
	public WebElement	txtTownField;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AgentSearch_ZipCode")
	public WebElement	txtZipCodeField;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AgentSearch_ContactNumber")
	public WebElement	txtContactNumberField;

	// @CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "iginputbutton")
	public WebElement	btnSearch;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Clear")
	public WebElement	btnClear;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='SC_AgentSearch_AgentNum']")
	public WebElement	txtAgnetNumberField;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='SC_AgentSearch_GroupCode']")
	public WebElement	txtGroupCodeField;

	@CacheLookup
	@FindBy(how = How.CSS, using = "#SC_AgentClientType")
	public WebElement	ddlAgentType;

	@CacheLookup
	@FindBy(how = How.CSS, using = "#SC_GroupCode")
	public WebElement	txtGroupCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "AssignButton")
	public WebElement	btnAssign;

	// @CacheLookup
	@FindBy(how = How.ID, using = "tblClientList")
	public WebElement	tbClientList;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnNewComp")
	public WebElement	btnNewCompany;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	barProgress;

}
