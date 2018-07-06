/**
 * 
 */
package com.innovation.pages.policy.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.misc.RandomLetters;
import com.innovation.misc.RandomNumbers;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicyCheckList;

/**
 * @author Qasim - This class stores all the locators and methods of the Policy Check List screen
 */

public class PolicyCheckList
{

	WebDriver			driver;
	OR_PolicyCheckList	orPolicyCheckList	= null;
	LoggingControl		loggingcontrol		= new LoggingControl ();
	OR_ControlPanel		orControlPanel		= null;

	public void typeSCCheckListDateFrom ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckList.txtSCCheckListDateFrom));

		orPolicyCheckList.txtSCCheckListDateFrom.click ();
		orPolicyCheckList.txtSCCheckListDateFrom.sendKeys (RandomLetters.produceRandomString (999));
	}

	// fill with specified text
	public void setSCCheckListDateFrom (String txtSCCheckListDateFrom)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckList.txtSCCheckListDateFrom));

		orPolicyCheckList.txtSCCheckListDateFrom.click ();
		orPolicyCheckList.txtSCCheckListDateFrom.sendKeys (txtSCCheckListDateFrom);
	}

	// select a random element from the list
	public void selectSCCheckListSearchBy ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckList.ddlSCCheckListSearchBy));

		orPolicyCheckList.ddlSCCheckListSearchBy.click ();
		Select oSCCheckListSearchBy = new Select (orPolicyCheckList.ddlSCCheckListSearchBy);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oSCCheckListSearchBy.getOptions ();
		oSCCheckListSearchBy.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectSCCheckListSearchBy (String ddlSCCheckListSearchBy)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckList.ddlSCCheckListSearchBy));

		orPolicyCheckList.ddlSCCheckListSearchBy.click ();
		Select oSCCheckListSearchBy = new Select (orPolicyCheckList.ddlSCCheckListSearchBy);
		oSCCheckListSearchBy.selectByVisibleText (ddlSCCheckListSearchBy);
	}

	// select a random element from the list
	public void selectSCCheckListCancelReason ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckList.ddlSCCheckListCancelReason));

		orPolicyCheckList.ddlSCCheckListCancelReason.click ();
		Select oSCCheckListCancelReason = new Select (orPolicyCheckList.ddlSCCheckListCancelReason);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oSCCheckListCancelReason.getOptions ();
		oSCCheckListCancelReason.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectSCCheckListCancelReason (String ddlSCCheckListCancelReason)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckList.ddlSCCheckListCancelReason));

		orPolicyCheckList.ddlSCCheckListCancelReason.click ();
		Select oSCCheckListCancelReason = new Select (orPolicyCheckList.ddlSCCheckListCancelReason);
		oSCCheckListCancelReason.selectByVisibleText (ddlSCCheckListCancelReason);
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
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckList.ddlReqDetailsNewMailAdd));

		orPolicyCheckList.ddlReqDetailsNewMailAdd.click ();
		Select oReqDetailsNewMailAdd = new Select (orPolicyCheckList.ddlReqDetailsNewMailAdd);

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
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckList.ddlReqDetailsNewMailAdd));

		orPolicyCheckList.ddlReqDetailsNewMailAdd.click ();
		Select oReqDetailsNewMailAdd = new Select (orPolicyCheckList.ddlReqDetailsNewMailAdd);
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

}
