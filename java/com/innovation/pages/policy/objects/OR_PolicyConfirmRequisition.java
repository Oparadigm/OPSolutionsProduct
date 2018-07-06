package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Qasim - This captures the page elements for the Requisition Details screen.
 * 
 */
public class OR_PolicyConfirmRequisition
{

	@FindBy(how = How.XPATH, using = "//*[@id='igLegend10a']/table[1]/tbody/tr/td[1]/table[1]/tbody/tr/td[2]/label")
	public WebElement txtAPRequisitionNumber;

}
