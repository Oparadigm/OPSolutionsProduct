/**
 * 
 */
package com.innovation.pages.policy.pages;

import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.innovation.misc.DatabaseData;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.TableHandler;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicyRenewals;
import com.innovation.sql.policy.PolicySQL;
import com.innovation.pages.claim.pages.ClaimMainSearch;
import com.innovation.pages.client.pages.ClientSummary;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.NavigationPanel;

/**
 * @author Tahir - This class stores all the locators and methods of the Policy Cancellation screen
 */

public class PolicyRenewals
{

	WebDriver			driver;
	OR_PolicyRenewals	orPolicyRenewals	= null;
	OR_ControlPanel		orControlPanel		= null;

	public PolicyRenewals (WebDriver driver)
	{
		this.driver = driver;
		orPolicyRenewals = PageFactory.initElements (driver, OR_PolicyRenewals.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	public String selectRandomLOB (String strEnvironmentBrand)
	{
		String strRandomLOB = null;
		if (strEnvironmentBrand.contains ("Model Office UK"))
		{
			final String[] strings = { "HOM", "AUT" };
			Random random = new Random ();
			strRandomLOB = strings[random.nextInt (strings.length)];
		}

		else if (strEnvironmentBrand.contains ("Model Office"))
		{
			strRandomLOB = "ELI";

		}

		return strRandomLOB;
	}

	public String getPolicy (String strEnvironmentName, String strCompany, String strLOB) throws Exception
	{

		String strPolicyNumber = null;

		String strSQLQuery = PolicySQL.returnPolicyforRenewals (strCompany, strLOB);
		List<String> strPolicyNo = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		strPolicyNumber = ClaimMainSearch.completePolicy (strPolicyNumber, strPolicyNo);

		return strPolicyNumber;

	}

	public void searchPolicyRenewalActivity (String strPolicy)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));

		// Get The Complete Policy Number:

		// Check the util function to split the policy number
		String strPolicyNumber = StringUtils.substringAfter (strPolicy, "0");
		strPolicyNumber = "0" + strPolicyNumber;
		// Now Enter the policy number to the respective fields
		// Enter the Policy number
		orPolicyRenewals.txtSCPNASearchPolicy.sendKeys (strPolicyNumber);
		orPolicyRenewals.btnSearchRenewalActivities.click ();

	}

	// The Following function will process the Renewals on the basis of Region
	public void processRenewals (String strRegionValue, String strPolicyNumber, String strEnvironmentName, String strEnvironmentBrand)
	{

		ControlPanel control = new ControlPanel (driver);
		PolicyBillingDetails billingdetails = new PolicyBillingDetails (driver);
		if (strRegionValue.contains ("UK"))
		{

			this.applyUKRenewalActivities (strPolicyNumber, strEnvironmentName);
		}

		else
		{
			this.applyUSARenewalActivities (strPolicyNumber, strEnvironmentName);
			// boolean boolCheckNoRenewalOffers = this.validateRenewalNonOffers ();

			if (this.validateRenewalNonOffers () == true)

			{

				System.out.println ("No Renewal Offers are available");
			}
			else
			{
				this.selectDirectBillingActions (strEnvironmentName, strEnvironmentBrand, strRegionValue);
				this.directBillingClickMakeAPayment ();
				billingdetails.selectReceiptType ("Cash");
				this.selectRenewalPaymentTotalBalance ();
				System.out.println ("Your Policy has been Renewed Successfully");
				control.clickFinishTransaction ();
			}
		}
	}

	// The following function will apply the renewal activities for MOUK till it get the renewal activity itself

	public void applyUKRenewalActivities (String strPolicyNumber, String strEnvironmentName)
	{
		ClientSummary clientsummary = new ClientSummary (driver);

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));

		TableHandler tblrenewallist = new TableHandler (driver);
		String strActivityText = null;
		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		do
		{

			load.until (ExpectedConditions.elementToBeClickable (orPolicyRenewals.tblNextActivityList));
			tblrenewallist.returnRowInTable ("tblPolicyNextActivityList", strPolicyNumber);

			load.until (ExpectedConditions.elementToBeClickable (orPolicyRenewals.btnNextActivityApply));
			orPolicyRenewals.btnNextActivityApply.click ();
			String strActivityStatus = orPolicyRenewals.lblActivityStatus.getText ();
			if (strActivityStatus.contains ("Processing suspended - exceptions encountered") == false)
			{
				load.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));
				load.until (ExpectedConditions.elementToBeClickable (orPolicyRenewals.btnApplyActualActivity));
				orPolicyRenewals.btnApplyActualActivity.click ();
				load.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));
				orPolicyRenewals.btnRefresh.click ();
				load.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));
				strActivityText = orPolicyRenewals.tblActivityText.getText ();
			}

			else if (strActivityStatus.contains ("Processing suspended - exceptions encountered") == true)
			{
				System.out.println ("The Policy has pending Renewal Exceptions and cannot be Renewed");
				clientsummary.searchIncompleteTrancation (strPolicyNumber, strEnvironmentName);
				break;
			}
		} while (strActivityText.contentEquals ("Renewal") == false && strActivityText.contentEquals ("Send non-Offer letter to insured") == false);

		if (strActivityText.contains ("Renewal") || strActivityText.contains ("Send non-Offer letter to insured"))
		{
			tblrenewallist.returnRowInTable ("tblPolicyNextActivityList", strPolicyNumber);
			WebDriverWait loadagain = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			loadagain.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));
			loadagain.until (ExpectedConditions.elementToBeClickable (orPolicyRenewals.btnNextActivityApply));
			orPolicyRenewals.btnNextActivityApply.click ();
			loadagain.until (ExpectedConditions.elementToBeClickable (orPolicyRenewals.btnApplyActualActivity));
			orPolicyRenewals.btnApplyActualActivity.click ();

			if (strActivityText.contains ("Renewal"))
			{

				System.out.println ("The Policy has been Renewed Successfully");
				clientsummary.searchIncompleteTrancation (strPolicyNumber, strEnvironmentName);
			}
			else if (strActivityText.contains ("Send non-Offer letter to insured"))
			{
				System.out.println ("Renewals cannot be offered on this Policy");
				clientsummary.searchIncompleteTrancation (strPolicyNumber, strEnvironmentName);
			}

		}

	}

	// The following function will apply the renewal activities for MOUS till it get the renewal activity itself

	public void applyUSARenewalActivities (String strPolicyNumber, String strEnvironmentName)
	{
		ClientSummary clientsummary = new ClientSummary (driver);

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));

		TableHandler tblrenewallist = new TableHandler (driver);
		String strActivityText = null;
		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		do
		{

			load.until (ExpectedConditions.elementToBeClickable (orPolicyRenewals.tblNextActivityList));
			tblrenewallist.returnRowInTable ("tblPolicyNextActivityList", strPolicyNumber);

			load.until (ExpectedConditions.elementToBeClickable (orPolicyRenewals.btnNextActivityApply));
			orPolicyRenewals.btnNextActivityApply.click ();
			String strActivityStatus = orPolicyRenewals.lblActivityStatus.getText ();

			// boolean boolCheckNoRenewalOffer = this.validateRenewalNonOffers ();
			if (this.validateRenewalNonOffers ())
			{
				break;
			}
			if (strActivityStatus.contains ("Processing suspended - exceptions encountered") == false)
			{
				load.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));
				load.until (ExpectedConditions.elementToBeClickable (orPolicyRenewals.btnApplyActualActivity));
				orPolicyRenewals.btnApplyActualActivity.click ();
				load.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));
				orPolicyRenewals.btnRefresh.click ();
				load.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));
				strActivityText = orPolicyRenewals.tblActivityText.getText ();
			}

			else if (strActivityStatus.contains ("Processing suspended - exceptions encountered") == true)
			{
				System.out.println ("The Policy cannot be Renewed either due to pending Exceptions or Non-Offer of Renewals");
				clientsummary.searchIncompleteTrancation (strPolicyNumber, strEnvironmentName);
				break;
			}
		} while (strActivityText.contentEquals ("Notice production") == false);

		if (strActivityText.contains ("Notice production"))
		{
			tblrenewallist.returnRowInTable ("tblPolicyNextActivityList", strPolicyNumber);
			WebDriverWait loadagain = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			loadagain.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));
			loadagain.until (ExpectedConditions.elementToBeClickable (orPolicyRenewals.btnNextActivityApply));
			orPolicyRenewals.btnNextActivityApply.click ();
			loadagain.until (ExpectedConditions.elementToBeClickable (orPolicyRenewals.btnApplyActualActivity));
			orPolicyRenewals.btnApplyActualActivity.click ();

			if (strActivityText.contains ("Renewal"))
			{

				System.out.println ("The Policy has been Renewed Successfully");
				clientsummary.searchIncompleteTrancation (strPolicyNumber, strEnvironmentName);
			}

		}

	}

	// The Following function will select the Maintain Next Activity from Direct Billing Actions Accordion from the Policy Summary's
	// left accordion menu

	public void selectDirectBillingActions (String strEnvironmentName, String strEnvironmentBrand, String strRegionValue)
	{

		PolicyBillingMaintainNextActivity nextactivity = new PolicyBillingMaintainNextActivity (driver);
		NavigationPanel navigate = new NavigationPanel (driver);
		ClientSummary clientsummary = new ClientSummary (driver);
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));

		String strQuotePolicyNumber = orPolicyRenewals.txtPolicyNumber.getText ();
		clientsummary.searchIncompleteTrancation (strQuotePolicyNumber, strEnvironmentName);

		wait.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));

		navigate.expandViewPolicy (strRegionValue);
		navigate.clickDirectBillingForPolicy ();
		wait.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));
		navigate.expandDirectBillingActions ();
		navigate.clickMaintainNextActivity ();

		wait.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));
		nextactivity.applyBillingNextActivitiesForRenewals (strEnvironmentBrand);
	}

	public boolean validateRenewalNonOffers ()
	{

		TableHandler tblrenewallist = new TableHandler (driver);
		Boolean boolRenewalPathCheck = tblrenewallist.checkTableHasRecords ("tblPolicyNextActivityList", "Non-offer of renewal", "All");
		if (boolRenewalPathCheck != true)
		{

			return false;
		}
		return true;

	}

	public void directBillingClickMakeAPayment ()
	{

		NavigationPanel navigate = new NavigationPanel (driver);
		navigate.clickMakeAPayment ();

	}

	public void selectRenewalPaymentTotalBalance ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyRenewals.prgProgress));

		List<WebElement> radiobuttons = orPolicyRenewals.rdoSelectPaymentAmount;
		for (WebElement radiobutton : radiobuttons)
		{
			if (radiobutton.getAttribute ("igmessage").equals ("Rnwl total balance"))
			{
				radiobutton.click ();
			}
			break;

		}
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyRenewals.btnSubmit));
		orPolicyRenewals.btnSubmit.click ();
	}

}
