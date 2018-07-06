/**
 * 
 */
package com.innovation.pages.client.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs - This captures the page elements for the Add individual client screen.
 *
 */
public class OR_AddIndividualClient
{

	@CacheLookup
	@FindBy(how = How.ID, using = "ClientAdd_NameTitle_1a")
	public WebElement	ddlTitle;

	@CacheLookup
	@FindBy(how = How.ID, using = "ClientAdd_FirstNm_1a")
	public WebElement	txtFirstName;

	@CacheLookup
	@FindBy(how = How.ID, using = "ClientAdd_LastNm_1a")
	public WebElement	txtLastName;

	@CacheLookup
	@FindBy(how = How.ID, using = "ClientAdd_HomeEmail_1a")
	public WebElement	txtEmail;

	@CacheLookup
	@FindBy(how = How.ID, using = "ClientAdd_HPNumber_1a")
	public WebElement	txtHomePhone;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Search_Criteria")
	public WebElement	txtZipCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "searchLocationIcon")
	public WebElement	imgZipSearchIcon;

	// @CacheLookup
	@FindBy(how = How.ID, using = "SC_Search_Results")
	public WebElement	ddlSearchCriteria;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientDetailsMaintain_DOB")
	public WebElement	txtDOB;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientDetailsMaintain_Gender")
	public WebElement	ddlGender;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientDetailsMaintain_MaritalStatus")
	public WebElement	ddlMaritalStatus;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientDetailsMaintain_Language")
	public WebElement	ddlLanguage;

	// When a client is added with same address the "Add to household"
	// message box is displayed. This captures the Yes button element.
	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseYes")
	public WebElement	btnYes;

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igFlowNext")
	public WebElement	imgNavigationNext;

	// When a client is added with same address the "Add to household"
	// message box is displayed. This captures the Yes button element.
	@FindBy(how = How.ID, using = "igUserInteractResponseNo")
	public WebElement	btnNo;

	// Select Client Occupation

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='s2id_SC_ClientDetailsMaintain_Occupation']/a/span[2]")
	public WebElement	ddlClientOccupation;

	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_autogen2_search")
	public WebElement	clientOccupationSearch;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='select2-results-2']")
	public WebElement	ddlOccupationList;

	// General veil object that use to be displayed during a navigation between one
	// page to another
	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgress;

	// Following elements are related to the Privacy Agreement

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Privacy agreement - must read before proceeding")
	public WebElement	lnkPrivacyAgreement;

	@CacheLookup
	@FindBy(how = How.ID, using = "ModYes")
	public WebElement	rdoDataProtection;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientDetailsMaintain_MarketingCampaigns")
	public WebElement	chkMarketingCampaigns;

}
