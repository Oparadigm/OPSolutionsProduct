package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
 *  @author Rubina - defining the objects for 'MOJ Communications' frame accessible through BO Navigation panel > Bodily injury > MOJ Communications 
 *  
 */

public class OR_ClaimMOJCommunications
{

	// Controls for MOJ Communications
	
	@CacheLookup
	@FindBy(how = How.ID, using = "printableDocsTable")
	public WebElement tblPrintableDocument;
	
	@CacheLookup
	@FindBy(how = How.ID, using = "btnMOJPrintableDocView")
	public WebElement btnView;

}
