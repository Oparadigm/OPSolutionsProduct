package com.innovation.pages.claim.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.innovation.pages.common.objects.OR_ControlPanel;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.TableHandler;
import com.innovation.pages.claim.objects.OR_ClaimEstimateList;

/*
 * @author  Alamq - this class stores all the locators and methods on 'Estimate list' frame accessible through BO Navigation panel > Property damage > Estimate  
 *  
 */

public class ClaimEstimateList
{
	WebDriver				driver;
	OR_ClaimEstimateList	orClaimEstimateList	= null;
	OR_ControlPanel			orControlPanel		= null;

	public ClaimEstimateList (WebDriver driver)
	{
		this.driver = driver;
		orClaimEstimateList = PageFactory.initElements (driver, OR_ClaimEstimateList.class);
		orControlPanel = PageFactory.initElements (driver, OR_ControlPanel.class);

	}

	public void clickAddEstimateProperty ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateList.btnAddEstimateProperty));
		orClaimEstimateList.btnAddEstimateProperty.click ();
	}

	public void clickAddEstimateAuto ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateList.btnAddEstimateAuto));
		orClaimEstimateList.btnAddEstimateAuto.click ();
	}

	public void selectEstimatesType (String strEstimateType)
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimEstimateList.tblEstimateType));
		TableHandler tablehandler = new TableHandler (driver);
		tablehandler.returnRowInTable ("CLM_SC_BO_0130_EstimateListTable", strEstimateType);
		wait.until (ExpectedConditions.invisibilityOf (orControlPanel.barProgress));
	}

}
