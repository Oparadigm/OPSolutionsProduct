/**
 * 
 */
package com.innovation.pages.common.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.innovation.pages.common.objects.OR_HibernateSearch;

/**
 * @author lushs This class will store all the locators and methods of the Hibernate Search page.
 */

public class HibernateSearch
{

	WebDriver			driver;

	By					RadioSearchType		= By.id ("SearchType");
	OR_HibernateSearch	orHibernateSearch	= null;

	public HibernateSearch (WebDriver driver)
	{
		this.driver = driver;
		orHibernateSearch = PageFactory.initElements (driver, OR_HibernateSearch.class);
	}

	public void clickSearch ()
	{
		orHibernateSearch.btnSearch.click ();
	}

	public void setSearchType ()
	{

		List<WebElement> radioBx = driver.findElements (RadioSearchType);
		// List < WebElement > radioBx = orHibernateSearch.RadioSearchType;
		// This will tell you the number of radio button are present
		int iSize = radioBx.size ();
		// iterate each link and click on it
		for (int i = 0; i < iSize; i++)
		{
			// Store the Check Box name to the string variable, using 'Value'
			// attribute
			String sValue = radioBx.get (i).getAttribute ("value");
			// Select the Check Box it the value of the Check Box is same what
			// you are looking for
			if (sValue.equalsIgnoreCase ("CLIENTS"))
			{
				radioBx.get (i).click ();
				// This will take the execution out of for loop
				break;
			}
		}
	}

	public void typeTextSearchField ()
	{
		orHibernateSearch.txtSearchField.clear ();
		orHibernateSearch.txtSearchField.sendKeys ("Testing Times");
	}

	public void checkText (String sTextToCheck)
	{

		String sText = orHibernateSearch.TableText.getText ();
		System.out.println (sText);
		if (sText.equalsIgnoreCase (sTextToCheck))
			System.out.println ("The text : " + sText + " has been located");
		else
			System.out.println ("The text you were searching for: " + sText + " has NOT been located");
	}

	public void clickNewIndividual ()
	{
		orHibernateSearch.btnNewIndividual.click ();

	}
}
