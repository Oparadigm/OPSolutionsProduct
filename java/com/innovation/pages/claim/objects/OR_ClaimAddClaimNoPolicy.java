package com.innovation.pages.claim.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/*
*  @author Rizwan. Defining the objects for Add claim - no policy pop up in Homeowner claim.
*  
*/
public class OR_ClaimAddClaimNoPolicy 
{

	   @CacheLookup
       @FindBy(how = How.ID, using = "CLM_SC_099_AddClaim_dol")
       public  WebElement dtpLossDate;
       
       @CacheLookup
       @FindBy(how = How.ID, using = "CLM_SC_099_AddClaim_lob")
       public  WebElement ddlLineOfBusiness;
       
       @CacheLookup
       @FindBy(how = How.ID, using = "genNotesSubmit")
       public  WebElement btnCreate;
       
       @CacheLookup
       @FindBy(how = How.ID, using = "genNotesCancel")
       public  WebElement btnCancel;
                            
}



