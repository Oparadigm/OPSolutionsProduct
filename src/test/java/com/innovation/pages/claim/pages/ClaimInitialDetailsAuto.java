package com.innovation.pages.claim.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.data.XMLDataReader;
import com.innovation.data.XMLElementCounter;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.RandomNumbers;
import com.innovation.pages.claim.objects.OR_ClaimInitialDetailsAuto;

/**
 * @author alamq&Rizwan. This class stores all the locators and methods in Initial Details page for Auto LOB.
 *
 */
public class ClaimInitialDetailsAuto
{
	WebDriver					driver;
	String						strZipCode;
	OR_ClaimInitialDetailsAuto	orClaimInitialDetailsAuto	= null;

	public ClaimInitialDetailsAuto (WebDriver driver)
	{
		this.driver = driver;
		orClaimInitialDetailsAuto = PageFactory.initElements (driver, OR_ClaimInitialDetailsAuto.class);
	}

	public void selectReportedBy (String strReportedBy)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.ddlReportedBy));

		orClaimInitialDetailsAuto.ddlClaimType.click ();
		Select oReportedBy = new Select (orClaimInitialDetailsAuto.ddlReportedBy);
		oReportedBy.selectByVisibleText (strReportedBy);
	}

	public void selectTitle ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.ddlTitle));

		orClaimInitialDetailsAuto.ddlTitle.click ();
		Select oTitle = new Select (orClaimInitialDetailsAuto.ddlTitle);

		// Select a random Title from the returned list
		List<WebElement> selections = oTitle.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oTitle.selectByIndex (index);
	}

	public void typeFirstName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.txtFirstName));

		orClaimInitialDetailsAuto.txtFirstName.click ();
		orClaimInitialDetailsAuto.txtFirstName.sendKeys (RandomLetters.produceRandomString (6));
	}

	public void typeLastName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.txtLastName));

		orClaimInitialDetailsAuto.txtLastName.click ();
		orClaimInitialDetailsAuto.txtLastName.sendKeys (RandomLetters.produceRandomString (8));
	}

	public void selectAreaCode ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.ddlPhoneAreaCode));

		orClaimInitialDetailsAuto.ddlPhoneAreaCode.click ();
		Select oPhoneAreaCode = new Select (orClaimInitialDetailsAuto.ddlPhoneAreaCode);

		// Select a random Phone Area Code from the returned list
		List<WebElement> selections = oPhoneAreaCode.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oPhoneAreaCode.selectByIndex (index);
	}

	public void typePhoneNumber ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.txtPhoneNumber));

		orClaimInitialDetailsAuto.txtPhoneNumber.click ();
		orClaimInitialDetailsAuto.txtPhoneNumber.sendKeys (RandomNumbers.produceRandomNumber (9));
	}

	public void typePhoneExt ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.txtPhoneExt));

		orClaimInitialDetailsAuto.txtPhoneExt.click ();
		orClaimInitialDetailsAuto.txtPhoneExt.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void selectBestContactTime ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.ddlBestContactTime));

		orClaimInitialDetailsAuto.ddlBestContactTime.click ();
		Select oBestContactTime = new Select (orClaimInitialDetailsAuto.ddlBestContactTime);

		// Select a random Best Contact Type from the returned list
		List<WebElement> selections = oBestContactTime.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oBestContactTime.selectByIndex (index);
	}

	public void selectClaimType (String strClaimType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.ddlClaimType));

		orClaimInitialDetailsAuto.ddlClaimType.click ();
		Select oClaimType = new Select (orClaimInitialDetailsAuto.ddlClaimType);
		oClaimType.selectByVisibleText (strClaimType);
	}

	public void selectIncidentCause (String strIncidentCause)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.ddlIncidentCause));

		if (strIncidentCause.equalsIgnoreCase ("Random"))
		{
			orClaimInitialDetailsAuto.ddlIncidentCause.click ();
			Select oIncidentCause = new Select (orClaimInitialDetailsAuto.ddlIncidentCauseValues);

			// Selects a random Further Details value from the returned list
			List<WebElement> selections = oIncidentCause.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oIncidentCause.selectByIndex (intIndex);
		}
		else
		{
			orClaimInitialDetailsAuto.ddlIncidentCause.click ();

			Select oIncidentCause = new Select (orClaimInitialDetailsAuto.ddlIncidentCauseValues);
			oIncidentCause.selectByVisibleText (strIncidentCause);

		}
	}

	public void typeIncidentTime ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.txtIncidentTime));

		orClaimInitialDetailsAuto.txtIncidentTime.clear ();
		orClaimInitialDetailsAuto.txtIncidentTime.click ();
		String strIncidentHour;
		String strNotificationTime = orClaimInitialDetailsAuto.txtNotificationTime.getAttribute ("value");
		String strNotificationHour = StringUtils.substring (strNotificationTime, 0, 2);
		int intNotificationHour = Integer.parseInt (strNotificationHour);
		if (intNotificationHour > 1)
		{
			intNotificationHour = intNotificationHour - 1;
			if (intNotificationHour < 10)
			{
				strIncidentHour = Integer.toString (intNotificationHour);
				orClaimInitialDetailsAuto.txtIncidentTime.sendKeys (Keys.HOME + "0" + strIncidentHour + ":00");
			}
			else
			{
				strIncidentHour = Integer.toString (intNotificationHour);
				orClaimInitialDetailsAuto.txtIncidentTime.sendKeys (Keys.HOME + strIncidentHour + ":00");
			}
		}
		else
		{
			orClaimInitialDetailsAuto.txtIncidentTime.sendKeys (Keys.HOME + "00:00");
		}
	}

	public void typeIncidentDescription ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.txaLossDescription));

		orClaimInitialDetailsAuto.txaLossDescription.click ();
		orClaimInitialDetailsAuto.txaLossDescription.sendKeys (
				"Incident description is added as random text " + RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	public void typeReferenceNumber ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.txtReferenceNumber));

		orClaimInitialDetailsAuto.txtReferenceNumber.click ();
		orClaimInitialDetailsAuto.txtReferenceNumber.sendKeys (RandomLetters.produceRandomString (3) + RandomNumbers.produceRandomNumber (9));
	}

	public void typeZIPCode (String strRegionValue)
	{

		if (strRegionValue.equals ("UK"))
		{
			String strElement = "postcode";
			String strNodePostcode = "postcode";
			String strXMLFileName = "Postcode.xml";

			XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
			Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodePostcode, strXMLFileName));

			XMLDataReader returnXMLString = new XMLDataReader ();
			strZipCode = returnXMLString.ReturnXMLNode (strElement + intElement, strNodePostcode, strXMLFileName);
			orClaimInitialDetailsAuto.txtZipCode.clear ();
			orClaimInitialDetailsAuto.txtZipCode.sendKeys (strZipCode);
			orClaimInitialDetailsAuto.txtZipCode.sendKeys (Keys.TAB);
		}
		else if (strRegionValue.equals ("USA"))
		{
			String strElement = "zipcode";
			String strNodePostcode = "zipcode";
			String strXMLFileName = "zipcode.xml";

			XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
			Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodePostcode, strXMLFileName));

			XMLDataReader returnXMLString = new XMLDataReader ();
			strZipCode = returnXMLString.ReturnXMLNode (strElement + intElement, strNodePostcode, strXMLFileName);
			orClaimInitialDetailsAuto.txtZipCode.clear ();
			orClaimInitialDetailsAuto.txtZipCode.sendKeys (strZipCode);
			orClaimInitialDetailsAuto.txtZipCode.sendKeys (Keys.TAB);

		}
	}

	public void clickZipCodeSearchIcon ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.imgZipSearch));

		orClaimInitialDetailsAuto.imgZipSearch.click ();
	}

	/*
	 * There are three different cases that occur as a result of ZIP code search that are handled here 1- ZIP code search returns no
	 * address - this is covered under first 'if' condition below 2- ZIP code search returns only one address - in this case address
	 * is directly displayed as label and Results dropdown is not displayed - this is covered under 'else if' condition 3- ZIP code
	 * search returns multiple addresses - these addresses are displayed in Results dropdown - 'else' condition is used to select
	 * the first address from the list. Note that Results dropdown displays only in case 1 and 3 and does not display in case 2.
	 * Therefore, the wait condition in the start waits for Results dropdown or single address label. Whoever appears, control is
	 * then transferred to if else conditions.
	 */
	public void selectAddress ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.or (ExpectedConditions.visibilityOf (orClaimInitialDetailsAuto.lblAddressSelected),
				ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.ddlAddressSearchResults)));

		if (orClaimInitialDetailsAuto.lblAddressSelected.isDisplayed ())
		{

		}
		else
		{
			wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.ddlAddressSearchResults));
			orClaimInitialDetailsAuto.ddlAddressSearchResults.click ();
			try
			{
				orClaimInitialDetailsAuto.ddlAddressSearchResultsValues.click ();
				wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.lblAddressSelected));
			}
			catch (Exception e)
			{
				if (orClaimInitialDetailsAuto.lblAddressSearchError.isDisplayed ())
				{
					System.out.println ("Zip code search returned no address - Either QAS NOT working OR no address associated with the Zip code");

				}
				addAddressManually ();
			}
		}
	}

	public void addAddressManually ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.chkManualAddress));
		orClaimInitialDetailsAuto.chkManualAddress.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.txtAddressLine1));
		orClaimInitialDetailsAuto.txtAddressLine1.sendKeys ("Address Line 1 " + RandomNumbers.produceRandomNumber (3));

		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.txtTown));
		orClaimInitialDetailsAuto.txtTown.sendKeys (RandomLetters.produceRandomString (5));

		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.ddlCounty));

		Select oCounty = new Select (orClaimInitialDetailsAuto.ddlCounty);
		List<WebElement> selections = oCounty.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oCounty.selectByIndex (intIndex);

		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.txtPostCode));
		orClaimInitialDetailsAuto.txtPostCode.sendKeys (strZipCode);

	}

	public void typeLocationDescription ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.txaLocationDescription));

		orClaimInitialDetailsAuto.txaLocationDescription.click ();
		orClaimInitialDetailsAuto.txaLocationDescription.sendKeys (
				"Location description is added as random text " + RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	public void clickSaveAndProceed ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetailsAuto.btnSaveAndProceed));
		orClaimInitialDetailsAuto.btnSaveAndProceed.click ();
	}

}
