/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.SelectionHelper;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicyPreliminaryQuestions;
import com.innovation.pages.policy.objects.OR_PolicyStartDetails;

/**
 * @author lushs - Create the page details for the Preliminary Questions.
 */
public class PolicyPreliminaryQuestions
{

	WebDriver						driver;

	OR_PolicyPreliminaryQuestions	orPreliminaryQuestions	= null;
	OR_PolicyStartDetails			orStartDetails			= null;
	SelectionHelper					selectionHelper			= new SelectionHelper ();

	public PolicyPreliminaryQuestions (WebDriver driver)
	{
		this.driver = driver;
		orPreliminaryQuestions = PageFactory.initElements (driver, OR_PolicyPreliminaryQuestions.class);
		orStartDetails = PageFactory.initElements (driver, OR_PolicyStartDetails.class);
	}

	public void selectHomeKnockOutQuestionsDeclaredBankCorrupt ()
	{
		/*
		 * We check to see if the page is visible if not we click next again on the wizard.
		 * 
		 *
		 */

		// Uninterruptibles.sleepUninterruptibly (10, TimeUnit.SECONDS);

		boolean blnIsPresent = orPreliminaryQuestions.lstDeclardBankrupt.size () > 0;

		if (blnIsPresent == true)

		{
			System.out.println ("The Policy start Details Proceed button does not need to be clicked again");
		}
		else
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orStartDetails.btnProceed));
			// sometimes we need to re-click on the navigation button
			orStartDetails.btnProceed.click ();
		}

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstDeclardBankrupt));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstDeclardBankrupt, "No", false, false, "Unknown");

	}

	public void selectHomeKnockOutQuestionsRefusedInsurance ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstRefusedinsurance));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstRefusedinsurance, "No", false, false, "Unknown");

	}

	public void selectHomeKnockOutQuestionsSpecificTerms ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstSpecificTerms));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstSpecificTerms, "No", false, false, "Unknown");

	}

	public void selectHomeKnockOutQuestionsCriminalConvictions ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstCriminalconvictions));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstCriminalconvictions, "No", false, false, "Unknown");

	}

	public void selectHomeKnockOutQuestionsPermanentResidence ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.LstPermanentResidence));
		SelectionHelper.selectRadio (orPreliminaryQuestions.LstPermanentResidence, "No", false, false, "Unknown");

	}

	public void clickProceedButton ()
	{
		ControlPanel control = new ControlPanel (driver);

		control.clickNext ();
	}

	/*
	 * @author Kamran Mahmood - Following methods will handle page details of preliminary questions for auto
	 */

	public void selectAutoKnockOutQuestionsDeclaredBankCorrupt ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstDeclaredBankCorrupt));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstDeclaredBankCorrupt, "No", false, false, "Unknown");

	}

	public void selectAutoKnockOutQuestionsRefusedInsurance ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstRefusedInsurance));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstRefusedInsurance, "No", false, false, "Unknown");

	}

	public void selectAutoKnockOutQuestionsSpecificTermImposed ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstSpecificTerm));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstSpecificTerm, "No", false, false, "Unknown");

	}

	public void selectAutoKnockOutQuestionsCriminalConvictions ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstCriminalConvictions));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstCriminalConvictions, "No", false, false, "Unknown");

	}

	public void selectAutoKnockOutQuestionsLicenseSuspended ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstLicenseSuspended));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstLicenseSuspended, "No", false, false, "Unknown");

	}

	public void selectAutoKnockOutQuestionsInfluenceOfAlchohal ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstInfluenceAlcohol));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstInfluenceAlcohol, "No", false, false, "Unknown");

	}

	public void selectAutoKnockOutQuestionsAccidentLosses ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstAccidentLosses));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstAccidentLosses, "No", false, false, "Unknown");

	}

	/*
	 * US Region Auto and HOME Preliminary Questions
	 */

	// Auto Questions US Region

	public void selectUSAutoSR22Form ()
	{
		boolean blnIsPresent = orPreliminaryQuestions.lstAutoSR22Form.size () > 0;

		if (blnIsPresent == true)

		{
			System.out.println ("The Policy start Details Proceed button does not need to be clicked again");
		}
		else
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orStartDetails.btnProceed));
			// sometimes we need to re-click on the navigation button
			orStartDetails.btnProceed.click ();
		}
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstAutoSR22Form));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstAutoSR22Form, "No", false, false, "Unknown");

	}

	public void selectUSAutoConvictedDUI ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstAutoConvictedDUI));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstAutoConvictedDUI, "No", false, false, "Unknown");

	}

	public void selectUSAutoLossesFiveYears ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstAutoFourLossesInFiveYears));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstAutoFourLossesInFiveYears, "No", false, false, "Unknown");
	}

	public void selectUSAutoPolicyCancelled ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstAutoInsuredPolicyCanelled));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstAutoInsuredPolicyCanelled, "No", false, false, "Unknown");
	}

	public void selectUSAutoIncreaseDeductible ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstAutoEverIncreasedDeductible));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstAutoEverIncreasedDeductible, "No", false, false, "Unknown");
	}

	public void selectUSAutoInvolvedInRacing ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstAutoInvlovedInRacing));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstAutoInvlovedInRacing, "No", false, false, "Unknown");
	}

	// Home Question US Region

	public void selectUSHomeFiveYearRefusedCancelledImposed ()
	{
		boolean blnIsPresent = orPreliminaryQuestions.lstHomeFiveYearRefusedCancelledImposed.size () > 0;

		if (blnIsPresent == true)

		{
			System.out.println ("The Policy start Details Proceed button does not need to be clicked again");
		}
		else
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orStartDetails.btnProceed));
			// sometimes we need to re-click on the navigation button
			orStartDetails.btnProceed.click ();
		}

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstHomeFiveYearRefusedCancelledImposed));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstHomeFiveYearRefusedCancelledImposed, "No", false, false, "Unknown");

	}

	public void selectUSHomeFiveYearConvictedCriminalOffences ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPreliminaryQuestions.lstHomeFiveYearConvictedCriminalOffences));
		SelectionHelper.selectRadio (orPreliminaryQuestions.lstHomeFiveYearConvictedCriminalOffences, "No", false, false, "Unknown");

	}

	public void selectHomePreliminaryQuestions (String strRegion)

	{
		PolicyPreliminaryQuestions policyPreliminaryQuestions = new PolicyPreliminaryQuestions (driver);

		if (strRegion.equals ("UK"))
		{
			// Preliminary Questions
			// Ever been declared bankrupt

			policyPreliminaryQuestions.selectHomeKnockOutQuestionsDeclaredBankCorrupt ();
			// Ever been refused insurance
			policyPreliminaryQuestions.selectHomeKnockOutQuestionsRefusedInsurance ();
			// Ever had specific terms imposed
			policyPreliminaryQuestions.selectHomeKnockOutQuestionsSpecificTerms ();
			// Any unspent criminal convictions
			policyPreliminaryQuestions.selectHomeKnockOutQuestionsCriminalConvictions ();
			// Property not left unattended for the 30 days consecutively
			policyPreliminaryQuestions.selectHomeKnockOutQuestionsPermanentResidence ();
		}
		else if (strRegion.equals ("USA"))
		{
			policyPreliminaryQuestions.selectUSHomeFiveYearRefusedCancelledImposed ();
			policyPreliminaryQuestions.selectUSHomeFiveYearConvictedCriminalOffences ();

		}

	}

	public void selectAutoPreliminaryQuestions (String strRegion)

	{
		PolicyPreliminaryQuestions policyPreliminaryQuestions = new PolicyPreliminaryQuestions (driver);
		if (strRegion.equals ("UK"))
		{
			// Bank Corrupt
			policyPreliminaryQuestions.selectAutoKnockOutQuestionsDeclaredBankCorrupt ();
			policyPreliminaryQuestions.selectAutoKnockOutQuestionsAccidentLosses ();
			// Criminal Convictions
			policyPreliminaryQuestions.selectAutoKnockOutQuestionsCriminalConvictions ();
			// Influence of Alcohol
			policyPreliminaryQuestions.selectAutoKnockOutQuestionsInfluenceOfAlchohal ();
			// License Suspension
			policyPreliminaryQuestions.selectAutoKnockOutQuestionsLicenseSuspended ();
			// Refused Insurance
			policyPreliminaryQuestions.selectAutoKnockOutQuestionsRefusedInsurance ();
			// Specific Term Imposed
			policyPreliminaryQuestions.selectAutoKnockOutQuestionsSpecificTermImposed ();
		}
		else if (strRegion.equals ("USA"))
		{
			policyPreliminaryQuestions.selectUSAutoSR22Form ();
			policyPreliminaryQuestions.selectUSAutoConvictedDUI ();
			policyPreliminaryQuestions.selectUSAutoLossesFiveYears ();
			policyPreliminaryQuestions.selectUSAutoPolicyCancelled ();
			policyPreliminaryQuestions.selectUSAutoIncreaseDeductible ();
			policyPreliminaryQuestions.selectUSAutoInvolvedInRacing ();
		}
	}

}
