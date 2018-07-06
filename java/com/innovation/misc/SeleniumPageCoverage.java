package com.innovation.misc;

/**
 * @author pinchenj This class handles selenium page coverage.
 */

import java.util.ArrayList;
import java.util.HashSet;

import org.openqa.selenium.WebDriver;

public class SeleniumPageCoverage
{

	static ArrayList<String>	arrUrl	= new ArrayList<String> ();
	static HashSet<String>		hsetUrl	= new HashSet<String> ();
	private static WebDriver	driver;

	public SeleniumPageCoverage (WebDriver driver)

	{
		SeleniumPageCoverage.setDriver (driver);
	}

	public static void storeURl (WebDriver driver)

	{

		String strUrl = getURl (driver);
		arrUrl.add (strUrl);

		// Remove duplicates by moving to a hashset and then moving back into an array.
		hsetUrl.addAll (arrUrl);
		arrUrl.clear ();
		arrUrl.addAll (hsetUrl);

	}

	public static void printPageCoverage ()

	{
		// Print out the page coverage we are using a hardcoded number of pages that Paul Cullum reported was the latest count
		// Nov2017
		int intArrSize = arrUrl.size ();
		double dblPageCoveragePercentage = ((intArrSize * 100) / 669);

		System.out.println ("Selenium Page Coverage : " + dblPageCoveragePercentage + "%");

		// Print out the Selenium Page Coverage.
		for (int counter = 0; counter < arrUrl.size (); counter++)

		{
			// Uncomment to get a unique list of the pages.
			System.out.println (arrUrl.get (counter));
		}

	}

	public static String getURl (WebDriver driver)

	{
		String strUrl = driver.getTitle ();

		// System.out.println(strUrl);

		// System.out.println ("Page Title: " + strUrl);
		return strUrl;
	}

	public static WebDriver getDriver ()
	{
		return driver;
	}

	public static void setDriver (WebDriver driver)
	{
		SeleniumPageCoverage.driver = driver;
	}

}
