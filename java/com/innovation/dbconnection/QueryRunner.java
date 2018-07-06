package com.innovation.dbconnection;

import java.sql.Connection;

public class QueryRunner
{
	public static Connection runQuery (String dbType, String url, String username, String password) throws Exception
	{
		Connection conn = null;

		if (dbType.equalsIgnoreCase ("DB2"))
		{
			conn = DB2Connection.openDBConnection (url, username, password);

		}
		else if (dbType.equalsIgnoreCase ("SQLServer"))
		{
			conn = SQLConnection.openDBConnection (url, username, password);
		}

		return conn;
	}

}
