/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.GlobalWaitTime;

import com.innovation.pages.policy.objects.OR_PolicyAmendmentInitiation;

/**
 * @author Tahir - This class stores all the locators and methods of the Policy
 *         summary screen
 */

public class PolicyAmendmentInitiation {

	WebDriver driver;
	OR_PolicyAmendmentInitiation orPolicyAmendmentInitiation = null;

	public PolicyAmendmentInitiation(WebDriver driver) {
		this.driver = driver;
		orPolicyAmendmentInitiation = PageFactory.initElements(driver, OR_PolicyAmendmentInitiation.class);
	}

	public void selectAmendmentInitiationDate(String strLocation, int intDays, int intMonths, int intYears) {
		WebDriverWait wait = new WebDriverWait(driver, GlobalWaitTime.getIntWaitTime());
		wait.until(ExpectedConditions.invisibilityOf(orPolicyAmendmentInitiation.Progressbar));

		wait.until(ExpectedConditions.elementToBeClickable(orPolicyAmendmentInitiation.dtpAmendDate));
		orPolicyAmendmentInitiation.dtpAmendDate.click();
		orPolicyAmendmentInitiation.dtpAmendDate
				.sendKeys(CalenderDate.returnDesiredDate(strLocation, intDays, intMonths, intYears));
	}

}
