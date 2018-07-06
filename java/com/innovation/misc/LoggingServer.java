package com.innovation.misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.innovation.data.LoggingConstants;
import com.innovation.data.XMLDataReader;
import com.thoughtworks.xstream.XStream;

/**
 * @author kaessert * This class is a standalone server which can receive logging requests. The collected data cab be written to a
 *         file either in its totality or grouped by screen, name and or environment.
 */

public class LoggingServer implements Runnable
{
	// The following variables are used to store the Logger port details found in the LoggerPortAndFileLocation.xml
	static String					strLogggerXMLFileName	= "LoggerPortAndFileLocation.xml";
	static String					strElement				= "LoggerConfiguration";
	static String					strNodePort				= "Port";

	static XMLDataReader			returnXMLString			= new XMLDataReader ();
	// Gets the port from LoggerPortAndFileLocation.xml
	static String					strLoggerPort			= returnXMLString.ReturnXMLNode (strElement, strNodePort, strLogggerXMLFileName);

	private static String			screenEntry				= "\t\t<Screen count=\"%s\" average=\"%s\" min=\"%s\" max=\"%s\">\n";
	private static String			listEntry				= "\t\t\t\t<GroupName duration=\"%s\">%s</GroupName>\n";

	// Convert the string strLoggerPort to an integer
	static int						intLoggerport			= Integer.parseInt (strLoggerPort);

	private static final XStream	XSTREAM					= new XStream ();

	private static final String		NEWLINE					= "\n";

	static
	{
		Class<?>[] classes = new Class[] { DataObject.class };
		XStream.setupDefaultSecurity (XSTREAM);
		XSTREAM.allowTypes (classes);
	}

	// private int port = 9876;
	private static int						port				= intLoggerport;

	private Set<String>						activeRegistrations	= new HashSet<String> ();
	private Map<String, List<DataObject>>	registerByName		= new HashMap<String, List<DataObject>> ();
	private Map<String, List<DataObject>>	registerByGroup		= new HashMap<String, List<DataObject>> ();

	public LoggingServer (int port)
	{
		this.port = port;
	}

	@Override
	public void run ()
	{
		try
		{
			ServerSocket ss = new ServerSocket (port);

			while (true)
			{
				Socket socket = ss.accept ();
				new Thread (new LoggingServerWorker (socket)).start ();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}

		System.out.println ("Finished");
	}

	// This method processes the different types of requests.
	public void handleData (String xml)
	{
		// System.out.println (xml);

		DataObject obj = (DataObject) XSTREAM.fromXML (xml);

		System.out.println (obj);

		switch (obj.getMessageType ())
		{
			case LoggingConstants.MESSAGE_REGISTER:
				register (obj);
				break;
			case LoggingConstants.MESSAGE_DEREGISTER:
				deregister (obj);
				break;
			case LoggingConstants.MESSAGE_ENTRY:
				storeEntry (obj);
				break;
			case LoggingConstants.MESSAGE_CLEAR:
				clear (obj);
				break;
			case LoggingConstants.MESSAGE_SUMMARY:
				// build the filename
				String n = replace (obj.getName (), "");
				obj.setName (n);
				createSummary (obj, null, null);
				break;
			case LoggingConstants.MESSAGE_STOP:
				stopServer (obj);
				break;
			case LoggingConstants.MESSAGE_SUMMARY_GROUP:
				for (String s : registerByGroup.keySet ())
				{
					// build the filename
					String name = replace (obj.getName (), s);
					DataObject d = new DataObject (obj.getMessageType (), obj.getMessageGroup (), name, obj.getDuration ());
					// create the individual files
					createSummary (d, s, null);
				}
				break;
			case LoggingConstants.MESSAGE_SUMMARY_NAME:
				for (String s : registerByName.keySet ())
				{
					// build the filename
					String name = replace (obj.getName (), s);
					DataObject d = new DataObject (obj.getMessageType (), obj.getMessageGroup (), name, obj.getDuration ());
					// create the individual files
					createSummary (d, null, s);
				}
				break;
			default:
				System.err.println ("Unsupported message type : " + obj.getMessageType ());
		}
	}

	// Calls replace method - replaces the placeholders with either the string or a date and time if the date and time starts with
	// dt e.g. {dt:yyyyMMdd-HHmm}.
	private String replace (String name, String s)
	{
		if (name == null || name.length () == 0)
			return name;

		int start = name.indexOf ("{");
		while (start > -1)
		{
			int end = name.indexOf ("}", start);
			if (end > -1)
			{
				String repl = name.substring (start + 1, end);
				if (repl.toUpperCase ().startsWith ("DT:"))
				{
					String format = repl.substring (3);
					SimpleDateFormat sdf = new SimpleDateFormat (format);
					String s2 = sdf.format (new Date ());

					name = name.substring (0, start) + s2 + name.substring (end + 1);
				}
				else
					name = name.substring (0, start) + s + name.substring (end + 1);
			}

			start = name.indexOf ("{");
		}

		return name;
	}

	private void stopServer (DataObject obj)
	{
		System.out.println ("asked to stop");
		new Thread (new Exiter ()).start ();
	}

	private void clear (DataObject obj)
	{
		activeRegistrations.clear ();
		registerByName.clear ();
		registerByGroup.clear ();
	}

	private void storeEntry (DataObject obj)
	{
		store (registerByName, obj.getName (), obj);
		store (registerByGroup, obj.getMessageGroup (), obj);
	}

	private void store (Map<String, List<DataObject>> map, String key, DataObject obj)
	{
		List<DataObject> list = map.get (key);
		if (list == null)
		{
			list = new ArrayList<DataObject> ();
			map.put (key, list);
		}

		// store the element in the list
		list.add (obj);
	}

	// If the Group and Name are set then the data is filtered by those.
	private void createSummary (DataObject obj, String group, String name)
	{
		boolean closeStream = true;
		String filename = obj.getName ();
		OutputStream stream = null;
		if (filename != null && filename.length () > 0)
		{
			File file = new File (filename);
			try
			{
				stream = new FileOutputStream (file);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace ();
			}
		}

		if (stream == null)
		{
			stream = System.out;
			closeStream = false;
		}

		// System.out.println ("registrations : " + activeRegistrations);
		StringBuilder builder = new StringBuilder ();

		builder.append ("<Summary>").append (NEWLINE);

		boolean hasGroup = group != null && group.length () > 0;
		boolean hasName = name != null && name.length () > 0;

		// ------------------------------------

		List<List<String>> groups = buildGroups (hasGroup, group, hasName, name);

		builder.append ("\t<MessageGroups count=\"").append (groups.size ()).append ("\">").append (NEWLINE);

		for (List<String> g : groups)
			for (String s : g)
				builder.append (s);

		builder.append ("\t</MessageGroups>").append (NEWLINE);

		// ------------------------------------

		List<List<String>> screens = listScreens (hasName, name, hasGroup, group);

		builder.append ("\t<Screens count=\"").append (screens.size ()).append ("\">").append (NEWLINE);

		for (List<String> scrs : screens)
			for (String s : scrs)
				builder.append (s);

		builder.append ("\t</Screens>").append (NEWLINE);

		// ------------------------------------

		builder.append ("</Summary>").append (NEWLINE);

		// System.out.println (builder.toString ());

		try
		{
			stream.write (builder.toString ().getBytes ());
			if (closeStream)
				stream.close ();
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}
	}

	// Generates the output data based on name and group.
	private List<List<String>> listScreens (boolean hasName, String name, boolean hasGroup, String group)
	{
		List<List<String>> list = new ArrayList<List<String>> ();

		for (Map.Entry<String, List<DataObject>> entry : registerByName.entrySet ())
		{
			if (hasName && !name.equals (entry.getKey ()))
				continue;

			ListObject lo = listGroups (hasGroup, group, entry);

			if (lo.getCount () > 0)
			{
				List<String> grps = new ArrayList<String> ();

				grps.add (new StringBuilder ()
						.append (String.format (screenEntry, "" + lo.getCount (), "" + lo.getAverage (), "" + lo.getMin (), "" + lo.getMax ())).toString ());
				grps.add (new StringBuilder ().append ("\t\t\t<Name>").append (entry.getKey ()).append ("</Name>").append (NEWLINE).toString ());
				grps.add (new StringBuilder ().append ("\t\t\t<GroupNames>").append (NEWLINE).toString ());

				grps.addAll (lo.getEntries ());

				grps.add (new StringBuilder ().append ("\t\t\t</GroupNames>").append (NEWLINE).toString ());
				grps.add (new StringBuilder ().append ("\t\t</Screen>").append (NEWLINE).toString ());

				list.add (grps);
			}
		}

		return list;
	}

	// Generates the group data based on name and group.
	private ListObject listGroups (boolean hasGroup, String group, Map.Entry<String, List<DataObject>> entry)
	{
		ListObject lo = new ListObject ();

		for (DataObject o : entry.getValue ())
		{
			if (hasGroup && !group.equals (o.getMessageGroup ()))
				continue;

			lo.addEntry (String.format (listEntry, "" + o.getDuration (), o.getMessageGroup ()), o.getDuration ());
		}

		return lo;
	}

	// private List<List<String>> listScreensOLD (boolean hasName, String name, boolean hasGroup, String group)
	// {
	// List<List<String>> list = new ArrayList<List<String>> ();
	//
	// for (Map.Entry<String, List<DataObject>> entry : registerByName.entrySet ())
	// {
	// if (hasName && !name.equals (entry.getKey ()))
	// continue;
	//
	// List<String> groups = listGroups (hasGroup, group, entry);
	// if (groups.size () > 0)
	// {
	// List<String> grps = new ArrayList<String> ();
	//
	// grps.add (new StringBuilder ().append ("\t\t<Screen>").append (NEWLINE).toString ());
	// grps.add (new StringBuilder ().append ("\t\t\t<Name>").append (entry.getKey ()).append ("</Name>").append (NEWLINE).toString
	// ());
	// grps.add (new StringBuilder ().append ("\t\t\t<GroupNames>").append (NEWLINE).toString ());
	//
	// grps.addAll (groups);
	//
	// grps.add (new StringBuilder ().append ("\t\t\t</GroupNames>").append (NEWLINE).toString ());
	// grps.add (new StringBuilder ().append ("\t\t</Screen>").append (NEWLINE).toString ());
	//
	// list.add (grps);
	// }
	// }
	//
	// return list;
	// }

	// private List<String> listGroups (boolean hasGroup, String group, Map.Entry<String, List<DataObject>> entry)
	// {
	// List<String> list = new ArrayList<String> ();
	//
	// for (DataObject o : entry.getValue ())
	// {
	// if (hasGroup && !group.equals (o.getMessageGroup ()))
	// continue;
	//
	// list.add (new StringBuilder ().append ("\t\t\t\t<GroupName duration=\"").append (o.getDuration ()).append ("\">").append
	// (o.getMessageGroup ())
	// .append ("</GroupName>").append (NEWLINE).toString ());
	// }
	//
	// return list;
	// }

	private List<List<String>> buildGroups (boolean hasGroup, String group, boolean hasName, String name)
	{
		List<List<String>> list = new ArrayList<List<String>> ();

		for (Map.Entry<String, List<DataObject>> entry : registerByGroup.entrySet ())
		{
			if (hasGroup && !group.equals (entry.getKey ()))
				continue;

			List<String> screens = buildScreens (hasName, name, entry);
			List<String> summary = buildSummary (hasName, name, entry);

			if (screens.size () > 0)
			{
				List<String> scr = new ArrayList<String> ();
				scr.add (new StringBuilder ().append ("\t\t<MessageGroup>").append (NEWLINE).toString ());
				scr.add (new StringBuilder ().append ("\t\t\t<GroupName>").append (entry.getKey ()).append ("</GroupName>").append (NEWLINE).toString ());
				scr.add (new StringBuilder ().append ("\t\t\t<Screens>").append (NEWLINE).toString ());

				scr.addAll (screens);

				scr.add (new StringBuilder ().append ("\t\t\t</Screens>").append (NEWLINE).toString ());
				scr.add (new StringBuilder ().append ("\t\t\t<ScreenSummary>").append (NEWLINE).toString ());
				scr.addAll (summary);
				scr.add (new StringBuilder ().append ("\t\t\t</ScreenSummary>").append (NEWLINE).toString ());
				scr.add (new StringBuilder ().append ("\t\t</MessageGroup>").append (NEWLINE).toString ());

				list.add (scr);
			}
		}

		return list;
	}

	private List<String> buildScreens (boolean hasName, String name, Map.Entry<String, List<DataObject>> entry)
	{
		List<String> list = new ArrayList<String> ();

		for (DataObject o : entry.getValue ())
		{
			if (hasName && !name.equals (o.getName ()))
				continue;

			list.add (new StringBuilder ().append ("\t\t\t\t<Screen duration=\"").append (o.getDuration ()).append ("\">").append (o.getName ())
					.append ("</Screen>").append (NEWLINE).toString ());
		}

		return list;
	}

	private List<String> buildSummary (boolean hasName, String name, Map.Entry<String, List<DataObject>> entry)
	{
		Map<String, SummaryObject> map = new HashMap<String, SummaryObject> ();

		List<String> list = new ArrayList<String> ();

		for (DataObject o : entry.getValue ())
		{
			if (hasName && !name.equals (o.getName ()))
				continue;

			SummaryObject so = map.get (o.getName ());
			if (so == null)
			{
				so = new SummaryObject (o.getName (), o.getDuration ());
				map.put (so.getName (), so);
			}
			else
				so.add (o.getDuration ());

		}

		String text = "\t\t\t\t<Screen count=\"%s\" average=\"%s\" min=\"%s\" max=\"%s\">%s</Screen>\n";
		for (Map.Entry<String, SummaryObject> e : map.entrySet ())
		{
			SummaryObject o = e.getValue ();
			list.add (String.format (text, "" + o.getCount (), "" + o.getAverage (), "" + o.getMin (), "" + o.getMax (), o.getName ()));
		}

		return list;
	}

	// Register and de-register clients to see which clients are connected
	private void register (DataObject obj)
	{
		activeRegistrations.add (obj.getMessageGroup ());
	}

	private void deregister (DataObject obj)
	{
		activeRegistrations.remove (obj.getMessageGroup ());
	}

	// Main method to start the server for a given port
	public static void main (String[] args)
	{
		new Thread (new LoggingServer (port)).start ();
		// new Thread (new LoggingServer (9876)).start ();
	}

	// The server side thread which handles the communication to the client.
	class LoggingServerWorker implements Runnable
	{
		private Socket socket;

		public LoggingServerWorker (Socket socket)
		{
			this.socket = socket;
		}

		// Reads the data back from the socket as a string.
		@Override
		public void run ()
		{
			try
			{
				InputStream in = socket.getInputStream ();
				// Read the data 1kb at a time, once no more data is available the length is -1.
				int length = -1;
				StringBuilder builder = new StringBuilder ();
				byte[] buffer = new byte[1024];
				while ((length = in.read (buffer)) > -1)
					builder.append (new String (buffer, 0, length));
				in.close ();
				socket.close ();

				handleData (builder.toString ());
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
		}
	}

	// Class to stop the server.
	static class Exiter implements Runnable
	{

		@Override
		public void run ()
		{
			try
			{
				Thread.sleep (2000);
			}
			catch (InterruptedException e)
			{
				// e.printStackTrace();
			}

			System.exit (0);
		}

	}

	static class SummaryObject
	{
		private String	name;
		private int		count;
		private long	total;
		private long	min;
		private long	max;

		public SummaryObject (String name, long duration)
		{
			this.name = name;
			this.count = 1;
			this.total = duration;
			this.min = duration;
			this.max = duration;
		}

		public void add (long duration)
		{
			total += duration;
			count++;
			if (duration < this.min)
				this.min = duration;
			if (duration > this.max)
				this.max = duration;
		}

		public long getAverage ()
		{
			return Math.round ((double) total / (double) count);
		}

		public int getCount ()
		{
			return count;
		}

		public String getName ()
		{
			return name;
		}

		public long getMin ()
		{
			return min;
		}

		public long getMax ()
		{
			return max;
		}
	}

	static class ListObject
	{
		private List<String>	entries	= new ArrayList<String> ();
		private long			total	= 0;
		private long			min		= -1;
		private long			max		= -1;

		public ListObject ()
		{
			super ();
		}

		public void addEntry (String entry, long duration)
		{
			entries.add (entry);
			total += duration;
			this.min = this.min == -1 ? duration : Math.min (this.min, duration);
			this.max = this.max == -1 ? duration : Math.max (this.max, duration);
		}

		public List<String> getEntries ()
		{
			return this.entries;
		}

		public int getCount ()
		{
			return entries.size ();
		}

		public long getAverage ()
		{
			if (getCount () == 0)
				return 0;

			return Math.round ((double) this.total / (double) getCount ());
		}

		public long getMin ()
		{
			return this.min == -1 ? 0 : min;
		}

		public long getMax ()
		{
			return this.max == -1 ? 0 : max;
		}
	}
}
