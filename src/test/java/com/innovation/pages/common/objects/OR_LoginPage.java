/**
 * 
 */
package com.innovation.pages.common.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author lushs
 *
 */
public class OR_LoginPage
{

	@CacheLookup
	@FindBy(how = How.ID, using = "username")
	public WebElement	txtUsernameField;

	@CacheLookup
	@FindBy(how = How.ID, using = "password")
	public WebElement	txtPasswordField;

	@CacheLookup
	@FindBy(how = How.ID, using = "idLoginButton")
	public WebElement	btnLogin;

}
