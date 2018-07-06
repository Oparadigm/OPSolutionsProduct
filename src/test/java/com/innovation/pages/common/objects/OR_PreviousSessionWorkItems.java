/**
 * 
 */
package com.innovation.pages.common.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs - This captures the page elements for the Previous Session Work Items screen.
 *
 */
public class OR_PreviousSessionWorkItems
{

	// Restore all button
	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//*[@id='btnSubmitActions'])[1]")
	public WebElement	btnRestoreAll;

	// Apply button
	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//*[@id='btnSubmitActions'])[3]")
	public WebElement	btnApply;

	// Clear all button
	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//*[@id='btnSubmitActions'])[2]")
	public WebElement	btnClearAll;
	
}
