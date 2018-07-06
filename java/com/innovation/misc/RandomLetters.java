/**
 * 
 */
package com.innovation.misc;

import java.util.Random;

/**
 * @author lushs * This generates Random Letters, just need to enter the length when calling the class.
 */
public class RandomLetters
{
	public static String produceRandomString (Integer LenString)
	{
		// This function produces a random string based off a length parm.
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder ();
		Random rnd = new Random ();
		while (salt.length () < LenString)
		{ // length of the random string.
			int index = (int) (rnd.nextFloat () * SALTCHARS.length ());
			salt.append (SALTCHARS.charAt (index));
		}
		String saltStr = salt.toString ();
		return saltStr;
	}
}
