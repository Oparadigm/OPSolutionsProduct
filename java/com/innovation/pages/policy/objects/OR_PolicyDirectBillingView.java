package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Qasim This captures the page elements for the Direct Billing View --> Current Summary Screen.
 *
 */
public class OR_PolicyDirectBillingView
{

	@FindBy(how = How.XPATH, using = "//*[@id=\"igLegend30a\"]/table/tbody/tr/td[1]/table[3]/tbody/tr/td[2]/label")
	public WebElement lblCarryForwardAmount;

}
