package com.innovation.pages.policy.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Tahir- This captures the page elements for the Auto Policy Reinstatement screen if the cancellation reason is
 *         "Non-Payment".
 * 
 */
public class OR_PolicyReinstatement
{

	@CacheLookup
	@FindBy(how = How.ID, using = "policyTitle")
	public WebElement	tlepolicyTitle;

	@CacheLookup
	@FindBy(how = How.ID, using = "SC_PoicyReinstate_EffectiveDte")
	public WebElement	dptReinstatementEffectiveDte;

	@CacheLookup
	@FindBy(how = How.ID, using = "btnProcess")
	public WebElement	btnProcess;

	@CacheLookup
	@FindBy(how = How.ID, using = "igProgress")
	public WebElement	prgProgress;

}
