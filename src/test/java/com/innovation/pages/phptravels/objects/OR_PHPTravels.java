package com.innovation.pages.phptravels.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * 
 * Written by M.Tahir Akbar Khan
 */
public class OR_PHPTravels {

	// ------------------The following objects are related to the PHP Travels
	// Website First Page ------------------------------------------------
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[.='Flights']")
	public WebElement lnkFlights;

	@FindBy(how = How.XPATH, using = "//span[.='Enter City Or Airport']")
	public WebElement spnEnterCity;

	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']/div/input[1]")
	public WebElement txtCityName;

	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']/ul/li[1]")
	public WebElement resultCity;

	@CacheLookup
	@FindBy(how = How.ID, using = "s2id_location_to")
	public WebElement txtLocationTo;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='flights']/form/div[3]/div/input")
	public WebElement dtpDateOfFlight;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='flights']/form/div[6]/button")
	public WebElement btnPickFlight;

	// --------------------- Now we are on the Booking page and we are going to book
	// a flight---------------------------------

	@CacheLookup
	@FindBy(how = How.ID, using = "bookbtn")
	public WebElement btnBookFlight;

	@CacheLookup
	@FindBy(how = How.NAME, using = "firstname")
	public WebElement txtFirstName;

	@CacheLookup
	@FindBy(how = How.NAME, using = "lastname")
	public WebElement txtLastName;

	@CacheLookup
	@FindBy(how = How.NAME, using = "email")
	public WebElement txtEmail;

	@CacheLookup
	@FindBy(how = How.NAME, using = "confirmemail")
	public WebElement txtConfirmEmail;

	@CacheLookup
	@FindBy(how = How.NAME, using = "phone")
	public WebElement txtPhoneNumber;

	@CacheLookup
	@FindBy(how = How.NAME, using = "address")
	public WebElement txtAddress;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[.='Select Country']")
	public WebElement spnCountry;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']/div/input")
	public WebElement txtCountryOfOrigin;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html/body/div[10]/ul")
	public WebElement txtSelectedCountry;

	@CacheLookup
	@FindBy(how = How.CLASS_NAME, using = "btn-success")
	public WebElement btnSubmitInformation;

	// ---------------------- Now Download the System Generate Invoice and and
	// complete the flow-------------------------------

	@CacheLookup
	@FindBy(how = How.ID, using = "downloadInvoice")
	public WebElement btnDownloadInvoice;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "btn-default")
	public WebElement btnGotoHome;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "/html/body/nav/div/div[1]/a/img")
	public WebElement lnkPHPTravels;

}
