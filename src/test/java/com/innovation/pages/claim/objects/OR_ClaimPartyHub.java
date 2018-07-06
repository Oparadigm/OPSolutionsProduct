package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Rizwan. This captures the page elements for the Party Hub screen in Home LOBs.
 * 
 */

public class OR_ClaimPartyHub
{

	// This element is used to identify Parties table on Party Hub frame
	@CacheLookup
	@FindBy(how = How.ID, using = "PartiesTable")
	public WebElement	tblPartiesTable;

	// @CacheLookup
	@FindBy(how = How.ID, using = "btnAddClaimant")
	public WebElement	btnAddParty;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnAddWitness")
	public WebElement	btnAddWitness;

	@FindBy(how = How.ID, using = "btnAddEmergService")
	public WebElement	btnAddEmergencyService;

	@CacheLookup
	@FindBy(how = How.ID, using = "igFlowNextBtn")
	public WebElement	btnSaveAndProceed;

	@CacheLookup
	@FindBy(how = How.ID, using = "igFlowPreviousBtn")
	public WebElement	btnNavigateBack;

}
