package com.innovation.pages.claim.pages;

import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.DatabaseData;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.misc.TableHandler;
import com.innovation.misc.TransactionTimer;
import com.innovation.pages.claim.objects.OR_ClaimMOJClaims;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.common.pages.NavigationPanel;
import com.innovation.sql.common.CommonSQL;
import com.innovation.sql.moj.MOJSQL;

/*
 * @author  Rizwan - this class stores all the locators and methods on 'MOJ Claims' frame accessible through Desktop > Navigation panel > Claims 
 *  
 */

public class ClaimMOJClaims
{
	WebDriver			driver;
	OR_ClaimMOJClaims	orClaimMOJClaims	= null;
	OR_ControlPanel		orControlPanel		= null;

	public ClaimMOJClaims (WebDriver driver)
	{
		this.driver = driver;
		orClaimMOJClaims = PageFactory.initElements (driver, OR_ClaimMOJClaims.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);

	}

	public void selectMOJClaimForAcceptance (String strEnvironmentName, String strClaimNumber) throws Exception
	{
		boolean blnClaimSelected;
		String strSQLQuery;
		List<String> lstMOJClaimsRefreshData;
		String strCurrentRefreshDataValue;
		int intPageRefresh = 0;

		StopWatch stopwatch = new StopWatch ();
		NavigationPanel navigationpanel = new NavigationPanel (driver);

		// First check in database if Refresh data button clicked by someone else has already loaded your MOJ claim. If so,
		// then just load the frame.
		strSQLQuery = MOJSQL.returnTransIdForMOJClaimAfterRefreshData (strClaimNumber);
		try
		{
			lstMOJClaimsRefreshData = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
			strCurrentRefreshDataValue = lstMOJClaimsRefreshData.get (0);
			System.out.print (strCurrentRefreshDataValue + "\n");
			System.out.print ("Refresh data button is clicked by someone else.\n");
			do
			{
				intPageRefresh = intPageRefresh + 1;
				TransactionTimer.start (stopwatch);
				navigationpanel.clickMOJClaims ();
				TransactionTimer.stop (stopwatch, "MOJ Claims", driver, strEnvironmentName);
				clickCNFRefNo ();
				blnClaimSelected = selectMOJClaim (strClaimNumber);
			} while (blnClaimSelected == false && intPageRefresh <= 3);
		}
		catch (Exception e)
		{
			TransactionTimer.start (stopwatch);
			navigationpanel.clickMOJClaims ();
			TransactionTimer.stop (stopwatch, "MOJ Claims", driver, strEnvironmentName);
			do
			{
				intPageRefresh = intPageRefresh + 1;
				clickRefreshData (strEnvironmentName);
				clickCNFRefNo ();
				blnClaimSelected = selectMOJClaim (strClaimNumber);
			} while (blnClaimSelected == false && intPageRefresh <= 3);
		}

	}

	public void clickRefreshData (String strEnvironmentName) throws Exception
	{
		String strErrorType = "No Refresh button error!";
		String strSQLQuery;
		List<String> lstMOJClaimsRefreshDataStatus;
		String strCurrentRefreshDataStatusValue;

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getLongWaitTime ());
		NavigationPanel navigationpanel = new NavigationPanel (driver);

		// First check from DB if Refresh data button has just been clicked by someone else and data refresh is already in
		// progress
		strSQLQuery = CommonSQL.returnMOJClaimsRefreshDataStatus ();
		lstMOJClaimsRefreshDataStatus = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		strCurrentRefreshDataStatusValue = lstMOJClaimsRefreshDataStatus.get (0);

		// If refresh data is already in progress then keep checking database until it is complete.
		if (strCurrentRefreshDataStatusValue.equalsIgnoreCase ("0"))
		{
			do
			{
				strSQLQuery = CommonSQL.returnMOJClaimsRefreshDataStatus ();
				lstMOJClaimsRefreshDataStatus = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
				strCurrentRefreshDataStatusValue = lstMOJClaimsRefreshDataStatus.get (0);
			} while (strCurrentRefreshDataStatusValue.equalsIgnoreCase ("0"));

			System.out.print ("Refresh data button is clicked by someone else.\n");
			navigationpanel.clickMOJClaims ();
		}
		else
		{
			wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.btnRefreshData));
			orClaimMOJClaims.btnRefreshData.click ();
			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
			// Find out if Refresh data button has just been clicked by someone else and frame displays the error that Claim
			// list refresh is already in progress.
			try
			{
				strErrorType = orClaimMOJClaims.lblErrorType.getText ();
			}
			catch (Exception e)
			{
				strErrorType = "No Refresh button error!";
				System.out.print ("Refresh data button is clicked by this test.\n");
			}

			// If error occurs then keep checking database until Refresh data service is complete.
			if (!strErrorType.equalsIgnoreCase ("No Refresh button error!"))
			{

				do
				{
					strSQLQuery = CommonSQL.returnMOJClaimsRefreshDataStatus ();
					lstMOJClaimsRefreshDataStatus = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
					strCurrentRefreshDataStatusValue = lstMOJClaimsRefreshDataStatus.get (0);
				} while (strCurrentRefreshDataStatusValue.equalsIgnoreCase ("0"));

				System.out.print ("Refresh data button is clicked by someone else.\n");
				navigationpanel.clickMOJClaims ();

			}

		}

	}

	public void typeFrom (String strFromDate)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.txtFrom));
		orClaimMOJClaims.txtFrom.click ();
		orClaimMOJClaims.txtFrom.sendKeys (strFromDate);

	}

	public void clickApply ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.btnApply));
		orClaimMOJClaims.btnApply.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void clickCNFRefNo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.lnkCNFRefNo));
		orClaimMOJClaims.lnkCNFRefNo.click ();
	}

	// Radio button Filter by is selected as per parameter value. Pass 'Unmatched' /
	// 'U', 'Open' / 'O' or 'All' / 'A'
	public void selectFilterBy (String strFilterBy)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		if (strFilterBy.equalsIgnoreCase ("Unmatched") || strFilterBy.equalsIgnoreCase ("U"))
		{
			List<WebElement> radiobuttons = orClaimMOJClaims.rdoFilterBy;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("U"))
				{
					radiobutton.click ();
					wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
					break;
				}
			}
		}
		else if ((strFilterBy.equalsIgnoreCase ("Open") || strFilterBy.equalsIgnoreCase ("O")))
		{
			List<WebElement> radiobuttons = orClaimMOJClaims.rdoFilterBy;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("O"))
				{
					radiobutton.click ();
					wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
					break;
				}

			}
		}
		else if ((strFilterBy.equalsIgnoreCase ("All") || strFilterBy.equalsIgnoreCase ("A")))
		{
			List<WebElement> radiobuttons = orClaimMOJClaims.rdoFilterBy;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("A"))
				{
					radiobutton.click ();
					wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
					break;
				}

			}
		}
	}

	// Pass a value from the row as a parameter, to select the row, e.g. the CNF Ref
	// no.
	public boolean selectMOJClaim (String strRowText)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.tblMOJClaims));

		// Passing table id, and a text string from table data to click on the
		// respective row
		TableHandler tablehandler = new TableHandler (driver);
		// Passed table name, row to search in table and number of pages to check in parameters
		boolean blnClaimSelected = tablehandler.selectRowInTableWithPages ("CLM_SC_MOJClaims", strRowText, "2");
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		return blnClaimSelected;

	}

	public void clickViewCNF ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.btnViewCNF));
		orClaimMOJClaims.btnViewCNF.click ();
	}

	public void selectAction (String strClaimAction)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimMOJClaims.ddlAction, strClaimAction));
		orClaimMOJClaims.ddlAction.click ();
		orClaimMOJClaims.ddlAction.sendKeys (strClaimAction);
		orClaimMOJClaims.ddlAction.click ();
	}

	public void typeClaimNumber (String strClaimNumber)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		SeleniumWaiter.elementIsLoaded (orClaimMOJClaims.lblInsurerMatchedClaim);
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.txtClaimNumber));
		orClaimMOJClaims.txtClaimNumber.click ();
		orClaimMOJClaims.txtClaimNumber.sendKeys (strClaimNumber);
	}

	public void clickFetchClaimants ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.btnFetchClaimants));
		orClaimMOJClaims.btnFetchClaimants.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Pass 'Random' to select a random value. Otherwise pass specific value for
	// selection
	public void selectClaimant (String strClaimant)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		SeleniumWaiter.elementIsLoaded (orClaimMOJClaims.ddlClaimant);
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimMOJClaims.ddlClaimant, " "));

		if (strClaimant.equalsIgnoreCase ("Random"))
		{

			Select oClaimant = new Select (orClaimMOJClaims.ddlClaimant);

			List<WebElement> selections = oClaimant.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oClaimant.selectByIndex (intIndex);
		}
		else
		{
			orClaimMOJClaims.ddlClaimant.click ();
			orClaimMOJClaims.ddlClaimant.sendKeys (strClaimant);
			orClaimMOJClaims.ddlClaimant.click ();
		}
	}

	public void clickCancel ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.btnCancel));
		orClaimMOJClaims.btnCancel.click ();
	}

	public void clickAcceptCNF ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.btnAcceptCNF));
		orClaimMOJClaims.btnAcceptCNF.click ();
	}

	public void selectUser (String strUser)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.ddlUser));
		orClaimMOJClaims.ddlUser.click ();
		orClaimMOJClaims.ddlUser.sendKeys (strUser);
		orClaimMOJClaims.ddlUser.click ();
	}

	public void clickSave ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.btnSave));
		orClaimMOJClaims.btnSave.click ();
	}

	public void typeInsurerSearch (String strInsurer)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.ddlUser));
		orClaimMOJClaims.txtInsurerSearch.click ();
		orClaimMOJClaims.txtInsurerSearch.sendKeys (strInsurer);
	}

	public void clickSearch ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.btnSearch));
		orClaimMOJClaims.btnSearch.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Pass 'Random' to select a random value. Otherwise pass specific value for
	// selection
	public void selectInsurer (String strInsurer)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.textToBePresentInElement (orClaimMOJClaims.ddlInsurers, " "));
		orClaimMOJClaims.ddlInsurers.click ();

		if (strInsurer.equalsIgnoreCase ("Random"))
		{

			Select oInsurer = new Select (orClaimMOJClaims.ddlInsurers);

			List<WebElement> selections = oInsurer.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oInsurer.selectByIndex (intIndex);
			orClaimMOJClaims.ddlInsurers.click ();
		}
		else
		{
			orClaimMOJClaims.ddlInsurers.sendKeys (strInsurer);
			orClaimMOJClaims.ddlInsurers.click ();
		}
	}

	public void clickCancelReassign ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.btnCancelReassign));
		orClaimMOJClaims.btnCancelReassign.click ();
	}

	public void clickReassignCNF ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.btnReassignCNF));
		orClaimMOJClaims.btnReassignCNF.click ();
	}

	// Pass 'Random' to select a random value. Otherwise pass specific value for
	// selection
	public void selecRejectionReason (String strRejectionReason)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.textToBePresentInElement (orClaimMOJClaims.ddlRejectionReason, " "));
		orClaimMOJClaims.ddlRejectionReason.click ();

		if (strRejectionReason.equalsIgnoreCase ("Random"))
		{

			Select oRejectionReason = new Select (orClaimMOJClaims.ddlRejectionReason);

			List<WebElement> selections = oRejectionReason.getOptions ();
			int intIndex = RandomNumbers.randomNumberGenerator (1, selections.size () - 1);
			oRejectionReason.selectByIndex (intIndex);
			orClaimMOJClaims.ddlRejectionReason.click ();
		}
		else
		{
			orClaimMOJClaims.ddlRejectionReason.sendKeys (strRejectionReason);
			orClaimMOJClaims.ddlRejectionReason.click ();
		}
	}

	public void clickRejectCNF ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.btnRejectCNF));
		orClaimMOJClaims.btnRejectCNF.click ();
	}

	public void clickOpenClaim ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJClaims.btnOpenClaim));
		orClaimMOJClaims.btnOpenClaim.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

}
