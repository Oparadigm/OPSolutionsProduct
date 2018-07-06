package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author alamq - defining the objects for 'Estimate list' frame accessible through BO Navigation panel > Property damage > Estimate
 *  
 */

public class OR_ClaimEstimateList
{
	// This element is used to click on "Add estimate" button for property LOB
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_AddEstimate_30a")
	public WebElement	btnAddEstimateProperty;
	
	// This element is used to click on "Add estimate" button for auto LOB
	@CacheLookup
	@FindBy(how = How.ID, using = "EstimateAdd")
	public WebElement	btnAddEstimateAuto;	
	
	// This element is used to select row of 'Initial Estimates'
	@FindBy(how = How.ID, using = "CLM_SC_BO_0130_EstimateListTable")
	public WebElement	tblEstimateType;
	
}


