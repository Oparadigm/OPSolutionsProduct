package com.innovation.misc;

import com.innovation.data.XMLDataReader;

public class GetCoverageReport
{
	public static void main (String[] args) throws InterruptedException
	{
		// The following variables are used to store the Logger directory and file name
		// details found in the LoggerPortAndFileLocation.xml
		String strLogggerXMLFileName = "LoggerPortAndFileLocation.xml";
		String strElement = "LoggerConfiguration";
		String strNodeLoggerDirectoryName = "LoggingServerDirectory";
		String strNodeLoggerFileName = "LoggingServerFileName";

		XMLDataReader returnXMLString = new XMLDataReader ();
		// Gets the directory path from LoggerPortAndFileLocation.xml
		String strLoggerReportPath = returnXMLString.ReturnXMLNode (strElement, strNodeLoggerDirectoryName, strLogggerXMLFileName);
		// Gets the filename from LoggerPortAndFileLocation.xml
		String strLoggerFileName = returnXMLString.ReturnXMLNode (strElement, strNodeLoggerFileName, strLogggerXMLFileName);

		// This writes the Log Data in an xml format (Screen Name and Duration) to the output window.
		LoggingClient.sendSummary ();

		// This writes the Log Data out to the XML file and location as defined in the LoggerPortAndFileLocation.xml
		// GetCoverageReport. e.g. - ScreensandResponseTimes.xml
		// LoggingClient.sendSummary (strLoggerReportPath + strLoggerFileName + ".xml");

		// This writes the Log Data out to the XML file and location as defined in the LoggerPortAndFileLocation.xml
		// it also appends the Environment Name to the file e.g. - ScreensandResponseTimes_Odin.xml
		LoggingClient.sendSummaryByGroup (strLoggerReportPath + strLoggerFileName + "_{group}_{dt:yyyyMMdd-HHmm}.xml");

		// This writes the Log Data out to multiple XML files to the location as defined in the LoggerPortAndFileLocation.xml
		// a file is created for every screen visited e.g. - ScreensandResponseTimes_Claim Search.xml
		// LoggingClient.sendSummaryByName (strLoggerReportPath + strLoggerFileName + "_{name}_{dt:yyyyMMdd-HHmm}.xml");

		System.out.println ("stopping...");
		LoggingClient.stopServer ();
		// LoggingClient.sendclear ();
	}
}
