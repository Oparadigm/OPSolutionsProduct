package com.innovation.configuration;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

/**
 * @author haiderm
 * @Documentation This class holds methods to instantiate browser and incorporate with the DriverFactory.java class to marshal
 *                threads.
 * @Variables {@link #webdriver} - holds the object of Selenium WebDriver class
 * @Methods The {@link #instantiateWebDriver()} to hold a reference to a WebDriver object, and ensures that every time you call
 *          {@link #instantiateWebDriver()} you get a valid instance of WebDriver back with the specified browser in the test. If
 *          one has been started up, you will get the existing one. If one hasn't been started up, it will start one for you. The
 *          {@link #getDriver()} method uses {@link #instantiateWebDriver()} to set up and return a valid WebDriver instance.
 * 
 *          The {@link #quitDriver()} method will perform a quit() on your WebDriver object. It also nullifies the WebDriver object
 *          held in the class.
 * 
 */
public class WebDriverThread
{

	private WebDriver webdriver;

	public WebDriver getDriver (String strBrowser) throws Exception
	{
		if (null == webdriver)
		{
			instantiateWebDriver (strBrowser);

		}

		return webdriver;
	}

	public void quitDriver ()
	{
		if (null != webdriver)
		{
			webdriver.quit ();
		}
	}

	private void instantiateWebDriver (String strBrowser) throws MalformedURLException
	{
		switch (strBrowser.toUpperCase ())
		{
			case "CHROME_HEADLESS":
			{
				File inputFile = new File (getClass ().getClassLoader ().getResource ("webdrivers/chromedriver.exe").getFile ());
				System.setProperty ("webdriver.chrome.driver", inputFile.getAbsolutePath ());
				ChromeOptions options = new ChromeOptions ();
				String zapProxy = "localhost:8888";
				options.addArguments ("--headless", "window-size=1936, 1056");
				options.addArguments ("--disable-gpu");
				options.setCapability (CapabilityType.PROXY, new Proxy ().setHttpProxy (zapProxy));
				webdriver = new ChromeDriver (options);
				break;
			}

			case "CHROME_ZAP":
			{
				File inputFile = new File (getClass ().getClassLoader ().getResource ("webdrivers/chromedriver.exe").getFile ());
				System.setProperty ("webdriver.chrome.driver", inputFile.getAbsolutePath ());
				ChromeOptions options = new ChromeOptions ();
				String zapProxy = "localhost:8888";
				options.addArguments ("--incognito");
				options.addArguments ("--start-maximized");
				options.setCapability ("chrome.switches", Arrays.asList ("--no-default-browser-check"));
				options.setCapability (CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				HashMap<String, String> chromePreferences = new HashMap<String, String> ();
				chromePreferences.put ("profile.password_manager_enabled", "false");
				options.setCapability ("chrome.prefs", chromePreferences);
				options.addArguments ("disable-infobars");
				options.setCapability (CapabilityType.PROXY, new Proxy ().setHttpProxy (zapProxy));
				webdriver = new ChromeDriver (options);
				break;
			}

			case "FIREFOX":
			{
				File inputFile = new File (getClass ().getClassLoader ().getResource ("webdrivers/geckodriver.exe").getFile ());
				System.setProperty ("webdriver.gecko.driver", inputFile.getAbsolutePath ());
				FirefoxOptions options = new FirefoxOptions ();
				options.addArguments ("--incognito");
				options.addArguments ("--start-maximized");
				options.addArguments ("disable-infobars");
				webdriver = new FirefoxDriver (options);
				break;
			}

			case "FIREFOX_ZAP":
			{
				File inputFile = new File (getClass ().getClassLoader ().getResource ("webdrivers/geckodriver.exe").getFile ());
				System.setProperty ("webdriver.gecko.driver", inputFile.getAbsolutePath ());
				FirefoxOptions options = new FirefoxOptions ();
				String zapProxy = "localhost:8888";
				options.setCapability (CapabilityType.PROXY, new Proxy ().setHttpProxy (zapProxy));
				options.addArguments ("--incognito");
				options.addArguments ("--start-maximized");
				options.addArguments ("disable-infobars");
				webdriver = new FirefoxDriver (options);
				break;
			}

			case "EDGE":
			{
				/**
				 * Microsft Edge driver needs to be manually placed in below location since this driver is machine specific i.e. it
				 * is based on Windows 10 Build version. For more details visit
				 * https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
				 */

				File inputFile = new File ("C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
				System.setProperty ("webdriver.edge.driver", inputFile.getAbsolutePath ());
				EdgeOptions options = new EdgeOptions ();
				webdriver = new EdgeDriver (options);
				break;
			}

			case "IE":
			{
				File inputFile = new File (getClass ().getClassLoader ().getResource ("webdrivers/IEDriverServer.exe").getFile ());
				System.setProperty ("webdriver.ie.driver", inputFile.getAbsolutePath ());
				InternetExplorerOptions options = new InternetExplorerOptions ();
				webdriver = new InternetExplorerDriver (options);
				break;
			}

			// Fall over case: When Chrome or Unknown / No driver specified, default to
			// Chrome
			default:
			case "CHROME":
			{
				File inputFile = new File (getClass ().getClassLoader ().getResource ("webdrivers/chromedriver.exe").getFile ());
				System.setProperty ("webdriver.chrome.driver", inputFile.getAbsolutePath ());
				ChromeOptions options = new ChromeOptions ();
				options.addArguments ("--incognito");
				options.addArguments ("--start-maximized");
				options.setCapability ("chrome.switches", Arrays.asList ("--no-default-browser-check"));
				options.setCapability (CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				HashMap<String, String> chromePreferences = new HashMap<String, String> ();
				chromePreferences.put ("profile.password_manager_enabled", "false");
				options.setCapability ("chrome.prefs", chromePreferences);
				options.addArguments ("disable-infobars");
				webdriver = new ChromeDriver (options);
				break;
			}

		}

	}

}
