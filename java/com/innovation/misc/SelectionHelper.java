package com.innovation.misc;

import java.util.List;

import org.openqa.selenium.WebElement;

public class SelectionHelper
{

	public static boolean selectRadio (List<WebElement> elements, String value, boolean allowUnknown, boolean allowElse, int elseValue)
	{
		return selectRadio (elements, value, allowUnknown, allowElse, "" + elseValue);
	}

	public static boolean selectRadio (List<WebElement> elements, String value, boolean allowUnknown, boolean allowElse, String elseValue)
	{
		if (value == null)
			return false;

		if (value.equalsIgnoreCase ("Yes") || value.equalsIgnoreCase ("Y"))
		{
			List<WebElement> radiobuttons = elements;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("true") || radiobutton.getAttribute ("value").equals ("1") ||
					radiobutton.getAttribute ("value").equals ("Y") || radiobutton.getAttribute ("value").equals ("Yes"))
				{
					radiobutton.click ();
					return true;
				}
			}
		}
		else if ((value.equalsIgnoreCase ("No") || value.equalsIgnoreCase ("N")))
		{
			List<WebElement> radiobuttons = elements;
			for (WebElement radiobutton : radiobuttons)
			{
				if (radiobutton.getAttribute ("value").equals ("false") || radiobutton.getAttribute ("value").equals ("0") ||
					radiobutton.getAttribute ("value").equals ("N") || radiobutton.getAttribute ("value").equals ("No"))
				{
					radiobutton.click ();
					return false;
				}

			}
		}
		else
		{
			if (allowUnknown)
			{
				if (value.equalsIgnoreCase ("Unknown") || value.equalsIgnoreCase ("U"))
				{
					List<WebElement> radiobuttons = elements;
					for (WebElement radiobutton : radiobuttons)
					{
						if (radiobutton.getAttribute ("value").equals ("-1"))
						{
							radiobutton.click ();
							return false;
						}
					}
				}
			}
			else if (allowElse)
			{
				List<WebElement> radiobuttons = elements;
				for (WebElement radiobutton : radiobuttons)
				{
					if (radiobutton.getAttribute ("value").equals (elseValue))
					{
						radiobutton.click ();
						return false;
					}

				}
			}
		}

		return false;
	}
}
