package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomNumbers;
import com.innovation.pages.claim.objects.OR_ClaimEstimateSummary;
import com.innovation.pages.common.objects.OR_ControlPanel;

/*
 * @author  Alamq- this class stores all the locators and methods on 'Estimate summary' frame accessible through BO Navigation panel > Property damage > Estimate
 *  Alamq - Added Locators and method for Estimate Details screen for Auto LOB.
 */

public class ClaimEstimateSummary
{
	WebDriver				driver;
	OR_ClaimEstimateSummary	orClaimEstimateSummary	= null;
	OR_ControlPanel			orControlPanel			= null;

	public ClaimEstimateSummary (WebDriver driver)
	{
		this.driver = driver;
		orClaimEstimateSummary = PageFactory.initElements (driver, OR_ClaimEstimateSummary.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	public void selectSupplier ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.ddlSupplier));

		Select oSupplier = new Select (orClaimEstimateSummary.ddlSupplier);
		List<WebElement> selections = oSupplier.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oSupplier.selectByIndex (intIndex);
	}

	public void selectOwner ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.ddlOwner));

		Select oOwner = new Select (orClaimEstimateSummary.ddlOwner);
		List<WebElement> selections = oOwner.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oOwner.selectByIndex (intIndex);
	}

	public void selectSupplierJobReference ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.ddlSupplierJobReference));

		Select oSupplierJobReference = new Select (orClaimEstimateSummary.ddlSupplierJobReference);
		List<WebElement> selections = oSupplierJobReference.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oSupplierJobReference.selectByIndex (intIndex);
	}

	public void clickNewJob ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.btnNewJob));
		orClaimEstimateSummary.btnNewJob.click ();
	}

	public void typeEstimateDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtEstimateDateProperty));
		orClaimEstimateSummary.txtEstimateDateProperty.click ();
		orClaimEstimateSummary.txtEstimateDateProperty.sendKeys (CalenderDate.returnCurrentDate (strRegion));

	}

	public void typeSupplierReference ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtSupplierReference));

		orClaimEstimateSummary.txtSupplierReference.click ();
		orClaimEstimateSummary.txtSupplierReference.sendKeys ("Supplier ref: " + RandomNumbers.produceRandomNumber (4));
	}

	public void selectEstimatingSystem ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.ddlEstimatingSystemProperty));

		Select oEstimatingSystem = new Select (orClaimEstimateSummary.ddlEstimatingSystemProperty);
		List<WebElement> selections = oEstimatingSystem.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oEstimatingSystem.selectByIndex (intIndex);
	}

	public void clickSave ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.btnSave));
		orClaimEstimateSummary.btnSave.click ();
	}

	public void selectSupplierName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.ddlSupplierName));
		orClaimEstimateSummary.ddlSupplierName.click ();
		Select oSupplierName = new Select (orClaimEstimateSummary.ddlSupplierName);
		List<WebElement> selections = oSupplierName.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (0, selections.size () - 1);
		oSupplierName.selectByIndex (intIndex);

		// wait.until (ExpectedConditions.or (ExpectedConditions.visibilityOf (orClaimEstimateSummary.txtMETLabourHours),
		// ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtMETLabourHours)));
	}

	public void selectEstimatingSystemAuto ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.ddlEstimatingSystemAuto));

		Select oEstimatingSystem = new Select (orClaimEstimateSummary.ddlEstimatingSystemAuto);
		List<WebElement> selections = oEstimatingSystem.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oEstimatingSystem.selectByIndex (intIndex);
	}

	public void typeReferenceNumber ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtReferenceNumber));

		orClaimEstimateSummary.txtReferenceNumber.click ();
		orClaimEstimateSummary.txtReferenceNumber.sendKeys (RandomNumbers.produceRandomNumber (4));
	}

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectRepairable (String strRepairable)
	{
		if (strRepairable.equalsIgnoreCase ("Yes") || strRepairable.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimEstimateSummary.rdoRepairable;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strRepairable.equalsIgnoreCase ("No") || strRepairable.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimEstimateSummary.rdoRepairable;
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

	// Pass Yes/Y to select Yes or No/N to select No from the radio group
	public void selectTotalLossIndicator (String strTotalLoss)
	{
		if (strTotalLoss.equalsIgnoreCase ("Yes") || strTotalLoss.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimEstimateSummary.rdoTotalLossIndicator;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strTotalLoss.equalsIgnoreCase ("No") || strTotalLoss.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimEstimateSummary.rdoTotalLossIndicator;
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

	public void typeEstimateDateAuto (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtEstimateDateAuto));

		orClaimEstimateSummary.txtEstimateDateAuto.click ();
		orClaimEstimateSummary.txtEstimateDateAuto.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typeAssessmentDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtAssessmentDate));

		orClaimEstimateSummary.txtAssessmentDate.click ();
		orClaimEstimateSummary.txtAssessmentDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typePreAccidentValue ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtPreAccidentValue));

		orClaimEstimateSummary.txtPreAccidentValue.click ();
		orClaimEstimateSummary.txtPreAccidentValue.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeInsuredValue ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtInsuredValue));

		orClaimEstimateSummary.txtInsuredValue.click ();
		orClaimEstimateSummary.txtInsuredValue.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typeMETLabourRate ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtMETLabourRate));

		orClaimEstimateSummary.txtMETLabourRate.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typeMETLabourHours ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtMETLabourHours));
		orClaimEstimateSummary.txtMETLabourHours.sendKeys (RandomNumbers.produceRandomNumber (1));
	}

	public void typeMechanicalLabourRate ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtMechanicalLabourRate));

		orClaimEstimateSummary.txtMechanicalLabourRate.click ();
		orClaimEstimateSummary.txtMechanicalLabourRate.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeMechanicalLabourHours ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtMechanicalLabourHours));

		orClaimEstimateSummary.txtMechanicalLabourHours.click ();
		orClaimEstimateSummary.txtMechanicalLabourHours.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typePanelLabourRate ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtPanelLabourRate));

		orClaimEstimateSummary.txtPanelLabourRate.click ();
		orClaimEstimateSummary.txtPanelLabourRate.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typePanelLabourHours ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtPanelLabourRate));

		orClaimEstimateSummary.txtPanelLabourRate.click ();
		orClaimEstimateSummary.txtPanelLabourRate.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typePaintLabourRate ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtPaintLabourRate));

		orClaimEstimateSummary.txtPaintLabourRate.click ();
		orClaimEstimateSummary.txtPaintLabourRate.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typePaintLabourHours ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtPaintLabourHours));

		orClaimEstimateSummary.txtPaintLabourHours.click ();
		orClaimEstimateSummary.txtPaintLabourHours.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeMiscellaneousLabourRate ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtMiscellaneousLabourRate));

		orClaimEstimateSummary.txtMiscellaneousLabourRate.click ();
		orClaimEstimateSummary.txtMiscellaneousLabourRate.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeMiscellaneousLabourHours ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtMiscellaneousLabourHours));

		orClaimEstimateSummary.txtMiscellaneousLabourHours.click ();
		orClaimEstimateSummary.txtMiscellaneousLabourHours.sendKeys (RandomNumbers.produceRandomNumber (1));
	}

	public void typeTotalParts ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtPartsTotal));

		orClaimEstimateSummary.txtPartsTotal.click ();
		orClaimEstimateSummary.txtPartsTotal.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typePaintAndMaterial ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtPaintMaterials));

		orClaimEstimateSummary.txtPaintMaterials.click ();
		orClaimEstimateSummary.txtPaintMaterials.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeSpecialistCharges ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtSpecialistCharges));

		orClaimEstimateSummary.txtSpecialistCharges.click ();
		orClaimEstimateSummary.txtSpecialistCharges.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeSundries ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtSundries));

		orClaimEstimateSummary.txtSundries.click ();
		orClaimEstimateSummary.txtSundries.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeCorrosionProtection ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtCorrosionProtection));

		orClaimEstimateSummary.txtCorrosionProtection.click ();
		orClaimEstimateSummary.txtCorrosionProtection.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeEnvironmentalCharges ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtEnvironmentalCharges));

		orClaimEstimateSummary.txtEnvironmentalCharges.click ();
		orClaimEstimateSummary.txtEnvironmentalCharges.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeStorage ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

		orClaimEstimateSummary.txtStorage.click ();
		orClaimEstimateSummary.txtStorage.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeTowing ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtTowing));

		orClaimEstimateSummary.txtTowing.click ();
		orClaimEstimateSummary.txtTowing.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typeStorageAndRecovery ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtStorageAndCoverage));

		orClaimEstimateSummary.txtStorageAndCoverage.click ();
		orClaimEstimateSummary.txtStorageAndCoverage.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeContractRepair ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtContractRepair));

		orClaimEstimateSummary.txtContractRepair.click ();
		orClaimEstimateSummary.txtContractRepair.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typePolicyHolderContributions ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtPolicyholderContributions));

		orClaimEstimateSummary.txtPolicyholderContributions.click ();
		orClaimEstimateSummary.txtPolicyholderContributions.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeOtherAdjustments ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtOtherAdjustments));

		orClaimEstimateSummary.txtOtherAdjustments.click ();
		orClaimEstimateSummary.txtOtherAdjustments.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeVAT ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtVAT));

		orClaimEstimateSummary.txtVAT.click ();
		orClaimEstimateSummary.txtVAT.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeExcess ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtExcess));

		orClaimEstimateSummary.txtExcess.click ();
		orClaimEstimateSummary.txtExcess.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void clickSaveAuto ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.btnSaveAuto));
		orClaimEstimateSummary.btnSaveAuto.click ();

	}

	public void clickYesPopUp ()
	{

		try
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
			boolean blnIsStateVisible = orClaimEstimateSummary.btnYes.isDisplayed ();
			if (blnIsStateVisible)
			{
				orClaimEstimateSummary.btnYes.click ();
			}

		}
		catch (NoSuchElementException ignored)
		{

		}

	}

	public void typeRepairAuthorisationDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.txtRepairAuthorsationDate));
		orClaimEstimateSummary.txtRepairAuthorsationDate.click ();
		orClaimEstimateSummary.txtRepairAuthorsationDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	// Pass 'Random' in parameter to randomly select a value from Repair Authorisation Type dropdown. Otherwise pass respective
	// value for selection
	public void selectRepairAuthorisatonType (String strRepairAuthorisatonType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.ddlRepairAuthorsationType));

		if (strRepairAuthorisatonType.equalsIgnoreCase ("Random"))
		{
			orClaimEstimateSummary.ddlRepairAuthorsationType.click ();
			Select oRepairAuthorisation = new Select (orClaimEstimateSummary.ddlRepairAuthorsationType);

			// Selects a random Further Details value from the returned list
			List<WebElement> selections = oRepairAuthorisation.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oRepairAuthorisation.selectByIndex (intIndex);
		}
		else
		{
			orClaimEstimateSummary.ddlRepairAuthorsationType.click ();
			orClaimEstimateSummary.ddlRepairAuthorsationType.sendKeys (strRepairAuthorisatonType);
			orClaimEstimateSummary.ddlRepairAuthorsationType.click ();
		}
	}

	public void clickCreateInvoice ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateSummary.btnCreateInvoice));
		orClaimEstimateSummary.btnCreateInvoice.click ();

	}

}
