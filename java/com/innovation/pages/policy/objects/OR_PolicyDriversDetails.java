package com.innovation.pages.policy.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs This captures the page elements for the Policy Preliminary
 *         Questions screen.
 * 
 */
public class OR_PolicyDriversDetails {
	/**
	 * @param args
	 */

	// Add new Driver Button - Add Driver
	@CacheLookup
	@FindBy(how = How.ID, using = "btnAddDriver")
	public WebElement btnAddDriver;

	// Edit Driver Button - Edit Driver
	@CacheLookup
	@FindBy(how = How.ID, using = "btnEditDriver")
	public WebElement btnEditDriver;

	// Remove Driver Button - Remove Driver
	@CacheLookup
	@FindBy(how = How.ID, using = "btnRemoveDriver")
	public WebElement btnRemoveDriver;

	// Losses and Convictions Button - Losses and Convictions
	@CacheLookup
	@FindBy(how = How.ID, using = "btnLossConviction")
	public WebElement btnLossesConvictions;

	// On Edit Driver - Add License Details

	// Country Drop Down
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_LicenceCountry")
	public WebElement ddlCountrySelect;

	// Status Drop Down
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_LicenceStatus")
	public WebElement ddlStatus;

	// Driving License Number Drop Down
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_LicenceNumber")
	public WebElement txtLicenseNumber;

	// Driving License Type
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_LicenceType")
	public WebElement ddlLicneseType;

	// Driving License Years
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_LicenceHeldYears")
	public WebElement ddlLicenseYear;

	// Driver Details Update
	@CacheLookup
	@FindBy(how = How.ID, using = "btnDriverDetailsUpdate")
	public WebElement btnDriverDetailsUpdate;

	// Progress Bar
	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement prgProgress;

	// Proceed Next Button
	@CacheLookup
	@FindBy(how = How.ID, using = "flowBtnContinue")
	public WebElement btnProceedNext;

	// Table of existing Driver
	@CacheLookup
	@FindBy(how = How.ID, using = "tblDriver_001813")
	public WebElement tblDriversList;

	// The following Repository is for US related Driver Screen
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_LicenceState")
	public WebElement ddlLicenseState;

	// Check for the License Cancellation Indicator
	@CacheLookup
	@FindBy(how = How.NAME, using = "SC_DriverDetails_002515_LicenceCancelledIndicator")
	public List<WebElement> rdoLicenseCancellationIndicator;

	// Check the License Start Date
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_LicenceStartDate")
	public WebElement dtpLicenseStartDate;

	// Enter the First License Date
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_LicenceFirstYear")
	public WebElement txtLicenseFirstYear;

	// Enter the Driver Training
	@CacheLookup
	@FindBy(how = How.NAME, using = "SC_DriverDetails_002515_DriverTrainingIndicator")
	public List<WebElement> rdoDriverTrainingIndicator;

	// Driver Retirement Indicator
	@CacheLookup
	@FindBy(how = How.NAME, using = "SC_DriverDetails_002515_DriverTrainingIndicator")
	public List<WebElement> rdoDriverRetiredIndicator;

	// Student Away Indicator
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_StudentAwayIndicator")
	public WebElement ddlStudentAwayIndicator;

	// Defensive Driver Indicator
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_DefensiveDriver")
	public WebElement ddlDefensiveDriverIndicator;

	// Defensive Good Student Indicator
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_GoodStudentIndicator")
	public WebElement ddlGoodStudentIndicator;

	// Defensive Defensive Driver date
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_DefensiveDriverDate")
	public WebElement dtpDefensiveDriverDate;

	// Defensive Good Student date
	@CacheLookup
	@FindBy(how = How.ID, using = "	SC_DriverDetails_002515_GoodStudentDate")
	public WebElement dtpGoodStudentDate;

	// License if Less Than 1 Year
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_DriverDetails_002515_LicenceHeldMonths")
	public WebElement ddlDriverLicensedMonths;

}
