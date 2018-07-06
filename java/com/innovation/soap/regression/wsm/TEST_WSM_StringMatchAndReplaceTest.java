package com.innovation.soap.regression.wsm;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class TEST_WSM_StringMatchAndReplaceTest
{
	@Test
	public void generateWSMStringMatchAndReplaceTest () throws Exception
	{
		Map<String, String> tokensMap = new HashMap<String, String> ();
		tokensMap.put ("ClientID", "682759");
		tokensMap.put ("UserAgent", "682558");

		String toInspect = "\\n\\t\\t<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:com=\"http://com.innovation\">\\n   <soapenv:Header/>\\n   <soapenv:Body>\\n      <com:ClientQuotePolicyList>\\n         <!--Optional:-->\\n         <inDTO>\\n            <!--Optional:-->\\n            <client>${ClientID}</client>\\n            <!--Optional:-->\\n            <company>1</company>\\n            <!--Optional:-->\\n            <userLang>en</userLang>\\n            <!--Optional:-->\\n            <usragent>${UserAgent}</usragent>\\n            <!--Optional:-->\\n            <usrseclvl>9</usrseclvl>\\n         </inDTO>\\n      </com:ClientQuotePolicyList>\\n   </soapenv:Body>\\n</soapenv:Envelope>\\n\\t";
		String regex = "\\$\\{([^}]+)\\}";
		Pattern pattern = Pattern.compile (regex);
		Matcher matcher = pattern.matcher (toInspect);
		String result = toInspect;
		while (matcher.find ())
		{
			String token = matcher.group (); // Ex: ${ClientID}
			String tokenKey = matcher.group (1); // Ex: ClientID
			String replacementValue = null;

			if (tokensMap.containsKey (tokenKey))
				replacementValue = tokensMap.get (tokenKey);
			else
				throw new RuntimeException ("String contained an unsupported token.");

			result = result.replaceFirst (Pattern.quote (token), replacementValue);

			System.out.println ("The Soap XML has had its parametrised replaced " + result);
		}
	}

}
