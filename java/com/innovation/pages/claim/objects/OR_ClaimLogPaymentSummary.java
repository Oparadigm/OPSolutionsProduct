package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Kamal - defining the objects for Summary frame in Claims BO Log Payment flow. 
 */

public class OR_ClaimLogPaymentSummary
{

	@CacheLookup
	@FindBy(how = How.ID, using = "flowFinished")
	public WebElement btnFlowCompleted;
}
