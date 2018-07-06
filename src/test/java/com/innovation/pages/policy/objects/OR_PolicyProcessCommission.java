package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Alamq- This captures the page elements for the Process Commision screen.
 * 
 */
public class OR_PolicyProcessCommission
{

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ComProcBankAcct")
	public WebElement	ddlSCComProcBankAcct;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ComProcBranch")
	public WebElement	ddlSCComProcBranch;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_ComProcFrequency")
	public WebElement	ddlSCComProcFrequency;

}
