package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs This captures the page elements for the Policy Client Search screen.
 *
 */
public class OR_PolicyClientSearch
{

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_LastName")
	public WebElement	txtLastNameField;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_FirstName")
	public WebElement	txtFirstNameField;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_CompanyName")
	public WebElement	txtCompanyField;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_City")
	public WebElement	txtCityField;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_PostCode")
	public WebElement	txtZipCodeField;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientSearch_PhoneNum")
	public WebElement	txtPhoneNumField;

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "iginputbutton")
	public WebElement	btnSearch;

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "iginputbuttonSecondary")
	public WebElement	btnClear;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnViewClient")
	public WebElement	btnViewClient;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnShowPolicies")
	public WebElement	btnViewPolicies;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnAddCompanyClient")
	public WebElement	btnNewCompany;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnAddIndividualClient")
	public WebElement	btnNewIndividual;

	@CacheLookup
	@FindBy(how = How.ID, using = "igsortedtable")
	public WebElement	tblClientSearch;

	@CacheLookup
	@FindBy(how = How.ID, using = "tblClientSearch")
	public WebElement	btnClientView;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgressBar;

}
