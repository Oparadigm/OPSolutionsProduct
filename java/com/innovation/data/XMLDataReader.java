package com.innovation.data;

/**
 * @author lushs
 *
 */

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLDataReader
{

	public String ReturnXMLNode (String strXmlElement, String strXmlNode, String strFileName)
	{

		// I am dubious about the naming convention for the xml data reader.
		// xmlElement this is referring to user1 element
		// xmlNode this is referring to user1 username data

		// System.out.println (strFileName);
		String returnString = null;

		// XML Testing END

		try
		{
			File inputFile = new File (getClass ().getClassLoader ().getResource ("xml/" + strFileName).getFile ());

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance ();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder ();
			Document doc = dBuilder.parse (inputFile);
			doc.getDocumentElement ().normalize ();
			NodeList nList = doc.getElementsByTagName (strXmlElement);
			Node nNode = nList.item (0);
			Element eElement = (Element) nNode;
			returnString = eElement.getElementsByTagName (strXmlNode).item (0).getTextContent ();
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		// System.out.print (returnString);
		return returnString;
	}

	public String ReturnXMLNodes (String strXmlElement, String strXmlNode, String strFileName)
	{

		// I am dubious about the naming convention for the xml data reader.
		// xmlElement this is referring to user1 element
		// xmlNode this is referring to user1 username data

		// System.out.println (strFileName);
		String returnString = null;

		// XML Testing END

		try
		{
			File inputFile = new File (getClass ().getClassLoader ().getResource ("xml/" + strFileName).getFile ());

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance ();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder ();
			Document doc = dBuilder.parse (inputFile);
			doc.getDocumentElement ().normalize ();
			NodeList nList = doc.getElementsByTagName (strXmlElement);
			Node nNode = nList.item (0);
			Element eElement = (Element) nNode;
			returnString = eElement.getElementsByTagName (strXmlNode).item (0).getTextContent ();
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		// System.out.print (returnString);
		return returnString;
	}

	public int ReturnXMLNodeInt (String strXmlElement, String strXmlNode, String strFileName)
	{

		// I am dubious about the naming convention for the xml data reader.
		// xmlElement this is referring to user1 element
		// xmlNode this is referring to user1 username data

		// System.out.println (strFileName);

		String returnString = null;
		int returnInt = 0;

		// XML Testing END

		try
		{
			File inputFile = new File (getClass ().getClassLoader ().getResource ("xml/" + strFileName).getFile ());

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance ();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder ();
			Document doc = dBuilder.parse (inputFile);
			doc.getDocumentElement ().normalize ();
			NodeList nList = doc.getElementsByTagName (strXmlElement);
			Node nNode = nList.item (0);
			Element eElement = (Element) nNode;
			returnString = eElement.getElementsByTagName (strXmlNode).item (0).getTextContent ();

			// This is probably poor coding but now going to convert the string to an int.
			returnInt = Integer.parseInt (returnString);

		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		// System.out.print (returnString);
		return returnInt;

	}

}
