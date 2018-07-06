package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimVehicleDriver;
import com.innovation.pages.common.objects.OR_ControlPanel;

/**
 * @author Rizwan. This class stores all the locators and methods in Claim's FNOL Vehicle/driver screen for Auto LOB.
 *
 */
public class ClaimVehicleDriver
{
	WebDriver				driver;
	OR_ClaimVehicleDriver	orClaimVehicleDriver	= null;
	OR_ControlPanel			orControlPanel			= null;

	public ClaimVehicleDriver (WebDriver driver)
	{
		this.driver = driver;
		orClaimVehicleDriver = PageFactory.initElements (driver, OR_ClaimVehicleDriver.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	// This selects Radio button Vehicle Other
	public void selectVehicleOther ()
	{
		List<WebElement> radiobuttons = orClaimVehicleDriver.rdoVehicleOther;
		for (WebElement radiobutton : radiobuttons)
		{
			if (radiobutton.getAttribute ("value").equals ("Other"))
			{
				radiobutton.click ();
				break;
			}
		}
	}

	// Selects a random record from the listed vehicles table
	public void selectRandomVehicleRecord ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		SeleniumWaiter.elementIsLoaded (orClaimVehicleDriver.tblListedVehicles);
		wait.until (ExpectedConditions.elementToBeClickable (orClaimVehicleDriver.tblListedVehicles));
		// Calling function from TableHandler misc class to click on a random
		// row in the table based on table id parameters
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.clickRandomTableRow ("CLM_SC_016_SelectVehicle");

		// This waits until the progress bar goes invisible
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// This selects one of the driver type radio buttons based on parameter.
	// Pass values 'Other', 'Unknown' or 'No driver' to select respective radio
	// button
	public void selectDriverType (String strDriverType)
	{
		if (strDriverType.equalsIgnoreCase ("Other"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDriver.rdoDriverType;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("Other"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strDriverType.equalsIgnoreCase ("Unknown"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDriver.rdoDriverType;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("Unknown"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strDriverType.equalsIgnoreCase ("No driver"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDriver.rdoDriverType;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("NoDriver"))
				{
					radiobutton.click ();
					break;
				}
			}
		}

		// This waits until the progress bar goes invisible
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Selects a random record from the listed drivers table
	public void selectRandomDriverRecord ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimVehicleDriver.tblListedDrivers));

		// Calling function from TableHandler misc class to click on a random
		// row in the table based on table id parameters
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.clickRandomTableRow ("CLM_SC_015_SelectDriver");

		// This waits until the progress bar goes invisible
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// This clicks on Yes button on 'Vehicle select' or 'Driver select' pop ups
	// that are displayed on selecting the vehicle type and driver type radio
	// buttons
	public void clickPopupYes ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimVehicleDriver.btnSelectYes));

		orClaimVehicleDriver.btnSelectYes.click ();

		// This waits until the progress bar goes invisible
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// This clicks on No button on 'Vehicle select' or 'Driver select' pop ups
	public void clickPopupNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimVehicleDriver.btnSelectNo));

		orClaimVehicleDriver.btnSelectNo.click ();
	}

}
