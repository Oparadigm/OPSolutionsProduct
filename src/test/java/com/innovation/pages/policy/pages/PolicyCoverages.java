/**
 * 
 */
package com.innovation.pages.policy.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomNumbers;
import com.innovation.pages.policy.objects.OR_PolicyCoverages;

/**
 * @author lushs - Create the page details for the Property/Auto Coverage
 */
public class PolicyCoverages
{

	WebDriver			driver;
	OR_PolicyCoverages	orPolicyCoverages	= null;

	public PolicyCoverages (WebDriver driver)
	{
		this.driver = driver;
		orPolicyCoverages = PageFactory.initElements (driver, OR_PolicyCoverages.class);
	}

	public void selectBuildingsCoverage ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkBuildings));
		orPolicyCoverages.chkBuildings.click ();
	}

	public void typeBuildingsCoverageLimit ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.txtBuildingsLimit));
		orPolicyCoverages.txtBuildingsLimit.sendKeys (RandomNumbers.produceRandomNumber (6));
	}

	public void selectBuildingsExcess ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.ddlBuildingsExcess));
		orPolicyCoverages.ddlBuildingsExcess.click ();
		Select oBldgsXs = new Select (orPolicyCoverages.ddlBuildingsExcess);

		List<WebElement> selections = oBldgsXs.getOptions ();
		// Select a random buildings excess from the returned list
		// This can select a blank row (the first option in the drop down list) as you
		// do not always want an excess
		// associated to a quote and the test works fine if one is not selected.
		int index = (int) (Math.random () * selections.size ());
		oBldgsXs.selectByIndex (index);

	}

	public void selectContentsCoverage ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkContents));
		orPolicyCoverages.chkContents.click ();
	}

	public void typeContentsCoverageLimit ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.txtContentsLimit));
		orPolicyCoverages.txtContentsLimit.sendKeys (RandomNumbers.produceRandomNumber (5));
	}

	public void selectContentsExcess ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.ddlContentsExcess));
		orPolicyCoverages.ddlContentsExcess.click ();
		Select oContentsXs = new Select (orPolicyCoverages.ddlContentsExcess);

		List<WebElement> selections = oContentsXs.getOptions ();
		// Select a random contents excess from the returned list
		// This can select a blank row (the first option in the drop down list) as you
		// do not always want an excess
		// associated to a quote and the test works fine if one is not selected.
		int index = (int) (Math.random () * selections.size ());
		oContentsXs.selectByIndex (index);

	}

	public void clickCalculateButton ()
	{
		// This will wait for up to 5 seconds for the Calculate button to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.btnCalculatePremium));
		orPolicyCoverages.btnCalculatePremium.click ();
	}

	// Extracts the policy premium
	public void checkPremium ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.tblTransactionPremium));
		String sText = orPolicyCoverages.tblTransactionPremium.getText ();
		System.out.println ("The Quotation Premium is : " + sText);

	}

	public void clickProceedNext ()
	{
		// This will wait for up to 10 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, 10);
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.btnProceedNext));
		orPolicyCoverages.btnProceedNext.click ();
	}

	/*
	 * Auto Coverage functions added @author Kamran
	 */
	public void selectComprehensiveCoverage ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOf (orPolicyCoverages.chkComprehensive));
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkComprehensive));
		orPolicyCoverages.chkComprehensive.click ();
	}

	public void selectComprehensiveExcess ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.ddlComprehensiveExcess));
		orPolicyCoverages.ddlComprehensiveExcess.click ();
		Select oComprehensiveExcess = new Select (orPolicyCoverages.ddlComprehensiveExcess);

		List<WebElement> selections = oComprehensiveExcess.getOptions ();
		// Select a random buildings excess from the returned list
		// This can select a blank row (the first option in the drop down list) as you
		// do not always want an excess
		// associated to a quote and the test works fine if one is not selected.
		int intIndex = (int) (Math.random () * selections.size ());
		oComprehensiveExcess.selectByIndex (intIndex);

	}

	public void selectThirdPartyTheftCoverage ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkThirdPartyTheft));
		orPolicyCoverages.chkThirdPartyTheft.click ();
	}

	public void selectThirdPartyTheftExcess ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.ddlThirdPartyTheft));
		orPolicyCoverages.ddlThirdPartyTheft.click ();
		Select oTPTheftExcess = new Select (orPolicyCoverages.ddlThirdPartyTheft);

		List<WebElement> selections = oTPTheftExcess.getOptions ();
		// Select a random buildings excess from the returned list
		// This can select a blank row (the first option in the drop down list) as you
		// do not always want an excess
		// associated to a quote and the test works fine if one is not selected.
		int intIndex = (int) (Math.random () * selections.size ());
		oTPTheftExcess.selectByIndex (intIndex);

	}

	public void selectThirdPartyOnlyCoverage ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkThirdPartyOnly));
		orPolicyCoverages.chkThirdPartyOnly.click ();
	}

	public void typeThirdPartyOnlyExcess ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.txtThirdPartyOnlyExcess));
		orPolicyCoverages.txtThirdPartyOnlyExcess.click ();
		orPolicyCoverages.txtThirdPartyOnlyExcess.sendKeys (RandomNumbers.produceRandomNumber (5));
	}

	public void selectTowingLabourCoverage ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkTowingLabour));
		orPolicyCoverages.chkTowingLabour.click ();
	}

	public void selectTowingLabourLimits ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.ddlTowingLabourLimit));
		orPolicyCoverages.ddlTowingLabourLimit.click ();
		Select oTowingLabourLimits = new Select (orPolicyCoverages.ddlTowingLabourLimit);

		List<WebElement> selections = oTowingLabourLimits.getOptions ();
		// Select a random buildings excess from the returned list
		// This can select a blank row (the first option in the drop down list) as you
		// do not always want an excess
		// associated to a quote and the test works fine if one is not selected.
		int intIndex = (int) (Math.random () * selections.size ());
		oTowingLabourLimits.selectByIndex (intIndex);

	}

	// US Region Home Coverage methods
	public void selectDwellingCoverage ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		// wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkDwelling));
		// orPolicyCoverages.chkDwelling.click ();
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.txtLimtDwelling));
		orPolicyCoverages.txtLimtDwelling.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void selectPersonalProperty ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		// wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkPersonalProperty));
		// orPolicyCoverages.chkPersonalProperty.click ();
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.txtLimtPersonalProperty));
		orPolicyCoverages.txtLimtPersonalProperty.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void selectOrdinanceLaw ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkOridanceOfLaw));
		orPolicyCoverages.chkOridanceOfLaw.click ();
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.txtLimtOrdinanceOfLaw));
		orPolicyCoverages.txtLimtOrdinanceOfLaw.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void selectFireDepartmentServiceCharge ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkFireDepartmentServiceCharge));
		orPolicyCoverages.chkFireDepartmentServiceCharge.click ();
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.ddlLimitFireDepartmentSeriveCharge));
		orPolicyCoverages.ddlLimitFireDepartmentSeriveCharge.click ();
		Select oFireDepartmentLimits = new Select (orPolicyCoverages.ddlLimitFireDepartmentSeriveCharge);
		List<WebElement> selections = oFireDepartmentLimits.getOptions ();
		int intIndex = (int) (Math.random () * selections.size ());
		oFireDepartmentLimits.selectByIndex (intIndex);
	}

	public void selectBackUpOfSewer ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkBackUpOfSewer));
		orPolicyCoverages.chkBackUpOfSewer.click ();
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.ddlLimtBackUpSewer));
		orPolicyCoverages.ddlLimtBackUpSewer.click ();
		Select oBackSewerLimits = new Select (orPolicyCoverages.ddlLimtBackUpSewer);
		List<WebElement> selections = oBackSewerLimits.getOptions ();
		int intIndex = (int) (Math.random () * selections.size ());
		oBackSewerLimits.selectByIndex (intIndex);
	}

	public void selectDebrisRemoval ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkDebrisRemoval));
		orPolicyCoverages.chkDebrisRemoval.click ();
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.ddlLimtDebrisRemoval));
		orPolicyCoverages.ddlLimtDebrisRemoval.click ();
		Select oDebrisRemovalLimits = new Select (orPolicyCoverages.ddlLimtDebrisRemoval);
		List<WebElement> selections = oDebrisRemovalLimits.getOptions ();
		int intIndex = (int) (Math.random () * selections.size ());
		oDebrisRemovalLimits.selectByIndex (intIndex);
	}

	public void selectCoverages (String strRegion)
	{
		PolicyCoverages policycoverages = new PolicyCoverages (driver);
		if (strRegion.equals ("UK"))
		{
			policycoverages.selectBuildingsCoverage ();
			policycoverages.typeBuildingsCoverageLimit ();
			policycoverages.selectBuildingsExcess ();
			policycoverages.selectContentsCoverage ();
			policycoverages.typeContentsCoverageLimit ();
			policycoverages.selectContentsExcess ();
		}
		else if (strRegion.equals ("USA") || strRegion.equals ("US"))
		{
			policycoverages.selectDwellingCoverage ();
			policycoverages.selectPersonalProperty ();
		}
	}

	public void UpdateHomeCoverage (String strRegion)
	{
		PolicyCoverages policycoverages = new PolicyCoverages (driver);
		if (strRegion.equals ("UK"))
		{
			policycoverages.selectBuildingAccidentalDamage ();
		}
		else if (strRegion.equals ("USA") || strRegion.equals ("US"))
		{
			policycoverages.selectBackUpOfSewer ();
			policycoverages.selectFireDepartmentServiceCharge ();
		}
	}

	public void deselectComprehensiveCoverage ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyCoverages.prgProgress));
		wait.until (ExpectedConditions.visibilityOf (orPolicyCoverages.chkComprehensive));
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkComprehensive));

		orPolicyCoverages.chkComprehensive.click ();

	}

	public void selectPremiumOptionAlreadySelected ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.lblPremiumOptionSelected));
		orPolicyCoverages.lblPremiumOptionSelected.click ();
	}

	public void selectPremiumOptionOne ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.lblPremiumOptionOne));
		orPolicyCoverages.lblPremiumOptionOne.click ();
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.btnSelectOptionOne));
		orPolicyCoverages.btnSelectOptionOne.click ();
		wait.until (ExpectedConditions.invisibilityOf (orPolicyCoverages.prgProgress));
	}

	public void selectPremiumOptionTwo ()
	{
		// This will wait for up to 3 seconds for the Region drop down list to become
		// available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.lblPremiumOptionTwo));
		orPolicyCoverages.lblPremiumOptionTwo.click ();
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.btnSelectOptionTwo));
		orPolicyCoverages.btnSelectOptionTwo.click ();
		wait.until (ExpectedConditions.invisibilityOf (orPolicyCoverages.prgProgress));
	}

	public void selectAutoCoverages (String strRegion)
	{
		PolicyCoverages policycoverages = new PolicyCoverages (driver);
		if (strRegion.equals ("UK"))
		{
			policycoverages.selectComprehensiveCoverage ();
			policycoverages.selectComprehensiveExcess ();
		}
		else if (strRegion.equals ("USA") || strRegion.equals ("US"))
		{
			policycoverages.selectPremiumOptionTwo ();

		}

	}

	public void UpdateAutoCoverages (String strRegion)
	{
		PolicyCoverages policycoverages = new PolicyCoverages (driver);
		if (strRegion.equals ("UK"))
		{
			policycoverages.deselectComprehensiveCoverage ();
			policycoverages.selectThirdPartyOnlyCoverage ();
			policycoverages.selectThirdPartyTheftCoverage ();
			policycoverages.selectThirdPartyTheftExcess ();
			policycoverages.selectTowingLabourCoverage ();
		}
		else if (strRegion.equals ("USA") || strRegion.equals ("US"))
		{
			policycoverages.selectPremiumOptionOne ();
		}

	}

	public void selectBuildingAccidentalDamage ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCoverages.chkBuildingAccidentalDamage));
		orPolicyCoverages.chkBuildingAccidentalDamage.click ();
	}

}
