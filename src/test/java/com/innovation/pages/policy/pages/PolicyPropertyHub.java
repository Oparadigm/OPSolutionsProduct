/**
 * 
 */
package com.innovation.pages.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.TableHandler;
import com.innovation.pages.policy.objects.OR_PolicyPropertyHub;

/**
 * @author lushs - Create the page details for the Property Hub
 */
public class PolicyPropertyHub
{

	WebDriver				driver;
	OR_PolicyPropertyHub	orPolicyPropertyHub	= null;

	public PolicyPropertyHub (WebDriver driver)
	{
		this.driver = driver;
		orPolicyPropertyHub = PageFactory.initElements (driver, OR_PolicyPropertyHub.class);
	}

	public void selectRiskType (String strRiskType)
	{
		// This will wait for up to 3 seconds for the Risk drop down list to become available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyPropertyHub.ddlAddNew));
		Select oRiskType = new Select (orPolicyPropertyHub.ddlAddNew);
		oRiskType.selectByVisibleText (strRiskType);
	}

	public void checkText (String sTextToCheck)
	{

		String sText = orPolicyPropertyHub.txaPropertySearch.getText ();
		System.out.println (sText);
		if (sText.equalsIgnoreCase (sTextToCheck))
			System.out.println ("The text : " + sText + " has been located");
		else
			System.out.println ("The text you were searching for: " + sText + " has NOT been located");
	}

	public void selectUseExistingAddress ()
	{
		Select oExistingAddr = new Select (orPolicyPropertyHub.ddlUseExistingAddress);
		oExistingAddr.selectByIndex (1);
	}

	public void clickAddButton ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyPropertyHub.btnAdd));
		orPolicyPropertyHub.btnAdd.click ();
	}

	public void clickProceedNext ()
	{
		// This will wait for up to 3 seconds for the Proceed Next button to become available.
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyPropertyHub.prgProgress));
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyPropertyHub.btnProceedNext));
		orPolicyPropertyHub.btnProceedNext.click ();
	}

	public void clickEditDetails ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyPropertyHub.btnEditPropertyDetails));
		orPolicyPropertyHub.btnEditPropertyDetails.click ();
		wait.until (ExpectedConditions.invisibilityOf (orPolicyPropertyHub.prgProgress));
	}

	public void selecExistingProperty (String strRiskType)
	{
		TableHandler tableHandler = new TableHandler (driver);
		tableHandler.returnRowInTable ("tblProperty", strRiskType);
	}

}
