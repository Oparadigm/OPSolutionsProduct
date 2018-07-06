package com.innovation.pages.policy.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs This captures the page elements for the Policy Residential Details screen.
 * 
 */
public class OR_PolicyResidentialDetails
{
	/**
	 * @param args
	 */

	@CacheLookup
	@FindBy(how = How.NAME, using = "NoUnits")
	public WebElement		ddlNoUnits;

	@CacheLookup
	@FindBy(how = How.NAME, using = "PrimaryHeating")
	public WebElement		ddlPrimaryHeating;

	@CacheLookup
	@FindBy(how = How.ID, using = "OilTankLocation")
	public WebElement		ddlOilTankLocation;

	@CacheLookup
	@FindBy(how = How.ID, using = "OilTankInstallYear")
	public WebElement		ddlOilTankInstallYear;

	@CacheLookup
	@FindBy(how = How.NAME, using = "SecondaryHeating")
	public WebElement		ddlSecondaryHeating;

	@CacheLookup
	@FindBy(how = How.NAME, using = "StructureType")
	public WebElement		ddlStructureType;

	@CacheLookup
	@FindBy(how = How.ID, using = "ChimneyInspectionYear")
	public WebElement		ddlChimneyInspectionYear;

	@CacheLookup
	@FindBy(how = How.NAME, using = "Heating")
	public WebElement		ddlHeating;

	@CacheLookup
	@FindBy(how = How.NAME, using = "Electrical")
	public WebElement		ddlElectrical;

	@CacheLookup
	@FindBy(how = How.NAME, using = "Plumbing")
	public WebElement		ddlPlumbing;

	@CacheLookup
	@FindBy(how = How.NAME, using = "Roof")
	public WebElement		ddlRoof;

	@CacheLookup
	@FindBy(how = How.NAME, using = "RoofType")
	public WebElement		ddlRoofType;

	@CacheLookup
	@FindBy(how = How.NAME, using = "Pro_Financed")
	public WebElement		ddlProFinanced;

	@CacheLookup
	@FindBy(how = How.NAME, using = "BuildYear")
	public WebElement		ddlBuildYear;

	@CacheLookup
	@FindBy(how = How.NAME, using = "RatingTerritory")
	public WebElement		ddlRatingTerritory;

	@CacheLookup
	@FindBy(how = How.NAME, using = "OverrideReason")
	public WebElement		ddlOverrideReason;

	@CacheLookup
	@FindBy(how = How.NAME, using = "TierCode")
	public WebElement		ddlTierCode;

	@CacheLookup
	@FindBy(how = How.NAME, using = "PropFireProtProvider")
	public WebElement		ddlFireProtectionProvide;

	@CacheLookup
	@FindBy(how = How.NAME, using = "FireProtClassOReason")
	public WebElement		ddlFireProtClassOReason;

	@CacheLookup
	@FindBy(how = How.NAME, using = "EarthquakeZone")
	public WebElement		ddlEarthquakeZone;

	@CacheLookup
	@FindBy(how = How.NAME, using = "MinesubZone")
	public WebElement		ddlMinesubZone;

	@CacheLookup
	@FindBy(how = How.NAME, using = "WindZone")
	public WebElement		ddlWindZone;

	// Year built drop down list
	// @CacheLookup
	@FindBy(how = How.ID, using = "BuildYear")
	public WebElement		ddlYearBuilt;

	// Number of bedrooms drop down list
	// @CacheLookup
	@FindBy(how = How.ID, using = "NoBdrms")
	public WebElement		ddlNoOfBedrooms;

	// Number of units drop down list
	@CacheLookup
	@FindBy(how = How.ID, using = "NoUnits")
	public WebElement		ddlNoOfUnits;

	// Ownership drop down list
	@CacheLookup
	@FindBy(how = How.ID, using = "Pro_Financed")
	public WebElement		ddlOwnership;

	// Hold type drop down list
	@CacheLookup
	@FindBy(how = How.ID, using = "HoldType")
	public WebElement		ddlHoldType;

	// Proceed Next Button
	@CacheLookup
	@FindBy(how = How.ID, using = "btnContinue")
	public WebElement		btnProceedNext;

	// Residence Type
	@CacheLookup
	@FindBy(how = How.ID, using = "PrimaryUse")
	public WebElement		ddlResidenceType;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_property_Details_DIV_Combo_2")
	public WebElement		ddlConstructionType;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_property_Details_DIV_Combo_4")
	public WebElement		ddlUnderConstruction;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_property_Details_DIV_Combo_5")
	public WebElement		ddlSwimmingPoolType;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_residential_Details_DIV_Combo_1")
	public WebElement		ddlResidentialUse;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_residential_Details_DIV_Combo_2")
	public WebElement		ddlMonthsOccupied;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_residential_Details_DIV_Combo_4")
	public WebElement		ddlDangerousAnimal;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_Qte_5_residential_Details_DIV_Combo_1")
	public WebElement		ddlManagedByAgents;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_residential_Details_DIV_Combo_3")
	public WebElement		ddlNoRoomersBoarders;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_residential_Details_DIV_TextBox_1")
	public WebElement		txtNumberOfFamilies;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_residential_Details_DIV_RadioGroup_1")
	public List<WebElement>	lstResidenceOccupiedByFamily;

	@CacheLookup
	@FindBy(how = How.ID, using = "DistToFireHydrant")
	public WebElement		ddlDistToFireHydrant;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_protections_DIV_RadioGroup_1")
	public List<WebElement>	lstFireExtinguisher;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_protections_DIV_Combo_1")
	public WebElement		ddlFireProtectionDevices;

	@CacheLookup
	@FindBy(how = How.ID, using = "PropDistToFireStation")
	public WebElement		ddlDistanceOfFireStation;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_protections_DIV_Combo_2")
	public WebElement		ddlTheftDevices;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_policyOptions_DIV_Combo_4")
	public WebElement		ddlBuildingReplacementCost;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_policyOptions_DIV_Combo_3")
	public WebElement		ddlContentsReplacementCost;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_policyOptions_DIV_RadioGroup_1")
	public List<WebElement>	lstRoofACV;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_policyOptions_DIV_Combo_8")
	public WebElement		ddlMineSubSidenece;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_policyOptions_DIV_Combo_1")
	public WebElement		ddlStandardDeductible;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_policyOptions_DIV_Combo_5")
	public WebElement		ddlWindHailDeductible;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_policyOptions_DIV_Combo_6")
	public WebElement		ddlSpecialTheft;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_policyOptions_DIV_Combo_7")
	public WebElement		ddlEarthQuakeDeductible;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_1_property_Details_DIV_TextBox_1")
	public WebElement		txtTotalLivingArea;

	@CacheLookup
	@FindBy(how = How.ID, using = "Pro_Financed")
	public WebElement		ddlPropertyFinanced;

	@CacheLookup
	@FindBy(how = How.ID, using = "POL_FR_GenericPropertyDetails_SC_PropertyDetails_5_residential_Details_DIV_Combo_1")
	public WebElement		ddlManagedAgents;

}
