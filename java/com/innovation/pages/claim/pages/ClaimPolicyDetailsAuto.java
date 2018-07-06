package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.RandomNumbers;
import com.innovation.pages.claim.objects.OR_ClaimIncidentDetailsAuto;
import com.innovation.pages.claim.objects.OR_ClaimPolicyDetailsAuto;
import com.innovation.pages.common.objects.OR_ControlPanel;

/**
 * @author Rizwan. This class stores all the locators and methods in Claim's Policy Details frame for Auto LOBs.
 *
 */
public class ClaimPolicyDetailsAuto
{
	WebDriver					driver;
	OR_ControlPanel				orControlPanel				= null;
	OR_ClaimPolicyDetailsAuto	orClaimPolicyDetailsAuto	= null;
	OR_ClaimIncidentDetailsAuto	orClaimIncidentDetailsAuto	= null;

	public ClaimPolicyDetailsAuto (WebDriver driver)
	{
		this.driver = driver;
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
		orClaimPolicyDetailsAuto = PageFactory.initElements (driver, OR_ClaimPolicyDetailsAuto.class);
		orClaimIncidentDetailsAuto = PageFactory.initElements (driver, OR_ClaimIncidentDetailsAuto.class);
	}

	// For the time being, only mandatory fields on Policyholder tab are covered as under

	// Functions on Policyholder tab

	public void typeFirstName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPolicyDetailsAuto.txtFirstName));

		orClaimPolicyDetailsAuto.txtFirstName.click ();
		orClaimPolicyDetailsAuto.txtFirstName.sendKeys (RandomLetters.produceRandomString (6));
	}

	public void typeLastName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPolicyDetailsAuto.txtLastName));

		orClaimPolicyDetailsAuto.txtLastName.click ();
		orClaimPolicyDetailsAuto.txtLastName.sendKeys (RandomLetters.produceRandomString (8));
	}

	public void selectGender ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimPolicyDetailsAuto.ddlGender));

		orClaimPolicyDetailsAuto.ddlGender.click ();
		Select oGender = new Select (orClaimPolicyDetailsAuto.ddlGender);

		// Select a random Gender from the returned list
		List<WebElement> selections = oGender.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oGender.selectByIndex (intIndex);
	}

	// This clicks on Yes button on Event management pop up if the pop up is displayed
	public void clickEventManagementYes ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.or (ExpectedConditions.visibilityOf (orControlPanel.dlgConfirmPopup),
				ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txaIncidentDescription)));

		if (orControlPanel.dlgConfirmPopup.isDisplayed ())
		{
			wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.dlgYes));
			orControlPanel.dlgYes.click ();

			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		}
	}

	// This clicks on No button on Event management pop up if the pop up is displayed
	public void clickEventManagementNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.or (ExpectedConditions.visibilityOf (orControlPanel.dlgConfirmPopup),
				ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txaIncidentDescription)));

		if (orControlPanel.dlgConfirmPopup.isDisplayed ())
		{
			wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.dlgNo));
			orControlPanel.dlgNo.click ();

			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		}
	}

}
