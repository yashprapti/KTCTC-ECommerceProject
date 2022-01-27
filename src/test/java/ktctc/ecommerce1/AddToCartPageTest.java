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
		driver.quit();
	}
	
	@Test
	public void validateProductAddedInBaskettest() {
		loginpage = new LoginPage();
		indexpage  = loginpage.loginToIndexPage(prop.getProperty("username"), prop.getProperty("password"));
		searchpage = indexpage.searchForProduct("palak");
		addpage = searchpage.clickOnAddToBasketBtn();
		viewbasket = addpage.clickOnAddToCartBtn();
		String actext = viewbasket.verifyProductAddedInBasket();
		String extext = "Palak";
		Assert.assertEquals(actext, extext);
	}
	
}
