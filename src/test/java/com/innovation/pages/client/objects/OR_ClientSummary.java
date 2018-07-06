package com.innovation.pages.client.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Rizwan. This captures the page elements for Client Summary screen.
 *
 */
public class OR_ClientSummary {

	// Capturing elements on Billing summary tab

	// This captures Billing summary tab on Client Summary frame
	@CacheLookup
	@FindBy(how = How.CSS, using = "html body.igMainBody form.igForm div#contentColumn span#sectionSpan_xmlAssembled30 div#contentColumn_xmlAssembledExpDiv30.icongroup1 table tbody tr td div#tabs table.igST_tabTable tbody tr td#cltSummaryTabs_tabSelector_2.igST_tabSelectorUnsel div#tabSelectorDiv_2.igST_tabSelDiv label.igFormLabel.igST_tabLabel")
	public WebElement tabBillingSummary;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnBillAcctView")
	public WebElement btnViewBillingDetails;

	// Capturing elements on Quotes/Policies tab

	@CacheLookup
	@FindBy(how = How.CSS, using = "html body.igMainBody form.igForm div#contentColumn span#sectionSpan_xmlAssembled30 div#contentColumn_xmlAssembledExpDiv30.icongroup1 table tbody tr td div#tabs table.igST_tabTable tbody tr td#cltSummaryTabs_tabSelector_3.igST_tabSelectorUnsel div#tabSelectorDiv_3.igST_tabSelDiv label.igFormLabel.igST_tabLabel")
	public WebElement tabQuotesPolicies;

	@CacheLookup
	@FindBy(how = How.ID, using = "Policy_Action")
	public WebElement ddlPolicyAction;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnPolicyAction")
	public WebElement btnPolicyGo;

	@CacheLookup
	@FindBy(how = How.ID, using = "Quote_Action")
	public WebElement ddlQuoteAction;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnQuoteAction")
	public WebElement btnQuoteGo;

	// Capturing elements on Claims tab

	@CacheLookup
	@FindBy(how = How.CSS, using = "html body.igMainBody form.igForm div#contentColumn span#sectionSpan_xmlAssembled30 div#contentColumn_xmlAssembledExpDiv30.icongroup1 table tbody tr td div#tabs table.igST_tabTable tbody tr td#cltSummaryTabs_tabSelector_4.igST_tabSelectorUnsel div#tabSelectorDiv_4.igST_tabSelDiv label.igFormLabel.igST_tabLabel")
	public WebElement tabClaims;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnClaimView")
	public WebElement btnViewClaim;

	// Capturing elements on Tasks tab

	@FindBy(how = How.CSS, using = "html body.igMainBody form.igForm div#contentColumn span#sectionSpan_xmlAssembled30 div#contentColumn_xmlAssembledExpDiv30.icongroup1 table tbody tr td div#tabs table.igST_tabTable tbody tr td#cltSummaryTabs_tabSelector_5.igST_tabSelectorUnsel div#tabSelectorDiv_5.igST_tabSelDiv label.igFormLabel.igST_tabLabel")
	public WebElement tabTasks;

	// Capturing elements on Communications tab

	@FindBy(how = How.CSS, using = "html body.igMainBody form.igForm div#contentColumn span#sectionSpan_xmlAssembled30 div#contentColumn_xmlAssembledExpDiv30.icongroup1 table tbody tr td div#tabs table.igST_tabTable tbody tr td#cltSummaryTabs_tabSelector_6.igST_tabSelectorUnsel div#tabSelectorDiv_6.igST_tabSelDiv label.igFormLabel.igST_tabLabel")
	public WebElement tabCommunications;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_CombinedComuication_View")
	public WebElement btnViewCommunication;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_UserControl_QuickSearch")
	public WebElement txtQuickSearch;

	@CacheLookup
	@FindBy(how = How.ID, using = "userControl_quickSearchIcon")
	public WebElement imgQuickSearchIcon;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement prgProgress;

}
