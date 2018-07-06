
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
import com.innovation.misc.RandomNumbers;
import com.innovation.pages.claim.objects.OR_ClaimVehicleDetails;
import com.innovation.pages.common.objects.OR_ControlPanel;

/*@author  alamq:  This will capture Methods of claims Vehicle details screen for Motor LOB
 * 
 */

public class ClaimVehicleDetails
{
	WebDriver				driver;
	OR_ClaimVehicleDetails	orClaimVehicleDetails	= null;
	OR_ControlPanel			orControlPanel			= null;

	public ClaimVehicleDetails (WebDriver driver)
	{
		this.driver = driver;
		orClaimVehicleDetails = PageFactory.initElements (driver, OR_ClaimVehicleDetails.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	// Select "Appraisal" tab

	public void selectAppraisaltab ()
	{
		orClaimVehicleDetails.tabAppraisal.click ();
	}

	// Select "Is the Vehicle pre-2000" checkbox

	public void selectVehiclePre2000 ()
	{
		orClaimVehicleDetails.chkPre2000.click ();
	}

	// Select "Vehicle entirley consumed in the loss" checkbox

	public void selectVehicleConsumedEntirly ()
	{
		orClaimVehicleDetails.chkVehicleConsumedEntirly.click ();
	}

	// Select "Water level rise above the dash" checkbox

	public void selectLevelAboveDash ()
	{
		orClaimVehicleDetails.chkLevelAboveDash.click ();
	}

	// Select "Did the vehicle roll over" checkbox

	public void selectVehicleRollOver ()
	{
		orClaimVehicleDetails.chkvehicleRollOver.click ();
	}

	// click on "Calculate" button

	public void ClickCalculate ()
	{
		orClaimVehicleDetails.btnCalculate.click ();
	}

	// Select "Supplier" tab

	public void selectSuppliertab ()
	{
		orClaimVehicleDetails.tabSupplier.click ();
	}

	// Click on "Supplier Search" button

	public void clickSupplierSearch ()
	{
		orClaimVehicleDetails.btnSupplierSearch.click ();
	}

	// Select "Property" tab

	public void selectPropertytab ()
	{
		orClaimVehicleDetails.tabProperty.click ();
	}

	// Click on "Add" button under Property tab

	public void clickAddProperty ()
	{
		orClaimVehicleDetails.btnAdd.click ();
	}

	// Select "Vehicle" tab

	public void selectVehicletab ()
	{
		orClaimVehicleDetails.tabVehicle.click ();
	}
	// Select "Damage" tab

	public void selectDamagetab ()
	{
		orClaimVehicleDetails.tabDamage.click ();
	}

	// Select Vehicle "Type"

	public void selectVehicleType (String strVehicleType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimVehicleDetails.ddlVehicleType));
		orClaimVehicleDetails.ddlVehicleType.click ();
		Select oVehicleType = new Select (orClaimVehicleDetails.ddlVehicleType);
		oVehicleType.selectByVisibleText (strVehicleType);
		orClaimVehicleDetails.ddlVehicleType.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Radio button "Vehicle Details Known" is selected as per parameter

	public void selectVehicleDetailsKnown (String strVehicleDetailsKnown)
	{

		if (strVehicleDetailsKnown.equalsIgnoreCase ("Yes") || strVehicleDetailsKnown.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoVehicleDetailsKnown;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("Yes"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strVehicleDetailsKnown.equalsIgnoreCase ("No") || strVehicleDetailsKnown.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoVehicleDetailsKnown;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("No"))
				{
					radiobutton.click ();
					break;
				}

			}
		}

	}

	// Type details in "Vehicle regitration number" Text field

	public void typeVehicleReg ()
	{

		orClaimVehicleDetails.txtVehicleRegistrationNumber.sendKeys ("a1");
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Click on "Search"

	public void clickVehicleSearch ()
	{

		orClaimVehicleDetails.btnVehicleSearch.click ();
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Select "Vehicle Category" dropdown

	public void selectVehicleCategory ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimVehicleDetails.ddlVehicleCategory));

		orClaimVehicleDetails.ddlVehicleCategory.click ();
		Select oVehicleCategory = new Select (orClaimVehicleDetails.ddlVehicleCategory);

		// Select a random Role from the returned list
		List<WebElement> selections = oVehicleCategory.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oVehicleCategory.selectByIndex (index);
		orClaimVehicleDetails.ddlVehicleCategory.click ();
	}

	// Type details in "Current Mileage" text box

	public void typeCurrentMileage ()
	{
		orClaimVehicleDetails.txtCurrentMileage.sendKeys (RandomNumbers.produceRandomNumber (3));

	}

	// Type details in "Engine Size (cc)" text box

	public void typeEngineSize ()
	{
		orClaimVehicleDetails.txtEngineSize.sendKeys (RandomNumbers.produceRandomNumber (3));

	}

	// Type details in "Number of doors" text box

	public void typeNoOfDoor ()
	{
		orClaimVehicleDetails.txtNumberOfDoors.sendKeys (RandomNumbers.produceRandomNumber (3));

	}
	// Type details in "Owner" text box

	public void typeOwner ()
	{
		orClaimVehicleDetails.txtOwner.sendKeys ("Owner" + RandomLetters.produceRandomString (5));

	}

	// Radio button "MID search performed" is selected as per parameter

	public void selectMIDSearch (String strMIDSearch)
	{

		if (strMIDSearch.equalsIgnoreCase ("Yes") || strMIDSearch.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoMIDSearchPerformed;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strMIDSearch.equalsIgnoreCase ("No") || strMIDSearch.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoMIDSearchPerformed;
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

	// Radio button "MIAFTR search performed" is selected as per parameter

	public void selectMIAFTRSearch (String strMIAFTRSearch)
	{

		if (strMIAFTRSearch.equalsIgnoreCase ("Yes") || strMIAFTRSearch.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoMIAFTRSearchPerformed;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strMIAFTRSearch.equalsIgnoreCase ("No") || strMIAFTRSearch.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoMIAFTRSearchPerformed;
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

	// Select "Role" dropdown

	public void selectRole ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimVehicleDetails.ddlRole));

		orClaimVehicleDetails.ddlRole.click ();
		Select oRole = new Select (orClaimVehicleDetails.ddlRole);

		// Select a random Role from the returned list
		List<WebElement> selections = oRole.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oRole.selectByIndex (index);
		orClaimVehicleDetails.ddlRole.click ();
	}

	// Select "Actual use" dropdown

	public void selectActualUse ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimVehicleDetails.ddlActualUse));

		orClaimVehicleDetails.ddlActualUse.click ();
		Select oActualUse = new Select (orClaimVehicleDetails.ddlActualUse);

		// Select a random Actual Use from the returned list
		List<WebElement> selections = oActualUse.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oActualUse.selectByIndex (index);
		orClaimVehicleDetails.ddlActualUse.click ();
	}

	// Select "Permissible use" dropdown

	public void selectPermissibleUse ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimVehicleDetails.ddlPermissibleUse));

		orClaimVehicleDetails.ddlPermissibleUse.click ();
		Select oPerUse = new Select (orClaimVehicleDetails.ddlPermissibleUse);

		// Select a random Permissible use from the returned list
		List<WebElement> selections = oPerUse.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oPerUse.selectByIndex (index);
		orClaimVehicleDetails.ddlPermissibleUse.click ();
	}

	// Type details in "No. of Passenger" text box

	public void typeNoOfPassenger ()
	{
		orClaimVehicleDetails.txtNoOfPassengers.sendKeys (RandomNumbers.produceRandomNumber (2));

	}

	// Radio button "Vehicle Moving" is selected as per parameter

	public void selectVehicleMoving (String strVehicleMoving)
	{

		if (strVehicleMoving.equalsIgnoreCase ("Yes") || strVehicleMoving.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoVehicleMoving;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strVehicleMoving.equalsIgnoreCase ("No") || strVehicleMoving.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoVehicleMoving;
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

	// Radio button "Vehicle driveable" is selected as per parameter

	public void selectVehicleDriveable (String strVehicleDriveable)
	{

		if (strVehicleDriveable.equalsIgnoreCase ("Yes") || strVehicleDriveable.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoVehicleDriveable;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strVehicleDriveable.equalsIgnoreCase ("No") || strVehicleDriveable.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoVehicleDriveable;
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

	// Radio button "Repairs complete" is selected as per parameter

	public void selectRepairsComplete (String strRepairsComplete)
	{

		if (strRepairsComplete.equalsIgnoreCase ("Yes") || strRepairsComplete.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoRepairsComplete;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strRepairsComplete.equalsIgnoreCase ("No") || strRepairsComplete.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoRepairsComplete;
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

	// Radio button "Secure" is selected as per parameter

	public void selectSecure (String strSecure)
	{

		if (strSecure.equalsIgnoreCase ("Yes") || strSecure.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoSecure;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strSecure.equalsIgnoreCase ("No") || strSecure.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoSecure;
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

	// Radio button "Permission to drive" is selected as per parameter

	public void selectPermissionToDrive (String strPermissionToDrive)
	{

		if (strPermissionToDrive.equalsIgnoreCase ("Yes") || strPermissionToDrive.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoDrivePermission;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strPermissionToDrive.equalsIgnoreCase ("No") || strPermissionToDrive.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoDrivePermission;
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

	// Radio button "Claiming for Damage" is selected as per parameter

	public void selectClaimingForDamage (String strClaimingForDamage)
	{

		if (strClaimingForDamage.equalsIgnoreCase ("Yes") || strClaimingForDamage.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoClaimingforDamage;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strClaimingForDamage.equalsIgnoreCase ("No") || strClaimingForDamage.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoClaimingforDamage;
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

	// Radio button "Settlement Route" is selected as per parameter

	public void selectSettlementRoute (String strSettlementRoute)
	{

		if (strSettlementRoute.equalsIgnoreCase ("Repairable") || strSettlementRoute.equalsIgnoreCase ("R"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoSettlementRoute;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strSettlementRoute.equalsIgnoreCase ("Total loss") || strSettlementRoute.equalsIgnoreCase ("TL")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoSettlementRoute;
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

	// Radio button "Mechanical" is selected as per parameter

	public void selectMechanic (String strMechanic)
	{

		if (strMechanic.equalsIgnoreCase ("Yes") || strMechanic.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoMechanical;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strMechanic.equalsIgnoreCase ("No") || strMechanic.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoMechanical;
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

	// Radio button "Interior" is selected as per parameter

	public void selectInterior (String strInterior)
	{

		if (strInterior.equalsIgnoreCase ("Yes") || strInterior.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoInterior;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strInterior.equalsIgnoreCase ("No") || strInterior.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoInterior;
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

	// Radio button "ICE" is selected as per parameter

	public void selectICE (String strICE)
	{

		if (strICE.equalsIgnoreCase ("Yes") || strICE.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoICE;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strICE.equalsIgnoreCase ("No") || strICE.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoICE;
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

	// Radio button "Under Body" is selected as per parameter

	public void selectUnderBody (String strUnderBody)
	{

		if (strUnderBody.equalsIgnoreCase ("Yes") || strUnderBody.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoUnderBody;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strUnderBody.equalsIgnoreCase ("No") || strUnderBody.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoUnderBody;
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

	// Radio button "Locks" is selected as per parameter

	public void selectLocks (String strLocks)
	{

		if (strLocks.equalsIgnoreCase ("Yes") || strLocks.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoLocks;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strLocks.equalsIgnoreCase ("No") || strLocks.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoLocks;
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

	// Radio button "Wheel" is selected as per parameter

	public void selectWheel (String strWheel)
	{

		if (strWheel.equalsIgnoreCase ("Yes") || strWheel.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoWheel;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strWheel.equalsIgnoreCase ("No") || strWheel.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoWheel;
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

	// Radio button "Glass" is selected as per parameter

	public void selectGlass (String strGlass)
	{

		if (strGlass.equalsIgnoreCase ("Yes") || strGlass.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoGlass;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strGlass.equalsIgnoreCase ("No") || strGlass.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimVehicleDetails.rdoGlass;
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

	// Click on "Car Roof" damage

	public void clickCarRoofDamage ()
	{

		orClaimVehicleDetails.imgCarRoof.click ();
	}

	// Click on "Car bonet" damage

	public void clickCarBonetDamage ()
	{

		orClaimVehicleDetails.imgCarBonnet.click ();
	}

	// Click on "Car Boot" damage

	public void clickCarBootDamage ()
	{

		orClaimVehicleDetails.imgCarBoot.click ();
	}

	// Type details in "Owner" text box

	public void typeComments ()
	{
		orClaimVehicleDetails.txaComments.sendKeys ("Comments" + RandomLetters.produceRandomString (5));

	}

	// Click on "Minor Damage Arrow1" damage

	public void clickMinorDamageArrow1 ()
	{

		orClaimVehicleDetails.imgMinorDamageArrow1.click ();
	}

	// Click on "Minor Damage Arrow2" damage

	public void clickMinorDamageArrow2 ()
	{

		orClaimVehicleDetails.imgMinorDamageArrow2.click ();
	}

	// Click on "Minor Damage Arrow3" damage

	public void clickMinorDamageArrow3 ()
	{

		orClaimVehicleDetails.imgMinorDamageArrow3.click ();
	}

	// Click on "Minor Damage Arrow4" damage

	public void clickMinorDamageArrow4 ()
	{

		orClaimVehicleDetails.imgMinorDamageArrow4.click ();
	}

	// Click on "Minor Damage Arrow5" damage

	public void clickMinorDamageArrow5 ()
	{

		orClaimVehicleDetails.imgMinorDamageArrow5.click ();
	}

	// Click on "Minor Damage Arrow6" damage

	public void clickMinorDamageArrow6 ()
	{

		orClaimVehicleDetails.imgMinorDamageArrow6.click ();
	}

	// Click on "Minor Damage Arrow7" damage

	public void clickMinorDamageArrow7 ()
	{

		orClaimVehicleDetails.imgMinorDamageArrow7.click ();
	}

	// Click on "Minor Damage Arrow8" damage

	public void clickMinorDamageArrow8 ()
	{

		orClaimVehicleDetails.imgMinorDamageArrow8.click ();
	}

	// Click on "Minor Damage Arrow9" damage

	public void clickMinorDamageArrow9 ()
	{

		orClaimVehicleDetails.imgMinorDamageArrow9.click ();
	}

	// Click on "Minor Damage Arrow10" damage

	public void clickMinorDamageArrow10 ()
	{

		orClaimVehicleDetails.imgMinorDamageArrow10.click ();
	}

	// Click on "Minor Damage Arrow11" damage

	public void clickMinorDamageArrow11 ()
	{

		orClaimVehicleDetails.imgMinorDamageArrow11.click ();
	}

	// Click on "Minor Damage Arrow12" damage

	public void clickMinorDamageArrow12 ()
	{

		orClaimVehicleDetails.imgMinorDamageArrow12.click ();
	}

	// Click on "Major Damage Arrow1" damage

	public void clickMajorDamageArrow1 ()
	{

		orClaimVehicleDetails.imgMajorDamageArrow1.click ();
	}

	// Click on "Major Damage Arrow2" damage

	public void clickMajorDamageArrow2 ()
	{

		orClaimVehicleDetails.imgMajorDamageArrow2.click ();
	}

	// Click on "Major Damage Arrow3" damage

	public void clickMajorDamageArrow3 ()
	{

		orClaimVehicleDetails.imgMajorDamageArrow3.click ();
	}

	// Click on "Major Damage Arrow4" damage

	public void clickMajorDamageArrow4 ()
	{

		orClaimVehicleDetails.imgMajorDamageArrow4.click ();
	}

	// Click on "Major Damage Arrow5" damage

	public void clickMajorDamageArrow5 ()
	{

		orClaimVehicleDetails.imgMajorDamageArrow5.click ();
	}

	// Click on "Major Damage Arrow6" damage

	public void clickMajorDamageArrow6 ()
	{

		orClaimVehicleDetails.imgMajorDamageArrow6.click ();
	}

	// Click on "Major Damage Arrow7" damage

	public void clickMajorDamageArrow7 ()
	{

		orClaimVehicleDetails.imgMajorDamageArrow7.click ();
	}

	// Click on "Major Damage Arrow8" damage

	public void clickMajorDamageArrow8 ()
	{

		orClaimVehicleDetails.imgMajorDamageArrow8.click ();
	}

	// Click on "Major Damage Arrow9" damage

	public void clickMajorDamageArrow9 ()
	{

		orClaimVehicleDetails.imgMajorDamageArrow9.click ();
	}

	// Click on "Major Damage Arrow10" damage

	public void clickMajorDamageArrow10 ()
	{

		orClaimVehicleDetails.imgMajorDamageArrow10.click ();
	}

	// Click on "Major Damage Arrow11" damage

	public void clickMajorDamageArrow11 ()
	{

		orClaimVehicleDetails.imgMajorDamageArrow11.click ();
	}

	// Click on "Major Damage Arrow12" damage

	public void clickMajorDamageArrow12 ()
	{

		orClaimVehicleDetails.imgMajorDamageArrow12.click ();

	}

}
