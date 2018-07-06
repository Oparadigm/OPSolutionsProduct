
package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Rizwan. This captures the page elements for the Add Party screen in Home LOBs.
 * 
 */
public class OR_ClaimAddParty
{

	@CacheLookup
	@FindBy(how = How.ID, using = "selSearchType")
	public WebElement		ddlSearchBy;

	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_FirstName")
	public WebElement		txtFirstName;

	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_LastName")
	public WebElement		txtLastName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_DOB")
	public WebElement		txtDateOfBirth;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_CompanyName")
	public WebElement		txtCompanyName;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_City")
	public WebElement		txtCity;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_PostCode")
	public WebElement		txtPostcode;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_PhoneNo_Contact")
	public WebElement		txtContactNo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_PolicyNumber")
	public WebElement		txtPolicyNo;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_ClaimNumber")
	public WebElement		txtClaimNo;

	// @CacheLookup
	@FindBy(how = How.CSS,
			using = "html body.igMainBody form.igForm div#contentColumn span#sectionSpan_xmlAssembled1 div#contentColumn_xmlAssembledExpDiv1.icongroup1 table tbody tr td div.igLegendContainer table tbody tr td div#divSearchByType_1_1a table tbody tr td input#Search.iginputbutton")
	public WebElement		btnSearchByName;

	@CacheLookup
	@FindBy(how = How.CSS,
			using = "html body.igMainBody form.igForm div#contentColumn span#sectionSpan_xmlAssembled1 div#contentColumn_xmlAssembledExpDiv1.icongroup1 table tbody tr td div.igLegendContainer table tbody tr td div#divSearchByType_0_1a table tbody tr td input#Search.iginputbutton")
	public WebElement		btnSearchByParameter;

	@CacheLookup
	@FindBy(how = How.CSS,
			using = "html body.igMainBody form.igForm div#contentColumn span#sectionSpan_xmlAssembled1 div#contentColumn_xmlAssembledExpDiv1.icongroup1 table tbody tr td div.igLegendContainer table tbody tr td div#divSearchByType_1_1a table tbody tr td div.igButtonDiv button.iginputbuttonSecondary")
	public WebElement		btnClearByName;

	@CacheLookup
	@FindBy(how = How.CSS,
			using = "html body.igMainBody form.igForm div#contentColumn span#sectionSpan_xmlAssembled1 div#contentColumn_xmlAssembledExpDiv1.icongroup1 table tbody tr td div.igLegendContainer table tbody tr td div#divSearchByType_0_1a table tbody tr td div.igButtonDiv button.iginputbuttonSecondary")
	public WebElement		btnClearByParameter;

	@CacheLookup
	@FindBy(how = How.ID, using = "tblClientSearch")
	public WebElement		tblClientSearch;

	@CacheLookup
	@FindBy(how = How.CSS,
			using = "html body.igMainBody form.igForm div#contentColumn span#sectionSpan_xmlAssembled1 div#contentColumn_xmlAssembledExpDiv1.icongroup1 table tbody tr td div#container.igLegendContainer div#clientTableDivAll table tbody tr td input.iginputbuttonSecondary")
	public WebElement		btnNewEntry;

	@CacheLookup
	@FindBy(how = How.ID, using = "igUserInteractResponseOK")
	public WebElement		btnResetOK;

	@FindBy(how = How.ID, using = "CLM_SC_099_PartyTypeNew")
	public WebElement		ddlPartyIndicatorNew;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_PartyTypeNewExist")
	public WebElement		ddlPartyIndicatorExist;

	@CacheLookup
	@FindBy(how = How.NAME, using = "CLM_SC_099_PartyType")
	public List<WebElement>	rdoThirdPartyTypeNew;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_NewCompanyname")
	public WebElement		txtTPCompanyNameNew;

	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_CLM_SC_099_NewTitle")
	public WebElement		ddlTitle;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_NewTitle")
	public WebElement		ddlTitleValues;

	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_NewSubRoles")
	public WebElement		ddlAbvailableSubRolesNew;

	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_NewSubRolesExist")
	public WebElement		ddlAbvailableSubRolesExist;

	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_Add")
	public WebElement		btnAddSubRoleNew;

	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_AddExist")
	public WebElement		btnAddSubRoleExist;

	// @CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_AddedSubRoles")
	public WebElement		lstSelectedSubRolesNew;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_AddedSubRolesExist")
	public WebElement		lstSelectedSubRolesExist;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_Remove")
	public WebElement		btnRemoveSubRoleNew;

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_099_RemoveExist")
	public WebElement		btnRemoveSubRoleExist;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnSubmitNewClaimant")
	public WebElement		btnAddPartyNew;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnSubmitNewClientClaimant")
	public WebElement		btnAddPartyExist;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html/body/form/div[10]/span/div[2]/table/tbody/tr/td/div[3]/div/div/table/tbody/tr[3]/td[2]/input")
	public WebElement		btnCancelPartyNew;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html/body/form/div[10]/span/div[2]/table/tbody/tr/td/div[2]/div[3]/table/tbody/tr[3]/td[2]/input")
	public WebElement		btnCancelPartyExist;

	@CacheLookup
	@FindBy(how = How.CSS,
			using = "html body.igMainBody form.igForm div#headerColumn div#controlpanel table.tableControlPanel tbody tr td div.igButtonDiv button.igFlowPrevious")
	public WebElement		btnNavigateBack;

}
