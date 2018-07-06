package com.innovation.pages.claim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.CalenderDate;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimMOJSummary;
import com.innovation.soap.customexceptions.TestCaseValidationFailed;

/**
 * @author Rizwan - this class stores all the locators and methods on 'MOJ summary' frame accessible through BO Navigation panel >
 *         Bodily injury > MOJ actions
 * 
 */

public class ClaimMOJSummary
{
	WebDriver			driver;
	boolean				blnRecordStatus;
	String				strTaskDueDate;
	String				strTaskDeadlineDate;
	String				strTaskDetails;
	OR_ClaimMOJSummary	orClaimMOJSummary	= null;

	public ClaimMOJSummary (WebDriver driver)
	{
		this.driver = driver;
		orClaimMOJSummary = PageFactory.initElements (driver, OR_ClaimMOJSummary.class);
	}

	public void validateTaskGeneration (String strTaskDescription) throws TestCaseValidationFailed
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJSummary.tblToDoList));

		TableHandler tablehandler = new TableHandler (driver);
		blnRecordStatus = tablehandler.checkTableHasRecords ("CLM_SC_035_ClaimPlanGet", strTaskDescription, "All");

		if (blnRecordStatus)
		{
			System.out.println ("Task generated: " + strTaskDescription);
		}
		else
		{
			throw new TestCaseValidationFailed ();
		}

	}

	public void validateTaskCancelled (String strTaskDescription) throws TestCaseValidationFailed
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJSummary.tblToDoList));

		TableHandler tablehandler = new TableHandler (driver);
		blnRecordStatus = tablehandler.checkTableHasRecords ("CLM_SC_035_ClaimPlanGet", strTaskDescription, "All");

		if (blnRecordStatus)
		{
			throw new TestCaseValidationFailed ();
		}
		else
		{
			System.out.println ("Task cancelled: " + strTaskDescription);
		}

	}

	public void selectToDoTask (String strTaskDescription)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJSummary.tblToDoList));

		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.returnRowInTable ("CLM_SC_035_ClaimPlanGet", strTaskDescription);

	}

	public void validateTaskDueDate (String strEnvironmentName, String strCompany, String strRegionValue, String strCurrentDate, int intDueDateDays)
			throws TestCaseValidationFailed, Exception
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJSummary.lblDueDate));

		strTaskDueDate = orClaimMOJSummary.lblDueDate.getText ();

		if (strTaskDueDate
				.equalsIgnoreCase (CalenderDate.returnNextDateBasedOnWorkDays (strEnvironmentName, strCompany, strRegionValue, strCurrentDate, intDueDateDays)))
		{
			System.out.println ("Due date for task is: " + strTaskDueDate);
		}
		else
		{
			throw new TestCaseValidationFailed ();
		}

	}

	public String returnTaskDueDate ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJSummary.lblDueDate));

		strTaskDueDate = orClaimMOJSummary.lblDueDate.getText ();

		return strTaskDueDate;

	}

	public void validateTaskDeadlineDate (String strEnvironmentName, String strCompany, String strRegionValue, String strTaskDueDate, int intDeadlineDateDays)
			throws TestCaseValidationFailed, Exception
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJSummary.lblDeadlineDate));

		strTaskDeadlineDate = orClaimMOJSummary.lblDeadlineDate.getText ();

		if (strTaskDeadlineDate.equalsIgnoreCase (
				CalenderDate.returnNextDateBasedOnWorkDays (strEnvironmentName, strCompany, strRegionValue, strTaskDueDate, intDeadlineDateDays)))
		{
			System.out.println ("Deadline date for task is: " + strTaskDeadlineDate);
		}
		else
		{
			throw new TestCaseValidationFailed ();
		}
	}

	public void validateTaskDetails (String strTaskDetails) throws TestCaseValidationFailed
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJSummary.lblDetails));

		String strTaskDetailsValue = orClaimMOJSummary.lblDetails.getText ();

		if (strTaskDetailsValue.equalsIgnoreCase (strTaskDetails))
		{
			System.out.println ("Task details are: " + strTaskDetails);
		}
		else
		{
			throw new TestCaseValidationFailed ();
		}

	}

	public void validateTaskCompleted (String strTaskDescription) throws TestCaseValidationFailed
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJSummary.tblCompletedActivities));

		TableHandler tablehandler = new TableHandler (driver);
		blnRecordStatus = tablehandler.checkTableHasRecords ("CLM_SC_BO_0032_CompletedList", strTaskDescription, "All");

		if (blnRecordStatus)
		{
			System.out.println ("Task completed: " + strTaskDescription);
		}
		else
		{
			throw new TestCaseValidationFailed ();
		}

	}

	public void validateAuditGeneration (String strAuditDetails) throws TestCaseValidationFailed
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJSummary.tblAudits));

		TableHandler tablehandler = new TableHandler (driver);
		blnRecordStatus = tablehandler.checkTableHasRecords ("CLM_SC_BO_HistoryAudits", strAuditDetails, "All");

		if (blnRecordStatus)
		{
			System.out.println ("Audit generated: " + strAuditDetails);
		}
		else
		{
			throw new TestCaseValidationFailed ();
		}

	}
}
