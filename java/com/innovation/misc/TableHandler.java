package com.innovation.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.innovation.data.XMLDataReader;
import com.innovation.data.XMLElementCounter;
import com.innovation.pages.common.pages.ControlPanel;

/*
 * @Author Kamran Mahmood - This class contains methods to select row in table based on table name and text to select in table
 * @Author haiderm - implemented "clickRandomlyOnRowWithSameCellText" and "verifyTableHasData" methods.
 * 
 */
public class TableHandler
{

	private WebDriver driver;

	public TableHandler (WebDriver driver)
	{
		this.driver = driver;
	}

	// This function is to be used when the table contains multiple page of data and the row to click on could be on any of the
	// pages. Pass table id into strTableId, text to search int strRowText and number of page to check into strPageCount. Pass "All"
	// if you want to check all pages, otherwise pass number of page e.g. "3" if you want to check first 3 pages
	public boolean selectRowInTableWithPages (String strTableId, String strRowText, String strPageCount)
	{
		int intRowCount;
		int intPageCount;
		long intColumnCount;
		String strFinalXpath;
		String strFirst_part;
		String strSecond_part;
		String strThird_part;
		String strTableData;

		// Get row count of all the rows in table accross multiple pages
		intRowCount = driver.findElements (By.xpath ("//*[@id='" + strTableId + "']/tbody/tr")).size ();
		// Get row count of actual data rows as first 2 rows are for filter options and headings
		intRowCount = intRowCount - 2;

		if (strPageCount.equalsIgnoreCase ("All"))
		{
			// Calculate page count. Each page contains 10 rows
			intPageCount = intRowCount / 10;
			if (intPageCount * 10 < intRowCount)
			{
				intPageCount = intPageCount + 1;
			}
		}
		else
		{
			intPageCount = Integer.parseInt (strPageCount);
		}

		// Get number of visible columns In table.
		intColumnCount = driver.findElements (By.xpath ("//*[@id='" + strTableId + "']/tbody/tr[3]/td")).stream ().filter (WebElement::isDisplayed).count ();

		// Divided xpath In three parts to pass the row number and column number as parameters
		strFirst_part = "//*[@id='" + strTableId + "']/tbody/tr[";
		strSecond_part = "]/td[";
		strThird_part = "]";

		// Traverse each page to find out the row with data for selection
		for (int i = 0; i < intPageCount; i++)
		{

			// Calculate starting and ending row numbers for each page
			int intPageStartRow = i * 10 + 3;
			int intPageEndRow = i * 10 + 2 + 10;

			// Used for loop for number of rows in given page
			for (int k = intPageStartRow; k <= intPageEndRow; k++)
			{
				// Used for loop for number of columns in given page
				for (int j = 1; j <= intColumnCount; j++)
				{
					// Prepared final xpath of specific cell as per values of k and
					// j for each of data cell in the table
					strFinalXpath = strFirst_part + k + strSecond_part + j + strThird_part;
					// Get the value from the cell in the table
					strTableData = driver.findElement (By.xpath (strFinalXpath)).getText ();
					// If the value in the cell matches the value passed as parameter then click on the cell to select the row and
					// then return
					if (strTableData.contains (strRowText))
					{
						driver.findElement (By.xpath ("//*[@id='" + strTableId + "']/tbody[1]/tr[" + k + "]/td[" + j + "]")).click ();
						return true;
					}
				}

			}

			ControlPanel controlpanel = new ControlPanel (driver);
			controlpanel.clickNextPageInTable ();
		}
		return false;
	}

	public void returnRowInTable (String strTableName, String strRowText)
	{
		// Get the Table data
		// tr[3] - takes the 3rd row in the table as the 1st is the Filter
		// Options, the
		// 2nd is the Column headings and the 3rd is the actual data.
		int Row_count = driver.findElements (By.xpath ("//*[@id='" + strTableName + "']/tbody/tr")).size ();
		// Get number of visible columns In table.
		long Col_count = driver.findElements (By.xpath ("//*[@id='" + strTableName + "']/tbody/tr[3]/td")).stream ().filter (WebElement::isDisplayed).count ();
		// divided xpath In three parts to pass Row_count and Col_count values.
		String strFirst_part = "//*[@id='" + strTableName + "']/tbody/tr[";
		String strSecond_part = "]/td[";
		String strThird_part = "]";

		// Used for loop for number of rows.
		for (int k = 3; k <= Row_count; k++)
		{
			// Used for loop for number of columns.
			for (int j = 1; j <= Col_count; j++)
			{
				// Prepared final xpath of specific cell as per values of k and
				// j.
				String final_xpath = strFirst_part + k + strSecond_part + j + strThird_part;
				// Will retrieve value from located cell and print It.
				String Table_data = driver.findElement (By.xpath (final_xpath)).getText ();
				if (Table_data.contains (strRowText))
				{
					driver.findElement (By.xpath ("//*[@id='" + strTableName + "']/tbody[1]/tr[" + k + "]/td[" + j + "]")).click ();
					// break;
					return;
				}
			}

		}

	}

	// This function can be used for quick execution and we can modify it later
	// as
	// things progresses
	public void returnRowInTableWithText (String strTableNameWithText, String strRowText)

	{
		// This will find table based on input parameter
		WebElement oTable = driver.findElement (By.id (strTableNameWithText.trim ()));
		// This will find row with xpath of the row to be clicked based on
		// Visible Text
		// passed as parameter
		WebElement oRow = oTable.findElement (By.xpath ("//tr/td[contains(text(), '" + strRowText + "')]"));
		// This will click on the table row
		oRow.click ();

	}

	// Clicks randomly on a row with some text similar to other rows
	public void clickRandomlyOnRowWithSameCellText (String strTableName, String strRowText)
	{

		int intRowCount = driver.findElements (By.xpath ("//table[@class='" + strTableName + "']" + "/tbody/tr")).size ();
		long lngColCount = driver.findElements (By.xpath ("//table[@class='" + strTableName + "']" + "/tbody/tr[3]/td")).stream ()
				.filter (WebElement::isDisplayed).count ();
		String strFirst_part = "//table[@class='" + strTableName + "']" + "/tbody/tr[";
		String strSecond_part = "]/td[";
		String strThird_part = "]";
		// Store every found element in an array of type WebElement
		List<WebElement> lstCellsWithSameText = new ArrayList<> ();
		for (int k = 3; k < (intRowCount - 2); k++)
		{
			for (int j = 1; j <= lngColCount; j++)
			{
				String strFinal_xpath = strFirst_part + k + strSecond_part + j + strThird_part;
				String strTable_data = driver.findElement (By.xpath (strFinal_xpath)).getText ();
				if (strTable_data != null && strTable_data.equalsIgnoreCase (strRowText))
				{
					WebElement strCellText = driver.findElement (By.xpath ("//table[@class='" + strTableName + "']/tbody[1]/tr[" + k + "]/td[" + j + "]"));

					lstCellsWithSameText.add (strCellText);
				}
			}
		}

		if (lstCellsWithSameText.size () > 0)
		{
			Random tdRandom = new Random ();
			int intRandomCell = tdRandom.nextInt (lstCellsWithSameText.size ());
			lstCellsWithSameText.get (intRandomCell).click ();
		}
	}

	// @auther Rizwan. This function clicks on a random row in the table and
	// takes table id as parameter.
	public void clickRandomTableRow (String strTableId)
	{
		// Table rows that are displayed are counted including the header row
		// that contains column headings. 1 is added to include the first hidden
		// row.
		int intTableRowCount = (int) driver.findElements (By.xpath ("//table[@id='" + strTableId + "']" + "/tbody/tr")).stream ()
				.filter (WebElement::isDisplayed).count () +
			1;
		// 3rd row is the first record so 3 and row count is passed to generate
		// a random number
		int intRandomRowNo = RandomNumbers.randomNumberGenerator (3, intTableRowCount);
		WebElement oRandomRow = driver.findElement (By.xpath ("//*[@id='" + strTableId + "']/tbody[1]/tr[" + intRandomRowNo + "]/td[1]"));
		oRandomRow.click ();
	}

	public void clickRandomTableRowWithText (String strTableId, String strStatus)
	{
		// Table rows that are displayed are counted including the header row
		// that contains column headings. 1 is added to include the first hidden
		// row.
		int intTableRowCount = (int) driver.findElements (By.xpath ("//table[@id='" + strTableId + "']" + "/tbody/tr")).stream ()
				.filter (WebElement::isDisplayed).count () +
			1;
		// 3rd row is the first record so 3 and row count is passed to generate
		// a random number
		int intRandomRowNo = RandomNumbers.randomNumberGenerator (3, intTableRowCount);
		WebElement oRandomRow = driver.findElement (By.xpath ("//*[@id='" + strTableId + "']/tbody[1]/tr[" + intRandomRowNo + "]/td[1]"));
		oRandomRow.click ();
	}

	// This function takes table id, a string value to search and number of rows to check as parameters. It returns true if a cell
	// from the specified rows of the table (a record) contains string value otherwise it returns false. To check all rows, pass
	// "All" otherwise pass number of rows to strRowCount parameter e.g. strRowCount = "10" to check first 10 rows
	public boolean checkTableHasRecords (String strTableId, String strRowText, String strRowCount)
	{
		int Row_count;
		if (strRowCount.equalsIgnoreCase ("All"))
		{
			// Get number of rows in table.
			Row_count = driver.findElements (By.xpath ("//*[@id='" + strTableId + "']/tbody/tr")).size ();
		}
		else
		{
			int intRowCount = Integer.parseInt (strRowCount);
			// 2 added here as the first row in the table is row number 3
			Row_count = intRowCount + 2;
		}
		// Get number of visible columns In table.
		long Col_count = driver.findElements (By.xpath ("//*[@id='" + strTableId + "']/tbody/tr[3]/td")).stream ().filter (WebElement::isDisplayed).count ();
		// divided xpath In three parts to pass Row_count and Col_count values.
		String strFirst_part = "//*[@id='" + strTableId + "']/tbody/tr[";
		String strSecond_part = "]/td[";
		String strThird_part = "]";

		// Used for loop for number of rows. Starts from the 3rd row in the table as the
		// 1st is the Filter Options, the
		// 2nd is the Column headings and the 3rd is the actual data.
		for (int k = 3; k <= Row_count; k++)
		{
			// Used for loop for number of columns.
			for (int j = 1; j <= Col_count; j++)
			{
				// Prepared final xpath of specific cell as per values of k and j.
				String final_xpath = strFirst_part + k + strSecond_part + j + strThird_part;
				// Will retrieve value from located cell and if it matches with the parameter
				// value, it will return true, otherwise
				// will return false
				String Table_data = driver.findElement (By.xpath (final_xpath)).getText ();
				if (Table_data.contains (strRowText))
				{
					return true;
				}
			}

		}
		return false;
	}

	// Check if the table has any row with data populated
	public boolean verifyTableHasData (String strTableName)
	{

		boolean blnDataFound = false;

		int tableRows = driver.findElements (By.xpath ("//*[@id='" + strTableName + "']" + "/tbody/tr")).size ();

		for (int k = 3; k <= tableRows;)
		{

			WebElement row = driver.findElement (By.xpath ("//*[@id='" + strTableName + "']" + "/tbody/tr[" + k + "]"));
			long lngColCount = row.findElements (By.tagName ("td")).stream ().filter (WebElement::isDisplayed).count ();
			if (lngColCount > 2)
			{

				blnDataFound = true;
				System.out.println ("data is present");
				break;

			}
			else
			{

				blnDataFound = false;
				System.out.println ("data is not present");
				break;

			}

		}

		return blnDataFound;

	}

	// @Author M.Tahir Akbar, This function can be used in filling up the
	// details of
	// Policy Endorsements
	// The below function will locate the fields in the table and enter the
	// variable
	// data in.
	// will enhance this function afterwards with some more dynamic data entries
	// id of table is inputContainer came from page class
	// xpath is //*[@id=\"inputContainer\"]/table[1]/tbody

	public void addEndVariableData (String strVariableDataSection)
	{

		// Get the Table information from Endorsement Test Script
		// tr[3] - takes the 3rd row in the table as the 1st is the Filter
		// Options, the
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

	// @Author M.Tahir Akbar, The following function can be used to check the
	// completeness indicator
	// for Driver as well as Vehicle if there are any details left and yet to be
	// entered in the System

	public int completenessChecker (String strTableName)
	{

		WebElement driversList = driver.findElement (By.xpath ("//*[@id='" + strTableName + "']/tbody"));
		List<WebElement> allRows = driversList.findElements (By.tagName ("tr"));
		int intTotalRows = allRows.size ();
		int intFlag = 1;

		for (int i = 3; i <= intTotalRows; i++)
		{

			List<WebElement> allColumns = driversList.findElements (By.xpath ("//*[@id='" + strTableName + "']/tbody/tr[" + i + "]/td"));
			long lngAllColumns = allColumns.stream ().filter (WebElement::isDisplayed).count ();

			for (long j = 1; j <= lngAllColumns; j++)
			{

				String strImageTDID = driversList.findElement (By.xpath ("//*[@id= '" + strTableName + "']/tbody/tr[" + i + "]/td[" + j + "]"))
						.getAttribute ("id");

				if (strImageTDID.equals ("DETIND") || strImageTDID.equals ("DRVDETIND"))
				{

					String strImageState = driversList.findElement (By.xpath ("//*[@id= '" + strTableName + "']/tbody/tr[" + i + "]/td[" + j + "]/img"))
							.getAttribute ("alt");

					if (strImageState.equals ("true"))
					{
						intFlag = 1;
					}
					if (strImageState.equals ("false"))
					{
						driversList.findElement (By.xpath ("//*[@id= '" + strTableName + "']/tbody/tr[" + i + "]/td[" + j + "]")).click ();
						intFlag = 0;

					}

				}

			}

		}
		return intFlag;
	}

	// @Author M.Tahir Akbar, The following function can be used to check the
	// Vehicle records from CarWeb

	public String vehicleSearchSelect (String strElement, String strNodeMake, String strXMLFileName)
	{

		XMLDataReader returnXMLString = new XMLDataReader ();
		XMLElementCounter returnXMLElementCount = new XMLElementCounter ();

		// Return a random id row of Vehicle Make
		Integer intMakeElement = (returnXMLElementCount.ReturnXMLElementCount (strNodeMake, strXMLFileName));

		// Get the user details for the supplied random id intElement.
		String strMake = returnXMLString.ReturnXMLNode (strElement + intMakeElement, strNodeMake, strXMLFileName);

		return strMake;

	}

}
