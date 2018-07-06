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
import com.innovation.pages.policy.objects.OR_PolicyProcessCommission;

/**
 * @author Qasim - This class stores all the locators and methods of the Policy Process Commission screen
 */

public class PolicyProcessCommission
{

	WebDriver					driver;
	OR_PolicyProcessCommission	orPolicyProcessCommission	= null;
	LoggingControl				loggingcontrol				= new LoggingControl ();
	OR_ControlPanel				orControlPanel				= null;

	// select a random element from the list
	public void selectSCComProcBankAcct ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyProcessCommission.ddlSCComProcBankAcct));

		orPolicyProcessCommission.ddlSCComProcBankAcct.click ();
		Select oSCComProcBankAcct = new Select (orPolicyProcessCommission.ddlSCComProcBankAcct);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oSCComProcBankAcct.getOptions ();
		oSCComProcBankAcct.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectSCComProcBankAcct (String ddlSCComProcBankAcct)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyProcessCommission.ddlSCComProcBankAcct));

		orPolicyProcessCommission.ddlSCComProcBankAcct.click ();
		Select oSCComProcBankAcct = new Select (orPolicyProcessCommission.ddlSCComProcBankAcct);
		oSCComProcBankAcct.selectByVisibleText (ddlSCComProcBankAcct);
	}

	// select a random element from the list
	public void selectSCComProcBranch ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyProcessCommission.ddlSCComProcBranch));

		orPolicyProcessCommission.ddlSCComProcBranch.click ();
		Select oSCComProcBranch = new Select (orPolicyProcessCommission.ddlSCComProcBranch);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oSCComProcBranch.getOptions ();
		oSCComProcBranch.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectSCComProcBranch (String ddlSCComProcBranch)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyProcessCommission.ddlSCComProcBranch));

		orPolicyProcessCommission.ddlSCComProcBranch.click ();
		Select oSCComProcBranch = new Select (orPolicyProcessCommission.ddlSCComProcBranch);
		oSCComProcBranch.selectByVisibleText (ddlSCComProcBranch);
	}

	// select a random element from the list
	public void selectSCComProcFrequency ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyProcessCommission.ddlSCComProcFrequency));

		orPolicyProcessCommission.ddlSCComProcFrequency.click ();
		Select oSCComProcFrequency = new Select (orPolicyProcessCommission.ddlSCComProcFrequency);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oSCComProcFrequency.getOptions ();
		oSCComProcFrequency.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectSCComProcFrequency (String ddlSCComProcFrequency)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyProcessCommission.ddlSCComProcFrequency));

		orPolicyProcessCommission.ddlSCComProcFrequency.click ();
		Select oSCComProcFrequency = new Select (orPolicyProcessCommission.ddlSCComProcFrequency);
		oSCComProcFrequency.selectByVisibleText (ddlSCComProcFrequency);
	}

}
