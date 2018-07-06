package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Rizwan - defining the objects for 'SIU Spotlight' frame accessible through Claims BO Navigation panel > SIU menu. 
 *  
 */

public class OR_ClaimSIUSpotlight
{

	@CacheLookup
	@FindBy(how = How.ID, using = "tblReferrals")
	public WebElement	tblReferrals;

	//@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0152_ReferralStatus")
	public WebElement	ddlReferralStatus;

	//@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0152_Reason")
	public WebElement	txtReason;

	//@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0151_RemoveButton")
	public WebElement	btnRemoveReason;
	

}
