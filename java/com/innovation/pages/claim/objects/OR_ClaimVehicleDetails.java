package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author alamq. This captures the page elements for the "Vehicle Details" screen for Motor LOB.
 *
 */
public class OR_ClaimVehicleDetails
{

	// This element is used to select "Vehicle" Tab
	@CacheLookup
	@FindBy(how = How.ID, using = "igVehicleTabs_tabSelector_1")
	public WebElement		tabVehicle;

	// This element is used to select "Appraisal" Tab
	@CacheLookup
	@FindBy(how = How.ID, using = "igVehicleTabs_tabSelector_2")
	public WebElement		tabAppraisal;

	// This element is used to select "Damage" Tab
	@CacheLookup
	@FindBy(how = How.ID, using = "igVehicleTabs_tabSelector_3")
	public WebElement		tabDamage;

	// This element is used to select "Supplier" Tab
	@CacheLookup
	@FindBy(how = How.ID, using = "igVehicleTabs_tabSelector_4")
	public WebElement		tabSupplier;

	// This element is used to click on 'Search' button under Supplier tab
	@CacheLookup
	@FindBy(how = How.CSS, using = "#vendor_btns_Search > div > button")
	public WebElement		btnSupplierSearch;

	// This element is used to select "Property" Tab
	@CacheLookup
	@FindBy(how = How.ID, using = "igVehicleTabs_tabSelector_5")
	public WebElement		tabProperty;

	// This element is used to click on "Add" button under Property tab
	@CacheLookup
	@FindBy(how = How.ID, using = "btnAddNew")
	public WebElement		btnAdd;

	// This element is used to select "Vehicle Type" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_VehicleClass_10a")
	public WebElement		ddlVehicleType;

	// This element is used to select "Vehicle Details Known" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Vehicle_Details_Known_10a")
	public List<WebElement>	rdoVehicleDetailsKnown;

	// This element is used to click on "search" Button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Locate_10a")
	public WebElement		btnVehicleSearch;

	// This element is used to enter details in "Vehicle registration number" text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_LicenceNumber_10a")
	public WebElement		txtVehicleRegistrationNumber;

	// This element is used to select "Year" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Year_10a")
	public WebElement		ddlYear;

	// This element is used to select "Make" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_023_Make_10a")
	public WebElement		ddlMake;

	// This element is used to select value of "Make" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Make_10a")
	public WebElement		ddlMakeValue;

	// This element is used to select "Model" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_023_Model_10a")
	public WebElement		ddlModel;

	// This element is used to select value of "Model" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Model_10a")
	public WebElement		ddlModelValue;

	// This element is used to select "Vehicle category" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Category_10a")
	public WebElement		ddlVehicleCategory;

	// This element is used to select "Body style" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_023_BodyStyle_10a")
	public WebElement		ddlBodyStyle;

	// This element is used to select value of "Body style" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_BodyStyle_10a")
	public WebElement		ddlBodyStyleValue;

	// This element is used to select "Colour" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_023_Colour_10a")
	public WebElement		ddlColour;

	// This element is used to select value of "Colour" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Colour_10a")
	public WebElement		ddlColourValue;

	// This element is used to select "Transmission" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Transmission_10a")
	public WebElement		ddlTransmission;

	// This element is used to enter details in "Engine size (cc)" text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_EngineSize_10a")
	public WebElement		txtEngineSize;

	// This element is used to enter details in "Number of doors" text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_NumberOfDoors_10a")
	public WebElement		txtNumberOfDoors;

	// This element is used to enter details in "Current mileage" text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_CurrentMileage_10a")
	public WebElement		txtCurrentMileage;

	// This element is used to enter details in "VIN" text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_VIN_10a")
	public WebElement		txtVIN;

	// This element is used to enter details in "V5" text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Document_Reference_10a")
	public WebElement		txtV5;

	// This element is used to enter details in "Owner" text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Owner_10a")
	public WebElement		txtOwner;

	// This element is used to select "MID search performed" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_InsuranceInd_10a")
	public List<WebElement>	rdoMIDSearchPerformed;

	// This element is used to select "MIAFTR search performed" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Vehicle_MIAFTR_Indicator_10a")
	public List<WebElement>	rdoMIAFTRSearchPerformed;

	// This element is used to enter details in "MIAFTR Details" text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Owner_10a")
	public WebElement		txaMIAFTRDetails;

	// This element is used to select "Role" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_Role_10a")
	public WebElement		ddlRole;

	// This element is used to select "Actual use" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_ActualUse_10a")
	public WebElement		ddlActualUse;

	// This element is used to select "Permissible use" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_PerUse_Label_10a")
	public WebElement		ddlPermissibleUse;

	// This element is used to enter details in "No. of passengers" text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_NoOfPassengers_10a")
	public WebElement		txtNoOfPassengers;

	// This element is used to select "Vehicle Moving" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_VehicleMoving_10a")
	public List<WebElement>	rdoVehicleMoving;

	// This element is used to select "Vehicle driveable" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_VehicleDriveable_10a")
	public List<WebElement>	rdoVehicleDriveable;

	// This element is used to select "Repairs complete" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_RepairsComplete_10a")
	public List<WebElement>	rdoRepairsComplete;

	// This element is used to select "Secure" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_VehicleSecure_10a")
	public List<WebElement>	rdoSecure;

	// This element is used to select "Permission to Drive" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_023_PhPermission_10a")
	public List<WebElement>	rdoDrivePermission;

	// This element is used to select "Vehicle Damage" dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_024_Damaged_10a")
	public WebElement		ddlVehicleDamage;

	// This element is used to select "Claiming for damage" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_024_VehicleClaim_10a")
	public List<WebElement>	rdoClaimingforDamage;

	// This element is used to select "Settlement route" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_024_SettlemntRoute")
	public List<WebElement>	rdoSettlementRoute;

	// This element is used to select "Type of damage" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_024_TypeOfDamage")
	public List<WebElement>	rdoDamageType;

	// This element is used to select "Mechanical" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_024_MechincalDamage_10a")
	public List<WebElement>	rdoMechanical;

	// This element is used to select "Interior" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_024_InteriorDamage_10a")
	public List<WebElement>	rdoInterior;

	// This element is used to select "ICE" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_024_ICE_10a")
	public List<WebElement>	rdoICE;

	// This element is used to select "Under Body" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_024_UnderBodyDamage_10a")
	public List<WebElement>	rdoUnderBody;

	// This element is used to select "Locks" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_024_LockDamage_10a")
	public List<WebElement>	rdoLocks;

	// This element is used to select "Wheel" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_024_WheelDamage_10a")
	public List<WebElement>	rdoWheel;

	// This element is used to select "Glass" radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_024_GlassDamage_10a")
	public List<WebElement>	rdoGlass;

	// This element is used to enter details in "Comments" text area field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_024_Comments_10a")
	public WebElement		txaComments;

	// This element is used to click on Car Roof Damage
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CAR_ROOF")
	public WebElement		imgCarRoof;

	// This element is used to click on Car Bonet Damage
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CAR_BONNET")
	public WebElement		imgCarBonnet;

	// This element is used to click on Car Boot Damage
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CAR_BOOT")
	public WebElement		imgCarBoot;

	// This element is used to click on Damage Arrow 1
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CLOCK_ONE")
	public WebElement		imgMinorDamageArrow1;

	// This element is used to click on Damage Arrow 2
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CLOCK_TWO")
	public WebElement		imgMinorDamageArrow2;

	// This element is used to click on Minor Damage Arrow 3
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CLOCK_THREE")
	public WebElement		imgMinorDamageArrow3;

	// This element is used to click on Damage Arrow 4
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CLOCK_FOUR")
	public WebElement		imgMinorDamageArrow4;

	// This element is used to click on Damage Arrow 5
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CLOCK_FIVE")
	public WebElement		imgMinorDamageArrow5;

	// This element is used to click on Damage Arrow 6
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CLOCK_SIX")
	public WebElement		imgMinorDamageArrow6;

	// This element is used to click on Damage Arrow 7
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CLOCK_SEVEN")
	public WebElement		imgMinorDamageArrow7;

	// This element is used to click on Damage Arrow 8
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CLOCK_EIGHT")
	public WebElement		imgMinorDamageArrow8;

	// This element is used to click on Damage Arrow 9
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CLOCK_NINE")
	public WebElement		imgMinorDamageArrow9;

	// This element is used to click on Damage Arrow 10
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CLOCK_TEN")
	public WebElement		imgMinorDamageArrow10;

	// This element is used to click on Damage Arrow 11
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CLOCK_ELEVEN")
	public WebElement		imgMinorDamageArrow11;

	// This element is used to click on Damage Arrow 12
	@CacheLookup
	@FindBy(how = How.ID, using = "div_CLOCK_TWELVE")
	public WebElement		imgMinorDamageArrow12;

	// This element is used to click on Major Damage Arrow 1
	@CacheLookup
	@FindBy(how = How.ID, using = "CLOCK_ONE")
	public WebElement		imgMajorDamageArrow1;

	// This element is used to click on Major Damage Arrow 2
	@CacheLookup
	@FindBy(how = How.ID, using = "CLOCK_TWO")
	public WebElement		imgMajorDamageArrow2;

	// This element is used to click on Major Damage Arrow 3
	@CacheLookup
	@FindBy(how = How.ID, using = "CLOCK_THREE")
	public WebElement		imgMajorDamageArrow3;

	// This element is used to click on Major Damage Arrow 4
	@CacheLookup
	@FindBy(how = How.ID, using = "CLOCK_FOUR")
	public WebElement		imgMajorDamageArrow4;

	// This element is used to click on Major Damage Arrow 5
	@CacheLookup
	@FindBy(how = How.ID, using = "CLOCK_FIVE")
	public WebElement		imgMajorDamageArrow5;

	// This element is used to click on Major Damage Arrow 6
	@CacheLookup
	@FindBy(how = How.ID, using = "CLOCK_SIX")
	public WebElement		imgMajorDamageArrow6;

	// This element is used to click on Major Damage Arrow 7
	@CacheLookup
	@FindBy(how = How.ID, using = "CLOCK_SEVEN")
	public WebElement		imgMajorDamageArrow7;

	// This element is used to click on Major Damage Arrow 8
	@CacheLookup
	@FindBy(how = How.ID, using = "CLOCK_EIGHT")
	public WebElement		imgMajorDamageArrow8;

	// This element is used to click on Major Damage Arrow 9
	@CacheLookup
	@FindBy(how = How.ID, using = "CLOCK_NINE")
	public WebElement		imgMajorDamageArrow9;

	// This element is used to click on Major Damage Arrow 10
	@CacheLookup
	@FindBy(how = How.ID, using = "CLOCK_TEN")
	public WebElement		imgMajorDamageArrow10;

	// This element is used to click on Major Damage Arrow 11
	@CacheLookup
	@FindBy(how = How.ID, using = "CLOCK_ELEVEN")
	public WebElement		imgMajorDamageArrow11;

	// This element is used to click on Major Damage Arrow 12
	@CacheLookup
	@FindBy(how = How.ID, using = "CLOCK_TWELVE")
	public WebElement		imgMajorDamageArrow12;

	// This element is used to select "Is the vehicle pre-2000" checkbox. This checkbox is display under General section
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_025_General1_10a")
	public WebElement		chkPre2000;

	// This element is used to select "Vehicle entirley consumed in the loss" checkbox. This checkbox is display under Fire section
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_025_Fire1_10a")
	public WebElement		chkVehicleConsumedEntirly;

	// This element is used to select "Water level rise above the dash" checkbox. This checkbox is display under Water loss section
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_025_WaterLoss1_10a")
	public WebElement		chkLevelAboveDash;

	// This element is used to select "Did the Vehicle roll over". This checkbox is display under Collision section
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_025_Collision1_10a")
	public WebElement		chkvehicleRollOver;

	// This element is used to click on Calculate button
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"tabContentDiv2\"]/table/tbody/tr[1]/td[2]/table[9]/tbody/tr/td[2]/div/button")
	public WebElement		btnCalculate;

}
