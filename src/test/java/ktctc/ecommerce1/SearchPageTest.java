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
		driver.quit();
	}
	
	@Test
	public void validateProductSearchTest() {
		loginpage = new LoginPage();
		indexpage = loginpage.loginToIndexPage(prop.getProperty("username"), prop.getProperty("password"));
		searchpage = indexpage.searchForProduct("palak");
		addpage = searchpage.clickOnAddToBasketBtn();
		String acproduct = addpage.validateProductSearch();
		String exproduct = "Fresh vegetable direct from Farmer";
		Assert.assertEquals(acproduct, exproduct);
	}

}
