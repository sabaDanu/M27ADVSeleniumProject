package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	@FindBy(id="add-to-cart")
	private WebElement addToCart;
	@FindBy(className="inventory_details_price")
	private WebElement price;
	public InventoryItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddToCart() {
		return addToCart;
	}
	public WebElement getPrice() {
		return price;
	}
	//Business Library
	public void clickOnAddToCartBtn() {
		addToCart.click();
	}
}
