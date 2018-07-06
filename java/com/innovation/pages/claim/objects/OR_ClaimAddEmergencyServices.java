package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author alamq. This captures the page elements for Claims Add emergency services page. screen in Home/Auto LOBs.
 * 
 */


public class OR_ClaimAddEmergencyServices
{


	@FindBy(how = How.XPATH, using = "//button[.='Supplier search']")
	public WebElement	btnSupplierSearch;
}
