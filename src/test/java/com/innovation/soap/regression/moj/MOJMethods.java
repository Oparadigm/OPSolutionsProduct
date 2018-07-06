package com.innovation.soap.regression.moj;

import com.innovation.soap.connection.MOJConstants;
import com.innovation.soap.connection.SoapConnection;
import com.innovation.soap.customexceptions.InputDocumentNotValid;

public class MOJMethods
{

	public String getMOJClaimNumber () throws Exception
	{

		SoapConnection soap = new SoapConnection ();
		String MOJ_ClaimNumber = soap.extractTagValue (MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_ADDCLAIM, MOJConstants.MOJ_CLAIMNUMBER,
				MOJConstants.MOJ_SOAPXML);
		if (MOJ_ClaimNumber != null)
		{
			System.out.println ("The MOJ_ClaimNumber is: " + MOJ_ClaimNumber);

		}
		else
		{
			throw new InputDocumentNotValid ();
		}

		return MOJ_ClaimNumber;
	}

	public String getMOJChildClaimNumber () throws Exception
	{

		SoapConnection soap = new SoapConnection ();
		String MOJ_ClaimNumber = soap.extractTagValue (MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_ADDCHILDCLAIM, MOJConstants.MOJ_CLAIMNUMBER,
				MOJConstants.MOJ_SOAPXML);
		if (MOJ_ClaimNumber != null)
		{
			System.out.println ("The MOJ_ClaimNumber for a Child is: " + MOJ_ClaimNumber);

		}
		else
		{
			throw new InputDocumentNotValid ();
		}

		return MOJ_ClaimNumber;
	}

	
	public String getMOJClaimData (String strMOJClaimNumber) throws Exception
	{

		SoapConnection soap = new SoapConnection ();
		String MOJClaimData = soap.extractTagValue (MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_GETCLAIM, MOJConstants.MOJ_CLAIMDATA, MOJConstants.MOJ_SOAPXML,
				strMOJClaimNumber);
		if (MOJClaimData != null)
		{
			System.out.println ("The MOJClaimData is: " + MOJClaimData);

		}
		else
		{
			throw new InputDocumentNotValid ();
		}

		return MOJClaimData;
	}

	public String getMOJClaimStatus (String strMOJClaimNumber, String strOutputTag) throws Exception
	{

		SoapConnection soap = new SoapConnection ();
		String strActivityEngineGuid = soap.extractTagValue (MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_GETCLAIMSSTATUS, strOutputTag,
				MOJConstants.MOJ_SOAPXML, strMOJClaimNumber, null);
		if (strActivityEngineGuid != null)
		{
			System.out.println ("The ActivityEngineGuid is: " + strActivityEngineGuid);

		}
		else
		{
			throw new InputDocumentNotValid ();
		}

		return strActivityEngineGuid;
	}

	public String acknowledgeLiabilityAdmitted (String strMOJClaimNumber, String strActivityEngineGUID) throws Exception
	{

		SoapConnection soap = new SoapConnection ();
		String strUpdatedActivityEngineGuid = soap.extractTagValue (MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_ACKNOWLEDGELIABILITYADMITTED,
				MOJConstants.MOJ_ACTIVITYENGINEGUID, MOJConstants.MOJ_SOAPXML, strMOJClaimNumber, strActivityEngineGUID);
		if (strUpdatedActivityEngineGuid != null)
		{
			System.out.println ("The UpdatedActivityEngineGuid is: " + strUpdatedActivityEngineGuid);

		}
		else
		{
			throw new InputDocumentNotValid ();
		}

		return strUpdatedActivityEngineGuid;
	}

	public String setInterimPaymentNeeded (String strMOJClaimNumber, String strActivityEngineGUID, String strIsInterimPaymentNeededValue) throws Exception
	{

		SoapConnection soap = new SoapConnection ();
		String strLatestActivityEngineGuid = soap.extractTagValue (MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_SETINTERIMPAYMENTNEEDED,
				MOJConstants.MOJ_ACTIVITYENGINEGUID, MOJConstants.MOJ_SOAPXML, strMOJClaimNumber, strActivityEngineGUID, strIsInterimPaymentNeededValue);
		if (strLatestActivityEngineGuid != null)
		{
			System.out.println ("The LatestActivityEngineGuid is: " + strLatestActivityEngineGuid);

		}
		else
		{
			throw new InputDocumentNotValid ();
		}

		return strLatestActivityEngineGuid;
	}
	
	public String setStage2SPFCounterOfferNeeded (String strMOJClaimNumber, String strActivityEngineGUID, String strIsStage2SPFCounterOfferNeeded) throws Exception
	{

		SoapConnection soap = new SoapConnection ();
		String strLatestActivityEngineGuid = soap.extractTagValue (MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_SETSTAGE2SPFCOUNTEROFFERNEEDED,
				MOJConstants.MOJ_ACTIVITYENGINEGUID, MOJConstants.MOJ_SOAPXML, strMOJClaimNumber, strActivityEngineGUID, strIsStage2SPFCounterOfferNeeded);
		if (strLatestActivityEngineGuid != null)
		{
			System.out.println ("The LatestActivityEngineGuid is: " + strLatestActivityEngineGuid);

		}
		else
		{
			throw new InputDocumentNotValid ();
		}

		return strLatestActivityEngineGuid;
	}
	
	public String setStage2SPFAgreementDecision (String strMOJClaimNumber, String strActivityEngineGUID, String strIsAgreed) throws Exception
	{

		SoapConnection soap = new SoapConnection ();
		String strLatestActivityEngineGuid = soap.extractTagValue (MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_SETSTAGE2SPFAGREEMENTDECISION,
				MOJConstants.MOJ_ACTIVITYENGINEGUID, MOJConstants.MOJ_SOAPXML, strMOJClaimNumber, strActivityEngineGUID, strIsAgreed);
		if (strLatestActivityEngineGuid != null)
		{
			System.out.println ("The LatestActivityEngineGuid is: " + strLatestActivityEngineGuid);

		}
		else
		{
			throw new InputDocumentNotValid ();
		}

		return strLatestActivityEngineGuid;
	}
	
	public String setAdditionalDamagesExistence (String strMOJClaimNumber, String strActivityEngineGUID, String strAdditionalDamagesExist) throws Exception
	{

		SoapConnection soap = new SoapConnection ();
		String strLatestActivityEngineGuid = soap.extractTagValue (MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_SETADDITIONALDAMAGESEXIST,
				MOJConstants.MOJ_ACTIVITYENGINEGUID, MOJConstants.MOJ_SOAPXML, strMOJClaimNumber, strActivityEngineGUID, strAdditionalDamagesExist);
		if (strLatestActivityEngineGuid != null)
		{
			System.out.println ("The LatestActivityEngineGuid is: " + strLatestActivityEngineGuid);

		}
		else
		{
			throw new InputDocumentNotValid ();
		}

		return strLatestActivityEngineGuid;
	}
	
	public String addInterimSPFRequest (String strMOJClaimNumber, String strActivityEngineGUID) throws Exception
	{

		SoapConnection soap = new SoapConnection ();
		String strPhaseCacheName = soap.extractTagValue (MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_ADDINTERIMSPFREQUEST, MOJConstants.MOJ_PHASECACHENAME,
				MOJConstants.MOJ_SOAPXML, strMOJClaimNumber, strActivityEngineGUID);
		if (strPhaseCacheName != null)
		{
			System.out.println ("The PhaseCacheName is: " + strPhaseCacheName);

		}
		else
		{
			throw new InputDocumentNotValid ();
		}

		return strPhaseCacheName;
	}

	public String addStage2SPFRequest (String strMOJClaimNumber, String strActivityEngineGUID) throws Exception 
	{

		SoapConnection soap = new SoapConnection ();
		String strPhaseCacheName = soap.extractTagValue(MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_ADDSTAGE2SPFREQUEST,
				MOJConstants.MOJ_PHASECACHENAME, MOJConstants.MOJ_SOAPXML, strMOJClaimNumber, strActivityEngineGUID);
		if (strPhaseCacheName != null) 
		{
			System.out.println("The PhaseCacheName is: " + strPhaseCacheName);

		} else 
		{
			throw new InputDocumentNotValid ();
		}

		return strPhaseCacheName;
	}
	
	public String addS2SPFAdditionalDamagesRequest (String strMOJClaimNumber, String strActivityEngineGUID) throws Exception 
	{

		SoapConnection soap = new SoapConnection ();
		String strPhaseCacheName = soap.extractTagValue(MOJConstants.INTERFACE_MOJ, MOJConstants.MOJ_ADDS2SPFADDITIONALDAMAGESREQUEST,
				MOJConstants.MOJ_PHASECACHENAME, MOJConstants.MOJ_SOAPXML, strMOJClaimNumber, strActivityEngineGUID);
		if (strPhaseCacheName != null) 
		{
			System.out.println("The PhaseCacheName is: " + strPhaseCacheName);

		} else 
		{
			throw new InputDocumentNotValid ();
		}

		return strPhaseCacheName;
	}

}
