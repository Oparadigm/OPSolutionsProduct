package com.innovation.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class SeleniumWaiter
{

	private static WebDriver driver;

	public SeleniumWaiter (WebDriver driver)
	{
		SeleniumWaiter.driver = driver;
	}

	public void waitForMe (int timeout)

	{
		WebDriverWait wait = new WebDriverWait (driver, timeout);
		wait.until (SeleniumWaiter.pageloaded ());

	}

	public static Function<WebDriver, Boolean> pageloaded ()
	{
		// This function returns the condition of the page load.
		return new Function<WebDriver, Boolean> ()
		{
			@Override
			public Boolean apply (WebDriver driver)

			{
				String strBrowserID = driver.getWindowHandle ();
				String strBrowserReadyState = String.valueOf (((JavascriptExecutor) driver).executeScript ("return document.readyState"));
				String strCurrentPageTitle = SeleniumPageCoverage.getURl (driver);

				System.out.println (
						"Loading Page: " + strCurrentPageTitle + "..........." + "Page Loaded State: " + strBrowserReadyState + "Browser: " + strBrowserID);
				boolean blnPageLoad = String.valueOf (((JavascriptExecutor) driver).executeScript ("return document.readyState")).equals ("complete");

				if (blnPageLoad == true)
				{
					SeleniumPageCoverage.storeURl (driver);

				}

				else

				{
					// Loop coding wait need!
				}

				return blnPageLoad;
			}
		};
	}

	static List<Class<? extends Throwable>> exceptionsToIgnore = new ArrayList<Class<? extends Throwable>> ()
	{

		{
			add (NoSuchElementException.class);
			add (StaleElementReferenceException.class);
		}
	};

	public static void elementIsLoaded (WebElement passElement)

	{
		Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)

				.withTimeout (15, TimeUnit.SECONDS).pollingEvery (500, TimeUnit.MILLISECONDS).ignoreAll (exceptionsToIgnore)
				.withMessage ("TimeoutException is thrown");

		wait.until (SeleniumWaiter.elementloaded (passElement));

	}

	public static Function<WebDriver, Boolean> elementloaded (WebElement elementToLoad)
	{
		return new Function<WebDriver, Boolean> ()
		{
			@Override
			public Boolean apply (WebDriver driver)
			{

				WebElement element = elementToLoad;
				return element != null && element.isDisplayed ();
			}
		};
	}

	public static ExpectedCondition<Boolean> jQueryAJAXCallsHaveCompleted ()
	{
		return new ExpectedCondition<Boolean> ()
		{

			@Override
			public Boolean apply (WebDriver driver)
			{
				return (Boolean) ((JavascriptExecutor) driver).executeScript ("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};
	}

	public static WebElement isElementLoaded (WebElement elementToBeLoaded)
	{

		WebDriverWait wait = new WebDriverWait (driver, 20, 500);
		WebElement element = wait.until (ExpectedConditions.visibilityOf (elementToBeLoaded));
		return element;
	}

}
