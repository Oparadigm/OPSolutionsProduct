/**
 * 
 */
package com.innovation.sql.claims;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author PinchenJ
 *
 */
public class ClaimsSQL
{

	public static String returnLatestClaimRef ()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Calendar cal = Calendar.getInstance ();

		// Substract 15 days to current date.
		cal = Calendar.getInstance ();
		cal.add (Calendar.DATE, -15);
		String strCurrentDate = dateFormat.format (new Date ());
		String strFifteenDaysbefore = dateFormat.format (cal.getTime ());

		String strSQLQuery = "select Claimnum from claim.claim where notificationdate >= '" + strFifteenDaysbefore + "' and notificationdate <='" +
			strCurrentDate + "' order by NEWID() ";
		return strSQLQuery;

	}
}
