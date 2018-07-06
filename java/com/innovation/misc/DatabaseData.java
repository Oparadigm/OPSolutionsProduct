package com.innovation.misc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.innovation.data.XMLDataReader;
import com.innovation.dbconnection.QueryRunner;

/**
 * @author PinchenJ, lushs
 *
 */
public class DatabaseData
{

	// This method passes in a SQL query as a string and returns the results.
	public static List<String> returnDatabaseValue (String strSQLQuery, String strEnvironmentName) throws Exception
	{

		String arrDatabaseConnectionString[] = arrConnectionString (strEnvironmentName);

		Connection connString = null;
		connString = QueryRunner.runQuery (arrDatabaseConnectionString[0], arrDatabaseConnectionString[1], arrDatabaseConnectionString[2],
				arrDatabaseConnectionString[3]);
		ResultSet rsData = null;
		if (connString != null)
		{
			Statement stmnt = connString.createStatement ();
			// Return the top X rows
			// stmnt.setMaxRows (1);
			// ExecuteQuery should be used for a select as it returns a result set!
			rsData = stmnt.executeQuery (strSQLQuery);
		}
		List<String> returnQueryResult = null;
		List<String> list = new ArrayList<> ();
		ResultSetMetaData rs = rsData.getMetaData ();
		int intColumnCount = rs.getColumnCount ();
		// Loop around the result set
		while (rsData.next ())
		{
			int i = 1;
			while (i <= intColumnCount)
			{
				list.add (rsData.getString (i++));
			}
		}
		returnQueryResult = list;
		connString.close ();
		System.out.println ("SQL Run: " + strSQLQuery);
		System.out.println ("SQL Results: " + returnQueryResult);
		return returnQueryResult;
	}

	// This method passes in a SQL query as a string and updates the database and returns the results.
	public static String updateDatabaseValue (String strSQLQuery, String strEnvironmentName) throws Exception
	{
		String arrDatabaseConnectionString[] = arrConnectionString (strEnvironmentName);
		Connection connString = null;
		connString = QueryRunner.runQuery (arrDatabaseConnectionString[0], arrDatabaseConnectionString[1], arrDatabaseConnectionString[2],
				arrDatabaseConnectionString[3]);
		if (connString != null)
		{
			Statement stmnt = connString.createStatement ();
			// ExecuteUpdate should be used for Update, Insert and Delete as it does not return a result set.
			int intAffectedCount = stmnt.executeUpdate (strSQLQuery);
			// System.out.println ("Number of rows affected: " + stmnt.getUpdateCount ());
			System.out.println ("SQL Run: " + strSQLQuery);
			System.out.println ("Number of rows affected: " + intAffectedCount);
		}
		connString.close ();

		return strSQLQuery;
	}

	// This method passes in the environment key to get the environment name.
	// This needs to be looked at again as we have change the concept of Environment 1 is Bungo to just the Bungo environment.
	// It also should have the environment passed into it rather than looking it up. This needs refactoring a new task has been
	// raised.
	public static String[] arrConnectionString (String strEnvironmentName)

	{
		String[] arrDatabaseConnectionDetails = new String[4];

		XMLDataReader returnXMLString = new XMLDataReader ();

		// Get the environment name to find the associated database details.
		String strElement = strEnvironmentName;
		String strNode = "Database";
		String strXMLFileName = "UrlBrowser.xml";

		// Get the database connection details for the associated environment name.

		strElement = strEnvironmentName;
		strNode = "DatabaseType";
		strXMLFileName = "DatabaseConnectionDetails.xml";

		// Database type
		arrDatabaseConnectionDetails[0] = (returnXMLString.ReturnXMLNode (strElement, strNode, strXMLFileName));

		// Get the database connection string.
		strNode = "ConnectionString";
		arrDatabaseConnectionDetails[1] = (returnXMLString.ReturnXMLNode (strElement, strNode, strXMLFileName));

		// Get the username connection string.
		strNode = "UserName";
		arrDatabaseConnectionDetails[2] = (returnXMLString.ReturnXMLNode (strElement, strNode, strXMLFileName));

		// Get the password connection string.
		strNode = "Password";
		arrDatabaseConnectionDetails[3] = (returnXMLString.ReturnXMLNode (strElement, strNode, strXMLFileName));

		return arrDatabaseConnectionDetails;
	}
}
