package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Kamran This captures the page elements for the Agent Detail Screen.
 *
 */
public class OR_PolicyAgenDetails
{

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_EffectDte")
	public WebElement	dtpEffectiveDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AgtType")
	public WebElement	ddlAgentType;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ProcBranch")
	public WebElement	ddlBranch;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_UseAgtADE")
	public WebElement	ddlAgentADE;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AgedByEffDte")
	public WebElement	ddlCreditDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_RenList")
	public WebElement	ddlRenewalList;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_AutoRen")
	public WebElement	ddlAutoRenewal;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_IndexOver")
	public WebElement	ddlIndexOverride;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CreditTerm")
	public WebElement	ddlCreditTerm;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MatchInd")
	public WebElement	ddlMatchingOrder;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Team")
	public WebElement	ddlTeam;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_SortCode")
	public WebElement	ddlDisplayOrder;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ClientStmt")
	public WebElement	ddlClientStmt;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ADE")
	public WebElement	ddlADE;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Status")
	public WebElement	ddlStatus;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_NoticeTo")
	public WebElement	ddlNoticeTo;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_NoticeFreq")
	public WebElement	ddlNoticeFreq;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Suffix")
	public WebElement	ddlSuffix;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnFinish")
	public WebElement	btnContinue;

}
