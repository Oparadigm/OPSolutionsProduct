/**
 * 
 */
package com.innovation.misc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import com.innovation.data.XMLDataReader;

public class ZAP
{
	// Reference the tags from the ZAPInstallPortFileLocations.xml
	static String			strZAPXMLFileName			= "ZAPInstallPortFileLocations.xml";
	static String			strZAPElement				= "ZAPConfiguration";
	static String			strZAPXMLPort				= "zapPort";
	static String			strZAPXMLExecutableLocation	= "zapExecutableLocation";
	static String			strZAPXMLWorkingDirectory	= "zapWorkingDirectory";
	static String			strZAPXMLAddress			= "zapAddress";
	static String			strZAPXMLAPIKey				= "zapAPIKey";
	static String			strZAPXMLTarget				= "zapTarget";
	static String			strZAPXMLReportPathName		= "zapOutXMLReportPathName";
	static String			strZAPHTMLReportPathName	= "zapOutHTMLReportPathName";

	// Setup the XML Data Reader instance.
	static XMLDataReader	returnXMLString				= new XMLDataReader ();

	// Gets the port from ZAPInstallPortFileLocations.xml
	static String			strZapPort					= returnXMLString.ReturnXMLNode (strZAPElement, strZAPXMLPort, strZAPXMLFileName);
	// Gets the ZAP Executable Location from ZAPInstallPortFileLocations.xml
	static String			strZapExecutableLocation	= returnXMLString.ReturnXMLNode (strZAPElement, strZAPXMLExecutableLocation, strZAPXMLFileName);
	// Gets the ZAP Working Directory from ZAPInstallPortFileLocations.xml
	static String			strZapWorkingDirectory		= returnXMLString.ReturnXMLNode (strZAPElement, strZAPXMLWorkingDirectory, strZAPXMLFileName);
	// Gets the ZAP Address from ZAPInstallPortFileLocations.xml
	static String			strURL						= returnXMLString.ReturnXMLNode (strZAPElement, strZAPXMLAddress, strZAPXMLFileName);
	// Gets the ZAP API Key from ZAPInstallPortFileLocations.xml
	static String			strAPIKey					= returnXMLString.ReturnXMLNode (strZAPElement, strZAPXMLAPIKey, strZAPXMLFileName);
	// Gets the port from ZAPInstallPortFileLocations.xml
	static String			strTarget					= returnXMLString.ReturnXMLNode (strZAPElement, strZAPXMLTarget, strZAPXMLFileName);
	// Gets the port from ZAPInstallPortFileLocations.xml
	static String			strOutXMLPathName			= returnXMLString.ReturnXMLNode (strZAPElement, strZAPXMLReportPathName, strZAPXMLFileName);
	// Gets the port from ZAPInstallPortFileLocations.xml
	static String			strOutHTMLPathName			= returnXMLString.ReturnXMLNode (strZAPElement, strZAPHTMLReportPathName, strZAPXMLFileName);

	// Convert the string strLoggerPort to an integer
	static int				intZAPPort					= Integer.parseInt (strZapPort);

	// Setup the ZAP ClientAPI
	static ClientApi		zapClientAPI				= new ClientApi (strURL, intZAPPort, strAPIKey);

	public static ClientApi OpenZAP () throws Exception
	{

		ProcessBuilder pb = new ProcessBuilder (strZapExecutableLocation);
		pb.directory (new File (strZapWorkingDirectory).getAbsoluteFile ());
		pb.redirectErrorStream (true);
		pb.redirectOutput (new File ("OWASPZAPOutputStream.txt"));
		System.out.println ("Trying to invoke the ZAP executable");
		pb.start ();
		// Check If ZAP Has Started
		System.out.println ("Waiting for successful connection to ZAP");
		// Call to ClientApi to check ZAP has successfully loaded
		zapClientAPI.waitForSuccessfulConnectionToZap (60000, 1000);
		System.out.println ("Seems like we can connect to ZAP APIs now");
		return zapClientAPI;

	}

	public static void SpiderTarget (String endPoint) throws Exception
	{
		try
		{
			String target = (endPoint != null && endPoint.length () > 0) ? endPoint : strTarget;
			// Start spidering the target
			System.out.println ("Active scan : " + target);
			// It's not necessary to pass the ZAP API key again,
			// already set when creating the ClientApi.
			ApiResponse resp = zapClientAPI.spider.scan (target, null, null, null, null);
			String scanid;
			int progress;

			// The scan now returns a scan id to support concurrent scanning
			scanid = ((ApiResponseElement) resp).getValue ();

			// Poll the status until it completes
			while (true)
			{
				Thread.sleep (1000);
				progress = Integer.parseInt (((ApiResponseElement) zapClientAPI.spider.status (scanid)).getValue ());
				System.out.println ("Spider progress : " + progress + "%");
				if (progress >= 100)
				{
					break;
				}
			}
			System.out.println ("Spider complete");
		}
		catch (Exception e)
		{
			System.out.println ("Exception : " + e.getMessage ());
			e.printStackTrace ();
		}
		// Give the passive scanner a chance to complete
		Thread.sleep (2000);
	}

	public static void ActiveScanTarget (String endPoint) throws Exception
	{
		try
		{
			String target = (endPoint != null && endPoint.length () > 0) ? endPoint : strTarget;
			// Start scanning the target
			System.out.println ("Active scan : " + target);
			// It's not necessary to pass the ZAP API key again,
			// already set when creating the ClientApi.
			ApiResponse resp = zapClientAPI.ascan.scan (target, "True", "False", null, null, null);
			String scanid;
			int progress;

			// The scan now returns a scan id to support concurrent scanning
			scanid = ((ApiResponseElement) resp).getValue ();

			// Poll the status until it completes
			while (true)
			{
				Thread.sleep (5000);
				progress = Integer.parseInt (((ApiResponseElement) zapClientAPI.ascan.status (scanid)).getValue ());
				System.out.println ("Active Scan progress : " + progress + "%");
				if (progress >= 100)
				{
					break;
				}
			}
			System.out.println ("Active Scan complete");
			System.out.println ("Alerts:");
			System.out.println (new String (zapClientAPI.core.xmlreport ()));
			zapClientAPI.core.htmlreport ();

		}
		catch (Exception e)
		{
			System.out.println ("Exception : " + e.getMessage ());
			e.printStackTrace ();
		}
	}

	public static void writeXMLReportZAP () throws IOException
	{
		FileOutputStream tildeStream = new FileOutputStream (strOutXMLPathName + CalenderDate.fileDateTime () + ".html", false);
		BufferedWriter writer = new BufferedWriter (new OutputStreamWriter (tildeStream));
		try
		{
			String sCurrentLine = (new String (zapClientAPI.core.xmlreport ()));
			writer.write (sCurrentLine);
			// line feed
			writer.newLine ();
			writer.close ();
			tildeStream.close ();
		}
		catch (ClientApiException e)
		{
			System.out.println (e.getMessage ());
			e.printStackTrace ();
		}
	}

	public static void writeHTMLReportZAP () throws IOException
	{
		FileOutputStream tildeStream = new FileOutputStream (strOutHTMLPathName + CalenderDate.fileDateTime () + ".html", false);
		BufferedWriter writer = new BufferedWriter (new OutputStreamWriter (tildeStream));
		try
		{
			String sCurrentLine = (new String (zapClientAPI.core.htmlreport ()));
			writer.write (sCurrentLine);
			// line feed
			writer.newLine ();
			writer.close ();
			tildeStream.close ();
		}
		catch (ClientApiException e)
		{
			System.out.println (e.getMessage ());
			e.printStackTrace ();
		}
	}

	public static void CloseZAP () throws Exception
	{
		if (zapClientAPI == null)
			return;
		try
		{
			System.out.println ("Shutting ZAP down now");
			zapClientAPI.core.shutdown ();
			Thread.sleep (2000);
			// zapClientApi.destroy();

		}
		catch (final Exception e)
		{
			System.out.println ("Error shutting down ZAP.");
			System.out.println (e.getMessage ());
			e.printStackTrace ();
		}
	}
}
