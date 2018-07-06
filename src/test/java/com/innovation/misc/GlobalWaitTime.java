package com.innovation.misc;

/**
 * @author lushs - This class set the global timeout value in seconds.
 */

public class GlobalWaitTime
{

	public GlobalWaitTime ()
	{

	}

	// Standard wait timeout
	public static int getIntWaitTime ()
	{

		return 70;

	}

	// Short wait used for unexpected alerts
	public static int getShortWaitTime ()
	{

		return 10;

	}

	// Extra long wait timeout used in some searches
	public static int getLongWaitTime ()
	{

		return 300;

	}

}
