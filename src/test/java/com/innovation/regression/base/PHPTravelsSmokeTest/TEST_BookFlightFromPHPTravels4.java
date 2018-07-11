/**
 * 
 */
package com.innovation.regression.base.PHPTravelsSmokeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.innovation.configuration.DriverManager;
import com.innovation.misc.InsurerSetup;
import com.innovation.pages.phptravels.pages.PHPTravels;



public class TEST_BookFlightFromPHPTravels4 extends DriverManager {
	@Parameters({ "strBrowser", "strEnvironmentName" })
	@Test
	public void bookFlightFromPHPTravels(@Optional("CHROME") String strBrowser, @Optional("BaseDevelopment") String strEnvironmentName
			) throws Exception {

		// Variables used in this scenario
//		String strURL = "URL";
//		String strUrlXML = "UrlBrowser.xml";
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
	  	driver.get("https://www.phptravels.net/");
		driver.manage().window().maximize();
		
	 
		
		
//		WebDriver driver = getDriver (strBrowser);
//		InsurerSetup setup = new InsurerSetup (driver);
//		setup.navigateInsurer (strEnvironmentName, strURL, strUrlXML);
//		
		PHPTravels bookfromPHPTravels = new PHPTravels(driver);
		
		bookfromPHPTravels.enterInitialFlightInfo();
		bookfromPHPTravels.bookFirstSelectedFlight();
		bookfromPHPTravels.enterPersonalInformation();
		bookfromPHPTravels.confirmTransaction();
		driver.close();
		
	}

}
