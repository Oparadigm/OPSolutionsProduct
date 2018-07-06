package com.innovation.configuration;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
 * @ Auhtor - Kamran Mahmood    This class will re execute failed scripts upto three times and if a test pass at second or third time will
 * 								set the status as PASSED and if test failed more then three times set the status to Failed 
 */

public class RetryFailedTests implements IRetryAnalyzer
{
	private int	retryCount		= 0;
	private int	maxRetryCount	= 3;

	// Below method returns 'true' if the test method has to be retried else 'false'
	// and it takes the 'Result' as parameter of the test method that just ran
	@Override
	public boolean retry (ITestResult result)
	{
		if (retryCount < maxRetryCount)
		{
			System.out.println ("Retrying test " + result.getName () + " with status " + getResultStatusName (result.getStatus ()) + " for the " +
				(retryCount + 1) + " time(s).");
			retryCount++;
			return true;
		}
		return false;
	}

	public String getResultStatusName (int status)
	{
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAILURE";
		if (status == 3)
			resultName = "SKIP";
		return resultName;
	}
}
