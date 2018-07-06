package com.innovation.misc;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.core.config.plugins.util.PluginManager;
import org.openqa.selenium.WebDriver;

public class TransactionTimer
{
	public static void start (StopWatch pageLoad)
	{
		// This function resets the system time and then starts it.
		pageLoad.reset ();
		pageLoad.start ();
	}

	public static void stop (StopWatch pageLoad, String ScreenName, WebDriver driver, String environment)
	{
		// This method calculates the page load time.
		pageLoad.stop ();

		String strBrowserID = driver.getWindowHandle ();

		// Calculate the Page load time
		double pageLoadTime = pageLoad.getTime ();
		double pageLoadTimeInSeconds = pageLoadTime / 1000.0;
		// Rounds the double down
		// long pageLoadTimeInSecondsLong = (long) pageLoadTimeInSeconds;
		// Rounds the double up
		long pageLoadTimeInSecondsLong = Math.round (pageLoadTimeInSeconds);
		System.out.println ("The " + ScreenName + " Total Page Load Time is: " + pageLoadTimeInSecondsLong + " Seconds " + strBrowserID);

		// Calculate the Page load time
		// long pageLoadTime = pageLoad.getTime();
		// System.out.println("The " + ScreenName + " Total Page Load Time is: " +
		// pageLoadTime + " milliseconds"
		// + "Browser: " + strBrowserID);

		// String token = Long.toHexString (System.currentTimeMillis ());
		// name of the package with the new appender
		String pckage = "com.innovation.misc";

		// load the appender before the first call to log4j
		// this looks for the @Plugin Annotation
		PluginManager.addPackage (pckage);

		// The marker is used to group logging output into different files.
		// Sets the marker to the environment and browserID e.g. - log_Odin_CDwindow-BF271119B504DBA1A945BE2A0A4702D.log
		// Commented this out 06 April 2018 to reduce the volume of files created. Essentially has the same information
		// as the ScreenResponseTimes logs.
		// Marker marker = new Log4jMarker (environment + "_" + strBrowserID);
		// Logger logger = LogManager.getLogger (LoggingControl.class);
		// logger.debug (marker, ScreenName + " load time = " + pageLoadTime);

		// LoggingClient.sendEntry (strBrowserID, ScreenName, pageLoadTimeInSecondsLong);
		LoggingClient.sendEntry (environment, ScreenName, pageLoadTimeInSecondsLong);
	}
}
