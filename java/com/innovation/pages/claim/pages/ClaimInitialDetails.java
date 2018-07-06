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
import com.innovation.misc.LoggingControl;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.RandomNumbers;
import com.innovation.pages.claim.objects.OR_ClaimInitialDetails;

/**
 * @author Rizwan. This class stores all the locators and methods in Initial Details page for Home/Auto LOBs.
 *
 */
public class ClaimInitialDetails
{
	WebDriver				driver;
	String					strZipCode;
	LoggingControl			loggingcontrol			= new LoggingControl ();
	String					strIncidentTime;

	OR_ClaimInitialDetails	orClaimInitialDetails	= null;

	public String getIncidentTime ()
	{
		return strIncidentTime;
	}

	public void setIncidentTime (String strIncidentTime)
	{
		this.strIncidentTime = strIncidentTime;
	}

	public ClaimInitialDetails (WebDriver driver)
	{
		this.driver = driver;
		orClaimInitialDetails = PageFactory.initElements (driver, OR_ClaimInitialDetails.class);
	}

	public void selectReportedBy ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.ddlReportedBy));

		orClaimInitialDetails.ddlReportedBy.click ();
		Select oReportedBy = new Select (orClaimInitialDetails.ddlReportedBy);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oReportedBy.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oReportedBy.selectByIndex (index);
	}

	public void selectTitle ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.ddlTitle));

		orClaimInitialDetails.ddlTitle.click ();
		Select oTitle = new Select (orClaimInitialDetails.ddlTitle);

		// Select a random Title from the returned list
		List<WebElement> selections = oTitle.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oTitle.selectByIndex (index);
	}

	public void typeFirstName ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.txtFirstName));

		orClaimInitialDetails.txtFirstName.click ();
		orClaimInitialDetails.txtFirstName.sendKeys (RandomLetters.produceRandomString (6));
	}

	public void typeLastName ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.txtLastName));

		orClaimInitialDetails.txtLastName.click ();
		orClaimInitialDetails.txtLastName.sendKeys (RandomLetters.produceRandomString (8));
	}

	public void selectAreaCode (String strRegionValue)
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		if (strRegionValue.equals ("UK"))
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.ddlPhoneAreaCode));

			orClaimInitialDetails.ddlPhoneAreaCode.click ();
			Select oAreaCode = new Select (orClaimInitialDetails.ddlPhoneAreaCode);
			oAreaCode.selectByVisibleText ("44");

		}

		else if (strRegionValue.equals ("USA"))
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.ddlPhoneAreaCode));

			orClaimInitialDetails.ddlPhoneAreaCode.click ();
			Select oAreaCode = new Select (orClaimInitialDetails.ddlPhoneAreaCode);
			oAreaCode.selectByVisibleText ("1");
		}
		
	}

	public void typePhoneNumber ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.txtPhoneNumber));

		orClaimInitialDetails.txtPhoneNumber.click ();
		orClaimInitialDetails.txtPhoneNumber.sendKeys (RandomNumbers.produceRandomNumber (9));
	}

	public void typePhoneExt ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.txtPhoneExt));

		orClaimInitialDetails.txtPhoneExt.click ();
		orClaimInitialDetails.txtPhoneExt.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void selectBestContactTime ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.ddlBestContactTime));

		orClaimInitialDetails.ddlBestContactTime.click ();
		Select oBestContactTime = new Select (orClaimInitialDetails.ddlBestContactTime);

		// Select a random Best Contact Type from the returned list
		List<WebElement> selections = oBestContactTime.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oBestContactTime.selectByIndex (index);
	}

	public void selectClaimType (String strClaimType)
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.ddlClaimType));

		orClaimInitialDetails.ddlClaimType.click ();
		Select oClaimType = new Select (orClaimInitialDetails.ddlClaimTypeValues);
		oClaimType.selectByVisibleText (strClaimType);
	}

	public void selectIncidentCause ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.ddlIncidentCause));

		orClaimInitialDetails.ddlIncidentCause.click ();
		Select oIncidentCause = new Select (orClaimInitialDetails.ddlIncidentCauseValues);

		// Select a random Incident Cause from the returned list
		List<WebElement> selections = oIncidentCause.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oIncidentCause.selectByIndex (index);
	}

	// Incident time is calculated based on Notification time. The hour value in
	// Notification time is taken and reduced by 1. Then
	// the hour value along with '00' minute is added as Incident time.
	public void typeIncidentTime ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.txtIncidentTime));

		orClaimInitialDetails.txtIncidentTime.click ();
		String strIncidentHour;
		String strNotificationTime = orClaimInitialDetails.txtNotificationTime.getAttribute ("value");
		String strNotificationHour = StringUtils.substring (strNotificationTime, 0, 2);
		int intNotificationHour = Integer.parseInt (strNotificationHour);
		if (intNotificationHour > 1)
		{
			intNotificationHour = intNotificationHour - 1;
			if (intNotificationHour < 10)
			{
				strIncidentHour = Integer.toString (intNotificationHour);
				orClaimInitialDetails.txtIncidentTime.sendKeys ("0" + strIncidentHour + ":00");
			}
			else
			{
				strIncidentHour = Integer.toString (intNotificationHour);
				orClaimInitialDetails.txtIncidentTime.sendKeys (strIncidentHour + ":00");
			}
		}
		else
		{
			orClaimInitialDetails.txtIncidentTime.sendKeys ("00:00");
		}
		strIncidentTime = orClaimInitialDetails.txtIncidentTime.getAttribute ("value");
	}

	// No is selected from Severe loss radio button
	public void selectSeverLoss ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.rdoSevereLoss));

		orClaimInitialDetails.rdoSevereLoss.click ();
	}

	public void typeIncidentDescription ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.txaLossDescription));

		orClaimInitialDetails.txaLossDescription.click ();
		orClaimInitialDetails.txaLossDescription.sendKeys (
				"Incident description is added as random text " + RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	public void typeReferenceNumber ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.txtReferenceNumber));

		orClaimInitialDetails.txtReferenceNumber.click ();
		orClaimInitialDetails.txtReferenceNumber.sendKeys (RandomLetters.produceRandomString (3) + RandomNumbers.produceRandomNumber (9));
	}

	public void typeZIPCode (String strRegionValue)
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		if (strRegionValue.equals ("UK"))
		{
			String strElement = "postcode";
			String strNodePostcode = "postcode";
			String strXMLFileName = "Postcode.xml";

			XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
			Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodePostcode, strXMLFileName));

			XMLDataReader returnXMLString = new XMLDataReader ();
			strZipCode = returnXMLString.ReturnXMLNode (strElement + intElement, strNodePostcode, strXMLFileName);
			orClaimInitialDetails.txtZipCode.clear ();
			orClaimInitialDetails.txtZipCode.sendKeys (strZipCode);
			// Trying tab to make sure data is set correctly.
			orClaimInitialDetails.txtZipCode.sendKeys (Keys.TAB);

		}

		else if (strRegionValue.equals ("USA"))
		{
			String strElement = "zipcode";
			String strNodePostcode = "zipcode";
			String strXMLFileName = "Zipcode.xml";

			XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
			Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodePostcode, strXMLFileName));

			XMLDataReader returnXMLString = new XMLDataReader ();
			strZipCode = returnXMLString.ReturnXMLNode (strElement + intElement, strNodePostcode, strXMLFileName);
			orClaimInitialDetails.txtZipCode.clear ();
			orClaimInitialDetails.txtZipCode.sendKeys (strZipCode);
			// Trying tab to make sure data is set correctly.
			orClaimInitialDetails.txtZipCode.sendKeys (Keys.TAB);
		}
	}

	public void clickZipCodeSearchIcon ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.imgZipSearch));

		orClaimInitialDetails.imgZipSearch.click ();
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

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.or (ExpectedConditions.visibilityOf (orClaimInitialDetails.lblAddressSelected),
				ExpectedConditions.elementToBeClickable (orClaimInitialDetails.ddlAddressSearchResults)));

		if (orClaimInitialDetails.lblAddressSelected.isDisplayed ())
		{

		}
		else
		{
			wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.ddlAddressSearchResults));
			orClaimInitialDetails.ddlAddressSearchResults.click ();
			try
			{

				orClaimInitialDetails.ddlAddressSearchResultsValues.click ();
				wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.lblAddressSelected));
			}
			catch (Exception e)
			{
				if (orClaimInitialDetails.lblAddressSearchError.isDisplayed ())
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

		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.chkManualAddress));
		orClaimInitialDetails.chkManualAddress.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.txtAddressLine1));
		orClaimInitialDetails.txtAddressLine1.sendKeys ("Address Line 1 " + RandomNumbers.produceRandomNumber (3));

		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.txtTown));
		orClaimInitialDetails.txtTown.sendKeys (RandomLetters.produceRandomString (5));

		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.ddlCounty));

		Select oCounty = new Select (orClaimInitialDetails.ddlCounty);
		List<WebElement> selections = oCounty.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oCounty.selectByIndex (intIndex);

		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.txtPostCode));
		orClaimInitialDetails.txtPostCode.sendKeys (strZipCode);

	}

	public void typeLocationDescription ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.txaLocationDescription));

		orClaimInitialDetails.txaLocationDescription.click ();
		orClaimInitialDetails.txaLocationDescription.sendKeys (
				"Location description is added as random text " + RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	public void clickSaveAndProceed ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimInitialDetails.btnSaveAndProceed));
		orClaimInitialDetails.btnSaveAndProceed.click ();
	}

}
