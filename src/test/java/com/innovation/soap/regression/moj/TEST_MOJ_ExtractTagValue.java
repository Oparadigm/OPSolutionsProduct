package com.innovation.soap.regression.moj;

import org.testng.annotations.Test;
import com.innovation.data.Constants;
import com.innovation.soap.connection.SoapConnection;
import com.innovation.soap.customexceptions.InputDocumentNotValid;
/**
 * @author haiderm - This is the sample test to extract the specified values from MOJ portal.
 *
 */
public class TEST_MOJ_ExtractTagValue 
{

	@Test
	public void extractMOJTagValue () throws Exception 
	{

		SoapConnection soap = new SoapConnection();
		String MOJTagValue = soap.extractTagValue(Constants.Interface_MOJ, Constants.MOJ_addClaim, Constants.MOJ_ClaimNumber, Constants.MOJ_SoapXML);
		if (MOJTagValue != null) 
		{
			System.out.println("The MOJTagValue is: " + MOJTagValue);

		} 
		else
		{
			throw new InputDocumentNotValid ();
		}

	}

}
