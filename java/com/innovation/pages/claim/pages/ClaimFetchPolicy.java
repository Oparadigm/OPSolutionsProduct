package com.innovation.pages.claim.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.DatabaseData;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.pages.claim.objects.OR_ClaimFetchPolicy;
import com.innovation.pages.claim.pages.ClaimMainSearch;
import com.innovation.pages.claim.objects.OR_ClaimMainSearch;
import com.innovation.sql.policy.PolicySQL;

/**
 * @author Rizwan. This class stores all the locators and methods in Claim's Back Office Fetch Policy screen in Home LOBs.
 *
 */
public class ClaimFetchPolicy
{
	WebDriver			driver;
	OR_ClaimFetchPolicy	orClaimFetchPolicy	= null;
	OR_ClaimMainSearch	orMainSearch		= null;

	public ClaimFetchPolicy (WebDriver driver)
	{
		this.driver = driver;
		orClaimFetchPolicy = PageFactory.initElements (driver, OR_ClaimFetchPolicy.class);
	}

	public void typePolicyNo (String strPolicyNo)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimFetchPolicy.txtPolicyNo));

		orClaimFetchPolicy.txtPolicyNo.click ();
		orClaimFetchPolicy.txtPolicyNo.sendKeys (strPolicyNo);
	}

	public void typeHomePolicyWithQuery (String strEnvironmentName, String strCompany) throws Exception

	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimFetchPolicy.txtPolicyNo));
		String strSQLQuery = PolicySQL.returnHomePolicyBldgAndContCovers (strCompany);
		List<String> strPolicyNo = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		String strPolicyNumber = null;
		strPolicyNumber = ClaimMainSearch.completePolicy (strPolicyNumber, strPolicyNo);

		orClaimFetchPolicy.txtPolicyNo.sendKeys (strPolicyNumber);
	}

	public void ClickfetchPolicy ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimFetchPolicy.btnFetchPolicy));

		orClaimFetchPolicy.btnFetchPolicy.click ();

		// This waits until the progress bar that displays to load e.g. the address goes invisible
		wait.until (ExpectedConditions.invisibilityOf (orClaimFetchPolicy.prgProgressBar));
	}

	public void selectClaimingFor ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		// wait.until (ExpectedConditions.elementToBeClickable (orClaimFetchPolicy.chkClaimingFor));
		wait.until (ExpectedConditions.visibilityOf (orClaimFetchPolicy.chkClaimingFor));
		orClaimFetchPolicy.chkClaimingFor.click ();

		// This waits until the progress bar that displays to load e.g. the address goes invisible
		wait.until (ExpectedConditions.invisibilityOf (orClaimFetchPolicy.prgProgressBar));
	}

}
