package com.innovation.misc;
public class Utils
{
	public static String replaceString (String sInput, String sReplace, String sReplaceWith, boolean bTrimReplace, boolean bCaseInsensitive)
	{
		// The start
		int iStartPos = 0;

		// Similar?
		if (bCaseInsensitive && sReplace.equalsIgnoreCase (sReplaceWith))
			return (sInput);
		if (sReplace.equals (sReplaceWith))
			return (sInput);

		// Replace
		if (bTrimReplace)
			sReplace = sReplace.trim ();

		// Are we case insensitive?
		String sUseInput = sInput;
		String sUseReplace = sReplace;
		if (bCaseInsensitive)
		{
			// Uppercase the values
			sUseInput = sInput.toUpperCase ();
			sUseReplace = sReplace.toUpperCase ();
		}

		// Valid?
		int iPos = sUseInput.indexOf (sUseReplace, iStartPos);
		if (iPos == -1)
			return (sInput);

		// Variuos lengths
		int iInputLen = sInput.length ();
		int iReplaceLen = sReplace.length ();

		// Is it zero
		if (iReplaceLen == 0)
			return (sInput);

		// The return
		StringBuilder sbRet = new StringBuilder (iInputLen);

		// Copy up to here
		while (iPos > -1)
		{
			sbRet.append (sInput.substring (iStartPos, iPos));
			sbRet.append (sReplaceWith);

			iStartPos = iPos + iReplaceLen;
			iPos = sUseInput.indexOf (sUseReplace, iStartPos);
		}

		// Any left over
		if (iStartPos < iInputLen)
			sbRet.append (sInput.substring (iStartPos));

		// return
		return (sbRet.toString ());
	}

}
