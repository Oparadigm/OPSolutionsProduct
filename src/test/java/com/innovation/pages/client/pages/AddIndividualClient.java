/**
 * 
 */
package com.innovation.pages.client.pages;

import java.util.List;

import org.openqa.selenium.By;
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
import com.innovation.pages.client.objects.OR_AddIndividualClient;

/**
 * @author lushs This class will store all the locators and methods of the Add Client page.
 */

public class AddIndividualClient
{

	WebDriver				driver;
	OR_AddIndividualClient	orAddIndividualClient	= null;

	public AddIndividualClient (WebDriver driver)
	{
		this.driver = driver;
		orAddIndividualClient = PageFactory.initElements (driver, OR_AddIndividualClient.class);
	}

	public void selectTitle ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.ddlTitle));

		orAddIndividualClient.ddlTitle.click ();
		Select oTitle = new Select (orAddIndividualClient.ddlTitle);

		// Select a random title from the returned list
		List<WebElement> selections = oTitle.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oTitle.selectByIndex (index);

	}

	public void typeFirstName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.txtFirstName));

		orAddIndividualClient.txtFirstName.click ();
		orAddIndividualClient.txtFirstName.sendKeys (RandomLetters.produceRandomString (6));
	}

	public void typeSurname ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.txtLastName));

		orAddIndividualClient.txtLastName.click ();
		orAddIndividualClient.txtLastName.sendKeys (RandomLetters.produceRandomString (8));
	}

	public void typeEmail ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.txtEmail));

		orAddIndividualClient.txtEmail.click ();
		String emailconcat = RandomLetters.produceRandomString (10) + "@1insurer.com";
		orAddIndividualClient.txtEmail.sendKeys (emailconcat);
	}

	public void typeHomePhoneNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.txtHomePhone));

		orAddIndividualClient.txtHomePhone.click ();
		orAddIndividualClient.txtHomePhone.sendKeys (RandomNumbers.produceRandomNumber (9));
	}

	public void typeZIPCode (String strRegion)
	{

		if (strRegion.equals ("UK"))
		{
			String strElement = "postcode";
			String strNodePostcode = "postcode";
			String strXMLFileName = "Postcode.xml";
			XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
			Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodePostcode, strXMLFileName));
			System.out.println ("The postcode element number is : " + intElement);

			XMLDataReader returnXMLString = new XMLDataReader ();
			orAddIndividualClient.txtZipCode.clear ();
			orAddIndividualClient.txtZipCode.sendKeys (returnXMLString.ReturnXMLNode (strElement + intElement, strNodePostcode, strXMLFileName));

		}
		else if (strRegion.equals ("USA"))
		{
			String strElement = "zipcode";
			String strNodePostcode = "zipcode";
			String strXMLFileName = "Zipcode.xml";
			XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
			Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodePostcode, strXMLFileName));
			System.out.println ("The postcode element number is : " + intElement);

			XMLDataReader returnXMLString = new XMLDataReader ();
			orAddIndividualClient.txtZipCode.clear ();
			orAddIndividualClient.txtZipCode.sendKeys (returnXMLString.ReturnXMLNode (strElement + intElement, strNodePostcode, strXMLFileName));

		}
	}

	public void clickZipCodeSearchIcon ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.imgZipSearchIcon));

		orAddIndividualClient.imgZipSearchIcon.click ();
	}

	public void SearchCriteriaDropDown ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.ddlSearchCriteria));

		orAddIndividualClient.ddlSearchCriteria.click ();
		Select dropdown = new Select (orAddIndividualClient.ddlSearchCriteria);

		// Select a random PostCode from the returned list
		List<WebElement> selections = dropdown.getOptions ();
		int iCnt = selections.size ();
		// System.out.println ("The postcode list size is : " + iCnt);
		// If only one postcode is returned the list is 2 in size (including one blank
		// field) but the Results field is automatically
		// populated
		// As the drop down is no longer in focus the test will fail.
		if (iCnt > 2)
		{
			int index = (int) (Math.random () * (selections.size () - 2)) + 2;
			// System.out.println ("The postcode element to be selected is : " + index);
			dropdown.selectByIndex (index);
		}
		else
		{
			System.out.println ("Only one address line returned : " + iCnt);
		}
	}

	public void typeDOB (String strRegion)
	{

		if (strRegion.equals ("UK"))
		{
			String strElement = "dateofbirth";
			String strNodeDOB = "dateofbirth";
			String strXMLFileName = "UKDateOfBirth.xml";

			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.txtDOB));
			orAddIndividualClient.txtDOB.click ();
			XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
			Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodeDOB, strXMLFileName));
			// System.out.println ("The number is : " + intElement);
			XMLDataReader returnXMLString = new XMLDataReader ();
			orAddIndividualClient.txtDOB.sendKeys (returnXMLString.ReturnXMLNode (strElement + intElement, strNodeDOB, strXMLFileName));

		}

		else if (strRegion.equals ("USA"))
		{
			String strElement = "dateofbirth";
			String strNodeDOB = "dateofbirth";
			String strXMLFileName = "USDateOfBirth.xml";

			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.txtDOB));
			orAddIndividualClient.txtDOB.click ();
			XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
			Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodeDOB, strXMLFileName));
			// System.out.println ("The number is : " + intElement);
			XMLDataReader returnXMLString = new XMLDataReader ();
			orAddIndividualClient.txtDOB.sendKeys (returnXMLString.ReturnXMLNode (strElement + intElement, strNodeDOB, strXMLFileName));

		}

	}

	public void selectGender ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.ddlGender));

		orAddIndividualClient.ddlGender.click ();
		Select oGender = new Select (orAddIndividualClient.ddlGender);

		// Select a random gender from the returned list
		List<WebElement> selections = oGender.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oGender.selectByIndex (index);
	}

	public void selectMaritalStatus ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.ddlMaritalStatus));

		orAddIndividualClient.ddlMaritalStatus.click ();
		Select oMarital = new Select (orAddIndividualClient.ddlMaritalStatus);

		// Select a random marital status from the returned list
		List<WebElement> selections = oMarital.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oMarital.selectByIndex (index);
	}

	// Select the Occuppation of the client **Added by M.Tahir**

	public void selectOccupation ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.ddlClientOccupation));
		orAddIndividualClient.ddlClientOccupation.click ();

		wait.until (ExpectedConditions.visibilityOf (orAddIndividualClient.ddlOccupationList));
		WebElement allOccupationList = driver.findElement (By.xpath ("//*[@id='SC_ClientDetailsMaintain_Occupation']"));
		List<WebElement> allList = allOccupationList.findElements (By.tagName ("option"));
		int intListCount = (int) (Math.random () * (allList.size () - 2)) + 1;

		String strSelectedOccupation = driver.findElement (By.xpath ("//*[@id='SC_ClientDetailsMaintain_Occupation']/option[" + intListCount + "]")).getText ();
		orAddIndividualClient.clientOccupationSearch.sendKeys (strSelectedOccupation);
		driver.findElement (By.xpath ("//span[.='" + strSelectedOccupation + "']")).click ();

	}

	public void selectLanguage (String strRegionValue)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.ddlLanguage));

		orAddIndividualClient.ddlLanguage.click ();
		Select oLanguage = new Select (orAddIndividualClient.ddlLanguage);

		// Select a random language from the returned list

		if (strRegionValue.contains ("UK"))
		{

			oLanguage.selectByVisibleText ("English (UK)");
		}

		else if (strRegionValue.contains ("USA"))
		{
			oLanguage.selectByVisibleText ("English (US)");

		}

	}

	public void clickPrivacyAgreement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.lnkPrivacyAgreement));
		orAddIndividualClient.lnkPrivacyAgreement.click ();

	}

	public void validatePrivacyAgreement ()
	{

		// following string will handle window that will be opened

		// now the following list of the windows will contain how many windows actually
		// open

		String strCurrentWindow = driver.getWindowHandle ();

		for (String strNewWindowHandle : driver.getWindowHandles ())
		{
			driver.switchTo ().window (strNewWindowHandle);
		}

		driver.close ();

		driver.switchTo ().window (strCurrentWindow);

	}

	public void privacyAgreementAcceptance ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orAddIndividualClient.prgProgress));
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.rdoDataProtection));
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.chkMarketingCampaigns));

		orAddIndividualClient.rdoDataProtection.click ();
		orAddIndividualClient.chkMarketingCampaigns.click ();

		wait.until (ExpectedConditions.invisibilityOf (orAddIndividualClient.prgProgress));
	}

	public void clickNext ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orAddIndividualClient.imgNavigationNext));
		orAddIndividualClient.imgNavigationNext.click ();
	}

	public void clickYes ()
	{
		boolean blnIsPresent = driver.findElements (By.id ("igUserInteractResponseYes")).size () > 0;
		if (!blnIsPresent)
		{
			// To Do
		}
		else
		{
			orAddIndividualClient.btnYes.click ();

		}

	}

}
