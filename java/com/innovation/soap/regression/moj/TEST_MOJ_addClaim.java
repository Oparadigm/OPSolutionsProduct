package com.innovation.soap.regression.moj;

import org.testng.annotations.Test;

import com.innovation.soap.connection.SoapConnection;
import com.innovation.soap.customexceptions.InputDocumentNotValid;

public class TEST_MOJ_addClaim
{

	@Test
	public void addMOJClaim () throws Exception
	{
		System.setProperty ("java.net.useSystemProxies", "true");
		SoapConnection soap = new SoapConnection ();
		String MOJ_ClaimNumber = soap.extractTagValue ("MOJ", "URL", "applicationId", "soapRequests/MOJ_addClaim.xml");
		if (MOJ_ClaimNumber != null)
		{
			System.out.println ("The MOJ_ClaimNumber is: " + MOJ_ClaimNumber);

		}
		else
		{
			throw new InputDocumentNotValid ();
		}

	}

}
