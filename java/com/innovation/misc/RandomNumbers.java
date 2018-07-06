/**
 * 
 */
package com.innovation.misc;

import java.util.Random;

/**
 * @author Kamran Mahmood This generates a Random Number, just need to enter the length of the number when calling the class.
 *
 */
public class RandomNumbers
{
	public static String produceRandomNumber (Integer LenString)
	{
		// This function produces a random string based off a length parm.
		String SALTNUMBERS = "1234567890";
		StringBuilder salt = new StringBuilder ();
		Random rnd = new Random ();
		while (salt.length () < LenString)
		{ // length of the random string.
			int index = (int) (rnd.nextFloat () * SALTNUMBERS.length ());
			salt.append (SALTNUMBERS.charAt (index));
		}
		String saltStr = salt.toString ();
		return saltStr;
	}

	public static int randomNumberGenerator (int min, int max)
	{
		Random rand = new Random ();
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int intRandomNum = rand.nextInt ((max - min) + 1) + min;
		return intRandomNum;
	}

	// This class was created by Tobi and is used for to randomise the selection on drop downs.
	// The class is ingrained in the Insurer Pages so worth adding in even if we never use it.
	public static int randomSelect (int max)
	{
		return (int) (Math.random () * (max - 2)) + 2;
	}

}
