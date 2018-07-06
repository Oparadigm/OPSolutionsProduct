package com.innovation.pages.client.pages;

import java.util.List;

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
import com.innovation.pages.client.objects.OR_AddCompanyClient;
import com.innovation.pages.policy.objects.OR_PolicyAgentSearch;;

/*
 * @Author Kamran Mahmood	This class will store all the locators and methods of the Add Company Client Screen.
 */

public class AddCompanyClient
{
	WebDriver				driver;
	LoggingControl			loggingcontrol		= new LoggingControl ();
	OR_AddCompanyClient		orAddCompanyClient	= null;
	OR_PolicyAgentSearch	orPolicyAgentSearch	= null;

	public AddCompanyClient (WebDriver driver)
	{
		this.driver = driver;
		orAddCompanyClient = PageFactory.initElements (driver, OR_AddCompanyClient.class);
		orPolicyAgentSearch = PageFactory.initElements (driver, OR_PolicyAgentSearch.class);
	}

	public void typeCompanyName ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyAgentSearch.barProgress));
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtCompanyName));

		orAddCompanyClient.txtCompanyName.click ();
		orAddCompanyClient.txtCompanyName.clear ();
		orAddCompanyClient.txtCompanyName.sendKeys (RandomLetters.produceRandomString (5));

	}

	public void typeHomeEmail ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtHomeEmail));

		orAddCompanyClient.txtHomeEmail.click ();
		String strHomeEmail = RandomLetters.produceRandomString (8) + "@1insurer.com";
		orAddCompanyClient.txtHomeEmail.sendKeys (strHomeEmail);

	}

	public void typeOfficeEmail ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtOfficeEmail));

		orAddCompanyClient.txtOfficeEmail.click ();
		String strOfficeEmail = RandomLetters.produceRandomString (9) + "@1insurer.com";
		orAddCompanyClient.txtOfficeEmail.sendKeys (strOfficeEmail);
	}

	public void selectHomePhoneAreCode (String strHomeAreaCode)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.ddHomePhone));

		orAddCompanyClient.ddHomePhone.click ();
		Select HomeAreacode = new Select (orAddCompanyClient.ddHomePhone);
		HomeAreacode.selectByVisibleText (strHomeAreaCode);

	}

	public void typeHomePhone ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtHomePhone));

		orAddCompanyClient.txtHomePhone.click ();
		orAddCompanyClient.txtHomePhone.sendKeys (RandomNumbers.produceRandomNumber (9));
	}

	public void selectMobilePhoneAreaCode (String strMobileAreaCode)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.ddMobilePhone));

		orAddCompanyClient.ddMobilePhone.click ();
		Select MobileAreacode = new Select (orAddCompanyClient.ddMobilePhone);
		MobileAreacode.selectByVisibleText (strMobileAreaCode);
	}

	public void typeMobilePhone ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtMobilePhone));

		orAddCompanyClient.txtMobilePhone.click ();
		orAddCompanyClient.txtMobilePhone.sendKeys (RandomNumbers.produceRandomNumber (9));
	}

	public void selectOfficePhoneAreaCode (String strOfficeAreaCode)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.ddOfficePhone));

		orAddCompanyClient.ddOfficePhone.click ();
		Select OfficeAreacode = new Select (orAddCompanyClient.ddOfficePhone);
		OfficeAreacode.selectByVisibleText (strOfficeAreaCode);

	}

	public void typeOfficePhone ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtOfficePhone));

		orAddCompanyClient.txtOfficePhone.click ();
		orAddCompanyClient.txtOfficePhone.sendKeys (RandomNumbers.produceRandomNumber (9));

	}

	public void typeOfficePhoneExtension ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtOfficePhoneExtension));

		orAddCompanyClient.txtOfficePhoneExtension.click ();
		orAddCompanyClient.txtOfficePhoneExtension.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void selectFaxNumber (String strFaxAreaCode)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.ddFaxNumber));

		orAddCompanyClient.ddFaxNumber.click ();
		Select FaxAreacode = new Select (orAddCompanyClient.ddFaxNumber);
		FaxAreacode.selectByVisibleText (strFaxAreaCode);
	}

	public void typeFaxNumber ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtFaxNumber));

		orAddCompanyClient.txtFaxNumber.click ();
		orAddCompanyClient.txtFaxNumber.sendKeys (RandomNumbers.produceRandomNumber (9));
	}

	public void typeContactPerson ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtContactPerson));

		orAddCompanyClient.txtContactPerson.click ();
		orAddCompanyClient.txtContactPerson.sendKeys (RandomLetters.produceRandomString (7));
	}

	public void clickNextButton ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.btnFlowNext));

		orAddCompanyClient.btnFlowNext.click ();

	}

	public void clickVATRegistered ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.chkVAT));

		orAddCompanyClient.chkVAT.click ();
	}

	public void clickWithHolding ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.chkWithHolding));

		orAddCompanyClient.chkWithHolding.click ();

	}

	public void selectReferDecline ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.ddReferDecline));

		orAddCompanyClient.ddReferDecline.click ();
		Select oReferDecline = new Select (orAddCompanyClient.ddReferDecline);

		// Select a random ReferDecline from the returned list
		List<WebElement> selections = oReferDecline.getOptions ();
		int intIndex = (int) (Math.random () * (selections.size () - 2)) + 2;
		oReferDecline.selectByIndex (intIndex);

	}

	public void clickCheckBoxPersonOfInterest ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.chkPersonOfInterest));

		orAddCompanyClient.chkPersonOfInterest.click ();

	}

	public void selectIntroductionType ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.ddIntroductionType));

		orAddCompanyClient.ddIntroductionType.click ();
		Select oIntroType = new Select (orAddCompanyClient.ddIntroductionType);

		// Select a random IntroductionType from the returned list
		List<WebElement> selections = oIntroType.getOptions ();
		int intIndex = (int) (Math.random () * (selections.size () - 2)) + 2;
		oIntroType.selectByIndex (intIndex);
	}

	public void selectIntroductionCode ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.ddIntroductionCode));

		orAddCompanyClient.ddIntroductionType.click ();
		Select oIntroCode = new Select (orAddCompanyClient.ddIntroductionCode);

		// Select a random IntroductionCode from the returned list
		List<WebElement> selections = oIntroCode.getOptions ();
		int intIndex = (int) (Math.random () * (selections.size () - 2)) + 2;
		oIntroCode.selectByIndex (intIndex);

	}

	public void clickMareketingResearch ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.chkMarketingResearch));

		orAddCompanyClient.chkMarketingResearch.click ();
	}

	public void clickProductService ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.chkProductService));

		orAddCompanyClient.chkProductService.click ();

	}

	public void selectCountry (String strCountry)
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.ddCountry));

		Select oCountry = new Select (orAddCompanyClient.ddCountry);
		oCountry.selectByVisibleText (strCountry);

	}

	public void clickSearchBy ()
	{
		// Radio button needs to be selected
	}

	public void typeZipCodeToSearch (String strRegion)
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		if (strRegion.equals ("UK"))
		{

			String strElement = "postcode";
			String strNodePostcode = "postcode";
			String strXMLFileName = "Postcode.xml";

			XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
			Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodePostcode, strXMLFileName));
			// System.out.println ("The postcode element number is : " + intElement);

			XMLDataReader returnXMLString = new XMLDataReader ();
			orAddCompanyClient.txtSearchCriteria.clear ();
			orAddCompanyClient.txtSearchCriteria.sendKeys (returnXMLString.ReturnXMLNode (strElement + intElement, strNodePostcode, strXMLFileName));
		}
		else if (strRegion.equals ("USA"))
		{
			String strElement = "zipcode";
			String strNodePostcode = "zipcode";
			String strXMLFileName = "Zipcode.xml";

			XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
			Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodePostcode, strXMLFileName));
			// System.out.println ("The postcode element number is : " + intElement);

			XMLDataReader returnXMLString = new XMLDataReader ();
			orAddCompanyClient.txtSearchCriteria.clear ();
			orAddCompanyClient.txtSearchCriteria.sendKeys (returnXMLString.ReturnXMLNode (strElement + intElement, strNodePostcode, strXMLFileName));
		}

	}

	public void clickImgSearch ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.imgSearchAddress));

		orAddCompanyClient.imgSearchAddress.click ();
	}

	public void selectAddressResults ()
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.ddSearchResults));

		orAddCompanyClient.ddSearchResults.click ();
		Select AddressResults = new Select (orAddCompanyClient.ddSearchResults);

		// Select a random PostCode from the returned list
		List<WebElement> selections = AddressResults.getOptions ();
		int intCount = selections.size ();

		// If only one postcode is returned the list is 2 in size (including one blank field) but the Results field is automatically
		// populated
		// As the drop down is no longer in focus the test will fail.
		if (intCount > 2)
		{
			int intIndex = (int) (Math.random () * (selections.size () - 2)) + 2;
			// System.out.println ("The postcode element to be selected is : " + intIndex);
			AddressResults.selectByIndex (intIndex);
		}
		else
		{
			System.out.println ("Only one address line returned : " + intCount);
		}

	}

	public void clickManualAddress ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.chkManualAddress));
		orAddCompanyClient.chkManualAddress.click ();
	}

	public void typeAddressLine1 ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtAddressLine1));

		orAddCompanyClient.txtAddressLine1.click ();
		orAddCompanyClient.txtAddressLine1.sendKeys (RandomLetters.produceRandomString (7));
	}

	public void typeAddressLine2 ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtAddressLine2));

		orAddCompanyClient.txtAddressLine2.click ();
		orAddCompanyClient.txtAddressLine2.sendKeys (RandomLetters.produceRandomString (5));

	}

	public void typeAddressLine3 ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtAddressLine3));

		orAddCompanyClient.txtAddressLine3.click ();
		orAddCompanyClient.txtAddressLine3.sendKeys (RandomLetters.produceRandomString (4));
	}

	public void typeCity ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtCity));

		orAddCompanyClient.txtCity.click ();
		orAddCompanyClient.txtCity.sendKeys (RandomLetters.produceRandomString (4));

	}

	public void typeCounty ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtStateProvinceCounty));

		orAddCompanyClient.txtStateProvinceCounty.click ();
		orAddCompanyClient.txtStateProvinceCounty.sendKeys (RandomLetters.produceRandomString (9));

	}

	public void typeManualZipCode (String strElement, String strNodePostcode, String strXMLFileName)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddCompanyClient.txtZipPostCode));
		XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
		Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodePostcode, strXMLFileName));
		System.out.println ("The postcode element number is : " + intElement);

		XMLDataReader returnXMLString = new XMLDataReader ();
		orAddCompanyClient.txtSearchCriteria.clear ();
		orAddCompanyClient.txtSearchCriteria.sendKeys (returnXMLString.ReturnXMLNode (strElement + intElement, strNodePostcode, strXMLFileName));

	}

}
