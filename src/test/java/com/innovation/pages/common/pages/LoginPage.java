/**
 * 
 */
package com.innovation.pages.common.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innovation.data.XMLDataReader;
import com.innovation.data.XMLElementCounter;
import com.innovation.misc.DatabaseData;
import com.innovation.misc.GlobalWaitTime;
import com.innovation.misc.LoggingControl;
import com.innovation.pages.common.objects.OR_LoginPage;
import com.innovation.sql.users.LoginSQL;

/**
 * @author lushs This class will store all the locators and methods of the Login page.
 */

public class LoginPage
{

	private WebDriver		driver;
	private LoggingControl	loggingcontrol	= new LoggingControl ();
	private OR_LoginPage	orLoginPage		= null;

	public LoginPage (WebDriver driver)
	{
		this.driver = driver;
		orLoginPage = PageFactory.initElements (driver, OR_LoginPage.class);

	}

	// This method gets a random ordered SQL Query from the database. It then picks a random item from the list.

	public String getUsersFromDatabase (String strEnvironmentName) throws Exception
	{
		String strSQLQuery = LoginSQL.getRandomLoginAccounts ();

		System.out.println (DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName));
		List<String> resultsListString = DatabaseData.returnDatabaseValue (strSQLQuery, strEnvironmentName);
		System.out.println (resultsListString);
		String random = resultsListString.get (new Random ().nextInt (resultsListString.size ()));
		System.out.println (random);

		return random;

	}

	public void typeUserNamePassword (String strElement, String strNodeUsername, String strNodePassword, String strXMLFileName, String strEnvironmentName)
	{

		XMLDataReader returnXMLString = new XMLDataReader ();
		XMLElementCounter returnXMLElementCount = new XMLElementCounter ();

		loggingcontrol.ConsoleLogger (new Object ()
		{
		}.getClass ().getEnclosingMethod ().getName (), driver);

		// Return a random id row to login with
		Integer intElement = (returnXMLElementCount.ReturnXMLElementCount (strNodeUsername, strXMLFileName));

		// Get the user details for the supplied random id intElement.
		String strUserName = returnXMLString.ReturnXMLNode (strElement + intElement, strNodeUsername, strXMLFileName);

		System.out.println ("UserName is: " + strUserName);

		// Get the SQL to update the database users.
		String strSQLPath = LoginSQL.updateLoginAccounts (strUserName);
		try
		{
			// Pass in the user count update SQL
			DatabaseData.updateDatabaseValue (strSQLPath, strEnvironmentName);
			// Work around for Parallel running
			strSQLPath = LoginSQL.updateUserCount ();
			DatabaseData.updateDatabaseValue (strSQLPath, strEnvironmentName);

		}

		catch (Exception e1)

		{
			e1.printStackTrace ();
		}

		// Get focus on the field.
		orLoginPage.txtUsernameField.click ();
		orLoginPage.txtUsernameField.sendKeys (strUserName);
		// Get the password for the user and then send it in.
		orLoginPage.txtPasswordField.sendKeys (returnXMLString.ReturnXMLNode (strElement + intElement, strNodePassword, strXMLFileName));

	}

	public void clickLoginButton ()
	{
		WebDriverWait wait = new WebDriverWait (driver, GlobalWaitTime.getIntWaitTime ());
		wait.until (ExpectedConditions.elementToBeClickable (orLoginPage.btnLogin));
		orLoginPage.btnLogin.click ();
	}

}
