package com.innovation.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB2Connection
{

	public static Connection openDBConnection (String url, String user, String password)
	{
		try
		{
			Class.forName ("com.ibm.db2.jcc.DB2Driver");
			System.out.println ("Database Connection String= " + url);
			return DriverManager.getConnection (url, user, password);

		}
		catch (Exception ex)
		{
			ex.printStackTrace ();
		}
		return null;
	}

}
