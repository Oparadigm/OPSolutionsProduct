package com.innovation.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection
{

	public static Connection openDBConnection (String url, String user, String password)
	{

		try
		{
			return DriverManager.getConnection (url, user, password);
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		return null;
	}

}
