package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Qasim - This captures the page elements for the EFT List screen.
 * 
 */
public class OR_PolicyEFTList
{

	@CacheLookup
	@FindBy(how = How.ID, using = "reqDetails_RejectionReason")
	public WebElement      ddlReqDetailsRejectionReason;
	 
	@CacheLookup
	@FindBy(how = How.NAME, using = "aPEFTSrchSearchBy")
	public WebElement      ddlAPEFTSrchSearchBy;
	 
	@CacheLookup
	@FindBy(how = How.ID, using = "aPEFTSrchPaidDate")
	public WebElement      txtAPEFTSrchPaidDate;
	 
	@CacheLookup
	@FindBy(how = How.ID, using = "aPEFTSrchSearchByValue")
	public WebElement      txtAPEFTSrchSearchByValue;
	 
	@CacheLookup
	@FindBy(how = How.ID, using = "aPEFTSrchBankAcct")
	public WebElement      ddlAPEFTSrchBankAcct;

}
