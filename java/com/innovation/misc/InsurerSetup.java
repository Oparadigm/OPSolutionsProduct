package com.innovation.misc;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.innovation.configuration.DriverManager;
import com.innovation.data.XMLDataReader;

/**
 * @author haiderm - This class contains method to navigate to insurer application via reading urlBrowser.xml file.
 * 
 */
public class InsurerSetup extends DriverManager
{

	private WebDriver driver;

	public InsurerSetup (WebDriver driver) throws Exception
	{

		this.driver = driver;
	}

	public void navigateInsurer (String strElement, String strNodeURL, String strXMLFileName) throws Exception

	{
		try
		{

			XMLDataReader returnXMLString = new XMLDataReader ();
			System.out.println ("The selected Enviornment is: " + strElement);
			// System.out.println ("Browser to be used: " + strNodeBrowser);
			// System.out.println ("Environment URL: " + strNodeURL);
			driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
			driver.get (returnXMLString.ReturnXMLNode (strElement, strNodeURL, strXMLFileName));
			driver.manage ().window ().maximize ();
			Dimension iWindowSize1 = driver.manage ().window ().getSize ();
			System.out.println ("The window size after maximising the browser is : " + iWindowSize1);
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getShortWaitTime ());
			wait.until (ExpectedConditions.alertIsPresent ());
			Alert alert = driver.switchTo ().alert ();
			alert.accept ();
		}
		catch (Exception ignore)
		{
			// Ignore the Exception - Need to revisit this area once Exception Handling will be done in TestFramework
		}

	}

}
