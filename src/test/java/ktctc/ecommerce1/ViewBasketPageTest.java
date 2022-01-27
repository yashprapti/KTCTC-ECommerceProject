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
		driver.quit();
	}
	
	@Test
	public void validatePlaceOrderTest() {
		loginpage = new LoginPage();
		indexpage  = loginpage.loginToIndexPage(prop.getProperty("username"), prop.getProperty("password"));
		searchpage = indexpage.searchForProduct("palak");
		addpage = searchpage.clickOnAddToBasketBtn();
		viewbasket = addpage.clickOnAddToCartBtn();
		profilepage = viewbasket.verifyplaceOrder("Shivaji Road,Gandhi colony,Nagpur,Maharashtra");
		String actext=profilepage.verifyPlacedOrder();
		String extext = "Krantidhembre@gmail.com";
		Assert.assertEquals(actext, extext);
	}

}
