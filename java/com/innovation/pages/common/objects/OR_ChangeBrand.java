// @Author Tahir Akbar, this class contains all the objects require to script the page ChangeBrand

package com.innovation.pages.common.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OR_ChangeBrand
{

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Change brand")
	public WebElement	lnkChangeBrand;

	// @CacheLookup
	@FindBy(how = How.ID, using = "userBrandCombo")
	public WebElement	ddlChangeBrand;

	//@CacheLookup
	@FindBy(how = How.ID, using = "changeUserBrandSave")
	public WebElement	btnChangeBrand;
}
