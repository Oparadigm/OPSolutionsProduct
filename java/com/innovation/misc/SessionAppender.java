package com.innovation.misc;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractOutputStreamAppender;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.appender.FileManager;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginBuilderAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginBuilderFactory;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.apache.logging.log4j.core.net.Advertiser;
import org.apache.logging.log4j.core.util.Booleans;
import org.apache.logging.log4j.core.util.Constants;
import org.apache.logging.log4j.core.util.Integers;

/**
 * File Appender.
 */
@Plugin(name = SessionAppender.PLUGIN_NAME, category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE, printObject = true)
public final class SessionAppender extends AbstractOutputStreamAppender<FileManager>
{
	public static final String	PLUGIN_NAME			= "SessionFile";

	public FileManagerValues	fileManagerValues	= new FileManagerValues ();

	@PluginFactory
	public static SessionAppender buildSessionAppender ()
	{
		return new Builder ().build ();
	}

	/**
	 * Builds SessionAppender instances.
	 * 
	 * @param <B>
	 *            The type to build
	 */
	public static class Builder<B extends Builder<B>> extends AbstractOutputStreamAppender.Builder<B>
			implements org.apache.logging.log4j.core.util.Builder<SessionAppender>
	{

		@PluginBuilderAttribute
		@Required
		private String	fileName;

		@PluginBuilderAttribute
		private boolean	append	= true;

		@PluginBuilderAttribute
		private boolean	locking;

		@PluginBuilderAttribute
		private boolean	advertise;

		@PluginBuilderAttribute
		private String	advertiseUri;

		@PluginBuilderAttribute
		private boolean	createOnDemand;

		@PluginBuilderAttribute
		private String	filePermissions;

		@PluginBuilderAttribute
		private String	fileOwner;

		@PluginBuilderAttribute
		private String	fileGroup;

		@Override
		public SessionAppender build ()
		{
			boolean bufferedIo = isBufferedIo ();
			final int bufferSize = getBufferSize ();
			if (locking && bufferedIo)
			{
				LOGGER.warn ("Locking and buffering are mutually exclusive. No buffering will occur for {}", fileName);
				bufferedIo = false;
			}
			if (!bufferedIo && bufferSize > 0)
			{
				LOGGER.warn ("The bufferSize is set to {} but bufferedIo is false: {}", bufferSize, bufferedIo);
			}
			final Layout<? extends Serializable> layout = getOrCreateLayout ();

			Configuration configuration = getConfiguration ();

			final FileManager manager = FileManager.getFileManager (fileName, append, locking, bufferedIo, createOnDemand, advertiseUri, layout, bufferSize,
					filePermissions, fileOwner, fileGroup, configuration);
			if (manager == null)
			{
				return null;
			}

			SessionAppender appender = new SessionAppender (getName (), layout, getFilter (), manager, fileName, isIgnoreExceptions (),
					!bufferedIo || isImmediateFlush (), advertise ? getConfiguration ().getAdvertiser () : null);

			appender.fileManagerValues.setAdvertiseUri (advertiseUri);
			appender.fileManagerValues.setBufferedIo (bufferedIo);
			appender.fileManagerValues.setBufferSize (bufferSize);
			appender.fileManagerValues.setConfiguration (configuration);
			appender.fileManagerValues.setFileGroup (fileGroup);
			appender.fileManagerValues.setFileOwner (fileOwner);
			appender.fileManagerValues.setFilePermissions (filePermissions);
			appender.fileManagerValues.setLayout (layout);

			return appender;
		}

		public String getAdvertiseUri ()
		{
			return advertiseUri;
		}

		public String getFileName ()
		{
			return fileName;
		}

		public boolean isAdvertise ()
		{
			return advertise;
		}

		public boolean isAppend ()
		{
			return append;
		}

		public boolean isCreateOnDemand ()
		{
			return createOnDemand;
		}

		public boolean isLocking ()
		{
			return locking;
		}

		public String getFilePermissions ()
		{
			return filePermissions;
		}

		public String getFileOwner ()
		{
			return fileOwner;
		}

		public String getFileGroup ()
		{
			return fileGroup;
		}

		public B withAdvertise (final boolean advertise)
		{
			this.advertise = advertise;
			return asBuilder ();
		}

		public B withAdvertiseUri (final String advertiseUri)
		{
			this.advertiseUri = advertiseUri;
			return asBuilder ();
		}

		public B withAppend (final boolean append)
		{
			this.append = append;
			return asBuilder ();
		}

		public B withFileName (final String fileName)
		{
			this.fileName = fileName;
			return asBuilder ();
		}

		public B withCreateOnDemand (final boolean createOnDemand)
		{
			this.createOnDemand = createOnDemand;
			return asBuilder ();
		}

		public B withLocking (final boolean locking)
		{
			this.locking = locking;
			return asBuilder ();
		}

		public B withFilePermissions (final String filePermissions)
		{
			this.filePermissions = filePermissions;
			return asBuilder ();
		}

		public B withFileOwner (final String fileOwner)
		{
			this.fileOwner = fileOwner;
			return asBuilder ();
		}

		public B withFileGroup (final String fileGroup)
		{
			this.fileGroup = fileGroup;
			return asBuilder ();
		}

	}

	private static final int DEFAULT_BUFFER_SIZE = 8192;

	/**
	 * Create a File Appender.
	 * 
	 * @param fileName
	 *            The name and path of the file.
	 * @param append
	 *            "True" if the file should be appended to, "false" if it should be overwritten. The default is "true".
	 * @param locking
	 *            "True" if the file should be locked. The default is "false".
	 * @param name
	 *            The name of the Appender.
	 * @param immediateFlush
	 *            "true" if the contents should be flushed on every write, "false" otherwise. The default is "true".
	 * @param ignoreExceptions
	 *            If {@code "true"} (default) exceptions encountered when appending events are logged; otherwise they are propagated
	 *            to the caller.
	 * @param bufferedIo
	 *            "true" if I/O should be buffered, "false" otherwise. The default is "true".
	 * @param bufferSizeStr
	 *            buffer size for buffered IO (default is 8192).
	 * @param layout
	 *            The layout to use to format the event. If no layout is provided the default PatternLayout will be used.
	 * @param filter
	 *            The filter, if any, to use.
	 * @param advertise
	 *            "true" if the appender configuration should be advertised, "false" otherwise.
	 * @param advertiseUri
	 *            The advertised URI which can be used to retrieve the file contents.
	 * @param config
	 *            The Configuration
	 * @return The SessionAppender.
	 * @deprecated Use {@link #newBuilder()}
	 */
	@Deprecated
	public static <B extends Builder<B>> SessionAppender createAppender (
			// @formatter:off
			final String fileName, final String append, final String locking, final String name, final String immediateFlush, final String ignoreExceptions,
			final String bufferedIo, final String bufferSizeStr, final Layout<? extends Serializable> layout, final Filter filter, final String advertise,
			final String advertiseUri, final Configuration config)
	{
		return SessionAppender.<B> newBuilder ().withAdvertise (Boolean.parseBoolean (advertise)).withAdvertiseUri (advertiseUri)
				.withAppend (Booleans.parseBoolean (append, true)).withBufferedIo (Booleans.parseBoolean (bufferedIo, true))
				.withBufferSize (Integers.parseInt (bufferSizeStr, DEFAULT_BUFFER_SIZE)).setConfiguration (config).withFileName (fileName).withFilter (filter)
				.withIgnoreExceptions (Booleans.parseBoolean (ignoreExceptions, true)).withImmediateFlush (Booleans.parseBoolean (immediateFlush, true))
				.withLayout (layout).withLocking (Boolean.parseBoolean (locking)).withName (name).build ();
		// @formatter:on
	}

	@PluginBuilderFactory
	public static <B extends Builder<B>> B newBuilder ()
	{
		return new Builder<B> ().asBuilder ();
	}

	private final String		fileName;

	private final Advertiser	advertiser;

	private final Object		advertisement;

	private SessionAppender (final String name, final Layout<? extends Serializable> layout, final Filter filter, final FileManager manager,
			final String filename, final boolean ignoreExceptions, final boolean immediateFlush, final Advertiser advertiser)
	{

		super (name, layout, filter, ignoreExceptions, immediateFlush, manager);
		if (advertiser != null)
		{
			final Map<String, String> configuration = new HashMap<> (layout.getContentFormat ());
			configuration.putAll (manager.getContentFormat ());
			configuration.put ("contentType", layout.getContentType ());
			configuration.put ("name", name);
			advertisement = advertiser.advertise (configuration);
		}
		else
		{
			advertisement = null;
		}
		this.fileName = filename;
		this.advertiser = advertiser;
	}

	/**
	 * Returns the file name this appender is associated with.
	 * 
	 * @return The File name.
	 */
	public String getFileName ()
	{
		return this.fileName;
	}

	@Override
	public boolean stop (final long timeout, final TimeUnit timeUnit)
	{
		setStopping ();
		super.stop (timeout, timeUnit, false);
		if (advertiser != null)
		{
			advertiser.unadvertise (advertisement);
		}
		setStopped ();
		return true;
	}

	// ----------------------------------

	@Override
	public void append (final LogEvent event)
	{
		String name = getName (event);
		FileManager manager = getFileManager (name);
		try
		{
			tryAppend (event, manager);
		}
		catch (final AppenderLoggingException ex)
		{
			error ("Unable to write to stream " + manager.getName () + " for appender " + getName () + ": " + ex);
			throw ex;
		}
	}

	private static final Map<String, FileManager> managers = new HashMap<String, FileManager> ();

	private FileManager getFileManager (String name)
	{
		FileManager fileManager = managers.get (name);
		if (fileManager == null)
		{
			FileManager parent = getManager ();

			// String fileNameNew = Utils.replaceString (fileName, "sessionID", name, false, false);
			String fileNameNew = Utils.replaceString (fileName, "${name}", name, false, false);

			fileManager = FileManager.getFileManager (fileNameNew, parent.isAppend (), parent.isLocking (), fileManagerValues.isBufferedIo (), //
					parent.isCreateOnDemand (), fileManagerValues.getAdvertiseUri (), fileManagerValues.getLayout (), //
					fileManagerValues.getBufferSize (), fileManagerValues.getFilePermissions (), fileManagerValues.getFileOwner (), //
					fileManagerValues.getFileGroup (), fileManagerValues.getConfiguration ());
		}

		return fileManager;
	}

	public String getName (final LogEvent event)
	{
		String ret = "";

		if (event != null && event.getMarker () != null)
			ret = event.getMarker ().getName ();

		return ret == null ? "" : ret;
	}

	private void tryAppend (final LogEvent event, final FileManager manager)
	{
		if (Constants.ENABLE_DIRECT_ENCODERS)
		{
			directEncodeEvent (event, manager);
		}
		else
		{
			writeByteArrayToManager (event, manager);
		}
	}

	protected void directEncodeEvent (final LogEvent event, final FileManager manager)
	{
		getLayout ().encode (event, manager);
		if (getImmediateFlush (manager) || event.isEndOfBatch ())
		{
			manager.flush ();
		}
	}

	protected void writeByteArrayToManager (final LogEvent event, final FileManager manager)
	{
		final byte[] bytes = getLayout ().toByteArray (event);
		if (bytes != null && bytes.length > 0)
		{
			// manager.write (bytes, getImmediateFlush (manager) || event.isEndOfBatch ());
			manager.writeBytes (bytes, 0, bytes.length); // , getImmediateFlush (manager) || event.isEndOfBatch ());
			if (getImmediateFlush (manager) || event.isEndOfBatch ())
				manager.flush ();
		}
	}

	private boolean getImmediateFlush (FileManager manager)
	{
		// TODO Auto-generated method stub
		return true;
	}

}

class FileManagerValues
{
	private boolean							bufferedIo		= false;
	private String							advertiseUri	= "";
	private Layout<? extends Serializable>	layout			= null;
	private int								bufferSize		= 0;
	private String							filePermissions	= "";
	private String							fileOwner		= "";
	private String							fileGroup		= "";
	private Configuration					configuration	= null;

	public boolean isBufferedIo ()
	{
		return bufferedIo;
	}

	public void setBufferedIo (boolean bufferedIo)
	{
		this.bufferedIo = bufferedIo;
	}

	public String getAdvertiseUri ()
	{
		return advertiseUri;
	}

	public void setAdvertiseUri (String advertiseUri)
	{
		this.advertiseUri = advertiseUri;
	}

	public Layout<? extends Serializable> getLayout ()
	{
		return layout;
	}

	public void setLayout (Layout<? extends Serializable> layout)
	{
		this.layout = layout;
	}

	public int getBufferSize ()
	{
		return bufferSize;
	}

	public void setBufferSize (int bufferSize)
	{
		this.bufferSize = bufferSize;
	}

	public String getFilePermissions ()
	{
		return filePermissions;
	}

	public void setFilePermissions (String filePermissions)
	{
		this.filePermissions = filePermissions;
	}

	public String getFileOwner ()
	{
		return fileOwner;
	}

	public void setFileOwner (String fileOwner)
	{
		this.fileOwner = fileOwner;
	}

	public String getFileGroup ()
	{
		return fileGroup;
	}

	public void setFileGroup (String fileGroup)
	{
		this.fileGroup = fileGroup;
	}

	public Configuration getConfiguration ()
	{
		return configuration;
	}

	public void setConfiguration (Configuration configuration)
	{
		this.configuration = configuration;
	}

}
