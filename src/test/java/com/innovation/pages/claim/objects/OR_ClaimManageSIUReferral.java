package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Rizwan - defining the objects for 'Manage SIU referral/update score' frame accessible through Claims BO Navigation panel > SIU menu. 
 *  
 */

public class OR_ClaimManageSIUReferral
{

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0016_FraudSummary")
	public WebElement	tblSIUSummary;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='CLM_SC_BO_0016_FraudSummary']/tbody/tr")
	public List<WebElement>	tblSIUSummaryRows;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0151_SIUSelected")
	public WebElement	tblSIUReferralDetails;

	//@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0016_RemovalReason")
	public WebElement	ddlOverrideReason;

	//@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0016_Additional_Information")
	public WebElement	txaAdditionalInfo;

	//@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0151_RemoveButton")
	public WebElement	btnRemoveReason;
	

}
