/**
 * 
 */
package com.innovation.pages.policy.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.DatabaseData;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicyStartDetails;
import com.innovation.sql.agent.AgentSQL;

/**
 * @author lushs
 *
 */
public class PolicyStartDetails
{

	WebDriver				driver;
	OR_PolicyStartDetails	orPolicyStartDetails	= null;

	public PolicyStartDetails (WebDriver driver)
	{
		this.driver = driver;
		orPolicyStartDetails = PageFactory.initElements (driver, OR_PolicyStartDetails.class);

	}

	// this method is optional depending on if the value is visible on the screen.
	public void selectRegion (String strState)
	{

		try
		{

			boolean blnIsStateVisible = orPolicyStartDetails.ddlRegion.isDisplayed ();
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.visibilityOf (orPolicyStartDetails.ddlRegion));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyStartDetails.ddlRegion));
			orPolicyStartDetails.ddlRegion.click ();
			Select oRegion = new Select (orPolicyStartDetails.ddlRegion);
			oRegion.selectByVisibleText (strState);

		}
		catch (NoSuchElementException ignored)
		{

		}

	}

	public void selectLOB (String sLob)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyStartDetails.ddlLOB));
		wait.until (ExpectedConditions.visibilityOf (orPolicyStartDetails.ddlLOB));
		orPolicyStartDetails.ddlLOB.click ();
		Select oLOB = new Select (orPolicyStartDetails.ddlLOB);
		oLOB.selectByVisibleText (sLob);
	}

	public void typeAgent (String strEnvironmentName, String strCompany, String strState, String strSubCompany) throws Exception
	{

		ControlPanel control = new ControlPanel (driver);
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyStartDetails.txtAgent));

		// Add Agent From DataBase
		String strAgentSQLQuery = AgentSQL.returnAgentNumbers (strCompany, strState, strSubCompany);
		List<String> strDBAgentNumber = DatabaseData.returnDatabaseValue (strAgentSQLQuery, strEnvironmentName);
		String strSelectedDBAgentNumber = strDBAgentNumber.get (0);

		orPolicyStartDetails.txtAgent.sendKeys (strSelectedDBAgentNumber);

		orPolicyStartDetails.btnLookUp.click ();
		wait.until (ExpectedConditions.invisibilityOf (orPolicyStartDetails.prgProgressBar));
		control.clickNext ();
	}

	public void selectInceptionDate (String strLocation, int intDays, int intMonths, int intYears)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyStartDetails.prgProgressBar));
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyStartDetails.dtpEffectiveDate));
		orPolicyStartDetails.dtpEffectiveDate.click ();
		orPolicyStartDetails.dtpEffectiveDate.sendKeys (CalenderDate.returnDesiredDate (strLocation, intDays, intMonths, intYears));

	}

	public void clickProceedButton ()
	{
		System.out.println ("Test");

	}

}
