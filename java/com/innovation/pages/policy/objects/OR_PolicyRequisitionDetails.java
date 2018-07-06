package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Qasim - This captures the page elements for the Requisition Details screen.
 * 
 */
public class OR_PolicyRequisitionDetails
{

	@CacheLookup
	@FindBy(how = How.ID, using = "refundAmount_0")
	public WebElement txtRefundAmount;

}
