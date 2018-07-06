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

public class TEST_WSM_PolicyQuoteView
{
	@Parameters({ "strEnvironmentName" })
	@Test
	public void generateWSMPolicyQuoteView (@Optional("Java8") String strEnvironmentName) throws Exception
	{
		// Get the SQL Select Statement to return the ClientQuotePolicyList data.
		String strSQLPath = WSMSQL.returnPolicyQuoteView ();

		// Pass in the ClientQuotePolicyList select Statement for execution..
		List<String> strtest = DatabaseData.returnDatabaseValue (strSQLPath, strEnvironmentName);
		// System.out.println ("The ClientQuotePolicyList data is as follows " + DatabaseData.returnDatabaseValue (strSQLPath,
		// strEnvironmentName));

		Map<String, String> tokensMap = new HashMap<String, String> ();
		tokensMap.put ("PolicyQuoteViewCompany", strtest.get (0));
		tokensMap.put ("PolicyQuoteViewUsrAgent", strtest.get (2));
		tokensMap.put ("PolicyQuoteViewPolicy", strtest.get (3));
		tokensMap.put ("PolicyQuoteViewProduct", strtest.get (4));

		XMLDataReader returnXMLString = new XMLDataReader ();

		// Returns the selected WSM WSDL URL in the WSMWsdlURLs.xml for example
		// "http://34.248.25.64:9080/WebServicesModule/ClientQuotePolicyList?wsdl"
		String stringWSDLURL = returnXMLString.ReturnXMLNode (strEnvironmentName, WSMConstants.WSM_POLICYQUOTEVIEWWSDL, WSMConstants.WSM_WSDLS);

		// Returns the selected WSM WSDL XML in the WSMSoapXML.xml
		String stringWSDLXML = returnXMLString.ReturnXMLNode (WSMConstants.INTERFACE_XML, WSMConstants.WSM_POLICYQUOTEVIEWSOAPXML, WSMConstants.WSM_SOAPXML);

		StringMatcherReplacer stringmatcherreplacer = new StringMatcherReplacer ();
		String stringWSDLXMLParameterised = stringmatcherreplacer.substituteAllTokens (tokensMap, stringWSDLXML);
		System.out.println ("The Soap XML has had its parametrised replaced " + stringWSDLXMLParameterised);

		// Calls the SOAPRequestResponse class to process the WSDL passing over the WSDL and associated XML
		SOAPRequestResponse.main (new String[] {}, stringWSDLURL, stringWSDLXMLParameterised);
	}
}
