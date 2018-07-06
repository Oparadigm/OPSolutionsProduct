package com.innovation.regressionsuite.todelete;
/**
 * 
 */
/*
 * package com.innovation.regressionsuite;
 * 
 * import org.testng.annotations.Test;
 * 
 * import com.innovation.misc.SeleniumPageCoverage; import
 * com.innovation.regression.base.claims.regression.TEST_AddNoPolicyHomeownerClaim; import
 * com.innovation.regression.base.claims.regression.TEST_AddWithPolicyHomeownerClaim; import
 * com.innovation.regression.base.claims.regression.TEST_AddWithPolicyHomeownerClaimWithTP; import
 * com.innovation.regression.base.claims.regression.TEST_AddWithPolicyHomeownerFireClaim; import
 * com.innovation.regression.base.claims.regression.TEST_AddWithPolicyHomeownerStormClaimWithTP; import
 * com.innovation.regression.base.claims.regression.TEST_AddWithPolicyMotorClaimWithTP; import
 * com.innovation.regression.base.claims.regression.TEST_AddWithPolicyMotorFireClaimWithTP; import
 * com.innovation.regression.base.claims.regression.TEST_AddWithPolicyMotorTheftClaimWithTP; import
 * com.innovation.regression.base.common.regression.TEST_VerifyAddIndividualClient; import
 * com.innovation.regression.base.policy.regression.TEST_UKAddHomeownerQuote; import
 * com.innovation.regression.base.policy.regression.TEST_HomeownersCreateQuoteAndBuyQuote; import
 * com.innovation.regression.base.policy.regression.TEST_UKHomeownersStraightNewBusiness;
 * 
 *//**
	 * @author
	 *
	 *//*
		 * 
		 * public class MasterTestFile {
		 * 
		 * @Test public void masterTestFile () throws Exception { // String strEnvironmentValue = "Environment1"; // Variable inputs
		 * for text method // int myNumberInput = 5; // String myTextInput = "Arron";
		 * 
		 * // Instantiate object containing required tests
		 * 
		 * //
		 * ***************Claims***************************************************************************************************
		 * 
		 * try { TEST_AddNoPolicyHomeownerClaim addnopolicyhomeownerclaimtest = new TEST_AddNoPolicyHomeownerClaim ();
		 * addnopolicyhomeownerclaimtest.addNoPolicyHomeownerClaim (); SeleniumPageCoverage.printPageCoverage (); Runtime.getRuntime
		 * ().exec ("taskkill /im chromedriver.exe /f"); } catch (Exception e) { // TODO Auto-generated catch block
		 * Runtime.getRuntime ().exec ("taskkill /im chromedriver.exe /f"); SeleniumPageCoverage.printPageCoverage ();
		 * e.printStackTrace (); }
		 * 
		 * try { TEST_AddWithPolicyHomeownerClaim addwithpolicyhomeownerclaimtest = new TEST_AddWithPolicyHomeownerClaim ();
		 * addwithpolicyhomeownerclaimtest.addWithPolicyHomeownerClaim (); SeleniumPageCoverage.printPageCoverage (); } catch
		 * (Exception e) { // TODO Auto-generated catch block SeleniumPageCoverage.printPageCoverage (); e.printStackTrace (); }
		 * 
		 * try { TEST_AddWithPolicyHomeownerClaimWithTP addwithpolicyhomeownerclaimWithtptest = new
		 * TEST_AddWithPolicyHomeownerClaimWithTP (); addwithpolicyhomeownerclaimWithtptest.addWithPolicyHomeownerClaimWithTP ();
		 * SeleniumPageCoverage.printPageCoverage (); } catch (Exception e) { // TODO Auto-generated catch block
		 * SeleniumPageCoverage.printPageCoverage (); e.printStackTrace (); }
		 * 
		 * try { TEST_AddWithPolicyHomeownerFireClaim addwithpolicyhomeownerfireclaim = new TEST_AddWithPolicyHomeownerFireClaim ();
		 * addwithpolicyhomeownerfireclaim.addWithPolicyHomeownerFireClaim (); SeleniumPageCoverage.printPageCoverage (); } catch
		 * (Exception e) { // TODO Auto-generated catch block SeleniumPageCoverage.printPageCoverage (); e.printStackTrace (); }
		 * 
		 * try { TEST_AddWithPolicyHomeownerStormClaimWithTP addwithpolicyhomeownerstormclaimwithtp = new
		 * TEST_AddWithPolicyHomeownerStormClaimWithTP ();
		 * addwithpolicyhomeownerstormclaimwithtp.addWithPolicyHomeownerStormClaimWithTP (); SeleniumPageCoverage.printPageCoverage
		 * (); } catch (Exception e) { // TODO Auto-generated catch block SeleniumPageCoverage.printPageCoverage ();
		 * e.printStackTrace (); }
		 * 
		 * try { TEST_AddWithPolicyMotorClaimWithTP addwithpolicymotorclaimWithtptest = new TEST_AddWithPolicyMotorClaimWithTP ();
		 * addwithpolicymotorclaimWithtptest.addWithPolicyMotorClaimWithTP (); SeleniumPageCoverage.printPageCoverage (); } catch
		 * (Exception e) { // TODO Auto-generated catch block SeleniumPageCoverage.printPageCoverage (); e.printStackTrace (); }
		 * 
		 * try { TEST_AddWithPolicyMotorFireClaimWithTP addwithpolicymotorfireclaimwithTP = new
		 * TEST_AddWithPolicyMotorFireClaimWithTP (); addwithpolicymotorfireclaimwithTP.addWithPolicyMotorClaimWithTPFire ();
		 * SeleniumPageCoverage.printPageCoverage (); } catch (Exception e) { // TODO Auto-generated catch block
		 * SeleniumPageCoverage.printPageCoverage (); e.printStackTrace (); }
		 * 
		 * try { TEST_AddWithPolicyMotorTheftClaimWithTP addwithpolicymotortheftclaimwithTP = new
		 * TEST_AddWithPolicyMotorTheftClaimWithTP (); addwithpolicymotortheftclaimwithTP.addWithPolicyMotorTheftClaimWithTP ();
		 * SeleniumPageCoverage.printPageCoverage (); } catch (Exception e) { // TODO Auto-generated catch block
		 * SeleniumPageCoverage.printPageCoverage (); e.printStackTrace (); }
		 * 
		 * // ***************Common*************************************************************************************************
		 * 
		 * 
		 * try { TEST_AddAgentWithCompanyClientTest addagentwithcompanyclienttest = new TEST_AddAgentWithCompanyClientTest ();
		 * addagentwithcompanyclienttest.addAgentWithCompanyClient (); SeleniumPageCoverage.printPageCoverage (); } catch (Exception
		 * e) { // TODO Auto-generated catch block e.printStackTrace (); }
		 * 
		 * 
		 * try { TEST_VerifyAddIndividualClient verifyaddindividualclient = new TEST_VerifyAddIndividualClient ();
		 * verifyaddindividualclient.verifyAddIndividualClient (); SeleniumPageCoverage.printPageCoverage (); } catch (Exception e)
		 * { // TODO Auto-generated catch block e.printStackTrace (); }
		 * 
		 * // Instantiate object containing required tests // Deleting below code because this script is removed now as of duplicate
		 * 
		 * // Instantiate object containing required tests try { TEST_UKAddHomeownerQuote ukaddHomeOwnerquote = new
		 * TEST_UKAddHomeownerQuote (); ukaddHomeOwnerquote.addHomeownerQuote (); SeleniumPageCoverage.printPageCoverage (); } catch
		 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace (); }
		 * 
		 * // ***************Policy***************************************************************************************
		 * 
		 * try { TEST_UKAddHomeownerQuote ukaddhomeownerquote = new TEST_UKAddHomeownerQuote ();
		 * ukaddhomeownerquote.addHomeownerQuote (); SeleniumPageCoverage.printPageCoverage (); } catch (Exception e) { // TODO
		 * Auto-generated catch block SeleniumPageCoverage.printPageCoverage (); e.printStackTrace (); }
		 * 
		 * try { TEST_HomeownersCreateQuoteAndBuyQuote ukhomeownerscreatequoteandbuyquote = new
		 * TEST_HomeownersCreateQuoteAndBuyQuote (); ukhomeownerscreatequoteandbuyquote.uKHomeownersCreateQuoteAndBuyQuote ();
		 * SeleniumPageCoverage.printPageCoverage (); } catch (Exception e) { // TODO Auto-generated catch block
		 * SeleniumPageCoverage.printPageCoverage (); e.printStackTrace (); }
		 * 
		 * try { TEST_UKHomeownersStraightNewBusiness ukhomeownersstraightnewbusinesstest = new TEST_UKHomeownersStraightNewBusiness
		 * (); ukhomeownersstraightnewbusinesstest.ukHomeownersStraightNewBusiness (); SeleniumPageCoverage.printPageCoverage (); }
		 * catch (Exception e) { // TODO Auto-generated catch block SeleniumPageCoverage.printPageCoverage (); e.printStackTrace ();
		 * }
		 * 
		 * }
		 * 
		 * }
		 */
