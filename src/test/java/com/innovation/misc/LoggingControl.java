/**
 * 
 */
package com.innovation.misc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager.Log4jMarker;
import org.apache.logging.log4j.core.config.plugins.util.PluginManager;
import org.openqa.selenium.WebDriver;

import com.innovation.data.XMLDataReader;

/**
 * @author Tobi Kaesser - Class loads a new logging mechanism and creates the main log_.log file without the window handle.
 *
 */
public class LoggingControl
{
	String	strElement		= "Debug";
	String	strNode			= "DebugMode";
	String	strXMLFileName	= "DebugMode.XML";

	public void ConsoleLogger (String strMethodName, WebDriver driver)
	{

		XMLDataReader returnXMLString = new XMLDataReader ();
		int intDebug = (returnXMLString.ReturnXMLNodeInt (strElement, strNode, strXMLFileName));

		if (intDebug == 1)
		{
			String strBrowserID = driver.getWindowHandle ();
			System.out.println ("StartingMethod: " + strMethodName + "					" + "Browser: " + strBrowserID);

			// name of the package with the new appender
			String pckage = "com.innovation.misc";

			// load the appender before the first call to log4j
			// this looks for the @Plugin Annotation
			PluginManager.addPackage (pckage);

			Marker marker1 = new Log4jMarker (strBrowserID);
			Logger logger = LogManager.getLogger (LoggingControl.class);
			// logger.debug (marker1, strMethodName);
			logger.debug (strMethodName);

		}

	}
}
