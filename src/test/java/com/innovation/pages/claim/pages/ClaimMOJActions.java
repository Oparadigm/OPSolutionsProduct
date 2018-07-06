package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.RandomNumbers;
import com.innovation.pages.claim.objects.OR_ClaimMOJActions;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.soap.customexceptions.TestCaseValidationFailed;

/**
 * @author haiderm & Rizwan - this class stores all the locators and methods on 'MOJ Actions' frame accessible through BO Navigation
 *         panel > Bodily injury > MOJ actions
 * 
 */

public class ClaimMOJActions
{
	WebDriver			driver;
	String				strStateFraud;
	String				strCurrentStatus;
	String				strDaysRemainingInCurrentPhase;
	String				strLastPhaseUpdate;
	OR_ClaimMOJActions	orClaimMOJActions	= null;
	OR_ControlPanel		orControlPanel		= null;

	public ClaimMOJActions (WebDriver driver)
	{
		this.driver = driver;
		orClaimMOJActions = PageFactory.initElements (driver, OR_ClaimMOJActions.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	// Functions for Article 75 and Liability decision

	public void selectArticle75Decision (String strArticle75Decision)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimMOJActions.ddlArticle75Decision, strArticle75Decision));
		orClaimMOJActions.ddlArticle75Decision.click ();
		orClaimMOJActions.ddlArticle75Decision.sendKeys (strArticle75Decision);
		orClaimMOJActions.ddlArticle75Decision.click ();

	}

	public void clickArticle75Decision ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnArticle75Decision));
		orClaimMOJActions.btnArticle75Decision.click ();
	}

	public void typeStateFraud ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtStateFraud));
		orClaimMOJActions.txtStateFraud.click ();
		strStateFraud = RandomLetters.produceRandomString (8);
		orClaimMOJActions.txtStateFraud.sendKeys (strStateFraud);

	}

	public void selectInsurerCapacity (String strInsurerCapacity)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimMOJActions.ddlInsurerCapacity, strInsurerCapacity));

		orClaimMOJActions.ddlInsurerCapacity.click ();
		orClaimMOJActions.ddlInsurerCapacity.sendKeys (strInsurerCapacity);
		orClaimMOJActions.ddlInsurerCapacity.click ();

	}

	public void typeOtherDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txaOtherDetail));
		orClaimMOJActions.txaOtherDetail.click ();
		orClaimMOJActions.txaOtherDetail
				.sendKeys ("Other details are added as random text: " + RandomLetters.produceRandomString (5) + " " + RandomNumbers.produceRandomNumber (5));
	}

	public void selectLiability (String strLiability)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.ddlLiability));
		orClaimMOJActions.ddlLiability.click ();
		orClaimMOJActions.ddlLiability.sendKeys (strLiability);
		orClaimMOJActions.ddlLiability.click ();

	}

	public void typeLiabilityNotAdmittedReasons ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txaLiabilityNotAdmittedReasons));
		orClaimMOJActions.txaLiabilityNotAdmittedReasons.click ();
		orClaimMOJActions.txaLiabilityNotAdmittedReasons.sendKeys ("Liability Not Admitted Reasons are added as random text: " +
			RandomLetters.produceRandomString (5) + " " + RandomNumbers.produceRandomNumber (5));
	}

	public void typeContactName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtContactName));
		orClaimMOJActions.txtContactName.click ();
		orClaimMOJActions.txtContactName.sendKeys (RandomLetters.produceRandomString (6));
	}

	public void typeSurName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtContactSurName));
		orClaimMOJActions.txtContactSurName.click ();
		orClaimMOJActions.txtContactSurName.sendKeys (RandomLetters.produceRandomString (4));
	}

	public void typeTelephoneNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtTelephoneNo));
		orClaimMOJActions.txtTelephoneNo.click ();
		orClaimMOJActions.txtTelephoneNo.sendKeys (RandomNumbers.produceRandomNumber (7));
	}

	public void typeEmailAddress ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtEmailAddress));
		orClaimMOJActions.txtEmailAddress.click ();
		orClaimMOJActions.txtEmailAddress.sendKeys (RandomLetters.produceRandomString (4) + "@TEST.COM");
	}

	public void selectInsurerPreparedToProvideRehab (String strInsurerPreparedToProvideRehab)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.ddlInsurerPreparedToProvideRehab));
		orClaimMOJActions.ddlInsurerPreparedToProvideRehab.click ();
		orClaimMOJActions.ddlInsurerPreparedToProvideRehab.sendKeys (strInsurerPreparedToProvideRehab);
		orClaimMOJActions.ddlInsurerPreparedToProvideRehab.click ();

	}

	public void selectInsurerProvidedRehab (String strInsurerProvidedRehab)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.ddlInsurerProvidedRehab));
		orClaimMOJActions.ddlInsurerProvidedRehab.click ();
		orClaimMOJActions.ddlInsurerProvidedRehab.sendKeys (strInsurerProvidedRehab);
		orClaimMOJActions.ddlInsurerProvidedRehab.click ();

	}

	public void typeRehabilitationDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txaRehabilitationDetails));
		orClaimMOJActions.txaRehabilitationDetails.click ();
		orClaimMOJActions.txaRehabilitationDetails.sendKeys (
				"Rehabilitation details are added as random text: " + RandomLetters.produceRandomString (5) + " " + RandomNumbers.produceRandomNumber (5));
	}

	public void selectInsurerInstructedAlternativeVehicle (String strInsurerInstructedAlternativeVehicle)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.ddlInsurerInstructedAlternativeVehicle));
		orClaimMOJActions.ddlInsurerInstructedAlternativeVehicle.click ();
		orClaimMOJActions.ddlInsurerInstructedAlternativeVehicle.sendKeys (strInsurerInstructedAlternativeVehicle);
		orClaimMOJActions.ddlInsurerInstructedAlternativeVehicle.click ();

	}

	public void typeAlternativeVehicleDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txaAlternativeVehicleDetails));
		orClaimMOJActions.txaAlternativeVehicleDetails.click ();
		orClaimMOJActions.txaAlternativeVehicleDetails.sendKeys (
				"Alternative Vehicle details are added as random text: " + RandomLetters.produceRandomString (5) + " " + RandomNumbers.produceRandomNumber (5));
	}

	public void selectInsurerOrganisedRepairs (String strInsurerOrganisedRepairs)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.ddlInsurerOrganisedRepairs));
		orClaimMOJActions.ddlInsurerOrganisedRepairs.click ();
		orClaimMOJActions.ddlInsurerOrganisedRepairs.sendKeys (strInsurerOrganisedRepairs);
		orClaimMOJActions.ddlInsurerOrganisedRepairs.click ();

	}

	public void typeInspectionDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txaInspectionDetails));
		orClaimMOJActions.txaInspectionDetails.click ();
		orClaimMOJActions.txaInspectionDetails.sendKeys (
				"Inspection details are added as random text: " + RandomLetters.produceRandomString (5) + " " + RandomNumbers.produceRandomNumber (5));
	}

	public void typeHouseName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtHouseName));
		orClaimMOJActions.txtHouseName.click ();
		orClaimMOJActions.txtHouseName.sendKeys ("House " + RandomLetters.produceRandomString (4));
	}

	public void typeNumber ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtNumber));
		orClaimMOJActions.txtNumber.click ();
		orClaimMOJActions.txtNumber.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typeStreet1 ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtStreet1));
		orClaimMOJActions.txtStreet1.click ();
		orClaimMOJActions.txtStreet1.sendKeys ("Street 1 " + RandomLetters.produceRandomString (4));
	}

	public void typeStreet2 ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtStreet2));
		orClaimMOJActions.txtStreet2.click ();
		orClaimMOJActions.txtStreet2.sendKeys ("Street 2 " + RandomLetters.produceRandomString (4));
	}

	public void typeDistrict ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtDistrict));
		orClaimMOJActions.txtDistrict.click ();
		orClaimMOJActions.txtDistrict.sendKeys ("District " + RandomLetters.produceRandomString (4));
	}

	public void typeTown ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtTown));
		orClaimMOJActions.txtTown.click ();
		orClaimMOJActions.txtTown.sendKeys ("Town " + RandomLetters.produceRandomString (4));
	}

	public void typeCounty ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtCounty));
		orClaimMOJActions.txtCounty.click ();
		orClaimMOJActions.txtCounty.sendKeys ("County " + RandomLetters.produceRandomString (4));
	}

	public void typeCountry (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtCountry));
		orClaimMOJActions.txtCountry.click ();
		orClaimMOJActions.txtCountry.sendKeys (strRegion);
	}

	public void typePostcode ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtPostcode));
		orClaimMOJActions.txtPostcode.click ();
		orClaimMOJActions.txtPostcode.sendKeys (RandomLetters.produceRandomString (2) + RandomNumbers.produceRandomNumber (2) + " " +
			RandomNumbers.produceRandomNumber (1) + RandomLetters.produceRandomString (2));
	}

	public void clickLiabilityDecision ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnLiabilityDecision));
		orClaimMOJActions.btnLiabilityDecision.click ();
	}

	// Validations labels
	public String validateCurrentStatus ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.lblCurrentStatus));
		strCurrentStatus = orClaimMOJActions.lblCurrentStatus.getText ();

		return strCurrentStatus;
	}

	public String validateDaysRemainingInCurrentPhase ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOf (orClaimMOJActions.lblDaysRemainingInCurrentPhase));
		strDaysRemainingInCurrentPhase = orClaimMOJActions.lblDaysRemainingInCurrentPhase.getText ();

		return strDaysRemainingInCurrentPhase;
	}

	public void validateClaimStatusNew (String strClaimStatusNew) throws TestCaseValidationFailed
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.lblCurrentStatusNew));
		strCurrentStatus = orClaimMOJActions.lblCurrentStatusNew.getText ();

		if (strCurrentStatus.equalsIgnoreCase (strClaimStatusNew))
		{

			System.out.println ("Current claim status is :" + strClaimStatusNew);

		}
		else
		{
			throw new TestCaseValidationFailed ();
		}

	}

	public void validateDaysRemainingInCurrentPhaseNew (String strDaysRemainingInCurrentPhaseValue) throws TestCaseValidationFailed
	{
		strDaysRemainingInCurrentPhase = orClaimMOJActions.lblDaysRemainingInCurrentPhaseNew.getText ();

		if (strDaysRemainingInCurrentPhase.equalsIgnoreCase (strDaysRemainingInCurrentPhaseValue))
		{
			if (strDaysRemainingInCurrentPhase.equalsIgnoreCase (""))
				System.out.println ("Days Remaining in Current Phase are none.");
			else
				System.out.println ("Days Remaining in Current Phase are: " + strDaysRemainingInCurrentPhaseValue);
		}
		else
		{
			throw new TestCaseValidationFailed ();
		}
	}

	public String returnDaysRemainingInCurrentPhase ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.lblDaysRemainingInCurrentPhaseNew));
		String strDaysRemainingInCurrentPhase = orClaimMOJActions.lblDaysRemainingInCurrentPhaseNew.getText ();
		return strDaysRemainingInCurrentPhase;
	}

	public void validateLastPhaseUpdateNew (String strLastPhaseUpdateValue) throws TestCaseValidationFailed
	{
		strLastPhaseUpdate = orClaimMOJActions.lblLastPhaseUpdateNew.getText ();

		if (strLastPhaseUpdate.equalsIgnoreCase (strLastPhaseUpdateValue))
		{

			System.out.println ("Last phase update date is: " + strLastPhaseUpdateValue);
		}
		else
		{
			throw new TestCaseValidationFailed ();
		}
	}

	public String returnLastPhaseUpdate ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.lblLastPhaseUpdateNew));
		String strLastPhaseUpdate = orClaimMOJActions.lblLastPhaseUpdateNew.getText ();
		return strLastPhaseUpdate;
	}

	public void validateArticle75DecisionButtonEnabled () throws TestCaseValidationFailed
	{
		if (orClaimMOJActions.btnArticle75Decision.isEnabled ())
		{
			System.out.println ("Article 75 decision button is enabled.");
		}
		else
		{
			throw new TestCaseValidationFailed ();
		}

	}

	public void validateLiabilityDecisionButtonEnabled () throws TestCaseValidationFailed
	{
		if (orClaimMOJActions.btnLiabilityDecision.isEnabled ())
		{
			System.out.println ("Liability decision button is enabled.");
		}
		else
		{
			throw new TestCaseValidationFailed ();
		}

	}

	public void validateRejectRequestButtonEnabled () throws TestCaseValidationFailed
	{
		if (orClaimMOJActions.btnRejectRequest.isEnabled ())
		{
			System.out.println ("Reject request button is enabled.");
		}
		else
		{
			throw new TestCaseValidationFailed ();
		}
	}

	public boolean validateSendDecisionButtonEnabled ()
	{
		if (orClaimMOJActions.btnSendDecision.isEnabled ())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void validateOutcome (String strOutcome) throws TestCaseValidationFailed
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.tblOutcome));
		String strOutcomeValue = orClaimMOJActions.tblOutcome.getText ();

		if (strOutcomeValue.equalsIgnoreCase (strOutcome))
		{

			System.out.println ("Interim requests Outcome :" + strOutcome);

		}
		else
		{
			throw new TestCaseValidationFailed ();
		}
	}

	public void validateDateOfOutcome (String strDateOfOutcome) throws TestCaseValidationFailed
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.tblDateOfOutcome));
		String strDateOfOutcomeValue = orClaimMOJActions.tblDateOfOutcome.getText ();

		if (strDateOfOutcomeValue.equalsIgnoreCase (strDateOfOutcome))
		{
			System.out.println ("Date of outcome is  :" + strDateOfOutcome);
		}
		else
		{
			throw new TestCaseValidationFailed ();
		}
	}

	public boolean validateInterimSettlement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.tabSettlement));

		return orClaimMOJActions.tabSettlement.isDisplayed ();

	}

	public boolean validateErrorStrings (String strExpectedWarningMessage)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.wrnErrorStrings));
		String strReceivedWarningMessage = orClaimMOJActions.wrnErrorStrings.getText ();
		if (strExpectedWarningMessage.equals (strReceivedWarningMessage))
		{
			return true;

		}
		else
		{
			return false;
		}
	}

	public boolean validateRejectRequest ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnRejectRequest));

		return orClaimMOJActions.btnRejectRequest.isDisplayed ();

	}

	public boolean validateSendDecision ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnSendDecision));

		return orClaimMOJActions.btnSendDecision.isDisplayed ();

	}

	public boolean validateStateFraud ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnStateFraud));

		return orClaimMOJActions.btnStateFraud.isDisplayed ();

	}

	public boolean validateExitProcess ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnExitProcess));

		return orClaimMOJActions.btnExitProcess.isDisplayed ();
	}

	// Functions for controls on Interim settlement section

	public void clickSettlementTab ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.tabSettlement));
		orClaimMOJActions.tabSettlement.click ();

	}

	public void typeContactNameIS ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtContactNameIS));
		orClaimMOJActions.txtContactNameIS.clear ();
		orClaimMOJActions.txtContactNameIS.sendKeys (RandomLetters.produceRandomString (6));
	}

	public void typeContactSurNameIS ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtContactSurNameIS));
		orClaimMOJActions.txtContactSurNameIS.clear ();
		orClaimMOJActions.txtContactSurNameIS.sendKeys (RandomLetters.produceRandomString (4));
	}

	public void typeTelephoneNoIS ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtTelephoneNoIS));
		orClaimMOJActions.txtTelephoneNoIS.clear ();
		orClaimMOJActions.txtTelephoneNoIS.sendKeys (RandomNumbers.produceRandomNumber (7));
	}

	public void typeEmailAddressIS ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtEmailAddressIS));
		orClaimMOJActions.txtEmailAddressIS.clear ();
		orClaimMOJActions.txtEmailAddressIS.sendKeys (RandomLetters.produceRandomString (4) + "@TEST.COM");
	}

	public void typeCRUReferenceNumber ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtCRUReferenceNumber));
		orClaimMOJActions.txtCRUReferenceNumber.click ();
		orClaimMOJActions.txtCRUReferenceNumber.sendKeys (RandomLetters.produceRandomString (3) + RandomNumbers.produceRandomNumber (3));

	}

	public void typeCRUDeductions (String strCRUDeductions)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtCRUDeductions));
		orClaimMOJActions.txtCRUDeductions.clear ();
		orClaimMOJActions.txtCRUDeductions.sendKeys (strCRUDeductions);

	}

	// This function returns true if Interim request losses table has incomplete
	// records, it also clicks on first incomplete record
	public boolean clickIncompleteInterimLossRequest ()
	{
		// Get number of rows in the table
		int Row_count = orClaimMOJActions.tblInterimRequestLossesRows.size ();
		// Get number of visible columns in the table
		long Col_count = orClaimMOJActions.tblInterimRequestLossesColumns.stream ().filter (WebElement::isDisplayed).count ();
		// divided xpath In three parts to pass Row_count and Col_count values.
		String strFirst_part = "//*[@id='CLM_SC_BO_MOJActionInterimRequestLosses']/tbody/tr[";
		String strSecond_part = "]/td[";
		String strThird_part = "]/img";

		// Used for loop for number of rows.
		for (int k = 3; k <= Row_count; k++)
		{
			long j = Col_count;

			// Prepared final xpath of specific cell as per values of k and j.
			String final_xpath = strFirst_part + k + strSecond_part + j + strThird_part;
			// last cell of each row is checked and if record is incomplete,
			// record is clicked and false is returned
			String strCompleteIndicator = driver.findElement (By.xpath (final_xpath)).getAttribute ("alt");
			if (strCompleteIndicator.equals ("false"))
			{
				driver.findElement (By.xpath (final_xpath)).click ();
				return true;
			}
		}

		return false;

	}

	// This function processes all incomplete records in Interim request losses
	// table.
	// It requires 4 parameters to pass for each record processing
	public void processIncompleteInterimLossRequests (String strCRUDeductions, String strGrossValueAgreed, double dblDifferenceOfOfferedAndClaimed,
			String strContributoryDeductions)
	{

		while (clickIncompleteInterimLossRequest () == true)
		{
			typeCRUDeductions (strCRUDeductions);
			selectGrossValueAgreed (strGrossValueAgreed);
			String strValueOffered = typeDifferenceInValueClaimedAndOffered (dblDifferenceOfOfferedAndClaimed);
			typeGrossValueOffered (strValueOffered);
			typeDefendantComments ();
			typeContributoryDeductions (strContributoryDeductions);
			clickLossSave ();
		}

	}

	public void selectGrossValueAgreed (String strGrossValueAgreed)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.ddlGrossValueAgreed));
		orClaimMOJActions.ddlGrossValueAgreed.click ();
		orClaimMOJActions.ddlGrossValueAgreed.sendKeys (strGrossValueAgreed);
		orClaimMOJActions.ddlGrossValueAgreed.click ();

	}

	public void typeGrossValueOffered (String strValueOffered)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtGrossValueOffered));
		orClaimMOJActions.txtGrossValueOffered.click ();
		orClaimMOJActions.txtGrossValueOffered.sendKeys (strValueOffered);

	}

	public String typeDifferenceInValueClaimedAndOffered (double dblDifferenceOfOfferedAndClaimed)
	{
		String strGrossValueClaimed = orClaimMOJActions.lblGrossValueClaimed.getText ();
		// strGrossValueClaimed = StringUtils.substringBefore
		// (strGrossValueClaimed, ".");
		double dblGrossValueClaimed = Double.parseDouble (strGrossValueClaimed);
		String strGrossValueOffered = Double.toString (dblGrossValueClaimed - dblDifferenceOfOfferedAndClaimed);

		return strGrossValueOffered;
	}

	public void typeDefendantComments ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txaDefendantComments));
		orClaimMOJActions.txaDefendantComments.click ();
		orClaimMOJActions.txaDefendantComments.sendKeys ("Defendant comments are added as random text: " + RandomLetters.produceRandomString (5));
	}

	public void typeContributoryDeductions (String strContributoryDeductions)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		if (orClaimMOJActions.txtContributoryDeductions.isDisplayed ())
		{
			wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtContributoryDeductions));
			orClaimMOJActions.txtContributoryDeductions.click ();
			orClaimMOJActions.txtContributoryDeductions.sendKeys (strContributoryDeductions);
		}
	}

	public void clickLossSave ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnLossSave));
		orClaimMOJActions.btnLossSave.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	public void clickRequestTimeoutExtention ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnRequestTimeoutExtention));
		orClaimMOJActions.btnRequestTimeoutExtention.click ();

	}

	public void clickRejectRequest ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnRejectRequest));
		orClaimMOJActions.btnRejectRequest.click ();

	}

	public void typeRejectionComments ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txaRejectionComments));
		orClaimMOJActions.txaRejectionComments.click ();
		orClaimMOJActions.txaRejectionComments.sendKeys ("Rejection comments are added as random text: " + RandomLetters.produceRandomString (5));
	}

	public void clickSaveRejectRequest ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnSaveRejectRequest));
		orClaimMOJActions.btnSaveRejectRequest.click ();

	}

	public void clickSendDecision ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnSendDecision));
		orClaimMOJActions.btnSendDecision.click ();

	}

	public String returnNetValueOfOffer ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.lblNetValueOfOffer));
		String strNewValueOfOffer = orClaimMOJActions.lblNetValueOfOffer.getText ();
		return strNewValueOfOffer;
	}

	public void clickStateFraud ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnStateFraud));
		orClaimMOJActions.btnStateFraud.click ();

	}

	public void typeStateFraud (String strStateFraud)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtStateFraud));
		orClaimMOJActions.txtStateFraud.click ();
		orClaimMOJActions.txtStateFraud.sendKeys (strStateFraud);

	}

	public void clickSave ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnSave));
		orClaimMOJActions.btnSave.click ();

	}

	public void clickConfirm ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnConfirm));
		orClaimMOJActions.btnConfirm.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	public void clickViewCNF ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnViewCNF));
		orClaimMOJActions.btnViewCNF.click ();
	}

	public void clickExitProcess ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnExitProcess));
		orClaimMOJActions.btnExitProcess.click ();
	}

	public void selectReasonToExit ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.ddlReasonToExit));
		orClaimMOJActions.ddlReasonToExit.click ();
		Select oReasonToExit = new Select (orClaimMOJActions.ddlReasonToExit);
		// Select a random reason from the returned list
		List<WebElement> selections = oReasonToExit.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oReasonToExit.selectByIndex (index);
		orClaimMOJActions.ddlReasonToExit.click ();
	}

	public String returnReasonToExit ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.ddlReasonToExit));
		Select oReasonToExit = new Select (orClaimMOJActions.ddlReasonToExit);
		String srtReasonToExit = oReasonToExit.getFirstSelectedOption ().getAttribute ("text");
		return srtReasonToExit;

	}

	public void typeExitComments ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtExitComments));

		orClaimMOJActions.txtExitComments.click ();
		orClaimMOJActions.txtExitComments.sendKeys ("Exit comments are added as random text: " + RandomLetters.produceRandomString (6));

	}

	public void clickSaveExitProcess ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnSaveExitProcess));
		orClaimMOJActions.btnSaveExitProcess.click ();

	}

	// Functions for controls on Stage 2 Settlement tab

	public void typeCRUReferenceNumberStage2Settlement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtCRUReferenceNumberStage2Settlement));
		orClaimMOJActions.txtCRUReferenceNumberStage2Settlement.click ();
		orClaimMOJActions.txtCRUReferenceNumberStage2Settlement.sendKeys (RandomLetters.produceRandomString (3) + RandomNumbers.produceRandomNumber (3));

	}

	public void selectSettlementPackDecision (String strSettlementPackDecision)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.ddlSettlementPackDecision));
		orClaimMOJActions.ddlSettlementPackDecision.click ();
		orClaimMOJActions.ddlSettlementPackDecision.sendKeys (strSettlementPackDecision);
		orClaimMOJActions.ddlSettlementPackDecision.click ();

	}

	public void typeCRUDeductionsStage2Settlement (String strCRUDeductions)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtCRUDeductionsStage2Settlement));
		orClaimMOJActions.txtCRUDeductionsStage2Settlement.clear ();
		orClaimMOJActions.txtCRUDeductionsStage2Settlement.sendKeys (strCRUDeductions);

	}

	public void typeDefendantResponseComments ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txaDefendantResponseComments));
		orClaimMOJActions.txaDefendantResponseComments.click ();
		orClaimMOJActions.txaDefendantResponseComments
				.sendKeys ("Defendant response comments are added as random text: " + RandomLetters.produceRandomString (5));
	}

	public void typeInterimPaymentAmounts (String strInterimPaymentAmounts)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtInterimPaymentAmounts));
		orClaimMOJActions.txtInterimPaymentAmounts.clear ();
		orClaimMOJActions.txtInterimPaymentAmounts.sendKeys (strInterimPaymentAmounts);

	}

	// This function returns true if Stage 2 losses table has incomplete
	// records, it also clicks on first incomplete record
	public boolean clickIncompleteStage2LossRequest ()
	{
		// Get number of rows in the table
		int Row_count = orClaimMOJActions.tblStage2PackLossesRows.size ();
		// Get number of visible columns in the table
		long Col_count = orClaimMOJActions.tblStage2PackLossesColumns.stream ().filter (WebElement::isDisplayed).count ();
		// divided xpath In three parts to pass Row_count and Col_count values.
		String strFirst_part = "//*[@id='CLM_SC_BO_MOJActionStage2PackLosses']/tbody/tr[";
		String strSecond_part = "]/td[";
		String strThird_part = "]/img";

		// Used for loop for number of rows.
		for (int k = 3; k <= Row_count; k++)
		{
			long j = Col_count;

			// Prepared final xpath of specific cell as per values of k and j.
			String final_xpath = strFirst_part + k + strSecond_part + j + strThird_part;
			// last cell of each row is checked and if record is incomplete,
			// record is clicked and false is returned
			String strCompleteIndicator = driver.findElement (By.xpath (final_xpath)).getAttribute ("alt");
			if (strCompleteIndicator.equals ("false"))
			{
				driver.findElement (By.xpath (final_xpath)).click ();
				return true;
			}
		}

		return false;

	}

	// This function processes all incomplete records in Stage 2 losses table.
	// It requires 4 parameters to pass for each record processing
	public void processIncompleteStage2LossRequests (String strCRUDeductions, String strGrossValueAgreed, double dblDifferenceOfOfferedAndClaimed,
			String strContributoryDeductions)
	{

		while (clickIncompleteStage2LossRequest () == true)
		{
			typeCRUDeductionsStage2Settlement (strCRUDeductions);
			selectGrossValueAgreedStage2Settlement (strGrossValueAgreed);
			String strValueOffered = typeDifferenceInValueClaimedAndOfferedStage2Settlement (dblDifferenceOfOfferedAndClaimed);
			typeGrossValueOfferedStage2Settlement (strValueOffered);
			typeDefendantCommentsStage2Settlement ();
			typeContributoryDeductionsStage2Settlement (strContributoryDeductions);
			clickLossSaveStage2Settlement ();
		}

	}

	public void selectGrossValueAgreedStage2Settlement (String strGrossValueAgreed)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.ddlGrossValueAgreedStage2Settlement));
		orClaimMOJActions.ddlGrossValueAgreedStage2Settlement.click ();
		orClaimMOJActions.ddlGrossValueAgreedStage2Settlement.sendKeys (strGrossValueAgreed);
		orClaimMOJActions.ddlGrossValueAgreedStage2Settlement.click ();

	}

	public void typeGrossValueOfferedStage2Settlement (String strValueOffered)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtGrossValueOfferedStage2Settlement));
		orClaimMOJActions.txtGrossValueOfferedStage2Settlement.click ();
		orClaimMOJActions.txtGrossValueOfferedStage2Settlement.sendKeys (strValueOffered);

	}

	public String typeDifferenceInValueClaimedAndOfferedStage2Settlement (double dblDifferenceOfOfferedAndClaimed)
	{
		String strGrossValueClaimed = orClaimMOJActions.lblGrossValueClaimedStage2Settlement.getText ();
		double dblGrossValueClaimed = Double.parseDouble (strGrossValueClaimed);
		String strGrossValueOffered = Double.toString (dblGrossValueClaimed - dblDifferenceOfOfferedAndClaimed);

		return strGrossValueOffered;
	}

	public void typeDefendantCommentsStage2Settlement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txaDefendantCommentsStage2Settlement));
		orClaimMOJActions.txaDefendantCommentsStage2Settlement.click ();
		orClaimMOJActions.txaDefendantCommentsStage2Settlement
				.sendKeys ("Defendant comments are added as random text: " + RandomLetters.produceRandomString (5));
	}

	public void typeContributoryDeductionsStage2Settlement (String strContributoryDeductions)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		if (orClaimMOJActions.txtContributoryDeductionsStage2Settlement.isDisplayed ())
		{
			wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtContributoryDeductionsStage2Settlement));
			orClaimMOJActions.txtContributoryDeductionsStage2Settlement.click ();
			orClaimMOJActions.txtContributoryDeductionsStage2Settlement.sendKeys (strContributoryDeductions);
		}
	}

	public void clickLossSaveStage2Settlement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnLossSaveStage2Settlement));
		orClaimMOJActions.btnLossSaveStage2Settlement.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	public void clickRequestTimeoutExtentionStage2Settlement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnRequestTimeoutExtentionStage2Settlement));
		orClaimMOJActions.btnRequestTimeoutExtentionStage2Settlement.click ();

	}

	public void clickSendDecisionStage2Settlement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnSendDecisionStage2Settlement));
		orClaimMOJActions.btnSendDecisionStage2Settlement.click ();

	}

	public String returnNetValueOfOfferStage2Settlement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.lblNetValueOfOfferStage2Settlement));
		String strNewValueOfOffer = orClaimMOJActions.lblNetValueOfOfferStage2Settlement.getText ();
		return strNewValueOfOffer;
	}

	public String returnTotalNetDamagesClaimedTodateStage2Settlement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.lblTotalNetDamagesClaimedTodateStage2Settlement));
		String strTotalNetDamagesClaimedTodateStage2Settlement = orClaimMOJActions.lblTotalNetDamagesClaimedTodateStage2Settlement.getText ();
		return strTotalNetDamagesClaimedTodateStage2Settlement;
	}

	public String returnInterimPaymentReceivedStage2Settlement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.lblInterimPaymentReceivedStage2Settlement));
		String strInterimPaymentReceivedStage2Settlement = orClaimMOJActions.lblInterimPaymentReceivedStage2Settlement.getText ();
		return strInterimPaymentReceivedStage2Settlement;
	}

	public void validateNetValueOfOfferTodateStage2Settlement (String strNetValueOfOfferTodateStage2Settlement) throws TestCaseValidationFailed
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.lblNetValueOfOfferTodateStage2Settlement));
		String strNetValueOfOfferTodateStage2SettlementValue = orClaimMOJActions.lblNetValueOfOfferTodateStage2Settlement.getText ();

		if (strNetValueOfOfferTodateStage2SettlementValue.equalsIgnoreCase (strNetValueOfOfferTodateStage2Settlement))
		{

			System.out.println ("Net value of offer is, " + strNetValueOfOfferTodateStage2Settlement);

		}
		else
		{
			throw new TestCaseValidationFailed ();
		}

	}

	public void validateLossesOfferedTodateStage2Settlement (String strLossesOfferedTodateStage2Settlement) throws TestCaseValidationFailed
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.lblLossesOfferedTodateStage2Settlement));
		String strLossesOfferedTodateStage2SettlementValue = orClaimMOJActions.lblLossesOfferedTodateStage2Settlement.getText ();

		if (strLossesOfferedTodateStage2SettlementValue.equalsIgnoreCase (strLossesOfferedTodateStage2Settlement))
		{

			System.out.println ("Losses offered to date is " + strLossesOfferedTodateStage2Settlement);

		}
		else
		{
			throw new TestCaseValidationFailed ();
		}

	}

	// This validates all loss requests in Stage 2 Loss Request table should be complete
	public void validateStage2LossRequestsCompleted () throws TestCaseValidationFailed
	{
		// Get number of rows in the table
		int Row_count = orClaimMOJActions.tblStage2PackLossesRows.size ();
		// Get number of visible columns in the table
		long Col_count = orClaimMOJActions.tblStage2PackLossesColumns.stream ().filter (WebElement::isDisplayed).count ();
		// divided xpath In three parts to pass Row_count and Col_count values.
		String strFirst_part = "//*[@id='CLM_SC_BO_MOJActionStage2PackLosses']/tbody/tr[";
		String strSecond_part = "]/td[";
		String strThird_part = "]/img";

		// Used for loop for number of rows.
		for (int k = 3; k <= Row_count; k++)
		{
			long j = Col_count;

			// Prepared final xpath of specific cell as per values of k and j.
			String final_xpath = strFirst_part + k + strSecond_part + j + strThird_part;
			// last cell of each row is checked and if any record is incomplete then test case validation fails
			String strCompleteIndicator = driver.findElement (By.xpath (final_xpath)).getAttribute ("alt");
			if (strCompleteIndicator.equals ("true"))
			{
				System.out.println ("Stage 2 loss request row " + (k - 2) + " is marked as Complete.");
			}
			else
			{
				throw new TestCaseValidationFailed ();

			}
		}

	}

	public void selectExtensionReasonStage2Settlement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.ddlExtensionReasonStage2Settlement));

		Select oExtensionReason = new Select (orClaimMOJActions.ddlExtensionReasonStage2Settlement);

		List<WebElement> selections = oExtensionReason.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oExtensionReason.selectByIndex (intIndex);

	}

	public String returnExtensionReasonStage2Settlement ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.ddlExtensionReasonStage2Settlement));
		Select oExtensionReason = new Select (orClaimMOJActions.ddlExtensionReasonStage2Settlement);
		String srtExtensionReason = oExtensionReason.getFirstSelectedOption ().getAttribute ("text");
		return srtExtensionReason;

	}

	public void typeRevisedTimeoutDateStage2Settlement (String strRevisedTimeoutDate)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.txtRevisedTimeoutDateStage2Settlement));

		orClaimMOJActions.txtRevisedTimeoutDateStage2Settlement.sendKeys (strRevisedTimeoutDate);

	}

	public void clickSendRequestStage2Settlement ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJActions.btnSendRequestStage2Settlement));
		orClaimMOJActions.btnSendRequestStage2Settlement.click ();

	}

	public void validateRequestTimeoutExtensionNotDisplayedStage2Settlement () throws TestCaseValidationFailed
	{
		try
		{
			if (orClaimMOJActions.btnRequestTimeoutExtentionStage2Settlement.isDisplayed ())
			{
				throw new TestCaseValidationFailed ();
			}
		}
		catch (Exception e)
		{

			{
				System.out.println ("Request timeout extension button is not displayed.");
			}
		}
	}

	public void validateSendDecisionNotDisplayedStage2Settlement () throws TestCaseValidationFailed
	{
		try
		{
			if (orClaimMOJActions.btnSendDecisionStage2Settlement.isDisplayed ())
			{
				throw new TestCaseValidationFailed ();
			}
		}
		catch (Exception e)
		{

			{
				System.out.println ("Send decision button is not displayed.");
			}
		}
	}

	public void validateStateFraudNotDisplayed () throws TestCaseValidationFailed
	{
		try
		{
			if (orClaimMOJActions.btnStateFraud.isDisplayed ())
			{
				throw new TestCaseValidationFailed ();
			}
		}
		catch (Exception e)
		{

			{
				System.out.println ("State fraud button is not displayed.");
			}
		}
	}

	public void validateExitProcessNotDisplayed () throws TestCaseValidationFailed
	{
		try
		{
			if (orClaimMOJActions.btnExitProcess.isDisplayed ())
			{
				throw new TestCaseValidationFailed ();
			}
		}
		catch (Exception e)
		{

			{
				System.out.println ("Exit process button is not displayed.");
			}
		}
	}

}
