package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import genericUtility.SeleniumUtility;
public class InventoryPage extends SeleniumUtility {//rule1
	@FindBy(className="product_sort_container")
	private WebElement sortDropDown;
	@FindBy(id="shopping_cart_container")
	private WebElement cartContainerBtn;
	@FindBy(id="react-burger-menu-btn")
	private WebElement menuBtn;
	@FindBy(linkText="Logout")
	private WebElement logoutLnk;
	//Initialization
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getSortDropDown() {
		return sortDropDown;
	}

	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getLogoutLnk() {
		return logoutLnk;
	}
	//Business library


	/**
	 * This method will click any product specified by caller
	 * @param driver
	 * @param productName
	 */
	public void clickOnAProduct(WebDriver driver,String productName) {

		driver.findElement(By.xpath("//div[.='"+productName+"']")).click();
	}

	/**
	 * This method will perform logout operation
	 */
	public void logoutofApp() {
		menuBtn.click();
		logoutLnk.click();
	}
	/**
	 * This method will sort for lowestprice producr and then click on it
	 * @param driver
	 * @param sortOption
	 * @param productname
	 */
	public void clickOnLowestPriceProduct(WebDriver driver,String sortOption,String productname) {
		handleDropDown(sortDropDown,sortOption);
		driver.findElement(By.xpath("//div[.='"+productname+"']")).click();
	}
	/**
	 * This method is used to click on cart
	 */
	public void clickOnCartContainer() {
		cartContainerBtn.click();
	}




}
