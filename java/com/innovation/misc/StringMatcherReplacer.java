package com.innovation.misc;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lushs - This class contains the method to search for and replace data in a given string.
 *
 */

public class StringMatcherReplacer
{
	public String substituteAllTokens (Map<String, String> tokensMap, String toInspect)
	{
		String regex = "\\$\\{([^}]+)\\}";
		Pattern pattern = Pattern.compile (regex);
		Matcher matcher = pattern.matcher (toInspect);
		String result = toInspect;
		while (matcher.find ())
		{
			String token = matcher.group (); // Example: ${ClientID}
			String tokenKey = matcher.group (1); // Example: ClientID
			String replacementValue = null;

			if (tokensMap.containsKey (tokenKey))
				replacementValue = tokensMap.get (tokenKey);
			else
				throw new RuntimeException ("String contained an unsupported token.");

			result = result.replaceFirst (Pattern.quote (token), replacementValue);
		}
		// System.out.println ("The Soap XML has had its parametrised replaced " + result);
		return result;
	}
}
