/**
 * 
 */
package com.innovation.pages.phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.phptravels.objects.OR_PHPTravels;

/**
 * @author M.Tahir Akbar Khan
 *
 */
public class PHPTravels {

	WebDriver driver;
	OR_PHPTravels orPHPTravels = null;

	public PHPTravels(WebDriver driver) {
		this.driver = driver;
		orPHPTravels = PageFactory.initElements(driver, OR_PHPTravels.class);
	}

	public void enterInitialFlightInfo() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.elementToBeClickable(orPHPTravels.lnkFlights));
		orPHPTravels.lnkFlights.click();
		Thread.sleep(1000);
		orPHPTravels.spnEnterCity.click();
		Thread.sleep(1000);
		orPHPTravels.txtCityName.sendKeys("LHE");
		Thread.sleep(1000);
		orPHPTravels.resultCity.click();
		Thread.sleep(1000);
		orPHPTravels.txtLocationTo.click();
		Thread.sleep(1000);
		orPHPTravels.txtCityName.sendKeys("DXB");
		Thread.sleep(1000);
		orPHPTravels.resultCity.click();
		Thread.sleep(1000);
		orPHPTravels.dtpDateOfFlight.click();
		Thread.sleep(1000);
		orPHPTravels.dtpDateOfFlight.sendKeys("2018-07-09");
		Thread.sleep(1000);
		orPHPTravels.btnPickFlight.click();

	}

	public void bookFirstSelectedFlight() throws InterruptedException {

		Thread.sleep(3000);
		orPHPTravels.btnBookFlight.click();
		Thread.sleep(1000);

	}

	public void enterPersonalInformation() throws InterruptedException {

		Thread.sleep(1000);
		orPHPTravels.txtFirstName.sendKeys("optimum");
		orPHPTravels.txtLastName.sendKeys("paradigm");
		orPHPTravels.txtEmail.sendKeys("reachus@optimumparadigm.com");
		orPHPTravels.txtConfirmEmail.sendKeys("reachus@optimumparadigm.com");
		orPHPTravels.txtPhoneNumber.sendKeys("+9233344411111");
		orPHPTravels.txtAddress.sendKeys("House 1, ABC Street, XYZ Lahore");
		orPHPTravels.spnCountry.click();
		orPHPTravels.txtCountryOfOrigin.sendKeys("Pakistan");
		Thread.sleep(1000);
		orPHPTravels.txtSelectedCountry.click();
		orPHPTravels.btnSubmitInformation.click();
		Thread.sleep(3000);

	}

	public void confirmTransaction() throws InterruptedException {
		Thread.sleep(2000);
		orPHPTravels.btnDownloadInvoice.click();
		Thread.sleep(2000);
		orPHPTravels.lnkPHPTravels.click();
		System.out.println("Your Flight Reservation Trasaction is successfull and Complete, Thanks");
	}

}
