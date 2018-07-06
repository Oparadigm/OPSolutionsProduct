/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomCount;
import com.innovation.pages.policy.objects.OR_PolicyAgenDetails;

/**
 * @author Kamran Mahmood
 *
 */
public class PolicyAgenDetails
{

	WebDriver				driver;
	OR_PolicyAgenDetails	orPolicyAgenDetails	= null;

	public PolicyAgenDetails (WebDriver driver)
	{
		this.driver = driver;
		orPolicyAgenDetails = PageFactory.initElements (driver, OR_PolicyAgenDetails.class);
	}

	public void dtpEffetiveDate (String strRegion)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.dtpEffectiveDate));
		orPolicyAgenDetails.dtpEffectiveDate.click ();
		String strDate = CalenderDate.returnDesiredDate (strRegion, -5, 0, 0);
		orPolicyAgenDetails.dtpEffectiveDate.sendKeys (strDate);
	}

	public void selectAgentType (String strAgenttype)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlAgentType));
		Select oSelectAgentType = new Select (orPolicyAgenDetails.ddlAgentType);
		oSelectAgentType.selectByVisibleText (strAgenttype);
	}

	public void selectBranch (String strBranch)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlBranch));
		Select oSelectBranch = new Select (orPolicyAgenDetails.ddlBranch);
		oSelectBranch.selectByVisibleText (strBranch);
	}

	public void selectAgentADE ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlAgentADE));
		Select oSelectAgentADE = new Select (orPolicyAgenDetails.ddlAgentADE);
		int intIndex = RandomCount.selectRandomItem (oSelectAgentADE);
		oSelectAgentADE.selectByIndex (intIndex);
	}

	public void selectCreditDate ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlCreditDate));
		Select oSelectCreditDate = new Select (orPolicyAgenDetails.ddlCreditDate);
		int intIndex = RandomCount.selectRandomItem (oSelectCreditDate);
		oSelectCreditDate.selectByIndex (intIndex);
	}

	public void selectRenewalList ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlRenewalList));
		Select oSelectRenewalList = new Select (orPolicyAgenDetails.ddlRenewalList);
		int intIndex = RandomCount.selectRandomItem (oSelectRenewalList);
		oSelectRenewalList.selectByIndex (intIndex);
	}

	public void selectAutoRenewal ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlAutoRenewal));
		Select oSelectAutoRenewal = new Select (orPolicyAgenDetails.ddlAutoRenewal);
		// oSelectAutoRenewal.selectByVisibleText ("Automatic");
		oSelectAutoRenewal.selectByIndex (2);
	}

	public void selectIndexOverride ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlIndexOverride));
		Select oSelectIndexOverride = new Select (orPolicyAgenDetails.ddlIndexOverride);
		int intIndex = RandomCount.selectRandomItem (oSelectIndexOverride);
		oSelectIndexOverride.selectByIndex (intIndex);
	}

	public void selectCreditTerm ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlCreditTerm));
		Select oSelectCreditTerm = new Select (orPolicyAgenDetails.ddlCreditTerm);
		int intIndex = RandomCount.selectRandomItem (oSelectCreditTerm);
		oSelectCreditTerm.selectByIndex (intIndex);
	}

	public void selectMatchingOrder ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlMatchingOrder));
		Select oSelectMatchingOrder = new Select (orPolicyAgenDetails.ddlMatchingOrder);
		int intIndex = RandomCount.selectRandomItem (oSelectMatchingOrder);
		oSelectMatchingOrder.selectByIndex (intIndex);
	}

	public void selectTeam ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlTeam));
		Select oSelectTeam = new Select (orPolicyAgenDetails.ddlTeam);
		int intIndex = RandomCount.selectRandomItem (oSelectTeam);
		oSelectTeam.selectByIndex (intIndex);
	}

	public void selectDisplayOrder ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlDisplayOrder));
		Select oSelectDisplayOrder = new Select (orPolicyAgenDetails.ddlDisplayOrder);
		int Iindex = RandomCount.selectRandomItem (oSelectDisplayOrder);
		oSelectDisplayOrder.selectByIndex (Iindex);

	}

	public void selectClientStmt ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlClientStmt));
		Select oSelectClientStmt = new Select (orPolicyAgenDetails.ddlClientStmt);
		int intIndex = RandomCount.selectRandomItem (oSelectClientStmt);
		oSelectClientStmt.selectByIndex (intIndex);
	}

	public void selectADE ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlADE));
		Select oSelectADE = new Select (orPolicyAgenDetails.ddlADE);
		int intIndex = RandomCount.selectRandomItem (oSelectADE);
		oSelectADE.selectByIndex (intIndex);
	}

	public void selectStatus (String strStatus)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlStatus));
		Select oSelectStatus = new Select (orPolicyAgenDetails.ddlStatus);
		oSelectStatus.selectByVisibleText (strStatus);
	}

	public void selectNoticeTo ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlNoticeTo));
		Select oSelectNoticeTo = new Select (orPolicyAgenDetails.ddlNoticeTo);
		// int intIndex = RandomCount.selectRandomItem (oSelectNoticeTo);
		// oSelectNoticeTo.selectByIndex (intIndex);
		oSelectNoticeTo.selectByVisibleText ("Client");
	}

	public void selectNoticeFreq ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlNoticeFreq));
		Select oSelectNoticeFreq = new Select (orPolicyAgenDetails.ddlNoticeFreq);
		int intIndex = RandomCount.selectRandomItem (oSelectNoticeFreq);
		oSelectNoticeFreq.selectByIndex (intIndex);
	}

	// Select Agent Suffix depending upon parameter
	public void selectSuffix (String strSuffix)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.ddlSuffix));
		Select oSelectSuffix = new Select (orPolicyAgenDetails.ddlSuffix);
		oSelectSuffix.selectByVisibleText (strSuffix);
	}

	public void clickContinue ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyAgenDetails.btnContinue));
		orPolicyAgenDetails.btnContinue.click ();
	}
}
