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
import com.innovation.pages.claim.objects.OR_ClaimLitigation;
import com.innovation.pages.common.objects.OR_ControlPanel;

public class ClaimLitigation
{
	WebDriver			driver;
	OR_ClaimLitigation	orClaimLitigation	= null;
	OR_ControlPanel		orControlPanel		= null;

	public ClaimLitigation (WebDriver driver)
	{
		this.driver = driver;
		orClaimLitigation = PageFactory.initElements (driver, OR_ClaimLitigation.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	// Methods for fields under Management tab

	public void selectManagementTab ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.tabManagement));
		orClaimLitigation.tabManagement.click ();
	}

	public void clickAddLitigation ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.btnAddLitigation));
		orClaimLitigation.btnAddLitigation.click ();

	}

	// Title of action is passed as parameter strTitleOfAction
	public void typeTitleOfAction (String strTitleOfAction)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtTitleOfAction));

		orClaimLitigation.txtTitleOfAction.click ();
		orClaimLitigation.txtTitleOfAction.sendKeys (strTitleOfAction);
	}

	// Pass 'Random' in parameter to randomly select a value from
	// dropdown. Otherwise pass respective value for selection
	public void selectLitigationCategory (String strLitigationCategory)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.ddlLitigationCategory));
		orClaimLitigation.ddlLitigationCategory.click ();

		if (strLitigationCategory.equalsIgnoreCase ("Random"))
		{
			Select oLitigationCategory = new Select (orClaimLitigation.ddlLitigationCategory);
			// Select a random oLitigation Category from the returned list
			List<WebElement> selections = oLitigationCategory.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oLitigationCategory.selectByIndex (intIndex);
		}
		else
		{
			orClaimLitigation.ddlLitigationCategory.sendKeys (strLitigationCategory);
			orClaimLitigation.ddlLitigationCategory.click ();
		}

	}

	public void typeCourtClaimNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtCourtClaimNo));

		orClaimLitigation.txtCourtClaimNo.click ();
		orClaimLitigation.txtCourtClaimNo.sendKeys ("CCN" + RandomNumbers.produceRandomNumber (5));
	}

	public void typeDateIssued (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtDateIssued));

		orClaimLitigation.txtDateIssued.click ();
		orClaimLitigation.txtDateIssued.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typeDateServed (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtDateServed));

		orClaimLitigation.txtDateServed.click ();
		orClaimLitigation.txtDateServed.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	// Radio button Section152 is selected as per parameter
	public void selectSection152 (String strSection152)
	{

		if (strSection152.equalsIgnoreCase ("Yes") || strSection152.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimLitigation.rdoSection152;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strSection152.equalsIgnoreCase ("No") || strSection152.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimLitigation.rdoSection152;
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

	// Radio button Defective service is selected as per parameter
	public void selectDefectiveService (String strDefectiveService)
	{

		if (strDefectiveService.equalsIgnoreCase ("Yes") || strDefectiveService.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimLitigation.rdoDefectiveService;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strDefectiveService.equalsIgnoreCase ("No") || strDefectiveService.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimLitigation.rdoDefectiveService;
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

	// Pass 'Random' in parameter to randomly select a value from
	// dropdown. Otherwise pass respective value for selection
	public void selectType (String strCPRType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.ddlTypeCPR));

		orClaimLitigation.ddlTypeCPR.click ();
		if (strCPRType.equalsIgnoreCase ("Random"))
		{
			Select oTypeCPR = new Select (orClaimLitigation.ddlTypeCPR);

			// Select a random CPR type from the returned list
			List<WebElement> selections = oTypeCPR.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oTypeCPR.selectByIndex (intIndex);
		}
		else
		{
			orClaimLitigation.ddlTypeCPR.sendKeys (strCPRType);
			orClaimLitigation.ddlTypeCPR.click ();
		}
	}

	// Radio button Requested is selected as per parameter
	public void selectRequested (String strRequested)
	{

		if (strRequested.equalsIgnoreCase ("Yes") || strRequested.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimLitigation.rdoRequested;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strRequested.equalsIgnoreCase ("No") || strRequested.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimLitigation.rdoRequested;
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

	public void typeDateRequested (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtDateRequested));

		orClaimLitigation.txtDateRequested.click ();
		orClaimLitigation.txtDateRequested.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	// Entering date 3 days ahead of current date as Expected date
	public void typeDateExpected (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtDateExpected));

		orClaimLitigation.txtDateExpected.click ();
		orClaimLitigation.txtDateExpected.sendKeys (CalenderDate.returnDesiredDate (strRegion, 3, 0, 0));
	}

	// Radio button Response is selected as per parameter
	public void selectResponse (String strResponse)
	{

		if (strResponse.equalsIgnoreCase ("Yes") || strResponse.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimLitigation.rdoResponse;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strResponse.equalsIgnoreCase ("No") || strResponse.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimLitigation.rdoResponse;
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

	// Pass 'Random' in parameter to randomly select a value from
	// dropdown. Otherwise pass respective value for selection
	public void selectLitigationReason (String strLitigationReason)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.ddlLitigationReason));

		orClaimLitigation.ddlLitigationReason.click ();
		if (strLitigationReason.equalsIgnoreCase ("Random"))
		{

			Select oLitigationReason = new Select (orClaimLitigation.ddlLitigationReason);

			// Select a random Litigation Reason from the returned list
			List<WebElement> selections = oLitigationReason.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oLitigationReason.selectByIndex (intIndex);
		}
		else
		{
			orClaimLitigation.ddlLitigationReason.sendKeys (strLitigationReason);
			orClaimLitigation.ddlLitigationReason.click ();

		}

	}

	// Radio button Defence Required is selected as per parameter
	public void selectDefenceRequired (String strDefenceRequired)
	{

		if (strDefenceRequired.equalsIgnoreCase ("Yes") || strDefenceRequired.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimLitigation.rdoDefenceRequired;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strDefenceRequired.equalsIgnoreCase ("No") || strDefenceRequired.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimLitigation.rdoDefenceRequired;
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

	// Entering date 3 days ahead of current date as Expected date
	public void typeDefenceDueDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtDefenceDueDate));

		orClaimLitigation.txtDefenceDueDate.click ();
		orClaimLitigation.txtDefenceDueDate.sendKeys (CalenderDate.returnDesiredDate (strRegion, 5, 0, 0));
	}

	// Radio button Defence Required is selected as per parameter
	public void selectExtended (String strExtended)
	{

		if (strExtended.equalsIgnoreCase ("Yes") || strExtended.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimLitigation.rdoExtended;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strExtended.equalsIgnoreCase ("No") || strExtended.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimLitigation.rdoExtended;
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

	public void typeExtendedReason ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txaExtendedReason));

		orClaimLitigation.txaExtendedReason.click ();
		orClaimLitigation.txaExtendedReason
				.sendKeys ("Extended reason as entered as random text: " + RandomNumbers.produceRandomNumber (8) + " " + RandomLetters.produceRandomString (8));
	}

	public void clickSaveLitigation ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.btnSaveLitigation));
		orClaimLitigation.btnSaveLitigation.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	public void clickCancelLitigation ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.btnCancelLitigation));
		orClaimLitigation.btnCancelLitigation.click ();

	}

	// Methods for fields under WIP tab

	public void selectWIPTab ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.tabWIP));
		orClaimLitigation.tabWIP.click ();
	}

	public void selectLitigationRecord ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.tblLitigationList));

		// Calling function from TableHandler misc class to click on a random
		// row in the table
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.clickRandomTableRow ("CLM_SC_LitigationListWIP");

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	// Add party details

	public void clickAddParty ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.btnAddPartyDetails));
		orClaimLitigation.btnAddPartyDetails.click ();

	}

	// Pass 'Random' in parameter to randomly select a value from
	// dropdown. Otherwise pass respective value for selection
	public void selectPartyName (String strPartyName)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.ddlNameParty));

		orClaimLitigation.ddlNameParty.click ();
		if (strPartyName.equalsIgnoreCase ("Random"))
		{

			Select oNameParty = new Select (orClaimLitigation.ddlNameParty);

			// Select a random Party name from the returned list
			List<WebElement> selections = oNameParty.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oNameParty.selectByIndex (intIndex);
		}
		else
		{

			orClaimLitigation.ddlNameParty.sendKeys (strPartyName);
			orClaimLitigation.ddlNameParty.click ();
		}
	}

	// Pass 'Random' in parameter to randomly select a value from
	// dropdown. Otherwise pass respective value for selection
	public void selectPartyType (String strPartyType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.ddlTypeParty));
		orClaimLitigation.ddlTypeParty.click ();
		if (strPartyType.equalsIgnoreCase ("Random"))
		{

			Select oTypeParty = new Select (orClaimLitigation.ddlTypeParty);

			List<WebElement> selections = oTypeParty.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oTypeParty.selectByIndex (intIndex);
		}
		else
		{
			orClaimLitigation.ddlTypeParty.sendKeys (strPartyType);
			orClaimLitigation.ddlTypeParty.click ();
		}
	}

	public void selectPartyRepresentative ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.ddlRepresentative));

		orClaimLitigation.ddlRepresentative.click ();
		Select oRepresentative = new Select (orClaimLitigation.ddlRepresentative);

		List<WebElement> selections = oRepresentative.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oRepresentative.selectByIndex (intIndex);

	}

	public void typeDateInstructed (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtDateInstructed));

		orClaimLitigation.txtDateInstructed.click ();
		orClaimLitigation.txtDateInstructed.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	// Pass 'Random' in parameter to randomly select a value from
	// dropdown. Otherwise pass respective value for selection
	public void selectAction (String strLitigationAction)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.ddlAction));
		orClaimLitigation.ddlAction.click ();
		if (strLitigationAction.equalsIgnoreCase ("Random"))
		{

			Select oTypeParty = new Select (orClaimLitigation.ddlAction);

			List<WebElement> selections = oTypeParty.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oTypeParty.selectByIndex (intIndex);
		}
		else
		{
			orClaimLitigation.ddlAction.sendKeys (strLitigationAction);
			orClaimLitigation.ddlAction.click ();
		}
	}

	// Pass 'Random' in parameter to randomly select a value from
	// dropdown. Otherwise pass respective value for selection
	public void selectStatus (String strLitigationStatus)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.ddlStatus));
		orClaimLitigation.ddlStatus.click ();
		if (strLitigationStatus.equalsIgnoreCase ("Random"))
		{

			Select oLitigationStatus = new Select (orClaimLitigation.ddlStatus);

			List<WebElement> selections = oLitigationStatus.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oLitigationStatus.selectByIndex (intIndex);
		}
		else
		{
			orClaimLitigation.ddlStatus.sendKeys (strLitigationStatus);
			orClaimLitigation.ddlStatus.click ();
		}
	}

	// Pass 'Random' in parameter to randomly select a value from
	// dropdown. Otherwise pass respective value for selection
	public void selectOutcome (String strLitigationOutcome)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.ddlOutcome));
		orClaimLitigation.ddlOutcome.click ();
		if (strLitigationOutcome.equalsIgnoreCase ("Random"))
		{

			Select oLitigationOutcome = new Select (orClaimLitigation.ddlOutcome);

			List<WebElement> selections = oLitigationOutcome.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oLitigationOutcome.selectByIndex (intIndex);
		}
		else
		{
			orClaimLitigation.ddlOutcome.sendKeys (strLitigationOutcome);
			orClaimLitigation.ddlOutcome.click ();
		}
	}

	public void typeOutcomeDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtOutcomeDate));

		orClaimLitigation.txtOutcomeDate.click ();
		orClaimLitigation.txtOutcomeDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void clickSavePartyDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.btnSavePartyDetails));
		orClaimLitigation.btnSavePartyDetails.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void clickCancelPartyDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.btnCancelPartyDetails));
		orClaimLitigation.btnCancelPartyDetails.click ();

	}

	public void selectPartyRecord ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.tblPartyDetails));

		// Calling function from TableHandler misc class to click on a random
		// row in the table
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.clickRandomTableRow ("CLM_SC_0659_PartiesDetail");

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	// Add offer details

	public void clickAddOffer ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.btnAddOfferDetails));
		orClaimLitigation.btnAddOfferDetails.click ();

	}

	// Pass 'Random' in parameter to randomly select a value from
	// dropdown. Otherwise pass respective value for selection
	public void selectOfferType (String strOfferType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.ddlOfferType));
		orClaimLitigation.ddlOfferType.click ();
		if (strOfferType.equalsIgnoreCase ("Random"))
		{

			Select oOfferType = new Select (orClaimLitigation.ddlOfferType);

			List<WebElement> selections = oOfferType.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oOfferType.selectByIndex (intIndex);
		}
		else
		{
			orClaimLitigation.ddlOfferType.sendKeys (strOfferType);
			orClaimLitigation.ddlOfferType.click ();
		}
	}

	// Pass 'Random' in parameter to randomly select a value from
	// dropdown. Otherwise pass respective value for selection
	public void selectOffer (String strOffer)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.ddlOffer));
		orClaimLitigation.ddlOffer.click ();
		if (strOffer.equalsIgnoreCase ("Random"))
		{

			Select oOffer = new Select (orClaimLitigation.ddlOffer);

			List<WebElement> selections = oOffer.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oOffer.selectByIndex (intIndex);
		}
		else
		{
			orClaimLitigation.ddlOffer.sendKeys (strOffer);
			orClaimLitigation.ddlOffer.click ();
		}
	}

	// Pass 'Random' in parameter to randomly select a value from
	// dropdown. Otherwise pass respective value for selection
	public void selectOfferStatus (String strOfferStatus)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.ddlStatusOffer));
		orClaimLitigation.ddlStatusOffer.click ();
		if (strOfferStatus.equalsIgnoreCase ("Random"))
		{

			Select oOfferStatus = new Select (orClaimLitigation.ddlStatusOffer);

			List<WebElement> selections = oOfferStatus.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oOfferStatus.selectByIndex (intIndex);
		}
		else
		{
			orClaimLitigation.ddlStatusOffer.sendKeys (strOfferStatus);
			orClaimLitigation.ddlStatusOffer.click ();
		}
	}

	public void typeSplitPercentage ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtSplitPercentage));

		orClaimLitigation.txtSplitPercentage.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typeAmount ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtOfferAmount));

		orClaimLitigation.txtOfferAmount.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void clickSaveOfferDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.btnSaveOffer));
		orClaimLitigation.btnSaveOffer.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void clickCancelOfferDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.btnCancelOffer));
		orClaimLitigation.btnCancelOffer.click ();

	}

	// Add Evaluation details

	public void clickAddEvalutation ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.btnAddEvaluation));
		orClaimLitigation.btnAddEvaluation.click ();

	}

	public void typeEvaluationDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtEvaluationDate));

		orClaimLitigation.txtEvaluationDate.click ();
		orClaimLitigation.txtEvaluationDate.sendKeys (CalenderDate.returnCurrentDate (strRegion));
	}

	public void typeVehicleAmount ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtVehicleAmount));

		orClaimLitigation.txtVehicleAmount.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typePropertyAmount ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtPropertyAmount));

		orClaimLitigation.txtPropertyAmount.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typeSpecialAmount ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtSpecialAmount));

		orClaimLitigation.txtSpecialAmount.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typeGeneralDamageAmount ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtGeneralAmount));

		orClaimLitigation.txtGeneralAmount.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typeInterestAmount ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtInterestAmount));

		orClaimLitigation.txtInterestAmount.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typeOwnCostsAmount ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtOwnCostsAmount));

		orClaimLitigation.txtOwnCostsAmount.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typeClaimantCostsAmount ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtClaimantCostsAmount));

		orClaimLitigation.txtClaimantCostsAmount.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void typeLiabilityPercentage ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.txtLiabilityPercentage));
		orClaimLitigation.txtLiabilityPercentage.clear ();
		orClaimLitigation.txtLiabilityPercentage.sendKeys (RandomNumbers.produceRandomNumber (2));
	}

	public void clickSaveEvaluationDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.btnSaveEvaluation));
		orClaimLitigation.btnSaveEvaluation.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void clickCancelEvaluationDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimLitigation.btnCancelEvaluation));
		orClaimLitigation.btnCancelEvaluation.click ();

	}

}
