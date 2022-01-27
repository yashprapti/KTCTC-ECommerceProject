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
public class IndexPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath="/html/body/nav[2]/a[1]/span")
	WebElement Home;
	
	@FindBy(id="navbar-search-input")
	WebElement searchproductbox;
	
	@FindBy(xpath="//*[@id=\"ftco-navbar\"]/div/div[2]/form/div/span/button")
	WebElement searchBtn;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyIndexPage() {
		action.implicitWait(driver, 20);
		return action.isDisplayed(driver, Home);
	}
	
	public SerchPage searchForProduct(String productname) {
		action.implicitWait(driver, 10);
		action.type(searchproductbox, productname);
		action.click(driver, searchBtn);
		return new SerchPage();
	}

}
