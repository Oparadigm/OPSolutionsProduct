package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Rizwan. This captures the page elements for the Claimant Details screen in Home LOBs.
 * 
 */
public class OR_ClaimClaimantDetails
{

	// This element is used to click on Title drop down
	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_019_Title_10a")
	public WebElement		ddlTitle;

	// This element is used to select a value from Title drop down
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_Title_10a")
	public WebElement		ddlTitleValues;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_FirstName_10a")
	public WebElement		txtFirstName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_LastName_10a")
	public WebElement		txtLastName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_NIN")
	public WebElement		txtNationalInsuranceNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_Gender_10a")
	public WebElement		ddlGender;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_DateofBirth_10a")
	public WebElement		txtDateOfBirth;

	// This element is used to identify Deceased radio group
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_019_PartyStatus_10a")
	public List<WebElement>	rdoDeceased;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_043_DateofDeath_10a")
	public WebElement		txtDateOfDeath;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_SubTypeAvailable_10a")
	public WebElement		ddlAvailableSubRoles;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_AddSubType")
	public WebElement		btnAddSubRole;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_SubTypeSelected_10a")
	public WebElement		lstSelectedSubRoles;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_RemoveSubType")
	public WebElement		btnRemoveSubRole;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_019_PersonOfInterestIndicator_10a")
	public List<WebElement>	rdoPersonOfInterest;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_019_VulnerablePersonIndicator_10a")
	public List<WebElement>	rdoVulnerablePerson;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_019_StaffMemberIndicator_10a")
	public List<WebElement>	rdoStaffMember;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_019_SecurityLevelIndicator_10a")
	public List<WebElement>	rdoVIP;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_019_MinorIndicator_10a")
	public List<WebElement>	rdoMinor;

	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_019_SelectOccupation_10a")
	public WebElement		ddlOccupation;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_SelectOccupation_10a")
	public WebElement		ddlOccupationValues;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_PreferredLanguage_10a")
	public WebElement		ddlPreferredLanguage;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_BestContactMethod_10a")
	public WebElement		ddlBestContactMethod;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_BestContactTime_10a")
	public WebElement		ddlBestContactTime;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_019_Comments_10a")
	public WebElement		txaComments;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_019_VatRegistered_10a")
	public List<WebElement>	rdoVATRegistered;

	@CacheLookup
	@FindBy(how = How.ID, using = "igAddressMAAddNew_10a")
	public WebElement		btnAddContact;

	@CacheLookup
	@FindBy(how = How.ID, using = "igAddressType_10a")
	public WebElement		ddlContactType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_010_AddressSearchCriteria_10a")
	public WebElement		txtZipCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_010_AddressSearchImg_10a")
	public WebElement		imgZipSearch;

	// This element is used to click on Results drop down
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_010_AddressSearchResults_10a")
	public WebElement		ddlAddressSearchResults;

	// This element is used to select first value from Results drop down
	@FindBy(how = How.XPATH, using = "//*[@class='igMainBody']/div[1]/div[2]")
	public WebElement		ddlAddressSearchResultsValues;

	// This element identifies the selected address
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_010_AddressSelected_10a")
	public WebElement		lblAddressSelected;

	// This element identifies the error message when ZIP code search returns no
	// addresses
	@CacheLookup
	@FindBy(how = How.ID, using = "lblAddressErrorMsg_10a")
	public WebElement		lblAddressSearchError;

	@FindBy(how = How.ID, using = "CLM_SC_010_AddressManual_10a")
	public WebElement		chkManualAddress;

	@FindBy(how = How.ID, using = "cGB_E_igAddrLine1_10a")
	public WebElement		txtAddressLine1;

	@FindBy(how = How.ID, using = "cGB_E_igAddrCity_10a")
	public WebElement		txtTown;

	@FindBy(how = How.ID, using = "cGB_E_igAddrCounty_10a")
	public WebElement		ddlCounty;

	@FindBy(how = How.ID, using = "cGB_E_igAddrPostcode_10a")
	public WebElement		txtPostCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "igAddrType_10a")
	public WebElement		ddlAddressType;

	@CacheLookup
	@FindBy(how = How.ID, using = "igAddrFrom_10a")
	public WebElement		txtAddressFromDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "igEmailType_10a")
	public WebElement		ddlEmailType;

	@CacheLookup
	@FindBy(how = How.ID, using = "igEmailFrom_10a")
	public WebElement		txtEmailFromDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "cIG_E_igEmailAddr_10a")
	public WebElement		txtEmailAddress;

	@CacheLookup
	@FindBy(how = How.ID, using = "igPhoneType_10a")
	public WebElement		ddlPhoneType;

	@CacheLookup
	@FindBy(how = How.ID, using = "igPhoneFrom_10a")
	public WebElement		txtPhoneFromDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "cGENERIC_E_igPhoneAreaCode_10a")
	public WebElement		txtPhoneCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "cGENERIC_E_igPhoneNo_10a")
	public WebElement		txtPhoneNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "cGENERIC_E_igPhoneExt_10a")
	public WebElement		txtPhoneExt;

	@CacheLookup
	@FindBy(how = How.ID, using = "igAddressMASave_10a")
	public WebElement		btnSaveContact;

	@CacheLookup
	@FindBy(how = How.ID, using = "igAddressMACancel_10a")
	public WebElement		btnCancelContact;

	@CacheLookup
	@FindBy(how = How.ID, using = "AccountAddNew")
	public WebElement		btnAddAccount;

	@CacheLookup
	@FindBy(how = How.ID, using = "AccountType")
	public WebElement		ddlAccountType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_013_DefaultAccount_10a")
	public WebElement		chkDefaultAccount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_013_BankAccNo_10a")
	public WebElement		txtAccountNo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_013_SortCode_10a")
	public WebElement		txtSortCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "imgVerified")
	public WebElement		imgVerified;

	@CacheLookup
	@FindBy(how = How.ID, using = "chkOverride")
	public WebElement		chkOverride;

	@CacheLookup
	@FindBy(how = How.ID, using = "accountSave_10a")
	public WebElement		btnSaveAccount;

	@CacheLookup
	@FindBy(how = How.ID, using = "accountCancel_10a")
	public WebElement		btnCancelAccount;

	@CacheLookup
	@FindBy(how = How.ID, using = "igLightbox")
	public WebElement		dlgAccountValidation;

	@FindBy(how = How.ID, using = "btnBankValidationClose")
	public WebElement		btnAccountValidationClose;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_013_AccountDetails")
	public WebElement		tblAccountDetails;

	@CacheLookup
	@FindBy(how = How.CSS,
			using = "html body.igMainBody form.igForm div#contentColumn span#sectionSpan_xmlAssembled10 div#contentColumn_xmlAssembledExpDiv10.icongroup1 table tbody tr td div#tabs table.igST_tabTable tbody tr td.igST_tabArea div#igClaimantTabs_tabContent_1.igST_tabContentShowing div#tabContentDiv1 table tbody tr td table tbody tr td div#div_ActionButton_Adds_CreditCard input#accountSave_10a.iginputbuttonSecondary")
	public WebElement		btnAccountAdd;

	@CacheLookup
	@FindBy(how = How.NAME, using = "card_type")
	public List<WebElement>	rdoCardType;

	@CacheLookup
	@FindBy(how = How.ID, using = "card_number")
	public WebElement		txtCardNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "card_expiry_month")
	public WebElement		ddlExpiryMonth;

	@CacheLookup
	@FindBy(how = How.ID, using = "card_expiry_year")
	public WebElement		ddlExpiryYear;

	@CacheLookup
	@FindBy(how = How.NAME, using = "commit")
	public WebElement		btnNext;

	@CacheLookup
	@FindBy(how = How.CSS, using = "html body#review-oc div#wrap div#main div.container.group div.review_container.group div.row form input.right.complete")
	public WebElement		btnFinish;

	@CacheLookup
	@FindBy(how = How.ID, using = "igClaimantTabs_tabSelector_2")
	public WebElement		tabClaim;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_043_RealProperty_10a")
	public List<WebElement>	rdoPropertyDamage;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_355b_SubrogationIndicator_10a")
	public List<WebElement>	rdoSubrogationOpportunity;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_355b_SubrogationReason_10a")
	public WebElement		txaSubrogationReason;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_043_ProactiveHandling_10a")
	public List<WebElement>	rdoProactiveHandling;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_043_AnimalInjuryofDeath_10a")
	public List<WebElement>	rdoAnimalInjury;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_043_InjuryClaim_10a")
	public List<WebElement>	rdoPersonalInjury;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_043_MedicalAttention_10a")
	public List<WebElement>	rdoMedicalAttention;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_043_Fatal_10a")
	public List<WebElement>	rdoFatal;

	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseOK")
	public WebElement		btnConfirmOK;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_020_PartyRejectingService_10a")
	public List<WebElement>	rdoServicesRejected;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_020_AdditionalInjuryRealPropertyInformation_10a")
	public WebElement		txaAdditionalInfo;

	@CacheLookup
	@FindBy(how = How.ID, using = "igClaimantTabs_tabSelector_4")
	public WebElement		tabInjuryQuestionnaire;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_InjuryClmntQues_ExtentOfInjury_10a")
	public WebElement		ddlExtentofInjry;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_InjuryClmntQues_TimeOffFromWork_10a")
	public WebElement		ddlTimeOffWork;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_InjuryClmntQues_TimeOffFromWorkDetails_10a")
	public WebElement		txaTimeOffWorkDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_InjuryClmntQues_InjuryImpactOnSocialLife_10a")
	public WebElement		ddlImpactOnSocialLife;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_InjuryClmntQues_InjuryImpactOnSocialLifeDetails_10a")
	public WebElement		txaImpactOnSocialLifeDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_ClmntInjuryQuestnSave_10a")
	public WebElement		btnSaveInjuryQuestion;

	@CacheLookup
	@FindBy(how = How.ID, using = "igClaimantTabs_tabSelector_3")
	public WebElement		tabAssocaitedParties;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='tabContentDiv3']/table/tbody/tr/td/div[1]/div/button")
	public WebElement		btnSearchAssociatedParty;

	@CacheLookup
	@FindBy(how = How.CSS,
			using = "html body.igMainBody form.igForm div#headerColumn div#controlpanel table.tableControlPanel tbody tr td div.igButtonDiv button.igFlowApply")
	public WebElement		btnSaveAndProceed;

	// Below fields will be used for Claimant details screen for motor LOB

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_020_DrivingforEmployer_10a")
	public List<WebElement>	rdoDrivingForEmployee;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_020_PermissionSought_10a")
	public List<WebElement>	rdoPermissionGiven;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_020_SeatbeltWorn_10a")
	public List<WebElement>	rdoSeatBeltWorn;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_020_DrivingViolations_10a")
	public List<WebElement>	rdoConvictions;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_020_MedicalConditions_10a")
	public List<WebElement>	rdoMedicalConditions;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_043_Vehicle_10a")
	public List<WebElement>	rdoVehicleDamage;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_043_Cycle_10a")
	public List<WebElement>	rdoCycle;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_043_Motorcycle_10a")
	public List<WebElement>	rdoMotorcycle;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_020_Alcohol_Drugs_10a")
	public List<WebElement>	rdoAlcoholDrugInvovled;

}
