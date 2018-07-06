package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.RandomNumbers;
import com.innovation.pages.claim.objects.OR_ClaimIncidentDetailsAuto;

/**
 * @author Rizwan. This class stores all the locators and methods in Incident Details frame for Auto LOBs.
 * 
 *         Fields displayed on Incident details frame depend on Claim type and Incident cause selected on Initial details frame.
 *         Separate and different sections display for each of claim type. Fields in these sections remain the same for each of
 *         claim type (Accident, Fire or Vandalism) even when Incident cause is changed. However, fields change when Incident cause
 *         is changed for Theft claim. When creating regression tests, we can randomly pick value from Incident cause for Accident,
 *         Fire and Vandalism claim types. However, we will have to parameterize Incident cause for Theft claim so that we could
 *         select the respective fields.
 *
 */
public class ClaimIncidentDetailsAuto
{
	WebDriver					driver;
	OR_ClaimIncidentDetailsAuto	orClaimIncidentDetailsAuto	= null;

	public ClaimIncidentDetailsAuto (WebDriver driver)
	{
		this.driver = driver;
		orClaimIncidentDetailsAuto = PageFactory.initElements (driver, OR_ClaimIncidentDetailsAuto.class);
	}

	// Methods for General incident details section

	// Pass 'Random' in parameter to randomly select a value from Further
	// details dropdown. Otherwise pass respective value for selection
	public void selectFurtherDetails (String strFurtherDetails)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.ddlFurtherDetails));
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimIncidentDetailsAuto.ddlFurtherDetails, " "));

		if (strFurtherDetails.equalsIgnoreCase ("Random"))
		{
			orClaimIncidentDetailsAuto.ddlFurtherDetails.click ();
			Select oFurtherDetails = new Select (orClaimIncidentDetailsAuto.ddlFurtherDetails);

			// Selects a random Further Details value from the returned list
			List<WebElement> selections = oFurtherDetails.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oFurtherDetails.selectByIndex (intIndex);
		}
		else
		{
			orClaimIncidentDetailsAuto.ddlFurtherDetails.click ();
			orClaimIncidentDetailsAuto.ddlFurtherDetails.sendKeys (strFurtherDetails);
			orClaimIncidentDetailsAuto.ddlFurtherDetails.click ();
		}
	}

	// Pass 'Random' in parameter to randomly select a value from Insured
	// Disposition dropdown. Otherwise pass respective value for selection
	public void selectInsuredDisposition (String strInsuredDisposition)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.ddlInsuredDisposition));

		if (strInsuredDisposition.equalsIgnoreCase ("Random"))
		{
			orClaimIncidentDetailsAuto.ddlInsuredDisposition.click ();
			Select oInsuredDispostion = new Select (orClaimIncidentDetailsAuto.ddlInsuredDisposition);

			// Selects a random Further Details value from the returned list
			List<WebElement> selections = oInsuredDispostion.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oInsuredDispostion.selectByIndex (intIndex);
		}
		else
		{
			orClaimIncidentDetailsAuto.ddlInsuredDisposition.click ();
			orClaimIncidentDetailsAuto.ddlInsuredDisposition.sendKeys (strInsuredDisposition);
			orClaimIncidentDetailsAuto.ddlInsuredDisposition.click ();
		}
	}

	public void typeIncidentDescription ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txaIncidentDescription));

		orClaimIncidentDetailsAuto.txaIncidentDescription.click ();
		orClaimIncidentDetailsAuto.txaIncidentDescription.sendKeys ("Incident description is added here as a random text: " +
			RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectCCTVAvailable (String strCCTVAvailable)
	{
		if (strCCTVAvailable.equalsIgnoreCase ("Yes") || strCCTVAvailable.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoCCTVAvailable;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strCCTVAvailable.equalsIgnoreCase ("No") || strCCTVAvailable.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoCCTVAvailable;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("false"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	public void typeCCTVDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txaCCTVDetails));

		orClaimIncidentDetailsAuto.txaCCTVDetails.click ();
		orClaimIncidentDetailsAuto.txaCCTVDetails.sendKeys (
				"CCTV details are added here as a random text: " + RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	// Methods for General accident details section

	public void selectWeatherConditions ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.ddlWeatherConditions));

		orClaimIncidentDetailsAuto.ddlWeatherConditions.click ();
		Select oWeatherConditions = new Select (orClaimIncidentDetailsAuto.ddlWeatherConditions);

		// Selects a random Weather conditions value from the returned list
		List<WebElement> selections = oWeatherConditions.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oWeatherConditions.selectByIndex (intIndex);
	}

	public void selectSurfaceCondition ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.ddlSurfaceCondition));

		orClaimIncidentDetailsAuto.ddlSurfaceCondition.click ();
		Select oSurfaceCondition = new Select (orClaimIncidentDetailsAuto.ddlSurfaceCondition);

		// Selects a random Weather conditions value from the returned list
		List<WebElement> selections = oSurfaceCondition.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oSurfaceCondition.selectByIndex (intIndex);
	}

	public void typeImpactSpeed ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txtImpactSpeed));

		orClaimIncidentDetailsAuto.txtImpactSpeed.click ();
		orClaimIncidentDetailsAuto.txtImpactSpeed.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typeNoOfVehicleInvolved ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txtNoOfVehiclesInvolved));

		orClaimIncidentDetailsAuto.txtNoOfVehiclesInvolved.click ();
		orClaimIncidentDetailsAuto.txtNoOfVehiclesInvolved.sendKeys (RandomNumbers.produceRandomNumber (1));
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectSeatBeltWorn (String strSeatBeltWorn)
	{
		if (strSeatBeltWorn.equalsIgnoreCase ("Yes") || strSeatBeltWorn.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoSeatBelt;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strSeatBeltWorn.equalsIgnoreCase ("No") || strSeatBeltWorn.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoSeatBelt;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectRecoveredFromRoadside (String strRecoveredFromRoadside)
	{
		if (strRecoveredFromRoadside.equalsIgnoreCase ("Yes") || strRecoveredFromRoadside.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoRecoveredFromRoadSide;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strRecoveredFromRoadside.equalsIgnoreCase ("No") || strRecoveredFromRoadside.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoRecoveredFromRoadSide;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectLightsOn (String strLightsOn)
	{
		if (strLightsOn.equalsIgnoreCase ("Yes") || strLightsOn.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoLightsOn;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strLightsOn.equalsIgnoreCase ("No") || strLightsOn.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoLightsOn;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Methods for General fire details section

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectReportedToFireDept (String strReportFireDept)
	{
		if (strReportFireDept.equalsIgnoreCase ("Yes") || strReportFireDept.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoReportedToFireDept;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strReportFireDept.equalsIgnoreCase ("No") || strReportFireDept.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoReportedToFireDept;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectFireReportedToPolice (String strFireReportedToPolice)
	{
		if (strFireReportedToPolice.equalsIgnoreCase ("Yes") || strFireReportedToPolice.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoFireReportedToPolice;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strFireReportedToPolice.equalsIgnoreCase ("No") || strFireReportedToPolice.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoFireReportedToPolice;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	public void typeFireDateReported (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txtFireDateReported));

		orClaimIncidentDetailsAuto.txtFireDateReported.click ();
		orClaimIncidentDetailsAuto.txtFireDateReported.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typeFireReportNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txtFireReportNo));

		orClaimIncidentDetailsAuto.txtFireReportNo.click ();
		orClaimIncidentDetailsAuto.txtFireReportNo.sendKeys ("FRN" + RandomNumbers.produceRandomNumber (5));
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectFireCulpritsDetained (String strFireCulpritsDetained)
	{
		if (strFireCulpritsDetained.equalsIgnoreCase ("Yes") || strFireCulpritsDetained.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoFireCulpritsDetained;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strFireCulpritsDetained.equalsIgnoreCase ("No") || strFireCulpritsDetained.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoFireCulpritsDetained;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	public void typeFireCulpritsDetainedDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txaFireCulpritsDetainedDetails));

		orClaimIncidentDetailsAuto.txaFireCulpritsDetainedDetails.click ();
		orClaimIncidentDetailsAuto.txaFireCulpritsDetainedDetails.sendKeys ("Fire culprits detained details are entered as random text: " +
			RandomLetters.produceRandomString (10) + RandomNumbers.produceRandomNumber (10));
	}

	public void typeFireDetailsOfPropertyDamage ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txaFireDatailsOfPropertyDamage));

		orClaimIncidentDetailsAuto.txaFireDatailsOfPropertyDamage.click ();
		orClaimIncidentDetailsAuto.txaFireDatailsOfPropertyDamage.sendKeys ("Fire details of property damage are entered as random text: " +
			RandomLetters.produceRandomString (10) + RandomNumbers.produceRandomNumber (10));
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectInjuriesSustained (String strInjuriesSustained)
	{
		if (strInjuriesSustained.equalsIgnoreCase ("Yes") || strInjuriesSustained.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoInjuriesSustained;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strInjuriesSustained.equalsIgnoreCase ("No") || strInjuriesSustained.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoInjuriesSustained;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectNotifiedBySupplier (String strNotifiedBySupplier)
	{
		if (strNotifiedBySupplier.equalsIgnoreCase ("Yes") || strNotifiedBySupplier.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoNotifiedBySupplier;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strNotifiedBySupplier.equalsIgnoreCase ("No") || strNotifiedBySupplier.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoNotifiedBySupplier;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	public void typeSupplierDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txaSupplierDetails));

		orClaimIncidentDetailsAuto.txaSupplierDetails.click ();
		orClaimIncidentDetailsAuto.txaSupplierDetails
				.sendKeys ("Supplier details are entered as random text: " + RandomLetters.produceRandomString (10) + RandomNumbers.produceRandomNumber (10));
	}

	// Methods for General theft details section

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectTheftReportedToPolice (String strTheftReportedToPolice)
	{
		if (strTheftReportedToPolice.equalsIgnoreCase ("Yes") || strTheftReportedToPolice.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoTheftReportedToPolice;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strTheftReportedToPolice.equalsIgnoreCase ("No") || strTheftReportedToPolice.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoTheftReportedToPolice;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	public void typeTheftDateReported (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txtTheftDateReported));

		orClaimIncidentDetailsAuto.txtTheftDateReported.click ();
		orClaimIncidentDetailsAuto.txtTheftDateReported.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typeTheftReportNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txtTheftReportNo));

		orClaimIncidentDetailsAuto.txtTheftReportNo.click ();
		orClaimIncidentDetailsAuto.txtTheftReportNo.sendKeys ("TRN" + RandomNumbers.produceRandomNumber (5));
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectAccidentFollowingTheft (String strAccidentFollowingTheft)
	{
		if (strAccidentFollowingTheft.equalsIgnoreCase ("Yes") || strAccidentFollowingTheft.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoAccidentFollowingTheft;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strAccidentFollowingTheft.equalsIgnoreCase ("No") || strAccidentFollowingTheft.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoAccidentFollowingTheft;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	public void typeTheftDamageDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txaTheftDamageDetails));

		orClaimIncidentDetailsAuto.txaTheftDamageDetails.click ();
		orClaimIncidentDetailsAuto.txaTheftDamageDetails.sendKeys (
				"Theft damage details are entered as random text: " + RandomLetters.produceRandomString (10) + RandomNumbers.produceRandomNumber (10));
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectLocked (String strLocked)
	{
		if (strLocked.equalsIgnoreCase ("Yes") || strLocked.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoLocked;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strLocked.equalsIgnoreCase ("No") || strLocked.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoLocked;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectKeysInVehicle (String strKeysInVehicle)
	{
		if (strKeysInVehicle.equalsIgnoreCase ("Yes") || strKeysInVehicle.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoKeysInVehicle;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strKeysInVehicle.equalsIgnoreCase ("No") || strKeysInVehicle.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoKeysInVehicle;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectDoYouHaveAllSetsOfKeys (String strDoYouHaveAllSetsOfKeys)
	{
		if (strDoYouHaveAllSetsOfKeys.equalsIgnoreCase ("Yes") || strDoYouHaveAllSetsOfKeys.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoDoYouHaveAllSetsOfKeys;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strDoYouHaveAllSetsOfKeys.equalsIgnoreCase ("No") || strDoYouHaveAllSetsOfKeys.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoDoYouHaveAllSetsOfKeys;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	public void typeKeyLocation ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txtKeyLocation));

		orClaimIncidentDetailsAuto.txtKeyLocation.click ();
		orClaimIncidentDetailsAuto.txtKeyLocation.sendKeys ("Key location: " + RandomLetters.produceRandomString (7));
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectAlarmEnabled (String strAlarmEnabled)
	{
		if (strAlarmEnabled.equalsIgnoreCase ("Yes") || strAlarmEnabled.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoAlarmEnabled;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strAlarmEnabled.equalsIgnoreCase ("No") || strAlarmEnabled.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoAlarmEnabled;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectAlaramActivated (String strAlaramActivated)
	{
		if (strAlaramActivated.equalsIgnoreCase ("Yes") || strAlaramActivated.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoAlaramActivated;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strAlaramActivated.equalsIgnoreCase ("No") || strAlaramActivated.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoAlarmEnabled;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectSuspectsKnown (String strSuspectsKnown)
	{
		if (strSuspectsKnown.equalsIgnoreCase ("Yes") || strSuspectsKnown.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoSuspectsKnown;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strSuspectsKnown.equalsIgnoreCase ("No") || strSuspectsKnown.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoSuspectsKnown;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectLocks (String strLocks)
	{
		if (strLocks.equalsIgnoreCase ("Yes") || strLocks.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoLocks;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strLocks.equalsIgnoreCase ("No") || strLocks.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoLocks;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectIgnition (String strIgnition)
	{
		if (strIgnition.equalsIgnoreCase ("Yes") || strIgnition.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoIgnition;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strIgnition.equalsIgnoreCase ("No") || strIgnition.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoIgnition;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectDashboard (String strDashboard)
	{
		if (strDashboard.equalsIgnoreCase ("Yes") || strDashboard.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoDashboard;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strDashboard.equalsIgnoreCase ("No") || strDashboard.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoDashboard;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectFrontGlass (String strFrontGlass)
	{
		if (strFrontGlass.equalsIgnoreCase ("Yes") || strFrontGlass.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoFrontGlass;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strFrontGlass.equalsIgnoreCase ("No") || strFrontGlass.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoFrontGlass;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectSideGlass (String strSideGlass)
	{
		if (strSideGlass.equalsIgnoreCase ("Yes") || strSideGlass.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoSideGlass;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strSideGlass.equalsIgnoreCase ("No") || strSideGlass.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoSideGlass;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectParts (String strParts)
	{
		if (strParts.equalsIgnoreCase ("Yes") || strParts.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoParts;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strParts.equalsIgnoreCase ("No") || strParts.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoParts;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectPartsStolen (String strPartsStolen)
	{
		if (strPartsStolen.equalsIgnoreCase ("Yes") || strPartsStolen.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoPartsStolen;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strPartsStolen.equalsIgnoreCase ("No") || strPartsStolen.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoPartsStolen;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	public void typeVehicleDamageDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txaVehicleDamageDetails));

		orClaimIncidentDetailsAuto.txaVehicleDamageDetails.click ();
		orClaimIncidentDetailsAuto.txaVehicleDamageDetails.sendKeys (
				"Vehicle damage details are entered as random text: " + RandomLetters.produceRandomString (10) + RandomNumbers.produceRandomNumber (10));
	}

	public void selectRecoveredBy ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.ddlRecoveredBy));

		orClaimIncidentDetailsAuto.ddlRecoveredBy.click ();
		Select oRecoveredBy = new Select (orClaimIncidentDetailsAuto.ddlRecoveredBy);

		// Selects a random Recovered By value from the returned list
		List<WebElement> selections = oRecoveredBy.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oRecoveredBy.selectByIndex (intIndex);
	}

	public void typeRecoveredDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txtRecoveredDate));

		orClaimIncidentDetailsAuto.txtRecoveredDate.click ();
		orClaimIncidentDetailsAuto.txtRecoveredDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectForcibleEntry (String strForcibleEntry)
	{
		if (strForcibleEntry.equalsIgnoreCase ("Yes") || strForcibleEntry.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoForcibleEntry;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strForcibleEntry.equalsIgnoreCase ("No") || strForcibleEntry.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoForcibleEntry;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	public void selectVehicleLocation ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.ddlVehicleLocation));

		orClaimIncidentDetailsAuto.ddlVehicleLocation.click ();
		Select oVehicleLocation = new Select (orClaimIncidentDetailsAuto.ddlVehicleLocation);

		// Selects a random oVehicle Location value from the returned list
		List<WebElement> selections = oVehicleLocation.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oVehicleLocation.selectByIndex (intIndex);
		orClaimIncidentDetailsAuto.ddlVehicleLocation.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.ddlVehicleLocation));
		String selectedValue = oVehicleLocation.getFirstSelectedOption ().getText ();
		if (selectedValue.equalsIgnoreCase ("Other"))
		{
			wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txtSpecifyOther));

			orClaimIncidentDetailsAuto.txtSpecifyOther.click ();
			orClaimIncidentDetailsAuto.txtSpecifyOther.sendKeys ("Specify other: " + RandomLetters.produceRandomString (7));
		}
	}

	// Methods for General vandalism details section

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectVandalismReportedToPolice (String strVandalismReportedToPolice)
	{
		if (strVandalismReportedToPolice.equalsIgnoreCase ("Yes") || strVandalismReportedToPolice.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoVandalismReportedToPolice;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strVandalismReportedToPolice.equalsIgnoreCase ("No") || strVandalismReportedToPolice.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoVandalismReportedToPolice;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	public void typeVandalismDateReported (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txtVandalismDateReported));

		orClaimIncidentDetailsAuto.txtVandalismDateReported.click ();
		orClaimIncidentDetailsAuto.txtVandalismDateReported.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typeVandalismReportNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txtVandalismReportNumber));

		orClaimIncidentDetailsAuto.txtVandalismReportNumber.click ();
		orClaimIncidentDetailsAuto.txtVandalismReportNumber.sendKeys ("VRN" + RandomNumbers.produceRandomNumber (5));
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectVandalismCulpritsDetained (String strVandalismCulpritsDetained)
	{
		if (strVandalismCulpritsDetained.equalsIgnoreCase ("Yes") || strVandalismCulpritsDetained.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoVandalismCulpritsDetained;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strVandalismCulpritsDetained.equalsIgnoreCase ("No") || strVandalismCulpritsDetained.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoVandalismCulpritsDetained;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	public void typeVandalismCulpritsDetainedDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txaVandalismCulpritsDetainedDetails));

		orClaimIncidentDetailsAuto.txaVandalismCulpritsDetainedDetails.click ();
		orClaimIncidentDetailsAuto.txaVandalismCulpritsDetainedDetails.sendKeys ("Vandalism culprits detained details are entered as random text: " +
			RandomLetters.produceRandomString (10) + RandomNumbers.produceRandomNumber (10));
	}

	public void typeVandalismDetailsOfPropertyDamage ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetailsAuto.txaVandalismPropertyDamageDetails));

		orClaimIncidentDetailsAuto.txaVandalismPropertyDamageDetails.click ();
		orClaimIncidentDetailsAuto.txaVandalismPropertyDamageDetails.sendKeys ("Vandalism details of property damage are entered as random text: " +
			RandomLetters.produceRandomString (10) + RandomNumbers.produceRandomNumber (10));
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectWitnessesToIncident (String strWitnessesToIncident)
	{
		if (strWitnessesToIncident.equalsIgnoreCase ("Yes") || strWitnessesToIncident.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoWitnessesToIncident;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strWitnessesToIncident.equalsIgnoreCase ("No") || strWitnessesToIncident.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetailsAuto.rdoWitnessesToIncident;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

}
