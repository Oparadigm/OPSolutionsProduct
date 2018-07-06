package com.innovation.pages.claim.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.innovation.misc.CalenderDate;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.pages.claim.objects.OR_ClaimAddClaimNoPolicy;


/**
 * @author Rizwan. This class stores all the locators and methods in Add claim - no policy pop up for Home LOB.
 *
 */
public class ClaimAddClaimNoPolicy
{
	WebDriver		driver;
	LoggingControl	loggingcontrol	= new LoggingControl ();
	OR_ClaimAddClaimNoPolicy orClaimAddClaimNoPolicy = null;

	public ClaimAddClaimNoPolicy (WebDriver driver)
	{
		this.driver = driver;
		orClaimAddClaimNoPolicy = PageFactory.initElements (driver, OR_ClaimAddClaimNoPolicy.class);
	}

	public void typeLossDate (String strRegion)
	{

		//@formatter:off 
    	loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver); 
    	//@formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddClaimNoPolicy.dtpLossDate));
		orClaimAddClaimNoPolicy.dtpLossDate.click ();
		orClaimAddClaimNoPolicy.dtpLossDate.sendKeys (Keys.HOME + CalenderDate.returnCurrentDate (strRegion));
	}

	public void selectLineOfBusiness (String strLineOfBusiness)
	{
		//@formatter:off 
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver); 
		//@formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddClaimNoPolicy.ddlLineOfBusiness));

		orClaimAddClaimNoPolicy.ddlLineOfBusiness.click ();
		orClaimAddClaimNoPolicy.ddlLineOfBusiness.sendKeys (strLineOfBusiness);
		orClaimAddClaimNoPolicy.ddlLineOfBusiness.click ();
	}

	public void clickCreate ()
	{
		//@formatter:off 
		loggingcontrol.ConsoleLogger (new Object (){}.getClass ().getEnclosingMethod ().getName (), driver); 
		//@formatter:on

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddClaimNoPolicy.btnCreate));

		orClaimAddClaimNoPolicy.btnCreate.click ();
	}

	public void clickCancel ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orClaimAddClaimNoPolicy.btnCancel));

		orClaimAddClaimNoPolicy.btnCancel.click ();
	}

}
