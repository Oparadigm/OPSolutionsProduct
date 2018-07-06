package com.innovation.pages.policy.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs This captures the page elements for the Policy Preliminary Questions screen.
 * 
 */
public class OR_PolicyPreliminaryQuestions
{
	/**
	 * @param args
	 */

	// Ever been declared bankrupt?
	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_KnockoutQuestions_SC_GenericKnockOutQuestions_Tailored_T2_RadioGroup_1")
	public List<WebElement>	lstDeclardBankrupt;

	// Have the policy holder and/or any associated applicants ever been refused insurance?
	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_KnockoutQuestions_SC_GenericKnockOutQuestions_Tailored_T2_RadioGroup_2")
	public List<WebElement>	lstRefusedinsurance;

	// Ever had specific terms imposed?
	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_KnockoutQuestions_SC_GenericKnockOutQuestions_Tailored_T2_RadioGroup_3")
	public List<WebElement>	lstSpecificTerms;

	// Any unspent criminal convictions?
	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_KnockoutQuestions_SC_GenericKnockOutQuestions_Tailored_T2_RadioGroup_4")
	public List<WebElement>	lstCriminalconvictions;

	// Is the property your permanent residence and not left unattended for more than 30 days consecutively?
	// @CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_KnockoutQuestions_SC_GenericKnockOutQuestions_Tailored_T2_RadioGroup_5")
	public List<WebElement>	LstPermanentResidence;

	// Proceed Next
	@CacheLookup
	@FindBy(how = How.ID, using = "flowBtnContinue")
	public WebElement		btnProceedNext;
	/*
	 * Auto Objects identification
	 */
	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_KnockoutQuestions_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_1")
	public List<WebElement>	lstDeclaredBankCorrupt;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_KnockoutQuestions_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_2")
	public List<WebElement>	lstRefusedInsurance;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_KnockoutQuestions_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_3")
	public List<WebElement>	lstSpecificTerm;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_KnockoutQuestions_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_4")
	public List<WebElement>	lstCriminalConvictions;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_KnockoutQuestions_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_5")
	public List<WebElement>	lstLicenseSuspended;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_KnockoutQuestions_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_6")
	public List<WebElement>	lstInfluenceAlcohol;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_KnockoutQuestions_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_7")
	public List<WebElement>	lstAccidentLosses;

	/*
	 * US region Home And Auto preliminary Questions
	 */

	// HOME US region questions
	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_AddLOBKnockoutQuestions_001614_SC_GenericKnockOutQuestions_Tailored_T2_RadioGroup_1")
	public List<WebElement>	lstHomeFiveYearRefusedCancelledImposed;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_AddLOBKnockoutQuestions_001614_SC_GenericKnockOutQuestions_Tailored_T2_RadioGroup_2")
	public List<WebElement>	lstHomeFiveYearConvictedCriminalOffences;

	// Auto US region Questions

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_AddLOBKnockoutQuestions_001614_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_1")
	public List<WebElement>	lstAutoSR22Form;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_AddLOBKnockoutQuestions_001614_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_2")
	public List<WebElement>	lstAutoConvictedDUI;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_AddLOBKnockoutQuestions_001614_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_3")
	public List<WebElement>	lstAutoFourLossesInFiveYears;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_AddLOBKnockoutQuestions_001614_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_4")
	public List<WebElement>	lstAutoInsuredPolicyCanelled;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_AddLOBKnockoutQuestions_001614_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_5")
	public List<WebElement>	lstAutoEverIncreasedDeductible;

	@CacheLookup
	@FindBy(how = How.NAME, using = "POL_FR_AddLOBKnockoutQuestions_001614_SC_GenericKnockOutQuestions_Tailored_T1_RadioGroup_6")
	public List<WebElement>	lstAutoInvlovedInRacing;

}
