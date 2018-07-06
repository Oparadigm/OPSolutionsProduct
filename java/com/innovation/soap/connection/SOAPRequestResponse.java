package com.innovation.soap.connection;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.Charset;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import com.innovation.misc.XMLPrettyPrint;

public class SOAPRequestResponse
{
	public static void main (String args[], String stringWSDLURL, String stringSOAPXML) throws Exception
	{
		try
		{
			// Create SOAP Connection
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance ();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection ();

			// Send SOAP Message to SOAP Server.
			SOAPMessage soapResponse = soapConnection.call (createSOAPRequest (stringSOAPXML), new URL (stringWSDLURL));

			// Process the SOAP Response
			printSOAPResponse (soapResponse);

			soapConnection.close ();
		}
		catch (Exception e)
		{
			System.err.println ("Error occurred while sending SOAP Request to Server");
			e.printStackTrace ();
		}
	}

	private static SOAPMessage createSOAPRequest (String stringSOAPXML) throws Exception
	{
		MessageFactory messageFactory = MessageFactory.newInstance ();
		InputStream is = new ByteArrayInputStream (stringSOAPXML.getBytes (Charset.forName ("UTF-8")));
		MimeHeaders Headers = new MimeHeaders ();

		SOAPMessage soapMessage = messageFactory.createMessage (Headers, is);
		// Comment this out if you don't want the SOAP Request in the console
		// soapMessage.writeTo (System.out);

		return soapMessage;
	}

	private static void printSOAPResponse (SOAPMessage soapResponse) throws Exception
	{
		TransformerFactory transformerFactory = TransformerFactory.newInstance ();
		Transformer transformer = transformerFactory.newTransformer ();
		Source sourceContent = soapResponse.getSOAPPart ().getContent ();
		// System.out.println ("Response SOAP Message = ");
		// StreamResult result = new StreamResult (System.out);
		// transformer.transform (sourceContent, result);

		StringWriter writer = new StringWriter ();
		transformer.transform (sourceContent, new StreamResult (writer));
		String strOutput = writer.toString ();

		// This pulls the interface name out of the XML returned. Only captured if successful!
		String strInterfaceName = strOutput.substring (strOutput.indexOf ("<ns2:") + 5, strOutput.lastIndexOf ("xmlns:ns2="));
		// System.out.println ("The interface name is " + strInterfaceName);

		// Checks if the interface returns Fault.
		// Not sure how reliable this is for error checking the data that was returned.
		if (strOutput.indexOf ("soapenv:Fault") != -1)
		{
			// System.out.println ("The SOAP request FAILED = " + XMLPrettyPrint.prettyPrintXMLAsString (strOutput));
			System.err.println ("The SOAP request FAILED = ");
			// Calls the XMLPrettyPrint class to pretty the XML
			System.err.println (XMLPrettyPrint.prettyPrintXMLAsString (strOutput));

			org.testng.Assert.fail ("the test failed");
		}
		else
		{
			// System.out.println ("The SOAP request was SUCCESSFUL = " + XMLPrettyPrint.prettyPrintXMLAsString (strOutput));
			System.out.println ("The request to " + strInterfaceName + "was SUCCESSFUL = ");
			// Calls the XMLPrettyPrint class to pretty the XML
			System.out.println (XMLPrettyPrint.prettyPrintXMLAsString (strOutput));
		}
	}
}
