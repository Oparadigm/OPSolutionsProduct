package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.TableHandler;
import com.innovation.pages.policy.objects.OR_PolicyEndorsements;

/*
 * @Author Tahir Akbar This class contains method to validate and add Endorsements in the Straight New Business or 
 * Buy Quote Journey
 */

public class PolicyEndorsements

{

	WebDriver				driver;
	OR_PolicyEndorsements	orPolicyEndorsements	= null;

	public PolicyEndorsements (WebDriver driver)
	{
		this.driver = driver;
		orPolicyEndorsements = PageFactory.initElements (driver, OR_PolicyEndorsements.class);

	}

	// The following code will validate the Policy Endorsements Frame in the flow

	public void validateScreen ()

	{

		String strBreadCrumbName = orPolicyEndorsements.txtEndorsementsBreadCrumb.getText ();

		// The above string will have the Policy Endorsements bread Crumb name in it,
		// // that we can do before running any scenario on the frame itself, we are
		// just validating the name for the time being
		// and we will cater other important functional points in it afterwards

		if (strBreadCrumbName.contains (" Endorsements"))
		{
			System.out.println ("This is Endorsements Frame");
		}
	}

	// // The Following function will validate the Risk Row if exists in the
	// Interested Party Section, then it checks what is the status of the
	// endorsement and
	// click on the one which is incomplete, if it doesn't find any row it will
	// click on ManuallyAdd button

	public void selectEndorsementsRow ()

	{

		TableHandler SelectEndorsementsRow = new TableHandler (driver);
		boolean boolData = SelectEndorsementsRow.verifyTableHasData ("EndoListTbl");

		if (boolData == true)
		{

			SelectEndorsementsRow.returnRowInTable ("EndoListTbl", "Incomplete");

			if (orPolicyEndorsements.btnEditEndorsements.isEnabled ())
			{

				orPolicyEndorsements.btnEditEndorsements.click ();

				SelectEndorsementsRow.addEndVariableData ("inputContainer");

				WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

				wait.until (ExpectedConditions.invisibilityOf (orPolicyEndorsements.prgProgressbar));
				orPolicyEndorsements.btnVarDataEndorsementUpdate.click ();
			}
		}
		else
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

			wait.until (ExpectedConditions.elementToBeClickable (orPolicyEndorsements.btnManuallyAdd));
			orPolicyEndorsements.btnManuallyAdd.click ();

			boolean boolDataExists = SelectEndorsementsRow.verifyTableHasData ("EndoAvailListTbl");

			if (boolDataExists == true)
			{
				SelectEndorsementsRow.returnRowInTable ("EndoAvailListTbl", "Policy");
				orPolicyEndorsements.btnSelectAvailableEndorsement.click ();
				SelectEndorsementsRow.returnRowInTable ("EndoListTbl", "Incomplete");
				orPolicyEndorsements.btnEditEndorsements.click ();

				// The following function will add the variable data on Endorsement Frame

				SelectEndorsementsRow.addEndVariableData ("inputContainer");
				WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
				load.until (ExpectedConditions.invisibilityOf (orPolicyEndorsements.prgProgressbar));
				orPolicyEndorsements.btnVarDataEndorsementUpdate.click ();
			}
		}

	}

	public void proceedContinue ()

	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.invisibilityOf (orPolicyEndorsements.prgProgressbar));

		orPolicyEndorsements.btnProceedNext.click ();
	}

}
