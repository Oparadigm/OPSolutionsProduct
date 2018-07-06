package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.DatabaseData;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimMainSearch;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.sql.policy.PolicySQL;

/**
 * @author alam. This class stores all the locators and methods in Claim Search page for Home/Auto LOBs.
 *
 */
public class ClaimMainSearch
{
	WebDriver			driver;
	OR_ClaimMainSearch	orClaimMainSearch	= null;
	OR_ControlPanel		orControlPanel		= null;

	public ClaimMainSearch (WebDriver driver)
	{
		this.driver = driver;
		orClaimMainSearch = PageFactory.initElements (driver, OR_ClaimMainSearch.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	// Pass 'Name and contact' or 'Reference number' as parameter to select
	// option from Search by dropdown
	public void selectSearchBy (String strSearchBy)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimMainSearch.ddlSearchBy, strSearchBy));

		orClaimMainSearch.ddlSearchBy.click ();
		orClaimMainSearch.ddlSearchBy.sendKeys (strSearchBy);
		orClaimMainSearch.ddlSearchBy.click ();
	}

	// Pass Policy Number as parameter to search an existing policy
	public void typePolicyNo (String strPolicyNo)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.txtPolicyNo));

		orClaimMainSearch.txtPolicyNo.click ();
		orClaimMainSearch.txtPolicyNo.sendKeys (strPolicyNo);
	}

	public void clickOnSearch ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.btnSearch));

		orClaimMainSearch.btnSearch.click ();
		// This waits until the progress bar that displays to load e.g. the
		// address goes invisible
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Selects a matching record from policy search results table
	public void selectFromPolicySearchResults (String strTableName, String strRowText)
	{
		// This waits until Policy Search Results table is loaded after search
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.tblPolicySearch));

		// Calling function from TableHandler misc class to click on a row in
		// the table based on parameters
		// Pass table id into strTableName parameter. strRowText parameter
		// should be a cell's value
		// from search result table to click on.
		//
		//
		//
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.returnRowInTableWithText (strTableName, strRowText);
	}

	// Radio button DPA Check Passed is selected as per parameter
	// strDPACheckStatus; pass value Yes or No
	public void selectDPACheckStatus (String strDPACheckStatus)
	{
		if (strDPACheckStatus.equalsIgnoreCase ("Yes") || strDPACheckStatus.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimMainSearch.rdoDPACheckPassed;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if (strDPACheckStatus.equalsIgnoreCase ("No") || strDPACheckStatus.equalsIgnoreCase ("N"))
		{
			List<WebElement> radiobuttons = orClaimMainSearch.rdoDPACheckPassed;
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

	// This gets the Claim Number
	public void checkClaimNo ()
	{

		ClaimClaimSummary claimsummary = new ClaimClaimSummary (driver);
		claimsummary.getClaimNumber ();
	}

	public void selectDPAFailureReason ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.ddlDPAFailureReason));

		orClaimMainSearch.ddlDPAFailureReason.click ();
		Select oDPAFailureReaosns = new Select (orClaimMainSearch.ddlDPAFailureReason);

		// Select a random DPA Failure Reason from the returned list
		List<WebElement> selections = oDPAFailureReaosns.getOptions ();
		int intIndex = (int) (Math.random () * (selections.size () - 2)) + 2;
		oDPAFailureReaosns.selectByIndex (intIndex);
	}

	// Selects a value from Actions dropdown based on parameter
	public void selectAction (String strAction)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimMainSearch.ddlActions, strAction));

		orClaimMainSearch.ddlActions.click ();
		orClaimMainSearch.ddlActions.sendKeys (strAction);
		orClaimMainSearch.ddlActions.click ();
	}

	/*
	 * When Go button is clicked, a dialog box 'Potential duplicate claims' is displayed on the next frame if there are already
	 * claim(s) logged against the policy for which this particular claim is being initiated. In this case, user can click on 'Add
	 * claim' or 'Cancel' buttons on the dialog. Parameter strDuplicateClaimAction will be passed with 'Add' or 'Cancel'
	 * respectively to click on Add claim or Cancel button.
	 */
	public static String completePolicy (String strPolicyNumber, List<String> strPolicyNo)
	{

		String strPolicyProduct = strPolicyNo.get (0);
		String strSeqPol = strPolicyNo.get (1);
		int intPolicyNo = strSeqPol.length ();

		if (intPolicyNo == 1)
		{
			strPolicyNumber = strPolicyProduct + "00000000" + strSeqPol;
		}
		else if (intPolicyNo == 2)
		{
			strPolicyNumber = strPolicyProduct + "0000000" + strSeqPol;
		}
		else if (intPolicyNo == 3)
		{
			strPolicyNumber = strPolicyProduct + "000000" + strSeqPol;
		}
		else if (intPolicyNo == 4)
		{
			strPolicyNumber = strPolicyProduct + "00000" + strSeqPol;
		}
		else if (intPolicyNo == 5)
		{
			strPolicyNumber = strPolicyProduct + "0000" + strSeqPol;
		}
		else if (intPolicyNo == 6)
		{
			strPolicyNumber = strPolicyProduct + "000" + strSeqPol;
		}

		else if (intPolicyNo == 7)
		{
			strPolicyNumber = strPolicyProduct + "00" + strSeqPol;
		}

		else if (intPolicyNo == 8)
		{
			strPolicyNumber = strPolicyProduct + "0" + strSeqPol;
		}

		else
		{
			strPolicyNumber = strPolicyProduct + strSeqPol;
		}
		return strPolicyNumber;

	}

	public void clickOnGo (String strDuplicateClaimAction)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.btnGO));

		orClaimMainSearch.btnGO.click ();

		// This waits until the progress bar goes invisible
		// wait.until (ExpectedConditions.visibilityOf (orClaimMainSearch.prgProgressBar));
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

		try
		{
			// This waits until Duplicate claims pop up is loaded or next frame is
			// loaded
			wait.until (ExpectedConditions.or (ExpectedConditions.visibilityOf (orClaimMainSearch.dlgDuplicateClaim),
					ExpectedConditions.elementToBeClickable (orControlPanel.btnNext)));
		}
		catch (Exception e)
		{
			// This waits until Duplicate claims pop up is loaded or next frame is
			// loaded
			wait.until (ExpectedConditions.or (ExpectedConditions.visibilityOf (orClaimMainSearch.dlgDuplicateClaim),
					ExpectedConditions.elementToBeClickable (orControlPanel.btnNext)));
		}

		// This checks if dialog box 'Potential duplicate claims' is displayed
		// and then clicks on Add claim or Cancel button as per
		// parameter value.
		if (orClaimMainSearch.dlgDuplicateClaim.isDisplayed () && strDuplicateClaimAction.equalsIgnoreCase ("Add"))
		{
			wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.btnDuplicateClaimAdd));
			orClaimMainSearch.btnDuplicateClaimAdd.click ();
			// This waits until the progress bar goes invisible
			wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		}
		else if (orClaimMainSearch.dlgDuplicateClaim.isDisplayed () && strDuplicateClaimAction.equalsIgnoreCase ("Cancel"))
		{
			orClaimMainSearch.btnDuplicateClaimCancel.click ();

			wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.btnResetYes));
			orClaimMainSearch.btnResetYes.click ();
		}
		else
		{
			System.out.println ("No Claim exist on policy");
		}
	}

	public void fetchLatestHomePolicy (String strEnvironmentName, String strCompany) throws Exception
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.txtPolicyNo));
		String strSQLQuery = PolicySQL.returnLatestHomePolicy (strCompany);
		List<String> strPolicyNo = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		String strPolicyNumber = null;
		strPolicyNumber = ClaimMainSearch.completePolicy (strPolicyNumber, strPolicyNo);

		orClaimMainSearch.txtPolicyNo.sendKeys (strPolicyNumber);
		orClaimMainSearch.btnSearch.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		// claimsearch.selectFromPolicySearchResults (strTableName, strRowText);
		TableHandler tblClient = new TableHandler (driver);
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimMainSearch.tblPolicySearch, strPolicyNumber));
		tblClient.returnRowInTable ("tblPolicySearch", strPolicyNumber);

	}

	public void fetchHomePolicyBldgAndContCovers (String strEnvironmentName, String strCompany) throws Exception

	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.txtPolicyNo));
		String strSQLQuery = PolicySQL.returnHomePolicyBldgAndContCovers (strCompany);
		List<String> strPolicyNo = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		String strPolicyNumber = null;
		strPolicyNumber = ClaimMainSearch.completePolicy (strPolicyNumber, strPolicyNo);

		orClaimMainSearch.txtPolicyNo.sendKeys (strPolicyNumber);
		orClaimMainSearch.btnSearch.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		// claimsearch.selectFromPolicySearchResults (strTableName, strRowText);
		TableHandler tblClient = new TableHandler (driver);
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimMainSearch.tblPolicySearch, strPolicyNumber));
		tblClient.returnRowInTable ("tblPolicySearch", strPolicyNumber);

	}

	public void fetchLatestAutoPolicy (String strEnvironmentName, String strCompany) throws Exception
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.txtPolicyNo));
		String strSQLQuery = PolicySQL.returnLatestAutoPolicy (strCompany);
		List<String> strPolicyNo = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		String strPolicyNumber = null;
		strPolicyNumber = ClaimMainSearch.completePolicy (strPolicyNumber, strPolicyNo);

		orClaimMainSearch.txtPolicyNo.sendKeys (strPolicyNumber);
		orClaimMainSearch.btnSearch.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		// claimsearch.selectFromPolicySearchResults (strTableName, strRowText);
		TableHandler tblClient = new TableHandler (driver);
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimMainSearch.tblPolicySearch, strPolicyNumber));
		tblClient.returnRowInTable ("tblPolicySearch", strPolicyNumber);
	}

	public void fetchAutoPolicyWithComprehensiveCover (String strEnvironmentName, String strCompany) throws Exception

	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.txtPolicyNo));
		String strSQLQuery = PolicySQL.returnAutoPolicyWithComprehensiveCover (strCompany);
		List<String> strPolicyNo = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		String strPolicyNumber = null;
		strPolicyNumber = ClaimMainSearch.completePolicy (strPolicyNumber, strPolicyNo);

		orClaimMainSearch.txtPolicyNo.sendKeys (strPolicyNumber);
		orClaimMainSearch.btnSearch.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		TableHandler tblClient = new TableHandler (driver);
		wait.until (ExpectedConditions.textToBePresentInElement (orClaimMainSearch.tblPolicySearch, strPolicyNumber));
		tblClient.returnRowInTable ("tblPolicySearch", strPolicyNumber);
	}

	public void clickSearchImage ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.imgSearch));

		orClaimMainSearch.imgSearch.click ();

	}

	public void typeClaimNumber (String strClaimNumber)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.txtClaimNo));

		orClaimMainSearch.txtClaimNo.sendKeys (strClaimNumber);

	}

	public void typeNumberPlate ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.txtNumberPlate));

		orClaimMainSearch.txtNumberPlate.click ();
		orClaimMainSearch.txtNumberPlate.sendKeys (RandomLetters.produceRandomString (6));

	}

	public void typeReferenceNumber ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.txtReferenceNumber));

		orClaimMainSearch.txtReferenceNumber.click ();
		orClaimMainSearch.txtReferenceNumber.sendKeys (RandomLetters.produceRandomString (6));

	}

	public void typeNiNumber (String strNINumber)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.txtNiNumber));

		orClaimMainSearch.txtNiNumber.click ();
		orClaimMainSearch.txtNiNumber.sendKeys (strNINumber);

	}

	public void typeVIN ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.txtVIN));

		orClaimMainSearch.txtVIN.click ();
		orClaimMainSearch.txtVIN.sendKeys (RandomLetters.produceRandomString (12));

	}

	public void typeLossDate (String strLossDate)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.txtLossDate));

		orClaimMainSearch.txtLossDate.click ();
		orClaimMainSearch.txtLossDate.sendKeys (strLossDate);

	}

	public void SelectClient ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.rdoSearchForClient));

		orClaimMainSearch.rdoSearchForClient.click ();
	}

	public void SelectPolicy ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.rdoSearchForPolicy));

		orClaimMainSearch.rdoSearchForPolicy.click ();
	}

	public void SelectClaim ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.rdoSearchForClaim));

		orClaimMainSearch.rdoSearchForClaim.click ();
	}

	public void clickOnOpen ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.btnOpenClaim));
		orClaimMainSearch.btnOpenClaim.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void selectClaimRow ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.tblClaimSearch));

		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.clickRandomTableRow ("tblClaimSearch");
	}

	public void typeIncidentDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMainSearch.dtIncidentDate));
		orClaimMainSearch.dtIncidentDate.click ();
		orClaimMainSearch.dtIncidentDate.sendKeys (Keys.HOME + CalenderDate.returnCurrentDate (strRegion));
		orClaimMainSearch.dtIncidentDate.sendKeys (Keys.TAB);
	}

}
