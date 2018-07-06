package com.innovation.regressionsuite.todelete;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.misc.Parallelized;
import com.innovation.misc.GridParallelTestBase;

@RunWith(Parallelized.class) // the runner class
public class Test_AddIndividualClient_SeleniumGrid extends GridParallelTestBase {

	// Constructor
	public Test_AddIndividualClient_SeleniumGrid(String browserName) {
		super(browserName);
	}

	@Test
	public void AddIndividualClient() throws InterruptedException {

		setPlatform(Platform.WIN10);

		System.out.println("Test is started for: " + browserName);

		driver.get("http://10.2.64.3:9080/Jasper/");
		driver.manage ().window ().maximize ();
		driver.findElement(By.id("username")).sendKeys("haiderm");
		driver.findElement(By.id("password")).sendKeys("Nightowl09");
		driver.findElement(By.name("Login")).click();
		// Restore all
		driver.findElement(By.xpath("//div[@id='igLegend3']/div[4]/div[1]/button")).click();
		// Apply
		driver.findElement(By.xpath("//div[@id='igLegend3']/div[4]/div[3]/button")).click();

		// Change Brand
		System.out.println("Changing Environment Brand");

		driver.findElement(By.linkText("Change brand")).click();
		Thread.sleep(3000);

		Select ChangeBrand = new Select(driver.findElement(By.cssSelector("#userBrandCombo")));
		ChangeBrand.selectByVisibleText("Model Office UK");
		driver.findElement(By.cssSelector("#changeUserBrandSave")).click();
		Thread.sleep(6000);
		// Search functionality
		driver.findElement(By.linkText("Search")).click();
		driver.findElement(By.linkText("Policy client search")).click();
		System.out.println("Searching for the Client");

		driver.findElement(By.id("SC_ClientSearch_LastName")).sendKeys("abc");

		driver.findElement(By.id("SC_ClientSearch_FirstName")).sendKeys("abc");

		driver.findElement(By.id("SC_ClientSearch_PostCode")).sendKeys("S016 9AA");

		// Click on Search button

		driver.findElement(By.xpath("//*[@id='container']/div[3]/table/tbody/tr/td/div[1]/button")).click();
		System.out.println("Client Not Found");

		// Create Individual Client
		WebElement AddIndividual = driver.findElement(By.cssSelector("#btnAddIndividualClient"));
		// System.out.println(AddIndividual.isEnabled());
		Thread.sleep(5000);
		System.out.println(AddIndividual.isEnabled());

		driver.findElement(By.cssSelector("#btnAddIndividualClient")).click();
		Thread.sleep(5000);
		// Complete All Mandatory fields
		// Title
		System.out.println("Creating New Individual Client");

		Select Title = new Select(driver.findElement(By.id("ClientAdd_NameTitle_1a")));
		Title.selectByVisibleText("Mr");

		driver.findElement(By.cssSelector("#ClientAdd_FirstNm_1a")).clear();

		driver.findElement(By.cssSelector("#ClientAdd_FirstNm_1a")).sendKeys("Majid");

		driver.findElement(By.cssSelector("#ClientAdd_LastNm_1a")).clear();

		driver.findElement(By.cssSelector("#ClientAdd_LastNm_1a")).sendKeys("Khan");
		// Enter E-mail Address

		driver.findElement(By.id("ClientAdd_OfficeEmail_1a")).sendKeys("tafseer.haider@ei.1insurer.com");
		// QAS - Quick Address Search

		driver.findElement(By.id("SC_Search_Criteria")).clear();
		driver.findElement(By.id("SC_Search_Criteria")).sendKeys("BL6 7AU");
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("#searchLocationIcon")).click();
		// Select Address

		Select QAS = new Select(driver.findElement(By.cssSelector("#SC_Search_Results")));
		Thread.sleep(5000);
		QAS.selectByIndex(1);
		// QAS.selectByVisibleText("Victoria Sandwich, 67 Lee Lane, Horwich, BOLTON BL6
		// 7AU");
		Thread.sleep(3000);
		// Enter Date of Birth
		driver.findElement(By.id("SC_ClientDetailsMaintain_DOB")).clear();
		//driver.findElement(By.id("SC_ClientDetailsMaintain_DOB")).click();

		driver.findElement(By.id("SC_ClientDetailsMaintain_DOB")).sendKeys("05/05/1988");
		// Select Gender

		Select Gender = new Select(driver.findElement(By.id("SC_ClientDetailsMaintain_Gender")));
		Gender.selectByVisibleText("Male");

		// Select Marital Status

	Select MStatus = new Select(driver.findElement(By.id("SC_ClientDetailsMaintain_MaritalStatus")));
	MStatus.selectByVisibleText("Single");
//
//		// Select Occupation Details
//
//		Select Occupation = new Select(driver.findElement(By.cssSelector("#SC_ClientDetailsMaintain_Occupation")));
//		Thread.sleep(8000);
//		Occupation.selectByIndex(2);
//
//		Select OccuBusType = new Select(
//				driver.findElement(By.cssSelector("#SC_ClientDetailsMaintain_Occupation_Business_Type")));
//		Thread.sleep(8000);
//		OccuBusType.selectByIndex(2);
//
//		Select SecEmp = new Select(
//				driver.findElement(By.cssSelector("#SC_ClientDetailsMaintain_Secondary_Occupation")));
//		Thread.sleep(8000);
//		SecEmp.selectByIndex(2);
//
//		Select SecEmpBusType = new Select(
//				driver.findElement(By.cssSelector("#SC_ClientDetailsMaintain_Secondary_Occupation_Business_Type")));
//		Thread.sleep(8000);
//		SecEmpBusType.selectByIndex(2);
//
		Select Lang = new Select(driver.findElement(By.cssSelector("#SC_ClientDetailsMaintain_Language")));
		Thread.sleep(3000);
		Lang.selectByVisibleText("English (UK)");
		
		// Proceed
		Thread.sleep(3000);
		driver.findElement(By.className("igFlowNext")).click();

		// Handle Pop-ups
		try {
			List<WebElement> AddToHousehold = new WebDriverWait(driver, 10).until(
					ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#igUserInteractResponseYes")));
			if (!AddToHousehold.isEmpty()) {
				AddToHousehold.get(0).click();
			}
		} catch (TimeoutException e) {

			e.printStackTrace();
		}

		Thread.sleep(3000);
		System.out.println("Signing out from the Application");
		driver.findElement(By.linkText("(Sign out)")).click();
		Thread.sleep(3000);
		System.out.println("Closing off the Chrome Browser");
		driver.quit();
	}
}