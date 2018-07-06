package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Kamal - defining the objects for Party frame in Claims BO Log Payment flow. 
 */

public class OR_ClaimLogPaymentParty
{

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0108_Claimants_40a")
	public WebElement ddlSelectParty;

}
