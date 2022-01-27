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
public class SerchPage extends BaseClass {
	 Action action = new Action();
	 
	 @FindBy(xpath="/html/body/section/div[1]/div/div/h4")
	 WebElement searchresult;
	 
	 @FindBy(xpath="/html/body/section/div[2]/div/div/div/div[2]/a")
	 WebElement addToBaskrtBtn;
	 
	 
	 public SerchPage() {
		 PageFactory.initElements(driver.get(), this);
	 }
	 
	 public boolean verifySearchResult() {
		 action.implicitWait(driver.get(), 10);
		return action.isDisplayed(driver.get(), searchresult);
	 }
	 
	 public AddToCartPage clickOnAddToBasketBtn() {
		 action.implicitWait(driver.get(), 10);
		 action.JSClick(driver.get(), addToBaskrtBtn);
		 return new AddToCartPage();
	 }

}
