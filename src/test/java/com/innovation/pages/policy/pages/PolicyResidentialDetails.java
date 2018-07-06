/**
 * 
 */
package com.innovation.pages.policy.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.SelectionHelper;
import com.innovation.pages.policy.objects.OR_PolicyResidentialDetails;

/**
 * @author lushs - Create the page details for the Residential details
 */
public class PolicyResidentialDetails
{

	WebDriver					driver;
	OR_PolicyResidentialDetails	orPolicyResidentialDetails	= null;
	LoggingControl				loggingcontrol				= new LoggingControl ();

	public PolicyResidentialDetails (WebDriver driver)
	{
		this.driver = driver;
		orPolicyResidentialDetails = PageFactory.initElements (driver, OR_PolicyResidentialDetails.class);
	}

	public void selectYearBuilt ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlYearBuilt));
		orPolicyResidentialDetails.ddlYearBuilt.click ();
		Select oYearBuilt = new Select (orPolicyResidentialDetails.ddlYearBuilt);

		// Select a random build year from the returned list
		List<WebElement> selections = oYearBuilt.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 75)) + 2;
		oYearBuilt.selectByIndex (index);
	}

	public void selectNoOfBeds ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlNoOfBedrooms));
		orPolicyResidentialDetails.ddlNoOfBedrooms.click ();
		Select oNoBeds = new Select (orPolicyResidentialDetails.ddlNoOfBedrooms);

		// Select a random number of bedrooms from the returned list
		List<WebElement> selections = oNoBeds.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oNoBeds.selectByIndex (index);
	}

	public void selectNoOfunits (String strNoOfUnits)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlNoOfUnits));
		// CANNOT RANDOMISE THIS - AS NUMBER OF UNITS MUST NOT EXCEED 1. ADDITIONAL
		// UNITS MUST BE ENTERED AS SEPARATE RISK
		Select oNoUnits = new Select (orPolicyResidentialDetails.ddlNoOfUnits);
		oNoUnits.selectByVisibleText (strNoOfUnits);
	}

	// The following function will return the ownership indicator in the call flow script
	// this returning string will become the parameter for Interested Party function and decides
	// whether InterestedParty should supposed to be added or not.

	public String selectOwnership ()
	{

		String strvalueSelected = null;
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlOwnership));
		orPolicyResidentialDetails.ddlOwnership.click ();
		Select oOwnership = new Select (orPolicyResidentialDetails.ddlOwnership);

		// Select a random ownership from the returned list
		List<WebElement> selections = oOwnership.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oOwnership.selectByIndex (index);

		// Get the Selected Value after the Selection
		List<WebElement> selectedOption = oOwnership.getAllSelectedOptions ();
		int selectedOptionsCount = selectedOption.size ();
		for (int i = 0; i < selectedOptionsCount; i++)
		{

			strvalueSelected = selectedOption.get (i).getText ();

		}

		return strvalueSelected;
	}

	public void selectHoldType ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlHoldType));
		orPolicyResidentialDetails.ddlHoldType.click ();
		Select oHoldType = new Select (orPolicyResidentialDetails.ddlHoldType);

		// Select a random hold type from the returned list
		List<WebElement> selections = oHoldType.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oHoldType.selectByIndex (index);
	}

	public void clickProceedNext ()
	{
		// This will wait for up to 3 seconds for the Proceed Next button to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.btnProceedNext));
		orPolicyResidentialDetails.btnProceedNext.click ();
	}

	public void selectResidenceType ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlResidenceType));
		orPolicyResidentialDetails.ddlResidenceType.click ();
		Select oResidenceType = new Select (orPolicyResidentialDetails.ddlResidenceType);

		// Select a random hold type from the returned list
		List<WebElement> selections = oResidenceType.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oResidenceType.selectByIndex (index);
	}

	// US Region methods to select Values on property details

	// select a random element from the list
	public void selectPrimaryHeating ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlPrimaryHeating));

		orPolicyResidentialDetails.ddlPrimaryHeating.click ();
		Select oPrimaryHeating = new Select (orPolicyResidentialDetails.ddlPrimaryHeating);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oPrimaryHeating.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oPrimaryHeating.selectByIndex (index);
	}

	// select a specified value
	public void selectPrimaryHeating (String ddlPrimaryHeating)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlPrimaryHeating));

		orPolicyResidentialDetails.ddlPrimaryHeating.click ();
		Select oPrimaryHeating = new Select (orPolicyResidentialDetails.ddlPrimaryHeating);
		oPrimaryHeating.selectByVisibleText (ddlPrimaryHeating);
	}

	// select a random element from the list
	public void selectOilTankLocation ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlOilTankLocation));

		orPolicyResidentialDetails.ddlOilTankLocation.click ();
		Select oOilTankLocation = new Select (orPolicyResidentialDetails.ddlOilTankLocation);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oOilTankLocation.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oOilTankLocation.selectByIndex (index);
	}

	// select a specified value
	public void selectOilTankLocation (String ddlOilTankLocation)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlOilTankLocation));

		orPolicyResidentialDetails.ddlOilTankLocation.click ();
		Select oOilTankLocation = new Select (orPolicyResidentialDetails.ddlOilTankLocation);
		oOilTankLocation.selectByVisibleText (ddlOilTankLocation);
	}

	// select a random element from the list
	public void selectOilTankInstallYear ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlOilTankInstallYear));

		orPolicyResidentialDetails.ddlOilTankInstallYear.click ();
		Select oOilTankInstallYear = new Select (orPolicyResidentialDetails.ddlOilTankInstallYear);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oOilTankInstallYear.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oOilTankInstallYear.selectByIndex (index);
	}

	// select a specified value
	public void selectOilTankInstallYear (String ddlOilTankInstallYear)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlOilTankInstallYear));

		orPolicyResidentialDetails.ddlOilTankInstallYear.click ();
		Select oOilTankInstallYear = new Select (orPolicyResidentialDetails.ddlOilTankInstallYear);
		oOilTankInstallYear.selectByVisibleText (ddlOilTankInstallYear);
	}

	// select a random element from the list
	public void selectSecondaryHeating ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlSecondaryHeating));

		orPolicyResidentialDetails.ddlSecondaryHeating.click ();
		Select oSecondaryHeating = new Select (orPolicyResidentialDetails.ddlSecondaryHeating);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oSecondaryHeating.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oSecondaryHeating.selectByIndex (index);
	}

	// select a specified value
	public void selectSecondaryHeating (String ddlSecondaryHeating)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlSecondaryHeating));

		orPolicyResidentialDetails.ddlSecondaryHeating.click ();
		Select oSecondaryHeating = new Select (orPolicyResidentialDetails.ddlSecondaryHeating);
		oSecondaryHeating.selectByVisibleText (ddlSecondaryHeating);
	}

	// select a random element from the list
	public void selectStructureType ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlStructureType));

		orPolicyResidentialDetails.ddlStructureType.click ();
		Select oStructureType = new Select (orPolicyResidentialDetails.ddlStructureType);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oStructureType.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oStructureType.selectByIndex (index);
	}

	// select a specified value
	public void selectStructureType (String ddlStructureType)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlStructureType));

		orPolicyResidentialDetails.ddlStructureType.click ();
		Select oStructureType = new Select (orPolicyResidentialDetails.ddlStructureType);
		oStructureType.selectByVisibleText (ddlStructureType);
	}

	// select a random element from the list
	public void selectChimneyInspectionYear ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlChimneyInspectionYear));

		orPolicyResidentialDetails.ddlChimneyInspectionYear.click ();
		Select oChimneyInspectionYear = new Select (orPolicyResidentialDetails.ddlChimneyInspectionYear);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oChimneyInspectionYear.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oChimneyInspectionYear.selectByIndex (index);
	}

	// select a specified value
	public void selectChimneyInspectionYear (String ddlChimneyInspectionYear)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlChimneyInspectionYear));

		orPolicyResidentialDetails.ddlChimneyInspectionYear.click ();
		Select oChimneyInspectionYear = new Select (orPolicyResidentialDetails.ddlChimneyInspectionYear);
		oChimneyInspectionYear.selectByVisibleText (ddlChimneyInspectionYear);
	}

	// select a random element from the list
	public void selectHeating ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlHeating));

		orPolicyResidentialDetails.ddlHeating.click ();
		Select oHeating = new Select (orPolicyResidentialDetails.ddlHeating);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oHeating.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oHeating.selectByIndex (index);
	}

	// select a specified value
	public void selectHeating (String ddlHeating)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlHeating));

		orPolicyResidentialDetails.ddlHeating.click ();
		Select oHeating = new Select (orPolicyResidentialDetails.ddlHeating);
		oHeating.selectByVisibleText (ddlHeating);
	}

	// select a random element from the list
	public void selectElectrical ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlElectrical));

		orPolicyResidentialDetails.ddlElectrical.click ();
		Select oElectrical = new Select (orPolicyResidentialDetails.ddlElectrical);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oElectrical.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oElectrical.selectByIndex (index);
	}

	// select a specified value
	public void selectElectrical (String ddlElectrical)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlElectrical));

		orPolicyResidentialDetails.ddlElectrical.click ();
		Select oElectrical = new Select (orPolicyResidentialDetails.ddlElectrical);
		oElectrical.selectByVisibleText (ddlElectrical);
	}

	// select a random element from the list
	public void selectPlumbing ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlPlumbing));

		orPolicyResidentialDetails.ddlPlumbing.click ();
		Select oPlumbing = new Select (orPolicyResidentialDetails.ddlPlumbing);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oPlumbing.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oPlumbing.selectByIndex (index);
	}

	// select a specified value
	public void selectPlumbing (String ddlPlumbing)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlPlumbing));

		orPolicyResidentialDetails.ddlPlumbing.click ();
		Select oPlumbing = new Select (orPolicyResidentialDetails.ddlPlumbing);
		oPlumbing.selectByVisibleText (ddlPlumbing);
	}

	// select a random element from the list
	public void selectRoof ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlRoof));

		orPolicyResidentialDetails.ddlRoof.click ();
		Select oRoof = new Select (orPolicyResidentialDetails.ddlRoof);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oRoof.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oRoof.selectByIndex (index);
	}

	// select a specified value
	public void selectRoof (String ddlRoof)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlRoof));

		orPolicyResidentialDetails.ddlRoof.click ();
		Select oRoof = new Select (orPolicyResidentialDetails.ddlRoof);
		oRoof.selectByVisibleText (ddlRoof);
	}

	// select a random element from the list
	public void selectRoofType ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlRoofType));

		orPolicyResidentialDetails.ddlRoofType.click ();
		Select oRoofType = new Select (orPolicyResidentialDetails.ddlRoofType);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oRoofType.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oRoofType.selectByIndex (index);
	}

	// select a specified value
	public void selectRoofType (String ddlRoofType)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlRoofType));

		orPolicyResidentialDetails.ddlRoofType.click ();
		Select oRoofType = new Select (orPolicyResidentialDetails.ddlRoofType);
		oRoofType.selectByVisibleText (ddlRoofType);
	}

	// select a random element from the list
	public void selectProFinanced ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlProFinanced));

		orPolicyResidentialDetails.ddlProFinanced.click ();
		Select oProFinanced = new Select (orPolicyResidentialDetails.ddlProFinanced);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oProFinanced.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oProFinanced.selectByIndex (index);
	}

	// select a specified value
	public void selectProFinanced (String ddlProFinanced)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlProFinanced));

		orPolicyResidentialDetails.ddlProFinanced.click ();
		Select oProFinanced = new Select (orPolicyResidentialDetails.ddlProFinanced);
		oProFinanced.selectByVisibleText (ddlProFinanced);
	}

	// select a random element from the list
	public void selectBuildYear ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlBuildYear));

		orPolicyResidentialDetails.ddlBuildYear.click ();
		Select oBuildYear = new Select (orPolicyResidentialDetails.ddlBuildYear);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oBuildYear.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oBuildYear.selectByIndex (index);
	}

	// select a specified value
	public void selectBuildYear (String ddlBuildYear)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlBuildYear));

		orPolicyResidentialDetails.ddlBuildYear.click ();
		Select oBuildYear = new Select (orPolicyResidentialDetails.ddlBuildYear);
		oBuildYear.selectByVisibleText (ddlBuildYear);
	}

	// select a random element from the list
	public void selectRatingTerritory ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlRatingTerritory));

		orPolicyResidentialDetails.ddlRatingTerritory.click ();
		Select oRatingTerritory = new Select (orPolicyResidentialDetails.ddlRatingTerritory);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oRatingTerritory.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oRatingTerritory.selectByIndex (index);
	}

	// select a specified value
	public void selectRatingTerritory (String ddlRatingTerritory)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlRatingTerritory));

		orPolicyResidentialDetails.ddlRatingTerritory.click ();
		Select oRatingTerritory = new Select (orPolicyResidentialDetails.ddlRatingTerritory);
		oRatingTerritory.selectByVisibleText (ddlRatingTerritory);
	}

	// select a random element from the list
	public void selectOverrideReason ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlOverrideReason));

		orPolicyResidentialDetails.ddlOverrideReason.click ();
		Select oOverrideReason = new Select (orPolicyResidentialDetails.ddlOverrideReason);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oOverrideReason.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oOverrideReason.selectByIndex (index);
	}

	// select a specified value
	public void selectOverrideReason (String ddlOverrideReason)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlOverrideReason));

		orPolicyResidentialDetails.ddlOverrideReason.click ();
		Select oOverrideReason = new Select (orPolicyResidentialDetails.ddlOverrideReason);
		oOverrideReason.selectByVisibleText (ddlOverrideReason);
	}

	// select a random element from the list
	public void selectTierCode ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlTierCode));

		orPolicyResidentialDetails.ddlTierCode.click ();
		Select oTierCode = new Select (orPolicyResidentialDetails.ddlTierCode);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oTierCode.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oTierCode.selectByIndex (index);
	}

	// select a specified value
	public void selectTierCode (String ddlTierCode)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlTierCode));

		orPolicyResidentialDetails.ddlTierCode.click ();
		Select oTierCode = new Select (orPolicyResidentialDetails.ddlTierCode);
		oTierCode.selectByVisibleText (ddlTierCode);
	}

	// select a random element from the list
	public void selectFireProtectionClass ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlFireProtectionProvide));

		orPolicyResidentialDetails.ddlFireProtectionProvide.click ();
		Select oFireProtectionClass = new Select (orPolicyResidentialDetails.ddlFireProtectionProvide);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oFireProtectionClass.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oFireProtectionClass.selectByIndex (index);
	}

	// select a specified value
	public void selectFireProtectionClass (String ddlFireProtectionClass)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlFireProtectionProvide));

		orPolicyResidentialDetails.ddlFireProtectionProvide.click ();
		Select oFireProtectionClass = new Select (orPolicyResidentialDetails.ddlFireProtectionProvide);
		oFireProtectionClass.selectByVisibleText (ddlFireProtectionClass);
	}

	// select a random element from the list
	public void selectFireProtClassOReason ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlFireProtClassOReason));

		orPolicyResidentialDetails.ddlFireProtClassOReason.click ();
		Select oFireProtClassOReason = new Select (orPolicyResidentialDetails.ddlFireProtClassOReason);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oFireProtClassOReason.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oFireProtClassOReason.selectByIndex (index);
	}

	// select a specified value
	public void selectFireProtClassOReason (String ddlFireProtClassOReason)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlFireProtClassOReason));

		orPolicyResidentialDetails.ddlFireProtClassOReason.click ();
		Select oFireProtClassOReason = new Select (orPolicyResidentialDetails.ddlFireProtClassOReason);
		oFireProtClassOReason.selectByVisibleText (ddlFireProtClassOReason);
	}

	// select a random element from the list
	public void selectEarthquakeZone ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlEarthquakeZone));

		orPolicyResidentialDetails.ddlEarthquakeZone.click ();
		Select oEarthquakeZone = new Select (orPolicyResidentialDetails.ddlEarthquakeZone);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oEarthquakeZone.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oEarthquakeZone.selectByIndex (index);
	}

	// select a specified value
	public void selectEarthquakeZone (String ddlEarthquakeZone)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlEarthquakeZone));

		orPolicyResidentialDetails.ddlEarthquakeZone.click ();
		Select oEarthquakeZone = new Select (orPolicyResidentialDetails.ddlEarthquakeZone);
		oEarthquakeZone.selectByVisibleText (ddlEarthquakeZone);
	}

	// select a random element from the list
	public void selectMinesubZone ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlMinesubZone));

		orPolicyResidentialDetails.ddlMinesubZone.click ();
		Select oMinesubZone = new Select (orPolicyResidentialDetails.ddlMinesubZone);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oMinesubZone.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oMinesubZone.selectByIndex (index);
	}

	// select a specified value
	public void selectMinesubZone (String ddlMinesubZone)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlMinesubZone));

		orPolicyResidentialDetails.ddlMinesubZone.click ();
		Select oMinesubZone = new Select (orPolicyResidentialDetails.ddlMinesubZone);
		oMinesubZone.selectByVisibleText (ddlMinesubZone);
	}

	// select a random element from the list
	public void selectWindZone ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlWindZone));

		orPolicyResidentialDetails.ddlWindZone.click ();
		Select oWindZone = new Select (orPolicyResidentialDetails.ddlWindZone);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oWindZone.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oWindZone.selectByIndex (index);
	}

	// select a specified value
	public void selectWindZone (String ddlWindZone)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlWindZone));

		orPolicyResidentialDetails.ddlWindZone.click ();
		Select oWindZone = new Select (orPolicyResidentialDetails.ddlWindZone);
		oWindZone.selectByVisibleText (ddlWindZone);
	}

	public void selectConstructionType ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlConstructionType));

		orPolicyResidentialDetails.ddlConstructionType.click ();
		Select oConstruction = new Select (orPolicyResidentialDetails.ddlConstructionType);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oConstruction.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oConstruction.selectByIndex (index);
	}

	public void selectUnderConstruction ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlUnderConstruction));

		orPolicyResidentialDetails.ddlUnderConstruction.click ();
		Select oUnderConstruction = new Select (orPolicyResidentialDetails.ddlUnderConstruction);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oUnderConstruction.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oUnderConstruction.selectByIndex (index);
	}

	public void selectSelectSwimmingPool ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlSwimmingPoolType));

		orPolicyResidentialDetails.ddlSwimmingPoolType.click ();
		Select oSwimmingPool = new Select (orPolicyResidentialDetails.ddlSwimmingPoolType);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oSwimmingPool.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oSwimmingPool.selectByIndex (index);
	}

	public void selectResidentialUse ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlResidentialUse));

		orPolicyResidentialDetails.ddlResidentialUse.click ();
		Select oResidentialUse = new Select (orPolicyResidentialDetails.ddlResidentialUse);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oResidentialUse.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oResidentialUse.selectByIndex (index);
	}

	public void selectMonthsOccupied ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlMonthsOccupied));

		orPolicyResidentialDetails.ddlMonthsOccupied.click ();
		Select oMonthsOccupied = new Select (orPolicyResidentialDetails.ddlMonthsOccupied);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oMonthsOccupied.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oMonthsOccupied.selectByIndex (index);
	}

	public void selectDangerousAnimal ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlDangerousAnimal));

		orPolicyResidentialDetails.ddlDangerousAnimal.click ();
		Select oDangerousAnimal = new Select (orPolicyResidentialDetails.ddlDangerousAnimal);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oDangerousAnimal.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oDangerousAnimal.selectByIndex (index);
	}

	public void selectManagedAgent ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		try
		{
			boolean blnIsStateVisible = orPolicyResidentialDetails.ddlManagedByAgents.isDisplayed ();
			if (blnIsStateVisible)
			{
				WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
				wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlManagedByAgents));

				orPolicyResidentialDetails.ddlManagedByAgents.click ();
				Select oManagedByAgents = new Select (orPolicyResidentialDetails.ddlManagedByAgents);

				// Select a random Reported By from the returned list
				List<WebElement> selections = oManagedByAgents.getOptions ();
				int index = (int) (Math.random () * (selections.size () - 2)) + 2;
				oManagedByAgents.selectByIndex (index);
			}
		}
		catch (NoSuchElementException ignored)
		{

		}
		try
		{

			boolean blnIsStateVisible = orPolicyResidentialDetails.ddlManagedAgents.isDisplayed ();
			if (blnIsStateVisible)
			{
				WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
				wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlManagedAgents));

				orPolicyResidentialDetails.ddlManagedAgents.click ();
				Select oManagedByAgents = new Select (orPolicyResidentialDetails.ddlManagedAgents);

				// Select a random Reported By from the returned list
				List<WebElement> selections = oManagedByAgents.getOptions ();
				int index = (int) (Math.random () * (selections.size () - 2)) + 2;
				oManagedByAgents.selectByIndex (index);
			}
		}
		catch (NoSuchElementException ignored)
		{

		}
	}

	public void NoOfRoomersBoarders ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlNoRoomersBoarders));

		orPolicyResidentialDetails.ddlNoRoomersBoarders.click ();
		Select oNoRoomersBoarders = new Select (orPolicyResidentialDetails.ddlNoRoomersBoarders);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oNoRoomersBoarders.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oNoRoomersBoarders.selectByIndex (index);
	}

	public void selectResidenceOccupiedFamily ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPolicyResidentialDetails.lstResidenceOccupiedByFamily));

		SelectionHelper.selectRadio (orPolicyResidentialDetails.lstResidenceOccupiedByFamily, "Yes", false, false, "unknown");

	}

	public void typeNumberofFamilies ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.txtNumberOfFamilies));

		orPolicyResidentialDetails.txtNumberOfFamilies.click ();
		orPolicyResidentialDetails.txtNumberOfFamilies.sendKeys (RandomNumbers.produceRandomNumber (1));

	}

	public void FireHydrantDistance ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlDistToFireHydrant));

		orPolicyResidentialDetails.ddlDistToFireHydrant.click ();
		Select oDistToFireHydrant = new Select (orPolicyResidentialDetails.ddlDistToFireHydrant);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oDistToFireHydrant.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oDistToFireHydrant.selectByIndex (index);
	}

	public void selectFireProtectionDevices ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlFireProtectionDevices));

		orPolicyResidentialDetails.ddlFireProtectionDevices.click ();
		Select oFireProtectionDevices = new Select (orPolicyResidentialDetails.ddlFireProtectionDevices);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oFireProtectionDevices.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oFireProtectionDevices.selectByIndex (index);
	}

	public void selectFireStationDistance ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlDistanceOfFireStation));

		orPolicyResidentialDetails.ddlDistanceOfFireStation.click ();
		Select oDistanceOfFireStation = new Select (orPolicyResidentialDetails.ddlDistanceOfFireStation);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oDistanceOfFireStation.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oDistanceOfFireStation.selectByIndex (index);
	}

	public void selectTheftDevices ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlTheftDevices));

		orPolicyResidentialDetails.ddlTheftDevices.click ();
		Select oTheftDevices = new Select (orPolicyResidentialDetails.ddlTheftDevices);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oTheftDevices.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oTheftDevices.selectByIndex (index);
	}

	public void clickFireExtinguisher ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPolicyResidentialDetails.lstFireExtinguisher));

		SelectionHelper.selectRadio (orPolicyResidentialDetails.lstFireExtinguisher, "Yes", false, false, "unknown");
	}

	public void selectBuildingReplacementCost ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlBuildingReplacementCost));

		orPolicyResidentialDetails.ddlBuildingReplacementCost.click ();
		Select oBuildingReplacementCost = new Select (orPolicyResidentialDetails.ddlBuildingReplacementCost);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oBuildingReplacementCost.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oBuildingReplacementCost.selectByIndex (index);
	}

	public void selectContentsReplacementCost ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlContentsReplacementCost));

		orPolicyResidentialDetails.ddlContentsReplacementCost.click ();
		Select oContentsReplacementCost = new Select (orPolicyResidentialDetails.ddlContentsReplacementCost);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oContentsReplacementCost.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oContentsReplacementCost.selectByIndex (index);
	}

	public void selectMineSubsidence ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlMineSubSidenece));

		orPolicyResidentialDetails.ddlMineSubSidenece.click ();
		Select oMineSubSidenece = new Select (orPolicyResidentialDetails.ddlMineSubSidenece);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oMineSubSidenece.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oMineSubSidenece.selectByIndex (index);
	}

	public void selectStandardDeductible ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlStandardDeductible));

		orPolicyResidentialDetails.ddlStandardDeductible.click ();
		Select oStandardDeductible = new Select (orPolicyResidentialDetails.ddlStandardDeductible);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oStandardDeductible.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oStandardDeductible.selectByIndex (index);
	}

	public void selectWindHailDeductible ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlWindHailDeductible));

		orPolicyResidentialDetails.ddlWindHailDeductible.click ();
		Select oWindHailDeductible = new Select (orPolicyResidentialDetails.ddlWindHailDeductible);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oWindHailDeductible.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oWindHailDeductible.selectByIndex (index);
	}

	public void selectSpecialTheft ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlSpecialTheft));

		orPolicyResidentialDetails.ddlSpecialTheft.click ();
		Select oSpecialTheft = new Select (orPolicyResidentialDetails.ddlSpecialTheft);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oSpecialTheft.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oSpecialTheft.selectByIndex (index);
	}

	public void selectEarthQuakeDeductible ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlEarthQuakeDeductible));

		orPolicyResidentialDetails.ddlEarthQuakeDeductible.click ();
		Select oEarthQuakeDeductible = new Select (orPolicyResidentialDetails.ddlEarthQuakeDeductible);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oEarthQuakeDeductible.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oEarthQuakeDeductible.selectByIndex (index);
	}

	public void clickRoofACV ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPolicyResidentialDetails.lstRoofACV));
		SelectionHelper.selectRadio (orPolicyResidentialDetails.lstRoofACV, "Yes", false, false, "unknown");
	}

	public void typeTotalLivingArea ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		try
		{

			boolean blnIsStateVisible = orPolicyResidentialDetails.txtTotalLivingArea.isDisplayed ();

			if (blnIsStateVisible)
			{
				WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
				wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.txtTotalLivingArea));
				orPolicyResidentialDetails.txtTotalLivingArea.click ();
				orPolicyResidentialDetails.txtTotalLivingArea.clear ();
				orPolicyResidentialDetails.txtTotalLivingArea.sendKeys (RandomNumbers.produceRandomNumber (4));
			}
		}
		catch (NoSuchElementException ignored)
		{

		}

	}

	public void selectPropertyFinanced ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		try
		{

			boolean blnIsStateVisible = orPolicyResidentialDetails.ddlPropertyFinanced.isDisplayed ();
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyResidentialDetails.ddlPropertyFinanced));

			orPolicyResidentialDetails.ddlPropertyFinanced.click ();
			Select oEarthQuakeDeductible = new Select (orPolicyResidentialDetails.ddlPropertyFinanced);

			// Select a random Reported By from the returned list
			oEarthQuakeDeductible.selectByVisibleText ("No");

		}
		catch (NoSuchElementException ignored)
		{

		}
	}

	public void selectRiskDetails (String strRegion)
	{
		PolicyResidentialDetails policyresidentialdetails = new PolicyResidentialDetails (driver);
		if (strRegion.equals ("UK"))
		{
			policyresidentialdetails.selectStructureType ();
			policyresidentialdetails.selectYearBuilt ();
			policyresidentialdetails.selectNoOfBeds ();
			policyresidentialdetails.selectNoOfunits ("One unit in fire division");
			policyresidentialdetails.selectOwnership ();
			policyresidentialdetails.selectHoldType ();
		}
		else if (strRegion.equals ("USA") || strRegion.equals ("US"))
		{

			// Property Details

			policyresidentialdetails.selectYearBuilt ();
			policyresidentialdetails.selectNoOfunits ("One unit in fire division");
			policyresidentialdetails.selectStructureType ();
			policyresidentialdetails.selectPrimaryHeating ();
			policyresidentialdetails.selectRoofType ();
			policyresidentialdetails.selectConstructionType ();
			policyresidentialdetails.selectUnderConstruction ();
			policyresidentialdetails.selectSelectSwimmingPool ();

			// Residential Details
			policyresidentialdetails.selectResidentialUse ();
			policyresidentialdetails.selectResidenceOccupiedFamily ();
			policyresidentialdetails.selectMonthsOccupied ();
			policyresidentialdetails.typeNumberofFamilies ();
			policyresidentialdetails.selectDangerousAnimal ();
			policyresidentialdetails.selectManagedAgent ();
			policyresidentialdetails.NoOfRoomersBoarders ();
			policyresidentialdetails.typeTotalLivingArea ();
			policyresidentialdetails.selectPropertyFinanced ();

			// Protections
			policyresidentialdetails.selectFireProtectionClass ();
			policyresidentialdetails.FireHydrantDistance ();
			policyresidentialdetails.clickFireExtinguisher ();
			policyresidentialdetails.selectFireProtectionDevices ();
			policyresidentialdetails.selectFireStationDistance ();
			policyresidentialdetails.selectTheftDevices ();

			// Policy Options
			policyresidentialdetails.selectBuildingReplacementCost ();
			policyresidentialdetails.selectContentsReplacementCost ();
			policyresidentialdetails.clickRoofACV ();
			policyresidentialdetails.selectMineSubsidence ();
			policyresidentialdetails.selectStandardDeductible ();
			policyresidentialdetails.selectWindHailDeductible ();
			policyresidentialdetails.selectSpecialTheft ();
			policyresidentialdetails.selectEarthQuakeDeductible ();
		}

	}

	public void UpdateResidentialDetails (String strRegion)
	{
		PolicyResidentialDetails policyresidentialdetails = new PolicyResidentialDetails (driver);
		if (strRegion.equals ("UK"))
		{
			policyresidentialdetails.selectYearBuilt ();
			policyresidentialdetails.selectNoOfBeds ();

		}
		else if (strRegion.equals ("USA"))
		{
			policyresidentialdetails.selectYearBuilt ();
			policyresidentialdetails.selectSelectSwimmingPool ();
			policyresidentialdetails.typeTotalLivingArea ();
			policyresidentialdetails.selectPropertyFinanced ();
		}

	}

}
