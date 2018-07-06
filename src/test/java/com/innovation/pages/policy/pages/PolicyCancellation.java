/**
 * 
 */
package com.innovation.pages.policy.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.DatabaseData;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomCount;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicyCancellation;
import com.innovation.sql.policy.PolicySQL;

/**
 * @author Tahir - This class stores all the locators and methods of the Policy Cancellation screen
 */

public class PolicyCancellation
{

	WebDriver				driver;
	OR_PolicyCancellation	orPolicyCancellation	= null;
	OR_ControlPanel			orControlPanel			= null;

	public PolicyCancellation (WebDriver driver)
	{
		this.driver = driver;
		orPolicyCancellation = PageFactory.initElements (driver, OR_PolicyCancellation.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	public String selectRandomLOB ()
	{

		final String[] strings = { "HOM", "AUT" };
		Random random = new Random ();
		String strRandomLOB = strings[random.nextInt (strings.length)];

		return strRandomLOB;
	}

	public String getPolicy (String strEnvironmentName, String strCompany, String strLOB) throws Exception
	{

		String strPolicyNumber = null;

		if (strLOB.contains ("AUT"))
		{
			String strSQLQuery = PolicySQL.returnAutoPolicyforCancellation (strCompany);
			List<String> strPolicyNo = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
			String strPolicyProduct = strPolicyNo.get (0);
			String strSeqPol = strPolicyNo.get (1);
			int intPolicyNo = strSeqPol.length ();

			if (intPolicyNo == 1)
			{
				strPolicyNumber = strPolicyProduct + "00000000" + strSeqPol;
			}
			else if (intPolicyNo == 2)
			{
				strPolicyNumber = strPolicyProduct + "0000000" + strSeqPol;
			}
			else if (intPolicyNo == 3)
			{
				strPolicyNumber = strPolicyProduct + "000000" + strSeqPol;
			}
			else if (intPolicyNo == 4)
			{
				strPolicyNumber = strPolicyProduct + "00000" + strSeqPol;
			}
			else if (intPolicyNo == 5)
			{
				strPolicyNumber = strPolicyProduct + "0000" + strSeqPol;
			}
			else if (intPolicyNo == 6)
			{
				strPolicyNumber = strPolicyProduct + "000" + strSeqPol;
			}

			else if (intPolicyNo == 7)
			{
				strPolicyNumber = strPolicyProduct + "00" + strSeqPol;
			}

			else if (intPolicyNo == 8)
			{
				strPolicyNumber = strPolicyProduct + "0" + strSeqPol;
			}

			else
			{
				strPolicyNumber = strPolicyProduct + strSeqPol;
			}

		}

		else if (strLOB.contains ("HOM"))
		{
			String strSQLQuery = PolicySQL.returnHomePolicyforCancellation (strCompany);
			List<String> strPolicyNo = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
			String strPolicyProduct = strPolicyNo.get (0);
			String strSeqPol = strPolicyNo.get (1);
			int intPolicyNo = strSeqPol.length ();

			if (intPolicyNo == 1)
			{
				strPolicyNumber = strPolicyProduct + "00000000" + strSeqPol;
			}
			else if (intPolicyNo == 2)
			{
				strPolicyNumber = strPolicyProduct + "0000000" + strSeqPol;
			}
			else if (intPolicyNo == 3)
			{
				strPolicyNumber = strPolicyProduct + "000000" + strSeqPol;
			}
			else if (intPolicyNo == 4)
			{
				strPolicyNumber = strPolicyProduct + "00000" + strSeqPol;
			}
			else if (intPolicyNo == 5)
			{
				strPolicyNumber = strPolicyProduct + "0000" + strSeqPol;
			}
			else if (intPolicyNo == 6)
			{
				strPolicyNumber = strPolicyProduct + "000" + strSeqPol;
			}

			else if (intPolicyNo == 7)
			{
				strPolicyNumber = strPolicyProduct + "00" + strSeqPol;
			}

			else if (intPolicyNo == 8)
			{
				strPolicyNumber = strPolicyProduct + "0" + strSeqPol;
			}

			else
			{
				strPolicyNumber = strPolicyProduct + strSeqPol;
			}

		}
		return strPolicyNumber;
	}

	public void searchPolicytoCancel (String strPolicy)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyCancellation.prgProgress));
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCancellation.txtQuickSearch));
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCancellation.imgQuickSearchIcon));
		orPolicyCancellation.txtQuickSearch.sendKeys (strPolicy);
		orPolicyCancellation.imgQuickSearchIcon.click ();

	}

	public void setCancellationDate (String strLocation, int intDays, int intMonth, int intYear)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyCancellation.prgProgress));
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCancellation.dtpCancellationDate));
		orPolicyCancellation.dtpCancellationDate.click ();
		orPolicyCancellation.dtpCancellationDate.sendKeys (CalenderDate.returnDesiredDate (strLocation, intDays, intMonth, intYear));

	}

	public String setCancellationReason ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyCancellation.prgProgress));
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCancellation.ddlCnclReason));

		Select oCancelReason = new Select (orPolicyCancellation.ddlCnclReason);
		int intCancelReasonIndex = RandomCount.selectRandomItem (oCancelReason);
		oCancelReason.selectByIndex (intCancelReasonIndex);

		String strCancellationReason = oCancelReason.getFirstSelectedOption ().getText ();

		return strCancellationReason;
	}

	public void processCancellation ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyCancellation.prgProgress));
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyCancellation.btnProcess));
		orPolicyCancellation.btnProcess.click ();
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	public void commitCancellation (String strPolicytoCancel)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyCancellation.prgProgress));
		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		load.until (ExpectedConditions.elementToBeClickable (orPolicyCancellation.btnCommitCancel));
		orPolicyCancellation.btnCommitCancel.click ();
		WebDriverWait Wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		Wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));

		boolean blnIsStateVisible = orPolicyCancellation.errPanel.isDisplayed ();
		if (blnIsStateVisible)
		{
			load.until (ExpectedConditions.elementToBeClickable (orPolicyCancellation.txtQuickSearch));
			load.until (ExpectedConditions.elementToBeClickable (orPolicyCancellation.imgQuickSearchIcon));
			System.out.println ("There are no activities scheduled for this Policy, However it has been Cancelled");
			wait.until (ExpectedConditions.visibilityOf (orPolicyCancellation.txtQuickSearch));
			orPolicyCancellation.txtQuickSearch.click ();
			orPolicyCancellation.txtQuickSearch.sendKeys (strPolicytoCancel);
			orPolicyCancellation.imgQuickSearchIcon.click ();
			wait.until (ExpectedConditions.invisibilityOf (orPolicyCancellation.prgProgress));
		}

	}
}
