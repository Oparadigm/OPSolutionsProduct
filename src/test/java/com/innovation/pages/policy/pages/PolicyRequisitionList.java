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
import com.innovation.misc.LoggingControl;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.TableHandler;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicyRequisitionList;

/**
 * @author Qasim - This class stores all the locators and methods of the Policy Requisition List screen
 */

public class PolicyRequisitionList
{

	WebDriver					driver;
	OR_PolicyRequisitionList	orPolicyRequisitionList	= null;
	LoggingControl				loggingcontrol			= new LoggingControl ();
	OR_ControlPanel				orControlPanel			= null;

	public PolicyRequisitionList (WebDriver driver)
	{
		this.driver = driver;
		orPolicyRequisitionList = PageFactory.initElements (driver, OR_PolicyRequisitionList.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	// select a random element from the list
	public void selectReqDetailsRejectionReason ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.ddlReqDetailsRejectionReason));

		orPolicyRequisitionList.ddlReqDetailsRejectionReason.click ();
		Select oReqDetailsRejectionReason = new Select (orPolicyRequisitionList.ddlReqDetailsRejectionReason);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oReqDetailsRejectionReason.getOptions ();
		oReqDetailsRejectionReason.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectReqDetailsRejectionReason (String ddlReqDetailsRejectionReason)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.ddlReqDetailsRejectionReason));

		orPolicyRequisitionList.ddlReqDetailsRejectionReason.click ();
		Select oReqDetailsRejectionReason = new Select (orPolicyRequisitionList.ddlReqDetailsRejectionReason);
		oReqDetailsRejectionReason.selectByVisibleText (ddlReqDetailsRejectionReason);
	}

	public void clickInPaymentView ()
	{
		// TODO - what can be done with this field
	}

	// select a random element from the list
	public void selectReqDetailsNewMailAdd ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.ddlReqDetailsNewMailAdd));

		orPolicyRequisitionList.ddlReqDetailsNewMailAdd.click ();
		Select oReqDetailsNewMailAdd = new Select (orPolicyRequisitionList.ddlReqDetailsNewMailAdd);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oReqDetailsNewMailAdd.getOptions ();
		oReqDetailsNewMailAdd.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectReqDetailsNewMailAdd (String ddlReqDetailsNewMailAdd)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.ddlReqDetailsNewMailAdd));

		orPolicyRequisitionList.ddlReqDetailsNewMailAdd.click ();
		Select oReqDetailsNewMailAdd = new Select (orPolicyRequisitionList.ddlReqDetailsNewMailAdd);
		oReqDetailsNewMailAdd.selectByVisibleText (ddlReqDetailsNewMailAdd);
	}

	public void clickSoleDisbView ()
	{
		// TODO - what can be done with this field
	}

	public void clickDistView ()
	{
		// TODO - what can be done with this field
	}

	public void clickHoldDateView ()
	{
		// TODO - what can be done with this field
	}

	// select a random element from the list
	public void selectReqListReqType ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.ddlReqListReqType));

		orPolicyRequisitionList.ddlReqListReqType.click ();
		Select oReqListReqType = new Select (orPolicyRequisitionList.ddlReqListReqType);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oReqListReqType.getOptions ();
		oReqListReqType.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectReqListReqType (String ddlReqListReqType)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.ddlReqListReqType));

		orPolicyRequisitionList.ddlReqListReqType.click ();
		Select oReqListReqType = new Select (orPolicyRequisitionList.ddlReqListReqType);
		oReqListReqType.selectByVisibleText (ddlReqListReqType);
	}

	// select a random element from the list
	public void selectReqListProcBranch ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.ddlReqListProcBranch));

		orPolicyRequisitionList.ddlReqListProcBranch.click ();
		Select oReqListProcBranch = new Select (orPolicyRequisitionList.ddlReqListProcBranch);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oReqListProcBranch.getOptions ();
		oReqListProcBranch.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// // select a specified value
	// public void selectReqListProcBranch (String ddlReqListProcBranch)
	// {
	// // @formatter:off
	// loggingcontrol.ConsoleLogger (new Object ()
	// {
	// }.getClass ().getEnclosingMethod ().getName (), driver);
	// // @formatter:on
	//
	// WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
	// wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.ddlReqListProcBranch));
	//
	// orPolicyRequisitionList.ddlReqListProcBranch.click ();
	// Select oReqListProcBranch = new Select (orPolicyRequisitionList.ddlReqListProcBranch);
	// oReqListProcBranch.selectByVisibleText (ddlReqListProcBranch);
	// }

	public void selectReqListProcBranch (String srtProcessingBranch)
	{

		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.ddlReqListProcBranch));
		orPolicyRequisitionList.ddlReqListProcBranch.click ();
		Select oAreaCode = new Select (orPolicyRequisitionList.ddlReqListProcBranch);
		oAreaCode.selectByVisibleText (srtProcessingBranch);

	}

	// select a random element from the list
	public void selectReqListSearchBy ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.ddlReqListSearchBy));

		orPolicyRequisitionList.ddlReqListSearchBy.click ();
		Select oReqListSearchBy = new Select (orPolicyRequisitionList.ddlReqListSearchBy);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oReqListSearchBy.getOptions ();
		oReqListSearchBy.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectReqListSearchBy (String ddlReqListSearchBy)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.ddlReqListSearchBy));

		orPolicyRequisitionList.ddlReqListSearchBy.click ();
		Select oReqListSearchBy = new Select (orPolicyRequisitionList.ddlReqListSearchBy);
		oReqListSearchBy.selectByVisibleText (ddlReqListSearchBy);
	}

	public void typeReqListFromDate ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.txtReqListFromDate));

		orPolicyRequisitionList.txtReqListFromDate.click ();
		orPolicyRequisitionList.txtReqListFromDate.sendKeys (RandomLetters.produceRandomString (999));
	}

	// fill with specified text
	public void setReqListFromDate (String txtReqListFromDate)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.txtReqListFromDate));

		orPolicyRequisitionList.txtReqListFromDate.click ();
		orPolicyRequisitionList.txtReqListFromDate.sendKeys (txtReqListFromDate);
	}

	// fill with specified text
	public void setSearchByValue (String strRequisitionNumber)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.txtSearchByValue));
		orPolicyRequisitionList.txtSearchByValue.sendKeys (strRequisitionNumber);
	}

	// Click Search button
	public void clickSearchButton ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.btnSearch));

		orPolicyRequisitionList.btnSearch.click ();
	}

	// click the checkbox
	public void clickReqListIncAuthReject ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.chkReqListIncAuthReject));

		orPolicyRequisitionList.chkReqListIncAuthReject.click ();
	}

	// select a specified state
	public void selectReqListIncAuthReject (boolean selected)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.chkReqListIncAuthReject));

		// only call the click method if the state requires a click
		if (selected && !orPolicyRequisitionList.chkReqListIncAuthReject.isSelected () ||
			!selected && orPolicyRequisitionList.chkReqListIncAuthReject.isSelected ())
			orPolicyRequisitionList.chkReqListIncAuthReject.click ();
	}

	// click the button
	public void clickReqListPrintList ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.btnReqListPrintList));
		orPolicyRequisitionList.btnReqListPrintList.click ();
	}

	// click the button
	public void clickReqListAuthList ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.btnReqListAuthList));
		orPolicyRequisitionList.btnReqListAuthList.click ();
	}

	// click the button
	public void clickAuthorize ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRequisitionList.btnAuthorize));
		orPolicyRequisitionList.btnAuthorize.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

	}

	public void selectRequisitionRecord (String strRequisitionNumber)

	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
		wait.until (ExpectedConditions.textToBePresentInElement (orPolicyRequisitionList.tblRequisitionList, strRequisitionNumber));
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.clickRandomTableRow ("tblReqList");

	}

}
