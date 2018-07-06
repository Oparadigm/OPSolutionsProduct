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
import com.innovation.pages.policy.objects.OR_PolicyCheckRunList;

/**
 * @author Qasim - This class stores all the locators and methods of the Policy Check Run List screen
 */

public class PolicyCheckRunList
{

	WebDriver					driver;
	OR_PolicyCheckRunList	    orPolicyCheckRunList	= null;
	LoggingControl				loggingcontrol			= new LoggingControl ();
	OR_ControlPanel				orControlPanel			= null;

	public void typeSCCheckRunListDate ()
	{
	        //@formatter:off 
	        loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
	        //@formatter:on
	 
	        WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
	        wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckRunList.txtSCCheckRunListDate));
	        
	        orPolicyCheckRunList.txtSCCheckRunListDate.click ();
	        orPolicyCheckRunList.txtSCCheckRunListDate.sendKeys (RandomLetters.produceRandomString (999));
	}
	 
	// fill with specified text
	public void setSCCheckRunListDate (String txtSCCheckRunListDate)
	{
	        //@formatter:off 
	        loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
	        //@formatter:on
	 
	        WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
	        wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckRunList.txtSCCheckRunListDate));
	 
	        orPolicyCheckRunList.txtSCCheckRunListDate.click ();
	        orPolicyCheckRunList.txtSCCheckRunListDate.sendKeys (txtSCCheckRunListDate);
	}
	 
	// select a random element from the list
	public void selectSCCheckRunListBankAcct ()
	{
	        //@formatter:off
	        loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
	        //@formatter:on
	        
	        WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
	        wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckRunList.ddlSCCheckRunListBankAcct));
	        
	        orPolicyCheckRunList.ddlSCCheckRunListBankAcct.click ();
	        Select oSCCheckRunListBankAcct = new Select (orPolicyCheckRunList.ddlSCCheckRunListBankAcct);
	        
	        // Select a random Reported By from the returned list
	        List<WebElement> selections = oSCCheckRunListBankAcct.getOptions ();
	        oSCCheckRunListBankAcct.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}
	 
	 
	// select a specified value
	public void selectSCCheckRunListBankAcct (String ddlSCCheckRunListBankAcct)
	{
	        //@formatter:off
	        loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
	        //@formatter:on
	        
	        WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
	        wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckRunList.ddlSCCheckRunListBankAcct));
	 
	        orPolicyCheckRunList.ddlSCCheckRunListBankAcct.click ();
	        Select oSCCheckRunListBankAcct = new Select (orPolicyCheckRunList.ddlSCCheckRunListBankAcct);
	        oSCCheckRunListBankAcct.selectByVisibleText (ddlSCCheckRunListBankAcct);
	}
	 
	// select a random element from the list
	public void selectSCCheckRunListUser ()
	{
	        //@formatter:off
	        loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
	        //@formatter:on
	        
	        WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
	        wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckRunList.ddlSCCheckRunListUser));
	        
	        orPolicyCheckRunList.ddlSCCheckRunListUser.click ();
	        Select oSCCheckRunListUser = new Select (orPolicyCheckRunList.ddlSCCheckRunListUser);
	        
	        // Select a random Reported By from the returned list
	        List<WebElement> selections = oSCCheckRunListUser.getOptions ();
	        oSCCheckRunListUser.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
	}
	 
	 
	// select a specified value
	public void selectSCCheckRunListUser (String ddlSCCheckRunListUser)
	{
	        //@formatter:off
	        loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
	        //@formatter:on
	        
	        WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
	        wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckRunList.ddlSCCheckRunListUser));
	 
	        orPolicyCheckRunList.ddlSCCheckRunListUser.click ();
	        Select oSCCheckRunListUser = new Select (orPolicyCheckRunList.ddlSCCheckRunListUser);
	        oSCCheckRunListUser.selectByVisibleText (ddlSCCheckRunListUser);
	}
	 
	public void typeSCCheckRunListCheckNumber ()
	{
	        //@formatter:off 
	        loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
	        //@formatter:on
	 
	        WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
	        wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckRunList.txtSCCheckRunListCheckNumber));
	        
	        orPolicyCheckRunList.txtSCCheckRunListCheckNumber.click ();
	        orPolicyCheckRunList.txtSCCheckRunListCheckNumber.sendKeys (RandomLetters.produceRandomString (999));
	}
	 
	// fill with specified text
	public void setSCCheckRunListCheckNumber (String txtSCCheckRunListCheckNumber)
	{
	        //@formatter:off 
	        loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
	        //@formatter:on
	 
	        WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
	        wait.until (ExpectedConditions.elementToBeClickable (orPolicyCheckRunList.txtSCCheckRunListCheckNumber));
	 
	        orPolicyCheckRunList.txtSCCheckRunListCheckNumber.click ();
	        orPolicyCheckRunList.txtSCCheckRunListCheckNumber.sendKeys (txtSCCheckRunListCheckNumber);
	}

	
	
	
}
