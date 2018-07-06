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
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimClaimSummary;
import com.innovation.pages.common.objects.OR_ActionsPanel;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.common.pages.NavigationPanel;

/**
 * @author alamq This class will store all the locators and methods on New Claim Summary Screen
 */

public class ClaimClaimSummary
{
	WebDriver				driver;
	StopWatch				stopwatch			= new StopWatch ();
	OR_ClaimClaimSummary	orClaimClaimSummary	= null;
	OR_ActionsPanel			orActionsPanel		= null;
	OR_ControlPanel			orControlPanel		= null;

	public ClaimClaimSummary (WebDriver driver)
	{
		this.driver = driver;
		orClaimClaimSummary = PageFactory.initElements (driver, OR_ClaimClaimSummary.class);
		orActionsPanel = PageFactory.initElements (driver, OR_ActionsPanel.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);
	}

	// Select "Claim Status" drop down

	public void selectClaimStatus (String strClaimStatus)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimSummary.ddlClaimStatus));
		orClaimClaimSummary.ddlClaimStatus.click ();
		Select oClaimStatus = new Select (orClaimClaimSummary.ddlClaimStatus);
		oClaimStatus.selectByVisibleText (strClaimStatus);

	}

	// Select "OverrideOwner" drop down

	public void selectOverrideOwner (String strOverrideOwner)
	{

		if (strOverrideOwner.equalsIgnoreCase ("Yes") || strOverrideOwner.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimSummary.rdoOverrideOwner;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strOverrideOwner.equalsIgnoreCase ("No") || strOverrideOwner.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimSummary.rdoOverrideOwner;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}

			}
		}

	}

	// Select "New owner" drop down

	public void selectNewOwner (String strNewOwner)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimSummary.ddlNewOwner));
		orClaimClaimSummary.ddlNewOwner.click ();
		Select oClaimStatus = new Select (orClaimClaimSummary.ddlClaimStatus);
		oClaimStatus.selectByVisibleText (strNewOwner);

	}

	// Select "Coverage issue" drop down

	public void selectCoverageIssue (String strCoverageIssue)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimSummary.ddlCoverageIssue));
		orClaimClaimSummary.ddlClaimStatus.click ();
		Select oCoverageIssue = new Select (orClaimClaimSummary.ddlCoverageIssue);
		oCoverageIssue.selectByVisibleText (strCoverageIssue);

	}

	// Radio button "Email Claim Summary" is selected as per parameter
	// strEmailClaimSummary

	public void selectEmailClaimSummary (String strEmailClaimSummary)
	{

		if (strEmailClaimSummary.equalsIgnoreCase ("Yes") || strEmailClaimSummary.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimSummary.rdoEmailClaimSummary;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("yes"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strEmailClaimSummary.equalsIgnoreCase ("No") || strEmailClaimSummary.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimSummary.rdoEmailClaimSummary;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("no"))
				{
					radiobutton.click ();
					break;
				}

			}
		}

	}

	// Select "Email" drop down

	public void selectEmail (String strEmailSummary)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimSummary.ddlEmail));
		orClaimClaimSummary.ddlEmail.click ();
		Select oEmailSummary = new Select (orClaimClaimSummary.ddlEmail);
		oEmailSummary.selectByVisibleText (strEmailSummary);

	}

	// Radio button "NCD Impacted" is selected as per parameter strNCDImpacted

	public void selectNcdImpacted (String strNCDImpacted)
	{

		if (strNCDImpacted.equalsIgnoreCase ("Yes") || strNCDImpacted.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimSummary.rdoNcdImpacted;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strNCDImpacted.equalsIgnoreCase ("No") || strNCDImpacted.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimSummary.rdoNcdImpacted;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}

			}
		}

	}

	// Radio button "Excess confirmed to Policyholder" is selected as per
	// parameter
	// strExcessConfirmed.

	public void selectExcessConfirmed (String strExcessConfirmed)
	{

		if (strExcessConfirmed.equalsIgnoreCase ("Yes") || strExcessConfirmed.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = orClaimClaimSummary.rdoExcessConfirmed;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("1"))
				{
					radiobutton.click ();
					break;
				}
			}
		}
		else if ((strExcessConfirmed.equalsIgnoreCase ("No") || strExcessConfirmed.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = orClaimClaimSummary.rdoExcessConfirmed;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("0"))
				{
					radiobutton.click ();
					break;
				}

			}
		}

	}

	// Click on Reserve tab

	public void selectReserve ()
	{

		orClaimClaimSummary.pnlReserves.click ();
		// we will implement further via DB in next feature

	}

	// Click on Other tab

	public void selectOther ()
	{

		orClaimClaimSummary.pnlOther.click ();
		// we will implement further via DB in next feature

	}

	public String getClaimNumber ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimSummary.numClaim));
		String strClaimNumber = orClaimClaimSummary.numClaim.getText ();
		String strfetchNumber = StringUtils.substringAfterLast (strClaimNumber, "> ");
		return strfetchNumber;
	}

	// Click on "FNOL Flow Completed"

	public void clickFlowCompleted ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimSummary.btnFlowCompleted));
		orClaimClaimSummary.btnFlowCompleted.click ();

		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

	// Methods for the Claim summary Back-office frame.

	// Check if coverage issues exist on BO Claim summary frame, if they do then
	// navigate onto Validation frame to resolve them
	public void checkAndResolveCoverageIssues ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOf (orClaimClaimSummary.lblCoverageIssues));

		if (orClaimClaimSummary.lblCoverageIssues.getText ().contains ("Coverage issue(s) unresolved on the claim."))
		{
			NavigationPanel navigationpanel = new NavigationPanel (driver);
			navigationpanel.expandBOFunctionsSpan ();
			navigationpanel.clickValidation ();

			ControlPanel controlpanel = new ControlPanel (driver);
			controlpanel.clickEditFrame ();

			ClaimValidation claimvalidation = new ClaimValidation (driver);
			// This resolves all validation exceptions on the claim
			claimvalidation.resolveValidationExceptions ();
		}
	}

	// Check if SIU activity exists on BO Claim summary frame, if it does then
	// navigate into SIU menu to close SIU feature
	public void checkAndCloseSIUFeature (String strSIUReferralOverrideReason, String strSIUClosureReason)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOf (orClaimClaimSummary.lblSIUSummary));

		if (orClaimClaimSummary.lblSIUSummary.getText ().contains ("SIU activity exists."))
		{
			NavigationPanel navigationpanel = new NavigationPanel (driver);
			navigationpanel.expandBOSIUSpan ();

			// Click on Manage SIU referral/update score link under SIU menu
			navigationpanel.clickManageSIUReferral ();

			ClaimManageSIUReferral claimmanagesiureferral = new ClaimManageSIUReferral (driver);
			// This function will remove all SIU referrals on the claim
			claimmanagesiureferral.removeSIUReferrals (strSIUReferralOverrideReason);

			// Click on SIU Spotlight link under SIU menu
			navigationpanel.clickSIUSpotlight ();

			ClaimSIUSpotlight claimsiuspotlight = new ClaimSIUSpotlight (driver);
			// This function will close SIU feature on the claim
			claimsiuspotlight.closeSIUFeature (strSIUClosureReason);

			// Once SIU feature is closed, this navigates user onto Claim
			// summary frame
			orActionsPanel.lnkClaimSummary.click ();

		}

	}

	// This selects Bodily injury feature row from Features table
	public void selectBodilyInjuryFeature ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimSummary.tblFeatureList));

		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.returnRowInTable ("tblFeatureList", "Bodily injury");

	}

	// This selects Bodily injury feature row from Features table
	public void selectFeature (String strFeature)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimSummary.tblFeatureList));

		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.returnRowInTable ("tblFeatureList", strFeature);

	}

	// This selects Bodily injury feature row from Features table
	public void openFeature ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimClaimSummary.btnOpenFeature));
		orClaimClaimSummary.btnOpenFeature.click ();

		wait.until (ExpectedConditions.invisibilityOf (orActionsPanel.barProgress));

	}

}
