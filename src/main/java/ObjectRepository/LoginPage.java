package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//rule1
	//rule2
		//identify single web-element through multiple locators -OR operators
		//autoHealing
		@FindAll({@FindBy(id="user-name"),@FindBy(xpath="//input[@name='user-name']" )})
		private WebElement usernameEdt1;

		//identify single web-element through multiple locators -AND operators
		@FindBys({@FindBy(id="user-name"),@FindBy(xpath="//input[@name='user-name']" )})
		private WebElement usernameEdt2;
		@FindBy(id="user-name")
		private WebElement usernameEdt;
		@FindBy(id="password")
		private WebElement passwordEdt;
		@FindBy(id="login-button")
		private WebElement loginBtn;
		//rule3 -Initialization

		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);

		}
		//rule4-Utilization
		public WebElement getUsernameEdt() {
			return usernameEdt;
		}
		public WebElement getPasswordEdt() {
			return passwordEdt;
		}
		public WebElement getLoginBtn() {
			return loginBtn;
		}
		//Business-optimization-generic method
		/**
		 * This method will perform login operation
		 * @param un
		 * @param pwd
		 */
		public void loginToApp(String un,String pwd) {
			usernameEdt.sendKeys(un);
			passwordEdt.sendKeys(pwd);
			loginBtn.click();
		}

}
