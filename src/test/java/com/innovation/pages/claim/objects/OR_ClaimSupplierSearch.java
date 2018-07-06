package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Rizwan. This captures the page elements for Claims Supplier Search page. screen in Home LOBs.
 * 
 */
public class OR_ClaimSupplierSearch
{

	@FindBy(how = How.ID, using = "CLM_SC_BO_0375_VendorType_10a")
	public WebElement	ddlType;

	@FindBy(how = How.ID, using = "CLM_SC_029_SearchProfile_10a")
	public WebElement	ddlSearchType;
	
	@FindBy(how = How.ID, using = "CLM_SC_BO_0375_DisplayID_10a")
	public WebElement	txtSupplierId;
	
	@FindBy(how = How.ID, using = "quickAddressAddressList_10a")
	public WebElement	ddlProximityTo;

	@FindBy(how = How.ID, using = "CLM_SC_BO_0375_Search_10a")
	public WebElement	btnSearchSupplier;


	@FindBy(how = How.ID, using = "CLM_SC_BO_0375_VendorSearch")
	public WebElement	tblSupplierSearchResults;

	@FindBy(how = How.ID, using = "CLM_SC_BO_032_AssociateVendor_30a")
	public WebElement	btnAssociateSupplier;

	@FindBy(how = How.ID, using = "CLM_SC_BO_032_AssociateVendorAndInstruct_30a")
	public WebElement	btnInstructSupplier;

	@FindBy(how = How.ID, using = "CLM_SC_BO_4218_Parties_Summary")
	public WebElement	tblSupplierSearchResultsBO;
	
	@FindBy(how = How.ID, using = "CLM_SC_BO_4476_Select_20a")
	public WebElement	btnSelectSupplierBO;
	
	@FindBy(how = How.ID, using = "igErrorPanel")
	public WebElement	pnlSupplierAttachmentMessage;

}
