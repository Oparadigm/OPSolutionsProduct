package com.innovation.soap.regression.wsm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innovation.data.XMLDataReader;
import com.innovation.misc.DatabaseData;
import com.innovation.misc.StringMatcherReplacer;
import com.innovation.soap.connection.SOAPRequestResponse;
import com.innovation.soap.connection.WSMConstants;
import com.innovation.sql.wsm.WSMSQL;

public class TEST_WSM_ClientQuotePolicyList
{
	@Parameters({ "strEnvironmentName" })
	@Test
	public void generateWSMClientQuotePolicyList (@Optional("Java8") String strEnvironmentName) throws Exception
	{
		// Get the SQL Select Statement to return the ClientQuotePolicyList data.
		String strSQLPath = WSMSQL.returnClientQuotePolicyList ();

		// Pass in the ClientQuotePolicyList select Statement for execution..
		List<String> strtest = DatabaseData.returnDatabaseValue (strSQLPath, strEnvironmentName);
		// System.out.println ("The ClientQuotePolicyList data is as follows " + DatabaseData.returnDatabaseValue (strSQLPath,
		// strEnvironmentName));

		// String[] out = strtest.split(",");
		// System.out.println ("The 1st value is " + strtest.get (0));
		// System.out.println ("The 2nd value is " + strtest.get (1));
		// System.out.println ("The 3rd value is " + strtest.get (2));

		Map<String, String> tokensMap = new HashMap<String, String> ();
		tokensMap.put ("Company", strtest.get (0));
		tokensMap.put ("ClientID", strtest.get (1));
		tokensMap.put ("UserAgent", strtest.get (2));

		XMLDataReader returnXMLString = new XMLDataReader ();

		// Returns the selected WSM WSDL URL in the WSMWsdlURLs.xml for example
		// "http://34.248.25.64:9080/WebServicesModule/ClientQuotePolicyList?wsdl"
		String stringWSDLURL = returnXMLString.ReturnXMLNode (strEnvironmentName, WSMConstants.WSM_CLIENTQUOTEPOLICYLISTWSDL, WSMConstants.WSM_WSDLS);

		// Returns the selected WSM WSDL XML in the WSMSoapXML.xml
		String stringWSDLXML = returnXMLString.ReturnXMLNode (WSMConstants.INTERFACE_XML, WSMConstants.WSM_CLIENTQUOTEPOLICYLISTSOAPXML,
				WSMConstants.WSM_SOAPXML);

		StringMatcherReplacer stringmatcherreplacer = new StringMatcherReplacer ();
		String stringWSDLXMLParameterised = stringmatcherreplacer.substituteAllTokens (tokensMap, stringWSDLXML);

		// System.out.println ("The Soap XML has had its parametrised replaced " + stringWSDLXMLParameterised);

		// Calls the SOAPRequestResponse class to process the WSDL passing over the WSDL and associated XML
		SOAPRequestResponse.main (new String[] {}, stringWSDLURL, stringWSDLXMLParameterised);
	}

}
