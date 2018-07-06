/**
 * 
 */
package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Alamq - This captures the page elements for the Item Management screen of Property Claim.
 * 
 *         Rizwan - Updated this class to add elements that appear on Add New Item screen in back office. Elements added are Clear
 *         button, Yes button, No button, 'Move all to item management' button and OK button.
 *
 */
public class OR_ClaimItemManagementDetails
{

	// This element captures 'Move all to item management' button that appears on Add New Item frame in back office
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2847_MoveAllItemsButton_30")
	public WebElement		btnMoveAllToItemMgmt;

	// This element captures 'OK' button on 'Item validation' pop up that appears after 'Move all to item management' button is
	// clicked
	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseOK")
	public WebElement		btnOK;

	// This element will select 'Coverage' drop down value
	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2847_CoverageCode_40b")
	public WebElement		ddlCoverage;
	
	// This element will select 'Item type' drop down value
	// @CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_2851_ItemType_40b")
	public WebElement		ddlItemType;

	// This element will select 'Item type value' drop down value
	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2851_ItemType_40b")
	public WebElement		ddlItemTypeValue;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2851_Item_40b")
	public WebElement		ddlItem;

	// This element will enter details in 'Item Details' Text Area field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2851_Description_TextArea_40b")
	public WebElement		txaItemDetails;

	// This element will select 'Part of a set' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_18569_PartSet_40b")
	public List<WebElement>	rdoPartOfSet;

	// This element will select 'Age of item' drop down value
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2851_Age_40b")
	public WebElement		ddlItemAge;

	// This element will select 'Item(s) Location' drop down value
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_18569_ItemsLocation_40b")
	public WebElement		ddlItemLocation;

	// This element will select 'Number of Rooms affected' drop down value
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_18569_NoOfRooms_40b")
	public WebElement		ddlNumberOfRooms;

	// This element will select 'Owned By' drop down value
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2847_Ownership_40b")
	public WebElement		ddlOwnedBy;

	// This element will select 'Priority' drop down value
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_18569_ItemsPriority_40b")
	public WebElement		ddlPriority;

	// This element will enter date in 'Date last used' field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_18569_DateLastUsed_40b")
	public WebElement		dtpDateLastUsed;

	// This element will select 'Item Use' drop down value
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_18569_ItemUse_40b")
	public WebElement		ddlItemUsed;

	// This element will select 'Item serviced/maintained/repaired' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_18569_ItemServiced_40b")
	public List<WebElement>	rdoItemServiced;

	// This element will enter date in 'last serviced/maintained/repaired' field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_18569_DateLastServiced_40b")
	public WebElement		dtpLastService;

	// This element will enter details in 'Serviced/maintained/repaired by Whom'
	// field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_18569_ServicedBy_40b")
	public WebElement		txtServicedByWhom;

	// This element will select 'Under Warranty' radio button
	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_18569_UnderWarranty_40b")
	public List<WebElement>	rdoUnderWarranty;

	// This element will enter details in 'Amount Claimed' field
	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2851_AmtClaimed_40b")
	public WebElement		txtAmountClaimed;

	// This element will enter details in 'Source of Amount' field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_2851_SourceOfAmt_40b")
	public WebElement		ddlSourceOfAmount;

	// This element will enter details in 'Purchase price' field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_18569_PurchasePrice_40b")
	public WebElement		txtPurchasePrice;

	// This element will enter details in 'Where Purchased' field
	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_18569_PurchaseWhere_40b")
	public WebElement		txtWherePurchased;

	// This element will enter details in 'Fullfilment route' field
	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_18569_FullFilmentRoute_40b")
	public WebElement		ddlFullfilmentRoute;

	@CacheLookup
	@FindBy(how = How.ID, using = "tblClaimItems")
	public WebElement		tblClaimItems;

	@CacheLookup
	@FindBy(how = How.ID, using = "ProviderSearch_40c")
	public WebElement		btnSupplierSearch;

	// This element will click on "Save" button
	// @CacheLookup
	@FindBy(how = How.ID, using = "SaveItem_40b")
	public WebElement		btnSave;

	// This element captures Clear button
	@CacheLookup
	@FindBy(how = How.ID, using = "ClearItem_40b")
	public WebElement		btnClear;

	// This element captures Yes button on Reset pop up that is displayed on pressing Clear button
	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseYes")
	public WebElement		btnYes;

	// This element captures No button on Reset pop up that is displayed on pressing Clear button
	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseNo")
	public WebElement		btnNo;

	// This element will click on "Nexttt" button
	@CacheLookup
	@FindBy(how = How.ID, using = "igFlowNextBtn")
	public WebElement		btnNext;

}
