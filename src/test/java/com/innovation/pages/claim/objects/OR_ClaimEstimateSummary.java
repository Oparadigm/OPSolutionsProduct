package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Alamq - defining the objects for 'Estimate summary' frame accessible through BO Navigation panel > Property damage > Estimate
 *  
 */

public class OR_ClaimEstimateSummary
{
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_Supplier_30a")
	public WebElement	ddlSupplier;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_Owner_30a")
	public WebElement	ddlOwner;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_JobReference_30a")
	public WebElement	ddlSupplierJobReference;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_EstimateDate_30a")
	public WebElement	txtEstimateDateProperty;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_Supplier_Reference_30a")
	public WebElement	txtSupplierReference;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "NewJob")
	public WebElement	btnNewJob;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_EstimateSystemCode_30a")
	public WebElement	ddlEstimatingSystemProperty;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "AddEstimate")
	public WebElement	btnSave;
	
//	Defining the objects for Estimate Summary frame in Auto Claim.
	
	// This element is used to select value from "Supplier name" dropdown 
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_EstimateSource")
	public WebElement	ddlSupplierName;

	// This element is used to select value from "Estimating System" dropdown 
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_EstimatingSystem")
	public WebElement	ddlEstimatingSystemAuto;	

	// This element is used to enter text in "Reference Number" text field 
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_EstimateReference")
	public WebElement	txtReferenceNumber;
	
	// This element is used to select value from "Repairable" dropdown
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_BO_0143_Repairable")
	public List <WebElement>	rdoRepairable;

	// This element is used to select value from "Total Loss Indicator" dropdown
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_BO_0143_TotalLoss")
	public List <WebElement>	rdoTotalLossIndicator;
	
	// This element is used to enter date in "Estimate Date" field 
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_EstimateDate")
	public WebElement	txtEstimateDateAuto;

	// This element is used to enter date in "Assessment Date" field 
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_EstimateDateAssessed")
	public WebElement	txtAssessmentDate;
	
	// This element is used to enter text in "Pre accident value" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_PreAccidentValue")
	public WebElement	txtPreAccidentValue;	

	// This element is used to enter text in "Insured value" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_DiminishedValue")
	public WebElement	txtInsuredValue;
	
	// Estimate Details section
	
	// This element is used to enter text in "MET labour rate" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_MetalLaborRate")
	public WebElement	txtMETLabourRate;
		
	// This element is used to enter text in "MET labour Hours" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_MetalLaborHour")
	public WebElement	txtMETLabourHours;
	
	// This element is used to enter text in "Mechanical Labour Rate" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_MechanicalLaborRate")
	public WebElement	txtMechanicalLabourRate;
	
	// This element is used to enter text in "Mechanical Labour Hours" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_MechanicalLaborHour")
	public WebElement	txtMechanicalLabourHours;


	// This element is used to enter text in "Panel Labour Rate" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_RefinishLaborRate")
	public WebElement	txtPanelLabourRate;
	
	// This element is used to enter text in "Panel Labour Hours" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_RefinishLaborHour")
	public WebElement	txtPanelLabourHours;
	
	// This element is used to enter text in "Paint Labour Rate" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_RefinishLaborRate")
	public WebElement	txtPaintLabourRate;
	
	// This element is used to enter text in "Paint Labour Hours" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_RefinishLaborHour")
	public WebElement	txtPaintLabourHours;
	
	// This element is used to enter text in "Miscellaneous Labour Rate" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_MiscLaborRate")
	public WebElement	txtMiscellaneousLabourRate;
	
	// This element is used to enter text in "Miscellaneous Labour Hours" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_MiscLaborRate")
	public WebElement	txtMiscellaneousLabourHours;	
	
	// This element is used to enter text in "Parts Total" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_PartsTotalValue")
	public WebElement	txtPartsTotal;	

	// This element is used to enter text in "Paint and Materials" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_PartsTotalValue")
	public WebElement	txtPaintMaterials;
	
	// This element is used to enter text in "Specialist Charges" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_PartsTotalValue")
	public WebElement	txtSpecialistCharges;
	
	// This element is used to enter text in "Sundries" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_SundriesValue")
	public WebElement	txtSundries;
	
	// This element is used to enter text in "Corrosion protection" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_CorrosionProtectionValue")
	public WebElement	txtCorrosionProtection;	
	
	// This element is used to enter text in "Environmental charges" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_EPAChargesValue")
	public WebElement	txtEnvironmentalCharges;	
	
	// This element is used to enter text in "Storage" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_StorageValue")
	public WebElement	txtStorage;	
	
	// This element is used to enter text in "Towing" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_TowingValue")
	public WebElement	txtTowing;	

	// This element is used to enter text in "Storage and Coverage" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_InheritedStorage")
	public WebElement	txtStorageAndCoverage;	
	
	// This element is used to enter text in "Policyholder contributions" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_InheritedStorage")
	public WebElement	txtPolicyholderContributions;

	// This element is used to enter text in "Contract Repair" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_ContributionsValue")
	public WebElement	txtContractRepair;
	
	// This element is used to enter text in "Other Adjustments" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_OtherAdjustment")
	public WebElement	txtOtherAdjustments;

	// This element is used to enter text in "VAT" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_TaxValue")
	public WebElement	txtVAT;
	
	// This element is used to enter text in "Excess" field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_DeductibleValue")
	public WebElement	txtExcess;
	
	// This element is used to click on "Save" button for auto LOB
	@FindBy(how = How.ID, using = "EstimateSave")
	public WebElement	btnSaveAuto;
	
	// This element is used to click on "Yes" button 
	@FindBy(how = How.XPATH, using = "//*[@id='igUserInteractResponseYes']")
	public WebElement	btnYes;
	
	// This element is used to enter date in "Repair Authorisation" Date
	
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_AuthorizationDate")
	public WebElement	txtRepairAuthorsationDate;
	
	// This element is used to select value from "Repair Authorisation Type" dropdown 
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0143_AuthorizationType")
	public WebElement	ddlRepairAuthorsationType;
	
	// This element is used to click on "Save" button for auto LOB
	@FindBy(how = How.ID, using = "createInvoicefromEstimate")
	public WebElement	btnCreateInvoice;
	
}
