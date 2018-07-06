package com.innovation.soap.connection;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;

import com.innovation.data.XMLDataReader;
import com.innovation.soap.customexceptions.MessageSendFailed;

/**
 * @author haiderm - This class contains the method which extract specified data from the specified interface.
 *
 */

public class SoapConnection
{
	private SOAPMessage	soapRequest			= null;
	private SOAPMessage	soapResponse		= null;
	private String		strTagValue			= null;
	private String		strStatusCode		= null;
	private String		strStatusMessage	= null;
	private String		strURL				= null;
	MOJ					moj					= new MOJ ();

	public String extractTagValue (String strInterface, String strMethodName, String strTagName, String strXMLFileName) throws Exception
	{
		return extractTagValue (strInterface, strMethodName, strTagName, strXMLFileName, null, null, null);
	}

	public String extractTagValue (String strInterface, String strMethodName, String strTagName, String strXMLFileName, String strMOJClaimNumber)
			throws Exception
	{
		return extractTagValue (strInterface, strMethodName, strTagName, strXMLFileName, strMOJClaimNumber, null, null);
	}

	public String extractTagValue (String strInterface, String strMethodName, String strTagName, String strXMLFileName, String strMOJClaimNumber, String strActivityEngineGUID
			) throws Exception
	{
		return extractTagValue (strInterface, strMethodName, strTagName, strXMLFileName, strMOJClaimNumber, strActivityEngineGUID, null);
	}
	
	public String extractTagValue (String strInterface, String strMethodName, String strTagName, String strXMLFileName, String strMOJClaimNumber,
			String strActivityEngineGUID, String strIsTagValue) throws Exception
	{
		try
		{
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance ();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection ();
			XMLDataReader returnXMLString = new XMLDataReader ();
			System.out.println ("The selected Interface is: " + strInterface);

			switch (strInterface)
			{

				case MOJConstants.INTERFACE_MOJ:
				{
					strURL = returnXMLString.ReturnXMLNode (MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_WSDL, MOJConstants.WSDLS);
					soapRequest = moj.createSoapRequest (strInterface, strMethodName, strXMLFileName, strMOJClaimNumber, strActivityEngineGUID, strIsTagValue);
					soapResponse = soapConnection.call (soapRequest, strURL);
					// Un-comment to see response for debugging
					// moj.createSoapResponse(soapResponse);
					SOAPBody responseBody = soapResponse.getSOAPBody ();
					strStatusCode = responseBody.getElementsByTagName ("code").item (0).getTextContent ();
					if (strStatusCode != null && strStatusCode.equalsIgnoreCase ("OK"))
					{
						System.out.println ("Status Code: " + strStatusCode);
						strTagValue = responseBody.getElementsByTagName (strTagName).item (0).getTextContent ();
						System.out.println ("Requested Tag is: " + strTagName);
					}
					else
					{
						strStatusMessage = responseBody.getElementsByTagName ("message").item (0).getTextContent ();
						System.out.println ("Status Code: " + strStatusCode);
						System.out.println ("Status Message: " + strStatusMessage);
					}

					break;
				}

				default:
				{

					System.out.println ("Please Select the Correct Interface.");
				}

					// Close Soap connection
					soapConnection.close ();
			}
		}
		catch (Exception e)
		{
			throw new MessageSendFailed ();

		}

		return strTagValue;
	}

}
