package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs This captures the page elements for the Policy Losses screen.
 * 
 */

/*
 * @author Kamran Mahmood - Update to capture elements for Policy losses screen
 */

public class OR_PolicyLosses
{
	/**
	 * @param args
	 */

	// Proceed Next Button
	@CacheLookup
	@FindBy(how = How.ID, using = "flowBtnContinue")
	public WebElement	btnProceedNext;

	@CacheLookup
	@FindBy(how = How.ID, using = "tblPropertyRisks")
	public WebElement	tblPropertyRisk;

	@CacheLookup
	@FindBy(how = How.ID, using = "RiskLossesAddBtn")
	public WebElement	btnAddLoss;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Risk_Losses_Description_ADD")
	public WebElement	rdoLossDescription;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Risk_Losses_Amt_ADD")
	public WebElement	txtLossAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Risk_Losses_Date_ADD")
	public WebElement	dtpLossDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "LossDetailsAddBtn")
	public WebElement	btnAddLossDetails;
}
