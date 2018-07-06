package com.innovation.soap.regression.wsm;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innovation.data.XMLDataReader;
import com.innovation.misc.StringMatcherReplacer;
import com.innovation.soap.connection.SOAPRequestResponse;
import com.innovation.soap.connection.WSMConstants;

public class TEST_WSM_LOBRetrieveCT
{
	@Parameters({ "strEnvironmentName" })
	@Test
	public void generateWSMLOBRetrieveCT (@Optional("Java8") String strEnvironmentName) throws Exception
	{
		Map<String, String> tokensMap = new HashMap<String, String> ();
		tokensMap.put ("LOBCompany", "1");
		tokensMap.put ("DateType", "yyyymmdd");
		tokensMap.put ("EffectDate", "02/27/2018");
		tokensMap.put ("RiskState", "CT");
		tokensMap.put ("Subcoy", "100");
		tokensMap.put ("UserLang", "en");

		XMLDataReader returnXMLString = new XMLDataReader ();

		// Returns the selected WSM WSDL URL in the WSMWsdlURLs.xml for example
		// "http://34.248.25.64:9080/WebServicesModule/ClientQuotePolicyList?wsdl"
		String stringWSDLURL = returnXMLString.ReturnXMLNode (strEnvironmentName, WSMConstants.WSM_LOBRETRIEVEWSDL, WSMConstants.WSM_WSDLS);

		// Returns the selected WSM WSDL XML in the WSMSoapXML.xml
		String stringWSDLXML = returnXMLString.ReturnXMLNode (WSMConstants.INTERFACE_XML, WSMConstants.WSM_LOBRETRIEVESOAPXML, WSMConstants.WSM_SOAPXML);

		StringMatcherReplacer stringmatcherreplacer = new StringMatcherReplacer ();
		String stringWSDLXMLParameterised = stringmatcherreplacer.substituteAllTokens (tokensMap, stringWSDLXML);
		// System.out.println ("The Soap XML has had its parametrised replaced " + stringWSDLXMLParameterised);

		// Calls the SOAPRequestResponse class to process the WSDL passing over the WSDL and associated XML
		SOAPRequestResponse.main (new String[] {}, stringWSDLURL, stringWSDLXMLParameterised);
	}

}
