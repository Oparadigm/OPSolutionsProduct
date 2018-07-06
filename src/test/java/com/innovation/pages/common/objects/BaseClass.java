/**
 * 
 */
package com.innovation.pages.common.objects;

import org.openqa.selenium.WebDriver;

/**
 * @author lushs
 *
 */
public abstract class BaseClass
{

	public static WebDriver	driver;
	public static boolean	bResult;

	public BaseClass (WebDriver driver)
	{
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}

}
