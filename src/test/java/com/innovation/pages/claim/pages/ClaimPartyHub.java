package com.innovation.pages.claim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.claim.objects.OR_ClaimPartyHub;

/**
 * @author Rizwan. This class stores all the locators and methods in Party Hub page for Home LOBs.
 *
 */

public class ClaimPartyHub
{
	WebDriver			driver;
	OR_ClaimPartyHub	orClaimPartyHub	= null;

	public ClaimPartyHub (WebDriver driver)
	{
		this.driver = driver;
		orClaimPartyHub = PageFactory.initElements (driver, OR_ClaimPartyHub.class);
	}

	// This clicks on the party on Party Hub frame based on the parameter value.
	// Parameter value must match with first and starting word in Sub type value of the respective party on Party Hub frame.
	public void selectParty (String strPartyToSelect)
	{
		WebElement oRow = orClaimPartyHub.tblPartiesTable.findElement (By.xpath ("//tr/td[starts-with(text(), '" + strPartyToSelect + "')]"));
		oRow.click ();
	}

	public void addParty ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPartyHub.btnAddParty));
		orClaimPartyHub.btnAddParty.click ();
	}

	public void addWitness ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPartyHub.btnAddWitness));
		orClaimPartyHub.btnAddWitness.click ();
	}

	public void addEmergencyService ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPartyHub.btnAddEmergencyService));
		orClaimPartyHub.btnAddEmergencyService.click ();
	}

	public void clickSaveAndProceed ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPartyHub.btnSaveAndProceed));
		orClaimPartyHub.btnSaveAndProceed.click ();
	}

	public void navigateBack ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPartyHub.btnNavigateBack));
		orClaimPartyHub.btnNavigateBack.click ();
	}

}
