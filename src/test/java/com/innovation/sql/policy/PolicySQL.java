package com.innovation.sql.policy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * @author  Kamran & Rizwan - this class stores all the SQL queries that are to be used for the data related to policies
 *  
 */
public class PolicySQL
{

	public static String returnLatestHomePolicy (String strCompany)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Calendar cal = Calendar.getInstance ();

		// Substract 15 days to current date.
		cal = Calendar.getInstance ();
		cal.add (Calendar.DATE, -15);
		String strCurrentDate = dateFormat.format (new Date ());
		String strFifteenDaysbefore = dateFormat.format (cal.getTime ());
		// This query will return latest home policy based on current effective
		// date without any other filter
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		// String strCurrentDate = dateFormat.format(new Date () );

		String strSQLQuery = "Select Pol.Product,Pol.SEQPOLNO, PolTH.policy from POlicy.Policy Pol, POlicy.PolicyTH PolTH where Pol.Policy not in (select policy from POLICY.POLLCK where product = 'HOM' and company = '" +
			strCompany + "') and Pol.Policy = PolTH.Policy and Pol.Product = 'HOM' and pol.company = '" + strCompany +
			"' and Pol.POLSTATUS != 'C' and Pol.termincep >=  '" + strFifteenDaysbefore + "' and Pol.termincep <='" + strCurrentDate +
			"'group by Pol.Product,Pol.SEQPOLNO, PolTH.policy order by NEWID()";
		return strSQLQuery;

	}

	public static String returnHomePolicyBldgAndContCovers (String strCompany)
	{
		// This query will return a random home policy with buildings and
		// contents coverage that was created in last 15 days
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Calendar cal = Calendar.getInstance ();

		// Substract 15 days to current date.
		cal = Calendar.getInstance ();
		cal.add (Calendar.DATE, -15);
		String strCurrentDate = dateFormat.format (new Date ());
		String strFifteenDaysbefore = dateFormat.format (cal.getTime ());

		String strSQLQuery = "select product, seqpolno, NEWID() as IDX  from policy.policy where polstatus != 'C' and termincep >= '" + strFifteenDaysbefore +
			"' and termincep <='" + strCurrentDate +
			"' and policy in (select policy from policy.covers where policy in (select PolTH.policy from policy.policyTH PolTH where PolTH.Policy not in (select policy from POLICY.POLLCK where product = 'HOM' and company = '" +
			strCompany + "') and PolTH.product = 'HOM' and PolTH.company = '" + strCompany +
			"') and covstatus != 'C' and coverage in ('BLDG', 'CONT') group by policy having count(*) = 2) group by product, seqpolno ORDER BY IDX";
		return strSQLQuery;

	}

	public static String returnLatestAutoPolicy (String strCompany)

	{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Calendar cal = Calendar.getInstance ();

		// Substract 15 days to current date.
		cal = Calendar.getInstance ();
		cal.add (Calendar.DATE, -15);
		String strCurrentDate = dateFormat.format (new Date ());
		String strFifteenDaysbefore = dateFormat.format (cal.getTime ());

		String strSQLQuery = "Select Pol.Product,Pol.SEQPOLNO, PolTH.policy from POlicy.Policy Pol, POlicy.PolicyTH PolTH where  Pol.Policy not in (select policy from POLICY.POLLCK where product = 'AUT' and company = '" +
			strCompany + "')   and Pol.Policy = PolTH.Policy and Pol.Product = 'AUT' and pol.company ='" + strCompany +
			"' and Pol.POLSTATUS != 'C' and Pol.termincep >= '" + strFifteenDaysbefore + "' and Pol.termincep <='" + strCurrentDate +
			"' group by Pol.Product,Pol.SEQPOLNO, PolTH.policy order by NEWID()";

		return strSQLQuery;

	}

	public static String returnAutoPolicyWithComprehensiveCover (String strCompany)
	{
		// This query will return a random auto policy with comprehensive
		// coverage that was created in last 15 days
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Calendar cal = Calendar.getInstance ();

		// Substract 15 days to current date.
		cal = Calendar.getInstance ();
		cal.add (Calendar.DATE, -15);
		String strCurrentDate = dateFormat.format (new Date ());
		String strFifteenDaysbefore = dateFormat.format (cal.getTime ());

		String strSQLQuery = "select pol.product, pol.seqpolno, polcovers.coverage from policy.policy pol, policy.policyth polTH, policy.covers polcovers where pol.policy = polcovers.policy and pol.policy = polTH.policy and Pol.policy not in (select policy from policy.pollck) and pol.policy not in (select policy from policy.covers where coverage = 'COMP' and covstatus = 'C') and pol.polstatus != 'C' and pol.company = '" +
			strCompany + "' and pol.product = 'AUT' and polcovers.coverage = 'COMP' and pol.termincep >= '" + strFifteenDaysbefore +
			"' and pol.termincep <= '" + strCurrentDate + "' group by pol.product, pol.seqpolno, polcovers.coverage ORDER BY NEWID()";
		return strSQLQuery;

	}

	public static String returnAutoPolicyforCancellation (String strCompany)

	{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Calendar cal = Calendar.getInstance ();

		// Substract 15 days to current date.
		cal = Calendar.getInstance ();
		cal.add (Calendar.DATE, -15);
		String strCurrentDate = dateFormat.format (new Date ());
		String strFifteenDaysbefore = dateFormat.format (cal.getTime ());

		String strSQLQuery = "Select Pol.Product,Pol.SEQPOLNO, PolTH.policy from POlicy.Policy Pol, POlicy.PolicyTH PolTH where  Pol.Policy not in (select policy from POLICY.POLLCK where product = 'AUT' and company = '" +
			strCompany + "')   and Pol.Policy = PolTH.Policy and Pol.Product = 'AUT' and pol.company ='" + strCompany +
			"' and Pol.POLSTATUS != 'C' and Pol.termincep >= '" + strFifteenDaysbefore + "' and Pol.termincep <='" + strCurrentDate +
			"' and Pol.bustrnno = '1' and pol.activto = '99999999' group by Pol.Product,Pol.SEQPOLNO, PolTH.policy order by NEWID()";

		return strSQLQuery;

	}

	public static String returnHomePolicyforCancellation (String strCompany)

	{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Calendar cal = Calendar.getInstance ();

		// Substract 15 days to current date.
		cal = Calendar.getInstance ();
		cal.add (Calendar.DATE, -15);
		String strCurrentDate = dateFormat.format (new Date ());
		String strFifteenDaysbefore = dateFormat.format (cal.getTime ());

		String strSQLQuery = "Select Pol.Product,Pol.SEQPOLNO, PolTH.policy from POlicy.Policy Pol, POlicy.PolicyTH PolTH where  Pol.Policy not in (select policy from POLICY.POLLCK where product = 'HOM' and company = '" +
			strCompany + "')   and Pol.Policy = PolTH.Policy and Pol.Product = 'HOM' and pol.company ='" + strCompany +
			"' and Pol.POLSTATUS != 'C' and Pol.termincep >= '" + strFifteenDaysbefore + "' and Pol.termincep <='" + strCurrentDate +
			"'and Pol.bustrnno = '1' and pol.activto = '99999999' group by Pol.Product,Pol.SEQPOLNO, PolTH.policy order by NEWID()";

		return strSQLQuery;

	}

	public static String returnPolicyBillPlan (String strCompany, String strSubCoy)
	{

		// The following query will return Bill Plans that have been configured in the system
		// as per the Company and sub company

		String strBillPlan = "select PolBil.BILLDESC from POLICY.BILPLN PolBil where " + "PolBil.COMPANY = '" + strCompany + "' and PolBil.SUBCOY = '" +
			strSubCoy + "' and PolBil.ACTIVTO = 99991231";

		return strBillPlan;
	}

	public static String returnPolicyforRenewals (String strCompany, String strLOB)

	{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Calendar cal = Calendar.getInstance ();
		String strSQLQuery = null;
		// Substract 30 days to current date.
		cal = Calendar.getInstance ();
		cal.add (Calendar.DATE, -45);
		String strCurrentDate = dateFormat.format (new Date ());
		String strFifteenDaysbefore = dateFormat.format (cal.getTime ());

		strSQLQuery =
					"select Pol.PRODUCT, Pol.SEQPOLNO from POLICY.POLICY Pol where Pol.POLICY in (select REFNO from POLICY.BILINS where BILLPLAN = 'ANDD' and PRODUCT = '" +
						strLOB + "') and Pol.POLICY not in (select policy from POLICY.POLLCK where product = '" + strLOB + "' and company = '" + strCompany +
						"') and Pol.POLICY not in (select policy from POLICY.PAYMTP where company = '" + strCompany + "') and Pol.effectdte >= '" +
						strFifteenDaysbefore + "' and Pol.effectdte <='" + strCurrentDate +
						"' and Pol.ACTIVTO = '99999999' and Pol.TRANCNT = 1 order by NEWID()";

		return strSQLQuery;
	}

}
