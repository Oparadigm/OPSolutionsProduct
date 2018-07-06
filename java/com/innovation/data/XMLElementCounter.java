package com.innovation.data;

/**
 * @author lushs - Pass in the Node name and the XML file name.  This class will then count all the nodes in the file and generate a random number between the range.
 *  The number can then be appended to the call to the XMLDataReader to select a random value from the XML file. 
 *
 */

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLElementCounter
{

	// Returns a random selection from the XML File this method name needs to be updated now.
	public Integer ReturnXMLElementCount (String strXmlNode, String strFileName)
	{
		Integer returnInteger = null;

		try
		{
			File inputFile = new File (getClass ().getClassLoader ().getResource ("xml/" + strFileName).getFile ());

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance ();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder ();
			Document doc = dBuilder.parse (inputFile);
			doc.getDocumentElement ().normalize ();

			// XML Element Count - Return all the nodes in the XML file
			NodeList list = doc.getElementsByTagName (strXmlNode);
			// System.out.println ("Total of elements : " + list.getLength ());

			// If the XML file only has one value then the
			if (list.getLength () <= 1)
			{
				returnInteger = 1;
			}
			else
			{
				// Math.Random() returns a number from zero to one - this value is multiplied by the number of nodes in the XML File
				// to generate a random number for selection.
				int intIndex = (int) (Math.random () * list.getLength ());
				// System.out.println ("The element selected is : " + intIndex);
				returnInteger = intIndex;
			}
			// If the Random function generates a 0 then the return is set to 1 so the first row in the file can be extracted.
			if (returnInteger == 0)
			{
				returnInteger = 1;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace ();
		}
		// System.out.print ("The integer returned is : " + returnInteger);
		return returnInteger;
	}
}
