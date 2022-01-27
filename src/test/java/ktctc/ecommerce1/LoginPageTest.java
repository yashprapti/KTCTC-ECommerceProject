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

/**
 * @author LENOVO
 *
 */
public class LoginPageTest extends BaseClass {

	LoginPage loginpage;
	IndexPage indexpage;
	
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void validateLogoTest() {
		loginpage = new LoginPage();
		boolean result = loginpage.verifyLogo();
		Assert.assertTrue(result);
	}
	
	@Test
	public void loginToIndexPageTest() {
		loginpage = new LoginPage();
		indexpage = loginpage.loginToIndexPage(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = indexpage.verifyIndexPage();
		Assert.assertTrue(result);
	}
}
