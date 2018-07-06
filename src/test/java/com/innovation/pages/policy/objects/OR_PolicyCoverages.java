package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs This captures the page elements for the Policy Preliminary Questions screen.
 * 
 */
public class OR_PolicyCoverages
{
	/**
	 * @param args
	 */

	// Buildings check box
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_UI_1")
	public WebElement	chkBuildings;

	// Buildings limit text box
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_LIMIT1_UI_1")
	public WebElement	txtBuildingsLimit;

	// Buildings excess drop down list
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_DEDUCT_UI_1")
	public WebElement	ddlBuildingsExcess;

	// Contents check box
	// @CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_UI_2")
	public WebElement	chkContents;

	// Contents limit text box
	// @CacheLookup
	@FindBy(how = How.ID, using = "COV_LIMIT1_UI_2")
	public WebElement	txtContentsLimit;

	// Contents excess drop down list
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_DEDUCT_UI_2")
	public WebElement	ddlContentsExcess;

	// Calculate premium button
	// @CacheLookup
	@FindBy(how = How.ID, using = "btnCoverageRecalculate")
	public WebElement	btnCalculatePremium;

	// Transaction premium column
	// Use this value to check if >0.00 etc for synchronisation purposes
	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "colTGROSS")
	public WebElement	tblTransactionPremium;

	// Proceed Next Button
	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igFlowNext")
	public WebElement	btnProceedNext;

	// ****************************************************
	// Auto coverage

	// @CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_UI_1")
	public WebElement	chkComprehensive;

	// @CacheLookup
	@FindBy(how = How.ID, using = "COV_DEDUCT_UI_1")
	public WebElement	ddlComprehensiveExcess;

	// @CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_UI_2")
	public WebElement	chkThirdPartyTheft;

	// @CacheLookup
	@FindBy(how = How.ID, using = "COV_DEDUCT_UI_2")
	public WebElement	ddlThirdPartyTheft;

	// @CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_UI_3")
	public WebElement	chkThirdPartyOnly;

	// @CacheLookup
	@FindBy(how = How.ID, using = "COV_DEDUCT_UI_3")
	public WebElement	txtThirdPartyOnlyExcess;

	// @CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_UI_4")
	public WebElement	chkTowingLabour;

	// @CacheLookup
	@FindBy(how = How.ID, using = "COV_LIMITS_UI_4")
	public WebElement	ddlTowingLabourLimit;

	// @CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgress;

	// @CacheLookup
	@FindBy(how = How.ID, using = "buttonOptionSelect_1")
	public WebElement	btnSelectOptionOne;

	// @CacheLookup
	@FindBy(how = How.ID, using = "buttonOptionSelect_2")
	public WebElement	btnSelectOptionTwo;

	// @CacheLookup
	@FindBy(how = How.XPATH, using = "//label[.='Selected Option']")
	public WebElement	lblPremiumOptionSelected;

	// @CacheLookup
	@FindBy(how = How.XPATH, using = "//label[.='Option 1']")
	public WebElement	lblPremiumOptionOne;

	// @CacheLookup
	@FindBy(how = How.XPATH, using = "//label[.='Option 2']")
	public WebElement	lblPremiumOptionTwo;

	/*
	 * US Region Home Coverage Screen objects identificaiton
	 * 
	 */
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_DISPLAY_1")
	public WebElement	chkDwelling;
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_DISPLAY_2")
	public WebElement	chkPersonalProperty;
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_UI_3")
	public WebElement	chkOridanceOfLaw;
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_UI_4")
	public WebElement	chkFireDepartmentServiceCharge;
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_UI_5")
	public WebElement	chkBackUpOfSewer;
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_UI_6")
	public WebElement	chkDebrisRemoval;
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_LIMIT1_UI_1")
	public WebElement	txtLimtDwelling;
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_LIMIT1_UI_2")
	public WebElement	txtLimtPersonalProperty;
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_LIMIT1_UI_3")
	public WebElement	txtLimtOrdinanceOfLaw;
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_LIMITS_UI_4")
	public WebElement	ddlLimitFireDepartmentSeriveCharge;
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_LIMITS_UI_5")
	public WebElement	ddlLimtBackUpSewer;
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_LIMITS_UI_6")
	public WebElement	ddlLimtDebrisRemoval;
	@CacheLookup
	@FindBy(how = How.ID, using = "COV_INCLUDED_UI_3")
	public WebElement	chkBuildingAccidentalDamage;
}
