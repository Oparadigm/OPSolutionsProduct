/**
 * 
 */
package com.innovation.pages.policy.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.DatabaseData;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.TableHandler;
import com.innovation.pages.common.pages.ActionsPanel;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicySummary;
import com.innovation.sql.policy.PolicySQL;

/**
 * @author lushs & haiderm - This class stores all the locators and methods of the Policy summary screen
 */

public class PolicySummary
{

	WebDriver			driver;
	OR_PolicySummary	orPolicySummary	= null;

	public PolicySummary (WebDriver driver)
	{
		this.driver = driver;
		orPolicySummary = PageFactory.initElements (driver, OR_PolicySummary.class);
	}

	// The following function will randomly return the Bill Plan

	public String returnBillPlan (String strCompany, String strEnvironmentName, String strSubCoy) throws Exception
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicySummary.prgProgressbar));
		wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.tblBillPlanDesc));
		String strBillPlanSQLQuery = PolicySQL.returnPolicyBillPlan (strCompany, strSubCoy);
		List<String> BillPlanDESC = DatabaseData.returnDatabaseValue (strBillPlanSQLQuery, strEnvironmentName);

		int intBillPlanIndex = BillPlanDESC.size () - 1;
		String strSelectedBillPlan = BillPlanDESC.get (RandomNumbers.randomNumberGenerator (0, intBillPlanIndex));

		return strSelectedBillPlan;

	}

	public void selectBillPlan (String strBillPlan)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicySummary.prgProgressbar));
		wait.until (ExpectedConditions.visibilityOf (orPolicySummary.tblBillPlanDesc));
		if (strBillPlan.equalsIgnoreCase ("Annual direct debit") || strBillPlan.equalsIgnoreCase ("Annual DD") || strBillPlan.equalsIgnoreCase ("ANDD"))
		{

			wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.tblAnnualDirectDebit));
			orPolicySummary.tblAnnualDirectDebit.click ();
		}
		else if (strBillPlan.equalsIgnoreCase ("Annual Card") || strBillPlan.equalsIgnoreCase ("CARD"))
		{

			wait.until (ExpectedConditions.visibilityOf (orPolicySummary.tblBillPlanDesc));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.tblAnnualCard));
			orPolicySummary.tblAnnualCard.click ();
		}
		else if (strBillPlan.equalsIgnoreCase ("Monthly DD 8%") || strBillPlan.equalsIgnoreCase ("Monthly DD") ||
			strBillPlan.equalsIgnoreCase ("Monthly direct debit") || strBillPlan.equalsIgnoreCase ("MNDD"))
		{

			wait.until (ExpectedConditions.visibilityOf (orPolicySummary.tblBillPlanDesc));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.tblMonthlyDirectDebit));
			orPolicySummary.tblMonthlyDirectDebit.click ();
		}
		else if (strBillPlan.equalsIgnoreCase ("Temp Agency Bill Plan") || strBillPlan.equalsIgnoreCase ("Agency bill") ||
			strBillPlan.equalsIgnoreCase ("Temp Agency") || strBillPlan.equalsIgnoreCase ("DAGT"))
		{

			wait.until (ExpectedConditions.visibilityOf (orPolicySummary.tblBillPlanDesc));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.tblTempAgencyBillPlan));
			orPolicySummary.tblTempAgencyBillPlan.click ();
		}

		else if (strBillPlan.equalsIgnoreCase ("1 Pay"))
		{

			wait.until (ExpectedConditions.visibilityOf (orPolicySummary.tblBillPlanDesc));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.tblOnePay));
			orPolicySummary.tblOnePay.click ();
		}

		else if (strBillPlan.equalsIgnoreCase ("Agent"))
		{

			wait.until (ExpectedConditions.visibilityOf (orPolicySummary.tblBillPlanDesc));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.tblAgentBillPlan));
			orPolicySummary.tblAgentBillPlan.click ();
		}

		else if (strBillPlan.equalsIgnoreCase ("Monthly Direct"))
		{

			wait.until (ExpectedConditions.visibilityOf (orPolicySummary.tblBillPlanDesc));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.tblMonthlyDirectBill));
			orPolicySummary.tblMonthlyDirectBill.click ();
		}

		else if (strBillPlan.equalsIgnoreCase ("Monthly EFT"))
		{

			wait.until (ExpectedConditions.visibilityOf (orPolicySummary.tblBillPlanDesc));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.tblMonthlyEFT));
			orPolicySummary.tblMonthlyEFT.click ();
		}
		else if (strBillPlan.equalsIgnoreCase ("Quarterly Direct Bill"))
		{

			wait.until (ExpectedConditions.visibilityOf (orPolicySummary.tblBillPlanDesc));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.tblQuarterlyDirectBill));
			orPolicySummary.tblQuarterlyDirectBill.click ();
		}

		else if (strBillPlan.equalsIgnoreCase ("Quarterly EFT Bill"))
		{

			wait.until (ExpectedConditions.visibilityOf (orPolicySummary.tblBillPlanDesc));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.tblQuarterlyEFT));
			orPolicySummary.tblQuarterlyEFT.click ();
		}

	}

	public void clickSelectButton ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.btnSelect));
		orPolicySummary.btnSelect.click ();
		wait.until (ExpectedConditions.invisibilityOf (orPolicySummary.prgProgressbar));
	}

	// This gets the Policy Quote Number
	public void checkQutoePolicyNo ()
	{
		ControlPanel control = new ControlPanel (driver);
		control.getQuotePolicyNumber ();
	}

	public void proceedContinue ()

	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.btnProceedNext));

		orPolicySummary.btnProceedNext.click ();
	}

	public void checkQutoePolicyStatus ()
	{
		// Actions Panel object Declaration
		ActionsPanel panel = new ActionsPanel (driver);

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicySummary.prgProgressbar));
		wait.until (ExpectedConditions.elementToBeClickable (orPolicySummary.lblTransactionStatus));

		String strTransactionStatus = orPolicySummary.lblTransactionStatus.getText ();

		if (strTransactionStatus.contains ("Incomplete quote"))
		{
			panel.clickCompleteQuote ();

		}
		else
			System.out.println ("Your policy status is" + strTransactionStatus);
	}

	public void checkPolicyStatus ()
	{
		// Actions Panel object Declaration
		ActionsPanel panel = new ActionsPanel (driver);

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicySummary.prgProgressbar));

		String strTransactionStatus = orPolicySummary.lblPolicyTransactionStatus.getText ();

		if (strTransactionStatus.contains ("Incomplete"))
		{
			panel.clickCompleteQuote ();

		}
		else
			System.out.println ("Your policy status is" + " " + strTransactionStatus);
	}

	public void checkPolicyCompleteness ()
	{

		TableHandler table = new TableHandler (driver);
		ControlPanel control = new ControlPanel (driver);
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicySummary.prgProgressbar));
		wait.until (ExpectedConditions.visibilityOf (orPolicySummary.lblAmountDueNow));

		String strTotalAmount = orPolicySummary.lblAmountDueNow.getText ();

		boolean boolCheckPremium = table.checkTableHasRecords ("MultiLine_RiskList", strTotalAmount, "All");

		if (boolCheckPremium == true)
		{

			control.clickNext ();

		}

	}

}
