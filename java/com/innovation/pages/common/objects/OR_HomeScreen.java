/**
 * 
 */
package com.innovation.pages.common.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs
 *
 */
public class OR_HomeScreen
{


	@FindBy(how = How.LINK_TEXT, using = "Search")
	public WebElement	btnSearch;
	
	// Hibernate Search
	@CacheLookup
	@FindBy(how = How.CSS, using = "a[href*='InnovationCombinedSearch']")
	public WebElement	btnHibernateSearch;	

	// Activity
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Activity")
	public WebElement	btnActivity;	
	
	// driver.findElement(By.linkText("Policy client search")).click();
	
	@FindBy(how = How.LINK_TEXT, using = "Claim search")
	public WebElement	btnClaimSearch;

	
	@FindBy(how = How.LINK_TEXT, using = "Policy search")
	public WebElement	btnPolicySearch;

	
	@FindBy(how = How.LINK_TEXT, using = "Policy client search")
	public WebElement	btnPolicyClientSearch;

	@CacheLookup
	@FindBy(how = How.ID, using = "userControl_signOut")
	public WebElement	btnSignOut;

	// Desktop button
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Desktop")
	public WebElement	btnDesktop;

	// Progress Bar
	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgress;
	
	// Quick Search
	@CacheLookup
	@FindBy(how = How.ID, using = "SC_UserControl_QuickSearch")
	public WebElement txtQuickSearch;

	// Quick search link
	@FindBy(how = How.XPATH, using = "//*[@id='userControl_quickSearchIcon']")
	public WebElement imgSearch;
}
