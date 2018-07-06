package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Rizwan. This captures the page elements for Claim's FNOL Vehicle/Driver screen in Auto LOBs.
 *   
 */
public class OR_ClaimVehicleDriver
{

	// This element is used to identify Vehicle Other radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_016_SelectVehicle_20a")
	public List<WebElement>	rdoVehicleOther;

	// This captures the listed vehicles table
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_016_SelectVehicle")
	public WebElement		tblListedVehicles;

	// This captures the radio group to select the driver type

	@FindBy(how = How.NAME, using = "CLM_SC_015_SelectDriver_30a")
	public List<WebElement>	rdoDriverType;

	// This captures the listed drivers table

	@FindBy(how = How.ID, using = "CLM_SC_015_SelectDriver")
	public WebElement		tblListedDrivers;

	// This captures Yes button displayed on 'Select vehicle' and 'Select
	// driver' pop ups that are displayed on selecting the vehicle type and
	// driver type radio buttons
	@FindBy(how = How.ID, using = "igUserInteractResponseYes")
	public WebElement		btnSelectYes;

	// This captures No button displayed on 'Select vehicle' and 'Select
	// driver' pop ups that are displayed on selecting the vehicle type and
	// driver type radio buttons
	@FindBy(how = How.ID, using = "igUserInteractResponseNo")
	public WebElement		btnSelectNo;
}
