package com.innovation.misc;

import java.io.Serializable;

public class DataObject implements Serializable
{
	private static final long	serialVersionUID	= 8103797877582820080L;

	private int					messageType;
	private String				messageGroup;
	private String				name;
	private long				duration;

	public DataObject (int messageType, String messageGroup, String name, long duration)
	{
		super ();
		this.messageType = messageType;
		this.messageGroup = messageGroup;
		this.name = name;
		this.duration = duration;
	}

	public int getMessageType ()
	{
		return messageType;
	}

	public void setMessageType (int messageType)
	{
		this.messageType = messageType;
	}

	public String getMessageGroup ()
	{
		return messageGroup;
	}

	public void setMessageGroup (String messageGroup)
	{
		this.messageGroup = messageGroup;
	}

	public String getName ()
	{
		return name;
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public long getDuration ()
	{
		return duration;
	}

	public void setDuration (long duration)
	{
		this.duration = duration;
	}

	@Override
	public String toString ()
	{
		return "DataObject [messageType=" + messageType + ", messageGroup=" + messageGroup + ", name=" + name + ", duration=" + duration + "]";
	}

}
