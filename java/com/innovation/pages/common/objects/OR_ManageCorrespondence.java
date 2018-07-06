package com.innovation.pages.common.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Alamq. This captures the page elements for Correspondence Out frame.
 *   
 */
public class OR_ManageCorrespondence
{

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Correspondence_Date_From")
	public WebElement		txtSCCorrespondenceDateFrom;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_Correspondence_Date_To")
	public WebElement		txtSCCorrespondenceDateTo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0161_DocumentPart")
	public WebElement		fldDocumentPart;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0161_UploadNewDocumentName")
	public WebElement		txtDocumentName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0161_UploadDocumentType")
	public WebElement		ddlDocumentType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0161_UploadDocumentSubType")
	public WebElement		ddlDocumentSubType;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0161_UploadNewDocumentDescription")
	public WebElement		txtDocumentDescription;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0161_AttachTo_30b")
	public List<WebElement>	rdoAttachTo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0161_UploadParty")
	public WebElement		ddlParty;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO_0161_Feature_30b")
	public WebElement		ddlFeature;

	@FindBy(how = How.XPATH, using = "//*[@id='CLM_SC_0155_CorrespondenceOut']")
	public  WebElement		tblDocumentList;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='CLM_SC_0155_CorrespondenceOut']/tbody/tr[3]/td[2]")
	public WebElement		tblDocumentColumn;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"CorrespondenceOutActionsCreated\"]/div/input[1]")
	public WebElement		btnView;

	@CacheLookup
	@FindBy(how = How.ID, using = "RePrint")
	public WebElement		btnResend;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//value[.='Cancel")
	public WebElement		btnCancel;

	@CacheLookup
	@FindBy(how = How.ID, using = "History")
	public WebElement		btnHistory;

	@FindBy(how = How.ID, using = "igProgress")
	public WebElement		prgProgressBar;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"plugin\"]")
	public WebElement		Window;
	
	//*[@id="plugin"]

}
