package com.innovation.pages.claim.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Kamal - defining the objects for Payee frame in Claims BO Log Payment flow. 
 */

public class OR_ClaimLogPaymentPayee
{

	@CacheLookup
	@FindBy(how = How.ID, using = "CLM_SC_BO__Payee")
	public WebElement		tblPayee;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='CLM_SC_BO__Payee']/tbody/tr")
	public List<WebElement>	tblPayeeRows;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='CLM_SC_BO__Payee']/tbody/tr[3]/td")
	public List<WebElement>	tblPayeeColumns;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"divPayeeList\"]/table[2]/tbody/tr/td[2]/div[1]/button")
	public WebElement		btnAddSupplier;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id=\"divPayeeList\"]/table[2]/tbody/tr/td[2]/div[2]/button")
	public WebElement		btnAddRepresentative;

}
