package com.innovation.soap.customexceptions;

/**
 * @author haiderm - This custom exception is thrown when a specific value of
 *         MOJ PhaseCacheCode doesn't match to the its respective value in DB.
 *
 */
public class TestCaseValidationFailed extends Exception
{
	private static final long serialVersionUID = 1L;

	public TestCaseValidationFailed () 
	{
		super("Test Case Validation Failed - Possible Reasons are"+"\n"+"1. Database Validation Failed"+"\n"+"2. Backend Service returned wrong values"+"\n"+"3. Frontend UI fields don't match with their respective database columns");
	}
}
