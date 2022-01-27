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
import ktctc.ecommerce.utility.Log;

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
		driver.get().quit();
	}
	
	@Test
	public void validateLogoTest() {
		Log.startTestCase("validateLogoTest");
		loginpage = new LoginPage();
		boolean result = loginpage.verifyLogo();
		Assert.assertTrue(result);
		Log.info("Logo Validation Successful");
		Log.endTestCase("validateLogoTest");
	}
	
	@Test
	public void loginToIndexPageTest() {
		Log.startTestCase("loginToIndexPageTest");
		loginpage = new LoginPage();
		Log.info("User is Trying to enter username and password");
		indexpage = loginpage.loginToIndexPage(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("User Enetered username and password Successfully");
		boolean result = indexpage.verifyIndexPage();
		Assert.assertTrue(result);
		Log.info("User Logged In Successfully");
		Log.endTestCase("loginToIndexPageTest");
	}
}
