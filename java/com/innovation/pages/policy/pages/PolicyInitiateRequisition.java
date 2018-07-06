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
import com.innovation.pages.policy.objects.OR_PolicyAPInitiateRequisition;

/**
 * @author Alamq - This class stores all the locators and methods of the Initiate Requisition screen
 */
public class PolicyInitiateRequisition
{

	WebDriver					driver;

	LoggingControl					loggingcontrol					= new LoggingControl ();
	
	OR_PolicyAPInitiateRequisition	orPolicyAPInitiateRequisition;

	public PolicyInitiateRequisition (WebDriver driver)
	{
		this.driver = driver;
		orPolicyAPInitiateRequisition = PageFactory.initElements (driver, OR_PolicyAPInitiateRequisition.class);

	}

//select a random element from the list
public void selectAPRRInPaymentOf ()
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlAPRRInPaymentOf));
     
     orPolicyAPInitiateRequisition.ddlAPRRInPaymentOf.click ();
     Select oAPRRInPaymentOf = new Select (orPolicyAPInitiateRequisition.ddlAPRRInPaymentOf);
     
     // Select a random Reported By from the returned list
     List<WebElement> selections = oAPRRInPaymentOf.getOptions ();
     oAPRRInPaymentOf.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
}


//select a specified value
public void selectAPRRInPaymentOf (String ddlAPRRInPaymentOf)
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlAPRRInPaymentOf));

     orPolicyAPInitiateRequisition.ddlAPRRInPaymentOf.click ();
     Select oAPRRInPaymentOf = new Select (orPolicyAPInitiateRequisition.ddlAPRRInPaymentOf);
     oAPRRInPaymentOf.selectByVisibleText (ddlAPRRInPaymentOf);
}

//click the checkbox
public void clickAPRRSolDisbMetd ()
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.chkAPRRSolDisbMetd));
     
     orPolicyAPInitiateRequisition.chkAPRRSolDisbMetd.click ();
}


//select a specified state
public void selectAPRRSolDisbMetd (boolean selected)
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.chkAPRRSolDisbMetd));

     // only call the click method if the state requires a click
     if (selected && !orPolicyAPInitiateRequisition.chkAPRRSolDisbMetd.isSelected() || !selected && orPolicyAPInitiateRequisition.chkAPRRSolDisbMetd.isSelected())
            orPolicyAPInitiateRequisition.chkAPRRSolDisbMetd.click ();
}

//select a random element from the list
public void selectAPRRDisbMetd ()
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlAPRRDisbMetd));
     
     orPolicyAPInitiateRequisition.ddlAPRRDisbMetd.click ();
     Select oAPRRDisbMetd = new Select (orPolicyAPInitiateRequisition.ddlAPRRDisbMetd);
     
     // Select a random Reported By from the returned list
     List<WebElement> selections = oAPRRDisbMetd.getOptions ();
     oAPRRDisbMetd.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
}


//select a specified value
public void selectAPRRDisbMetd (String ddlAPRRDisbMetd)
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlAPRRDisbMetd));

     orPolicyAPInitiateRequisition.ddlAPRRDisbMetd.click ();
     Select oAPRRDisbMetd = new Select (orPolicyAPInitiateRequisition.ddlAPRRDisbMetd);
     oAPRRDisbMetd.selectByVisibleText (ddlAPRRDisbMetd);
}

//select a random element from the list
public void selectAPRRIssuedby ()
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlAPRRIssuedby));
     
     orPolicyAPInitiateRequisition.ddlAPRRIssuedby.click ();
     Select oAPRRIssuedby = new Select (orPolicyAPInitiateRequisition.ddlAPRRIssuedby);
     
     // Select a random Reported By from the returned list
     List<WebElement> selections = oAPRRIssuedby.getOptions ();
     oAPRRIssuedby.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
}


//select a specified value
public void selectAPRRIssuedby (String ddlAPRRIssuedby)
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlAPRRIssuedby));

     orPolicyAPInitiateRequisition.ddlAPRRIssuedby.click ();
     Select oAPRRIssuedby = new Select (orPolicyAPInitiateRequisition.ddlAPRRIssuedby);
     oAPRRIssuedby.selectByVisibleText (ddlAPRRIssuedby);
}

public void typeAPRRcheckNum ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtAPRRcheckNum));
     
     orPolicyAPInitiateRequisition.txtAPRRcheckNum.click ();
     orPolicyAPInitiateRequisition.txtAPRRcheckNum.sendKeys (RandomLetters.produceRandomString (10));
}

//fill with specified text
public void setAPRRcheckNum (String txtAPRRcheckNum)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtAPRRcheckNum));

     orPolicyAPInitiateRequisition.txtAPRRcheckNum.click ();
     orPolicyAPInitiateRequisition.txtAPRRcheckNum.sendKeys (txtAPRRcheckNum);
}

//select a random element from the list
public void selectAPRRDistribution ()
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlAPRRDistribution));
     
     orPolicyAPInitiateRequisition.ddlAPRRDistribution.click ();
     Select oAPRRDistribution = new Select (orPolicyAPInitiateRequisition.ddlAPRRDistribution);
     
     // Select a random Reported By from the returned list
     List<WebElement> selections = oAPRRDistribution.getOptions ();
     oAPRRDistribution.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
}


//select a specified value
public void selectAPRRDistribution (String ddlAPRRDistribution)
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlAPRRDistribution));

     orPolicyAPInitiateRequisition.ddlAPRRDistribution.click ();
     Select oAPRRDistribution = new Select (orPolicyAPInitiateRequisition.ddlAPRRDistribution);
     oAPRRDistribution.selectByVisibleText (ddlAPRRDistribution);
}

public void typeAPRRIssuedate ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtAPRRIssuedate));
     
     orPolicyAPInitiateRequisition.txtAPRRIssuedate.click ();
     orPolicyAPInitiateRequisition.txtAPRRIssuedate.sendKeys (RandomLetters.produceRandomString (999));
}

//fill with specified text
public void setAPRRIssuedate (String txtAPRRIssuedate)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtAPRRIssuedate));

     orPolicyAPInitiateRequisition.txtAPRRIssuedate.click ();
     orPolicyAPInitiateRequisition.txtAPRRIssuedate.sendKeys (txtAPRRIssuedate);
}

public void typeAPRRHolddate ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtAPRRHolddate));
     
     orPolicyAPInitiateRequisition.txtAPRRHolddate.click ();
     orPolicyAPInitiateRequisition.txtAPRRHolddate.sendKeys (RandomLetters.produceRandomString (999));
}

//fill with specified text
public void setAPRRHolddate (String txtAPRRHolddate)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtAPRRHolddate));

     orPolicyAPInitiateRequisition.txtAPRRHolddate.click ();
     orPolicyAPInitiateRequisition.txtAPRRHolddate.sendKeys (txtAPRRHolddate);
}

//select a random element from the list
public void selectAPRRcDistribution ()
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlAPRRcDistribution));
     
     orPolicyAPInitiateRequisition.ddlAPRRcDistribution.click ();
     Select oAPRRcDistribution = new Select (orPolicyAPInitiateRequisition.ddlAPRRcDistribution);
     
     // Select a random Reported By from the returned list
     List<WebElement> selections = oAPRRcDistribution.getOptions ();
     oAPRRcDistribution.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
}


//select a specified value
public void selectAPRRcDistribution (String ddlAPRRcDistribution)
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlAPRRcDistribution));

     orPolicyAPInitiateRequisition.ddlAPRRcDistribution.click ();
     Select oAPRRcDistribution = new Select (orPolicyAPInitiateRequisition.ddlAPRRcDistribution);
     oAPRRcDistribution.selectByVisibleText (ddlAPRRcDistribution);
}

public void typeAPRRcHolddate ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtAPRRcHolddate));
     
     orPolicyAPInitiateRequisition.txtAPRRcHolddate.click ();
     orPolicyAPInitiateRequisition.txtAPRRcHolddate.sendKeys (RandomLetters.produceRandomString (999));
}

//fill with specified text
public void setAPRRcHolddate (String txtAPRRcHolddate)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtAPRRcHolddate));

     orPolicyAPInitiateRequisition.txtAPRRcHolddate.click ();
     orPolicyAPInitiateRequisition.txtAPRRcHolddate.sendKeys (txtAPRRcHolddate);
}

public void selectSCAccountTypeRadio (String strSCAccountTypeRadio)
{
     // possible values : bank = , credit = Bank account
     boolean allowUnknown = false;
     boolean defaultElse = false;
     int elseValue = 2;
     SelectionHelper.selectRadio (orPolicyAPInitiateRequisition.rdoSCAccountTypeRadio, strSCAccountTypeRadio, allowUnknown, defaultElse, elseValue);
}

//select a random element from the list
public void selectBNKAccountAcctType ()
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlBNKAccountAcctType));
     
     orPolicyAPInitiateRequisition.ddlBNKAccountAcctType.click ();
     Select oBNKAccountAcctType = new Select (orPolicyAPInitiateRequisition.ddlBNKAccountAcctType);
     
     // Select a random Reported By from the returned list
     List<WebElement> selections = oBNKAccountAcctType.getOptions ();
     oBNKAccountAcctType.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
}


//select a specified value
public void selectBNKAccountAcctType (String ddlBNKAccountAcctType)
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlBNKAccountAcctType));

     orPolicyAPInitiateRequisition.ddlBNKAccountAcctType.click ();
     Select oBNKAccountAcctType = new Select (orPolicyAPInitiateRequisition.ddlBNKAccountAcctType);
     oBNKAccountAcctType.selectByVisibleText (ddlBNKAccountAcctType);
}

public void typeSCAccountNumber ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCAccountNumber));
     
     orPolicyAPInitiateRequisition.txtSCAccountNumber.click ();
     orPolicyAPInitiateRequisition.txtSCAccountNumber.sendKeys (RandomLetters.produceRandomString (18));
}

//fill with specified text
public void setSCAccountNumber (String txtSCAccountNumber)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCAccountNumber));

     orPolicyAPInitiateRequisition.txtSCAccountNumber.click ();
     orPolicyAPInitiateRequisition.txtSCAccountNumber.sendKeys (txtSCAccountNumber);
}

public void typeSCBSBNumber ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCBSBNumber));
     
     orPolicyAPInitiateRequisition.txtSCBSBNumber.click ();
     orPolicyAPInitiateRequisition.txtSCBSBNumber.sendKeys (RandomLetters.produceRandomString (9));
}

//fill with specified text
public void setSCBSBNumber (String txtSCBSBNumber)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCBSBNumber));

     orPolicyAPInitiateRequisition.txtSCBSBNumber.click ();
     orPolicyAPInitiateRequisition.txtSCBSBNumber.sendKeys (txtSCBSBNumber);
}

public void typePayeeDetailsOverrideName ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.taPayeeDetailsOverrideName));
     
     orPolicyAPInitiateRequisition.taPayeeDetailsOverrideName.click ();
  orPolicyAPInitiateRequisition.taPayeeDetailsOverrideName.sendKeys (RandomLetters.produceRandomString (999));
}

//fill with specified text
public void setPayeeDetailsOverrideName (String taPayeeDetailsOverrideName)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.taPayeeDetailsOverrideName));

     orPolicyAPInitiateRequisition.taPayeeDetailsOverrideName.click ();
  orPolicyAPInitiateRequisition.taPayeeDetailsOverrideName.sendKeys (taPayeeDetailsOverrideName);
}

//select a random element from the list
public void selectReqHeaderReqType ()
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlRequisitionType));
     
     orPolicyAPInitiateRequisition.ddlRequisitionType.click ();
     Select oReqHeaderReqType = new Select (orPolicyAPInitiateRequisition.ddlRequisitionType);
     
     // Select a random Reported By from the returned list
     List<WebElement> selections = oReqHeaderReqType.getOptions ();
     oReqHeaderReqType.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
}


//select a specified value
public void selectReqHeaderReqType (String strRequisitionType)
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlRequisitionType));

     orPolicyAPInitiateRequisition.ddlRequisitionType.click ();
     Select oReqHeaderReqType = new Select (orPolicyAPInitiateRequisition.ddlRequisitionType);
     oReqHeaderReqType.selectByVisibleText (strRequisitionType);
}

public void typeReqHeaderPolNum (String strPolicyNumber)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtPolicyNumber));
     
     orPolicyAPInitiateRequisition.txtPolicyNumber.click ();
     orPolicyAPInitiateRequisition.txtPolicyNumber.sendKeys (strPolicyNumber);
}

//fill with specified text
public void setReqHeaderPolNum (String txtReqHeaderPolNum)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtPolicyNumber));

     orPolicyAPInitiateRequisition.txtPolicyNumber.click ();
     orPolicyAPInitiateRequisition.txtPolicyNumber.sendKeys (txtReqHeaderPolNum);
}

public void typeReqHeaderAgent ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtReqHeaderAgent));
     
     orPolicyAPInitiateRequisition.txtReqHeaderAgent.click ();
     orPolicyAPInitiateRequisition.txtReqHeaderAgent.sendKeys (RandomLetters.produceRandomString (10));
}

//fill with specified text
public void setReqHeaderAgent (String txtReqHeaderAgent)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtReqHeaderAgent));

     orPolicyAPInitiateRequisition.txtReqHeaderAgent.click ();
     orPolicyAPInitiateRequisition.txtReqHeaderAgent.sendKeys (txtReqHeaderAgent);
}

//select a random element from the list
public void selectReqHeaderAgentSuffix ()
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlReqHeaderAgentSuffix));
     
     orPolicyAPInitiateRequisition.ddlReqHeaderAgentSuffix.click ();
     Select oReqHeaderAgentSuffix = new Select (orPolicyAPInitiateRequisition.ddlReqHeaderAgentSuffix);
     
     // Select a random Reported By from the returned list
     List<WebElement> selections = oReqHeaderAgentSuffix.getOptions ();
     oReqHeaderAgentSuffix.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
}


//select a specified value
public void selectReqHeaderAgentSuffix (String ddlReqHeaderAgentSuffix)
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlReqHeaderAgentSuffix));

     orPolicyAPInitiateRequisition.ddlReqHeaderAgentSuffix.click ();
     Select oReqHeaderAgentSuffix = new Select (orPolicyAPInitiateRequisition.ddlReqHeaderAgentSuffix);
     oReqHeaderAgentSuffix.selectByVisibleText (ddlReqHeaderAgentSuffix);
}

//click the checkbox
public void clickWithholdings1099 ()
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.chkWithholdings1099));
     
     orPolicyAPInitiateRequisition.chkWithholdings1099.click ();
}


//select a specified state
public void selectWithholdings1099 (boolean selected)
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.chkWithholdings1099));

     // only call the click method if the state requires a click
     if (selected && !orPolicyAPInitiateRequisition.chkWithholdings1099.isSelected() || !selected && orPolicyAPInitiateRequisition.chkWithholdings1099.isSelected())
             orPolicyAPInitiateRequisition.chkWithholdings1099.click ();
}

//select a random element from the list
public void selectWithholdingsWithholdType ()
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlWithholdingsWithholdType));
     
    orPolicyAPInitiateRequisition.ddlWithholdingsWithholdType.click ();
     Select oWithholdingsWithholdType = new Select (orPolicyAPInitiateRequisition.ddlWithholdingsWithholdType);
     
     // Select a random Reported By from the returned list
     List<WebElement> selections = oWithholdingsWithholdType.getOptions ();
     oWithholdingsWithholdType.selectByIndex (RandomNumbers.randomSelect (selections.size ()));
}


//select a specified value
public void selectWithholdingsWithholdType (String ddlWithholdingsWithholdType)
{
     //@formatter:off
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on
     
     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.ddlWithholdingsWithholdType));

    orPolicyAPInitiateRequisition.ddlWithholdingsWithholdType.click ();
     Select oWithholdingsWithholdType = new Select (orPolicyAPInitiateRequisition.ddlWithholdingsWithholdType);
     oWithholdingsWithholdType.selectByVisibleText (ddlWithholdingsWithholdType);
}

public void typeSCClientSearchLastName ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchLastName));
     
     orPolicyAPInitiateRequisition.txtSCClientSearchLastName.click ();
   orPolicyAPInitiateRequisition.txtSCClientSearchLastName.sendKeys (RandomLetters.produceRandomString (40));
}

//fill with specified text
public void setSCClientSearchLastName (String txtSCClientSearchLastName)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchLastName));

     orPolicyAPInitiateRequisition.txtSCClientSearchLastName.click ();
   orPolicyAPInitiateRequisition.txtSCClientSearchLastName.sendKeys (txtSCClientSearchLastName);
}

public void typeSCClientSearchFirstName ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchFirstName));
     
     orPolicyAPInitiateRequisition.txtSCClientSearchFirstName.click ();
  orPolicyAPInitiateRequisition.txtSCClientSearchFirstName.sendKeys (RandomLetters.produceRandomString (20));
}

//fill with specified text
public void setSCClientSearchFirstName (String txtSCClientSearchFirstName)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchFirstName));

     orPolicyAPInitiateRequisition.txtSCClientSearchFirstName.click ();
  orPolicyAPInitiateRequisition.txtSCClientSearchFirstName.sendKeys (txtSCClientSearchFirstName);
}

public void typeSCClientSearchCompanyName ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchCompanyName));
     
   orPolicyAPInitiateRequisition.txtSCClientSearchCompanyName.click ();
orPolicyAPInitiateRequisition.txtSCClientSearchCompanyName.sendKeys (RandomLetters.produceRandomString (40));
}

//fill with specified text
public void setSCClientSearchCompanyName (String txtSCClientSearchCompanyName)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchCompanyName));

   orPolicyAPInitiateRequisition.txtSCClientSearchCompanyName.click ();
orPolicyAPInitiateRequisition.txtSCClientSearchCompanyName.sendKeys (txtSCClientSearchCompanyName);
}

public void typeSCClientSearchCity ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchCity));
     
     orPolicyAPInitiateRequisition.txtSCClientSearchCity.click ();
     orPolicyAPInitiateRequisition.txtSCClientSearchCity.sendKeys (RandomLetters.produceRandomString (20));
}

//fill with specified text
public void setSCClientSearchCity (String txtSCClientSearchCity)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchCity));

     orPolicyAPInitiateRequisition.txtSCClientSearchCity.click ();
     orPolicyAPInitiateRequisition.txtSCClientSearchCity.sendKeys (txtSCClientSearchCity);
}

public void typeSCClientSearchPostCode ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchPostCode));
     
     orPolicyAPInitiateRequisition.txtSCClientSearchPostCode.click ();
   orPolicyAPInitiateRequisition.txtSCClientSearchPostCode.sendKeys (RandomLetters.produceRandomString (10));
}

//fill with specified text
public void setSCClientSearchPostCode (String txtSCClientSearchPostCode)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchPostCode));

     orPolicyAPInitiateRequisition.txtSCClientSearchPostCode.click ();
   orPolicyAPInitiateRequisition.txtSCClientSearchPostCode.sendKeys (txtSCClientSearchPostCode);
}

public void typeSCClientSearchPhoneNum ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchPhoneNum));
     
     orPolicyAPInitiateRequisition.txtSCClientSearchPhoneNum.click ();
   orPolicyAPInitiateRequisition.txtSCClientSearchPhoneNum.sendKeys (RandomLetters.produceRandomString (12));
}

//fill with specified text
public void setSCClientSearchPhoneNum (String txtSCClientSearchPhoneNum)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchPhoneNum));

     orPolicyAPInitiateRequisition.txtSCClientSearchPhoneNum.click ();
   orPolicyAPInitiateRequisition.txtSCClientSearchPhoneNum.sendKeys (txtSCClientSearchPhoneNum);
}

public void typeSCClientSearchSSN ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchSSN));
     
     orPolicyAPInitiateRequisition.txtSCClientSearchSSN.click ();
     orPolicyAPInitiateRequisition.txtSCClientSearchSSN.sendKeys (RandomLetters.produceRandomString (15));
}

//fill with specified text
public void setSCClientSearchSSN (String txtSCClientSearchSSN)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchSSN));

     orPolicyAPInitiateRequisition.txtSCClientSearchSSN.click ();
     orPolicyAPInitiateRequisition.txtSCClientSearchSSN.sendKeys (txtSCClientSearchSSN);
}

public void typeSCClientSearchTaxID ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchTaxID));
     
     orPolicyAPInitiateRequisition.txtSCClientSearchTaxID.click ();
     orPolicyAPInitiateRequisition.txtSCClientSearchTaxID.sendKeys (RandomLetters.produceRandomString (15));
}

//fill with specified text
public void setSCClientSearchTaxID (String txtSCClientSearchTaxID)
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.txtSCClientSearchTaxID));

     orPolicyAPInitiateRequisition.txtSCClientSearchTaxID.click ();
     orPolicyAPInitiateRequisition.txtSCClientSearchTaxID.sendKeys (txtSCClientSearchTaxID);
}

public void clickGo ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.btnGo));
     
     orPolicyAPInitiateRequisition.btnGo.click ();
   
}

public void clickContinue ()
{
     //@formatter:off 
     loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
     //@formatter:on

     WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
     wait.until (ExpectedConditions.elementToBeClickable (orPolicyAPInitiateRequisition.btnContinue));
     
     orPolicyAPInitiateRequisition.btnContinue.click ();
   
}

}



