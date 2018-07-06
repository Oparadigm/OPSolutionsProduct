package com.innovation.pages.claim.pages;

/**
 * 
 */

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
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
import com.innovation.misc.TransactionTimer;
import com.innovation.pages.claim.objects.OR_ClaimWorkStatus;
import com.innovation.pages.common.objects.OR_ActionsPanel;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.common.pages.NavigationPanel;

/**
 * @author alamq This class will store all the locators and methods on Work Status Screen
 */

public class ClaimWorkStatus
{
	WebDriver				driver;
	StopWatch				stopwatch			= new StopWatch ();
	LoggingControl			loggingcontrol			= new LoggingControl ();
	OR_ClaimWorkStatus	    orClaimWorkStatus	= null;
	OR_ActionsPanel			orActionsPanel		= null;
	OR_ControlPanel		    orControlPanel		= null;

	public ClaimWorkStatus (WebDriver driver)
	{
		this.driver = driver;
		orClaimWorkStatus = PageFactory.initElements (driver, OR_ClaimWorkStatus.class);
		orActionsPanel = PageFactory.initElements (driver, OR_ActionsPanel.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	// select a random element from the list
	public void selectNewClaimStatus ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlNewClaimStatus));
		
		orClaimWorkStatus.ddlNewClaimStatus.click ();
		Select oNewClaimStatus = new Select (orClaimWorkStatus.ddlNewClaimStatus);
		
		// Select a random Reported By from the returned list
		List<WebElement> selections = oNewClaimStatus.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oNewClaimStatus.selectByIndex (index);
	}


	// select a specified value
	public void selectNewClaimStatus (String ddlNewClaimStatus)
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlNewClaimStatus));

		orClaimWorkStatus.ddlNewClaimStatus.click ();
		Select oNewClaimStatus = new Select (orClaimWorkStatus.ddlNewClaimStatus);
		oNewClaimStatus.selectByVisibleText (ddlNewClaimStatus);
	}

	// select a random element from the list
	public void selectReason ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlReason));
		
		orClaimWorkStatus.ddlReason.click ();
		Select oReason = new Select (orClaimWorkStatus.ddlReason);
		
		// Select a random Reported By from the returned list
		List<WebElement> selections = oReason.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oReason.selectByIndex (index);
	}


	// select a specified value
	public void selectReason (String ddlReason)
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlReason));

		orClaimWorkStatus.ddlReason.click ();
		Select oReason = new Select (orClaimWorkStatus.ddlReason);
		oReason.selectByVisibleText (ddlReason);
	}

	public void typeDuplicateClaimNumber ()
	{
		//@formatter:off 
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.txtDuplicateClaimNumber));
		
		orClaimWorkStatus.txtDuplicateClaimNumber.click ();
		orClaimWorkStatus.txtDuplicateClaimNumber.sendKeys (RandomLetters.produceRandomString (5));
	}

	// fill with specified text
	public void setDuplicateClaimNumber (String txtDuplicateClaimNumber)
	{
		//@formatter:off 
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.txtDuplicateClaimNumber));

		orClaimWorkStatus.txtDuplicateClaimNumber.click ();
		orClaimWorkStatus.txtDuplicateClaimNumber.sendKeys (txtDuplicateClaimNumber);
	}

	// select a random element from the list
	public void selectNewStatus ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlNewStatus));
		
		orClaimWorkStatus.ddlNewStatus.click ();
		Select oNewStatus = new Select (orClaimWorkStatus.ddlNewStatus);
		
		// Select a random New Status from the returned list
		List<WebElement> selections = oNewStatus.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oNewStatus.selectByIndex (index);
	}


	// select a specified value
	public void selectNewStatus (String ddlNewStatus)
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlNewStatus));

		orClaimWorkStatus.ddlNewStatus.click ();
		Select oNewStatus = new Select (orClaimWorkStatus.ddlNewStatus);
		oNewStatus.selectByVisibleText (ddlNewStatus);
	}

	// select a random element from the list
	public void selectReason40a ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlReason40a));
		
		orClaimWorkStatus.ddlReason40a.click ();
		Select oReason = new Select (orClaimWorkStatus.ddlReason40a);
		
		// Select a random Reported By from the returned list
		List<WebElement> selections = oReason.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oReason.selectByIndex (index);
	}


	// select a specified value
	public void selectReason40a (String ddlReason40a)
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlReason40a));

		orClaimWorkStatus.ddlReason40a.click ();
		Select oReason40a = new Select (orClaimWorkStatus.ddlReason40a);
		oReason40a.selectByVisibleText (ddlReason40a);
	}

	// select a random element from the list
	public void selectNewStatus50a ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlNewStatus50a));
		
		orClaimWorkStatus.ddlNewStatus50a.click ();
		Select oNewStatus = new Select (orClaimWorkStatus.ddlNewStatus50a);
		
		// Select a random Reported By from the returned list
		List<WebElement> selections = oNewStatus.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oNewStatus.selectByIndex (index);
	}


	// select a specified value
	public void selectNewStatus50a (String ddlNewStatus50a)
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlNewStatus50a));

		orClaimWorkStatus.ddlNewStatus50a.click ();
		Select oNewStatus50a = new Select (orClaimWorkStatus.ddlNewStatus50a);
		oNewStatus50a.selectByVisibleText (ddlNewStatus50a);
	}

	// select a random element from the list
	public void selectReason50a ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlReason50a));
		
		orClaimWorkStatus.ddlReason50a.click ();
		Select oReason = new Select (orClaimWorkStatus.ddlReason50a);
		
		// Select a random Reason from the returned list
		List<WebElement> selections = oReason.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oReason.selectByIndex (index);
	}


	// select a specified value
	public void selectReason50a (String ddlReason50a)
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlReason50a));

		orClaimWorkStatus.ddlReason50a.click ();
		Select oReason50a = new Select (orClaimWorkStatus.ddlReason50a);
		oReason50a.selectByVisibleText (ddlReason50a);
	}

	public void typeDuplicateClaimNumber50a ()
	{
		//@formatter:off 
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.txtDuplicateClaimNumber50a));
		
		orClaimWorkStatus.txtDuplicateClaimNumber50a.click ();
		orClaimWorkStatus.txtDuplicateClaimNumber50a.sendKeys (RandomLetters.produceRandomString (999));
	}

	// fill with specified text
	public void setDuplicateClaimNumber50a (String txtDuplicateClaimNumber50a)
	{
		//@formatter:off 
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.txtDuplicateClaimNumber50a));

		orClaimWorkStatus.txtDuplicateClaimNumber50a.click ();
		orClaimWorkStatus.txtDuplicateClaimNumber50a.sendKeys (txtDuplicateClaimNumber50a);
	}

//	public void selectClaim (String strClaim)
//	{
//		boolean allowUnknown = false;
//		boolean defaultElse = false;
//		int elseValue = 2;
//		SelectionHelper.selectRadio (orClaimWorkStatus.rdoClaim, strClaim, allowUnknown, defaultElse, elseValue);
//	}
	
	public void selectClaim ()
	{

		//@formatter:off 
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.rdoClaim));
		
		orClaimWorkStatus.rdoClaim.click ();	
	}


	// select a random element from the list
	public void selectFeature ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlFeature));
		
		orClaimWorkStatus.ddlFeature.click ();
		Select oFeature = new Select (orClaimWorkStatus.ddlFeature);
		
		// Select a random Reported By from the returned list
		List<WebElement> selections = oFeature.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oFeature.selectByIndex (index);
	}


	// select a specified value
	public void selectFeature (String ddlFeature)
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlFeature));

		orClaimWorkStatus.ddlFeature.click ();
		Select oFeature = new Select (orClaimWorkStatus.ddlFeature);
		oFeature.selectByVisibleText (ddlFeature);
	}

	// select a random element from the list
	public void selectTeamType ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlTeamType));
		
		orClaimWorkStatus.ddlTeamType.click ();
		Select oTeamType = new Select (orClaimWorkStatus.ddlTeamType);
		
		// Select a random Reported By from the returned list
		List<WebElement> selections = oTeamType.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oTeamType.selectByIndex (index);
	}


	// select a specified value
	public void selectCLMSCBOTeamTypeCombo (String ddlCLMSCBOTeamTypeCombo)
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlTeamType));

		orClaimWorkStatus.ddlTeamType.click ();
		Select oCLMSCBOTeamTypeCombo = new Select (orClaimWorkStatus.ddlTeamType);
		oCLMSCBOTeamTypeCombo.selectByVisibleText (ddlCLMSCBOTeamTypeCombo);
	}

	// select a random element from the list
	public void selectCLMSCBO0196TeamCombo ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlTeam));
		
		orClaimWorkStatus.ddlTeam.click ();
		Select oTeam = new Select (orClaimWorkStatus.ddlTeam);
		
		// Select a random Reported By from the returned list
		List<WebElement> selections = oTeam.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oTeam.selectByIndex (index);
	}


	// select a specified value
	public void selectCLMSCBO0196TeamCombo (String ddlCLMSCBO0196TeamCombo)
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlTeam));

		orClaimWorkStatus.ddlTeam.click ();
		Select oCLMSCBO0196TeamCombo = new Select (orClaimWorkStatus.ddlTeam);
		oCLMSCBO0196TeamCombo.selectByVisibleText (ddlCLMSCBO0196TeamCombo);
	}

	// select a random element from the list
	public void selectCLMSCBOAssignmentCombo ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlAssignment));
		
		orClaimWorkStatus.ddlAssignment.click ();
		Select oAssignment = new Select (orClaimWorkStatus.ddlAssignment);
		
		// Select a random Reported By from the returned list
		List<WebElement> selections = oAssignment.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oAssignment.selectByIndex (index);
	}


	// select a specified value
	public void selectCLMSCBOAssignmentCombo (String ddlCLMSCBOAssignmentCombo)
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlAssignment));

		orClaimWorkStatus.ddlAssignment.click ();
		Select oCLMSCBOAssignmentCombo = new Select (orClaimWorkStatus.ddlAssignment);
		oCLMSCBOAssignmentCombo.selectByVisibleText (ddlCLMSCBOAssignmentCombo);
	}

	// select a random element from the list
	public void selectCLMSCBO0196UserCombo ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlUser));
		
		orClaimWorkStatus.ddlUser.click ();
		Select oUser = new Select (orClaimWorkStatus.ddlUser);
		
		// Select a random Reported By from the returned list
		List<WebElement> selections = oUser.getOptions ();
		int index = (int) (Math.random () * (selections.size () - 2)) + 2;
		oUser.selectByIndex (index);
	}


	// select a specified value
	public void selectCLMSCBO0196UserCombo (String ddlCLMSCBO0196UserCombo)
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.ddlUser));

		orClaimWorkStatus.ddlUser.click ();
		Select oCLMSCBO0196UserCombo = new Select (orClaimWorkStatus.ddlUser);
		oCLMSCBO0196UserCombo.selectByVisibleText (ddlCLMSCBO0196UserCombo);
	}

	// Click on Change Status Button
	public void clickChangeStatus ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.btnChangeStatus));

		orClaimWorkStatus.btnChangeStatus.click ();
		wait.until(ExpectedConditions.invisibilityOf(orControlPanel.barProgress));
		
	}

	// Click on Cancel Button
	public void clickCancel ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.btnCancel));

		orClaimWorkStatus.btnCancel.click ();
	}

	// Click on Cancel Button
	public void clickYes ()
	{
		//@formatter:off
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver);
		//@formatter:on
		
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimWorkStatus.btnYes));

		orClaimWorkStatus.btnYes.click ();
		wait.until(ExpectedConditions.invisibilityOf(orControlPanel.barProgress));
		
	}
	
}
