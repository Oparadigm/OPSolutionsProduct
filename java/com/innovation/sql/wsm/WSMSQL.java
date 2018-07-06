package com.innovation.sql.wsm;

/**
 * @author lushs - This class contains all the SQL required to drive the WSM interfaces.
 *
 */
public class WSMSQL
{
	// Query for retrieving ClientQuotePolicyList data, this returns 1 random row of data
	public static String returnClientQuotePolicyList ()
	{

		String strClientQuotePolicyList = "select top 1 CLT.COMPANY,\r\n" + "		CLT.SEQCLTNO AS CLIENT,\r\n" + "		AGT.SEQCLTNO AS AGENT\r\n" +
			"FROM	CLIENT.CLIENT CLT\r\n" + "		INNER JOIN CLIENT.CLTREF CLTREF\r\n" + "			ON  CLTREF.COMPANY	= CLT.COMPANY\r\n" +
			"			AND CLTREF.CLIENT	= CLT.CLIENT\r\n" + "			AND CLTREF.REFTYPE  = 'AGT'\r\n" + "		INNER JOIN CLIENT.CLIENT AGT\r\n" +
			"			ON  AGT.COMPANY		= CLTREF.COMPANY\r\n" + "			AND AGT.CLIENT		= CLTREF.CLTREFNO\r\n" + "ORDER BY NEWID()";

		return strClientQuotePolicyList;
	}

	// Query for retrieving PolicyQuoteView data, this returns 1 random row of data
	public static String returnPolicyQuoteView ()
	{

		String strPolicyQuoteView = "select	top 1 CLT.COMPANY,\r\n" + "		CLT.SEQCLTNO AS CLIENT,\r\n" + "		AGT.SEQCLTNO AS AGENT,\r\n" +
			"		POL.SEQPOLNO AS POLICY,\r\n" + "		POL.PRODUCT	 AS PRODUCT,\r\n" + "		POL.BUSTRNNO AS BUSTRNNO,\r\n" +
			"		POL.EFFECTDTE AS EFFECTDTE,\r\n" + "		POL.ACTIVTO  AS ACTIVETO\r\n" + "FROM	CLIENT.CLIENT CLT\r\n" +
			"		INNER JOIN CLIENT.CLTREF CLTREF\r\n" + "			ON  CLTREF.COMPANY	= CLT.COMPANY\r\n" +
			"			AND CLTREF.CLIENT	= CLT.CLIENT\r\n" + "			AND CLTREF.REFTYPE  = 'AGT'\r\n" + "		INNER JOIN CLIENT.CLIENT AGT\r\n" +
			"			ON  AGT.COMPANY		= CLTREF.COMPANY\r\n" + "			AND AGT.CLIENT		= CLTREF.CLTREFNO\r\n" +
			"		INNER JOIN CLIENT.CLTREF POLREF\r\n" + "			ON  POLREF.COMPANY		= CLT.COMPANY\r\n" +
			"			AND POLREF.CLIENT		= CLT.CLIENT\r\n" + "			AND POLREF.REFTYPE		= 'POL'\r\n" +
			"			AND	POLREF.REFASSOC		= 'PH'\r\n" + "		INNER JOIN POLICY.POLICY POL  -- Changge this line to: INNER JOIN POLICY.POLQTE POL\r\n" +
			"									  -- to select quotes instead of policies\r\n" + "			ON  POL.COMPANY			=  POLREF.COMPANY\r\n" +
			"			AND POL.POLICY			=  POLREF.CLTREFNO\r\n" + "			AND POL.PRODUCT			=  POLREF.CLTREFPR\r\n" + "ORDER BY NEWID()";

		return strPolicyQuoteView;
	}
}
