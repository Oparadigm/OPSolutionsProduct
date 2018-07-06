package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Kamal - defining the objects for Address frame in Claims BO Log Payment flow.  
 */

public class OR_ClaimLogPaymentAddress
{

	@CacheLookup
	@FindBy(how = How.ID, using = "tblPayeeList")
	public WebElement	tblPartyForAddress;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO__AddressList")
	public WebElement	tblPartyAddress;

}
