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
public class OR_PolicyCancellation
{

	@CacheLookup
	@FindBy(how = How.ID, using = "CancellationDate")
	public WebElement		dtpCancellationDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CnclReason")
	public WebElement		ddlCnclReason;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PolicyCancelation_Question")
	public List<WebElement>	rdoPolicyCancelationPayment;

	@FindBy(how = How.ID, using = "SC_UserControl_QuickSearch")
	public WebElement		txtQuickSearch;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnProcess")
	public WebElement		btnProcess;

	@FindBy(how = How.ID, using = "userControl_quickSearchIcon")
	public WebElement		imgQuickSearchIcon;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnCompCancel")
	public WebElement		btnCommitCancel;

	@CacheLookup
	@FindBy(how = How.ID, using = "igErrorPanel")
	public WebElement		errPanel;

	@CacheLookup
	@FindBy(how = How.ID, using = "igWarningCount")
	public WebElement		wngwarningCount;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='policyTitle']")
	public WebElement		ttlPolicyTitle;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement		prgProgress;

}
