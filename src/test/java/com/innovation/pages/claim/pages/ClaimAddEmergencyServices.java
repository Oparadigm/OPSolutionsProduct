package com.innovation.pages.claim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.claim.objects.OR_ClaimAddEmergencyServices;
import com.innovation.pages.common.objects.OR_ControlPanel;

/**
 * @author alamq. This class stores all the locators and methods in Add Emergency services page.
 *
 */
public class ClaimAddEmergencyServices
{
	WebDriver						driver;
	OR_ClaimAddEmergencyServices	orClaimAddEmergencyServices	= null;
	OR_ControlPanel					orControlPanel				= null;

	public ClaimAddEmergencyServices (WebDriver driver)
	{
		this.driver = driver;
		orClaimAddEmergencyServices = PageFactory.initElements (driver, OR_ClaimAddEmergencyServices.class);
	}

	public void clickSupplierSearch ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddEmergencyServices.btnSupplierSearch));
		orClaimAddEmergencyServices.btnSupplierSearch.click ();

	}

}
