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
public class ViewBasketPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(xpath="//*[@id=\"tbody\"]/tr[1]/td[2]")
	WebElement productname;
	
	@FindBy(id="w3review")
	WebElement addressarea;
	
	@FindBy(xpath="//*[@value='COD']")
	WebElement codradioBtn;
	
	@FindBy(xpath="/html/body/section/div/div/section/div/div/div[2]/div/div[2]/div/div[2]/div/div/label/input")
	WebElement termscheckbox;
	
	@FindBy(xpath="//*[@value='Place an order']")
	WebElement placeOrderBtn;
	
	public ViewBasketPage(){
		PageFactory.initElements(driver.get(), this);
	}
	
	public String verifyProductAddedInBasket() {
		action.implicitWait(driver.get(), 10);
		String price = productname.getText();
		return price;
	}
	
	public ProfilePage verifyplaceOrder(String address) {
		action.implicitWait(driver.get(), 10);
		action.type(addressarea, address);
		action.click(driver.get(), codradioBtn);
		action.click(driver.get(), termscheckbox);
		action.click(driver.get(), placeOrderBtn);
		return new ProfilePage();
	}

}
