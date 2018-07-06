package com.innovation.pages.claim.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.claim.objects.OR_ClaimLogPaymentPayee;

/*@author  Kamal - this class stores all the locators and methods on Payee frame in Claims BO Log Payment flow. 
 * 
 */

public class ClaimLogPaymentPayee
{
	WebDriver				driver;
	OR_ClaimLogPaymentPayee	orClaimLogPaymentPayee	= null;

	public ClaimLogPaymentPayee (WebDriver driver)
	{
		this.driver = driver;
		orClaimLogPaymentPayee = PageFactory.initElements (driver, OR_ClaimLogPaymentPayee.class);
	}

	// Pass any cell's value from the row that is to be selected as a Payee

	public void selectPayee (String strRowText)
	{
		// Get number of rows in the table
		int Row_count = orClaimLogPaymentPayee.tblPayeeRows.size ();
		// Get number of visible columns in the table
		long Col_count = orClaimLogPaymentPayee.tblPayeeColumns.stream ().filter (WebElement::isDisplayed).count ();
		// divided xpath In three parts to pass Row_count and Col_count values.
		String strFirst_part = "//*[@id='CLM_SC_BO__Payee']/tbody/tr[";
		String strSecond_part = "]/td[";
		String strThird_part = "]";

		// Used for loop for number of rows.
		for (int k = 3; k <= Row_count; k++)
		{
			// Used for loop for number of columns.
			for (int j = 1; j <= Col_count; j++)
			{
				// Prepared final xpath of specific cell as per values of k and
				// j.
				String final_xpath = strFirst_part + k + strSecond_part + j + strThird_part;
				// find table cell where parameter value is found and then click
				// on radio button under Primary payee column
				String Table_data = driver.findElement (By.xpath (final_xpath)).getText ();
				if (Table_data.contains (strRowText))
				{

					driver.findElement (By.xpath ("/html/body/form/div[12]/span[2]/div[2]/table/tbody/tr/td/div/div/table[1]/tbody/tr[" + k + "]/td[6]/input"))
							.click ();
					return;

				}
			}
		}

	}

	public void clickAddSupplier ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentPayee.btnAddSupplier));
		orClaimLogPaymentPayee.btnAddSupplier.click ();
	}

	public void clickAddRepresentative ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLogPaymentPayee.btnAddRepresentative));
		orClaimLogPaymentPayee.btnAddRepresentative.click ();
	}

}
