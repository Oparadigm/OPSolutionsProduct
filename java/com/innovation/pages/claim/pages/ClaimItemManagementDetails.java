/**
 * 
 */
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
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimItemManagementDetails;
import com.innovation.pages.common.objects.OR_ControlPanel;

/**
 * @author alamq This class will store all the locators and methods on Item Management Screen
 * 
 *         Rizwan - Updated this class to add functions that appear on Add New Item screen in back office. Functions added are to
 *         click on Clear button, Yes button, No button, 'Move all to item management' button and OK button.
 */

public class ClaimItemManagementDetails
{
	WebDriver						driver;
	String							strCoverageSelected;
	OR_ClaimItemManagementDetails	orClaimItemManagementDetails	= null;
	OR_ControlPanel					orControlPanel					= null;

	public ClaimItemManagementDetails (WebDriver driver)
	{

		this.driver = driver;
		orClaimItemManagementDetails = PageFactory.initElements (driver, OR_ClaimItemManagementDetails.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	// Pass 'Random' in parameter to randomly select a value from Coverage
	// dropdown. Otherwise pass respective value for selection
	public void selectCoverage (String strCoverage)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.ddlCoverage));
		if (strCoverage.equalsIgnoreCase ("Random"))
		{
			orClaimItemManagementDetails.ddlCoverage.click ();
			Select oCoverage = new Select (orClaimItemManagementDetails.ddlCoverage);

			// Select a random Best Contact Type from the returned list
			List<WebElement> selections = oCoverage.getOptions ();
			int index = (int) (Math.random () * (selections.size () - 1)) + 1;
			oCoverage.selectByIndex (index);
			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		}
		else
		{
			orClaimItemManagementDetails.ddlCoverage.click ();
			orClaimItemManagementDetails.ddlCoverage.sendKeys (strCoverage);
			orClaimItemManagementDetails.ddlCoverage.click ();

			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

		}

		Select oCoverage = new Select (orClaimItemManagementDetails.ddlCoverage);
		strCoverageSelected = oCoverage.getFirstSelectedOption ().getText ();

	}

	// Pass 'Random' in parameter to randomly select a value from Item Type
	// dropdown. Otherwise pass respective value for selection
	public void selectItemType (String strItemType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.ddlItemType));

		if (strItemType.equalsIgnoreCase ("Random"))
		{
			orClaimItemManagementDetails.ddlItemType.click ();
			Select oItemType = new Select (orClaimItemManagementDetails.ddlItemTypeValue);

			// Select a random Best Contact Type from the returned list
			List<WebElement> selections = oItemType.getOptions ();
			String strSelectedItemType;
			do
			{
				int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
				oItemType.selectByIndex (intIndex);
				strSelectedItemType = oItemType.getFirstSelectedOption ().getText ();
			} while (strSelectedItemType.equalsIgnoreCase ("Total loss coverage"));
		}
		else
		{
			orClaimItemManagementDetails.ddlItemType.click ();
			Select oItemType = new Select (orClaimItemManagementDetails.ddlItemTypeValue);
			oItemType.selectByVisibleText (strItemType);
		}

	}

	// Pass 'Random' in parameter to randomly select a value from Item
	// dropdown. Otherwise pass respective value for selection
	public void selectItem (String strItem)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.ddlItem));

		if (strItem.equalsIgnoreCase ("Random"))
		{
			orClaimItemManagementDetails.ddlItem.click ();
			Select oItem = new Select (orClaimItemManagementDetails.ddlItem);

			// Select a random Item from the returned list
			List<WebElement> selections = oItem.getOptions ();
			int intIndex = (int) (Math.random () * (selections.size () - 1)) + 1;
			oItem.selectByIndex (intIndex);
		}
		else
		{
			orClaimItemManagementDetails.ddlItem.click ();
			orClaimItemManagementDetails.ddlItem.sendKeys (strItem);
			orClaimItemManagementDetails.ddlItem.click ();

		}

	}

	// Type details in "Item Details" text box

	public void typeItemDetails ()
	{

		orClaimItemManagementDetails.txaItemDetails.sendKeys ("Item Details ADDED A RANDOM TEXT " + RandomLetters.produceRandomString (6));

	}

	// Radio button "Part of a Set" is selected as per parameter strPartOfSet

	public void selectPartOfSet (String strPartOfSet)
	{

		if (strPartOfSet.equalsIgnoreCase ("Yes") || strPartOfSet.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimItemManagementDetails.rdoPartOfSet;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPartOfSet.equalsIgnoreCase ("No") || strPartOfSet.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimItemManagementDetails.rdoPartOfSet;
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

	// Select "Age of Item" drop down

	public void selectItemAge (String strItemAge)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.ddlItemAge));
		orClaimItemManagementDetails.ddlItemAge.click ();
		Select oItemAge = new Select (orClaimItemManagementDetails.ddlItemAge);
		oItemAge.selectByVisibleText (strItemAge);

	}

	// Select "Item(s) Location" drop down

	public void selectItemLocation (String strItemLocation)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.ddlItemLocation));
		orClaimItemManagementDetails.ddlItemLocation.click ();
		Select oItemLocation = new Select (orClaimItemManagementDetails.ddlItemLocation);
		oItemLocation.selectByVisibleText (strItemLocation);

	}

	// Select "Number of Rooms Affected" drop down

	public void selectNumberOfRoom (String strNumberOfRooms)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.ddlNumberOfRooms));
		orClaimItemManagementDetails.ddlNumberOfRooms.click ();
		Select oNumberOfRooms = new Select (orClaimItemManagementDetails.ddlNumberOfRooms);
		oNumberOfRooms.selectByVisibleText (strNumberOfRooms);

	}

	// Select "Owned By" drop down

	public void selectOwnedByForTPCover (String strOwnedBy)
	{
		if (strCoverageSelected.equalsIgnoreCase ("Public liability") || strCoverageSelected.equalsIgnoreCase ("Property owner's liability"))
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.ddlOwnedBy));
			orClaimItemManagementDetails.ddlOwnedBy.click ();
			orClaimItemManagementDetails.ddlOwnedBy.sendKeys (strOwnedBy);
			orClaimItemManagementDetails.ddlOwnedBy.click ();
		}

	}

	// Select "Priority" drop down

	public void selectPriority (String strPriority)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.ddlPriority));
		orClaimItemManagementDetails.ddlPriority.click ();
		Select oPriority = new Select (orClaimItemManagementDetails.ddlPriority);
		oPriority.selectByVisibleText (strPriority);
		orClaimItemManagementDetails.ddlPriority.click ();
	}

	// Select "Item Used" drop down

	public void selectItemUsed (String strItemUsed)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.ddlItemUsed));
		orClaimItemManagementDetails.ddlItemUsed.click ();
		Select oItemUsed = new Select (orClaimItemManagementDetails.ddlItemUsed);
		oItemUsed.selectByVisibleText (strItemUsed);

	}

	// Radio button "Item serviced/maintained/repaired" is selected as per
	// parameter as strItemServiced

	public void selectItemServiced (String strItemServiced)
	{

		if (strItemServiced.equalsIgnoreCase ("Yes") || strItemServiced.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimItemManagementDetails.rdoItemServiced;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strItemServiced.equalsIgnoreCase ("No") || strItemServiced.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimItemManagementDetails.rdoItemServiced;
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

	// Type date in "Date last used" field

	public void typeDateLastUsed (String strRegion)
	{

		orClaimItemManagementDetails.dtpDateLastUsed.clear ();
		orClaimItemManagementDetails.dtpDateLastUsed.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	// Type date in "Item serviced/maintained/repaired" field

	public void typeDateLastServiced (String strRegion)
	{

		orClaimItemManagementDetails.dtpLastService.clear ();
		orClaimItemManagementDetails.dtpLastService.sendKeys (CalenderDate.returnCurrentDate (strRegion));

	}

	// Type details in "Serviced/maintained/repaired by Whom" text box

	public void typeServicedByWhom ()
	{

		orClaimItemManagementDetails.txtServicedByWhom.sendKeys ("ItemDetails ADDED A RANDOM TEXT " + RandomLetters.produceRandomString (6));

	}

	// Radio button "Under Warranty" is selected as per parameter
	// strUnderWarranty

	public void selectUnderWarranty (String strUnderWarranty)
	{

		if (strUnderWarranty.equalsIgnoreCase ("Yes") || strUnderWarranty.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimItemManagementDetails.rdoUnderWarranty;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strUnderWarranty.equalsIgnoreCase ("No") || strUnderWarranty.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimItemManagementDetails.rdoUnderWarranty;
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

	// Type details in "Amount Claimed" text box

	public void typeAmountClaimed (String strAmountClaimed)
	{

		orClaimItemManagementDetails.txtAmountClaimed.clear ();
		orClaimItemManagementDetails.txtAmountClaimed.sendKeys (strAmountClaimed);

	}

	// Select "Source of Amount" drop down

	public void selectSourceOfAmount (String strAmountSource)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.ddlSourceOfAmount));
		orClaimItemManagementDetails.ddlSourceOfAmount.click ();
		Select oAmountSource = new Select (orClaimItemManagementDetails.ddlSourceOfAmount);
		oAmountSource.selectByVisibleText (strAmountSource);

	}

	// Type details in "Purchase price" text box

	public void typePurchasePrice ()
	{

		orClaimItemManagementDetails.txtPurchasePrice.sendKeys (RandomNumbers.produceRandomNumber (2));

	}

	// Type details in "Where Purchased" text box

	public void typeWherePurchased ()
	{

		orClaimItemManagementDetails.txtWherePurchased.sendKeys ("Where Purchased ADDED A RANDOM TEXT " + RandomLetters.produceRandomString (6));

	}

	// Select "Fullfilment route" drop down

	public void selectFullfilmentRoute (String strFullfilmentRoute)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.ddlFullfilmentRoute));
		orClaimItemManagementDetails.ddlFullfilmentRoute.click ();
		Select oFullfilmentRoute = new Select (orClaimItemManagementDetails.ddlFullfilmentRoute);
		oFullfilmentRoute.selectByVisibleText (strFullfilmentRoute);
		orClaimItemManagementDetails.ddlFullfilmentRoute.click ();

	}

	// Click on "Save" button

	public void clickSave ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.btnSave));
		orClaimItemManagementDetails.btnSave.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void selectRandomClaimItem ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.tblClaimItems));

		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.clickRandomTableRow ("tblClaimItems");
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void clickSupplierSearch ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.btnSupplierSearch));
		orClaimItemManagementDetails.btnSupplierSearch.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Click on "Clear" button
	public void clickClear ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.btnClear));

		orClaimItemManagementDetails.btnClear.click ();
	}

	// Click on Yes button on Reset pop up that is displayed on pressing Clear
	// button
	public void clickYes ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.btnYes));

		orClaimItemManagementDetails.btnYes.click ();
	}

	// Click on No button on Reset pop up that is displayed on pressing Clear
	// button
	public void clickNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.btnNo));

		orClaimItemManagementDetails.btnNo.click ();
	}

	// This clicks on 'Move all to item management' button that appears on Add
	// New Item frame in back office
	public void moveAllToItemMgmt ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.btnMoveAllToItemMgmt));

		orClaimItemManagementDetails.btnMoveAllToItemMgmt.click ();
	}

	// This clicks on 'OK' button on 'Item validation' pop up that appears after
	// 'Move all to item management' button is clicked
	public void clickOK ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimItemManagementDetails.btnOK));

		orClaimItemManagementDetails.btnOK.click ();
	}

	// Click on "Next" button

	public void clickNext ()
	{

		orClaimItemManagementDetails.btnNext.click ();
	}
}
