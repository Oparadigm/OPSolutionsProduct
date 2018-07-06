package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Rizwan. Defining the objects for Incident Details frame in Auto Claim.
 *  
 */
public class OR_ClaimIncidentDetailsAuto
{

	// General incident details sub section elements

	@FindBy(how = How.ID, using = "CLM_SC_003_FurtherDetails_20a")
	public WebElement		ddlFurtherDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_003_InsuredDisposition_20a")
	public WebElement		ddlInsuredDisposition;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_003_LossDescription_20a")
	public WebElement		txaIncidentDescription;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_003_CCTVAvailable_20a")
	public List<WebElement>	rdoCCTVAvailable;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_003_CCTVDetails_20a")
	public WebElement		txaCCTVDetails;

	// General accident details sub section elements

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_004_IncidentDetails_Combo_1")
	public WebElement		ddlWeatherConditions;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_004_IncidentDetails_Combo_2")
	public WebElement		ddlSurfaceCondition;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_004_IncidentDetails_TextBox_1")
	public WebElement		txtImpactSpeed;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_004_IncidentDetails_TextBox_2")
	public WebElement		txtNoOfVehiclesInvolved;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_004_Accident_RadioGroup_1")
	public List<WebElement>	rdoSeatBelt;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_004_Accident_RadioGroup_2")
	public List<WebElement>	rdoRecoveredFromRoadSide;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_004_Accident_RadioGroup_3")
	public List<WebElement>	rdoLightsOn;

	// General fire details sub section elements

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_006_Fire_RadioGroup_1")
	public List<WebElement>	rdoReportedToFireDept;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_006_Fire_RadioGroup_2")
	public List<WebElement>	rdoFireReportedToPolice;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_006_Fire_Date_1")
	public WebElement		txtFireDateReported;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_006_Fire_TextBox_1")
	public WebElement		txtFireReportNo;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_006_Fire_RadioGroup_3")
	public List<WebElement>	rdoFireCulpritsDetained;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_006_Fire_LargeText_2")
	public WebElement		txaFireCulpritsDetainedDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_006_Fire_LargeText_3")
	public WebElement		txaFireDatailsOfPropertyDamage;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_006_Fire_RadioGroup_4")
	public List<WebElement>	rdoInjuriesSustained;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_006_Fire_RadioGroup_5")
	public List<WebElement>	rdoNotifiedBySupplier;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_006_Fire_LargeText_1")
	public WebElement		txaSupplierDetails;

	// General theft details sub section elements

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_1")
	public List<WebElement>	rdoTheftReportedToPolice;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_Date_1")
	public WebElement		txtTheftDateReported;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_TextBox_1")
	public WebElement		txtTheftReportNo;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_2")
	public List<WebElement>	rdoAccidentFollowingTheft;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_LargeText_2")
	public WebElement		txaTheftDamageDetails;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_3")
	public List<WebElement>	rdoLocked;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_15")
	public List<WebElement>	rdoKeysInVehicle;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_16")
	public List<WebElement>	rdoDoYouHaveAllSetsOfKeys;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_TextBox_4")
	public WebElement		txtKeyLocation;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_4")
	public List<WebElement>	rdoAlarmEnabled;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_13")
	public List<WebElement>	rdoAlaramActivated;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_5")
	public List<WebElement>	rdoSuspectsKnown;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_005_WhoRecovered")
	public WebElement		ddlRecoveredBy;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_Date_2")
	public WebElement		txtRecoveredDate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_14")
	public List<WebElement>	rdoForcibleEntry;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_Combo_1")
	public WebElement		ddlVehicleLocation;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_TextBox_2")
	public WebElement		txtSpecifyOther;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_6")
	public List<WebElement>	rdoLocks;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_7")
	public List<WebElement>	rdoIgnition;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_8")
	public List<WebElement>	rdoDashboard;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_9")
	public List<WebElement>	rdoFrontGlass;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_10")
	public List<WebElement>	rdoSideGlass;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_11")
	public List<WebElement>	rdoParts;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_RadioGroup_12")
	public List<WebElement>	rdoPartsStolen;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_FR_002_IncidentDetails_CLM_SC_005_Theft_LargeText_1")
	public WebElement		txaVehicleDamageDetails;

	// General vandalism details sub section elements

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_007_Vandalism_RadioGroup_1")
	public List<WebElement>	rdoVandalismReportedToPolice;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_007_DateReported")
	public WebElement		txtVandalismDateReported;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_007_PoliceReportNumber")
	public WebElement		txtVandalismReportNumber;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_007_Vandalism_RadioGroup_2")
	public List<WebElement>	rdoVandalismCulpritsDetained;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_007_ApprehendedDetails")
	public WebElement		txaVandalismCulpritsDetainedDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_007_PropertyDamageDetails")
	public WebElement		txaVandalismPropertyDamageDetails;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_FR_002_IncidentDetails_CLM_SC_007_Vandalism_RadioGroup_3")
	public List<WebElement>	rdoWitnessesToIncident;

}
