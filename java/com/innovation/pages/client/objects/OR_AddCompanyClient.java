package com.innovation.pages.client.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 * @Author Kamran Mahmood	This class will capture all the elements of Company Client screen
 */
public class OR_AddCompanyClient

{

	/***
	 * Contact Details Section
	 */
	@CacheLookup
	@FindBy(how = How.ID, using = ("ClientAdd_CompanyName_1a"))
	public WebElement	txtCompanyName;

	@CacheLookup
	@FindBy(how = How.ID, using = ("ClientAdd_HomeEmail_1a"))
	public WebElement	txtHomeEmail;

	@CacheLookup
	@FindBy(how = How.ID, using = ("ClientAdd_OfficeEmail_1a"))
	public WebElement	txtOfficeEmail;

	@CacheLookup
	@FindBy(how = How.ID, using = ("ClientAdd_HPAreaCode_1a"))
	public WebElement	ddHomePhone;

	@CacheLookup
	@FindBy(how = How.ID, using = ("ClientAdd_HPNumber_1a"))
	public WebElement	txtHomePhone;

	@CacheLookup
	@FindBy(how = How.ID, using = "ClientAdd_MPAreaCode_1a")
	public WebElement	ddMobilePhone;

	@CacheLookup
	@FindBy(how = How.ID, using = ("ClientAdd_MPNumber_1a"))
	public WebElement	txtMobilePhone;

	@CacheLookup
	@FindBy(how = How.ID, using = ("ClientAdd_OPAreaCode_1a"))
	public WebElement	ddOfficePhone;

	@CacheLookup
	@FindBy(how = How.ID, using = ("ClientAdd_OPNumber_1a"))
	public WebElement	txtOfficePhone;

	@CacheLookup
	@FindBy(how = How.ID, using = ("ClientAdd_OPExtension_1a"))
	public WebElement	txtOfficePhoneExtension;

	@CacheLookup
	@FindBy(how = How.ID, using = ("ClientAdd_FaxAreaCode_1a"))
	public WebElement	ddFaxNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = ("ClientAdd_FaxNumber_1a"))
	public WebElement	txtFaxNumber;

	/**
	 * Add Client Details Section
	 */

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_ClientDetailsMaintain_ContactPerson"))
	public WebElement	txtContactPerson;

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_ClientDetailsMaintain_TaxId"))
	public WebElement	txtTaxID;

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_ClientDetailsMaintain_1099"))
	public WebElement	chkVAT;

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_ClientDetailsMaintain_Withholding"))
	public WebElement	chkWithHolding;

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_ClientDetailsMaintain_ReferDecline"))
	public WebElement	ddReferDecline;

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_ClientDetailsMaintain_Fraud"))
	public WebElement	chkPersonOfInterest;

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_ClientDetailsMaintain_IntroType"))
	public WebElement	ddIntroductionType;

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_ClientDetailsMaintain_IntroCode"))
	public WebElement	ddIntroductionCode;

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_ClientDetailsMaintain_MarketingResearch"))
	public WebElement	chkMarketingResearch;

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_ClientDetailsMaintain_MarketingCampaigns"))
	public WebElement	chkProductService;

	/*
	 * Address Section
	 */

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_Country"))
	public WebElement	ddCountry;

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = ("igRadioText"))
	public WebElement	rdoAddressMap;

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_Search_Criteria"))
	public WebElement	txtSearchCriteria;

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_AddressSearch"))
	public WebElement	imgSearchAddress;

	// @CacheLookup
	@FindBy(how = How.ID, using = ("SC_Search_Results"))
	public WebElement	ddSearchResults;

	@CacheLookup
	@FindBy(how = How.ID, using = ("SC_Manual_Address"))
	public WebElement	chkManualAddress;

	// @CacheLookup
	@FindBy(how = How.ID, using = ("GEN_AddrLine1"))
	public WebElement	txtAddressLine1;

	// @CacheLookup
	@FindBy(how = How.ID, using = ("GEN_AddrLine2"))
	public WebElement	txtAddressLine2;

	// @CacheLookup
	@FindBy(how = How.ID, using = ("GEN_AddrLine3"))
	public WebElement	txtAddressLine3;

	// @CacheLookup
	@FindBy(how = How.ID, using = ("GEN_AddrCity"))
	public WebElement	txtCity;

	// @CacheLookup
	@FindBy(how = How.ID, using = ("GEN_AddrCounty"))
	public WebElement	txtStateProvinceCounty;

	// @CacheLookup
	@FindBy(how = How.ID, using = ("GEN_AddrPostcode"))
	public WebElement	txtZipPostCode;

	@FindBy(how = How.CLASS_NAME, using = ("igFlowNext"))
	public WebElement	btnFlowNext;

}
