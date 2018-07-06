package com.innovation.pages.common.pages;

import java.util.function.Consumer;

import org.openqa.selenium.Alert;

/**
 * @author lushs
 * This class will store all the locators and methods of the Home page.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.pages.common.objects.OR_HomeScreen;

public class HomeScreen
{
	LoggingControl	loggingcontrol	= new LoggingControl ();
	WebDriver		driver;
	public Actions	action;
	OR_HomeScreen	orHomeScreen	= null;

	// A Consumer lambda function which accepts �By� as the parameter.
	Consumer<By>	hover			= (By by) -> {
										// Move the mouse to the middle of the element
										action.moveToElement (driver.findElement (by)).perform ();
									};

	public HomeScreen (WebDriver driver)
	{
		this.driver = driver;
		action = new Actions (driver);
		orHomeScreen = PageFactory.initElements (driver, OR_HomeScreen.class);
	}

	public void clickOnActivity ()
	{
		try
		{
			System.out.println ("Clicking on Activity Button");
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orHomeScreen.btnActivity));
			orHomeScreen.btnActivity.click ();
		}
		catch (Exception e)
		{
			System.out.println ("Error Clicking on Activity was it visible?");
		}
	}

	public void clickOnSearch ()
	{
		try
		{
			System.out.println ("Clicking on search");
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orHomeScreen.btnSearch));
			orHomeScreen.btnSearch.click ();
		}
		catch (Exception e)
		{
			System.out.println ("Error Clicking on search was it visible?");
		}
	}

	public void clickOnHibernateSearch ()
	{
		try
		{
			System.out.println ("Clicking on Hibernate Search");
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orHomeScreen.btnHibernateSearch));
			orHomeScreen.btnHibernateSearch.click ();
		}
		catch (Exception e)
		{
			System.out.println ("Error Clicking on Hibernate Search was it visible?");
		}
	}

	public void clickOnClaimSearch ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		try
		{
			System.out.println ("Clicking on Claim Search Button Menu Item");
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orHomeScreen.btnClaimSearch));
			orHomeScreen.btnClaimSearch.click ();
		}
		catch (Exception e)
		{
			System.out.println ("Error Clicking on Claim Search was it visible?");
		}

		// hover.accept(By.linkText("Search"));
		// hover.accept(By.linkText("Claim search"));
		// orHomeScreen.btnClaimSearch.click();
	}

	public void clickOnPolicySearch ()
	{
		try
		{
			System.out.println ("Clicking on Policy Search Button Menu Item");
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orHomeScreen.btnPolicySearch));
			orHomeScreen.btnPolicySearch.click ();
		}
		catch (Exception e)
		{
			System.out.println ("Error Clicking on Policy Search was it visible?");
		}
		// hover.accept(By.linkText("Search"));
		// hover.accept(By.linkText("Policy search"));
		// orHomeScreen.btnPolicySearch.click();
	}

	public void clickOnPolicyClientSearch ()
	{
		try
		{
			System.out.println ("Clicking on Policy Client Search Button Menu Item");
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orHomeScreen.btnPolicyClientSearch));
			orHomeScreen.btnPolicyClientSearch.click ();
		}
		catch (Exception e)
		{
			System.out.println ("Error Clicking on Policy Client Search was it visible?");
		}
		// hover.accept (By.linkText ("Search"));
		// hover.accept (By.linkText ("Policy client search"));
		// orHomeScreen.btnPolicyClientSearch.click ();
	}

	public void clickOnDesktop ()
	{
		// This will wait for up to 10 seconds for the Desktop button to become
		// available.
		System.out.println ("The Desktop is about to be clicked " + System.currentTimeMillis ());

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orHomeScreen.btnDesktop));
		orHomeScreen.btnDesktop.click ();
		System.out.println ("The Desktop has been clicked " + System.currentTimeMillis ());

	}

	public void typeQuickSearch (String strClaimOrPolicyNumber)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orHomeScreen.txtQuickSearch));
		orHomeScreen.txtQuickSearch.click ();
		orHomeScreen.txtQuickSearch.sendKeys (strClaimOrPolicyNumber);

	}

	public void clickQuickSearch ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orHomeScreen.imgSearch));
		orHomeScreen.imgSearch.click ();

	}

	public void clickSignOut ()
	{

		// This will wait for up to 10 seconds for the Sign Out button to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		// wait.until (ExpectedConditions.invisibilityOf (orHomeScreen.prgProgress));
		wait.until (ExpectedConditions.visibilityOf (orHomeScreen.btnSignOut));

		orHomeScreen.btnSignOut.click ();
		try
		{
			// Long timeOut = 8L;
			WebDriverWait waitAlert = new WebDriverWait (driver, 5);
			if (waitAlert.until (ExpectedConditions.alertIsPresent ()) != null)
			{

				Alert alert = driver.switchTo ().alert ();
				alert.accept ();
			}
		}
		catch (Exception e)
		{
			// exception handling
		}

	}
}
