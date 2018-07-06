package com.innovation.soap.regression.moj;

import org.testng.annotations.Test;

public class TestServicesOnly
{

	@Test
	public void testServicesOnly () throws Exception
	{

		// Generate MOJ Claim Number via SOAP Service
		MOJMethods mojmethods = new MOJMethods ();
		String strMOJClaimNumber = mojmethods.getMOJClaimNumber ();
		String strMOJChildClaimNumber = mojmethods.getMOJChildClaimNumber ();
		
		System.out.println ("Adult Claim Number is: " + strMOJClaimNumber );
		System.out.println ("Child Claim Number is: " + strMOJChildClaimNumber );

	}

}
