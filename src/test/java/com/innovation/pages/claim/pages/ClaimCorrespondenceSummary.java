package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.SelectionHelper;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimCorrespondenceSummary;

/**
 * @author Alamq. This class stores all the locators and methods in Correspondence Summary.
 *
 */
public class ClaimCorrespondenceSummary
{
	WebDriver						driver;
	LoggingControl					loggingcontrol					= new LoggingControl ();
	OR_ClaimCorrespondenceSummary	or_ClaimCorrespondenceSummary	= null;

	public ClaimCorrespondenceSummary (WebDriver driver)
	{
		this.driver = driver;
		or_ClaimCorrespondenceSummary = PageFactory.initElements (driver, OR_ClaimCorrespondenceSummary.class);
	}

	public void typeSCCorrespondenceDateFrom ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.txtSCCorrespondenceDateFrom));

		or_ClaimCorrespondenceSummary.txtSCCorrespondenceDateFrom.click ();
		or_ClaimCorrespondenceSummary.txtSCCorrespondenceDateFrom.sendKeys (RandomLetters.produceRandomString (6));
	}

	// fill with specified text
	public void setCorrespondenceDateFrom (String txtCorrespondenceDateFrom)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.txtSCCorrespondenceDateFrom));

		or_ClaimCorrespondenceSummary.txtSCCorrespondenceDateFrom.click ();
		or_ClaimCorrespondenceSummary.txtSCCorrespondenceDateFrom.sendKeys (txtCorrespondenceDateFrom);
	}

	public void typeSCCorrespondenceDateTo ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.txtSCCorrespondenceDateTo));

		or_ClaimCorrespondenceSummary.txtSCCorrespondenceDateTo.click ();
		or_ClaimCorrespondenceSummary.txtSCCorrespondenceDateTo.sendKeys (RandomLetters.produceRandomString (999));
	}

	// fill with specified text
	public void setSCCorrespondenceDateTo (String txtSCCorrespondenceDateTo)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.txtSCCorrespondenceDateTo));

		or_ClaimCorrespondenceSummary.txtSCCorrespondenceDateTo.click ();
		or_ClaimCorrespondenceSummary.txtSCCorrespondenceDateTo.sendKeys (txtSCCorrespondenceDateTo);
	}

	public void typeDocumentName ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.txtDocumentName));

		or_ClaimCorrespondenceSummary.txtDocumentName.click ();
		or_ClaimCorrespondenceSummary.txtDocumentName.sendKeys (RandomLetters.produceRandomString (120));
	}

	// fill with specified text
	public void setDocumentName (String txtDocumentName)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.txtDocumentName));

		or_ClaimCorrespondenceSummary.txtDocumentName.click ();
		or_ClaimCorrespondenceSummary.txtDocumentName.sendKeys (txtDocumentName);
	}

	// select a random element from the list
	public void selectDocumentType ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.ddlDocumentType));

		or_ClaimCorrespondenceSummary.ddlDocumentType.click ();
		Select oDocumentType = new Select (or_ClaimCorrespondenceSummary.ddlDocumentType);

		// Select a random Document Type from the returned list
		List<WebElement> selections = oDocumentType.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oDocumentType.selectByIndex (index);
	}

	// select a specified value
	public void selectDocumentType (String ddlDocumentType)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.ddlDocumentType));

		or_ClaimCorrespondenceSummary.ddlDocumentType.click ();
		Select oDocumentType = new Select (or_ClaimCorrespondenceSummary.ddlDocumentType);
		oDocumentType.selectByVisibleText (ddlDocumentType);
	}

	// select a random element from the list
	public void selectDocumentSubType ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.ddlDocumentSubType));

		or_ClaimCorrespondenceSummary.ddlDocumentSubType.click ();
		Select oDocumentSubType = new Select (or_ClaimCorrespondenceSummary.ddlDocumentSubType);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oDocumentSubType.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oDocumentSubType.selectByIndex (index);
	}

	// select a specified value
	public void selectDocumentSubType (String ddlDocumentSubType)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.ddlDocumentSubType));

		or_ClaimCorrespondenceSummary.ddlDocumentSubType.click ();
		Select oDocumentSubType = new Select (or_ClaimCorrespondenceSummary.ddlDocumentSubType);
		oDocumentSubType.selectByVisibleText (ddlDocumentSubType);
	}

	public void typeDocumentDescription ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.txtDocumentDescription));

		or_ClaimCorrespondenceSummary.txtDocumentDescription.click ();
		or_ClaimCorrespondenceSummary.txtDocumentDescription.sendKeys (RandomLetters.produceRandomString (999));
	}

	// fill with specified text
	public void setDocumentDescription (String txtDocumentDescription)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.txtDocumentDescription));

		or_ClaimCorrespondenceSummary.txtDocumentDescription.click ();
		or_ClaimCorrespondenceSummary.txtDocumentDescription.sendKeys (txtDocumentDescription);
	}

	public void selectAttachTo (String strAttachTo)
	{
		boolean allowUnknown = false;
		boolean defaultElse = false;
		int elseValue = 2;
		SelectionHelper.selectRadio (or_ClaimCorrespondenceSummary.rdoAttachTo, strAttachTo, allowUnknown, defaultElse, elseValue);
	}

	// select a random element from the list
	public void selectUploadParty ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.ddlParty));

		or_ClaimCorrespondenceSummary.ddlParty.click ();
		Select oUploadParty = new Select (or_ClaimCorrespondenceSummary.ddlParty);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oUploadParty.getOptions ();
		// oUploadParty.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oUploadParty.selectByIndex (index);
	}

	// select a specified value
	public void selectUploadParty (String ddlUploadParty)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.ddlParty));

		or_ClaimCorrespondenceSummary.ddlParty.click ();
		Select oUploadParty = new Select (or_ClaimCorrespondenceSummary.ddlParty);
		oUploadParty.selectByVisibleText (ddlUploadParty);
	}

	// select a random element from the list
	public void selectFeature ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.ddlFeature));

		or_ClaimCorrespondenceSummary.ddlFeature.click ();
		Select oFeature = new Select (or_ClaimCorrespondenceSummary.ddlFeature);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oFeature.getOptions ();
		oFeature.selectByIndex (RandomNumbers.randomNumberGenerator (0, 1));
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oFeature.selectByIndex (index);
	}

	// select a specified value
	public void selectFeature (String ddlFeature)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.ddlFeature));

		or_ClaimCorrespondenceSummary.ddlFeature.click ();
		Select oFeature = new Select (or_ClaimCorrespondenceSummary.ddlFeature);
		oFeature.selectByVisibleText (ddlFeature);
	}

	public void clickView ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.btnView));

		or_ClaimCorrespondenceSummary.btnView.click ();

	}

	// Selects a random record from the listed vehicles table
	public void selectRandomDocuments ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.tblDocumentList));
		wait.until (ExpectedConditions.invisibilityOf (or_ClaimCorrespondenceSummary.prgProgressBar));
		// Calling function from TableHandler misc class to click on a random
		// row in the table based on table id parameters
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.clickRandomTableRow ("CLM_SC_0155_CorrespondenceOut");

		// This waits until the progress bar goes invisible
		wait.until (ExpectedConditions.invisibilityOf (or_ClaimCorrespondenceSummary.prgProgressBar));
	}

	public void clickResend ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.btnResend));

		or_ClaimCorrespondenceSummary.btnResend.click ();

	}

	public void clickCancel ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.btnCancel));

		or_ClaimCorrespondenceSummary.btnCancel.click ();

	}

	public void clickHistory ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (or_ClaimCorrespondenceSummary.btnHistory));

		or_ClaimCorrespondenceSummary.btnHistory.click ();

	}

	public void closeDocument ()
	{

		// following string will handle window that will be opened

		// now the following list of the windows will contain how many windows actually
		// open

		String strCurrentWindow = driver.getWindowHandle ();

		for (String strNewWindowHandle : driver.getWindowHandles ())
		{
			driver.switchTo ().window (strNewWindowHandle);
		}

		driver.close ();

		driver.switchTo ().window (strCurrentWindow);

	}

}
