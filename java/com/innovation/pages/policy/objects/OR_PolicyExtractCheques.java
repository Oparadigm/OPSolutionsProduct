package com.innovation.pages.policy.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Alamq- This captures the page elements for the Extract Cheques screen.
 * 
 */
public class OR_PolicyExtractCheques
{

	@CacheLookup
	@FindBy(how = How.ID, using = "aPChkPrntBnkAcct")
	public WebElement		ddlAPChkPrntBnkAcct;

	@CacheLookup
	@FindBy(how = How.ID, using = "aPChkPrntStBrnch")
	public WebElement		ddlAPChkPrntStBrnch;

	@CacheLookup
	@FindBy(how = How.NAME, using = "aPChkPrntPrBranch")
	public WebElement		ddlAPChkPrntPrBranch;

	@CacheLookup
	@FindBy(how = How.ID, using = "aPChkPrntPaymntType")
	public WebElement		ddlAPChkPrntPaymntType;

	@CacheLookup
	@FindBy(how = How.ID, using = "aPChkPrntPrntAllUpTo")
	public WebElement		txtAPChkPrntPrntAllUpTo;

	@CacheLookup
	@FindBy(how = How.ID, using = "aPChkPrnPrManualOnlyYes")
	public List<WebElement>	rdoAPChkPrnPrManualOnlyYes;

	@CacheLookup
	@FindBy(how = How.ID, using = "aPChkPrnPrManualOnlyNo")
	public List<WebElement>	rdoAPChkPrnPrManualOnlyNo;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnAPChkPrntProcess")
	public WebElement	btnProcess;
	
}
