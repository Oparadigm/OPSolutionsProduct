package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OR_PolicyEndorsements
{

	// The following object will identify the Bread crumb of an Endorsements Screen
	// in Straight New Business and
	// Buy Quote Process
	// Frame

	// The following object is the Bread Crumb name of the Endorsements Screen

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"igPHCentre\"]/div[5]/div[2]/label")
	public WebElement	txtEndorsementsBreadCrumb;

	// The following object is the Add Manually Button of the Endorsements Screen
	@CacheLookup
	@FindBy(how = How.ID, using = "btnEndorsementManualAdd")
	public WebElement	btnManuallyAdd;

	// The following object is the Remove Button of the Endorsements Screen
	@CacheLookup
	@FindBy(how = How.ID, using = "btnEndorsementRemove")
	public WebElement	btnRemoveEndorsements;

	// The following object is the Edit Button of the Endorsements Screen
	@CacheLookup
	@FindBy(how = How.ID, using = "btnEndorsementEdit")
	public WebElement	btnEditEndorsements;

	// The following object is the Suppress Button of the Endorsements Screen
	@CacheLookup
	@FindBy(how = How.ID, using = "btnEndorsementSuppress")
	public WebElement	btnSuppressEndorsements;

	// The following object is the Table of the Endorsements List
	@CacheLookup
	@FindBy(how = How.ID, using = "EndoListTbl")
	public WebElement	tblEndorsements;

	@CacheLookup
	@FindBy(how = How.ID, using = "inputContainer")
	public WebElement	tblEndorsementVariableData;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnEndorsementVariableUpdate")
	public WebElement	btnVarDataEndorsementUpdate;

	// the following object is the table which have available Endorsements listed

	@CacheLookup
	@FindBy(how = How.ID, using = "EndoAvailListTbl")
	public WebElement	tblAvailableEndorsements;

	// The following object will locate the select button in endorsements
	// availability list
	@CacheLookup
	@FindBy(how = How.ID, using = "btnEndorsementAvailSelect")
	public WebElement	btnSelectAvailableEndorsement;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgressbar;

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "igFlowNext")
	public WebElement	btnProceedNext;

}
