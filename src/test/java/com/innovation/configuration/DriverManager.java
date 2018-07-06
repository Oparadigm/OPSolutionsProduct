package com.innovation.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.innovation.misc.GetCoverageReport;
import com.innovation.misc.LoggingServer;
import com.innovation.misc.ZAP;

/**
 * @author haiderm
 * @Documentation This class manages all the web driver actions i.e. instantiating, getting, and closing. It holds a pool of driver
 *                objects. It uses a {@link #ThreadLocal} object to instantiate our {@link #<WebDriverThread} objects in separate
 *                threads. It uses the {@link #getDriver()} method on the WebDriverThread object to pass each test a WebDriver
 *                instance it can use.
 * 
 *                We are using this class to start up all our browser instances, we need to make sure that we close them down, as
 *                well. Since starting up a web browser is a computationally intensive task, so we could choose not to close the
 *                browser after every test. This obviously has some side effects. You may not be at the usual entry page of your
 *                application, and you may have some session information that is not wanted. To deal with the session problem,
 *                WebDriver has a command that allows you to clear out your cookies, so we will trigger this after every test i.e.
 *                under @AfterMethod. The @AfterMethod method called {@link #clearCookies()} that will clear down the browser's
 *                cookies after each test. This should reset the browser to a neutral state without closing it so that we can start
 *                another test safely. We then added a @AfterSuite annotation to close the browser once all the tests have finished.
 *                The @AfterSuite annotation holds {@link #closeDriverObjects()} method which iterates through our
 *                {@link #webDriverThreadPool}, closing every threaded instance we are keeping track of. 13.03.2018 - added two more
 *                method to be executed at the start and end of the each test to calculate total test execution time.
 * 
 */

// @Listeners(ScreenshotListener.class)
public class DriverManager
{

	private static List<WebDriverThread>		webDriverThreadPool	= Collections.synchronizedList (new ArrayList<WebDriverThread> ());
	private static ThreadLocal<WebDriverThread>	driverThread;
	private long								start;

	@BeforeSuite
	public static void instantiateDriverObject ()
	{
		driverThread = new ThreadLocal<WebDriverThread> ()
		{
			@Override
			protected WebDriverThread initialValue ()
			{
				WebDriverThread webDriverThread = new WebDriverThread ();
				webDriverThreadPool.add (webDriverThread);
				return webDriverThread;
			}
		};

		// Starts the stand alone Logging Server in order to receive logging requests.
		LoggingServer.main (new String[0]);

		// Opens ZAP, may need to adjust the installation path
		// in ZAPInstallPortFileLocations.xml
		try
		{
			ZAP.OpenZAP ();
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}

	}

	public static WebDriver getDriver (String strBrowser) throws Exception
	{

		WebDriver driver = driverThread.get ().getDriver (strBrowser);

		return driver;

	}

	@BeforeMethod
	public void start ()
	{
		start = System.currentTimeMillis ();
	}

	public static void clearCookies (String strBrowser) throws Exception
	{
		getDriver (strBrowser).manage ().deleteAllCookies ();
	}

	@AfterMethod
	public void end ()
	{
		long timeInMillis = System.currentTimeMillis () - start;
		String humanReadableElapsedTime;
		humanReadableElapsedTime = String.format ("%d minutes, %d seconds", TimeUnit.MILLISECONDS.toSeconds (timeInMillis) / 60,
				TimeUnit.MILLISECONDS.toSeconds (timeInMillis) % 60);

		System.out.println ("Test Execution Time: " + humanReadableElapsedTime);

	}

	// Sets up the endPoint String.
	private static String endPoint = "";

	public static void setEndPoint (String endPointIn)
	{
		endPoint = endPointIn;
	}

	@AfterSuite
	public static void closeDriverObjects ()
	{
		 for (WebDriverThread webDriverThread : webDriverThreadPool)
		 {
		 webDriverThread.quitDriver ();
		 }

		// This calls the ZAP class here you can set the following options:
		// Spider the application - disabled as we will run handle this manually.
		// Active Scan - would start an invasive test to find vulnerabilities - disabled
		// as we will run handle this manually.
		// Write out the ZAP XML Report - the directory is set in the
		// ZAPInstallPortFileLocations.xml
		// Write out the ZAP HTML Report - the directory is set in the
		// ZAPInstallPortFileLocations.xml
		// Close the ZAP Application - may want to comment this out if we want to
		// manually run an active scan after
		// capturing the various flows after running the test suite.
		try
		{
			// ZAP.SpiderTarget (endPoint);
			// ZAP.ActiveScanTarget (endPoint);
			// ZAP.writeXMLReportZAP ();
			ZAP.writeHTMLReportZAP ();
			ZAP.CloseZAP ();
		}
		catch (Exception e1)
		{
			e1.printStackTrace ();
		}

		// Call GetCoverageReport.java to generate the logger xml reports.
		// The amount of data logged can be adjusted accordingly.
		try
		{
			GetCoverageReport.main (new String[0]);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace ();
		}

	}

}
