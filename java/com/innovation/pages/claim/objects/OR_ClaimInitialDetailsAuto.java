
package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author alamq. This captures the page elements for the Initial Details screen for Auto LOBs.
 *
 */
public class OR_ClaimInitialDetailsAuto
{

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_ReportedBy_20a")
	public WebElement	ddlReportedBy;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_NameTitle_20a")
	public WebElement	ddlTitle;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_CallerFirstName_20a")
	public WebElement	txtFirstName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_CallerName_20a")
	public WebElement	txtLastName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_CallerAreaCode_20a")
	public WebElement	ddlPhoneAreaCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_CallerContactNumber_20a")
	public WebElement	txtPhoneNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_CallerContactNumber2_20a")
	public WebElement	txtPhoneExt;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_BestContactTime_20a")
	public WebElement	ddlBestContactTime;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_NotificationTime_20a")
	public WebElement	txtNotificationTime;

	// This element is used to click on Claim Type dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_PerilCode_20a")
	public WebElement	ddlClaimType;

	// This element is used to click on Incident Cause dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_001_LossCause_20a")
	public WebElement	ddlIncidentCause;

	// This element is used to select a value from Incident Cause dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_LossCause_20a")
	public WebElement	ddlIncidentCauseValues;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_IncidentTime_20a")
	public WebElement	txtIncidentTime;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2708_LossDescription_2c")
	public WebElement	txaLossDescription;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_001_ReferenceNumber_20a")
	public WebElement	txtReferenceNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_010_AddressSearchCriteria_30a")
	public WebElement	txtZipCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_Locate_30a")
	public WebElement	imgZipSearch;

	// This element is used to click on Results dropdown
	@CacheLookup
	@FindBy(how = How.ID, using = "dhx_img_CLM_SC_010_AddressSearchResults_30a")
	public WebElement	ddlAddressSearchResults;

	// This element is used to select the first value from Results dropdown when it
	// has multiple values
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]")
	public WebElement	ddlAddressSearchResultsValues;

	// This element is used to check if ZIP code search has returned only one
	// address
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_010_AddressSelected_30a")
	public WebElement	lblAddressSelected;

	// This element is used to check if ZIP code code search has returned no address
	@CacheLookup
	@FindBy(how = How.ID, using = "lblAddressErrorMsg")
	public WebElement	lblAddressSearchError;

	@FindBy(how = How.ID, using = "CLM_SC_010_AddressManual_30a")
	public WebElement	chkManualAddress;

	@FindBy(how = How.ID, using = "cGB_E_igAddrLine1_30a")
	public WebElement	txtAddressLine1;

	@FindBy(how = How.ID, using = "cGB_E_igAddrCity_30a")
	public WebElement	txtTown;

	@FindBy(how = How.ID, using = "cGB_E_igAddrCounty_30a")
	public WebElement	ddlCounty;

	@FindBy(how = How.ID, using = "cGB_E_igAddrPostcode_30a")
	public WebElement	txtPostCode;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_002_Details_40a")
	public WebElement	txaLocationDescription;

	@CacheLookup
	@FindBy(how = How.ID, using = "igFlowNextBtn")
	public WebElement	btnSaveAndProceed;

}
