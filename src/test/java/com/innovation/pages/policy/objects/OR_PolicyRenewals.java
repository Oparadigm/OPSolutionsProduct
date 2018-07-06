package com.innovation.pages.policy.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Tahir- This captures the page elements for the Auto Policy Cancellation screen.
 * 
 */
public class OR_PolicyRenewals
{

	@FindBy(how = How.ID, using = "tblPolicyNextActivityList")
	public WebElement	tblNextActivityList;

	// the following xpath will direct the script to the renewal column

	@FindBy(how = How.XPATH, using = "//*[@id='tblPolicyNextActivityList']/tbody/tr[3]/td[4]")
	public WebElement	tblActivityText;

	// The following object will check the status if there is any exceptions encountered
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNAApply_Status")
	public WebElement	lblActivityStatus;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_NextActivityPath")
	public WebElement	ddlSCPNASearchNextActivityPath;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnNextActivityRefresh")
	public WebElement	btnRefresh;

	// The following button is related to Activity details list
	@CacheLookup
	@FindBy(how = How.ID, using = "btnNextActivityApply")
	public WebElement	btnNextActivityApply;

	// The following button is related to the apply activity section
	@CacheLookup
	@FindBy(how = How.ID, using = "btnNextActivityAppApply")
	public WebElement	btnApplyActualActivity;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_Product")
	public WebElement	ddlSCPNASearchProduct;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnNextActivitySearch")
	public WebElement	btnSearchRenewalActivities;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_Policy")
	public WebElement	txtSCPNASearchPolicy;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_ProcType")
	public WebElement	ddlSCPNASearchProcType;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_Status")
	public WebElement	ddlSCPNASearchStatus;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_Path")
	public WebElement	ddlSCPNASearchPath;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_Activity")
	public WebElement	ddlSCPNASearchActivity;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_State")
	public WebElement	ddlSCPNASearchState;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_ProcBranch")
	public WebElement	ddlSCPNASearchProcBranch;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_Agent")
	public WebElement	txtSCPNASearchAgent;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_AgtSuffix")
	public WebElement	ddlSCPNASearchAgtSuffix;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_ActivityDateFrom")
	public WebElement	txtSCPNASearchActivityDateFrom;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_ActivityDateTo")
	public WebElement	txtSCPNASearchActivityDateTo;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_RefDateFrom")
	public WebElement	txtSCPNASearchRefDateFrom;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNAApply_PolNum")
	public WebElement	txtPolicyNumber;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_MakePaymentAmountFields_Amount_RTAD_222")
	public List<WebElement>	rdoSelectPaymentAmount;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PNASearch_RefDateTo")
	public WebElement	txtSCPNASearchRefDateTo;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgress;
	
	@FindBy(how = How.XPATH, using = "//button[.='Submit']")
	public WebElement	btnSubmit;

}
