/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.innovation.pages.policy.objects.OR_PolicySummary;

/**
 * @author lushs - Create the page details for the Policy Client Screen
 */
public class PolicyClientSummary
{

	WebDriver			driver;

	OR_PolicySummary	orPolicySummary	= null;

	public PolicyClientSummary (WebDriver driver)
	{
		this.driver = driver;
		orPolicySummary = PageFactory.initElements (driver, OR_PolicySummary.class);
	}

}
