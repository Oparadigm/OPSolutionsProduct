/**
 * 
 */
package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Alamq - This captures the page elements for the Claim Incident screen of Property Claim.
 *
 */
public class OR_ClaimIncidentDetails
{

	// Select Incident Type
	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_2821_LossTypeCode_20a")
	public WebElement		ddlIncidentType;

	// Select Incident Type Value
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_LossTypeCode_20a")
	public WebElement		ddlIncidentTypeValue;

	// Enter Incident Description
	@CacheLookup
	@FindBy(how = How.ID, using = ("CLM_SC_2821_Description_20a"))
	public WebElement		txaIncidentDescription;

	// Select CCTV Available radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_CCTVAvailable_20a")
	public List<WebElement>	rdoCCTV;

	// Select CCTV Details Text Box
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_CCTVDetails_20a")
	public WebElement		txaCCTVDetails;

	// Select 'Additional Details' drop down
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_AdditionalDetails_70a")
	public WebElement		ddlAdditionalDetails;

	// Select Date from 'Date Last occupied'
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2820_PropertyOccupiedDate_70a")
	public WebElement		dtpLastOccupied;

	// Select Date from 'Date Last Furnished'
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2820_PropertyFurnishedDate_70a")
	public WebElement		dtpLastFurnished;

	// Select 'Parties Involved Known' radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_PartiesInvolvedId_70a")
	public List<WebElement>	rdoPartiesInvolved;

	// Select 'Witnesses' radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_Incident_70a")
	public List<WebElement>	rdoWitnesses;

	// Enter Details in 'Number Of Children' Text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_NumberChildren_70a")
	public WebElement		txtNumberOfChildren;

	// Select 'Accompanied by an Adult' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2913_ChildAccompanied_70a")
	public List<WebElement>	rdoChildAccompanied;

	// Select 'Owner of the Property' Drop down
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_PropertyOwner_70a")
	public WebElement		ddlPropertyOwner;

	// Select 'Last property maintenance' Drop down
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_PropertyMaintenance_70a")
	public WebElement		ddlPropertyMaintenance;

	// Select 'Maintained By' Drop down
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_WhoMaintenance_70a")
	public WebElement		ddlMaintainedBy;

	// Select 'Animal Type' Drop down
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_AnimalType_70a")
	public WebElement		ddlAnimalType;

	// Select 'Breed' Drop down
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_Breed_70a")
	public WebElement		txtBreed;

	// Select 'Animal Owner' Drop down
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_AnimalOwner_70a")
	public WebElement		ddlAnimalOwner;

	// Select 'Caused Damage Previously' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2913_Scratch_70a")
	public List<WebElement>	rdoDamagedCausedPreviously;

	// Select 'Vicious Temperature' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2913_Propensity_70a")
	public List<WebElement>	rdoViciousTemperature;

	// Enter 'Details of Incident' in Text Box
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_IncidentOccurence_70a")
	public WebElement		txtSlipIncidentDetails;

	// Select 'Condition of Incident Area' Drop down
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_AreaCondition_70a")
	public WebElement		ddlAreaCondition;

	// Select 'Posted hazard Signs' radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_HazardSignsId_70a")
	public List<WebElement>	rdoHazardSign;

	// Select 'Incident Notification Date' from date picker
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_IncidentNotified_70a")
	public WebElement		dtpIncidentNotification;

	// Select 'When did you Notice' from date picker
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_NotificationDate_20a")
	public WebElement		dtpNotificationDate;

	// Enter 'When did you Notice' time
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_NotificationTime_20a")
	public WebElement		txtNotificationTime;

	// Enter details in 'Mitigation Action taken' Text Description
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_MitigationAction_20a")
	public WebElement		txaMitigationAction;

	// Enter details in 'How did you Notice' Text Description
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_HowIncidentNotice_20a")
	public WebElement		txaHowIncidentNotice;

	// Select 'Already repaired/replaced' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_AlreadyRepaired_20a")
	public List<WebElement>	rdoAlreadyRepaired;

	// Enter details in 'Supplier Details' Text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_SupplierDetails_20a")
	public WebElement		txtSupplierDetails;

	// Enter details in 'Repaired Amount' Text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_RepairedAmount_20a")
	public WebElement		txtRepairedAmount;

	// Select 'Organised someone to repair/replace' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_OrganisedRepaired_20a")
	public List<WebElement>	rdoOrganisedRepaired;

	// Enter details in 'Supplier Organised Details' Text field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_SupplierDetailsOrganised_20a")
	public WebElement		txtSupplierOrganisedDetails;

	// Select 'Caused by Third Party' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_CaseByThirdParty_20a")
	public List<WebElement>	rdoCauseByThirdParty;

	// Select 'By Whom' radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_ByWhom_20a")
	public WebElement		ddlByWhom;

	// Select 'Type of Risk' Table
	@CacheLookup
	@FindBy(how = How.ID, using = "divRiskTable")
	public WebElement		tblRiskTable;

	// Select 'Type of Accidental Management' drop down List
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_2820_IncidentDetails_CLM_SC_2821_AccidentalDamage_Combo_1")
	public WebElement		ddlAccidentalDamage;

	// Select 'Reported to Police' radio button
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_2820_IncidentDetails_CLM_SC_2821_AccidentalDamage_RadioGroup_1")
	public List<WebElement>	rdoReportedToPolice;

	// Enter date in 'Date reported' field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_2820_IncidentDetails_CLM_SC_2821_AccidentalDamage_Date_1")
	public WebElement		dtpDateReported;

	// Enter details in 'Police Report Number' field
	@CacheLookup
	@FindBy(how = How.ID, using = "#CLM_FR_2820_IncidentDetails_CLM_SC_2821_AccidentalDamage_TextBox_1")
	public WebElement		txtPoliceReportNumber;

	// Select 'By Whom' drop down List
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2913_WhoMaintenance_70a")
	public WebElement		ddlwhoMaintained;

	// Select 'Damage Contained within premises' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_DamageContained_20a")
	public List<WebElement>	rdoDamageContained;

	// Select 'Has property been vacant' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_VacantProperty_20a")
	public List<WebElement>	rdoVacantProperty;

	// Select 'Vacant Length' text field
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_VacantLength_20a")
	public WebElement		txtVacantLength;

	// Select 'Property Secure' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_PropertySecure_20a")
	public List<WebElement>	rdoPropertySecure;

	// Select 'Property Safe' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_PropertySafe_20a")
	public List<WebElement>	rdoPropertySafe;

	// Select 'Home Purchased in last 12 months' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_HomePurchaseInd_70a")
	public List<WebElement>	rdoHomePurchased;

	// Select 'All Services Available' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_AllServicesInd_70a")
	public List<WebElement>	rdoServicesAvailable;

	// Select 'Property Uninhabitable' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_PropertyUninhabitable_70a")
	public List<WebElement>	rdoPropertyUninhabitable;

	// Select 'Assistance required to access the Property' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_AssistanceRequired_70a")
	public List<WebElement>	rdoAssistanceRequired;

	// Enter Details in 'Property Details' text field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_PropertyDetails_70a")
	public WebElement		txtPropertyUninhabitableDetails;

	// Clicking on Ok button

	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseOK")
	public WebElement		btnOK;

	// Clicking on Save button

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_SaveRiskDetails_140a")
	public WebElement		btnSave;

	// This element captures the progress bar that appears when Save button is
	// clicked
	// This object is added to wait for the progress bar to complete in order to
	// click for next button on Claim Incident Details screen
	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement		prgProgressBar;

	@CacheLookup
	@FindBy(how = How.ID, using = "igFlowNextBtn")
	public WebElement		btnProceed;

	// Click on "Meteorological Data" field

	@CacheLookup
	@FindBy(how = How.ID, using = "expDivProperty.Incident.MetData")
	public WebElement		pnlMeteorologicalData;

	// Enter details in "Weather Station" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2827_WeatherStation_60a")
	public WebElement		txtWeatherStation;

	// Enter details in "Maximum Gust (mph)" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2827_MaxGust_60a")
	public WebElement		txtMaximumGust;

	// Enter details in "Average Wind Speed (mph)" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2827_AvgWindSpeed_60a")
	public WebElement		txtAverageWindSpeed;

	// Enter details in "Snow Fall (mm)" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2827_Snowfall_60a")
	public WebElement		txtSnowFall;

	// Enter details in "Precipitation (mm)" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2827_Precipitation_60a")
	public WebElement		txtPrecipitation;

	// Enter details in "Hours of Sun" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2827_HoursofSun_60a")
	public WebElement		txtHoursOfSun;

	// Enter details in "Minimum Temperature" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2827_MinTemp_60a")
	public WebElement		txtMinimumTemperature;

	// Enter details in "Maximum Temperature" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2827_MaxTemp_60a")
	public WebElement		txtMaximumTemperature;

	// Enter details in "Meteorological Comments" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2827_Comments_60a")
	public WebElement		txaMeteorologicalComments;

	// Below details will be used for when Type of Claim is Fire

	// Select "Reported to Fire Department" radio button

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_FireMarshallAttended_20a")
	public List<WebElement>	rdoReportedToFire;

	// Select "Reported to Police" radio button

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_ReportedToPolice_20a")
	public List<WebElement>	rdoReportedToPoliceFire;

	// Click on "Origin" dropdown list

	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_2821_StartOfFire_70a")
	public WebElement		ddlOriginFire;

	// Select value from "Origin" dropdown list

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_StartOfFire_70a")
	public WebElement		ddlOriginValueFire;

	// Enter date in "Date Reported-Fire" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_ReportDate_20a")
	public WebElement		dtpDateReportedFire;

	// Enter details in "Police report number" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_PoliceReportNumber_20a")
	public WebElement		txtPoliceReportNumberFire;

	// Select "Was anyone present in the property" radio button

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_PropertyOccupiedInd_70a")
	public List<WebElement>	rdoPropertyOccupiedFire;

	// Enter details in "who was at the property" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_PERSONATPROPERTY_70a")
	public WebElement		txtPropertyOccupiedFire;

	// Enter details in "who discovered the fire/explosion" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_PersonDiscoveredDamage_70a")
	public WebElement		txtPersonDiscoveredDamageFire;

	// Enter details in "who has access to the property" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_PersonAccessedProperty_70a")
	public WebElement		txtPersonAccessedPropertyFire;

	// Select "Electrical or other works done (last 12 months)" radio button

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_ElectricalWorkInd_70a")
	public List<WebElement>	rdoElectricalWorkDoneFire;

	// Enter details in "Electrical Work Details" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_ElectricalWorkDetail_70a")
	public WebElement		txtElectricalWorkDetailsFire;

	// Select value from "Available Rooms" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_Room_70a")
	public WebElement		tblAvailableRoomFire;

	// Select value from "Affected Rooms" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_RoomSelected_70a")
	public WebElement		tblAffectedRoomFire;

	// Click on "Select Room" button

	@CacheLookup
	@FindBy(how = How.ID, using = "btnSelectRoom")
	public WebElement		btnSelectRoomFire;

	// Click on "Deselect Room" button

	@CacheLookup
	@FindBy(how = How.ID, using = "btnDeselectRoom")
	public WebElement		btnDeselectRoomFire;

	// Additional elements displayed when Storm claim type is selected on
	// Initial details frame

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_FireMarshallAttended_20a")
	public List<WebElement>	rdoReportedToFireDeptStorm;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_ReportedToPolice_20a")
	public List<WebElement>	rdoReportedToPoliceStorm;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_ReportDate_20a")
	public WebElement		txtDateReportedStorm;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_PoliceReportNumber_20a")
	public WebElement		txtPoliceReportNoStorm;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_PropertyUnderConstructionInd_70a")
	public List<WebElement>	rdoPropertyUnderConstStorm;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_DamageToUnderConstructionInd_70a")
	public List<WebElement>	rdoDamageToAreaUnderConstStorm;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_MaintenanceCompleteInd_70a")
	public List<WebElement>	rdoMaintenanceCompletedStorm;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_MaintenanceCompleteDetail_70a")
	public WebElement		txaMaintenanceCompletedDetailsStorm;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_Opening_To_Building_70a")
	public List<WebElement>	rdoOpeningToBuildingStorm;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_Property_Flooded_70a")
	public List<WebElement>	rdoPropertyFloodedStorm;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_Maximum_Height_Of_Water_70a")
	public WebElement		ddlMaxHeightOfWaterStorm;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_Foul_Water_70a")
	public List<WebElement>	rdoFoulWaterStorm;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_Previous_Flooding_70a")
	public List<WebElement>	rdoPreviousFloodingStorm;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_Services_70a")
	public WebElement		lstServicesStorm;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnSelectService")
	public WebElement		btnSelectServiceStorm;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnDeselectService")
	public WebElement		btnDeselectServiceStorm;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_ServiceUnavailable_70a")
	public WebElement		lstServicesUnavailableStorm;

	// Additional elements displayed when "Theft or attempted theft" claim type is selected on
	// Initial details frame

	// Select "Any unauthorised occupants" radio button

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_TheftAuthorizedOccupantInd_70a")
	public List<WebElement>	rdoUnauthorisedOccupantsTheft;

	// Select "Security System" radio button

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_TheftPropertySecureInd_70a")
	public List<WebElement>	rdoSecuritySystemTheft;

	// Enter date in "Last Activated Date" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_SecurityActivatedDate_70a")
	public WebElement		dtpLastActivatedDateTheft;

	// Enter Time in "Last Activated Time" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_SecurityActivatedTime_70a")
	public WebElement		dtpLastActivatedTimeTheft;

	// Enter Time in "Security system type" field

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_securitySystemTypeCode_70a")
	public WebElement		ddlSecuritySystemTypeTheft;

	// Select value from "Point of Entry" drop down list

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_TheftEntryPointCode_70a")
	public WebElement		ddlPointOfEntryTheft;

	// Select value from "Point of Exit" drop down list

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_TheftExitPointCode_70a")
	public WebElement		ddlPointOfExitTheft;

	// Select value from "Entry Method" drop down list

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_TheftEntryMethodCode_70a")
	public WebElement		ddlEntryMethodTheft;

	// Additional elements displayed when "Explosion" claim type is selected

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2914_StartofFire_70a")
	public WebElement		ddlFireOrigion;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2914_ExplosionLocation_70a")
	public WebElement		ddlLocation;
	
	// Additional elements displayed when "Water escape" claim type is selected
	
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_TypeOfWaterCode_70a")
	public WebElement		ddlTypeOfLiquid;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_OriginatingLocationCode_70a")
	public WebElement		ddlOriginatingLocation;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_EquipmentLeakingCode_70a")
	public WebElement		ddlEquipmentLeaking;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_2821_LeakStoppedInd_70a")
	public List<WebElement>	rdoLeakingStoppped;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_HeightOfDamageCode_70a")
	public WebElement		ddlHeightOfDamage;
		

}
