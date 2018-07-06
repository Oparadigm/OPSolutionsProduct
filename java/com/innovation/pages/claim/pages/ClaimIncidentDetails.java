/**
 * 
 */
package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.By;
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
import com.innovation.pages.claim.objects.OR_ClaimIncidentDetails;

/**
 * @author alamq This class will store all the locators and methods on Incident Details Screen
 */

public class ClaimIncidentDetails
{
	WebDriver				driver;
	OR_ClaimIncidentDetails	orClaimIncidentDetails	= null;

	public ClaimIncidentDetails (WebDriver driver)
	{
		this.driver = driver;
		orClaimIncidentDetails = PageFactory.initElements (driver, OR_ClaimIncidentDetails.class);
	}

	// Select "Incident type" drop down

	public void selectIncidentType (String strIncidentType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlIncidentType));
		orClaimIncidentDetails.ddlIncidentType.click ();
		Select oIncidentType = new Select (orClaimIncidentDetails.ddlIncidentTypeValue);
		oIncidentType.selectByVisibleText (strIncidentType);

	}

	// Type details in "Incident Description" Text Area

	public void typeIncidentDescription ()
	{

		orClaimIncidentDetails.txaIncidentDescription.sendKeys ("INCIDENT DETAILS ADDED A RANDOM TEXT " + RandomLetters.produceRandomString (6));

	}

	// Radio button "CCTV Available" is selected as per parameter
	// strCCTVAvailable

	public void selectCCTV (String strCCTVAvailable)
	{

		if (strCCTVAvailable.equalsIgnoreCase ("Yes") || strCCTVAvailable.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoCCTV;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strCCTVAvailable.equalsIgnoreCase ("No") || strCCTVAvailable.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoCCTV;
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

	// Type details in "CCTV Details" text box

	public void typeCCTVDetails ()
	{

		orClaimIncidentDetails.txaCCTVDetails.sendKeys ("CCTV DETAILS ADDED A RANDOM TEXT " + RandomLetters.produceRandomString (6));

	}

	// Type date in "Date Last Occupied" field

	public void typeLastOccupied (String strRegion)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.dtpLastOccupied));
		orClaimIncidentDetails.dtpLastOccupied.click ();
		orClaimIncidentDetails.dtpLastOccupied.sendKeys (CalenderDate.returnDesiredDate (strRegion, 0, 0, -3));

	}

	// Type date in "Date Last Furnished" field

	public void typeLastFurnished (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.dtpLastFurnished));
		orClaimIncidentDetails.dtpLastFurnished.click ();
		orClaimIncidentDetails.dtpLastFurnished.sendKeys (CalenderDate.returnDesiredDate (strRegion, 0, 0, -1));

	}

	// Radio button "Parties Involved known" is selected as per parameter
	// strPartiesInvolved

	public void selectPartiesInvolved (String strPartiesInvolved)
	{

		if (strPartiesInvolved.equalsIgnoreCase ("Yes") || strPartiesInvolved.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPartiesInvolved;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPartiesInvolved.equalsIgnoreCase ("No") || strPartiesInvolved.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPartiesInvolved;
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

	// Select "Additional Details" drop down

	public void selectAdditionalDetails (String strAdditionalDetails)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlAdditionalDetails));
		orClaimIncidentDetails.ddlAdditionalDetails.click ();
		Select oAdditionalDetails = new Select (orClaimIncidentDetails.ddlAdditionalDetails);
		oAdditionalDetails.selectByVisibleText (strAdditionalDetails);

	}

	// Radio button "Witnesses" is selected as per parameter strWitnesses

	public void selectWitnesses (String strWitnesses)
	{

		if (strWitnesses.equalsIgnoreCase ("Yes") || strWitnesses.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoWitnesses;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strWitnesses.equalsIgnoreCase ("No") || strWitnesses.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoWitnesses;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}

			}
		}

		else
		{

			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoWitnesses;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("2"))
				{
					radiobutton.click ();
					break;
				}

			}

		}

	}

	// Type details in "Number of Children" Text field

	public void typeNumberOfChildren (String strNumberOfChildren)
	{

		orClaimIncidentDetails.txtNumberOfChildren.sendKeys (strNumberOfChildren);

	}

	// Radio button "Accompanied by an Adult" is selected as per parameter
	// strAccompaniedByAdult

	public void selectAccompaniedByAdult (String strAccompaniedByAdult)
	{

		if (strAccompaniedByAdult.equalsIgnoreCase ("Yes") || strAccompaniedByAdult.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoChildAccompanied;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strAccompaniedByAdult.equalsIgnoreCase ("No") || strAccompaniedByAdult.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoChildAccompanied;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}

			}

		}
		else
		{

			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoChildAccompanied;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("2"))
				{
					radiobutton.click ();
					break;
				}

			}

		}

	}

	// Select Property Owner drop down

	public void selectPropertyOwner (String strPropertyOwner)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlPropertyOwner));
		orClaimIncidentDetails.ddlPropertyOwner.click ();
		Select oOwner = new Select (orClaimIncidentDetails.ddlPropertyOwner);
		oOwner.selectByVisibleText (strPropertyOwner);
	}

	// Select "Last Property Maintenance" drop down

	public void selectPropertyMaintenance (String strPropertyMaintenance)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlPropertyMaintenance));
		orClaimIncidentDetails.ddlPropertyMaintenance.click ();
		Select oMaintenance = new Select (orClaimIncidentDetails.ddlPropertyMaintenance);
		oMaintenance.selectByVisibleText (strPropertyMaintenance);

	}

	// Select "Maintained By" drop down

	public void selectMaintainedBy (String strMaintainedBy)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlMaintainedBy));
		orClaimIncidentDetails.ddlMaintainedBy.click ();
		Select oMaintainedBy = new Select (orClaimIncidentDetails.ddlMaintainedBy);
		oMaintainedBy.selectByVisibleText (strMaintainedBy);
	}

	// Select "Animal Type" drop down

	public void selectAnimalType (String strAnimalType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlAnimalType));
		orClaimIncidentDetails.ddlAnimalType.click ();
		Select oAnimalType = new Select (orClaimIncidentDetails.ddlAnimalType);
		oAnimalType.selectByVisibleText (strAnimalType);

	}

	// Type details in "Breed" field

	public void typeBreed ()
	{
		orClaimIncidentDetails.txtBreed.sendKeys ("Breed DETAILS ADDED A RANDOM TEXT " + RandomLetters.produceRandomString (6));

	}

	// Select "Animal Owner" drop down

	public void selectAnimalOwner (String strAnimalOwner)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlAnimalOwner));
		orClaimIncidentDetails.ddlAnimalOwner.click ();
		Select oAnimalOwner = new Select (orClaimIncidentDetails.ddlAnimalOwner);
		oAnimalOwner.selectByVisibleText (strAnimalOwner);

	}

	// Radio button "Vicious temperament" is selected as per parameter
	// strVicioustemperament

	public void selectViciousTemperament (String strVicioustemperament)
	{

		if (strVicioustemperament.equalsIgnoreCase ("Yes") || strVicioustemperament.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoViciousTemperature;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strVicioustemperament.equalsIgnoreCase ("No") || strVicioustemperament.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoViciousTemperature;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}

			}
		}

		else
		{

			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoViciousTemperature;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("2"))
				{
					radiobutton.click ();
					break;
				}

			}

		}

	}

	// Radio button "Caused Damage Previously" is selected as per parameter
	// strDamagePreviously

	public void selectDamagePreviously (String strDamagePreviously)
	{

		if (strDamagePreviously.equalsIgnoreCase ("Yes") || strDamagePreviously.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoDamagedCausedPreviously;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strDamagePreviously.equalsIgnoreCase ("No") || strDamagePreviously.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoDamagedCausedPreviously;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}

			}
		}

		else
		{

			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoDamagedCausedPreviously;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("-1"))
				{
					radiobutton.click ();
					break;
				}

			}

		}

	}

	// Type details in "Details of incident" field

	public void typeSlipIncident ()
	{

		orClaimIncidentDetails.txtSlipIncidentDetails.sendKeys ("Slip Incident DETAILS ADDED A RANDOM TEXT " + RandomLetters.produceRandomString (6));

	}

	// Radio button "Hazard Sign" is selected as per parameter strHazardSign

	public void selectHazardSign (String strHazardSign)
	{

		if (strHazardSign.equalsIgnoreCase ("Yes") || strHazardSign.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoHazardSign;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strHazardSign.equalsIgnoreCase ("No") || strHazardSign.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoHazardSign;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}

			}
		}

		else
		{

			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoHazardSign;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("2"))
				{
					radiobutton.click ();
					break;
				}

			}

		}

	}

	// Select "Condition of Incident Area" drop down

	public void selectIncidentCondition (String strIncidentCondition)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlAreaCondition));
		orClaimIncidentDetails.ddlAreaCondition.click ();
		Select oIncidentCondition = new Select (orClaimIncidentDetails.ddlAreaCondition);
		oIncidentCondition.selectByVisibleText (strIncidentCondition);

	}

	// Type date in "Incident Notification"

	public void typeIncidentNotification (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.dtpIncidentNotification));
		orClaimIncidentDetails.dtpIncidentNotification.clear ();
		orClaimIncidentDetails.dtpIncidentNotification.click ();
		orClaimIncidentDetails.dtpIncidentNotification.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	// Type date in "When did you notice"

	public void typeNotificationDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.dtpNotificationDate));
		orClaimIncidentDetails.dtpNotificationDate.click ();
		orClaimIncidentDetails.dtpNotificationDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	// Type time in "When did you notice" field

	public void typeIncidentNotificationTime (String strIncidentTime)

	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.txtNotificationTime));
		orClaimIncidentDetails.txtNotificationTime.click ();
		orClaimIncidentDetails.txtNotificationTime.sendKeys (strIncidentTime);
	}

	// Type details in "Mitigation Action taken" Text Area

	public void typeMitigationAction ()
	{
		orClaimIncidentDetails.txaMitigationAction.sendKeys ("Mitigation Action ADDED A RANDOM TEXT " + RandomLetters.produceRandomString (6));
	}

	// Type details in "How did you Notice" Text Area

	public void typeHowIncidentNotice ()

	{

		orClaimIncidentDetails.txaHowIncidentNotice.sendKeys ("How did you Notice ADDED A RANDOM TEXT " + RandomLetters.produceRandomString (6));
	}

	// Radio button "Already repaired/replaced" is selected as per parameter
	// strAlreadyRepaired

	public void selectAlreadyRepaired (String strAlreadyRepaired)
	{

		if (strAlreadyRepaired.equalsIgnoreCase ("Yes") || strAlreadyRepaired.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoAlreadyRepaired;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strAlreadyRepaired.equalsIgnoreCase ("No") || strAlreadyRepaired.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoAlreadyRepaired;
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

	// Radio button "organised someone to repair/replace" is selected as per
	// parameter strOrganisedRepaired

	public void selectOrganisedRepaired (String strOrganisedRepaired)
	{

		if (strOrganisedRepaired.equalsIgnoreCase ("Yes") || strOrganisedRepaired.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoOrganisedRepaired;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strOrganisedRepaired.equalsIgnoreCase ("No") || strOrganisedRepaired.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoOrganisedRepaired;
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

	// Radio button "Damage Contained within the premises" is selected as per
	// parameter strDamageContained

	public void selectDamageContained (String strDamageContained)
	{

		if (strDamageContained.equalsIgnoreCase ("Yes") || strDamageContained.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoDamageContained;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strDamageContained.equalsIgnoreCase ("No") || strDamageContained.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoDamageContained;
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

	// Radio button "Caused by Third Party" is selected as per parameter
	// strCausedByThirdParty

	public void selectCausedByThirdParty (String strCausedByThirdParty)
	{

		if (strCausedByThirdParty.equalsIgnoreCase ("Yes") || strCausedByThirdParty.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoCauseByThirdParty;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strCausedByThirdParty.equalsIgnoreCase ("No") || strCausedByThirdParty.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoCauseByThirdParty;
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

	// Type details in "Supplier Details" text box

	public void typeSupplierDetails ()
	{

		orClaimIncidentDetails.txtSupplierDetails.sendKeys ("Supplier details: " + RandomLetters.produceRandomString (6));

	}

	// Type details in "Repair Amount" text box

	public void typeRepairAmount ()
	{
		orClaimIncidentDetails.txtRepairedAmount.sendKeys ("2" + RandomNumbers.produceRandomNumber (3));

	}

	// Select "By Whom" drop down

	public void selectByWhom (String strByWhom)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlByWhom));
		orClaimIncidentDetails.ddlByWhom.click ();
		Select oByWhom = new Select (orClaimIncidentDetails.ddlByWhom);
		oByWhom.selectByVisibleText (strByWhom);

	}

	// Type details in "Supplier Organised Details" text box

	public void typeSupplierOrganisedDetails ()
	{

		orClaimIncidentDetails.txtSupplierOrganisedDetails.sendKeys ("Org. Supp. Det. : " + RandomLetters.produceRandomString (6));

	}

	// Click on OK button
	public void clickOK ()

	{

		orClaimIncidentDetails.btnOK.click ();

	}

	// Select "Type of Risk" table

	public void selectRiskRecord (String strValue)

	{ // Will update in next feature with TableHandler

		WebElement oTable = orClaimIncidentDetails.tblRiskTable;
		WebElement oRow = oTable.findElement (By.xpath ("//tr/td[contains(text(), '" + strValue + "')]"));
		oRow.click ();
	}

	public void selectAccidentalDamage (String strDamageType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlAccidentalDamage));
		orClaimIncidentDetails.ddlAccidentalDamage.click ();
		Select oAccidentalDamage = new Select (orClaimIncidentDetails.ddlAccidentalDamage);
		oAccidentalDamage.selectByVisibleText (strDamageType);

	}

	// Radio button "Reported to Police" is selected as per parameter
	// strReportedToPolice

	public void selectReportedToPolice (String strReportedToPolice)
	{

		if (strReportedToPolice.equalsIgnoreCase ("Yes") || strReportedToPolice.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoReportedToPolice;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strReportedToPolice.equalsIgnoreCase ("No") || strReportedToPolice.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoReportedToPolice;
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

	// Type date in "Date Reported"

	public void typeDateReported (String strRegion)
	{
		orClaimIncidentDetails.dtpDateReported.clear ();
		orClaimIncidentDetails.dtpDateReported.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	// Type details in "Police Report Number" text box

	public void typePoliceReportNumber ()
	{
		orClaimIncidentDetails.txtPoliceReportNumber.sendKeys (RandomNumbers.produceRandomNumber (2));

	}

	// Radio button "Has property been vacant" is selected as per parameter
	// strVacantProperty

	public void selectVacantProperty (String strVacantProperty)
	{

		if (strVacantProperty.equalsIgnoreCase ("Yes") || strVacantProperty.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoVacantProperty;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strVacantProperty.equalsIgnoreCase ("No") || strVacantProperty.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoVacantProperty;
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

	// Radio button "Property Safe" is selected as per parameter strPropertySafe

	public void selectPropertySafe (String strPropertySafe)
	{

		if (strPropertySafe.equalsIgnoreCase ("Yes") || strPropertySafe.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPropertySafe;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPropertySafe.equalsIgnoreCase ("No") || strPropertySafe.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPropertySafe;
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

	// Radio button "Property Secure" is selected as per parameter
	// strPropertySecure

	public void selectPropertySecure (String strPropertySecure)
	{

		if (strPropertySecure.equalsIgnoreCase ("Yes") || strPropertySecure.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPropertySecure;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPropertySecure.equalsIgnoreCase ("No") || strPropertySecure.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPropertySecure;
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

	// Type details in "Repair Amount" text box

	public void typeVacantLength ()
	{
		orClaimIncidentDetails.txtVacantLength.sendKeys (RandomNumbers.produceRandomNumber (1));

	}

	// Radio button "Home Purchased in last 12 Months" is selected as per
	// parameter
	// strHomePurchase

	public void selectHomePurchased (String strHomePurchase)
	{

		if (strHomePurchase.equalsIgnoreCase ("Yes") || strHomePurchase.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoHomePurchased;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strHomePurchase.equalsIgnoreCase ("No") || strHomePurchase.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoHomePurchased;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("false"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strHomePurchase.equalsIgnoreCase ("No") || strHomePurchase.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoHomePurchased;
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

	// Radio button "All Services Available" is selected as per parameter
	// strServicesAvailable

	public void selectServicesAvailable (String strServicesAvailable)
	{

		if (strServicesAvailable.equalsIgnoreCase ("Yes") || strServicesAvailable.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoServicesAvailable;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strServicesAvailable.equalsIgnoreCase ("No") || strServicesAvailable.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoServicesAvailable;
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

	// Radio button "Property Uninhabitable" is selected as per parameter
	// strPropertyUninhabitable

	public void selectPropertyUninhabitable (String strPropertyUninhabitable)
	{

		if (strPropertyUninhabitable.equalsIgnoreCase ("Yes") || strPropertyUninhabitable.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPropertyUninhabitable;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPropertyUninhabitable.equalsIgnoreCase ("No") || strPropertyUninhabitable.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPropertyUninhabitable;
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

	// Radio button "Assistance required to access the Property" is selected as
	// per
	// parameter strAssistanceRequired

	public void selectAssistanceRequired (String strAssistanceRequired)
	{

		if (strAssistanceRequired.equalsIgnoreCase ("Yes") || strAssistanceRequired.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoAssistanceRequired;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strAssistanceRequired.equalsIgnoreCase ("No") || strAssistanceRequired.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoAssistanceRequired;
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

	// Type details in "Property Uninhabitable Details" text box

	public void typePropertyDetails ()
	{

		orClaimIncidentDetails.txtPropertyUninhabitableDetails.sendKeys ("Prop. uninhab. " + RandomLetters.produceRandomString (6));

	}

	// Type details in "Weather Station" text box

	public void typeWeatherStation ()
	{

		orClaimIncidentDetails.txtWeatherStation.sendKeys ("WEATHER STATION DETAILS ADDED A RANDOM TEXT " + RandomLetters.produceRandomString (6));

	}

	// Click on "Meteorological Data" section

	public void ClickMeteorologicalData ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.pnlMeteorologicalData));
		orClaimIncidentDetails.pnlMeteorologicalData.click ();
	}

	// Type details in "Maximum Gust (mph)" text box

	public void typeMaximumGust ()
	{
		orClaimIncidentDetails.txtMaximumGust.sendKeys (RandomNumbers.produceRandomNumber (2));

	}

	// Type details in "Average Wind Speed (mph)" text box

	public void typeAverageWindSpeed ()
	{
		orClaimIncidentDetails.txtAverageWindSpeed.sendKeys (RandomNumbers.produceRandomNumber (2));

	}

	// Type details in "Snow fall (mm)" text box

	public void typeSnowFall ()
	{
		orClaimIncidentDetails.txtSnowFall.sendKeys (RandomNumbers.produceRandomNumber (2));

	}

	public void typeHoursOfSun ()
	{
		orClaimIncidentDetails.txtHoursOfSun.sendKeys (RandomNumbers.produceRandomNumber (1));

	}

	// Type details in "Precipitation (mm)" text box

	public void typePrecipitation ()
	{
		orClaimIncidentDetails.txtPrecipitation.sendKeys (RandomNumbers.produceRandomNumber (2));

	}

	// Type details in "Maximum Temperature" text box

	public void typeMaxTemperature ()
	{
		orClaimIncidentDetails.txtMaximumTemperature.sendKeys (RandomNumbers.produceRandomNumber (2));

	}

	// Type details in "Minimum Temperature" text box

	public void typeMinTemperature ()
	{
		orClaimIncidentDetails.txtMinimumTemperature.sendKeys (RandomNumbers.produceRandomNumber (2));

	}

	// Type details in "Comments" text area

	public void typeComments ()
	{
		orClaimIncidentDetails.txaMeteorologicalComments.sendKeys ("Meteorological data comments: " + RandomNumbers.produceRandomNumber (10));

	}

	// Below details will be used for when Type of Claim is Fire

	// Radio button "Reported to Fire" is selected as per

	public void selectReportedToFire (String strReportedToFire)
	{

		if (strReportedToFire.equalsIgnoreCase ("Yes") || strReportedToFire.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoReportedToFire;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strReportedToFire.equalsIgnoreCase ("No") || strReportedToFire.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoReportedToFire;
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

	// Radio button "Reported to Fire" is selected as per

	public void selectReportedToPoliceFire (String strReportedToPolice)
	{

		if (strReportedToPolice.equalsIgnoreCase ("Yes") || strReportedToPolice.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoReportedToPoliceFire;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strReportedToPolice.equalsIgnoreCase ("No") || strReportedToPolice.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoReportedToPoliceFire;
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

	public void selectOriginFire (String strOrigin)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlOriginFire));

		orClaimIncidentDetails.ddlOriginFire.click ();
		Select oOrigin = new Select (orClaimIncidentDetails.ddlOriginValueFire);
		oOrigin.selectByVisibleText (strOrigin);
	}

	// Type date in "Date Last Occupied" field

	public void typeDateReportedFire (String strRegion)
	{

		orClaimIncidentDetails.dtpDateReportedFire.clear ();
		orClaimIncidentDetails.dtpDateReportedFire.sendKeys (CalenderDate.returnCurrentDate (strRegion));

	}

	// Type details in "Minimum Temperature" text box

	public void typePoliceReportNumberFire ()
	{
		orClaimIncidentDetails.txtPoliceReportNumberFire.sendKeys (RandomNumbers.produceRandomNumber (2));

	}

	// Radio button "Was anyone present in the property" is selected as per

	public void selectPropertyOccupiedFire (String strPropertyOccupiedFire)
	{

		if (strPropertyOccupiedFire.equalsIgnoreCase ("Yes") || strPropertyOccupiedFire.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPropertyOccupiedFire;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPropertyOccupiedFire.equalsIgnoreCase ("No") || strPropertyOccupiedFire.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPropertyOccupiedFire;
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

	// Type details in "who was at the property" text box

	public void typePropertyOccupiedFire ()
	{
		orClaimIncidentDetails.txtPropertyOccupiedFire.sendKeys (RandomLetters.produceRandomString (6));

	}

	// Enter details in "who discovered the fire/explosion" field

	public void typePersonDiscoveredDamageFire ()
	{
		orClaimIncidentDetails.txtPersonDiscoveredDamageFire.sendKeys (RandomLetters.produceRandomString (6));

	}

	// Enter details in "who has access to the property" field

	public void typePersonAccessedPropertyFire ()
	{
		orClaimIncidentDetails.txtPersonAccessedPropertyFire.sendKeys (RandomLetters.produceRandomString (6));

	}

	// Radio button "Was anyone present in the property" is selected as per

	public void selectElectricalWorkDone (String strElectricalWorkDone)
	{

		if (strElectricalWorkDone.equalsIgnoreCase ("Yes") || strElectricalWorkDone.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoElectricalWorkDoneFire;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strElectricalWorkDone.equalsIgnoreCase ("No") || strElectricalWorkDone.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoElectricalWorkDoneFire;
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

	// Enter details in "who discovered the fire/explosion" field

	public void typeElectricalWorkDetailsFire ()
	{
		orClaimIncidentDetails.txtElectricalWorkDetailsFire.sendKeys (RandomLetters.produceRandomString (6));

	}

	public void selectAvailabelRooms (String strAvailabelRooms)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.tblAvailableRoomFire));
		Select oOrigin = new Select (orClaimIncidentDetails.tblAvailableRoomFire);
		oOrigin.selectByVisibleText (strAvailabelRooms);
	}

	// Click on "Select Rooms" button

	public void clickSelectRoom ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.btnSelectRoomFire));
		orClaimIncidentDetails.btnSelectRoomFire.click ();
	}

	// Click on Save button

	public void clickSave ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.btnSave));
		orClaimIncidentDetails.btnSave.click ();
		// This waits until the progress bar that displays to load e.g. the address goes invisible
		wait.until (ExpectedConditions.invisibilityOf (orClaimIncidentDetails.prgProgressBar));
	}

	// Click Proceed button

	public void clickProceed ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.btnProceed));
		orClaimIncidentDetails.btnProceed.click ();
	}

	// Additional methods for the fields that display when Storm claim type is
	// selected on Initial details frame

	// Pass 'Yes' or 'No' to parameter to select respective radio button
	public void selectReportedToFireDeptStorm (String strReportedToFireDeptStorm)
	{

		if (strReportedToFireDeptStorm.equalsIgnoreCase ("Yes") || strReportedToFireDeptStorm.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoReportedToFireDeptStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strReportedToFireDeptStorm.equalsIgnoreCase ("No") || strReportedToFireDeptStorm.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoReportedToFireDeptStorm;
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

	// Pass 'Yes' or 'No' to parameter to select respective radio button
	public void selectReportedToPoliceStorm (String strReportedToPoliceStorm)
	{

		if (strReportedToPoliceStorm.equalsIgnoreCase ("Yes") || strReportedToPoliceStorm.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoReportedToPoliceStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strReportedToPoliceStorm.equalsIgnoreCase ("No") || strReportedToPoliceStorm.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoReportedToPoliceStorm;
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

	public void typeDateReportedStorm (String strRegion)
	{
		orClaimIncidentDetails.txtDateReportedStorm.clear ();
		orClaimIncidentDetails.txtDateReportedStorm.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typePoliceReportNoStorm ()
	{
		orClaimIncidentDetails.txtPoliceReportNoStorm.click ();
		orClaimIncidentDetails.txtPoliceReportNoStorm.sendKeys ("SPRN" + RandomNumbers.produceRandomNumber (5));

	}

	// Pass 'Yes' or 'No' to parameter to select respective radio button
	public void selectPropertyUnderConstStorm (String strPropertyUnderConstStorm)
	{

		if (strPropertyUnderConstStorm.equalsIgnoreCase ("Yes") || strPropertyUnderConstStorm.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPropertyUnderConstStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPropertyUnderConstStorm.equalsIgnoreCase ("No") || strPropertyUnderConstStorm.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPropertyUnderConstStorm;
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

	// Pass 'Yes' or 'No' to parameter to select respective radio button
	public void selectDamageToAreaUnderConstStorm (String strDamageToAreaUnderConstStorm)
	{

		if (strDamageToAreaUnderConstStorm.equalsIgnoreCase ("Yes") || strDamageToAreaUnderConstStorm.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoDamageToAreaUnderConstStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strDamageToAreaUnderConstStorm.equalsIgnoreCase ("No") || strDamageToAreaUnderConstStorm.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoDamageToAreaUnderConstStorm;
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

	// Pass 'Yes' or 'No' to parameter to select respective radio button
	public void selectMaintenanceCompletedStorm (String strMaintenanceCompletedStorm)
	{

		if (strMaintenanceCompletedStorm.equalsIgnoreCase ("Yes") || strMaintenanceCompletedStorm.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoMaintenanceCompletedStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strMaintenanceCompletedStorm.equalsIgnoreCase ("No") || strMaintenanceCompletedStorm.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoMaintenanceCompletedStorm;
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

	public void typeMaintenanceCompletedDetailsStorm ()
	{

		orClaimIncidentDetails.txaMaintenanceCompletedDetailsStorm.click ();
		orClaimIncidentDetails.txaMaintenanceCompletedDetailsStorm.sendKeys (
				"Maintenance completed is entered as random text: " + RandomNumbers.produceRandomNumber (7) + " " + RandomLetters.produceRandomString (7));

	}

	// Pass 'Yes' or 'No' to parameter to select respective radio button
	public void selectOpeningToBuildingStorm (String strOpeningToBuildingStorm)
	{

		if (strOpeningToBuildingStorm.equalsIgnoreCase ("Yes") || strOpeningToBuildingStorm.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoOpeningToBuildingStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strOpeningToBuildingStorm.equalsIgnoreCase ("No") || strOpeningToBuildingStorm.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoOpeningToBuildingStorm;
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

	// Pass 'Yes' or 'No' to parameter to select respective radio button
	public void selectPropertyFloodedStorm (String strPropertyFloodedStorm)
	{

		if (strPropertyFloodedStorm.equalsIgnoreCase ("Yes") || strPropertyFloodedStorm.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPropertyFloodedStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPropertyFloodedStorm.equalsIgnoreCase ("No") || strPropertyFloodedStorm.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPropertyFloodedStorm;
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

	public void selectMaxHeightOfWaterStorm ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlMaxHeightOfWaterStorm));

		orClaimIncidentDetails.ddlMaxHeightOfWaterStorm.click ();
		Select oMaxHeightOfWater = new Select (orClaimIncidentDetails.ddlMaxHeightOfWaterStorm);

		// Selects a random Max Height Of Water value from the returned list
		List<WebElement> selections = oMaxHeightOfWater.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oMaxHeightOfWater.selectByIndex (intIndex);
	}

	// Pass 'Yes', 'No' or 'Unknown' to parameter to select respective radio
	// button
	public void selectFoulWaterStorm (String strFoulWaterStorm)
	{

		if (strFoulWaterStorm.equalsIgnoreCase ("Yes") || strFoulWaterStorm.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoFoulWaterStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strFoulWaterStorm.equalsIgnoreCase ("No") || strFoulWaterStorm.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoFoulWaterStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}

			}
		}
		else if ((strFoulWaterStorm.equalsIgnoreCase ("Unknown") || strFoulWaterStorm.equalsIgnoreCase ("U")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoFoulWaterStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("-1"))
				{
					radiobutton.click ();
					break;
				}

			}
		}

	}

	// Pass 'Yes', 'No' or 'Unknown' to parameter to select respective radio
	// button
	public void selectPreviousFloodingStorm (String strPreviousFloodingStorm)
	{

		if (strPreviousFloodingStorm.equalsIgnoreCase ("Yes") || strPreviousFloodingStorm.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoFoulWaterStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPreviousFloodingStorm.equalsIgnoreCase ("No") || strPreviousFloodingStorm.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPreviousFloodingStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}

			}
		}
		else if ((strPreviousFloodingStorm.equalsIgnoreCase ("Unknown") || strPreviousFloodingStorm.equalsIgnoreCase ("U")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoPreviousFloodingStorm;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("-1"))
				{
					radiobutton.click ();
					break;
				}

			}
		}

	}

	// To randomly selects a Service from Services list and add under Service unavailable list
	public void selectServicesUnavailableStorm ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.lstServicesStorm));

		Select oServices = new Select (orClaimIncidentDetails.lstServicesStorm);

		// Selects a random Service from Services list
		List<WebElement> selections = oServices.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (0, selections.size () - 1);
		oServices.selectByIndex (intIndex);

		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.btnSelectServiceStorm));
		orClaimIncidentDetails.btnSelectServiceStorm.click ();
	}

	// Radio button "Any unauthorised occupants" is selected as per parameter
	// strUnauthorisedOccupants

	public void selectUnauthorisedOccupantsTheft (String strUnauthorisedOccupants)
	{

		if (strUnauthorisedOccupants.equalsIgnoreCase ("Yes") || strUnauthorisedOccupants.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoUnauthorisedOccupantsTheft;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strUnauthorisedOccupants.equalsIgnoreCase ("No") || strUnauthorisedOccupants.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoUnauthorisedOccupantsTheft;
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

	// Select random value from "Point of entry" dropdown list

	public void selectPointOfEntryTheft ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlPointOfEntryTheft));

		Select oServices = new Select (orClaimIncidentDetails.ddlPointOfEntryTheft);

		// Selects a random Service from Services list
		List<WebElement> selections = oServices.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oServices.selectByIndex (intIndex);

		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlPointOfEntryTheft));
		orClaimIncidentDetails.ddlPointOfEntryTheft.click ();
	}

	// Select random value from "Point of Exit" dropdown list

	public void selectPointOfExitTheft ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlPointOfExitTheft));

		Select oServices = new Select (orClaimIncidentDetails.ddlPointOfExitTheft);

		// Selects a random Service from Services list
		List<WebElement> selections = oServices.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oServices.selectByIndex (intIndex);

		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlPointOfExitTheft));
		orClaimIncidentDetails.ddlPointOfExitTheft.click ();
	}

	// Select random value from "Point of Exit" dropdown list

	public void selectEntryMethodTheft ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlEntryMethodTheft));

		orClaimIncidentDetails.ddlEntryMethodTheft.click ();
		Select oServices = new Select (orClaimIncidentDetails.ddlEntryMethodTheft);

		// Selects a random Service from Services list
		List<WebElement> selections = oServices.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oServices.selectByIndex (intIndex);
		orClaimIncidentDetails.ddlEntryMethodTheft.click ();
	}

	// Radio button "Security system" is selected as per parameter
	// strUnauthorisedOccupants

	public void selectSecuritySystemTheft (String strSecuritySystem)
	{

		if (strSecuritySystem.equalsIgnoreCase ("Yes") || strSecuritySystem.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoSecuritySystemTheft;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strSecuritySystem.equalsIgnoreCase ("No") || strSecuritySystem.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoSecuritySystemTheft;
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

	// Type date in "Last Activated" field

	public void typeLastActivatedDateTheft (String strLocation)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.dtpLastActivatedDateTheft));
		orClaimIncidentDetails.dtpLastActivatedDateTheft.clear ();
		orClaimIncidentDetails.dtpLastActivatedDateTheft.click ();
		orClaimIncidentDetails.dtpLastActivatedDateTheft.sendKeys (CalenderDate.returnDesiredDate (strLocation, 0, 0, -2));

	}

	// Type time in "Last Activated" field

	public void typeLastActivatedTimeTheft (String strLastActivatedTime)

	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.dtpLastActivatedTimeTheft));
		orClaimIncidentDetails.dtpLastActivatedTimeTheft.click ();
		orClaimIncidentDetails.dtpLastActivatedTimeTheft.sendKeys (strLastActivatedTime);
	}

	// Select random value from "Security System type" dropdown list

	public void selectSecuritySystemTypeTheft ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlSecuritySystemTypeTheft));

		Select oServices = new Select (orClaimIncidentDetails.ddlSecuritySystemTypeTheft);

		// Selects a random Service from Services list
		List<WebElement> selections = oServices.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oServices.selectByIndex (intIndex);

	}

	// Additional methods when "Explosion" claim type is selected

	public void selectFireOrigin ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlFireOrigion));

		Select oFireOrigin = new Select (orClaimIncidentDetails.ddlFireOrigion);

		// Selects a random Service from Services list
		List<WebElement> selections = oFireOrigin.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oFireOrigin.selectByIndex (intIndex);

	}

	public void selectLocation ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlLocation));

		Select oLocation = new Select (orClaimIncidentDetails.ddlLocation);

		// Selects a random Service from Services list
		List<WebElement> selections = oLocation.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oLocation.selectByIndex (intIndex);

	}

	// Additional methods when "Water escape" claim type is selected

	public void selectTypeOfLiquid ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlTypeOfLiquid));

		Select oTypeOfLiquid = new Select (orClaimIncidentDetails.ddlTypeOfLiquid);

		// Selects a random Type Of Liquid from Services list
		List<WebElement> selections = oTypeOfLiquid.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oTypeOfLiquid.selectByIndex (intIndex);

	}

	public void selectOriginatingLocation ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlOriginatingLocation));

		Select oOriginatingLocation = new Select (orClaimIncidentDetails.ddlOriginatingLocation);

		// Selects a random Originating Location from Services list
		List<WebElement> selections = oOriginatingLocation.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oOriginatingLocation.selectByIndex (intIndex);

	}

	public void selectEquipmentLeaking ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlEquipmentLeaking));

		Select oEquipmentLeaking = new Select (orClaimIncidentDetails.ddlEquipmentLeaking);

		// Selects a random Equipment Leaking from Services list
		List<WebElement> selections = oEquipmentLeaking.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oEquipmentLeaking.selectByIndex (intIndex);

	}

	public void selectLeakStopped (String strLeakStopped)
	{

		if (strLeakStopped.equalsIgnoreCase ("Yes") || strLeakStopped.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoLeakingStoppped;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strLeakStopped.equalsIgnoreCase ("No") || strLeakStopped.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimIncidentDetails.rdoLeakingStoppped;
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

	public void selectHeightOfDamage ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimIncidentDetails.ddlHeightOfDamage));

		Select oHeightOfDamage = new Select (orClaimIncidentDetails.ddlHeightOfDamage);

		// Selects a random Height Of Damage from Services list
		List<WebElement> selections = oHeightOfDamage.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oHeightOfDamage.selectByIndex (intIndex);

	}

}
