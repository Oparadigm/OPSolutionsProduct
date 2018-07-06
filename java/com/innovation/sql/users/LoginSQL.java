/**
 * 
 */
package com.innovation.sql.users;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author
 *
 */
public class LoginSQL
{
	public static String updateLoginAccounts (String strUserName)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		String strCurrentDate = dateFormat.format (new Date ());
		String strSQLQuery =
								"update logn.accounts set logincount = -9, DTECHANGED = '" + strCurrentDate + "', LOGONFAILURECOUNT = 0 where username like '" +
									strUserName + "'";
		return strSQLQuery;

	}

	public static String getRandomLoginAccounts ()
	{

		String strSQLQuery = "Select UserName from LOGN.accounts where username like 'SELENIUM%' and logincount <= '0'";
		return strSQLQuery;

	}

	public static String updateUserCount ()
	{

		String strSQLQuery = "Update LOGN.accounts set logincount = '-9' where username like 'SELENIUM%'";
		return strSQLQuery;

	}

}
