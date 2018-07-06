/**
 * 
 */
package com.innovation.pages.policy.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomCount;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.TableHandler;
import com.innovation.pages.client.pages.AddIndividualClient;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicyVehicleHub;

/**
 * @author M.Tahir - Create the page details for the Vehicle Hub_Details
 */
public class PolicyVehicleHub
{

	WebDriver			driver;
	OR_PolicyVehicleHub	orPolicyVehicleHub	= null;

	public PolicyVehicleHub (WebDriver driver)
	{
		this.driver = driver;
		orPolicyVehicleHub = PageFactory.initElements (driver, OR_PolicyVehicleHub.class);

	}

	// This will first check the List of the vehicles in case of any incomplete
	// vehicle
	// This will wait for up to 3 seconds for the Risk drop down list to become
	// available and then select-
	// -'Car' from the Drop down

	// Initialize the Variables that will be used within the script

	// Enter Vehicle Details for UK Region
	public void enterVehicleDetails (String strRegionValue)
	{

		if (strRegionValue.contains ("UK"))
		{

			this.selectOwnership (strRegionValue);
			this.selectAlarmType ();
			this.selectTrackingDevice ();
			this.selectVehicleUse ();
			this.selectPriorInsurance (strRegionValue);
			this.enterAnnualMilage ();
			this.selectParkingLoc ();

		}

		else if (strRegionValue.contains ("USA"))
		{
			this.selectOwnership (strRegionValue);
			this.selectVehicleRegistrationState ();
			this.EnterOdoMilage ();
		}

	}

	public void checkVehicleExists (String strRiskType)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyVehicleHub.Progressbar));

		TableHandler vehiclesList = new TableHandler (driver);
		ControlPanel next = new ControlPanel (driver);
		boolean boolValidate = vehiclesList.verifyTableHasData ("tblVehicle");
		if (boolValidate == true)
		{

			int intVehicleStatus = vehiclesList.completenessChecker ("tblVehicle");

			if (intVehicleStatus == 1)
			{

				next.clickNext ();
			}
		}
		else if (boolValidate == false)
		{
			// Select Risk Type

			WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			load.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlVehicleRiskType));
			Select oRiskType = new Select (orPolicyVehicleHub.ddlVehicleRiskType);
			oRiskType.selectByVisibleText (strRiskType);

		}
	}

	// The Following function will need to select the search criteria of
	public void performVehicleSearch (String strRegionValue)
	{

		if (strRegionValue.contains ("UK"))
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.invisibilityOf (orPolicyVehicleHub.Progressbar));
			List<WebElement> radiobuttons = orPolicyVehicleHub.rdoVehicleRegNo;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("Y"))
				{
					radiobutton.click ();

					wait.until (ExpectedConditions.invisibilityOf (orPolicyVehicleHub.Progressbar));

					orPolicyVehicleHub.txtVRNNumber.sendKeys ("BD51SMR");
					orPolicyVehicleHub.btnVINSearch.click ();
					WebDriverWait waitForInterfaceCall = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

					TableHandler vehicleRecord = new TableHandler (driver);

					String strVehicleMake = vehicleRecord.vehicleSearchSelect ("make", "make", "VehicleData.xml");

					waitForInterfaceCall.until (ExpectedConditions.invisibilityOf (orPolicyVehicleHub.Progressbar));
					WebDriverWait waitt = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
					waitt.until (ExpectedConditions.visibilityOf (orPolicyVehicleHub.tblSearchResults));

					vehicleRecord.returnRowInTable ("tblVRNSearchResults", strVehicleMake);

					wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.btnAddRisk));

					orPolicyVehicleHub.btnAddRisk.click ();

				}
				break;
			}

		}

		else if (strRegionValue.contains ("USA"))
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.invisibilityOf (orPolicyVehicleHub.Progressbar));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.rdoVINSearch));
			orPolicyVehicleHub.rdoVINSearch.click ();

			wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.txtVehicleVIN));
			orPolicyVehicleHub.txtVehicleVIN.sendKeys ("2HNYD2H20AH508954");

			wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.btnVINSearch));
			orPolicyVehicleHub.btnVINSearch.click ();

			WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			load.until (ExpectedConditions.invisibilityOf (orPolicyVehicleHub.Progressbar));

			load.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlVehicleSelect));

			Select oVehicleSelect = new Select (orPolicyVehicleHub.ddlVehicleSelect);
			int intvehicleindex = RandomCount.selectRandomItem (oVehicleSelect);
			oVehicleSelect.selectByIndex (intvehicleindex);
			load.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.btnAddRisk));
			orPolicyVehicleHub.btnAddRisk.click ();

		}

	}

	// Now the following code will add the details of the Vehicle Risk

	// Ownership Indicator---------------------------------------------------------------

	public void selectOwnership (String strRegionValue)
	{
		if (strRegionValue.contains ("UK"))
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.invisibilityOf (orPolicyVehicleHub.Progressbar));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlOwnershipInd));
			Select oOwnershipInd = new Select (orPolicyVehicleHub.ddlOwnershipInd);
			int intOwnershipIndex = RandomCount.selectRandomItem (oOwnershipInd);
			oOwnershipInd.selectByIndex (intOwnershipIndex);
		}
		else
		{
			WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			load.until (ExpectedConditions.invisibilityOf (orPolicyVehicleHub.Progressbar));
			load.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlOwnershipInd));
			Select oOwnershipInd = new Select (orPolicyVehicleHub.ddlOwnershipInd);
			oOwnershipInd.selectByVisibleText ("Owned - Not financed");
		}
	}
	// Alarm Type------------------------------------------------------------------------

	public void selectAlarmType ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlOwnershipInd));
		Select oAlarmType = new Select (orPolicyVehicleHub.ddlAlarmType);
		int intAlarmTypeIndex = RandomCount.selectRandomItem (oAlarmType);
		oAlarmType.selectByIndex (intAlarmTypeIndex);
	}

	// Tracking Device-------------------------------------------------------------------
	public void selectTrackingDevice ()

	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlTrackingDevices));
		Select oTracking = new Select (orPolicyVehicleHub.ddlTrackingDevices);
		int intTrackingDeviceIndex = RandomCount.selectRandomItem (oTracking);
		oTracking.selectByIndex (intTrackingDeviceIndex);
	}

	// Vehicle Usage---------------------------------------------------------------------
	public void selectVehicleUse ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlVehicleUse));
		Select oVehicleUse = new Select (orPolicyVehicleHub.ddlVehicleUse);
		int intVehicleUseIndex = RandomCount.selectRandomItem (oVehicleUse);
		oVehicleUse.selectByIndex (intVehicleUseIndex);

		String strVehicleUsage = oVehicleUse.getFirstSelectedOption ().getText ();
		if (strVehicleUsage.contains ("Business use"))
		{
			this.enterBusinessMilage ();

		}
	}

	public void enterBusinessMilage ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.txtBusinessKMs));
		orPolicyVehicleHub.txtBusinessKMs.sendKeys (RandomNumbers.produceRandomNumber (3));

	}

	// Prior
	// Insurer---------------------------------------------------------------------

	public void selectPriorInsurance (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlPriorInsurer));
		Select oPriorInsurer = new Select (orPolicyVehicleHub.ddlPriorInsurer);
		int intPriorInsurance = RandomCount.selectRandomItem (oPriorInsurer);
		oPriorInsurer.selectByIndex (intPriorInsurance);
		String strPriorInsurance = oPriorInsurer.getFirstSelectedOption ().getText ();
		if (strPriorInsurance.contains ("No previous insurance") == false)
		{

			this.selectNCDType ();
			this.selectNCDProtectedRadio ();
			this.selectNCDPotectedClaim ();
			this.selectContinuousInsurance ();
			this.enterNCDExpiryDate (strRegion);
			this.selectNCDYears ();
			this.selectNCDConfirmed ();
			this.enterNCDConfirmationDate (strRegion);
			this.selectNCDConfirmationSource ();
			this.selectNCDVerification ();
		}

	}

	// Select NCD Type

	public void selectNCDType ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		Select oNCDType = new Select (orPolicyVehicleHub.ddlNCDType);
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlNCDType));
		int intNCDTypeIndex = RandomCount.selectRandomItem (oNCDType);
		oNCDType.selectByIndex (intNCDTypeIndex);

	}

	// Select NCD Radio Button

	public void selectNCDProtectedRadio ()
	{
		List<WebElement> ncdradiobuttons = orPolicyVehicleHub.rdoVehicleNCDProtected;
		for (WebElement ncdradiobutton : ncdradiobuttons)
		{
			if (ncdradiobutton.getAttribute ("value").equals ("Y"))
			{
				ncdradiobutton.click ();
				break;
			}
		}
	}

	// Select NCD Protected Claim

	public void selectNCDPotectedClaim ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlNCDProtected));
		Select oNCDProtectedClaims = new Select (orPolicyVehicleHub.ddlNCDProtected);
		int intNCDProtectedIndex = RandomCount.selectRandomItem (oNCDProtectedClaims);
		oNCDProtectedClaims.selectByIndex (intNCDProtectedIndex);

	}

	// Select Continuous Insurance

	public void selectContinuousInsurance ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlContinuousInsurance));
		Select oYearsInsured = new Select (orPolicyVehicleHub.ddlContinuousInsurance);
		int intYearsInsuredIndex = RandomCount.selectRandomItem (oYearsInsured);
		oYearsInsured.selectByIndex (intYearsInsuredIndex);
	}

	// Enter NCD Expiry Date

	public void enterNCDExpiryDate (String strRegion)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.dtpNCDExpiry));
		orPolicyVehicleHub.dtpNCDExpiry.click ();
		orPolicyVehicleHub.dtpNCDExpiry.sendKeys (CalenderDate.returnDesiredDate (strRegion, 1, 1, 2));
	}

	// Select NCD Years

	public void selectNCDYears ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlNCDYears));
		Select oNCDYears = new Select (orPolicyVehicleHub.ddlNCDYears);
		int intNCDYearsIndex = RandomCount.selectRandomItem (oNCDYears);
		oNCDYears.selectByIndex (intNCDYearsIndex);
	}

	// Select NCD Radio Buttons

	public void selectNCDConfirmed ()
	{

		List<WebElement> ncdconfirmedradiobuttons = orPolicyVehicleHub.rdoVehicleNCDConfirmed;
		for (WebElement ncdconfirmedradiobutton : ncdconfirmedradiobuttons)
		{
			if (ncdconfirmedradiobutton.getAttribute ("value").equals ("Y"))
			{
				ncdconfirmedradiobutton.click ();
				break;
			}
		}

	}

	// Select NCD Confirmation Source

	public void selectNCDConfirmationSource ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlNCDConfirmationSource));
		Select oNCDConfirmation = new Select (orPolicyVehicleHub.ddlNCDConfirmationSource);
		int intNCDConfirmationIndex = RandomCount.selectRandomItem (oNCDConfirmation);
		oNCDConfirmation.selectByIndex (intNCDConfirmationIndex);
	}

	// Enter NCD Confirmation Date

	public void enterNCDConfirmationDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.dtpNCDConirmedDate));
		orPolicyVehicleHub.dtpNCDConirmedDate.click ();
		orPolicyVehicleHub.dtpNCDConirmedDate.sendKeys (CalenderDate.returnDesiredDate (strRegion, 1, 1, 5));

	}

	// Select NCD Verification

	public void selectNCDVerification ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlNCDVerification));
		Select oNCDVerification = new Select (orPolicyVehicleHub.ddlNCDVerification);
		int intNCDVerificationIndex = RandomCount.selectRandomItem (oNCDVerification);
		oNCDVerification.selectByIndex (intNCDVerificationIndex);

	}

	// Annual Mileage----------------------------------------------------------------

	public void enterAnnualMilage ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.txtAnnualKMS));
		orPolicyVehicleHub.txtAnnualKMS.click ();
		orPolicyVehicleHub.txtAnnualKMS.sendKeys (RandomNumbers.produceRandomNumber (5));
	}

	// Parking Location------------------------------------------------------------
	public void selectParkingLoc ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlParking));
		Select oPrakingLoc = new Select (orPolicyVehicleHub.ddlParking);
		int intParkingLocIndex = RandomCount.selectRandomItem (oPrakingLoc);
		oPrakingLoc.selectByIndex (intParkingLocIndex);

	}

	// USA Vehicle Details

	public void selectVehicleRegistrationState ()
	{
		try
		{
			boolean IsStateVisibale = orPolicyVehicleHub.ddlVehicleRegistrationState.isDisplayed ();
			if (IsStateVisibale)
			{
				WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
				wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.ddlVehicleRegistrationState));
				Select oPrakingLoc = new Select (orPolicyVehicleHub.ddlVehicleRegistrationState);
				oPrakingLoc.selectByVisibleText ("Connecticut");
			}
		}
		catch (NoSuchElementException ignored)
		{

		}

	}

	public void EnterOdoMilage ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.txtVehicleOdo));
		orPolicyVehicleHub.txtVehicleOdo.sendKeys (RandomNumbers.produceRandomNumber (4));

	}

	// the following function will validate the error (if there is any) displayed

	public void validateGarageLocationError (String strRegion)
	{

		if (orPolicyVehicleHub.pnlScreenError.isDisplayed () == true)
		{
			do
			{
				WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
				load.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.lnkCloseError));
				orPolicyVehicleHub.lnkCloseError.click ();

				this.changeAddress (strRegion);
			} while (orPolicyVehicleHub.pnlScreenError.isDisplayed () == true);
		}
	}

	public void changeAddress (String strRegion)
	{

		AddIndividualClient changeVehicleAddress = new AddIndividualClient (driver);
		ControlPanel control = new ControlPanel (driver);

		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		load.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.rdoChangeAddress));
		orPolicyVehicleHub.rdoChangeAddress.click ();
		load.until (ExpectedConditions.elementToBeClickable (orPolicyVehicleHub.btnChangeVehicleLocation));
		orPolicyVehicleHub.btnChangeVehicleLocation.click ();

		changeVehicleAddress.typeZIPCode (strRegion);
		changeVehicleAddress.clickZipCodeSearchIcon ();
		changeVehicleAddress.SearchCriteriaDropDown ();
		control.clickNext ();

	}

}
