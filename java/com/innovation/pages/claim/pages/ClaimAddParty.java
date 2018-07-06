package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimAddParty;
import com.innovation.pages.common.objects.OR_ControlPanel;

/**
 * @author Rizwan. This class stores all the locators and methods in Add Party page for Home LOBs.
 *
 */
public class ClaimAddParty
{
	WebDriver			driver;

	// These variables and, getPartyName () and setPartyName () methods below are created so that the name of party being added
	// through this frame could be used on next frame where needed
	String				strPartyFullName	= "";
	String				strFirstName;
	String				strLastName;
	OR_ClaimAddParty	orClaimAddParty		= null;
	OR_ControlPanel		orControlPanel		= null;

	public String getPartyName ()
	{
		return strPartyFullName;
	}

	public void setPartyName (String strFullName)
	{

		this.strPartyFullName = strFullName;
	}

	public ClaimAddParty (WebDriver driver)
	{
		this.driver = driver;
		orClaimAddParty = PageFactory.initElements (driver, OR_ClaimAddParty.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	public void selectSearchBy (String strSearchBy)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.ddlSearchBy));

		orClaimAddParty.ddlSearchBy.click ();
		orClaimAddParty.ddlSearchBy.sendKeys (strSearchBy);
		orClaimAddParty.ddlSearchBy.click ();
	}

	// Pass first name as parameter to search an existing client
	public void typeFirstNameExist (String strFirstName)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.txtFirstName));

		orClaimAddParty.txtFirstName.click ();
		orClaimAddParty.txtFirstName.sendKeys (strFirstName);
	}

	// Pass last name as parameter to search an existing client
	public void typeLastNameExist (String strLastName)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.txtLastName));

		orClaimAddParty.txtLastName.click ();
		orClaimAddParty.txtLastName.sendKeys (strLastName);
	}

	// Enter a random first name to add a new party
	public void typeFirstNameNew ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.txtFirstName));

		orClaimAddParty.txtFirstName.click ();
		strFirstName = RandomLetters.produceRandomString (6);
		orClaimAddParty.txtFirstName.sendKeys (strFirstName);
	}

	// Enter a random last name to add a new party
	public void typeLastNameNew ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.txtLastName));

		orClaimAddParty.txtLastName.click ();
		strLastName = RandomLetters.produceRandomString (8);
		orClaimAddParty.txtLastName.sendKeys (strLastName);
		// These variables are used to set and get party name through functions at the top of this class
		strPartyFullName = strFirstName + " " + strLastName;
	}

	// Pass Date of Birth as parameter to search an existing client
	public void typeDateOfBirth (String strDOB)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.txtDateOfBirth));

		orClaimAddParty.txtDateOfBirth.click ();
		orClaimAddParty.txtDateOfBirth.sendKeys (strDOB);
	}

	// Pass Company Name as parameter to search an existing client
	public void typeCompanyName (String strCompanyName)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.txtCompanyName));

		orClaimAddParty.txtCompanyName.click ();
		orClaimAddParty.txtCompanyName.sendKeys (strCompanyName);
	}

	// Pass City as parameter to search an existing client
	public void typeCity (String strCity)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.txtCity));

		orClaimAddParty.txtCity.click ();
		orClaimAddParty.txtCity.sendKeys (strCity);
	}

	// Pass Post Code as parameter to search an existing client
	public void typePostCode (String strPostCode)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.txtPostcode));

		orClaimAddParty.txtPostcode.click ();
		orClaimAddParty.txtPostcode.sendKeys (strPostCode);
	}

	// Pass Contact No as parameter to search an existing client
	public void typeContactNo (String strContactNo)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.txtContactNo));

		orClaimAddParty.txtContactNo.click ();
		orClaimAddParty.txtContactNo.sendKeys (strContactNo);
	}

	// Pass Policy No as parameter to search an existing client
	public void typePolicyNo (String strPolicyNo)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.txtPolicyNo));

		orClaimAddParty.txtPolicyNo.click ();
		orClaimAddParty.txtPolicyNo.sendKeys (strPolicyNo);
	}

	// Pass Claim No as parameter to search an existing client
	public void typeClaimNo (String strClaimNo)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.txtClaimNo));

		orClaimAddParty.txtClaimNo.click ();
		orClaimAddParty.txtClaimNo.sendKeys (strClaimNo);
	}

	// Clicks Search button to search client based on name and contact
	public void searchPartyByNameAndContact ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.btnSearchByName));

		orClaimAddParty.btnSearchByName.click ();
		// This waits until the progress bar that displays to load e.g. the address goes invisible
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Clicks Search button to search client based on reference number
	public void searchPartyByReferenceNumber ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.btnSearchByParameter));

		orClaimAddParty.btnSearchByParameter.click ();
		// This waits until the progress bar that displays to load e.g. the address goes invisible
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Clicks Clear button to clear search criteria based on name and contact
	public void clearNameAndContactSearchCriteria ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.btnClearByName));

		orClaimAddParty.btnClearByName.click ();
	}

	// Clicks Clear button to clear search criteria based on reference number
	public void clearReferenceNumberSearchCriteria ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.btnClearByParameter));

		orClaimAddParty.btnClearByParameter.click ();
	}

	// Clicks OK button on Reset pop up that displays on clicking Clear/Cancel button
	public void clickResetOK ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.btnResetOK));

		orClaimAddParty.btnResetOK.click ();
	}

	// Selects a matching record from client search result table
	public void selectPartyFromTable (String strTableName, String strRowText)
	{
		// This waits until Client Search Results table is loaded after search
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.tblClientSearch));

		// Calling function from TableHandler misc class to click on a row in the table based on parameters
		// Pass table id from frame HTML into strTableName parameter. strRowText parameter should be a cell's unique value
		// from search result table to click on.
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.returnRowInTableWithText (strTableName, strRowText);
	}

	public void clickNewEntry ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.btnNewEntry));

		orClaimAddParty.btnNewEntry.click ();
	}

	// Selects Party indicator for a new party
	public void selectPartyIndicatorNew (String strPartyIndicatorNew)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.ddlPartyIndicatorNew));

		orClaimAddParty.ddlPartyIndicatorNew.click ();
		orClaimAddParty.ddlPartyIndicatorNew.sendKeys (strPartyIndicatorNew);
		orClaimAddParty.ddlPartyIndicatorNew.click ();
	}

	// Selects Party indicator for an existing party
	public void selectPartyIndicatorExist (String strPartyIndicatorExist)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.ddlPartyIndicatorExist));

		orClaimAddParty.ddlPartyIndicatorExist.click ();
		orClaimAddParty.ddlPartyIndicatorExist.sendKeys (strPartyIndicatorExist);
		orClaimAddParty.ddlPartyIndicatorExist.click ();
	}

	// Radio button Type is selected as per parameter strTPType; pass value Corporate or Individual
	public void selectTPPartyType (String strTPType)
	{
		if (strTPType.equalsIgnoreCase ("Corporate"))
		{
			List<WebElement> radiobuttons = orClaimAddParty.rdoThirdPartyTypeNew;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("K"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strTPType.equalsIgnoreCase ("Individual"))
		{
			List<WebElement> radiobuttons = orClaimAddParty.rdoThirdPartyTypeNew;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("I"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
	}

	public void typeTPCompanyName (String strTPCompanyName)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.txtTPCompanyNameNew));

		orClaimAddParty.txtTPCompanyNameNew.click ();
		orClaimAddParty.txtTPCompanyNameNew.sendKeys (strTPCompanyName);
	}

	public void selectTitle ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.ddlTitle));

		orClaimAddParty.ddlTitle.click ();
		Select oTitle = new Select (orClaimAddParty.ddlTitleValues);

		// Select a random Title from the returned list
		List<WebElement> selections = oTitle.getOptions ();
		int intIndex = (int) (Math.random () * (selections.size () - 2)) + 2;
		oTitle.selectByIndex (intIndex);
	}

	// Selects sub role for a new party
	public void selectSubRoleNew (String strSubRoleNew)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimAddParty.ddlAbvailableSubRolesNew, strSubRoleNew));

		orClaimAddParty.ddlAbvailableSubRolesNew.click ();
		orClaimAddParty.ddlAbvailableSubRolesNew.sendKeys (strSubRoleNew);
		orClaimAddParty.ddlAbvailableSubRolesNew.click ();
	}

	// Selects sub role for an existing party
	public void selectSubRoleExist (String strSubRoleExist)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.ddlAbvailableSubRolesExist));

		orClaimAddParty.ddlAbvailableSubRolesExist.click ();
		orClaimAddParty.ddlAbvailableSubRolesExist.sendKeys (strSubRoleExist);
		orClaimAddParty.ddlAbvailableSubRolesExist.click ();
	}

	// Clicks on Add button to add selected sub role for the new party
	public void addSubRoleNew ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.btnAddSubRoleNew));

		orClaimAddParty.btnAddSubRoleNew.click ();
	}

	// Clicks on Add button to add selected sub role for an existing party
	public void addSubRoleExist ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.btnAddSubRoleExist));

		orClaimAddParty.btnAddSubRoleExist.click ();
	}

	// Clicks on Add party button for a new party
	public void addPartyNew ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.btnAddPartyNew));

		orClaimAddParty.btnAddPartyNew.click ();
	}

	// Clicks on Add party button for an existing party
	public void addPartyExist ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.btnAddPartyExist));

		orClaimAddParty.btnAddPartyExist.click ();
	}

	// Clicks on Cancel button for a new party
	public void cancelPartyNew ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.btnCancelPartyNew));

		orClaimAddParty.btnCancelPartyNew.click ();
	}

	// Clicks on Cancel button for an existing party
	public void cancelPartyExist ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddParty.btnCancelPartyExist));

		orClaimAddParty.btnCancelPartyExist.click ();
	}

}
