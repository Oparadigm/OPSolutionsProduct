package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs This captures the page elements for the Policy Client Summary screen.
 * 
 */
public class OR_PolicyClientSummary
{
	/**
	 * @param args
	 */

	// Desktop button
	@CacheLookup
	@FindBy(how = How.CSS, using = "a[href*='Desktop']")
	public WebElement btnDesktop;

}
