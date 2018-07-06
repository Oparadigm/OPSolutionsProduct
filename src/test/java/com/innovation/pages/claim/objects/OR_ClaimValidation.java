package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Kamal - defining the objects for Validation frame accessible through Claims BO Navigation panel > Functions menu. 
 *  
 */

public class OR_ClaimValidation
{

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0034_ValidationExceptions")
	public WebElement	tblValidationExceptions;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0034_Reason_20a")
	public WebElement	ddlResolutionReason;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0034_Resolution_20a")
	public WebElement	btnUpdateResolutionReason;

}
