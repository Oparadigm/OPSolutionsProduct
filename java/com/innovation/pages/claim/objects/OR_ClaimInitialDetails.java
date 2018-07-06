
package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Rizwan. This captures the page elements for the Initial Details screen for Home/Auto LOBs.
 *
 */
public class OR_ClaimInitialDetails
{

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_ReportedBy_2c")
	public WebElement	ddlReportedBy;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_Title_2c")
	public WebElement	ddlTitle;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_FirstName_2c")
	public WebElement	txtFirstName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_LastName_2c")
	public WebElement	txtLastName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_CallerAreaCode_2c")
	public WebElement	ddlPhoneAreaCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_CallerContactNumber_2c")
	public WebElement	txtPhoneNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_CallerContactNumberExt_2c")
	public WebElement	txtPhoneExt;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_BestContactTime_2c")
	public WebElement	ddlBestContactTime;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_NotificationTime_2c")
	public WebElement	txtNotificationTime;

	// This element is used to click on Claim Type dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_2708_PerilCode_2c")
	public WebElement	ddlClaimType;

	// This element is used to select a value from Claim Type dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_PerilCode_2c")
	public WebElement	ddlClaimTypeValues;

	// This element is used to click on Incident Cause dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_2821_LossTypeCode_2c")
	public WebElement	ddlIncidentCause;

	// This element is used to select a value from Incident Cause dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2821_LossTypeCode_2c")
	public WebElement	ddlIncidentCauseValues;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_IncidentTime_2c")
	public WebElement	txtIncidentTime;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html/body/form/div[10]/span/div[2]/table/tbody/tr[2]/td[1]/div/table[12]/tbody/tr/td[2]/div/input[2]")
	public WebElement	rdoSevereLoss;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_LossDescription_2c")
	public WebElement	txaLossDescription;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_ReferenceNumber_2c")
	public WebElement	txtReferenceNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_010_AddressSearchCriteria_2e")
	public WebElement	txtZipCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_Locate_2e")
	public WebElement	imgZipSearch;

	// This element is used to click on Results dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_010_AddressSearchResults_2e")
	public WebElement	ddlAddressSearchResults;

	// This element is used to select the first value from Results dropdown when it has multiple values
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]")
	public WebElement	ddlAddressSearchResultsValues;

	// This element is used to check if ZIP code search has returned only one address
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_010_AddressSelected_2e")
	public WebElement	lblAddressSelected;

	// This element is used to check if ZIP code code search has returned no address
	@CacheLookup
	@FindBy(how = How.ID, using = "lblAddressErrorMsg")
	public WebElement	lblAddressSearchError;

	@FindBy(how = How.ID, using = "CLM_SC_010_AddressManual_2e")
	public WebElement	chkManualAddress;

	@FindBy(how = How.ID, using = "cGB_E_igAddrLine1_2e")
	public WebElement	txtAddressLine1;

	@FindBy(how = How.ID, using = "cGB_E_igAddrCity_2e")
	public WebElement	txtTown;

	@FindBy(how = How.ID, using = "cGB_E_igAddrCounty_2e")
	public WebElement	ddlCounty;

	@FindBy(how = How.ID, using = "cGB_E_igAddrPostcode_2e")
	public WebElement	txtPostCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_IncidentLocationDetail_2f")
	public WebElement	txaLocationDescription;

	@CacheLookup
	@FindBy(how = How.ID, using = "igFlowNextBtn")
	public WebElement	btnSaveAndProceed;

}
