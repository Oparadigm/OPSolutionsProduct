package com.innovation.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import com.innovation.configuration.RetryFailedTests;

/*
 * @ Auhtor - Kamran Mahmood    This class will see if test are failed to call RetryFailedTest class for re execution of failed tests 
 */

public class RetryListener implements IAnnotationTransformer
{

	@Override
	public void transform (ITestAnnotation testannotation, Class testClass, Constructor testConstructor, Method testMethod)
	{
		IRetryAnalyzer retry = testannotation.getRetryAnalyzer ();

		if (retry == null)
		{
			testannotation.setRetryAnalyzer (RetryFailedTests.class);
		}

	}
}
