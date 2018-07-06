package com.innovation.pages.policy.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author M.Tahir This captures the page elements for the Vehicle Hub_Details.
 */
public class OR_PolicyVehicleHub
{
	/**
	 * @param args
	 */

	// Add new drop down - select "Auto"
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_VehicleList_RiskType")
	public WebElement		ddlVehicleRiskType;

	// Check for the Vehicle Registration Number radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "SC_VRN_Known_1c")
	public List<WebElement>	rdoVehicleRegNo;

	// This field is being used to enter the valid full/partial VRN number
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_VehicleVRNNumber")
	public WebElement		txtVRNNumber;

	// This Button is being used to search the Vehicle with the entered VRN
	@CacheLookup
	@FindBy(how = How.ID, using = "btnVINSearch")
	public WebElement		btnVINSearch;

	// The following button is being used to select the record in the vehicle search
	// list

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"tblVRNSearchResults\"]/tbody/tr[3]/td[1]")
	public WebElement		tblSearchResults;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnAdd")
	public WebElement		btnAddRisk;

	// The following objects are the ones which will be needed to add the Vehicle
	// Details
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_VehicleDetails_Financed")
	public WebElement		ddlOwnershipInd;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_Alarm")
	public WebElement		ddlAlarmType;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_Trackingdevices")
	public WebElement		ddlTrackingDevices;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_VehicleDetails_Use")
	public WebElement		ddlVehicleUse;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_BusinessAnnualKilometres")
	public WebElement		txtBusinessKMs;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_AnnualKilometres")
	public WebElement		txtAnnualKMS;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_Prior_Insurance_Carrier")
	public WebElement		ddlPriorInsurer;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_NCD_Type")
	public WebElement		ddlNCDType;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_NCD_Protected_Claims")
	public WebElement		ddlNCDProtected;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_Years_Of_Continuous_Insurance")
	public WebElement		ddlContinuousInsurance;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_NCD_Years")
	public WebElement		ddlNCDYears;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_Expiry_Date")
	public WebElement		dtpNCDExpiry;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_NCD_Confirmed_Date")
	public WebElement		dtpNCDConirmedDate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "SC_Vehicle_NCD_Protected")
	public List<WebElement>	rdoVehicleNCDProtected;

	@CacheLookup
	@FindBy(how = How.NAME, using = "SC_Vehicle_NCD_Confirmed")
	public List<WebElement>	rdoVehicleNCDConfirmed;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_NCD_Confirmation_Source")
	public WebElement		ddlNCDConfirmationSource;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_NCD_Verification_Description")
	public WebElement		ddlNCDVerification;

	@CacheLookup
	@FindBy(how = How.ID, using = "Vehicle_parked")
	public WebElement		ddlParking;

	// The following object is related to the veil progress indicator
	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement		Progressbar;

	// US related vehicle details object identification
	// Vin Search Radio Button
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_VehicleSearch_VIN")
	public WebElement		rdoVINSearch;

	// YMM Search Radio Button
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_VehicleSearch_YMM")
	public WebElement		rdoYMMSearch;

	// VIN Search Text Field
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_VehicleVinNumber")
	public WebElement		txtVehicleVIN;

	// Select Vehicle Drop down
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_VehicleSelect_1c")
	public WebElement		ddlVehicleSelect;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_VehicleDetails_Registration_State")
	public WebElement		ddlVehicleRegistrationState;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Vehicle_Odometer")
	public WebElement		txtVehicleOdo;

	// Error Handling on Vehicle Details Frame

	@FindBy(how = How.ID, using = "igErrorPanel")
	public WebElement		pnlScreenError;

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igErrorType")
	public WebElement		txtErrorType;

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igErrorClose")
	public WebElement		lnkCloseError;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnChangeAddrs")
	public WebElement		btnChangeVehicleLocation;

	@CacheLookup
	@FindBy(how = How.ID, using = "vehicleLocationAlterGarageYes")
	public WebElement		rdoChangeAddress;

}
