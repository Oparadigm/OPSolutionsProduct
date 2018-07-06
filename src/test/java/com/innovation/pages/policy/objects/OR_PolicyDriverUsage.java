package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Kamran Mahmood This will captures the page elements for the AutoDriverUsage Screen.
 *
 */
public class OR_PolicyDriverUsage
{

	// @CacheLookup
	@FindBy(how = How.ID, using = "Drivtype~1_1")
	public WebElement ddlDriverType;

}
