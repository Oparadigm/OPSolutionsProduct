package com.innovation.sql.client;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author haiderm - This class contains all methods that query to client related data in the database.
 *
 */

public class ClientSQL
{

	// Query for retrieving Billing Client Name
	public static String returnBillingClientName (String strCompany, String strClientNumber)
	{

		String strClient = "SELECT TRIM(CLIENT) FROM CLIENT.CLIENT WHERE COMPANY = '" + strCompany + "' AND SEQCLTNO = '" + strClientNumber +
			"' AND TYPEOFCLT = 'I'";
		String strBillingClientName = "SELECT (TRIM(TITLE)||' ' || FIRSTNAME||' '|| SURNAME) AS FULLNAME FROM CLIENT.NAME WHERE CLIENT = (" + strClient +
			") AND NAMETYPE = 'LN'";
		return strBillingClientName;

	}

	// Query for retrieving Billing Address
	public static String returnBillingAddress (String strCompany, String strClientNumber)
	{

		String strClient = "SELECT TRIM(CLIENT) FROM CLIENT.CLIENT WHERE COMPANY = '" + strCompany + "' AND SEQCLTNO = '" + strClientNumber +
			"' AND TYPEOFCLT = 'I'";
		String strAddressReference = "SELECT TRIM(ADDRREF) AS ADDRESSREFERENCE FROM CLIENT.ADDRREF WHERE CLIENT =(" + strClient + ")";

		String strBillingAddress = "SELECT (ADDRLINE1 ||' ' || ADDRLINE2 ||' '|| ADDRLINE3 ||' '|| UCCITY ||' '|| STATE ||' '|| POSTCODE) AS BILLINGADDRESS FROM CLIENT.ADDRESS WHERE ADDRREF =(" +
			strAddressReference + ")";
		return strBillingAddress;

	}

	// Query for retrieving Existing Client.
	public static String returnExistingClient (String strCompany, String strState)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Calendar cal = Calendar.getInstance ();

		// Substract 15 days to current date.
		cal = Calendar.getInstance ();
		cal.add (Calendar.DATE, -5);
		String strCurrentDate = dateFormat.format (new Date ());
		String strFifteenDaysbefore = dateFormat.format (cal.getTime ());

		/*
		 * String strClient = "SELECT H.Client, N.FirstName,N.SurName, A.Postcode FROM CLIENT.NAME N, CLIENT.CLTTH H,\r\n" +
		 * " CLIENT.ADDrref A,Client.Address AD,CLIENT.CLIENT CLT WHERE CLT.CLIENT = H.CLIENT and H.CLIENT = N.CLIENT AND H.CLTTRNNO = 1 and H.Client = A.Client\r\n "
		 * + "and A.postcode = AD.postcode and a.ADDrref = ad.ADDrref and AD.state = 'GB' and N.company = '" + strCompany +
		 * "'AND H.TRANDATE >= '" + strFifteenDaysbefore + "'AND H.TRANDATE <='" + strCurrentDate +
		 * "'and FirstName != '' and SurName != '' and CLT.LastAgent = '0' and CLT.BirthDTE != '99999999' GROUP BY H.Client,\r\n " +
		 * "N.FirstName,N.SurName, A.Postcode, CLT.CLIENT order by NEWID()" + "";
		 */

		String strClient = "  SELECT  CLTNAME.COMPANY \r\n" + "        , CLTNAME.CLIENT\r\n" + "            , CLTNAME.FIRSTNAME\r\n" +
			"            , CLTNAME.SURNAME\r\n" + "            , ADDRREF.POSTCODE\r\n" + "            , CLIENT.BIRTHDTE\r\n" +
			"  FROM CLIENT.NAMELATEST AS CLTNAME\r\n" + "  INNER JOIN   CLIENT.ADDRREFLATEST AS ADDRREF\r\n" + "  ON CLTNAME.CLIENT = ADDRREF.CLIENT \r\n" +
			"  AND CLTNAME.COMPANY = ADDRREF.COMPANY\r\n" + "  /* limit to client with single HA address */\r\n" + "  INNER JOIN \r\n" + "    (\r\n" +
			"            SELECT   CLIENT\r\n" + "                   , COMPANY\r\n" + "                   , ADDRTYPE\r\n" +
			"            FROM CLIENT.ADDRREFLATEST\r\n" + "            WHERE ADDRTYPE = 'HA'\r\n" + "            GROUP BY CLIENT\r\n" +
			"                   , COMPANY\r\n" + "                   , ADDRTYPE\r\n" + "            HAVING COUNT(*) = 1\r\n" +
			"      )   AS SINGLE_ADDRREF\r\n" + "  ON SINGLE_ADDRREF.CLIENT = ADDRREF.CLIENT\r\n" + "  AND SINGLE_ADDRREF.COMPANY = ADDRREF.COMPANY\r\n" +
			"  AND SINGLE_ADDRREF.ADDRTYPE = ADDRREF.ADDRTYPE\r\n" + "  INNER JOIN  CLIENT.ADDRESS AS ADDR\r\n" + "  ON ADDRREF.ADDRREF = ADDR.ADDRREF \r\n" +
			"  AND ADDR.STATE = '" + strState + "'  INNER JOIN CLIENT.CLIENTLATEST CLIENT\r\n" + "  ON CLTNAME.CLIENT = CLIENT.CLIENT\r\n" +
			"  AND CLTNAME.COMPANY = CLIENT.COMPANY\r\n" + "  WHERE CLTNAME.COMPANY = '" + strCompany + "'  AND CLTNAME.FIRSTNAME <> '' \r\n" +
			"  AND CLTNAME.SURNAME <> ''\r\n" + "  /* try and exclude odd values for BIRTHDTE */\r\n" + "  AND CLIENT.BIRTHDTE > '190000'\r\n" +
			"  AND EXISTS ( SELECT 1\r\n" + "                      FROM CLIENT.CLTTH AS CLTTH\r\n" +
			"                      WHERE CLTTH.CLIENT = CLTNAME.CLIENT \r\n" + "                      AND CLTTH.COMPANY = CLTNAME.COMPANY\r\n" +
			"                      AND CLTTH.CLTTRNNO = 1\r\n" + "                      AND CLTTH.TRANDATE >= " + strFifteenDaysbefore + " \r\n" +
			"                      AND CLTTH.TRANDATE <= " + strCurrentDate + "  \r\n" + "                      /* Client at least 17 years old */\r\n" +
			"                      AND CLTTH.TRANDATE - CLIENT.BIRTHDTE >= 170000\r\n" + "                    )  order by NEWID()  ";

		return strClient;

	}

	// Query for retrieving the Existing Company Client
	public static String returnExistingCompanyClient (String strCompany, String strState)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Calendar cal = Calendar.getInstance ();

		// Substract 15 days to current date.
		cal = Calendar.getInstance ();
		cal.add (Calendar.DATE, -15);
		String strCurrentDate = dateFormat.format (new Date ());
		String strFifteenDaysbefore = dateFormat.format (cal.getTime ());

		String strCompanyClient = "SELECT N.COMPANYNAME, A.Postcode FROM  CLIENT.NAME N, CLIENT.ADDrref A,CLIENT.CLTTH H,\r\n" +
			"Client.Address AD WHERE H.CLIENT = N.CLIENT AND H.CLTTRNNO = 1 and H.Client = A.Client \r\n" + "and A.postcode = AD.postcode and AD.state ='" +
			strState + "'and N.company ='" + strCompany + "'AND H.TRANDATE >= '" + strFifteenDaysbefore + "'AND H.TRANDATE <= '" + strCurrentDate +
			"'and N.TYPEOFCLT = 'K' and COMPANYNAME != '' order by NEWID()  " + "";

		return strCompanyClient;
	}

}
