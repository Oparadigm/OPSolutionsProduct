package com.innovation.soap.customexceptions;

/**
 * @author haiderm - This custom exception is thrown when a regression test case doesn't meet its Prerequiste.
 *
 */
public class TestCasePrerequisteNotMet extends Exception
{
	private static final long serialVersionUID = 1L;

	public TestCasePrerequisteNotMet () 
	{
		super("The Test Case you are running didn't meet its Prerequiste.");
	}
}
