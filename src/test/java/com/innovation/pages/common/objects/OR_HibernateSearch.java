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
public class OR_HibernateSearch
{

	@CacheLookup
	@FindBy(how = How.CSS, using = "a[href*='Search']")
	public WebElement	btnSearch;

	@CacheLookup
	@FindBy(how = How.ID, using = "SearchType")
	public WebElement	btnSearchType;

	@CacheLookup
	@FindBy(how = How.ID, using = "InteractiveSearchTextBox")
	public WebElement	txtSearchField;

	@CacheLookup
	@FindBy(how = How.ID, using = "NAME")
	public WebElement	TableText;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnAddIndividualClient")
	public WebElement	btnNewIndividual;

}
