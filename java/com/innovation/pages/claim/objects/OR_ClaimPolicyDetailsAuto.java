package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Rizwan. This captures the page elements for Claim's Policy Details frame for Auto LOBs.
 *   
 */
public class OR_ClaimPolicyDetailsAuto
{

	// Elements on Policyholder tab

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_PolicyNumber_20a")
	public WebElement		txtPolicyNo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_IncepDate_20a")
	public WebElement		txtInceptionDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_ExpDate_20a")
	public WebElement		txtExirationDate;

	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_009_Title_20a")
	public WebElement		cboTitle;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_Title_20a")
	public WebElement		cboTitleValues;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_FirstName_20a")
	public WebElement		txtFirstName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_Surname_20a")
	public WebElement		txtLastName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_Gender_20a")
	public WebElement		ddlGender;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_DateOfBirth_20a")
	public WebElement		txtDOB;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_009_ClientStatus_20a")
	public List<WebElement>	rdoDeceased;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_DateofDeath_20a")
	public WebElement		txtDateOfDeath;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_PersonOfInterestIndicator_20a")
	public List<WebElement>	rdoPersonOfInterest;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_VulnerablePersonIndicator_20a")
	public List<WebElement>	rdoVulnerablePerson;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_StaffMemberIndicator_20a")
	public List<WebElement>	rdoStaffMember;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_SecurityLevelIndicator_20a")
	public List<WebElement>	rdoVIP;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_ContactMethod_20a")
	public WebElement		ddlContactMethod;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_ContactTime_20a")
	public WebElement		ddlBestContactTime;

	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_009_SelectOccupation_20a")
	public WebElement		cboOccupation;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_SelectOccupation_20a")
	public WebElement		cboOccupationValues;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_VATReg_20a")
	public List<WebElement>	rdoVATRegistered;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_PolicyExcess_20a")
	public WebElement		txtPolicyExcess;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_009_CoverTypeComb_20a")
	public WebElement		ddlCoverType;

}
