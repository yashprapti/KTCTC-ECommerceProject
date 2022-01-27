/**
 * 
 */
package ktctc.ecommerce.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ktctc.ecommerce.actiondriver.Action;
import ktctc.ecommerce.base.BaseClass;

/**
 * @author LENOVO
 *
 */
public class LoginPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath = "//*[@placeholder=\" Enter Mobile Number\"]")
	WebElement enterMobile;
	
	@FindBy(id="myInput")
	WebElement enterPwd;
	
	@FindBy(xpath="//*[@name=\"login\"]")
	WebElement loginBtn;
	
	@FindBy(xpath = "/html/body/div[1]/div/form/img")
	WebElement Logo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public IndexPage loginToIndexPage(String mobno,String pwd) {
		action.implicitWait(driver, 10);
		action.type(enterMobile, mobno);
		action.type(enterPwd, pwd);
		action.click(driver, loginBtn);
		return new IndexPage();
	}
	
	public boolean verifyLogo() {
		action.implicitWait(driver, 10);
		return action.isDisplayed(driver, Logo);
	}

}
