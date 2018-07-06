package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OR_ClaimLitigation
{

	// Management tab on Litigation frame
	@CacheLookup
	@FindBy(how = How.ID, using = "igLitigationTabs_tabSelector_3")
	public WebElement		tabManagement;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_AddLitigation_30a")
	public WebElement		btnAddLitigation;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0434_Title_30a")
	public WebElement		txtTitleOfAction;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_LitigationCategory_30a")
	public WebElement		ddlLitigationCategory;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_CourtClaimNumber_30a")
	public WebElement		txtCourtClaimNo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_DateIssued_30a")
	public WebElement		txtDateIssued;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_DateServed_30a")
	public WebElement		txtDateServed;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_Section152_30a")
	public List<WebElement>	rdoSection152;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_DefectiveService_30a")
	public List<WebElement>	rdoDefectiveService;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_CPRType_30a")
	public WebElement		ddlTypeCPR;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_CPRRequested_30a")
	public List<WebElement>	rdoRequested;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_CPRDateRequested_30a")
	public WebElement		txtDateRequested;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_CPRDateExpected_30a")
	public WebElement		txtDateExpected;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_CPRResponse_30a")
	public List<WebElement>	rdoResponse;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_LitigationReason_30a")
	public WebElement		ddlLitigationReason;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_DefenceRequired_30a")
	public List<WebElement>	rdoDefenceRequired;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_DefenceDue_30a")
	public WebElement		txtDefenceDueDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_Extended_30a")
	public List<WebElement>	rdoExtended;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_ExtendedReason_30a")
	public WebElement		txaExtendedReason;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_SaveLitigation_30a")
	public WebElement		btnSaveLitigation;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_CancelLitigation_30a")
	public WebElement		btnCancelLitigation;

	// WIP tab on Litigation frame
	@CacheLookup
	@FindBy(how = How.ID, using = "igLitigationTabs_tabSelector_4")
	public WebElement		tabWIP;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_LitigationListWIP")
	public WebElement		tblLitigationList;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_AddPartyDetails_30b")
	public WebElement		btnAddPartyDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0659_Name_30b")
	public WebElement		ddlNameParty;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0659_LitigantTypeCode_30b")
	public WebElement		ddlTypeParty;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0659_LitigationRepresentative_30b")
	public WebElement		ddlRepresentative;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_DateInstructed_30b")
	public WebElement		txtDateInstructed;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0659_ActionCode_30b")
	public WebElement		ddlAction;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0659_LitigantStatusCode_30b")
	public WebElement		ddlStatus;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0659_OutcomeCode_30b")
	public WebElement		ddlOutcome;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0659_OutcomeDate_30b")
	public WebElement		txtOutcomeDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0659_PartiesAdd_30b")
	public WebElement		btnSavePartyDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0659_PartiesCancel_30b")
	public WebElement		btnCancelPartyDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_0659_PartiesDetail")
	public WebElement		tblPartyDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_AddOfferDetails_30c")
	public WebElement		btnAddOfferDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_TypeCode_30c")
	public WebElement		ddlOfferType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_OfferTypeCode_30c")
	public WebElement		ddlOffer;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_OfferStatusCode_30c")
	public WebElement		ddlStatusOffer;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_OfferSplit_30c")
	public WebElement		txtSplitPercentage;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_OfferAmount_30c")
	public WebElement		txtOfferAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_OfferSave_30c")
	public WebElement		btnSaveOffer;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_OfferCancel_30c")
	public WebElement		btnCancelOffer;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_AddEvaluationDetails_30d")
	public WebElement		btnAddEvaluation;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0922_ClaimDate_30d")
	public WebElement		txtEvaluationDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0922_VDClaimedAmount_30d")
	public WebElement		txtVehicleAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0922_PDClaimedAmount_30d")
	public WebElement		txtPropertyAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0922_SpecialsAmount_30d")
	public WebElement		txtSpecialAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0922_GeneralAmount_30d")
	public WebElement		txtGeneralAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0922_Interest_30d")
	public WebElement		txtInterestAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0922_OwnCosts_30d")
	public WebElement		txtOwnCostsAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0922_ClaimantCosts_30d")
	public WebElement		txtClaimantCostsAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0922_LiabilityPercentRate_30d")
	public WebElement		txtLiabilityPercentage;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0659_EvaluationAdd_30d")
	public WebElement		btnSaveEvaluation;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0659_EvaluationCancel_30d")
	public WebElement		btnCancelEvaluation;

}
