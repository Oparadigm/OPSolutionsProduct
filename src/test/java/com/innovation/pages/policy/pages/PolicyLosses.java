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
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.TableHandler;
import com.innovation.pages.policy.objects.OR_PolicyLosses;

/**
 * @author lushs - Create the page details for the Losses screen
 */

/*
 * @author Kamran Mahmood - Update the class to add losses after selecting risk row
 */

public class PolicyLosses
{

	WebDriver		driver;
	OR_PolicyLosses	orPolicyLosses	= null;

	public PolicyLosses (WebDriver driver)
	{
		this.driver = driver;
		orPolicyLosses = PageFactory.initElements (driver, OR_PolicyLosses.class);
	}

	public void clickProceedNext ()
	{
		// This will wait for up to 3 seconds for the Proceed Next button to become available.
		// We had to add a hardcoded wait due to a firefox bug.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyLosses.btnProceedNext));
		orPolicyLosses.btnProceedNext.click ();
	}

	public void selectRiskRow (String strHomeRiskType)
	{

		// This will create a new instance of TableHandler class and click on desired row
		TableHandler selectRownfromTable = new TableHandler (driver);
		String strTableName = "tblPropertyRisks".trim ();
		selectRownfromTable.returnRowInTable (strTableName, strHomeRiskType);
	}

	public void clickRiskAddLoss ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyLosses.btnAddLoss));
		orPolicyLosses.btnAddLoss.click ();

	}

	public void selectLossDescription ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyLosses.rdoLossDescription));
		orPolicyLosses.rdoLossDescription.click ();
		Select oSelectLossDescription = new Select (orPolicyLosses.rdoLossDescription);
		int intIndex = RandomCount.selectRandomItem (oSelectLossDescription);
		oSelectLossDescription.selectByIndex (intIndex);

	}

	public void typeLossAmount ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyLosses.txtLossAmount));
		orPolicyLosses.txtLossAmount.sendKeys (RandomNumbers.produceRandomNumber (3));
	}

	public void typeLossDate (String strRegion)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyLosses.dtpLossDate));
		orPolicyLosses.dtpLossDate.click ();
		int intDays = RandomNumbers.randomNumberGenerator (1, 30);
		int intMonths = RandomNumbers.randomNumberGenerator (1, 12);
		int intYears = RandomNumbers.randomNumberGenerator (2014, 2017);
		String strLossDate = CalenderDate.setRandomDate (strRegion, intDays, intMonths, intYears);
		orPolicyLosses.dtpLossDate.sendKeys (strLossDate);

	}

	public void clickDetailsAddLoss ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyLosses.btnAddLossDetails));
		orPolicyLosses.btnAddLossDetails.click ();
	}

}
