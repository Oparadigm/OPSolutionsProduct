package com.innovation.misc;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Kamran
 *
 */

public class RandomCount
{

	public static int selectRandomItem (Select oSelectItems)
	{
		List<WebElement> options = oSelectItems.getOptions ();
		int limit = options.size ();
		limit = limit - 1;
		int number = RandomNumbers.randomNumberGenerator (1, limit);
		return number;
	}
}
