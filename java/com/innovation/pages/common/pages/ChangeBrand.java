package com.innovation.pages.common.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.pages.common.objects.OR_ChangeBrand;

/**
 * @author M.Tahir, this class will select the required scheme for which the sanity has to be executed
 *
 */
public class ChangeBrand
{

	WebDriver		driver;
	LoggingControl	loggingcontrol	= new LoggingControl ();
	OR_ChangeBrand	orChangeBrand	= null;

	public ChangeBrand (WebDriver driver)
	{
		this.driver = driver;
		orChangeBrand = PageFactory.initElements (driver, OR_ChangeBrand.class);
	}

	public void clickChangeBrand ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.textToBePresentInElement (orChangeBrand.lnkChangeBrand, "Change brand"));
		wait.until (ExpectedConditions.elementToBeClickable ((orChangeBrand.lnkChangeBrand)));
		orChangeBrand.lnkChangeBrand.click ();
	}

	public void selectBrand (String strBrand)
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.textToBePresentInElement (orChangeBrand.ddlChangeBrand, strBrand));

		wait.until (ExpectedConditions.elementToBeClickable ((orChangeBrand.ddlChangeBrand)));
		orChangeBrand.ddlChangeBrand.click ();

		Select oSelectBrand = new Select (orChangeBrand.ddlChangeBrand);
		oSelectBrand.selectByVisibleText (strBrand);

		wait.until (ExpectedConditions.elementToBeClickable ((orChangeBrand.ddlChangeBrand)));
		orChangeBrand.ddlChangeBrand.click ();

		String strBrandValue = oSelectBrand.getFirstSelectedOption ().getAttribute ("text");
		System.out.println ("Brand Selected is: " + strBrandValue);
	}

	public void saveBrand ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (SeleniumWaiter.jQueryAJAXCallsHaveCompleted ());

		// Fluent wait added as generic wait starts failing after each couple of days. Will replace with generic wait when a
		// suitable solution found.
		Long intMaxTimeOut = (long) GlobalWaitTime.getIntWaitTime ();
		Wait<WebDriver> fWait = new FluentWait<WebDriver> (driver).withTimeout (intMaxTimeOut, TimeUnit.SECONDS).pollingEvery (1, TimeUnit.SECONDS);

		fWait.until (ExpectedConditions.elementToBeClickable ((orChangeBrand.btnChangeBrand)));
		orChangeBrand.btnChangeBrand.click ();

	}
}
