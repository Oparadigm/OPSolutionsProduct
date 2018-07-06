package com.innovation.sql.agent;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Tahir Akbar
 *
 */

public class AgentSQL
{

	public static String returnAgentNumbers (String strCompany, String strState, String strSubCompany)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");
		Calendar cal = Calendar.getInstance ();

		// Substract 15 days to current date.
		cal = Calendar.getInstance ();
		cal.add (Calendar.DATE, -15);
		String strFifteenDaysbefore = dateFormat.format (cal.getTime ());

		String strAgentNumber = "select Agt.SEQAGTNO from POLICY.AGENT Agt where Agt.COMPANY = '" + strCompany +
			"'and Agt.AGTSUFFIX = 'P' and Agt.AGTSTATUS = 'A'and Agt.BRRESPAGT ='" + strCompany + "'and Agt.EFFECTDTE >= '" + strFifteenDaysbefore +
			"'and Agt.AGENTTYPE != '3' and  Agt.AGENT in (Select Agtcompany.AGENT  from POLICY.AGTCOY Agtcompany where Agtcompany.STATE = '" + strState +
			"'and Agtcompany.AGENT in (Select Agentclass.AGENT from Policy.AGTCLS Agentclass where Agentclass.AGENT in \r\n" +
			"(Select Agentlicence.AGENT from Policy.AGTLIC Agentlicence where Agentlicence.license != '' and Agentlicence.SUBCOY ='" + strSubCompany +
			"'and Agentlicence.RISKSTATE = '" + strState + "')))order by NEWID() \r\n" + "";

		return strAgentNumber;

	}

}
