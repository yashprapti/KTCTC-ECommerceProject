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
import ktctc.ecommerce.pageobject.ViewBasketPage;
import ktctc.ecommerce.utility.Log;

/**
 * @author LENOVO
 *
 */
public class AddToCartPageTest extends BaseClass {

	LoginPage loginpage;
	IndexPage indexpage;
	SerchPage searchpage;
	AddToCartPage addpage;
	ViewBasketPage viewbasket;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.get().quit();
	}
	
	@Test
	public void validateProductAddedInBaskettest() {
		Log.startTestCase("validateProductAddedInBaskettest");
		loginpage = new LoginPage();
		Log.info("User is Trying to enter username and password");
		indexpage  = loginpage.loginToIndexPage(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("User Enetered username and password Successfully");
		searchpage = indexpage.searchForProduct("palak");
		Log.info("User Entered productname Succeffuly");
		addpage = searchpage.clickOnAddToBasketBtn();
		Log.info("User Is On Add To Cart Page");
		viewbasket = addpage.clickOnAddToCartBtn();
		Log.info("User Is On View Basket Page");
		String actext = viewbasket.verifyProductAddedInBasket();
		String extext = "Palak";
		Log.info("User Is Verifying for Product Added In Basket Or Not");
		Assert.assertEquals(actext, extext);
		Log.info("Product Added In Bassket Validation Successfull");
		Log.endTestCase("validateProductAddedInBaskettest");
		
	}
	
}
