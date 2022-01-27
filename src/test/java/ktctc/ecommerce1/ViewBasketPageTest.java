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
import ktctc.ecommerce.pageobject.ProfilePage;
import ktctc.ecommerce.pageobject.SerchPage;
import ktctc.ecommerce.pageobject.ViewBasketPage;
import ktctc.ecommerce.utility.Log;

/**
 * @author LENOVO
 *
 */
public class ViewBasketPageTest extends BaseClass {
	
	LoginPage loginpage;
	IndexPage indexpage;
	SerchPage searchpage;
	AddToCartPage addpage;
	ViewBasketPage viewbasket;
	ProfilePage profilepage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.get().quit();
	}
	
	@Test
	public void validatePlaceOrderTest() {
		Log.startTestCase("validatePlaceOrderTest");
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
		profilepage = viewbasket.verifyplaceOrder("Shivaji Road,Gandhi colony,Nagpur,Maharashtra");
		String actext=profilepage.verifyPlacedOrder();
		String extext = "Krantidhembre@gmail.com";
		Log.info("User Verifying Placed Order");
		Assert.assertEquals(actext, extext);
		Log.info("Place Order Validation Successfull");
		Log.endTestCase("validatePlaceOrderTest");
	}

}
