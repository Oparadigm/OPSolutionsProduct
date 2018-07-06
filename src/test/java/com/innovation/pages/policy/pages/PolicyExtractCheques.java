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
import com.innovation.misc.SelectionHelper;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicyExtractCheques;;

/**
 * @author Qasim - This class stores all the locators and methods of the Policy EFT List screen
 */

public class PolicyExtractCheques
{

	WebDriver				driver;
	OR_PolicyExtractCheques	orPolicyExtractCheques	= null;
	LoggingControl			loggingcontrol			= new LoggingControl ();
	OR_ControlPanel			orControlPanel			= null;

	public PolicyExtractCheques (WebDriver driver)
	{
		this.driver = driver;
		orPolicyExtractCheques = PageFactory.initElements (driver, OR_PolicyExtractCheques.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	// select a random element from the list
	public void selectAPChkPrntBnkAcct ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyExtractCheques.ddlAPChkPrntBnkAcct));

		orPolicyExtractCheques.ddlAPChkPrntBnkAcct.click ();
		Select oAPChkPrntBnkAcct = new Select (orPolicyExtractCheques.ddlAPChkPrntBnkAcct);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oAPChkPrntBnkAcct.getOptions ();
		oAPChkPrntBnkAcct.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectAPChkPrntBnkAcct (String strAPChkPrntBnkAcct)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyExtractCheques.ddlAPChkPrntBnkAcct));

		orPolicyExtractCheques.ddlAPChkPrntBnkAcct.click ();
		Select oAPChkPrntBnkAcct = new Select (orPolicyExtractCheques.ddlAPChkPrntBnkAcct);
		oAPChkPrntBnkAcct.selectByVisibleText (strAPChkPrntBnkAcct);
	}

	// select a random element from the list
	public void selectAPChkPrntStBrnch ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyExtractCheques.ddlAPChkPrntStBrnch));

		orPolicyExtractCheques.ddlAPChkPrntStBrnch.click ();
		Select oAPChkPrntStBrnch = new Select (orPolicyExtractCheques.ddlAPChkPrntStBrnch);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oAPChkPrntStBrnch.getOptions ();
		oAPChkPrntStBrnch.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectAPChkPrntStBrnch (String strAPChkPrntStBrnch)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyExtractCheques.ddlAPChkPrntStBrnch));

		orPolicyExtractCheques.ddlAPChkPrntStBrnch.click ();
		Select oAPChkPrntStBrnch = new Select (orPolicyExtractCheques.ddlAPChkPrntStBrnch);
		oAPChkPrntStBrnch.selectByVisibleText (strAPChkPrntStBrnch);
	}

	// select a random element from the list
	public void selectAPChkPrntPrBranch ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyExtractCheques.ddlAPChkPrntPrBranch));

		orPolicyExtractCheques.ddlAPChkPrntPrBranch.click ();
		Select oAPChkPrntPrBranch = new Select (orPolicyExtractCheques.ddlAPChkPrntPrBranch);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oAPChkPrntPrBranch.getOptions ();
		oAPChkPrntPrBranch.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectAPChkPrntPrBranch (String ddlAPChkPrntPrBranch)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyExtractCheques.ddlAPChkPrntPrBranch));

		orPolicyExtractCheques.ddlAPChkPrntPrBranch.click ();
		Select oAPChkPrntPrBranch = new Select (orPolicyExtractCheques.ddlAPChkPrntPrBranch);
		oAPChkPrntPrBranch.selectByVisibleText (ddlAPChkPrntPrBranch);
	}

	// select a random element from the list
	public void selectAPChkPrntPaymntType ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyExtractCheques.ddlAPChkPrntPaymntType));

		orPolicyExtractCheques.ddlAPChkPrntPaymntType.click ();
		Select oAPChkPrntPaymntType = new Select (orPolicyExtractCheques.ddlAPChkPrntPaymntType);

		// Select a random Reported By from the returned list
		List<WebElement> selections = oAPChkPrntPaymntType.getOptions ();
		oAPChkPrntPaymntType.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}

	// select a specified value
	public void selectAPChkPrntPaymntType (String ddlAPChkPrntPaymntType)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyExtractCheques.ddlAPChkPrntPaymntType));

		orPolicyExtractCheques.ddlAPChkPrntPaymntType.click ();
		Select oAPChkPrntPaymntType = new Select (orPolicyExtractCheques.ddlAPChkPrntPaymntType);
		oAPChkPrntPaymntType.selectByVisibleText (ddlAPChkPrntPaymntType);
	}

	public void typeAPChkPrntPrntAllUpTo ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyExtractCheques.txtAPChkPrntPrntAllUpTo));

		orPolicyExtractCheques.txtAPChkPrntPrntAllUpTo.click ();
		orPolicyExtractCheques.txtAPChkPrntPrntAllUpTo.sendKeys (RandomLetters.produceRandomString (999));
	}

	// fill with specified text
	public void setAPChkPrntPrntAllUpTo (String txtAPChkPrntPrntAllUpTo)
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyExtractCheques.txtAPChkPrntPrntAllUpTo));

		orPolicyExtractCheques.txtAPChkPrntPrntAllUpTo.click ();
		orPolicyExtractCheques.txtAPChkPrntPrntAllUpTo.sendKeys (txtAPChkPrntPrntAllUpTo);
	}

	public void selectAPChkPrnPrManualOnlyYes (String strAPChkPrnPrManualOnlyYes)
	{
		// possible values : Y = Yes
		boolean allowUnknown = false;
		boolean defaultElse = false;
		int elseValue = 2;
		SelectionHelper.selectRadio (orPolicyExtractCheques.rdoAPChkPrnPrManualOnlyYes, strAPChkPrnPrManualOnlyYes, allowUnknown, defaultElse, elseValue);
	}

	public void selectAPChkPrnPrManualOnlyNo (String strAPChkPrnPrManualOnlyNo)
	{
		// possible values : N = No
		boolean allowUnknown = false;
		boolean defaultElse = false;
		int elseValue = 2;
		SelectionHelper.selectRadio (orPolicyExtractCheques.rdoAPChkPrnPrManualOnlyNo, strAPChkPrnPrManualOnlyNo, allowUnknown, defaultElse, elseValue);
	}

	// Click process button
	public void clickProcess ()
	{
		// @formatter:off
		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);
		// @formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyExtractCheques.btnProcess));
		orPolicyExtractCheques.btnProcess.click ();

	}

}
