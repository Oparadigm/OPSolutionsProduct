package com.innovation.pages.common.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.pages.common.objects.OR_PreviousSessionWorkItems;

/**
 * @author lushs - This class will store all the locators and methods of the Previous session work items page.
 */

public class PreviousSessionWorkItems
{
	private WebDriver					driver;

	By									RadioSearchType				= By.id ("SearchType");
	private LoggingControl				loggingcontrol				= new LoggingControl ();
	private OR_PreviousSessionWorkItems	orPreviousSessionWorkItems	= null;

	public PreviousSessionWorkItems (WebDriver driver)
	{
		this.driver = driver;
		orPreviousSessionWorkItems = PageFactory.initElements (driver, OR_PreviousSessionWorkItems.class);
	}

	public void clickRestoreAllAndApply ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		if (!driver.findElements (By.xpath ("(//*[@id='btnSubmitActions'])[1]")).isEmpty ())
		{
			orPreviousSessionWorkItems.btnRestoreAll.click ();
			// This will wait for up to 3 seconds for the Apply button to become
			// available.
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orPreviousSessionWorkItems.btnApply));
			orPreviousSessionWorkItems.btnApply.click ();
		}
		else
		{
			System.out.println ("No Previous Session Work Items");
		}

	}

}
