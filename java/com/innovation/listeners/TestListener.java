package com.innovation.listeners;

import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

/*
 * @ Author		Kamran Mahmood		This class will show results in the Result xml based on passed and failed only and exclude the count of 
 * 									retry test failed scripts.
 */
public class TestListener implements ITestListener
{
	@Override
	public void onFinish (ITestContext context)
	{
		Set<ITestResult> failedTests = context.getFailedTests ().getAllResults ();
		Set<ITestResult> SkippedTests = context.getSkippedTests ().getAllResults ();

		for (ITestResult temp : failedTests)
		{
			ITestNGMethod method = temp.getMethod ();
			if (context.getFailedTests ().getResults (method).size () > 1)
			{
				failedTests.remove (temp);
			}
			else if (context.getSkippedTests ().getResults (method).size () > 1)
			{
				SkippedTests.remove (temp);
			}
			else
			{
				if (context.getPassedTests ().getResults (method).size () > 0)
				{
					failedTests.remove (temp);
				}
			}
		}
	}

	@Override
	public void onTestStart (ITestResult result)
	{
	}

	@Override
	public void onTestSuccess (ITestResult result)
	{
	}

	@Override
	public void onTestFailure (ITestResult result)
	{
	}

	@Override
	public void onTestSkipped (ITestResult result)
	{
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage (ITestResult result)
	{
	}

	@Override
	public void onStart (ITestContext context)
	{
	}
}
