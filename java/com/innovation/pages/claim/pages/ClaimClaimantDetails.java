package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.data.XMLDataReader;
import com.innovation.data.XMLElementCounter;
import com.innovation.misc.CalenderDate;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.pages.claim.objects.OR_ClaimClaimantDetails;
import com.innovation.pages.common.objects.OR_ControlPanel;

/**
 * @author Rizwan. This class stores all the locators and methods in Claimant Details page for Home LOBs.
 *
 */
public class ClaimClaimantDetails
{
	WebDriver				driver;
	String					strZipCode;
	OR_ClaimClaimantDetails	orClaimClaimantDetails	= null;
	OR_ControlPanel			orControlPanel			= null;

	public ClaimClaimantDetails (WebDriver driver)
	{
		this.driver = driver;
		orClaimClaimantDetails = PageFactory.initElements (driver, OR_ClaimClaimantDetails.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	// Methods for fields on Information tab

	public void selectTitle ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlTitle));

		orClaimClaimantDetails.ddlTitle.click ();
		Select oTitle = new Select (orClaimClaimantDetails.ddlTitleValues);

		// Select a random Title from the returned list
		List<WebElement> selections = oTitle.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oTitle.selectByIndex (intIndex);

	}

	public void typeFirstName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtFirstName));

		orClaimClaimantDetails.txtFirstName.click ();
		orClaimClaimantDetails.txtFirstName.sendKeys (RandomLetters.produceRandomString (6));
	}

	public void typeLastName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtLastName));

		orClaimClaimantDetails.txtLastName.click ();
		orClaimClaimantDetails.txtLastName.sendKeys (RandomLetters.produceRandomString (8));
	}

	public void typeNationalInsuranceNumber ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtNationalInsuranceNumber));

		orClaimClaimantDetails.txtNationalInsuranceNumber.click ();
		;
		// key.HOME is used to move the cursor in the start within the field. At
		// present, cursor moves between 2nd and 3rd character.
		orClaimClaimantDetails.txtNationalInsuranceNumber
				.sendKeys (Keys.HOME + RandomLetters.produceRandomString (2) + RandomNumbers.produceRandomNumber (6) + RandomLetters.produceRandomString (1));
	}

	public void selectGender ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlGender));

		orClaimClaimantDetails.ddlGender.click ();
		Select oGender = new Select (orClaimClaimantDetails.ddlGender);

		// Select a random Gender from the returned list
		List<WebElement> selections = oGender.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oGender.selectByIndex (intIndex);
	}

	public void typeDateOfBirth (String strElement, String strNodeDOB, String strXMLFileName)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtDateOfBirth));

		// <dateofbirth1>
		// <dateofbirth>19/03/1974</dateofbirth>
		// </dateofbirth1>
		// dateofbirth1 - strElement
		// dateofbirth - strNode1
		// UKDateOfBirth.xml - strXMLFileName

		orClaimClaimantDetails.txtDateOfBirth.click ();
		XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
		Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodeDOB, strXMLFileName));
		XMLDataReader returnXMLString = new XMLDataReader ();
		orClaimClaimantDetails.txtDateOfBirth.sendKeys (returnXMLString.ReturnXMLNode (strElement + intElement, strNodeDOB, strXMLFileName));

	}

	// Radio button Deceased is selected as per parameter

	public void selectDeceased (String strDeceased)
	{

		if (strDeceased.equalsIgnoreCase ("Yes") || strDeceased.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoDeceased;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strDeceased.equalsIgnoreCase ("No") || strDeceased.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoDeceased;
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

	// Date of Death is set as per parameter strDate. Pass value as 15112017 to
	// enter date 15 Nov 2017.
	// Use this when Deceased is selected Yes
	public void typeDateOfDeath (String strDate)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtDateOfDeath));

		orClaimClaimantDetails.txtDateOfDeath.click ();
		orClaimClaimantDetails.txtDateOfDeath.sendKeys (strDate);
	}

	public void selectSubRole ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlAvailableSubRoles));

		orClaimClaimantDetails.ddlAvailableSubRoles.click ();
		Select oAvailableSubRoles = new Select (orClaimClaimantDetails.ddlAvailableSubRoles);

		// Select a random Sub Role from the returned list

		List<WebElement> selections = oAvailableSubRoles.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oAvailableSubRoles.selectByIndex (intIndex);

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnAddSubRole));
		orClaimClaimantDetails.btnAddSubRole.click ();
	}

	// To randomly remove one of the already selected sub roles.
	public void removeSubRole ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.lstSelectedSubRoles));

		Select oSelectedSubRoles = new Select (orClaimClaimantDetails.lstSelectedSubRoles);

		// Removes a random Sub Role from the returned list
		List<WebElement> selections = oSelectedSubRoles.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (0, selections.size () - 1);
		oSelectedSubRoles.selectByIndex (intIndex);

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnRemoveSubRole));
		orClaimClaimantDetails.btnRemoveSubRole.click ();
	}

	// Radio button Person of Interest is selected as per parameter

	public void selectPersonOfInterest (String strPersonOfInterest)
	{

		if (strPersonOfInterest.equalsIgnoreCase ("Yes") || strPersonOfInterest.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoPersonOfInterest;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPersonOfInterest.equalsIgnoreCase ("No") || strPersonOfInterest.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoPersonOfInterest;
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

	// Radio button Vulnerable Person is selected as per parameter

	public void selectVulnerablePerson (String strVulnerablePerson)
	{

		if (strVulnerablePerson.equalsIgnoreCase ("Yes") || strVulnerablePerson.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoVulnerablePerson;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strVulnerablePerson.equalsIgnoreCase ("No") || strVulnerablePerson.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoVulnerablePerson;
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

	// Radio button Staff Member is selected as per parameter

	public void selectStaffMember (String strStaffMember)
	{

		if (strStaffMember.equalsIgnoreCase ("Yes") || strStaffMember.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoStaffMember;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strStaffMember.equalsIgnoreCase ("No") || strStaffMember.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoStaffMember;
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

	// Radio button VIP is selected as per parameter

	public void selectVIP (String strVIP)
	{

		if (strVIP.equalsIgnoreCase ("Yes") || strVIP.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoVIP;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strVIP.equalsIgnoreCase ("No") || strVIP.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoVIP;
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

	// Radio button Minor is selected as per parameter

	public void selectMinor (String strMinor)
	{

		if (strMinor.equalsIgnoreCase ("Yes") || strMinor.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoMinor;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strMinor.equalsIgnoreCase ("No") || strMinor.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoMinor;
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

	public void selectOccupation ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlOccupation));

		orClaimClaimantDetails.ddlOccupation.click ();
		Select oOccupation = new Select (orClaimClaimantDetails.ddlOccupationValues);

		// Select a random Occupation from the returned list

		List<WebElement> selections = oOccupation.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oOccupation.selectByIndex (intIndex);

	}

	public void selectPreferredLanguage ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlPreferredLanguage));

		orClaimClaimantDetails.ddlPreferredLanguage.click ();
		Select oPLanguage = new Select (orClaimClaimantDetails.ddlPreferredLanguage);

		// Select a random Preferred Language from the returned list

		List<WebElement> selections = oPLanguage.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oPLanguage.selectByIndex (intIndex);

	}

	public void selectBestContactMethod ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlBestContactMethod));

		orClaimClaimantDetails.ddlBestContactMethod.click ();
		Select oBContactMethod = new Select (orClaimClaimantDetails.ddlBestContactMethod);

		// Select a random Best Contact Method from the returned list

		List<WebElement> selections = oBContactMethod.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oBContactMethod.selectByIndex (intIndex);

	}

	public void selectBestContactTime ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlBestContactTime));

		orClaimClaimantDetails.ddlBestContactTime.click ();
		Select oBContactTime = new Select (orClaimClaimantDetails.ddlBestContactTime);

		// Select a random Best Contact Time from the returned list

		List<WebElement> selections = oBContactTime.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oBContactTime.selectByIndex (intIndex);

	}

	public void typeComments ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txaComments));

		orClaimClaimantDetails.txaComments.click ();
		orClaimClaimantDetails.txaComments
				.sendKeys ("Comments are added as random text " + RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	// Radio button VAT Registered is selected as per parameter

	public void selectVATRegistered (String strVATRegistered)
	{

		if (strVATRegistered.equalsIgnoreCase ("Yes") || strVATRegistered.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoVATRegistered;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strVATRegistered.equalsIgnoreCase ("No") || strVATRegistered.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoVATRegistered;
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

	// Radio button Cycle is selected as per parameter

	public void selectCycle (String strCycle)
	{

		if (strCycle.equalsIgnoreCase ("Yes") || strCycle.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoCycle;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strCycle.equalsIgnoreCase ("No") || strCycle.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoCycle;
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

	// Radio button Motorcycle is selected as per parameter

	public void selectMotorcycle (String strMotorcycle)
	{

		if (strMotorcycle.equalsIgnoreCase ("Yes") || strMotorcycle.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoMotorcycle;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strMotorcycle.equalsIgnoreCase ("No") || strMotorcycle.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoMotorcycle;
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

	// Add contact details of type address
	public void addAddress (String strRegion)
	{
		// Click on Add button for Contact Details
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnAddContact));
		orClaimClaimantDetails.btnAddContact.click ();

		// Selects the contact type as Address
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlContactType));
		orClaimClaimantDetails.ddlContactType.click ();
		orClaimClaimantDetails.ddlContactType.sendKeys ("Address");
		orClaimClaimantDetails.ddlContactType.click ();

		if (strRegion.equals ("UK"))
		{
			// Generating a ZIP code and using it for address search
			String strElement = "postcode";
			String strNodePostcode = "postcode";
			String strXMLFileName = "Postcode.xml";
			XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
			Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodePostcode, strXMLFileName));

			XMLDataReader returnXMLString = new XMLDataReader ();
			strZipCode = returnXMLString.ReturnXMLNode (strElement + intElement, strNodePostcode, strXMLFileName);
			orClaimClaimantDetails.txtZipCode.clear ();
			orClaimClaimantDetails.txtZipCode.sendKeys (strZipCode);

			wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.imgZipSearch));
			orClaimClaimantDetails.imgZipSearch.click ();
		}
		else if (strRegion.equals ("USA"))
		{
			// Generating a ZIP code and using it for address search
			String strElement = "zipcode";
			String strNodePostcode = "zipcode";
			String strXMLFileName = "Zipcode.xml";
			XMLElementCounter returnXMLElementCount = new XMLElementCounter ();
			Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodePostcode, strXMLFileName));

			XMLDataReader returnXMLString = new XMLDataReader ();
			strZipCode = returnXMLString.ReturnXMLNode (strElement + intElement, strNodePostcode, strXMLFileName);
			orClaimClaimantDetails.txtZipCode.clear ();
			orClaimClaimantDetails.txtZipCode.sendKeys (strZipCode);

			wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.imgZipSearch));
			orClaimClaimantDetails.imgZipSearch.click ();
		}
		/*
		 * There are three different cases that occur as a result of ZIP code search that are handled here 1- ZIP code search
		 * returns no address - this is covered under first 'if' condition below 2- ZIP code search returns only one address - in
		 * this case address is directly displayed as label and Results dropdown is not displayed - this is covered under 'else if'
		 * condition 3- ZIP code search returns multiple addresses - these addresses are displayed in Results dropdown - 'else'
		 * condition is used to select the first address from the list. Note that Results dropdown displays only in case 1 and 3 and
		 * does not display in case 2. Therefore, the wait condition in the start waits for Results dropdown or single address
		 * label. Whoever appears, control is then transferred to if else conditions.
		 */
		wait.until (ExpectedConditions.or (ExpectedConditions.visibilityOf (orClaimClaimantDetails.lblAddressSelected),
				ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlAddressSearchResults)));

		if (orClaimClaimantDetails.lblAddressSelected.isDisplayed ())
		{

		}
		else
		{
			wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlAddressSearchResults));
			orClaimClaimantDetails.ddlAddressSearchResults.click ();
			try
			{

				orClaimClaimantDetails.ddlAddressSearchResultsValues.click ();
				wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.lblAddressSelected));
			}
			catch (Exception e)
			{
				if (orClaimClaimantDetails.lblAddressSearchError.isDisplayed ())
				{
					System.out.println ("Zip code search returned no address - Either QAS NOT working OR no address associated with the Zip code");

				}
				addAddressManually ();
			}
		}

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlAddressType));
		orClaimClaimantDetails.ddlAddressType.click ();

		Select oAddressType = new Select (orClaimClaimantDetails.ddlAddressType);

		// Select a random Address type from the returned list

		List<WebElement> selections = oAddressType.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oAddressType.selectByIndex (intIndex);
		orClaimClaimantDetails.ddlAddressType.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtAddressFromDate));
		orClaimClaimantDetails.txtAddressFromDate.click ();
		orClaimClaimantDetails.txtAddressFromDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnSaveContact));
		orClaimClaimantDetails.btnSaveContact.click ();

		// This waits until the progress bar that displays to load e.g. the
		// address goes
		// invisible
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void addAddressManually ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.chkManualAddress));
		orClaimClaimantDetails.chkManualAddress.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtAddressLine1));
		orClaimClaimantDetails.txtAddressLine1.sendKeys ("Address Line 1 " + RandomNumbers.produceRandomNumber (3));

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtTown));
		orClaimClaimantDetails.txtTown.sendKeys (RandomLetters.produceRandomString (5));

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlCounty));

		Select oCounty = new Select (orClaimClaimantDetails.ddlCounty);
		List<WebElement> selections = oCounty.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oCounty.selectByIndex (intIndex);

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtPostCode));
		orClaimClaimantDetails.txtPostCode.sendKeys (strZipCode);

	}

	// Add contact details of type email
	public void addEmail (String strRegion)
	{
		// Click on Add button for Contact Details
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnAddContact));
		orClaimClaimantDetails.btnAddContact.click ();

		// Select contact type as Email
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlContactType));
		orClaimClaimantDetails.ddlContactType.click ();
		orClaimClaimantDetails.ddlContactType.sendKeys ("Email");
		orClaimClaimantDetails.ddlContactType.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlEmailType));
		orClaimClaimantDetails.ddlEmailType.click ();
		Select oEmailType = new Select (orClaimClaimantDetails.ddlEmailType);

		// Select a random Email type from the returned list

		List<WebElement> selections = oEmailType.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oEmailType.selectByIndex (intIndex);
		orClaimClaimantDetails.ddlEmailType.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtEmailFromDate));
		orClaimClaimantDetails.txtEmailFromDate.click ();
		orClaimClaimantDetails.txtEmailFromDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));

		orClaimClaimantDetails.txtEmailAddress.sendKeys (RandomLetters.produceRandomString (10) + "@1insurer.com");

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnSaveContact));
		orClaimClaimantDetails.btnSaveContact.click ();

		// This waits until the progress bar that displays to load the email
		// address goes invisible
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Add contact details of type phone/fax
	public void addPhoneFax (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnAddContact));
		orClaimClaimantDetails.btnAddContact.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlContactType));
		orClaimClaimantDetails.ddlContactType.click ();
		orClaimClaimantDetails.ddlContactType.sendKeys ("Telephone/fax");
		orClaimClaimantDetails.ddlContactType.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlPhoneType));
		orClaimClaimantDetails.ddlPhoneType.click ();
		Select oPhoneType = new Select (orClaimClaimantDetails.ddlPhoneType);

		// Select a random Phone type from the returned list
		List<WebElement> selections = oPhoneType.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oPhoneType.selectByIndex (intIndex);
		orClaimClaimantDetails.ddlPhoneType.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtPhoneFromDate));
		orClaimClaimantDetails.txtPhoneFromDate.click ();
		orClaimClaimantDetails.txtPhoneFromDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtPhoneCode));
		orClaimClaimantDetails.txtPhoneCode.click ();
		orClaimClaimantDetails.txtPhoneCode.sendKeys (RandomNumbers.produceRandomNumber (2));

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtPhoneNumber));
		orClaimClaimantDetails.txtPhoneNumber.click ();
		orClaimClaimantDetails.txtPhoneNumber.sendKeys (RandomNumbers.produceRandomNumber (9));

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtPhoneExt));
		orClaimClaimantDetails.txtPhoneExt.click ();
		orClaimClaimantDetails.txtPhoneExt.sendKeys (RandomNumbers.produceRandomNumber (3));

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnSaveContact));
		orClaimClaimantDetails.btnSaveContact.click ();

		// This waits until the progress bar that displays to load the phone
		// number goes invisible
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Add bank account details
	public void addBankAccount (String strAccountNo, String strSortCode)
	{
		// Click on Add button for Account Details
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnAddAccount));
		orClaimClaimantDetails.btnAddAccount.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlAccountType));
		orClaimClaimantDetails.ddlAccountType.click ();
		orClaimClaimantDetails.ddlAccountType.sendKeys ("Bank Account");
		orClaimClaimantDetails.ddlAccountType.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.chkDefaultAccount));
		orClaimClaimantDetails.chkDefaultAccount.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtAccountNo));
		orClaimClaimantDetails.txtAccountNo.click ();
		orClaimClaimantDetails.txtAccountNo.sendKeys (strAccountNo);

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtSortCode));
		orClaimClaimantDetails.txtSortCode.click ();
		orClaimClaimantDetails.txtSortCode.sendKeys (strSortCode);

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnSaveAccount));
		orClaimClaimantDetails.btnSaveAccount.click ();

		// This waits until the progress bar that displays to validate account
		// goes invisible
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

		// This closes the Bank account validation pop up

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnAccountValidationClose));
		orClaimClaimantDetails.btnAccountValidationClose.click ();

		String strVerified = orClaimClaimantDetails.imgVerified.getAttribute ("src");

		if (strVerified.contains ("Incomplete.png"))
		{
			System.out.println ("Bank account validation failed against the provided account details.");
			orClaimClaimantDetails.chkOverride.click ();
		}

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnSaveAccount));
		orClaimClaimantDetails.btnSaveAccount.click ();

		// This waits until the progress bar that displays to load the account
		// details goes invisible

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	// Add credit card details
	public void addCreditCard (String strCardType, String strCardNumber, String strExpiryMonth, String strExpiryYear)
	{

		// Click on Add button for Account Details
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnAddAccount));
		orClaimClaimantDetails.btnAddAccount.click ();

		// Selecting account type as credit card account
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlAccountType));
		orClaimClaimantDetails.ddlAccountType.click ();
		orClaimClaimantDetails.ddlAccountType.sendKeys ("Credit Card Account");
		orClaimClaimantDetails.ddlAccountType.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.chkDefaultAccount));
		orClaimClaimantDetails.chkDefaultAccount.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnAccountAdd));

		// Control moves into Cybersource application
		orClaimClaimantDetails.btnAccountAdd.click ();
		addCybersourceDetails (strCardType, strCardNumber, strExpiryMonth, strExpiryYear);
	}

	// Add credit card details
	public void addCybersourceDetails (String strCardType, String strCardNumber, String strExpiryMonth, String strExpiryYear)
	{

		SeleniumWaiter seleniumwaiter = new SeleniumWaiter (driver);
		seleniumwaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtCardNumber));

		// Pass Visa or Mastercard to select respective card type in strCardType
		// parameter
		if (strCardType.equalsIgnoreCase ("Visa") || strCardType.equalsIgnoreCase ("V"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoCardType;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("001"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strCardType.equalsIgnoreCase ("Mastercard") || strCardType.equalsIgnoreCase ("M")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoCardType;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("002"))
				{
					radiobutton.click ();
					break;
				}

			}
		}

		// Entering card number based on parameter value. Card number value
		// should be as
		// per selected card type.

		// Used 4111111111111111 for Visa card and 5555555555554444 for Master
		// card
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txtCardNumber));
		orClaimClaimantDetails.txtCardNumber.click ();
		orClaimClaimantDetails.txtCardNumber.sendKeys (strCardNumber);

		// Selecting expiry month of card based on parameter value. Month value
		// is 01,
		// 02, ...., 12
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlExpiryMonth));
		orClaimClaimantDetails.ddlExpiryMonth.click ();
		orClaimClaimantDetails.ddlExpiryMonth.sendKeys (strExpiryMonth);
		orClaimClaimantDetails.ddlExpiryMonth.click ();

		// Selecting expiry years of card based on parameter value. Year values
		// are
		// 2017, 2018, 2019....
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlExpiryYear));
		orClaimClaimantDetails.ddlExpiryYear.click ();
		orClaimClaimantDetails.ddlExpiryYear.sendKeys (strExpiryYear);
		orClaimClaimantDetails.ddlExpiryYear.click ();

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnNext));
		orClaimClaimantDetails.btnNext.click ();

		// Finishing adding details in Cybersource and moving back into 1Insurer
		// application
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnFinish));
		orClaimClaimantDetails.btnFinish.click ();

		// This waits until Account Details table stale after coming back into
		// 1Insuer
		wait.until (ExpectedConditions.stalenessOf (orClaimClaimantDetails.tblAccountDetails));

	}

	// Methods for fields on Claim tab

	public void selectClaimTab ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.tabClaim));
		orClaimClaimantDetails.tabClaim.click ();
	}

	// Radio button VAT Registered is selected as per parameter

	public void selectPropertyDamage (String strPropertyDamage)
	{

		if (strPropertyDamage.equalsIgnoreCase ("Yes") || strPropertyDamage.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoPropertyDamage;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPropertyDamage.equalsIgnoreCase ("No") || strPropertyDamage.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoPropertyDamage;
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

	// Radio button Subrogation Opportunity is selected as per parameter

	public void selectSubrogationOpportunity (String strSubroOpportunity)
	{

		if (strSubroOpportunity.equalsIgnoreCase ("Yes") || strSubroOpportunity.equalsIgnoreCase ("Y"))
		{

			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoSubrogationOpportunity;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}

		}
		else if ((strSubroOpportunity.equalsIgnoreCase ("No") || strSubroOpportunity.equalsIgnoreCase ("N")))
		{

			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoSubrogationOpportunity;
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

	public void typeSubrogationReason ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txaSubrogationReason));

		orClaimClaimantDetails.txaSubrogationReason.click ();
		orClaimClaimantDetails.txaSubrogationReason.sendKeys ("Subrogation opportunity reason is added as random text " +
			RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	// Radio button Proactive Handling is selected as per parameter

	public void selectProactiveHandling (String strProHandling)
	{

		if (strProHandling.equalsIgnoreCase ("Yes") || strProHandling.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoProactiveHandling;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strProHandling.equalsIgnoreCase ("No") || strProHandling.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoProactiveHandling;
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

	// Radio button Animal Injury or Death is selected as per parameter

	public void selectAnimalInjury (String strAnimalInjury)
	{

		if (strAnimalInjury.equalsIgnoreCase ("Yes") || strAnimalInjury.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoAnimalInjury;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strAnimalInjury.equalsIgnoreCase ("No") || strAnimalInjury.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoAnimalInjury;
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

	// Radio button Personal Injury is selected as per parameter

	public void selectPersonalInjury (String strPersonalInjury)
	{

		if (strPersonalInjury.equalsIgnoreCase ("Yes") || strPersonalInjury.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoPersonalInjury;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPersonalInjury.equalsIgnoreCase ("No") || strPersonalInjury.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoPersonalInjury;
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

	// Radio button Medical Attention is selected as per parameter

	public void selectMedicalAttention (String strMedicalAttention)
	{

		if (strMedicalAttention.equalsIgnoreCase ("Yes") || strMedicalAttention.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoMedicalAttention;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strMedicalAttention.equalsIgnoreCase ("No") || strMedicalAttention.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoMedicalAttention;
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

	// Radio button Fatal is selected as per parameter

	public void selectFatal (String strFatal)
	{

		if (strFatal.equalsIgnoreCase ("Yes") || strFatal.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoFatal;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strFatal.equalsIgnoreCase ("No") || strFatal.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoFatal;
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

	// To click on OK button on Confimation pop up. This pop up is displayed
	// only
	// when Fatal radio button is Yes.
	public void clickConfirmOK ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnConfirmOK));
		orClaimClaimantDetails.btnConfirmOK.click ();
	}

	// Radio button Offered Services Rejected is selected as per parameter

	public void selectServicesRejected (String strServicesRejected)
	{

		if (strServicesRejected.equalsIgnoreCase ("Yes") || strServicesRejected.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoServicesRejected;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strServicesRejected.equalsIgnoreCase ("No") || strServicesRejected.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoServicesRejected;
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

	// Radio button Driving for employer is selected as per parameter

	public void selectDrivingForEmployer (String strDrivingForEmployer)
	{

		if (strDrivingForEmployer.equalsIgnoreCase ("Yes") || strDrivingForEmployer.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoDrivingForEmployee;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strDrivingForEmployer.equalsIgnoreCase ("No") || strDrivingForEmployer.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoServicesRejected;
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

	// Radio button Permission given is selected as per parameter

	public void selectPermissionGiven (String strPermissionGiven)
	{

		if (strPermissionGiven.equalsIgnoreCase ("Yes") || strPermissionGiven.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoPermissionGiven;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPermissionGiven.equalsIgnoreCase ("No") || strPermissionGiven.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoPermissionGiven;
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

	// Radio button Seat Belt Worn is selected as per parameter

	public void selectSeatBeltWorn (String strSeatBeltWorn)
	{

		if (strSeatBeltWorn.equalsIgnoreCase ("Yes") || strSeatBeltWorn.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoSeatBeltWorn;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strSeatBeltWorn.equalsIgnoreCase ("No") || strSeatBeltWorn.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoSeatBeltWorn;
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

	// Radio button Convictions is selected as per parameter

	public void selectConvictions (String strConvictions)
	{

		if (strConvictions.equalsIgnoreCase ("Yes") || strConvictions.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoConvictions;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strConvictions.equalsIgnoreCase ("No") || strConvictions.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoConvictions;
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

	// Radio button Medical condition is selected as per parameter

	public void selectMedicalCondition (String strMedicalCondition)
	{

		if (strMedicalCondition.equalsIgnoreCase ("Yes") || strMedicalCondition.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoMedicalConditions;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strMedicalCondition.equalsIgnoreCase ("No") || strMedicalCondition.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoMedicalConditions;
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

	// Radio button Vehicle Damage is selected as per parameter

	public void selectVehicleDamage (String strVehicleDamage)
	{

		if (strVehicleDamage.equalsIgnoreCase ("Yes") || strVehicleDamage.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoVehicleDamage;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strVehicleDamage.equalsIgnoreCase ("No") || strVehicleDamage.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoVehicleDamage;
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

	// Radio button Alcohol Drug Invovled is selected as per parameter

	public void selectAlcoholDrugInvolved (String strAlcoholDrugInvolved)
	{

		if (strAlcoholDrugInvolved.equalsIgnoreCase ("Yes") || strAlcoholDrugInvolved.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoAlcoholDrugInvovled;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strAlcoholDrugInvolved.equalsIgnoreCase ("No") || strAlcoholDrugInvolved.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimantDetails.rdoAlcoholDrugInvovled;
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

	public void typeAdditionalInfo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txaAdditionalInfo));

		orClaimClaimantDetails.txaAdditionalInfo.click ();
		orClaimClaimantDetails.txaAdditionalInfo.sendKeys (
				"Additional information is added as random text " + RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	// Methods for fields on Injury questionnaire tab

	public void selectInjuryQuestionnaireTab ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.tabInjuryQuestionnaire));
		orClaimClaimantDetails.tabInjuryQuestionnaire.click ();
	}

	public void selectExtentOfInjry ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlExtentofInjry));

		Select oExtentofInjry = new Select (orClaimClaimantDetails.ddlExtentofInjry);

		List<WebElement> selections = oExtentofInjry.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oExtentofInjry.selectByIndex (intIndex);

	}

	public void selectTimeOffWork ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlTimeOffWork));

		Select oTimeOffWork = new Select (orClaimClaimantDetails.ddlTimeOffWork);

		List<WebElement> selections = oTimeOffWork.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oTimeOffWork.selectByIndex (intIndex);

	}

	public void typeTimeOffWorkDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txaTimeOffWorkDetails));

		orClaimClaimantDetails.txaTimeOffWorkDetails.click ();
		orClaimClaimantDetails.txaTimeOffWorkDetails.sendKeys (
				"Time Off Work Details are added as random text " + RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	public void selectImpactOnSocialLife ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.ddlImpactOnSocialLife));

		Select oImpactOnSocialLife = new Select (orClaimClaimantDetails.ddlImpactOnSocialLife);

		List<WebElement> selections = oImpactOnSocialLife.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oImpactOnSocialLife.selectByIndex (intIndex);

	}

	public void typeImpactOnSocialLifeDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.txaImpactOnSocialLifeDetails));

		orClaimClaimantDetails.txaImpactOnSocialLifeDetails.click ();
		orClaimClaimantDetails.txaImpactOnSocialLifeDetails.sendKeys ("Impact On Social Life Details are added as random text " +
			RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	public void clickSaveInjuryQuestion ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnSaveInjuryQuestion));
		orClaimClaimantDetails.btnSaveInjuryQuestion.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	// Methods to add an Associated party

	public void selectAssociatedPartiesTab ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.tabAssocaitedParties));
		orClaimClaimantDetails.tabAssocaitedParties.click ();
	}

	public void clickSearchAssociatedParty ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnSearchAssociatedParty));
		orClaimClaimantDetails.btnSearchAssociatedParty.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	public void clickSaveAndProceed ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimantDetails.btnSaveAndProceed));
		orClaimClaimantDetails.btnSaveAndProceed.click ();

	}

}
