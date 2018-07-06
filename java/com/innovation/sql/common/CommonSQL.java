package com.innovation.sql.common;

/*
 * @author  Rizwan - this class stores all the SQL queries that are to be used for the data in common areas of application 
 *  
 */
public class CommonSQL
{

	// tigcom.uservacation table keeps records of public holidays. This query will return the value of vacationtypecode from the
	// table for a specific region/location and date value. If vacationtypecode is 1, it means date is a Public Holiday
	public static String returnNonWorkingDay (String strLocation, String strDate) throws Exception
	{
		String strSQLQuery = "select vacationtypecode from  tigcom.uservacation where username = '" + strLocation + "' and startdate = '" + strDate +
			"' and removeindicator = '0'";
		return strSQLQuery;
	}

	// This SQL returns status of MOJ Claims Refresh Data service. If status is 0, service is running, otherwise it is not running
	public static String returnMOJClaimsRefreshDataStatus ()
	{
		String strSQLQuery = "select statuscode from interfacecontrol.interfaceexecution where  messagequalifiedname = 'MOJ.GETCLAIMSLIST' and statuscode >= '0' order by statuscode ASC";
		return strSQLQuery;
	}
}
