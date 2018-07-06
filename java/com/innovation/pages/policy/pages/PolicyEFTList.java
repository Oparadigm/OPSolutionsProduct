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
import com.innovation.pages.policy.objects.OR_PolicyEFTList;

/**
 * @author Qasim - This class stores all the locators and methods of the Policy EFT List screen
 */

public class PolicyEFTList
{

	WebDriver			driver;
	OR_PolicyEFTList	orPolicyEFTList	= null;
	LoggingControl		loggingcontrol		= new LoggingControl ();
	OR_ControlPanel		orControlPanel		= null;

	// select a random element from the list
	public void selectReqDetailsRejectionReason ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyEFTList.ddlReqDetailsRejectionReason));

		orPolicyEFTList.ddlReqDetailsRejectionReason.click ();
		Select oReqDetailsRejectionReason = new Select (orPolicyEFTList.ddlReqDetailsRejectionReason);

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
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyEFTList.ddlReqDetailsRejectionReason));

		orPolicyEFTList.ddlReqDetailsRejectionReason.click ();
		Select oReqDetailsRejectionReason = new Select (orPolicyEFTList.ddlReqDetailsRejectionReason);
		oReqDetailsRejectionReason.selectByVisibleText (ddlReqDetailsRejectionReason);
	}

	// select a random element from the list
	public void selectAPEFTSrchSearchBy ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyEFTList.ddlAPEFTSrchSearchBy));

		orPolicyEFTList.ddlAPEFTSrchSearchBy.click ();
		Select oAPEFTSrchSearchBy = new Select (orPolicyEFTList.ddlAPEFTSrchSearchBy);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oAPEFTSrchSearchBy.getOptions ();
		oAPEFTSrchSearchBy.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectAPEFTSrchSearchBy (String ddlAPEFTSrchSearchBy)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyEFTList.ddlAPEFTSrchSearchBy));

		orPolicyEFTList.ddlAPEFTSrchSearchBy.click ();
		Select oAPEFTSrchSearchBy = new Select (orPolicyEFTList.ddlAPEFTSrchSearchBy);
		oAPEFTSrchSearchBy.selectByVisibleText (ddlAPEFTSrchSearchBy);
	}

	public void typeAPEFTSrchPaidDate ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyEFTList.txtAPEFTSrchPaidDate));

		orPolicyEFTList.txtAPEFTSrchPaidDate.click ();
		orPolicyEFTList.txtAPEFTSrchPaidDate.sendKeys (RandomLetters.produceRandomString (999));
	}

	// fill with specified text
	public void setAPEFTSrchPaidDate (String txtAPEFTSrchPaidDate)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyEFTList.txtAPEFTSrchPaidDate));

		orPolicyEFTList.txtAPEFTSrchPaidDate.click ();
		orPolicyEFTList.txtAPEFTSrchPaidDate.sendKeys (txtAPEFTSrchPaidDate);
	}

	public void typeAPEFTSrchSearchByValue ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyEFTList.txtAPEFTSrchSearchByValue));

		orPolicyEFTList.txtAPEFTSrchSearchByValue.click ();
		orPolicyEFTList.txtAPEFTSrchSearchByValue.sendKeys (RandomLetters.produceRandomString (9));
	}

	// fill with specified text
	public void setAPEFTSrchSearchByValue (String txtAPEFTSrchSearchByValue)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyEFTList.txtAPEFTSrchSearchByValue));

		orPolicyEFTList.txtAPEFTSrchSearchByValue.click ();
		orPolicyEFTList.txtAPEFTSrchSearchByValue.sendKeys (txtAPEFTSrchSearchByValue);
	}

	// select a random element from the list
	public void selectAPEFTSrchBankAcct ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyEFTList.ddlAPEFTSrchBankAcct));

		orPolicyEFTList.ddlAPEFTSrchBankAcct.click ();
		Select oAPEFTSrchBankAcct = new Select (orPolicyEFTList.ddlAPEFTSrchBankAcct);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oAPEFTSrchBankAcct.getOptions ();
		oAPEFTSrchBankAcct.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectAPEFTSrchBankAcct (String ddlAPEFTSrchBankAcct)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyEFTList.ddlAPEFTSrchBankAcct));

		orPolicyEFTList.ddlAPEFTSrchBankAcct.click ();
		Select oAPEFTSrchBankAcct = new Select (orPolicyEFTList.ddlAPEFTSrchBankAcct);
		oAPEFTSrchBankAcct.selectByVisibleText (ddlAPEFTSrchBankAcct);
	}

}
