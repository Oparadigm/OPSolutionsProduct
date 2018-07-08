/**
 * 
 */
package com.innovation.regression.base.PHPTravelsSmokeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.innovation.configuration.DriverManager;
import com.innovation.pages.phptravels.pages.PHPTravels;

/**
 * @author M.Tahir PHP Smoke Test - OptimumParadigm
 *
 */

public class TEST_BookFlightFromPHPTravels extends DriverManager {

	@Test
	public void bookFlightFromPHPTravels() throws Exception {

		// Variables used in this scenario

		System.setProperty("webdriver.chrome.driver",
				"D:\\Mobile App Testing Project\\Selenium Libraries\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/");
		driver.manage().window().maximize();

		PHPTravels bookfromPHPTravels = new PHPTravels(driver);

		bookfromPHPTravels.enterInitialFlightInfo();
		bookfromPHPTravels.bookFirstSelectedFlight();
		bookfromPHPTravels.enterPersonalInformation();
		bookfromPHPTravels.confirmTransaction();
		driver.close();
		
	}

}
