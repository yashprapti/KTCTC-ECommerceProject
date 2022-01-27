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
public class AddToCartPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath = "//*[text()='Fresh vegetable direct from Farmer']")
	WebElement valtext;
	
	@FindBy(xpath="//*[@id=\"productForm\"]/div[2]/input")
	WebElement AddToCartBtn;
	
	@FindBy(xpath="/html/body/nav[2]/a[2]/span")
	WebElement ViewBasketBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateProductSearch() {
		action.implicitWait(driver, 10);
		String acproduct = valtext.getText();
		return acproduct;
	}
	
	public ViewBasketPage clickOnAddToCartBtn() {
		action.implicitWait(driver, 10);
		action.click(driver, AddToCartBtn);
		action.click(driver, ViewBasketBtn);
		return new ViewBasketPage();
	}

}
