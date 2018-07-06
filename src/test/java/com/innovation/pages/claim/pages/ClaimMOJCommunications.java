package com.innovation.pages.claim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimMOJCommunications;

/**
 * @author Rubina - this class stores all the locators and methods on 'MOJ Communications' frame accessible through BO Navigation
 *         panel > Bodily injury > MOJ Communications
 * 
 */
public class ClaimMOJCommunications
{

	WebDriver					driver;
	OR_ClaimMOJCommunications	orClaimMOJCommunications	= null;

	public ClaimMOJCommunications (WebDriver driver)
	{
		this.driver = driver;
		orClaimMOJCommunications = PageFactory.initElements (driver, OR_ClaimMOJCommunications.class);

	}

	public void selectDocumentRow ()

	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJCommunications.tblPrintableDocument));
		
		// select any row from Moj Printable Documents Table
		TableHandler tablehandler = new TableHandler (driver);

		tablehandler.clickRandomTableRow ("printableDocsTable");
	}

	public void clickView ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimMOJCommunications.btnView));
		orClaimMOJCommunications.btnView.click ();

	}

	// This function will close the document pop up / window that will be opened from within 1insurer application
	public void closeWindow ()
	{

		// This variable will store the main 1insurer application browser
		String strCurrentWindow = driver.getWindowHandle ();
		// For loop will get each of open application window and will switch to it
		for (String strNewWindowHandle : driver.getWindowHandles ())
		{
			driver.switchTo ().window (strNewWindowHandle);
		}

		driver.close ();

		driver.switchTo ().window (strCurrentWindow);

	}

}
