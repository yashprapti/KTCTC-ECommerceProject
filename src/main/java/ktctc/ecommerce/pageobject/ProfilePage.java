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
public class ProfilePage extends BaseClass {
	Action action = new Action(); 
	
	@FindBy(xpath="//*[text()='Krantidhembre@gmail.com']")
	WebElement successmsg;
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPlacedOrder() {
		action.fluentWait(driver, successmsg, 20);
		String acmsg = successmsg.getText();
		return acmsg;
	}

}
