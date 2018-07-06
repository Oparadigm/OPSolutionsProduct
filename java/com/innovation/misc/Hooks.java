package com.innovation.misc;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import com.innovation.data.XMLDataReader;

public class Hooks
{
	public static WebDriver driver;

	public WebDriver OpenBrowser (String strElement, String strNodeBrowser, String strNodeURL, String strXMLFileName)

	{
		XMLDataReader returnXMLString = new XMLDataReader ();
		System.out.println ("Environment: " + strElement);
		// System.out.println ("Browser to be used: " + strNodeBrowser);
		// System.out.println ("Environment URL: " + strNodeURL);

		String strBrowser = (returnXMLString.ReturnXMLNode (strElement, strNodeBrowser, strXMLFileName));
		// String strBrowser = (returnXMLString.ReturnXMLNode ("Environment1", "Browser", "UrlBrowser.xml"));

		switch (strBrowser.toUpperCase ())
		{
			case "FIREFOX":
			{

				File inputFile = new File (getClass ().getClassLoader ().getResource ("webdrivers/geckodriver.exe").getFile ());
				System.setProperty ("webdriver.gecko.driver", inputFile.getAbsolutePath ());
				WebDriver driver = new FirefoxDriver ();

				driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS); // global timeout value
				driver.get (returnXMLString.ReturnXMLNode (strElement, strNodeURL, strXMLFileName));
				driver.manage ().window ().maximize ();
				return driver;
			}

			case "FIREFOX_ZAP":
			{
				File inputFile = new File (getClass ().getClassLoader ().getResource ("webdrivers/geckodriver.exe").getFile ());
				System.setProperty ("webdriver.gecko.driver", inputFile.getAbsolutePath ());

				String zapProxy = "localhost:8888";
				FirefoxOptions firefoxoptions = new FirefoxOptions ();
				firefoxoptions.setCapability (CapabilityType.PROXY, new Proxy ().setHttpProxy (zapProxy));
				WebDriver driver = new FirefoxDriver (firefoxoptions);

				driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS); // global timeout value
				driver.get (returnXMLString.ReturnXMLNode (strElement, strNodeURL, strXMLFileName));
				driver.manage ().window ().maximize ();
				return driver;
			}

			case "CHROME":
			{
				File inputFile = new File (getClass ().getClassLoader ().getResource ("webdrivers/chromedriver.exe").getFile ());
				System.setProperty ("webdriver.chrome.driver", inputFile.getAbsolutePath ());
				// @SuppressWarnings("unused") //driver is warning as it unused in parts of the switch
				WebDriver driver = new ChromeDriver ();
				driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS); // global timeout value
				driver.get (returnXMLString.ReturnXMLNode (strElement, strNodeURL, strXMLFileName));
				driver.manage ().window ().maximize ();
				Dimension iWindowSize1 = driver.manage ().window ().getSize ();
				System.out.println ("The window size after maximising the browser is : " + iWindowSize1);
				return driver;
			}

			case "CHROME_ZAP":
			{
				File inputFile = new File (getClass ().getClassLoader ().getResource ("webdrivers/chromedriver.exe").getFile ());
				System.setProperty ("webdriver.chrome.driver", inputFile.getAbsolutePath ());
				// @SuppressWarnings("unused") //driver is warning as it unused in parts of the switch

				String zapProxy = "localhost:8888";
				ChromeOptions chromeoptions = new ChromeOptions ();
				chromeoptions.setCapability (CapabilityType.PROXY, new Proxy ().setHttpProxy (zapProxy));
				WebDriver driver = new ChromeDriver (chromeoptions);

				driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS); // global timeout value
				driver.get (returnXMLString.ReturnXMLNode (strElement, strNodeURL, strXMLFileName));
				driver.manage ().window ().maximize ();
				Dimension iWindowSize1 = driver.manage ().window ().getSize ();
				System.out.println ("The window size after maximising the browser is : " + iWindowSize1);
				return driver;
			}

			case "CHROME_HEADLESS":
			{
				ChromeOptions chromeOptions = new ChromeOptions ();
				File inputFile = new File (getClass ().getClassLoader ().getResource ("webdrivers/chromedriver.exe").getFile ());
				System.setProperty ("webdriver.chrome.driver", inputFile.getAbsolutePath ());
				chromeOptions.addArguments ("--headless");
				chromeOptions.addArguments ("--disable-gpu");
				WebDriver driver = new ChromeDriver (chromeOptions);

				// File inputFile = new File (getClass ().getClassLoader ().getResource ("chromedriver.exe").getFile ());
				// System.setProperty ("webdriver.chrome.driver", inputFile.getAbsolutePath ());
				// //@SuppressWarnings("unused") //driver is warning as it unused in parts of the switch
				// WebDriver driver = new ChromeDriver ();
				driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS); // global timeout value
				driver.get (returnXMLString.ReturnXMLNode (strElement, strNodeURL, strXMLFileName));

				Dimension iWindowSize1 = driver.manage ().window ().getSize ();
				System.out.println ("The window size before maximising the browser is : " + iWindowSize1);

				driver.manage ().window ().maximize ();

				Dimension iWindowSize2 = driver.manage ().window ().getSize ();
				System.out.println ("The window size after maximising the browser is : " + iWindowSize2);
				driver.manage ().window ().setSize (new Dimension (1936, 1056));

				Dimension iWindowSize3 = driver.manage ().window ().getSize ();
				System.out.println ("The window size after setting the window size in code is : " + iWindowSize3);

				return driver;
			}

			case "IE":
			{
				File inputFile = new File (getClass ().getClassLoader ().getResource ("webdrivers/IEDriverServer.exe").getFile ());
				System.setProperty ("webdriver.ie.driver", inputFile.getAbsolutePath ());
				// @SuppressWarnings("unused") //driver is warning as it unused in parts of the switch
				WebDriver driver = new InternetExplorerDriver ();
				driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS); // global timeout value
				driver.get (returnXMLString.ReturnXMLNode (strElement, strNodeURL, strXMLFileName));
				driver.manage ().window ().maximize ();
				return driver;
			}
		}

		return driver;
	}

	public static WebDriver selectDriver ()
	{

		return driver;
	}

}
