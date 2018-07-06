/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomCount;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.SelectionHelper;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.misc.TableHandler;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicyDriversDetails;

/**
 * @author M.Tahir - Create the page details for the Property Hub
 */
public class PolicyDriverDetails
{

	WebDriver				driver;

	OR_PolicyDriversDetails	orPolicyDriverDetails	= null;

	public PolicyDriverDetails (WebDriver driver)
	{
		this.driver = driver;
		orPolicyDriverDetails = PageFactory.initElements (driver, OR_PolicyDriversDetails.class);

	}

	public void checkDriverList (String strRegion)
	{
		// This will check the List of all the Drivers in case of any incomplete driver
		// the script will select it and click on Edit button

		// Initialize the Variables for the drop downs

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyDriverDetails.tblDriversList));

		TableHandler driversList = new TableHandler (driver);
		ControlPanel next = new ControlPanel (driver);
		boolean boolValidate = driversList.verifyTableHasData ("tblDriver_001813");
		if (boolValidate == true)
		{

			int intDriverStatus = driversList.completenessChecker ("tblDriver_001813");

			if (intDriverStatus == 1)
			{

				next.clickNext ();
			}

			if (intDriverStatus == 0 && strRegion.equals ("Model Office UK"))
			{

				orPolicyDriverDetails.btnEditDriver.click ();

				// After Clicking Edit, wait for the system to finish loading and the Veil
				// should be disappeared
				// After Veil will disappear enter the license details

				wait.until (ExpectedConditions.invisibilityOf (orPolicyDriverDetails.prgProgress));

				// Select the Country
				Select oSelectCountry = new Select (orPolicyDriverDetails.ddlCountrySelect);
				oSelectCountry.selectByVisibleText ("United Kingdom");

				// int intCountryIndex = RandomCount.selectRandomItem(oSelectCountry);
				// oSelectCountry.selectByIndex(intCountryIndex);

				String strSelectedCountry = oSelectCountry.getFirstSelectedOption ().getText ();
				if (strSelectedCountry.equals ("United Kingdom"))
				{

					// Select the License Class
					Select oSelectLicClass = new Select (orPolicyDriverDetails.ddlLicneseType);
					// int intLicenseTypeIndex = RandomCount.selectRandomItem(oSelectLicClass);
					oSelectLicClass.selectByVisibleText ("Full UK Car Licence");
					String strLicenseClass = oSelectLicClass.getFirstSelectedOption ().getText ();
					wait.until (ExpectedConditions.elementToBeClickable (orPolicyDriverDetails.ddlLicenseYear));

					if (strLicenseClass != "No Licence Ever Held")
					{
						// Select License Year
						wait.until (ExpectedConditions.visibilityOf (orPolicyDriverDetails.ddlLicenseYear));
						Select oSelectLicYear = new Select (orPolicyDriverDetails.ddlLicenseYear);
						int intLicenseYearsIndex = RandomCount.selectRandomItem (oSelectLicYear);
						oSelectLicYear.selectByIndex (intLicenseYearsIndex);

						String strLicenseYearCount = oSelectLicYear.getFirstSelectedOption ().getText ();

						if (strLicenseYearCount.equals ("Less than 1"))
						{
							wait.until (ExpectedConditions.visibilityOf (orPolicyDriverDetails.ddlDriverLicensedMonths));
							Select oDriverLicenseMonths = new Select (orPolicyDriverDetails.ddlDriverLicensedMonths);
							int intLicenseMonthsIndex = RandomCount.selectRandomItem (oDriverLicenseMonths);
							oDriverLicenseMonths.selectByIndex (intLicenseMonthsIndex);

						}

					}

				}

				// Select the License Status
				Select oSelectStatus = new Select (orPolicyDriverDetails.ddlStatus);
				oSelectStatus.selectByVisibleText ("Current");

				// int intStatusIndex = RandomCount.selectRandomItem(oSelectStatus);
				// oSelectStatus.selectByIndex(intStatusIndex);

				// Enter the License Number
				orPolicyDriverDetails.txtLicenseNumber.sendKeys (RandomNumbers.produceRandomNumber (17));

				// Select Update Button
				SeleniumWaiter waitplease = new SeleniumWaiter (driver);
				waitplease.waitForMe (GlobalWaitTime.getIntWaitTime ());
				wait.until (ExpectedConditions.elementToBeClickable (orPolicyDriverDetails.btnDriverDetailsUpdate));

				orPolicyDriverDetails.btnDriverDetailsUpdate.click ();

				wait.until (ExpectedConditions.invisibilityOf (orPolicyDriverDetails.prgProgress));
				next.clickNext ();

			}

			if (intDriverStatus == 0 && (strRegion.equals ("Model Office") || strRegion.equals ("Insurer Us")))
			{

				orPolicyDriverDetails.btnEditDriver.click ();
				// After Clicking Edit, wait for the system to finish loading and the Veil
				// should be disappeared
				// After Veil will disappear enter the license details

				wait.until (ExpectedConditions.invisibilityOf (orPolicyDriverDetails.prgProgress));

				// Select the Country
				Select oSelectCountry = new Select (orPolicyDriverDetails.ddlCountrySelect);
				oSelectCountry.selectByVisibleText ("United States");

				// Select the License Status
				Select oSelectStatus = new Select (orPolicyDriverDetails.ddlStatus);
				oSelectStatus.selectByVisibleText ("Valid");

				// Select License Number
				orPolicyDriverDetails.txtLicenseNumber.sendKeys (RandomNumbers.produceRandomNumber (17));

				// Select the License Class
				Select oSelectLicClass = new Select (orPolicyDriverDetails.ddlLicneseType);
				oSelectLicClass.selectByVisibleText ("Full license");

				// Select the US State
				Select oSelectLicState = new Select (orPolicyDriverDetails.ddlLicenseState);
				oSelectLicState.selectByVisibleText ("Connecticut");

				// Select the License Cancellation Indicator
				SelectionHelper.selectRadio (orPolicyDriverDetails.rdoLicenseCancellationIndicator, "No", false, false, "unknown");
				String strDateRegion = "USA";
				// Select the License Start Date
				wait.until (ExpectedConditions.elementToBeClickable (orPolicyDriverDetails.dtpLicenseStartDate));
				orPolicyDriverDetails.dtpLicenseStartDate.click ();
				orPolicyDriverDetails.dtpLicenseStartDate.sendKeys (CalenderDate.returnDesiredDate (strDateRegion, 1, 1, -5));
				orPolicyDriverDetails.dtpLicenseStartDate.click ();
				// Enter the USA Drivers Extended Details
				wait.until (ExpectedConditions.elementToBeClickable (orPolicyDriverDetails.txtLicenseFirstYear));
				// String strPickLicenseYear = orPolicyDriverDetails.dtpLicenseStartDate.getText ();
				// String strlicenseYear = StringUtils.substringAfterLast (strPickLicenseYear, "/");
				orPolicyDriverDetails.txtLicenseFirstYear.sendKeys ("2012");

				// Select the License Driver Training
				SelectionHelper.selectRadio (orPolicyDriverDetails.rdoDriverTrainingIndicator, "No", false, false, "unknown");

				// Select the Driver Retired
				SelectionHelper.selectRadio (orPolicyDriverDetails.rdoDriverRetiredIndicator, "No", false, false, "unknown");

				// Select the Student Away Indicator
				Select oSelectStudentAway = new Select (orPolicyDriverDetails.ddlStudentAwayIndicator);
				int intStudentAwayIndex = RandomCount.selectRandomItem (oSelectStudentAway);
				oSelectStudentAway.selectByIndex (intStudentAwayIndex);

				// Select the Defensive Driver Indicator
				Select oSelectDefensiveDriver = new Select (orPolicyDriverDetails.ddlDefensiveDriverIndicator);
				int intDefensiveDriverIndex = RandomCount.selectRandomItem (oSelectDefensiveDriver);
				oSelectDefensiveDriver.selectByIndex (intDefensiveDriverIndex);

				String strActualDriverDefensiveInd = orPolicyDriverDetails.ddlDefensiveDriverIndicator.getText ();

				// Conditional Fields to be caterd

				if (strActualDriverDefensiveInd.equals ("Patriot") || strActualDriverDefensiveInd.equals ("Yes"))
				{
					wait.until (ExpectedConditions.elementToBeClickable (orPolicyDriverDetails.dtpDefensiveDriverDate));
					orPolicyDriverDetails.dtpDefensiveDriverDate.click ();
					orPolicyDriverDetails.dtpDefensiveDriverDate.sendKeys (CalenderDate.returnDesiredDate (strDateRegion, 1, 1, -10));
				}

				// Select the Good Student Indicator
				Select oSelectGoodStudent = new Select (orPolicyDriverDetails.ddlGoodStudentIndicator);
				int intGoodStudentIndex = RandomCount.selectRandomItem (oSelectGoodStudent) - 1;
				oSelectGoodStudent.selectByIndex (intGoodStudentIndex);

				String strActualGoodStudentValue = orPolicyDriverDetails.ddlGoodStudentIndicator.getText ();

				if (strActualGoodStudentValue.equals ("Good student college aged 25 and under") || strActualGoodStudentValue.equals ("Good student applies"))
				{
					wait.until (ExpectedConditions.elementToBeClickable (orPolicyDriverDetails.dtpGoodStudentDate));
					orPolicyDriverDetails.dtpGoodStudentDate.click ();
					orPolicyDriverDetails.dtpGoodStudentDate.sendKeys (CalenderDate.returnDesiredDate (strDateRegion, 1, 1, -18));
				}
				orPolicyDriverDetails.btnDriverDetailsUpdate.click ();
				wait.until (ExpectedConditions.invisibilityOf (orPolicyDriverDetails.prgProgress));
				next.clickNext ();

			}
		}
	}

}
