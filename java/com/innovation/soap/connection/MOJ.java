package com.innovation.soap.connection;

import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import com.innovation.data.XMLDataReader;

public class MOJ
{

	public SOAPMessage createSoapRequest (String strInterface, String strMethodName, String strXMLFileName) throws SOAPException, IOException
	{
		return createSoapRequest (strInterface, strMethodName, strXMLFileName, null, null, null);
	}

	public SOAPMessage createSoapRequest (String strInterface, String strMethodName, String strXMLFileName, String strMOJClaimNumber)
			throws SOAPException, IOException
	{
		return createSoapRequest (strInterface, strMethodName, strXMLFileName, strMOJClaimNumber, null, null);
	}

	public SOAPMessage createSoapRequest (String strInterface, String strMethodName, String strXMLFileName, String strMOJClaimNumber,
			String strActivityEngineGUID) throws SOAPException, IOException
	{
		return createSoapRequest (strInterface, strMethodName, strXMLFileName, strMOJClaimNumber, strActivityEngineGUID);
	}

	public SOAPMessage createSoapRequest (String strInterface, String strMethodName, String strXMLFileName, String strMOJClaimNumber,
			String strActivityEngineGUID, String strIsTagValue) throws SOAPException, IOException
	{
		SOAPBody soapBody = null;
		SOAPElement soapElement = null;
		SOAPMessage soapMessage = null;

		// Common
		XMLDataReader returnXMLString = new XMLDataReader ();
		String strPrefix = returnXMLString.ReturnXMLNode ("namespace", "prefix", strXMLFileName);
		String strURI = returnXMLString.ReturnXMLNode ("namespace", "uri", strXMLFileName);
		String strAsUser = returnXMLString.ReturnXMLNode (MOJConstants.INTERFACE_MOJ, "user", MOJConstants.INTERFACECREDENTIALS);
		String strUsername = returnXMLString.ReturnXMLNode (MOJConstants.INTERFACE_MOJ, "username", MOJConstants.INTERFACECREDENTIALS);
		String strPassword = returnXMLString.ReturnXMLNode (MOJConstants.INTERFACE_MOJ, "password", MOJConstants.INTERFACECREDENTIALS);
		String strApplicationId = returnXMLString.ReturnXMLNode ("body", "applicationId", strXMLFileName);
		String strClaimData = returnXMLString.ReturnXMLNode ("body", "claimData", strXMLFileName);
		String strActivityEngineGuid = returnXMLString.ReturnXMLNode ("body", "activityEngineGuid", strXMLFileName);

		// Add Claim
		String strMethod_addClaim = returnXMLString.ReturnXMLNode ("body", "method_addClaim", strXMLFileName);
		String strBodyPrefix = returnXMLString.ReturnXMLNode ("body", "prefix", strXMLFileName);
		String strClaimXML = returnXMLString.ReturnXMLNode ("body", "ClaimXML", strXMLFileName);
		String strCDATA = returnXMLString.ReturnXMLNode ("body", "ClaimXMLCDATA", strXMLFileName);

		// Add Child Claim
		String strMethod_addChildClaim = returnXMLString.ReturnXMLNode ("body", "method_addClaim", strXMLFileName);
		String strChildBodyPrefix = returnXMLString.ReturnXMLNode ("body", "prefix", strXMLFileName);
		String strChildClaimXML = returnXMLString.ReturnXMLNode ("body", "ClaimXML", strXMLFileName);
		String strChildClaimCDATA = returnXMLString.ReturnXMLNode ("body", "ChildClaimCDATA", strXMLFileName);

		// Get Claim
		String strMethod_getClaim = returnXMLString.ReturnXMLNode ("body", "method_getClaim", strXMLFileName);

		// AddInterimSPFRequest
		String strMethod_AddInterimSPFRequest = returnXMLString.ReturnXMLNode ("body", "method_AddInterimSPFRequest", strXMLFileName);
		String strISPFRequestXML = returnXMLString.ReturnXMLNode ("body", "ISPFRequestXML", strXMLFileName);
		String strISPFRequestXMLCDATA = returnXMLString.ReturnXMLNode ("body", "ISPFRequestXMLCDATA", strXMLFileName);

		// GetClaimsStatus
		String strMethod_getClaimsStatus = returnXMLString.ReturnXMLNode ("body", "method_getClaimsStatus", strXMLFileName);

		// AcknowledgeLiabilityAdmitted
		String strMethod_acknowledgeLiabilityAdmitted = returnXMLString.ReturnXMLNode ("body", "method_acknowledgeLiabilityAdmitted", strXMLFileName);

		// SetInterimPaymentNeeded
		String strMethod_setInterimPaymentNeeded = returnXMLString.ReturnXMLNode ("body", "method_setInterimPaymentNeeded", strXMLFileName);
		String strIsInterimPaymentNeeded = returnXMLString.ReturnXMLNode ("body", "isInterimPaymentNeeded", strXMLFileName);

		// SetStage2SPFCounterOfferNeeded
		String strMethod_setStage2SPFCounterOfferNeeded = returnXMLString.ReturnXMLNode ("body", "method_setStage2SPFCounterOfferNeeded", strXMLFileName);
		String strIsStage2SPFCounterOfferNeeded = returnXMLString.ReturnXMLNode ("body", "isStage2SPFCounterOfferNeeded", strXMLFileName);

		// setAdditionalDamagesExistence
		String strMethod_setAdditionalDamagesExistence = returnXMLString.ReturnXMLNode ("body", "method_setAdditionalDamagesExistence", strXMLFileName);
		String strAdditionalDamagesExist = returnXMLString.ReturnXMLNode ("body", "additionalDamagesExist", strXMLFileName);

		// setStage2SPFAgreementDecision
		String strMethod_setStage2SPFAgreementDecision = returnXMLString.ReturnXMLNode ("body", "method_setStage2SPFAgreementDecision", strXMLFileName);
		String strIsAgreed = returnXMLString.ReturnXMLNode ("body", "isAgreed", strXMLFileName);

		// AddStage2SPFRequest
		String strMethod_AddStage2SPFRequest = returnXMLString.ReturnXMLNode ("body", "method_AddStage2SPFRequest", strXMLFileName);
		String strS2SPFRequestXML = returnXMLString.ReturnXMLNode ("body", "S2SPFRequestXML", strXMLFileName);
		String strS2SPFRequestXMLCDATA = returnXMLString.ReturnXMLNode ("body", "S2SPFRequestXMLCDATA", strXMLFileName);

		// AddS2SPFAdditionalDamagesRequest
		String strMethod_AddS2SPFAdditionalDamagesRequest = returnXMLString.ReturnXMLNode ("body", "method_AddS2SPFAdditionalDamagesRequest", strXMLFileName);
		String strAdditionalDamagesRequestXML = returnXMLString.ReturnXMLNode ("body", "additionalDamagesRequestXML", strXMLFileName);
		String strAdditionalDamagesRequestXMLCDATA = returnXMLString.ReturnXMLNode ("body", "additionalDamagesRequestXMLCDATA", strXMLFileName);

		// Soap Request XML Creation Starts Here
		MessageFactory messageFactory = MessageFactory.newInstance ();
		soapMessage = messageFactory.createMessage ();
		SOAPPart soapPart = soapMessage.getSOAPPart ();
		SOAPEnvelope soapEnvelope = soapPart.getEnvelope ();

		switch (strMethodName.toUpperCase ())
		{

			case "ADDCLAIM":
			{
				soapEnvelope.addNamespaceDeclaration (strPrefix, strURI);
				soapBody = soapEnvelope.getBody ();
				soapElement = soapBody.addChildElement (strMethod_addClaim, strBodyPrefix);
				SOAPElement element_addClaim = soapElement.addChildElement (strClaimXML);
				element_addClaim.addTextNode (strCDATA);
				break;
			}

			case "ADDCHILDCLAIM":
			{
				soapEnvelope.addNamespaceDeclaration (strPrefix, strURI);
				soapBody = soapEnvelope.getBody ();
				soapElement = soapBody.addChildElement (strMethod_addChildClaim, strChildBodyPrefix);
				SOAPElement element_addChildClaim = soapElement.addChildElement (strChildClaimXML);
				element_addChildClaim.addTextNode (strChildClaimCDATA);
				break;
			}

			case "GETCLAIM":
			{
				soapEnvelope.addNamespaceDeclaration (strPrefix, strURI);
				soapBody = soapEnvelope.getBody ();
				soapElement = soapBody.addChildElement (strMethod_getClaim, strBodyPrefix);
				SOAPElement element_applicationId = soapElement.addChildElement (strApplicationId);
				element_applicationId.addTextNode (strMOJClaimNumber);
				break;
			}
			case "GETCLAIMSSTATUS":
			{
				soapEnvelope.addNamespaceDeclaration (strPrefix, strURI);
				soapBody = soapEnvelope.getBody ();
				soapElement = soapBody.addChildElement (strMethod_getClaimsStatus, strBodyPrefix);
				SOAPElement element_applicationId = soapElement.addChildElement (strApplicationId);
				element_applicationId.addTextNode (strMOJClaimNumber);
				break;
			}
			case "ACKNOWLEDGELIABILITYADMITTED":
			{
				soapEnvelope.addNamespaceDeclaration (strPrefix, strURI);
				soapBody = soapEnvelope.getBody ();
				soapElement = soapBody.addChildElement (strMethod_acknowledgeLiabilityAdmitted, strBodyPrefix);
				SOAPElement element_AcknowledgeLiabilityAdmitted = soapElement.addChildElement (strClaimData);
				SOAPElement element_ActivityEngineGuid = element_AcknowledgeLiabilityAdmitted.addChildElement (strActivityEngineGuid);
				element_ActivityEngineGuid.addTextNode (strActivityEngineGUID);
				SOAPElement element_applicationId = element_AcknowledgeLiabilityAdmitted.addChildElement (strApplicationId);
				element_applicationId.addTextNode (strMOJClaimNumber);
				break;
			}
			case "SETINTERIMPAYMENTNEEDED":
			{
				soapEnvelope.addNamespaceDeclaration (strPrefix, strURI);
				soapBody = soapEnvelope.getBody ();
				soapElement = soapBody.addChildElement (strMethod_setInterimPaymentNeeded, strBodyPrefix);
				SOAPElement element_SetInterimPaymentNeeded = soapElement.addChildElement (strClaimData);
				SOAPElement element_ActivityEngineGuid = element_SetInterimPaymentNeeded.addChildElement (strActivityEngineGuid);
				element_ActivityEngineGuid.addTextNode (strActivityEngineGUID);
				SOAPElement element_applicationId = element_SetInterimPaymentNeeded.addChildElement (strApplicationId);
				element_applicationId.addTextNode (strMOJClaimNumber);
				soapElement.addChildElement (strIsInterimPaymentNeeded).addTextNode (strIsTagValue);
				break;
			}
			case "SETSTAGE2SPFCOUNTEROFFERNEEDED":
			{
				soapEnvelope.addNamespaceDeclaration (strPrefix, strURI);
				soapBody = soapEnvelope.getBody ();
				soapElement = soapBody.addChildElement (strMethod_setStage2SPFCounterOfferNeeded, strBodyPrefix);
				SOAPElement element_SetStage2SPFCounterOfferNeeded = soapElement.addChildElement (strClaimData);
				SOAPElement element_ActivityEngineGuid = element_SetStage2SPFCounterOfferNeeded.addChildElement (strActivityEngineGuid);
				element_ActivityEngineGuid.addTextNode (strActivityEngineGUID);
				SOAPElement element_applicationId = element_SetStage2SPFCounterOfferNeeded.addChildElement (strApplicationId);
				element_applicationId.addTextNode (strMOJClaimNumber);
				soapElement.addChildElement (strIsStage2SPFCounterOfferNeeded).addTextNode (strIsTagValue);
				break;
			}
			
			case "SETSTAGE2SPFAGREEMENTDECISION":
			{
				soapEnvelope.addNamespaceDeclaration (strPrefix, strURI);
				soapBody = soapEnvelope.getBody ();
				soapElement = soapBody.addChildElement (strMethod_setStage2SPFAgreementDecision, strBodyPrefix);
				SOAPElement element_SetStage2SPFAgreementDecision = soapElement.addChildElement (strClaimData);
				SOAPElement element_ActivityEngineGuid = element_SetStage2SPFAgreementDecision.addChildElement (strActivityEngineGuid);
				element_ActivityEngineGuid.addTextNode (strActivityEngineGUID);
				SOAPElement element_applicationId = element_SetStage2SPFAgreementDecision.addChildElement (strApplicationId);
				element_applicationId.addTextNode (strMOJClaimNumber);
				soapElement.addChildElement (strIsAgreed).addTextNode (strIsTagValue);
				break;
			}
			
			case "SETADDITIONALDAMAGESEXIST":
			{
				soapEnvelope.addNamespaceDeclaration (strPrefix, strURI);
				soapBody = soapEnvelope.getBody ();
				soapElement = soapBody.addChildElement (strMethod_setAdditionalDamagesExistence, strBodyPrefix);
				SOAPElement element_SetAdditionalDamagesExistence = soapElement.addChildElement (strClaimData);
				SOAPElement element_ActivityEngineGuid = element_SetAdditionalDamagesExistence.addChildElement (strActivityEngineGuid);
				element_ActivityEngineGuid.addTextNode (strActivityEngineGUID);
				SOAPElement element_applicationId = element_SetAdditionalDamagesExistence.addChildElement (strApplicationId);
				element_applicationId.addTextNode (strMOJClaimNumber);
				soapElement.addChildElement (strAdditionalDamagesExist).addTextNode (strIsTagValue);
				break;
			}
			case "ADDINTERIMSPFREQUEST":
			{
				soapEnvelope.addNamespaceDeclaration (strPrefix, strURI);
				soapBody = soapEnvelope.getBody ();
				soapElement = soapBody.addChildElement (strMethod_AddInterimSPFRequest, strBodyPrefix);
				SOAPElement element_AddInterimSPFRequest = soapElement.addChildElement (strClaimData);
				element_AddInterimSPFRequest.addChildElement (strActivityEngineGuid).addTextNode (strActivityEngineGUID);
				element_AddInterimSPFRequest.addChildElement (strApplicationId).addTextNode (strMOJClaimNumber);
				SOAPElement element_ISPFRequestXML = soapElement.addChildElement (strISPFRequestXML);
				element_ISPFRequestXML.addTextNode (strISPFRequestXMLCDATA);
				break;
			}
			case "ADDSTAGE2SPFREQUEST":
			{
				soapEnvelope.addNamespaceDeclaration (strPrefix, strURI);
				soapBody = soapEnvelope.getBody ();
				soapElement = soapBody.addChildElement (strMethod_AddStage2SPFRequest, strBodyPrefix);
				SOAPElement element_AddStage2SPFRequest = soapElement.addChildElement (strClaimData);
				element_AddStage2SPFRequest.addChildElement (strActivityEngineGuid).addTextNode (strActivityEngineGUID);
				element_AddStage2SPFRequest.addChildElement (strApplicationId).addTextNode (strMOJClaimNumber);
				SOAPElement element_S2SPFRequestXML = soapElement.addChildElement (strS2SPFRequestXML);
				element_S2SPFRequestXML.addTextNode (strS2SPFRequestXMLCDATA);
				break;
			}

			case "ADDS2SPFADDITIONALDAMAGESREQUEST":
			{
				soapEnvelope.addNamespaceDeclaration (strPrefix, strURI);
				soapBody = soapEnvelope.getBody ();
				soapElement = soapBody.addChildElement (strMethod_AddS2SPFAdditionalDamagesRequest, strBodyPrefix);
				SOAPElement element_AddS2SPFAdditionalDamagesRequest = soapElement.addChildElement (strClaimData);
				element_AddS2SPFAdditionalDamagesRequest.addChildElement (strActivityEngineGuid).addTextNode (strActivityEngineGUID);
				element_AddS2SPFAdditionalDamagesRequest.addChildElement (strApplicationId).addTextNode (strMOJClaimNumber);
				SOAPElement element_AdditionalDamagesRequestXML = soapElement.addChildElement (strAdditionalDamagesRequestXML);
				element_AdditionalDamagesRequestXML.addTextNode (strAdditionalDamagesRequestXMLCDATA);
				break;
			}

			default:

				System.out.println ("Please provide the correct MOJ method to process.");
		}

		SOAPElement element_auth = soapElement.addChildElement ("userAuth");
		element_auth.addChildElement ("asUser").addTextNode (strAsUser);
		element_auth.addChildElement ("password").addTextNode (strPassword);
		element_auth.addChildElement ("username").addTextNode (strUsername);
		soapMessage.saveChanges ();

		// Un-comment below lines for debug purposes
		// System.out.println("----------SOAP Request------------");
		// soapMessage.writeTo(System.out);
		return soapMessage;
	}

	public class CreateSoapResponse
	{
		public void createSoapResponse (SOAPMessage soapResponse) throws Exception
		{
			TransformerFactory transformerFactory = TransformerFactory.newInstance ();
			Transformer transformer = transformerFactory.newTransformer ();
			Source sourceContent = soapResponse.getSOAPPart ().getContent ();
			System.out.println ("\n----------SOAP Response-----------");
			StreamResult result = new StreamResult (System.out);
			transformer.transform (sourceContent, result);
		}
	}

}
