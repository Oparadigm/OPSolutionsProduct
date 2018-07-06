package com.innovation.pages.policy.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.DatabaseData;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.RandomNumbers;
import com.innovation.misc.SeleniumWaiter;
import com.innovation.misc.TableHandler;
import com.innovation.pages.policy.objects.OR_PolicyBillingDetails;
import com.innovation.sql.client.ClientSQL;

/**
 * @author haiderm - This class stores all the locators and methods of the Policy billing details screen
 */
public class PolicyBillingDetails
{

	WebDriver				driver;
	OR_PolicyBillingDetails	orPolicyBillingDetails	= null;

	public PolicyBillingDetails (WebDriver driver)
	{
		this.driver = driver;
		orPolicyBillingDetails = PageFactory.initElements (driver, OR_PolicyBillingDetails.class);
		// this.intAdditionalAmount = (RandomNumbers.randomSelect (100));
	}

	/*** Implementation of Billing client details section ***/
	/**
	 * <- Database Validation->
	 * 
	 * @throws Exception
	 **/
	// Insured's name
	public void validateInsuredName (String strEnvironmentName) throws Exception
	{

		String strClientNum = orPolicyBillingDetails.hdnClientNumber.getAttribute ("value");
		String strSQLQuery = ClientSQL.returnBillingClientName ("8880", strClientNum);
		List<String> lstInsuredName_DB = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		String strInsuredName_DB = lstInsuredName_DB.get (0);
		Select oSelectInsuredName = new Select (orPolicyBillingDetails.ddlInsuredName);
		WebElement optionSelected = oSelectInsuredName.getFirstSelectedOption ();
		String nameSelected = optionSelected.getText ();
		if (strInsuredName_DB.equalsIgnoreCase (nameSelected))
		{

			System.out.println ("Database Validation for 'Insured's Name' is successful.");
		}

		else
		{

			System.out.println ("Database Validation for 'Insured's Name' is NOT successful.");
		}

	}

	// If more than one Name exists then select desired one
	public void selectInsuredName (String strInsuredName)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.ddlInsuredName));
		orPolicyBillingDetails.ddlInsuredName.click ();
		Select oSelectInsuredName = new Select (orPolicyBillingDetails.ddlInsuredName);
		oSelectInsuredName.selectByVisibleText (strInsuredName);
	}

	/** <- Database Validation-> **/
	// Billing address
	public void validateBillingAddress (String strEnvironmentName) throws Exception
	{

		String strClientNum = orPolicyBillingDetails.hdnClientNumber.getAttribute ("value");
		String strSQLQuery = ClientSQL.returnBillingAddress ("8880", strClientNum);
		List<String> lstBillingAddress_DB = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		String strBillingAddress_DB = lstBillingAddress_DB.get (0);
		Select oSelectBillingAddress = new Select (orPolicyBillingDetails.ddlBillingAddress);
		WebElement optionSelected = oSelectBillingAddress.getFirstSelectedOption ();
		String addressSelected = optionSelected.getText ();
		if (strBillingAddress_DB.equalsIgnoreCase (addressSelected))
		{

			System.out.println ("Database Validation for 'Billing Address' is successful.");
		}

		else
		{

			System.out.println ("Database Validation for 'Billing Address' is NOT successful.");
		}

	}

	// Billing address
	public void selectBillingAddress ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.ddlBillingAddress));
		orPolicyBillingDetails.ddlBillingAddress.click ();
		Select oSelectBillingAddress = new Select (orPolicyBillingDetails.ddlBillingAddress);
		oSelectBillingAddress.selectByIndex (1); // For robustness, I'll modify it via db in next feature.
	}

	// Add client
	public void addClient ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnAddClient));
		orPolicyBillingDetails.btnAddClient.click ();

	}

	// Maintain address
	public void maintainAddress ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnMaintainAddress));
		orPolicyBillingDetails.btnMaintainAddress.click ();

	}

	/*** Implementation of Make a Payment on Billing Details Frame ***/
	/** Implemented By M.Tahir Akbar **/

	public void makePayment (String strBillPlan, String strBankAccount, String strAccountNumber, String strSortCode, String strReceipt)
	{
		if (strBillPlan.contains ("Annual direct debit") || strBillPlan.contains ("Monthly DD 8%") || strBillPlan.contains ("Monthly EFT") ||
			strBillPlan.contains ("Quarterly EFT Bill") || strBillPlan.contains ("ANDD"))
		{
			this.selectAccountType (strBankAccount);
			this.selectBankAccountType (strBankAccount);
			this.typeAccountNumber (strAccountNumber);
			this.typeSortCode (strSortCode);
			this.clickAdd ();
			this.bankAccountPopup ();
			this.checkAddOverride ();
			this.selectReceiptType (strReceipt);
			this.selectCurrentBalance (strReceipt);

		}
		else if (strBillPlan.contains ("Annual Card") || strBillPlan.contains ("Temp Agency Bill Plan") || strBillPlan.contains ("1 Pay") ||
			strBillPlan.contains ("Agent") || strBillPlan.contains ("Monthly Direct") || strBillPlan.contains ("Quarterly Direct Bill"))
		{
			this.selectReceiptType (strReceipt);
			this.selectCurrentBalance (strReceipt);
		}

	}

	// Table
	public void selectExistingAccount (String strAccountType)
	{

		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		load.until (ExpectedConditions.visibilityOfAllElements (orPolicyBillingDetails.pnlAccountSelection));
		load.until (ExpectedConditions.invisibilityOf (orPolicyBillingDetails.prgProgressbar));
		List<WebElement> asSection = orPolicyBillingDetails.pnlAccountSelection;
		if (!asSection.isEmpty ())
		{
			TableHandler tablehandler = new TableHandler (driver);
			boolean booltablecontainsdata = tablehandler.verifyTableHasData ("tblAccountSelection");
			if (booltablecontainsdata == true)
			{

				tablehandler.returnRowInTable ("tblAccountSelection", strAccountType);
			}

		}
		else
		{

			System.out.println ("Account selection section is not available.");
		}

		load.until (ExpectedConditions.visibilityOfAllElements (orPolicyBillingDetails.pnlAccountSelection));
		TableHandler tableAccountsHandler = new TableHandler (driver);
		load.until (ExpectedConditions.invisibilityOf (orPolicyBillingDetails.prgProgressbar));
		List<WebElement> accountSection4 = orPolicyBillingDetails.pnlAccountSelection;
		if (!accountSection4.isEmpty ())
		{

			boolean booltablecontainsdata = tableAccountsHandler.verifyTableHasData ("tblAccountSelection");

			if (booltablecontainsdata == true)
			{

				tableAccountsHandler.returnRowInTable ("tblAccountSelection", strAccountType);
				PolicyBillingDetails.this.clickAssign ();

			}

			else
			{

				WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

				String strPCAResult = orPolicyBillingDetails.imgAccountStatus.getAttribute ("src");
				String strCurrentUrl = driver.getCurrentUrl ();
				String strfetchUrlIP = StringUtils.substringBefore (strCurrentUrl, "/Jasper");

				if (strPCAResult.contains (strfetchUrlIP + "/Jasper/images/Innovation/InnovationInsurance/baseLook/Incomplete.png"))
				{
					wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.chkOverride));
					orPolicyBillingDetails.chkOverride.click ();
				}

				if (strPCAResult.contains (strfetchUrlIP + "/Jasper/images/Innovation/InnovationInsurance/baseLook/Complete.png"))
				{
					wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnAccountAdd));
					orPolicyBillingDetails.btnAccountAdd.click ();
					;
				}

			}

		}

	}

	// // Account type
	public void selectAccountType (String strAccountType)
	{

		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		load.until (ExpectedConditions.visibilityOfAllElements (orPolicyBillingDetails.pnlAccountSelection));
		List<WebElement> asSection = orPolicyBillingDetails.pnlAccountSelection;
		if (!asSection.isEmpty ())
		{

			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.visibilityOfAllElements (orPolicyBillingDetails.rdoAccountType));

			if (strAccountType.equalsIgnoreCase ("Bank account") || strAccountType.equalsIgnoreCase ("B"))
			{

				List<WebElement> radiobuttons = orPolicyBillingDetails.rdoAccountType;
				for (WebElement radiobutton : radiobuttons)
				{

					if (radiobutton.getAttribute ("onclick").equals ("accountTypeSelection('B')"))
					{
						radiobutton.click ();
						break;
					}

				}

			}
			else
			{

				List<WebElement> radiobuttons = orPolicyBillingDetails.rdoAccountType;
				for (WebElement radiobutton : radiobuttons)
				{
					if (radiobutton.getAttribute ("onclick").equals ("accountTypeSelection('C')"))
					{
						radiobutton.click ();
						break;
					}

				}

			}
		}
		else
		{

			System.out.println ("Account selection section is not available.");
		}

	}

	// // Bank account type
	public void selectBankAccountType (String strBankAccountType)
	{

		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		load.until (ExpectedConditions.visibilityOfAllElements (orPolicyBillingDetails.pnlAccountSelection));
		List<WebElement> asSection = orPolicyBillingDetails.pnlAccountSelection;
		if (!asSection.isEmpty ())
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.ddlBankAccountType));
			orPolicyBillingDetails.ddlBankAccountType.click ();
			Select oBankAccountType = new Select (orPolicyBillingDetails.ddlBankAccountType);
			oBankAccountType.selectByVisibleText (strBankAccountType);
		}
		else
		{
			System.out.println ("Account selection section is not available.");
		}
	}

	// // Account number
	public void typeAccountNumber (String strAccountNumber)
	{

		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		load.until (ExpectedConditions.visibilityOfAllElements (orPolicyBillingDetails.pnlAccountSelection));
		List<WebElement> asSection = orPolicyBillingDetails.pnlAccountSelection;
		if (!asSection.isEmpty ())
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.txtAccountNumber));
			orPolicyBillingDetails.txtAccountNumber.clear ();
			orPolicyBillingDetails.txtAccountNumber.sendKeys (strAccountNumber);
		}
		else
		{
			System.out.println ("Account selection section is not available.");
		}
	}

	// Sort code
	public void typeSortCode (String strSortCode)
	{

		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		load.until (ExpectedConditions.visibilityOfAllElements (orPolicyBillingDetails.pnlAccountSelection));
		List<WebElement> asSection = orPolicyBillingDetails.pnlAccountSelection;
		if (!asSection.isEmpty ())
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.txtSortCode));
			orPolicyBillingDetails.txtSortCode.clear ();
			orPolicyBillingDetails.txtSortCode.sendKeys (strSortCode);
		}
		else
		{
			System.out.println ("Account selection section is not available.");
		}
	}

	// Add
	public void clickAdd ()
	{

		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		load.until (ExpectedConditions.visibilityOfAllElements (orPolicyBillingDetails.pnlAccountSelection));
		List<WebElement> asSection = orPolicyBillingDetails.pnlAccountSelection;
		if (!asSection.isEmpty ())
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnAccountAdd));
			orPolicyBillingDetails.btnAccountAdd.click ();
		}
		else
		{
			System.out.println ("Account selection section is not available.");
		}
	}

	// Validate: Pop up

	public void bankAccountPopup ()
	{

		WebDriverWait waitforpopup = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		waitforpopup.until (ExpectedConditions.visibilityOf (orPolicyBillingDetails.lgtPopUpBankAccount));
		String popUptxt = orPolicyBillingDetails.lgtPopUpBankAccount.getText ();
		if (popUptxt.contains ("Bank account details"))
		{

			List<WebElement> lightbox = orPolicyBillingDetails.lgtPopupClose;
			if (!lightbox.isEmpty ())
			{
				WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
				wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnPopupClose));
				orPolicyBillingDetails.btnPopupClose.click ();
			}
			else
			{
				System.out.println ("1insurer Lightbox is not popped up.");
			}

		}
	}

	// Close: Pop up
	// public void clickCloseOnPopup() {
	//
	// List<WebElement> lightbox = orPolicyBillingDetails.lgtPopupClose;
	// if (!lightbox.isEmpty()) {
	// WebDriverWait wait = new WebDriverWait(driver,
	// GlobalWaitTime.getIntWaitTime());
	// wait.until(ExpectedConditions.elementToBeClickable(orPolicyBillingDetails.btnPopupClose));
	// orPolicyBillingDetails.btnPopupClose.click();
	// } else {
	// System.out.println("1insurer Lightbox is not popped up.");
	// }
	// }

	// Override
	public void checkAddOverride ()
	{

		String strAccountType = "Bank Account";
		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		load.until (ExpectedConditions.visibilityOfAllElements (orPolicyBillingDetails.pnlAccountSelection));
		TableHandler tableAccountsHandler = new TableHandler (driver);
		load.until (ExpectedConditions.invisibilityOf (orPolicyBillingDetails.prgProgressbar));
		List<WebElement> asSection = orPolicyBillingDetails.pnlAccountSelection;
		if (!asSection.isEmpty ())
		{

			boolean booltablecontainsdata = tableAccountsHandler.verifyTableHasData ("tblAccountSelection");

			if (booltablecontainsdata == true)
			{

				tableAccountsHandler.returnRowInTable ("tblAccountSelection", strAccountType);
				PolicyBillingDetails.this.clickAssign ();

			}

			else
			{

				// List<WebElement> asSection = orPolicyBillingDetails.pnlAccountSelection;
				// if (!asSection.isEmpty()) {

				WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

				String strPCAResult = orPolicyBillingDetails.imgAccountStatus.getAttribute ("src");
				String strCurrentUrl = driver.getCurrentUrl ();
				String strfetchUrlIP = StringUtils.substringBefore (strCurrentUrl, "/Jasper");

				if (strPCAResult.contains (strfetchUrlIP + "/Jasper/images/Innovation/InnovationInsurance/baseLook/Incomplete.png"))
				{
					wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.chkOverride));
					orPolicyBillingDetails.chkOverride.click ();
				}

				if (strPCAResult.contains (strfetchUrlIP + "/Jasper/images/Innovation/InnovationInsurance/baseLook/Complete.png"))
				{
					wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnAccountAdd));
					orPolicyBillingDetails.btnAccountAdd.click ();
					;
				}

			}

			// }

			// else {
			// System.out.println("Account selection section is not available.");
			// }
		}
	}
	/*** Cybersource section ***/

	/** Billing information **/

	// Implementation not required since all fields gets populated from previous
	// information (pre-populated).
	// However, for validation purposes we can automate this section via db. Need
	// confirmation.

	/** Payment details **/
	// Card type
	public void selectCardType (String strCardType)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPolicyBillingDetails.rdoCardType));

		if (strCardType.equalsIgnoreCase ("Visa"))
		{

			List<WebElement> radiobuttons = orPolicyBillingDetails.rdoCardType;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("001"))
				{
					radiobutton.click ();
					break;
				}

			}

		}
		else
		{

			List<WebElement> radiobuttons = orPolicyBillingDetails.rdoCardType;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("00GlobalWaitTime.getIntWaitTime ()"))
				{
					radiobutton.click ();
					break;
				}

			}

		}
	}

	// Card Number
	public void typeCardNumber (String strCardNumber)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.txtCardNumber));
		orPolicyBillingDetails.txtCardNumber.sendKeys (strCardNumber);
	}

	// Expiration date month
	public void selectExpiryMonth (String strExpiryMonth)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.ddlExpirationMonth));
		orPolicyBillingDetails.ddlExpirationMonth.click ();
		Select oSelectExpiryMonth = new Select (orPolicyBillingDetails.ddlExpirationMonth);
		oSelectExpiryMonth.selectByValue (strExpiryMonth);
	}

	// Expiration date year
	public void selectExpiryYear (String strExpiryYear)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.ddlExpirationYear));
		orPolicyBillingDetails.ddlExpirationYear.click ();
		Select oSelectExpiryYear = new Select (orPolicyBillingDetails.ddlExpirationYear);
		oSelectExpiryYear.selectByValue (strExpiryYear);
	}

	// Next / Commit
	public void clickNext ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnNext));
		orPolicyBillingDetails.btnNext.click ();
	}

	// Cancel
	public void clickCancel ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnCancel));
		orPolicyBillingDetails.btnCancel.click ();
	}

	/** Review your Order **/
	// Edit address
	public void clickEditAddress ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnEditAddress));
		orPolicyBillingDetails.btnEditAddress.click ();

	}

	// Edit details
	public void clickEditDetails ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnEditDetails));
		orPolicyBillingDetails.btnEditDetails.click ();

	}

	// Back button
	public void clickBack ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnBack));
		orPolicyBillingDetails.btnBack.click ();

	}

	// Finish button
	public void clickFinish ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnFinish));
		orPolicyBillingDetails.btnFinish.click ();

	}

	// Pay
	public void clickPay ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnPay));
		orPolicyBillingDetails.btnPay.click ();
	}

	// Cancel order
	public void clickCancelOrder ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.lnkCancelOrder));
		orPolicyBillingDetails.lnkCancelOrder.click ();
	}

	// Cancel order pop up
	public void confirmCancelOrder (String strSelection)
	{

		if (strSelection.equalsIgnoreCase ("Yes") || strSelection.equalsIgnoreCase ("Y"))
		{

			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnYes));
			orPolicyBillingDetails.btnYes.click ();
		}
		else
		{

			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnNo));
			orPolicyBillingDetails.btnNo.click ();
		}
	}

	// Assign
	public void clickAssign ()
	{

		WebDriverWait load = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());

		List<WebElement> asSection = orPolicyBillingDetails.pnlAccountSelection;
		if (!asSection.isEmpty ())
		{
			WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			load.until (ExpectedConditions.visibilityOfAllElements (orPolicyBillingDetails.pnlAccountSelection));
			wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnAccountAssign));
			orPolicyBillingDetails.btnAccountAssign.click ();
		}
		else
		{
			System.out.println ("Account selection section is not available.");
		}
	}

	/*** Implementation of Make Payment section ***/

	// Proceed without payment
	public void selectProceedWithoutPayment ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.chkProceedWithoutPayment));
		orPolicyBillingDetails.chkProceedWithoutPayment.click ();
	}

	// Receipt type
	public void selectReceiptType (String strReceiptType)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.ddlReceiptType));
		Select oSelectReceiptType = new Select (orPolicyBillingDetails.ddlReceiptType);
		if (strReceiptType.equalsIgnoreCase ("Credit/debit card") || strReceiptType.equalsIgnoreCase ("Credit/ debit card") ||
			strReceiptType.equalsIgnoreCase ("CC") || strReceiptType.equalsIgnoreCase ("Card"))
		{
			orPolicyBillingDetails.ddlReceiptType.click ();
			oSelectReceiptType.selectByValue ("B");
		}
		else if (strReceiptType.equalsIgnoreCase ("Cash"))
		{
			orPolicyBillingDetails.ddlReceiptType.click ();
			oSelectReceiptType.selectByValue ("C");
		}
		else if (strReceiptType.equalsIgnoreCase ("A"))
		{
			orPolicyBillingDetails.ddlReceiptType.click ();
			oSelectReceiptType.selectByValue ("Cheque");
		}

	}

	/** <- Database Validation-> **/
	// Received from
	public void validateReceivedFrom (String strEnvironmentName) throws Exception
	{

		String strClientNum = orPolicyBillingDetails.hdnClientNumber.getAttribute ("value");
		String strSQLQuery = ClientSQL.returnBillingClientName ("8880", strClientNum);
		List<String> lstReceivedFrom_DB = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		String strReceivedFrom_DB = lstReceivedFrom_DB.get (0);
		System.out.println (strReceivedFrom_DB);
		if (strReceivedFrom_DB.equalsIgnoreCase (orPolicyBillingDetails.txtReceivedFrom.getAttribute ("value")))
		{

			System.out.println ("Database Validation for 'Received from' is successful.");
		}

		else
		{

			System.out.println ("Database Validation for 'Received from' is NOT successful.");
		}

	}

	/** When Receipt type = Cheque **/
	// Cheque Number
	public void typeChequeNumber (String strChequeNumber)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.txtChequeNumber));
		orPolicyBillingDetails.txtChequeNumber.clear ();
		orPolicyBillingDetails.txtChequeNumber.sendKeys (strChequeNumber);
	}

	// Sort Code / Transit Number
	public void typeTransitNumber (String strTransitNumber)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.txtTransitNumber));
		orPolicyBillingDetails.txtTransitNumber.clear ();
		orPolicyBillingDetails.txtTransitNumber.sendKeys (strTransitNumber);

	}

	/** When Receipt type = Credit/ debit card **/
	// Existing account
	public void selectExistingCardAccount ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.ddlExisitingAccount));
		orPolicyBillingDetails.ddlExisitingAccount.click ();
		Select oSelectExistingAccount = new Select (orPolicyBillingDetails.ddlExisitingAccount);
		oSelectExistingAccount.selectByIndex (1);
	}

	// New account
	public void selectNewAccount ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoNewAccount));
		orPolicyBillingDetails.rdoNewAccount.click ();

	}

	// Store credit card details
	public void selectStoreCreditCardDetials (String strStoreCreditCardDetials)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOfAllElements (orPolicyBillingDetails.rdoStoreCreditCardDetails));

		if (strStoreCreditCardDetials.equalsIgnoreCase ("Yes") || strStoreCreditCardDetials.equalsIgnoreCase ("Y"))
		{

			List<WebElement> radiobuttons = orPolicyBillingDetails.rdoStoreCreditCardDetails;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("Y"))
				{
					radiobutton.click ();
					break;
				}

			}

		}
		else
		{

			List<WebElement> radiobuttons = orPolicyBillingDetails.rdoStoreCreditCardDetails;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("N"))
				{
					radiobutton.click ();
					break;
				}

			}

		}

	}

	// Current balance o/s
	public void selectCurrentBalance (String strPaymentMode)
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.visibilityOf (orPolicyBillingDetails.rdoCurrentBalance_Cash));

		if (strPaymentMode.equalsIgnoreCase ("Cash"))
		{

			WebDriverWait waitForCash = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCash.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoCurrentBalance_Cash));
			orPolicyBillingDetails.rdoCurrentBalance_Cash.click ();

		}
		else if (strPaymentMode.equalsIgnoreCase ("Cheque"))
		{

			WebDriverWait waitForCheque = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCheque.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoCurrentBalance_Cheque));
			orPolicyBillingDetails.rdoCurrentBalance_Cheque.click ();
		}
		else if (strPaymentMode.equalsIgnoreCase ("CC") || strPaymentMode.equalsIgnoreCase ("Credit/ debit card"))
		{

			WebDriverWait waitForCC = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCC.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoCurrentBalance_CC));
			orPolicyBillingDetails.rdoCurrentBalance_CC.click ();
		}
		else
		{

			System.out.println ("Please specify which Receipt type you've selected.");
		}
	}

	// Total balance o/s
	public void selectTotalBalance (String strPaymentMode)
	{

		if (strPaymentMode.equalsIgnoreCase ("Cash"))
		{

			WebDriverWait waitForCash = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCash.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoTotalBalance_Cash));
			orPolicyBillingDetails.rdoTotalBalance_Cash.click ();

		}
		else if (strPaymentMode.equalsIgnoreCase ("Cheque"))
		{

			WebDriverWait waitForCheque = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCheque.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoTotalBalance_Cheque));
			orPolicyBillingDetails.rdoTotalBalance_Cheque.click ();
		}
		else if (strPaymentMode.equalsIgnoreCase ("CC") || strPaymentMode.equalsIgnoreCase ("Credit/ debit card"))
		{

			WebDriverWait waitForCC = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCC.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoTotalBalance_CC));

			orPolicyBillingDetails.rdoTotalBalance_CC.click ();
		}
		else
		{

			System.out.println ("Please specify which Receipt type you've selected.");
		}
	}

	// Last billed amount
	public void selectLastBilledAmount (String strPaymentMode)
	{

		if (strPaymentMode.equalsIgnoreCase ("Cash"))
		{

			WebDriverWait waitForCash = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCash.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoLastBilledAmount_Cash));
			orPolicyBillingDetails.rdoLastBilledAmount_Cash.click ();

		}
		else if (strPaymentMode.equalsIgnoreCase ("Cheque"))
		{

			WebDriverWait waitForCheque = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCheque.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoLastBilledAmount_Cheque));
			orPolicyBillingDetails.rdoLastBilledAmount_Cheque.click ();
		}
		else if (strPaymentMode.equalsIgnoreCase ("CC") || strPaymentMode.equalsIgnoreCase ("Credit/ debit card"))
		{

			WebDriverWait waitForCC = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCC.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoLastBilledAmount_CC));
			orPolicyBillingDetails.rdoLastBilledAmount_CC.click ();
		}
		else
		{

			System.out.println ("Please specify which Receipt type you've selected.");
		}

	}

	// Other - Select
	public void selectOtherAmount (String strPaymentMode)
	{

		if (strPaymentMode.equalsIgnoreCase ("Cash"))
		{

			WebDriverWait waitForCash = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCash.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoOther_Cash));
			orPolicyBillingDetails.rdoOther_Cash.click ();

		}
		else if (strPaymentMode.equalsIgnoreCase ("Cheque"))
		{

			WebDriverWait waitForCheque = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCheque.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoOther_Cheque));

			orPolicyBillingDetails.rdoOther_Cheque.click ();
		}
		else if (strPaymentMode.equalsIgnoreCase ("CC") || strPaymentMode.equalsIgnoreCase ("Credit/ debit card"))
		{

			WebDriverWait waitForCC = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCC.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.rdoOther_CC));
			orPolicyBillingDetails.rdoOther_CC.click ();
		}
		else
		{

			System.out.println ("Please specify which Receipt type you've selected.");
		}

	}

	// Other - Type
	public void typeOtherAmount (String strPaymentMode, double dblAmount)
	{

		if (strPaymentMode.equalsIgnoreCase ("Cash"))
		{

			WebDriverWait waitForCash = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCash.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.txtOther_Cash));
			orPolicyBillingDetails.txtOther_Cash.sendKeys (String.valueOf (dblAmount));

		}
		else if (strPaymentMode.equalsIgnoreCase ("Cheque"))
		{

			WebDriverWait waitForCheque = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCheque.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.txtOther_Cheque));
			orPolicyBillingDetails.txtOther_Cheque.sendKeys (String.valueOf (dblAmount));
		}
		else if (strPaymentMode.equalsIgnoreCase ("CC") || strPaymentMode.equalsIgnoreCase ("Credit/ debit card"))
		{

			WebDriverWait waitForCC = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
			waitForCC.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.txtOther_CC));
			orPolicyBillingDetails.txtOther_CC.sendKeys (String.valueOf (dblAmount));
		}
		else
		{

			System.out.println ("Please specify which Receipt type you've selected.");
			System.out.println ("Please type amount in numbers.");
		}

	}

	// Reset
	public void clickReset ()
	{

		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orPolicyBillingDetails.btnReset));

		orPolicyBillingDetails.btnReset.click ();
	}

	public void completeTransaction ()
	{
		SeleniumWaiter seleniumWaiter = new SeleniumWaiter (driver);
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyBillingDetails.prgProgressbar));
		wait.until (ExpectedConditions.visibilityOf (orPolicyBillingDetails.popupConfirmation));

		String strAccountReceiveable = orPolicyBillingDetails.lblReceiptNumber.getText ();
		System.out.println ("This is an Account Receiveable = " + strAccountReceiveable);

		if (orPolicyBillingDetails.popupConfirmation.isDisplayed () == true)
		{

			String strpopupTitle = orPolicyBillingDetails.popupConfirmation.getText ();
			if (strpopupTitle.contains ("Confirmation"))
			{

				orPolicyBillingDetails.btnComplete.click ();
				wait.until (ExpectedConditions.invisibilityOf (orPolicyBillingDetails.prgProgressbar));
				seleniumWaiter.waitForMe (GlobalWaitTime.getIntWaitTime ());
			}

		}

	}

	public void CreateOtherPayment ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.invisibilityOf (orPolicyBillingDetails.prgProgressbar));
		String strCurrentBalance = orPolicyBillingDetails.labelCurrentBalance.getText ();
		System.out.println ("Current Balance o/s = " + strCurrentBalance);

		int intAdditionalAmount = (RandomNumbers.randomSelect (100));
		double dblOtherValue = Double.parseDouble (strCurrentBalance);
		double dblTotalAmount = dblOtherValue + intAdditionalAmount;

		// return strGrossValueOffered;

		System.out.println ("Other Amount = " + dblTotalAmount);

		orPolicyBillingDetails.txtOther_Cash.sendKeys (String.valueOf (dblTotalAmount));

	}

	public void makeOverPamentforRefund (String strReceipt)
	{

		{
			this.selectReceiptType (strReceipt);
			this.selectOtherAmount (strReceipt);
			this.CreateOtherPayment ();
		}

	}

}
