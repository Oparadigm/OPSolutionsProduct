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
import com.innovation.pages.claim.objects.OR_ClaimComplaintsManagement;

public class ClaimComplaintsManagement
{
	WebDriver						driver;
	OR_ClaimComplaintsManagement	orClaimComplaintsManagement	= null;

	public ClaimComplaintsManagement (WebDriver driver)
	{
		this.driver = driver;
		orClaimComplaintsManagement = PageFactory.initElements (driver, OR_ClaimComplaintsManagement.class);
	}

	public void clickAddComplaint ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.btnAddComplaint));

		orClaimComplaintsManagement.btnAddComplaint.click ();
	}

	// Complainant details section
	public void selectName ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.ddlName));

		orClaimComplaintsManagement.ddlName.click ();
		Select oName = new Select (orClaimComplaintsManagement.ddlName);

		// Selects a random Name from the returned list
		List<WebElement> selections = oName.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oName.selectByIndex (intIndex);
	}

	public void selectCommunicatedBy ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.ddlCommunicatedBy));

		orClaimComplaintsManagement.ddlCommunicatedBy.click ();
		Select oCommBy = new Select (orClaimComplaintsManagement.ddlCommunicatedBy);

		// Select a random Communicated by value from the returned list
		List<WebElement> selections = oCommBy.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oCommBy.selectByIndex (intIndex);
	}

	public void typeReferenceNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.txtReferenceNo));

		orClaimComplaintsManagement.txtReferenceNo.click ();
		orClaimComplaintsManagement.txtReferenceNo.sendKeys ("CRN" + RandomNumbers.produceRandomNumber (5));
	}

	// Complaint details section
	public void selectProductType ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.ddlProductType));

		orClaimComplaintsManagement.ddlProductType.click ();
		Select oProdType = new Select (orClaimComplaintsManagement.ddlProductType);

		// Select a random coverage value from the returned list
		List<WebElement> selections = oProdType.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oProdType.selectByIndex (intIndex);
	}

	public void selectType ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.cboType));

		orClaimComplaintsManagement.cboType.click ();
		Select oType = new Select (orClaimComplaintsManagement.cboTypeValues);

		// Select a random Complaint type from the returned list
		List<WebElement> selections = oType.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oType.selectByIndex (intIndex);
	}

	public void selectCategory ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.cboCategory));

		orClaimComplaintsManagement.cboCategory.click ();
		Select oCategory = new Select (orClaimComplaintsManagement.cboCategoryValues);

		// Select a random Complaint Category from the returned list
		List<WebElement> selections = oCategory.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oCategory.selectByIndex (intIndex);
	}

	public void selectRegularityIndicator ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.ddlRegulatoryIndicator));

		orClaimComplaintsManagement.ddlRegulatoryIndicator.click ();
		Select oRegInd = new Select (orClaimComplaintsManagement.ddlRegulatoryIndicator);

		// Select a random Regulatory indicator from the returned list
		List<WebElement> selections = oRegInd.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oRegInd.selectByIndex (intIndex);
	}

	public void typeAgainst (String strAgainst)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.txtAgainst));

		orClaimComplaintsManagement.txtAgainst.click ();
		orClaimComplaintsManagement.txtAgainst.sendKeys (strAgainst);
	}

	public void selectRootCause ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.ddlRootCause));

		orClaimComplaintsManagement.ddlRootCause.click ();
		Select oRootCause = new Select (orClaimComplaintsManagement.ddlRootCause);

		// Select a random coverage value from the returned list
		List<WebElement> selections = oRootCause.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oRootCause.selectByIndex (intIndex);
	}

	public void selectHowReceived ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.ddlHowReceived));

		orClaimComplaintsManagement.ddlHowReceived.click ();
		Select oHowReceived = new Select (orClaimComplaintsManagement.ddlHowReceived);

		// Select a random coverage value from the returned list
		List<WebElement> selections = oHowReceived.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oHowReceived.selectByIndex (intIndex);
	}

	public void typeDateAcknowledged (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.dtpDateAcknowledged));

		orClaimComplaintsManagement.dtpDateAcknowledged.click ();
		orClaimComplaintsManagement.dtpDateAcknowledged.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typeSummary ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.txaSummary));

		orClaimComplaintsManagement.txaSummary.click ();
		orClaimComplaintsManagement.txaSummary.sendKeys (
				"Complaint summary is added here as a random text: " + RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	// Complaint tracking section
	public void selectStatus (String strStatus)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.ddlStatus));

		orClaimComplaintsManagement.ddlStatus.click ();
		orClaimComplaintsManagement.ddlStatus.sendKeys (strStatus);
		;
		orClaimComplaintsManagement.ddlStatus.click ();
	}

	public void selectCurrentStage ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.cboCurrentStage));

		orClaimComplaintsManagement.cboCurrentStage.click ();
		Select oCurrentStage = new Select (orClaimComplaintsManagement.cboCurrentStageValues);

		// Select a random Current stage from the returned list
		List<WebElement> selections = oCurrentStage.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oCurrentStage.selectByIndex (intIndex);
	}

	public void selectOwningTeam ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.ddlOwningTeam));

		orClaimComplaintsManagement.ddlOwningTeam.click ();
		Select oOwnTeam = new Select (orClaimComplaintsManagement.ddlOwningTeam);

		// Select a random Owning team value from the returned list
		List<WebElement> selections = oOwnTeam.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oOwnTeam.selectByIndex (intIndex);
	}

	public void selectOwner ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.ddlOwner));

		orClaimComplaintsManagement.ddlOwner.click ();
		Select oOwner = new Select (orClaimComplaintsManagement.ddlOwner);

		// Select a random coverage value from the returned list
		List<WebElement> selections = oOwner.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oOwner.selectByIndex (intIndex);
	}

	public void typeDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.txaAddDetails));

		orClaimComplaintsManagement.txaAddDetails.click ();
		orClaimComplaintsManagement.txaAddDetails.sendKeys (
				"Complaint details are added here as a random text: " + RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	// Complaint outcome section
	public void selectHowResolved ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.ddlHowResolved));

		orClaimComplaintsManagement.ddlHowResolved.click ();
		Select oHowResolved = new Select (orClaimComplaintsManagement.ddlHowResolved);

		// Select a random How resolved value from the returned list
		List<WebElement> selections = oHowResolved.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oHowResolved.selectByIndex (intIndex);
	}

	public void typeResolutionDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.dtpResolutionDate));

		orClaimComplaintsManagement.dtpResolutionDate.click ();
		orClaimComplaintsManagement.dtpResolutionDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void selectOutcome ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.ddlOutcome));

		orClaimComplaintsManagement.ddlOutcome.click ();
		Select oOutcome = new Select (orClaimComplaintsManagement.ddlOutcome);

		// Select a random Outcome value from the returned list
		List<WebElement> selections = oOutcome.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oOutcome.selectByIndex (intIndex);
	}

	public void typeCompensationPaid ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.txtCompensationPaid));

		orClaimComplaintsManagement.txtCompensationPaid.click ();
		orClaimComplaintsManagement.txtCompensationPaid.sendKeys (RandomNumbers.produceRandomNumber (3) + ".00");
	}

	public void typeOutcomeAdditionalDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.txaAdditionalDetails));

		orClaimComplaintsManagement.txaAdditionalDetails.click ();
		orClaimComplaintsManagement.txaAdditionalDetails.sendKeys ("Overall outcome additional details are added here as a random text: " +
			RandomLetters.produceRandomString (10) + " " + RandomNumbers.produceRandomNumber (10));
	}

	public void clickSaveDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.btnSaveDetails));

		orClaimComplaintsManagement.btnSaveDetails.click ();
	}

	public void clickCancel ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.btnCancelDetails));

		orClaimComplaintsManagement.btnCancelDetails.click ();
	}

	public void clickCancelChangesYes ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.btnCancelYes));

		orClaimComplaintsManagement.btnCancelYes.click ();
	}

	public void clickCancelChangesNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimComplaintsManagement.btnCancelNo));

		orClaimComplaintsManagement.btnCancelNo.click ();
	}
}
