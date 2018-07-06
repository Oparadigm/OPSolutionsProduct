package com.innovation.misc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * @Author Tahir Akbar This class contains method to select from the Endorsements (for all LOBs) and then check iif there are any 
 * additional details need to be added like variable data
 */
public class EndorsementsAdder
{

	private WebDriver driver;

	public EndorsementsAdder (WebDriver driver)
	{
		this.driver = driver;
	}

	// The below function will locate the fields in the table and enter the variable
	// data in.
	// will enhance this function afterwards with some more dynamic data entries
	// id of table is inputContainer came from page class
	// xpath is //*[@id=\"inputContainer\"]/table[1]/tbody

	public void AddEndVariableData (String strVariableDataSection)
	{

		// Get the Table information from Endorsement Test Script
		// tr[3] - takes the 3rd row in the table as the 1st is the Filter Options, the
		// 2nd is the Column headings and the 3rd is the actual data.

		WebElement variableDataTable = driver.findElement (By.xpath ("//*[@id='" + strVariableDataSection + "']/table[1]/tbody"));
		List<WebElement> allObjects = variableDataTable.findElements (By.tagName ("tr"));
		int intObjectCount = allObjects.size ();

		for (int i = 1; i <= intObjectCount; i++)
		{

			List<WebElement> allColumnsOfTr = variableDataTable
					.findElements (By.xpath ("//*[@id='" + strVariableDataSection + "']/table[1]/tbody/tr[" + i + "]/td"));
			long lngAllColumns = allColumnsOfTr.stream ().filter (WebElement::isDisplayed).count ();

			for (long j = 2; j <= lngAllColumns; j++)
			{

				String type = driver.findElement (By.xpath ("//*[@id='" + strVariableDataSection + "']/table[1]/tbody/tr[" + i + "]/td[" + j + "]/input"))
						.getAttribute ("type");
				String datatype = driver.findElement (By.xpath ("//*[@id  ='" + strVariableDataSection + "']/table[1]/tbody/tr[" + i + "]/td[" + j + "]/input"))
						.getAttribute ("igmask");

				if (type.contains ("text"))
				{

					switch (datatype)
					{
						case "numeric":
							driver.findElement (By.xpath ("//*[@id='" + strVariableDataSection + "']/table[1]/tbody/tr[" + i + "]/td[" + j + "]/input"))
									.sendKeys (RandomNumbers.produceRandomNumber (1));
							break;

						case "alphanumeric":
							driver.findElement (By.xpath ("//*[@id='" + strVariableDataSection + "']/table[1]/tbody/tr[" + i + "]/td[" + j + "]/input"))
									.sendKeys (RandomLetters.produceRandomString (4));
							break;
					}
				}

			}

		}

	}

}
