package com.innovation.pages.policy.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomCount;
import com.innovation.misc.TableHandler;
import com.innovation.pages.common.pages.ControlPanel;
import com.innovation.pages.policy.objects.OR_PolicyInterestedParty;

/*
 * @Author Tahir Akbar This class contains method to validate and add the Interested Party in the Straight New Business
 */

public class PolicyInterestedParty

{

	WebDriver					driver;

	OR_PolicyInterestedParty	orPolicyInterestedParty	= null;

	public PolicyInterestedParty (WebDriver driver)
	{
		this.driver = driver;
		orPolicyInterestedParty = PageFactory.initElements (driver, OR_PolicyInterestedParty.class);

	}

	public void selectIPRow (String strRiskType)

	{

		TableHandler RiskSelectRow = new TableHandler (driver);
		RiskSelectRow.returnRowInTable ("tblItemInterestedPartyList", strRiskType);

	}

	// The following function will select the Interested Party Row in the Screen if
	// Interested Party Exists it Continues,
	// If not it will add new party and select it
	public void AddInterestedParty (String strOwnershipIndicator, String strEnvironmentName, String strCompany, String strState) throws Exception

	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		TableHandler interestedpartytable = new TableHandler (driver);
		PolicyClientSearch clientsearch = new PolicyClientSearch (driver);

		boolean booldataexists = interestedpartytable.verifyTableHasData ("tblinterestedParty");

		if (booldataexists == false && strOwnershipIndicator.equals ("Mortgage owned - not rented out") || strOwnershipIndicator.equals ("Buy to let"))
		{

			// // In case the Interested Party already exists
			// System.out.println("Interested party Exists");

			wait.until (ExpectedConditions.elementToBeClickable (orPolicyInterestedParty.btnSearchParty));
			orPolicyInterestedParty.btnSearchParty.click ();

			String strSearchedClient = clientsearch.selectExistingCompanyClients (strEnvironmentName, strCompany, strState);
			orPolicyInterestedParty.btnSearchPartylist.click ();

			wait.until (ExpectedConditions.invisibilityOf (orPolicyInterestedParty.prgProgressBar));

			// Add the Searched Company Client

			interestedpartytable.returnRowInTable ("tblClientSearch", strSearchedClient);

			wait.until (ExpectedConditions.elementToBeClickable (orPolicyInterestedParty.btnSelectInterestedParty));
			orPolicyInterestedParty.btnSelectInterestedParty.click ();

			wait.until (ExpectedConditions.invisibilityOf (orPolicyInterestedParty.prgProgressBar));
			// Add
			Select interestedPartyType = new Select (orPolicyInterestedParty.ddlPartyType);
			Select interestedPartyPrintInd = new Select (orPolicyInterestedParty.ddlPartyPrintInd);
			Select interestedPartyPosition = new Select (orPolicyInterestedParty.ddlPartyPosition);
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyInterestedParty.secPartyDetails));

			// The following will validate if party details section is enabled
			orPolicyInterestedParty.secPartyDetails.isEnabled ();

			// following code will enter the details of the Interested Party in the section
			// the value will be randomly selected from the drop downs
			// -----------------------------------------------------------------------------------

			int intInterestedpartyTypeIndex = RandomCount.selectRandomItem (interestedPartyType);
			interestedPartyType.selectByIndex (intInterestedpartyTypeIndex);

			// ------------------------------------------------------------------------------------

			int intInterestedpartyposIndex = RandomCount.selectRandomItem (interestedPartyPosition);
			interestedPartyPosition.selectByIndex (intInterestedpartyposIndex);

			// ------------------------------------------------------------------------------------

			int intPrintIndicator = RandomCount.selectRandomItem (interestedPartyPrintInd);
			interestedPartyPrintInd.selectByIndex (intPrintIndicator);

			List<WebElement> jointOwner = driver.findElements (By.className ("iginputradio"));

			jointOwner.get (0).click ();

			orPolicyInterestedParty.btnAddInterestedParty.click ();

			wait.until (ExpectedConditions.invisibilityOf (orPolicyInterestedParty.prgProgressBar));

		}

	}

	public void selectAddedInterestedParty ()
	{

		TableHandler interestedpartytable = new TableHandler (driver);
		WebDriverWait waiter = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		waiter.until (ExpectedConditions.invisibilityOf (orPolicyInterestedParty.prgProgressBar));

		boolean boolinterestedpartyadded = interestedpartytable.verifyTableHasData ("tblinterestedParty");

		if (boolinterestedpartyadded == true)
		{

			waiter.until (ExpectedConditions.elementToBeClickable (orPolicyInterestedParty.tblInterestedParty));

			interestedpartytable.returnRowInTable ("tblItemInterestedPartyList", "Yes");

		}

	}

	public void proceedNext ()
	{

		ControlPanel controlnext = new ControlPanel (driver);
		controlnext.clickNext ();
	}

}
