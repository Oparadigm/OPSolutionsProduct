package com.innovation.pages.claim.pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimSupplierSearch;
import com.innovation.pages.common.objects.OR_ControlPanel;

/**
 * @author Rizwan. This class stores all the locators and methods in Claims Supplier Search page.
 *
 */
public class ClaimSupplierSearch
{
	WebDriver				driver;
	OR_ClaimSupplierSearch	orClaimSupplierSearch	= null;
	OR_ControlPanel			orControlPanel			= null;

	public ClaimSupplierSearch (WebDriver driver)
	{
		this.driver = driver;
		orClaimSupplierSearch = PageFactory.initElements (driver, OR_ClaimSupplierSearch.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	public void selectType (String strAssociPartyType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimSupplierSearch.ddlType));

		orClaimSupplierSearch.ddlType.click ();
		orClaimSupplierSearch.ddlType.sendKeys (strAssociPartyType);
		orClaimSupplierSearch.ddlType.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void selectSearchType (String strSearchType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimSupplierSearch.ddlSearchType));

		orClaimSupplierSearch.ddlSearchType.click ();
		orClaimSupplierSearch.ddlSearchType.sendKeys (strSearchType);
		orClaimSupplierSearch.ddlSearchType.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void typeSupplierId (String strSupplierId)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimSupplierSearch.txtSupplierId));

		orClaimSupplierSearch.txtSupplierId.click ();
		orClaimSupplierSearch.txtSupplierId.sendKeys (strSupplierId);

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}
	
	public void selectProximityTo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimSupplierSearch.ddlProximityTo));

		orClaimSupplierSearch.ddlProximityTo.click ();
		Select oProximityTo = new Select (orClaimSupplierSearch.ddlProximityTo);

		// Selects a random Proximity To value from the returned list
		List<WebElement> selections = oProximityTo.getOptions ();
		int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
		oProximityTo.selectByIndex (intIndex);
	}

	public void clickSearchSupplier ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		// Get an extra long timeout for the supplier search
		Long intMaxTimOut = (long) GlobalWaitTime.getLongWaitTime ();
		wait.until (ExpectedConditions.elementToBeClickable (orClaimSupplierSearch.btnSearchSupplier));
		orClaimSupplierSearch.btnSearchSupplier.click ();

		// Added fluent wait as the progress bar takes around 2-4 minutes to load the records
		Wait<WebDriver> fWait = new FluentWait<WebDriver> (driver).withTimeout (intMaxTimOut, TimeUnit.SECONDS).pollingEvery (1, TimeUnit.SECONDS)
				.ignoring (NoSuchElementException.class);

		fWait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	public void selectSupplier ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimSupplierSearch.tblSupplierSearchResults));

		// Calling function from TableHandler misc class to click on a random
		// row in the table
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.clickRandomTableRow ("CLM_SC_BO_0375_VendorSearch");

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void selectSupplierBO ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimSupplierSearch.tblSupplierSearchResultsBO));

		// Calling function from TableHandler misc class to click on a random
		// row in the table
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.clickRandomTableRow ("CLM_SC_BO_4218_Parties_Summary");

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void clickSelectSupplierBO ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimSupplierSearch.btnSelectSupplierBO));
		orClaimSupplierSearch.btnSelectSupplierBO.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void clickAssociateSupplier ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimSupplierSearch.btnAssociateSupplier));
		orClaimSupplierSearch.btnAssociateSupplier.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		wait.until (ExpectedConditions.visibilityOf (orClaimSupplierSearch.pnlSupplierAttachmentMessage));
	}

	public void clickInstructSupplier ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimSupplierSearch.btnInstructSupplier));
		orClaimSupplierSearch.btnInstructSupplier.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		wait.until (ExpectedConditions.visibilityOf (orClaimSupplierSearch.pnlSupplierAttachmentMessage));

	}

	public void navigateBackSupplierSearch ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orControlPanel.btnPrevious));
		orControlPanel.btnPrevious.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

}
