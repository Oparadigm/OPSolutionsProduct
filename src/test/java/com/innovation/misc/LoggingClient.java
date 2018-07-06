package com.innovation.misc;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.innovation.data.LoggingConstants;
import com.innovation.data.XMLDataReader;
import com.thoughtworks.xstream.XStream;

/**
 * @author kaessert * This class is contains the client code to call the logging server.
 */

public class LoggingClient
{
	// The following variables are used to store the Logger port details found in the LoggerPortAndFileLocation.xml
	static String					strLogggerXMLFileName	= "LoggerPortAndFileLocation.xml";
	static String					strElement				= "LoggerConfiguration";
	static String					strNodePort				= "Port";

	static XMLDataReader			returnXMLString			= new XMLDataReader ();
	// Gets the port from LoggerPortAndFileLocation.xml
	static String					strLoggerPort			= returnXMLString.ReturnXMLNode (strElement, strNodePort, strLogggerXMLFileName);

	// Convert the string strLoggerPort to an integer
	static int						intLoggerport			= Integer.parseInt (strLoggerPort);

	// This is the serialisation mechanism.
	private static final XStream	XSTREAM					= new XStream ();

	private static final String		SYSTEM					= "system";

	private static String			hostname				= "localhost";
	private static int				port					= intLoggerport;
	// private static int port = 9876;

	static
	{
		// Specifies the allowed class to be serialised. Builds an xml string from a data object.
		Class<?>[] classes = new Class[] { DataObject.class };
		XStream.setupDefaultSecurity (XSTREAM);
		XSTREAM.allowTypes (classes);
	}

	// Allows you specify where the server is running
	public static void setServerLocation (String hostname, int port)
	{
		LoggingClient.hostname = hostname;
		LoggingClient.port = port;
	}

	public static String getHostname ()
	{
		return hostname;
	}

	public static int getPort ()
	{
		return port;
	}

	// Generic send method - has the four parameters to match the data object
	private static void send (int messageType, String messageGroup, String name, long duration)
	{
		try
		{
			DataObject obj = new DataObject (messageType, messageGroup, name, duration);
			String xml = XSTREAM.toXML (obj);

			Socket socket = new Socket (hostname, port);

			OutputStream out = socket.getOutputStream ();
			out.write (xml.getBytes ());
			out.close ();
			socket.close ();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace ();
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}
	}

	/*
	 * The -1 is simply a default value, so a known value is passed over to the send method - private static void send (int
	 * messageType, String messageGroup, String name, long duration)
	 */

	// Public method to register a client on a server.
	public static void register (String messageGroup)
	{
		send (LoggingConstants.MESSAGE_REGISTER, messageGroup, "", -1);
	}

	// Public method to deregister a client on a server.
	public static void deregister (String messageGroup)
	{
		send (LoggingConstants.MESSAGE_DEREGISTER, messageGroup, "", -1);
	}

	// Public method to register an entry on the server.
	public static void sendEntry (String messageGroup, String name, long duration)
	{
		send (LoggingConstants.MESSAGE_ENTRY, messageGroup, name, duration);
	}

	// Public method to clear the data on the server.
	public static void sendclear ()
	{
		send (LoggingConstants.MESSAGE_CLEAR, SYSTEM, "", -1);
	}

	// Public method to summarise the data to the console.
	public static void sendSummary ()
	{
		send (LoggingConstants.MESSAGE_SUMMARY, SYSTEM, "", -1);
	}

	// Public method to summarise the data into a file.
	public static void sendSummary (String filename)
	{
		send (LoggingConstants.MESSAGE_SUMMARY, SYSTEM, filename, -1);
	}

	// Public method to summarise the data into a file grouped by environment name.
	public static void sendSummaryByGroup (String filename)
	{
		send (LoggingConstants.MESSAGE_SUMMARY_GROUP, SYSTEM, filename, -1);
	}

	// Public method to summarise the data into a file grouped by screen name.
	public static void sendSummaryByName (String filename)
	{
		send (LoggingConstants.MESSAGE_SUMMARY_NAME, SYSTEM, filename, -1);
	}

	// Public method to request the server to stop.
	public static void stopServer ()
	{
		send (LoggingConstants.MESSAGE_STOP, SYSTEM, "", -1);
	}
}
