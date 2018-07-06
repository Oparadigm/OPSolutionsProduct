/**
 * 
 */
package com.innovation.misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lushs This function takes a string of XML data and writes it out in a readable XML format, with line breaks and tabs etc.
 *
 */
public class XMLPrettyPrint
{
	public static String prettyPrintXMLAsString (String xmlString)
	{
		/* Remove new lines */
		final String LINE_BREAK = "\n";
		xmlString = xmlString.replaceAll (LINE_BREAK, "");
		StringBuffer prettyPrintXml = new StringBuffer ();
		/* Group the xml tags */
		Pattern pattern = Pattern.compile ("(<[^/][^>]+>)?([^<]*)(</[^>]+>)?(<[^/][^>]+/>)?");
		Matcher matcher = pattern.matcher (xmlString);
		int tabCount = 0;
		while (matcher.find ())
		{
			String str1 = (null == matcher.group (1) || "null".equals (matcher.group ())) ? "" : matcher.group (1);
			String str2 = (null == matcher.group (2) || "null".equals (matcher.group ())) ? "" : matcher.group (2);
			String str3 = (null == matcher.group (3) || "null".equals (matcher.group ())) ? "" : matcher.group (3);
			String str4 = (null == matcher.group (4) || "null".equals (matcher.group ())) ? "" : matcher.group (4);

			if (matcher.group () != null && !matcher.group ().trim ().equals (""))
			{
				printTabs (tabCount, prettyPrintXml);
				if (!str1.equals ("") && str3.equals (""))
				{
					++tabCount;
				}
				if (str1.equals ("") && !str3.equals (""))
				{
					--tabCount;
					prettyPrintXml.deleteCharAt (prettyPrintXml.length () - 1);
				}

				prettyPrintXml.append (str1);
				prettyPrintXml.append (str2);
				prettyPrintXml.append (str3);
				if (!str4.equals (""))
				{
					prettyPrintXml.append (LINE_BREAK);
					printTabs (tabCount, prettyPrintXml);
					prettyPrintXml.append (str4);
				}
				prettyPrintXml.append (LINE_BREAK);
			}
		}
		return prettyPrintXml.toString ();
	}

	private static void printTabs (int count, StringBuffer stringBuffer)
	{
		for (int i = 0; i < count; i++)
		{
			stringBuffer.append ("\t");
		}
	}

	// This is used to tests the method, it takes the string below and writes it out as in a readable XML format.
	public static void main (String[] args)
	{
		String x = new String (
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Body><ns2:ClientQuotePolicyListResponse xmlns:ns2=\"http://com.innovation\"><ClientQuotePolicyListResult><keyPolActivfrom>10/06/2015</keyPolActivfrom><keyPolCltrefno>508871</keyPolCltrefno><keyPolCltrefpr>HOM</keyPolCltrefpr><keyPolCltseqno>1</keyPolCltseqno><keyPolRefassoc>PH</keyPolRefassoc><keyPolReftype>POL</keyPolReftype><keyQteActivfrom>10/06/2015</keyQteActivfrom><keyQteCltrefno>436350</keyQteCltrefno><keyQteCltrefpr>QTE</keyQteCltrefpr><keyQteCltseqno>1</keyQteCltseqno><keyQteRefassoc>PH</keyQteRefassoc><keyQteReftype>POL</keyQteReftype><polDetailCount>2</polDetailCount><polMoreData/><polRskArray><polRskArray><addrref>984420000</addrref><polrskItemno>1</polrskItemno><polrskPolicy>000508863</polrskPolicy><polrskRiskDesc>Private-passenger2008 JEEP WRANGLER UNLIMITED</polrskRiskDesc><polrskRiskPremium>1191.05</polrskRiskPremium><polrskRiskStatus/><polrskRiskStatus_text/><polrskRiskseq>1</polrskRiskseq></polRskArray><polRskArray><addrref>984420000</addrref><polrskItemno>1</polrskItemno><polrskPolicy>000508871</polrskPolicy><polrskRiskDesc>HO-1-basic-coverage2 Batterson Park Rd Farmington CT 06032-2568</polrskRiskDesc><polrskRiskPremium>394.38</polrskRiskPremium><polrskRiskStatus/><polrskRiskStatus_text/><polrskRiskseq>1</polrskRiskseq></polRskArray></polRskArray><policyArray><policyArray><binderStatus/><polAmendmentsExist>N</polAmendmentsExist><polBustrnno>2</polBustrnno><polCity>FARMINGTON</polCity><polClass>PPA</polClass><polEffectdte>11/06/2015</polEffectdte><polExpiryDate>10/06/2016</polExpiryDate><polFirstItemno>1</polFirstItemno><polInception>10/06/2015</polInception><polLockuser>raveym</polLockuser><polPhClient>572860009</polPhClient><polPhName>Mark Ravey</polPhName><polPolicy>000508863</polPolicy><polPolicyNum>AUT000508863</polPolicyNum><polPostcode>06032-2568</polPostcode><polProduct>AUT</polProduct><polQteproduct/><polRisktype>REGL</polRisktype><polState>CT</polState><polState_text>Connecticut</polState_text><polStatus>Locked policy</polStatus><polStatusCde>K</polStatusCde><polSubcoy>100</polSubcoy><polTailorgrp>01</polTailorgrp><polTermincep>10/06/2015</polTermincep><polTotPremium>1191.05</polTotPremium><polpreviouspolicy>QTE000436350</polpreviouspolicy><reason>0</reason></policyArray><policyArray><binderStatus/><polAmendmentsExist>N</polAmendmentsExist><polBustrnno>1</polBustrnno><polCity>FARMINGTON</polCity><polClass>HME</polClass><polEffectdte>10/06/2015</polEffectdte><polExpiryDate>10/06/2016</polExpiryDate><polFirstItemno>1</polFirstItemno><polInception>10/06/2015</polInception><polLockuser/><polPhClient>572860009</polPhClient><polPhName>Mark Ravey</polPhName><polPolicy>000508871</polPolicy><polPolicyNum>HOM000508871</polPolicyNum><polPostcode>06032-2568</polPostcode><polProduct>HOM</polProduct><polQteproduct/><polRisktype>HO1</polRisktype><polState>CT</polState><polState_text>Connecticut</polState_text><polStatus>Active</polStatus><polStatusCde>G</polStatusCde><polSubcoy>100</polSubcoy><polTailorgrp>02</polTailorgrp><polTermincep>10/06/2015</polTermincep><polTotPremium>394.38</polTotPremium><polpreviouspolicy>QTE000436393</polpreviouspolicy><reason>0</reason></policyArray></policyArray><polrskDetailCount>2</polrskDetailCount><qteDetailCount>2</qteDetailCount><qteMoreData/><qteRskArray><qteRskArray><addrref>984420000</addrref><qterskItemno>1</qterskItemno><qterskPolicy>000436393</qterskPolicy><qterskRiskDesc>HO-1-basic-coverage2 Batterson Park Rd Farmington CT 06032-2568</qterskRiskDesc><qterskRiskPremium>394.38</qterskRiskPremium><qterskRiskStatus/><qterskRiskStatus_text/><qterskRiskseq>1</qterskRiskseq></qteRskArray><qteRskArray><addrref>984420000</addrref><qterskItemno>1</qterskItemno><qterskPolicy>000436350</qterskPolicy><qterskRiskDesc>Private-passenger2008 JEEP WRANGLER UNLIMITED</qterskRiskDesc><qterskRiskPremium>1191.05</qterskRiskPremium><qterskRiskStatus/><qterskRiskStatus_text/><qterskRiskseq>1</qterskRiskseq></qteRskArray></qteRskArray><qterskDetailCount>2</qterskDetailCount><quoteArray><quoteArray><description/><qteBustrnno>1</qteBustrnno><qteCity>FARMINGTON</qteCity><qteClass>HME</qteClass><qteEffectdte>10/06/2015</qteEffectdte><qteExpiryDate/><qteFirstItemno>1</qteFirstItemno><qteInception>10/06/2015</qteInception><qteLockuser/><qtePhClient>572860009</qtePhClient><qtePhName>Mark Ravey</qtePhName><qtePolicy>000436393</qtePolicy><qtePostcode>06032-2568</qtePostcode><qteProduct>QTE</qteProduct><qteQteproduct>HOM</qteQteproduct><qteQuoteNum>QTE000436393</qteQuoteNum><qteRisktype>HO1</qteRisktype><qteState>CT</qteState><qteStateDesc>CT</qteStateDesc><qteStateDesc_text>Connecticut</qteStateDesc_text><qteStatus>S</qteStatus><qteStatusCde>S</qteStatusCde><qteStatus_text>Converted quote</qteStatus_text><qteSubcoy>100</qteSubcoy><qteTailorgrp>02</qteTailorgrp><qteTermincep>10/06/2015</qteTermincep><qteTotPremium>394.38</qteTotPremium></quoteArray><quoteArray><description/><qteBustrnno>1</qteBustrnno><qteCity>FARMINGTON</qteCity><qteClass>PPA</qteClass><qteEffectdte>10/06/2015</qteEffectdte><qteExpiryDate/><qteFirstItemno>1</qteFirstItemno><qteInception>10/06/2015</qteInception><qteLockuser/><qtePhClient>572860009</qtePhClient><qtePhName>Mark Ravey</qtePhName><qtePolicy>000436350</qtePolicy><qtePostcode>06032-2568</qtePostcode><qteProduct>QTE</qteProduct><qteQteproduct>AUT</qteQteproduct><qteQuoteNum>QTE000436350</qteQuoteNum><qteRisktype>REGL</qteRisktype><qteState>CT</qteState><qteStateDesc>CT</qteStateDesc><qteStateDesc_text>Connecticut</qteStateDesc_text><qteStatus>S</qteStatus><qteStatusCde>S</qteStatusCde><qteStatus_text>Converted quote</qteStatus_text><qteSubcoy>100</qteSubcoy><qteTailorgrp>01</qteTailorgrp><qteTermincep>10/06/2015</qteTermincep><qteTotPremium>1191.05</qteTotPremium></quoteArray></quoteArray></ClientQuotePolicyListResult></ns2:ClientQuotePolicyListResponse></soapenv:Body></soapenv:Envelope>");
		System.out.println (prettyPrintXMLAsString (x));
	}
}
