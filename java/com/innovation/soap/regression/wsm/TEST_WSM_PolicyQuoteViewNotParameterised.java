package com.innovation.soap.regression.wsm;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.innovation.data.XMLDataReader;
import com.innovation.soap.connection.SOAPRequestResponse;
import com.innovation.soap.connection.WSMConstants;

public class TEST_WSM_PolicyQuoteViewNotParameterised
{
	@Parameters({ "strEnvironmentName" })
	@Test
	public void generateWSMPolicyQuoteViewNotParameterised (@Optional("Java8") String strEnvironmentName) throws Exception
	{
		XMLDataReader returnXMLString = new XMLDataReader ();

		// Returns the selected WSM WSDL URL in the WSMWsdlURLs.xml for example
		// "http://34.248.25.64:9080/WebServicesModule/ClientQuotePolicyList?wsdl"
		String stringWSDLURL = returnXMLString.ReturnXMLNode (strEnvironmentName, WSMConstants.WSM_POLICYQUOTEVIEWWSDL, WSMConstants.WSM_WSDLS);

		// Returns the selected WSM WSDL XML in the WSMSoapXML.xml
		String stringWSDLXML = returnXMLString.ReturnXMLNode (WSMConstants.INTERFACE_XML, WSMConstants.WSM_POLICYQUOTEVIEWSOAPXMLNOPARAMS,
				WSMConstants.WSM_SOAPXML);

		// Calls the SOAPRequestResponse class to process the WSDL passing over the WSDL and associated XML
		SOAPRequestResponse.main (new String[] {}, stringWSDLURL, stringWSDLXML);
	}
}
