package com.innovation.sql.moj;

/**
 * @author haiderm - This class contains all methods that query to MOJ related data in the database.
 *
 */
public class MOJSQL
{
	// Query for retrieving 1insurer Claim reference number by passing MOJ Claim
	// number
	public static String return1insurerClaimReferenceNumber (String strMOJClaimNumber)
	{

		String str1insurerClaimReferenceNumber = "SELECT TRIM(INSURERCLAIMREFERENCENUMBER) FROM MOJ.MOJCLAIM WHERE MOJCLAIMNUMBER = '"

			+ strMOJClaimNumber + "'";

		return str1insurerClaimReferenceNumber;
	}

	// Query for retrieving Phase Cache Code
	public static String returnPhaseCacheCode (String strMOJClaimNumber)
	{

		String strPhaseCacheCode = "SELECT RTRIM(LTRIM(PHASECACHECODE)) FROM MOJ.MOJCLAIM WHERE MOJCLAIMNUMBER = '" + strMOJClaimNumber + "'";

		return strPhaseCacheCode;
	}

	// Query for retrieving SelectedTimeoutDate / Days remaining in current phase
	public static String returnSelectedTimeoutDate (String strMOJClaimNumber)
	{

		String strSelectedTimeoutDate = "SELECT RTRIM(LTRIM(SELECTEDTIMEOUTDATE)) FROM MOJ.MOJCLAIM WHERE MOJCLAIMNUMBER = '" + strMOJClaimNumber + "'";

		return strSelectedTimeoutDate;
	}

	// Query in TIGCOM.AUDIT Table to retrieve MOJ Audit
	public static String returnEventCodeOnAuditTableForMOJ (String strInsurerClaimNumber, String strAuditText)
	{
		strInsurerClaimNumber = strInsurerClaimNumber.trim ();
		String strEventCode = "SELECT RTRIM(LTRIM(EVENTCODE)) FROM TIGCOM.AUDIT WHERE PARENTREF = '" + strInsurerClaimNumber + "'" + " AND TEXT LIKE '%" +
			strAuditText + "%'";
		return strEventCode;
	}

	// This would return Transaction Id when after Refresh data button click on MOJ claims frame, the MOJ claim number passed as
	// parameter is loaded in the DB
	public static String returnTransIdForMOJClaimAfterRefreshData (String strMOJClaimNumber)
	{

		String strTransId = "SELECT TRANSID FROM MOJ.MOJCLAIM WHERE MOJCLAIMNUMBER = '"

			+ strMOJClaimNumber + "'";

		return strTransId;
	}

}
