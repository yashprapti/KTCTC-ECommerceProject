/**
 * 
 */
package ktctc.ecommerce1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ktctc.ecommerce.base.BaseClass;
import ktctc.ecommerce.pageobject.AddToCartPage;
import ktctc.ecommerce.pageobject.IndexPage;
import ktctc.ecommerce.pageobject.LoginPage;
import ktctc.ecommerce.pageobject.SerchPage;
import ktctc.ecommerce.utility.Log;

/**
 * @author LENOVO
 *
 */
public class SearchPageTest extends BaseClass{
	
	LoginPage loginpage;
	IndexPage indexpage;
	SerchPage searchpage;
	AddToCartPage addpage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.get().quit();
	}
	
	@Test
	public void validateProductSearchTest() {
		Log.startTestCase("validateProductSearchTest");
		loginpage = new LoginPage();
		Log.info("User is Trying to enter username and password");
		indexpage = loginpage.loginToIndexPage(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("User Enetered username and password Successfully");
		searchpage = indexpage.searchForProduct("palak");
		Log.info("User Entered productname Succeffuly");
		addpage = searchpage.clickOnAddToBasketBtn();
		Log.info("User Is On Add To Cart Page");
		String acproduct = addpage.validateProductSearch();
		String exproduct = "Fresh vegetable direct from Farmer";
		Log.info("Validating Product Search");
		Assert.assertEquals(acproduct, exproduct);
		Log.info("Product Search Validation Successfull");
		Log.endTestCase("validateProductSearchTest");
	}

}
