package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Alamq- This captures the page elements for the Check Run List screen.
 * 
 */
public class OR_PolicyCheckRunList
{

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CheckRunList_Date")
	public WebElement      txtSCCheckRunListDate;
	 
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CheckRunList_BankAcct")
	public WebElement      ddlSCCheckRunListBankAcct;
	 
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CheckRunList_User")
	public WebElement      ddlSCCheckRunListUser;
	 
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CheckRunList_CheckNumber")
	public WebElement      txtSCCheckRunListCheckNumber;
	 

}
