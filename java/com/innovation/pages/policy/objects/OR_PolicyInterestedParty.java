package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OR_PolicyInterestedParty
{

	// The following object will identify the Breadcrumb of an Interested Party
	// Frame
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Interested party")
	public WebElement	txtIntestedPartyBreadCrumb;

	// The following table will locate the table where are the risks to be attached
	// with the interested parties will be displayed
	@CacheLookup
	@FindBy(how = How.ID, using = "tblItemInterestedPartyList")
	public WebElement	tblInterestedParty;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_IntParty_UseExisting")
	public WebElement	ddlExistingInterestedParty;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"tblinterestedParty\"]/tbody/tr[3]/td[1]")
	public WebElement	tblExistingInterestedParty;

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "iginputbutton")
	public WebElement	btnSearchParty;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"SearchCriteria_RefNumDiv\"]/table/tbody/tr[2]/td/div[1]/button")
	public WebElement	btnSearchPartylist;

	@CacheLookup
	@FindBy(how = How.ID, using = "expDivInterestedParty.Details")
	public WebElement	secPartyDetails;

	@CacheLookup
	@FindBy(how = How.ID, using = "InterestedPartyType")
	public WebElement	ddlPartyType;

	@CacheLookup
	@FindBy(how = How.ID, using = "InterestedPartyPosition")
	public WebElement	ddlPartyPosition;

	@CacheLookup
	@FindBy(how = How.ID, using = "InterestedPartyRefNum")
	public WebElement	txtPartyReference;

	@CacheLookup
	@FindBy(how = How.ID, using = "InterestedPartyPrint")
	public WebElement	ddlPartyPrintInd;

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "iginputradio")
	public WebElement	rdoOwnershipInd;

	@CacheLookup
	@FindBy(how = How.ID, using = "InterestedPartyClientAdd")
	public WebElement	btnAddInterestedParty;

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igFlowNext")
	public WebElement	btnProceedNext;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgressBar;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnEditIntParty")
	public WebElement	btnEditInterestedParty;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnRemoveIntParty")
	public WebElement	btnRemoveInterestedParty;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnSelectClient")
	public WebElement	btnSelectInterestedParty;

}
