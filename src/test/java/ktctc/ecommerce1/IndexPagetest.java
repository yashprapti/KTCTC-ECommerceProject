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
		driver.quit();
	}
	
	@Test
	public void validateSearchProduct() {
		loginpage = new LoginPage();
		indexpage = loginpage.loginToIndexPage(prop.getProperty("username"), prop.getProperty("password"));
		searchpage = indexpage.searchForProduct("palak");
		boolean result = searchpage.verifySearchResult();
		Assert.assertTrue(result);
	}

}
