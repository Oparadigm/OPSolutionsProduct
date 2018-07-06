package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Rizwan - defining the objects for 'MOJ Summary' frame accessible through BO Navigation panel > Bodily injury > MOJ actions 
 *  
 */

public class OR_ClaimMOJSummary
{

	@FindBy(how = How.ID, using = "CLM_SC_035_ClaimPlanGet")
	public WebElement	tblToDoList;

	@FindBy(how = How.ID, using = "CLM_SC_BO_0031_DueDate")
	public WebElement	lblDueDate;

	@FindBy(how = How.ID, using = "CLM_SC_BO_0031_DeadlineDate")
	public WebElement	lblDeadlineDate;

	@FindBy(how = How.ID, using = "CLM_SC_BO_0031_Detail")
	public WebElement	lblDetails;

	@FindBy(how = How.ID, using = "CLM_SC_BO_0032_CompletedList")
	public WebElement	tblCompletedActivities;

	@FindBy(how = How.ID, using = "CLM_SC_BO_HistoryAudits")
	public WebElement	tblAudits;
}
