package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Rizwan - defining the objects for 'MOJ Actions' frame accessible through BO Navigation panel > Bodily injury > MOJ actions 
 *  
 */

public class OR_ClaimMOJActions
{

	// Controls for Article 75 and Liability decision
	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_Article75indicator_20a")
	public WebElement		ddlArticle75Decision;

	@FindBy(how = How.ID, using = "CLM_SC_ProcessArticle75Decision_20a")
	public WebElement		btnArticle75Decision;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsCapacityInsurer")
	public WebElement		ddlInsurerCapacity;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsOtherDetail")
	public WebElement		txaOtherDetail;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsLiability")
	public WebElement		ddlLiability;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsLiabilityNotAdmittedReasons")
	public WebElement		txaLiabilityNotAdmittedReasons;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsContactName")
	public WebElement		txtContactName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsContactSurname")
	public WebElement		txtContactSurName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsTelephoneNumber")
	public WebElement		txtTelephoneNo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsEmailAddress")
	public WebElement		txtEmailAddress;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsPreparedToProvideRehabilitation")
	public WebElement		ddlInsurerPreparedToProvideRehab;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsInsurerProvidedRehabilitation")
	public WebElement		ddlInsurerProvidedRehab;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsFullDetails")
	public WebElement		txaRehabilitationDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsAlternativeVehicleSupply")
	public WebElement		ddlInsurerInstructedAlternativeVehicle;
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsFullDetailsOfVehicleSupply")
	public WebElement		txaAlternativeVehicleDetails;
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsInspection")
	public WebElement		ddlInsurerOrganisedRepairs;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsFullDetailsOfInspection")
	public WebElement		txaInspectionDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsHouseName")
	public WebElement		txtHouseName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsNumber")
	public WebElement		txtNumber;
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStreet1")
	public WebElement		txtStreet1;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStreet2")
	public WebElement		txtStreet2;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsDistrict")
	public WebElement		txtDistrict;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsTownCity")
	public WebElement		txtTown;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsCounty")
	public WebElement		txtCounty;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsCountry")
	public WebElement		txtCountry;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsPostcode")
	public WebElement		txtPostcode;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionSendLiabilityDecision_20a")
	public WebElement		btnLiabilityDecision;

	// Validation Labels
	@FindBy(how = How.ID, using = "CLM_SC_ClaimCurrentStatus_10a")
	public WebElement		lblCurrentStatus;

	@FindBy(how = How.ID, using = "CLM_SC_DaysRemainingInCurrentPhase_10a")
	public WebElement		lblDaysRemainingInCurrentPhase;

	@FindBy(how = How.ID, using = "CLM_SC_ClaimCurrentStatus_20a")
	public WebElement		lblCurrentStatusNew;

	@FindBy(how = How.ID, using = "CLM_SC_DaysRemainingInCurrentPhase_20a")
	public WebElement		lblDaysRemainingInCurrentPhaseNew;

	@FindBy(how = How.ID, using = "CLM_SC_DateOfLastStatusUpdate_20a")
	public WebElement		lblLastPhaseUpdateNew;

	// Controls for interim settlement section

	@CacheLookup
	@FindBy(how = How.ID, using = "igMOJActionsTabs_tabSelector_1")
	public WebElement		tabSettlement;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsISFirsttName")
	public WebElement		txtContactNameIS;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsISLastName")
	public WebElement		txtContactSurNameIS;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsISTelephoneNumber")
	public WebElement		txtTelephoneNoIS;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsISEmail")
	public WebElement		txtEmailAddressIS;

	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsISCRUReferenceNumber")
	public WebElement		txtCRUReferenceNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsISNoCRUReason")
	public WebElement		txtNoCRUReason;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsIRCRUDeductions")
	public WebElement		txtCRUDeductions;

	// @CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='CLM_SC_BO_MOJActionInterimRequest']/tbody/tr[3]/td[4]")
	public WebElement		tblOutcome;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='CLM_SC_BO_MOJActionInterimRequest']/tbody/tr[3]/td[9]")
	public WebElement		tblDateOfOutcome;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_MOJActionInterimRequestLosses")
	public WebElement		tblInterimRequestLosses;

	@FindBy(how = How.XPATH, using = "//*[@id='CLM_SC_BO_MOJActionInterimRequestLosses']/tbody/tr")
	public List<WebElement>	tblInterimRequestLossesRows;

	@FindBy(how = How.XPATH, using = "//*[@id='CLM_SC_BO_MOJActionInterimRequestLosses']/tbody/tr[3]/td")
	public List<WebElement>	tblInterimRequestLossesColumns;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsIRLossGrossValueClaimed")
	public WebElement		lblGrossValueClaimed;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsIRLossGrossValueAgreed")
	public WebElement		ddlGrossValueAgreed;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsIRLossGrossValueOffered")
	public WebElement		txtGrossValueOffered;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsIRLossDefendantComments")
	public WebElement		txaDefendantComments;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsIRLossDefendantContributoryDeductions")
	public WebElement		txtContributoryDeductions;

	@FindBy(how = How.ID, using = "btnCLM_SC_MOJActionsIRLossSave")
	public WebElement		btnLossSave;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnExtendInterimTimeout")
	public WebElement		btnRequestTimeoutExtention;

	@FindBy(how = How.ID, using = "btnInterimRejectRequest")
	public WebElement		btnRejectRequest;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJInterimRejectCommentsText_20a")
	public WebElement		txaRejectionComments;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJInterimRejectSave_20a")
	public WebElement		btnSaveRejectRequest;

	@FindBy(how = How.ID, using = "btnInterimSendDecision")
	public WebElement		btnSendDecision;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsIRNetValueOfOffer")
	public WebElement		lblNetValueOfOffer;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionStateFraud")
	public WebElement		btnStateFraud;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_FraudReasonCodeComments")
	public WebElement		txtStateFraud;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionSendStateFraud_20a")
	public WebElement		btnSave;

	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseOK")
	public WebElement		btnConfirm;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsViewCNF")
	public WebElement		btnViewCNF;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_ExitProcess")
	public WebElement		btnExitProcess;

	@FindBy(how = How.CLASS_NAME, using = "igWarningLabel")
	public WebElement		wrnErrorStrings;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJExitProcessReason_20a")
	public WebElement		ddlReasonToExit;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJExitProcessReasonText_20a")
	public WebElement		txtExitComments;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJExitProcessSave_20a")
	public WebElement		btnSaveExitProcess;

	// Controls for Stage 2 Settlement

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJStag2PackActionsISCRUReferenceNumber")
	public WebElement		txtCRUReferenceNumberStage2Settlement;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJStag2PackActionsISNoCRUReason")
	public WebElement		txtNoCRUReasonStage2Settlement;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsSettlementPackDecision")
	public WebElement		ddlSettlementPackDecision;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2NegotiationCRUDeductions")
	public WebElement		txtCRUDeductionsStage2Settlement;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2NegotiationAdditionalComments")
	public WebElement		txaDefendantResponseComments;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2NegotiationInterimPaymentAmnt")
	public WebElement		txtInterimPaymentAmounts;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_MOJActionStage2PackLosses")
	public WebElement		tblStage2PackLosses;

	@FindBy(how = How.XPATH, using = "//*[@id='CLM_SC_BO_MOJActionStage2PackLosses']/tbody/tr")
	public List<WebElement>	tblStage2PackLossesRows;

	@FindBy(how = How.XPATH, using = "//*[@id='CLM_SC_BO_MOJActionStage2PackLosses']/tbody/tr[3]/td")
	public List<WebElement>	tblStage2PackLossesColumns;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2PackLossGrossValueAgreed")
	public WebElement		ddlGrossValueAgreedStage2Settlement;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2PackLossGrossValueOffered")
	public WebElement		txtGrossValueOfferedStage2Settlement;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2PackLossDefendantComments")
	public WebElement		txaDefendantCommentsStage2Settlement;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2PackLossDefendantContributoryDeductions")
	public WebElement		txtContributoryDeductionsStage2Settlement;

	@FindBy(how = How.ID, using = "btnCLM_SC_MOJActionsStage2PackLossSave")
	public WebElement		btnLossSaveStage2Settlement;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnExtendStage2PackTimeout")
	public WebElement		btnRequestTimeoutExtentionStage2Settlement;

	@FindBy(how = How.ID, using = "btnStage2SendDecision")
	public WebElement		btnSendDecisionStage2Settlement;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2NegotiationNetAmntOffer")
	public WebElement		lblNetValueOfOfferStage2Settlement;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2PackLossGrossValueClaimed")
	public WebElement		lblGrossValueClaimedStage2Settlement;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2NegotiationPaymentMoreThan1000")
	public WebElement		lblTotalNetDamagesClaimedTodateStage2Settlement;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2NegotiationNetValueOfOffer")
	public WebElement		lblNetValueOfOfferTodateStage2Settlement;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2NegotiationLossesOffered")
	public WebElement		lblLossesOfferedTodateStage2Settlement;

	@FindBy(how = How.ID, using = "CLM_SC_MOJActionsStage2NegotiationInterimPaymentReceived")
	public WebElement		lblInterimPaymentReceivedStage2Settlement;

	@FindBy(how = How.ID, using = "CLM_SC_MOJ_Stage2TimeoutExtensionReason")
	public WebElement		ddlExtensionReasonStage2Settlement;

	@FindBy(how = How.ID, using = "CLM_SC_MOJ_Stage2TimeoutExtensionDate")
	public WebElement		txtRevisedTimeoutDateStage2Settlement;

	@FindBy(how = How.ID, using = "CLM_SC_MOJStage2PackExtendTimeoutSave")
	public WebElement		btnSendRequestStage2Settlement;

}
