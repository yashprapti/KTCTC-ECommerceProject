/**
 * 
 */
package ktctc.ecommerce1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ktctc.ecommerce.base.BaseClass;
import ktctc.ecommerce.pageobject.IndexPage;
import ktctc.ecommerce.pageobject.LoginPage;
import ktctc.ecommerce.pageobject.SerchPage;
import ktctc.ecommerce.utility.Log;

/**
 * @author LENOVO
 *
 */
public class IndexPagetest extends BaseClass{
	
	LoginPage loginpage;
	IndexPage indexpage;
	SerchPage searchpage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.get().quit();
	}
	
	@Test
	public void validateSearchProduct() {
		Log.startTestCase("validateSearchProduct");
		loginpage = new LoginPage();
		Log.info("User is Trying to enter username and password");
		indexpage = loginpage.loginToIndexPage(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("User Enetered username and password Successfully");
		searchpage = indexpage.searchForProduct("palak");
		boolean result = searchpage.verifySearchResult();
		Log.info("User Is Validating Product Search");
		Assert.assertTrue(result);
		Log.info("Product Search Validation Successfull");
		Log.endTestCase("validateSearchProduct");
	}

}
