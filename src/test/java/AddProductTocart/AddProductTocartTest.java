package AddProductTocart;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository.CartPage;
import ObjectRepository.InventoryItemPage;
import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;
//import genericUtility.JavaUtility;
import genericUtility.SeleniumUtility;
import genericUtility.BaseClass;
import genericUtility.FileUtility;


public class AddProductTocartTest extends BaseClass {

	public static void main(String[] args) throws IOException {
		FileUtility fUtil=new FileUtility();
		//JavaUtility jUtil=new JavaUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		//read data from property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		//read data from excel file
		String PRODUCTNAME=fUtil.readDataFromExcel("Products", 1, 2);
		//Launch the browser
		WebDriver driver =new FirefoxDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitltyWait(driver);
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		InventoryPage ip=new InventoryPage(driver);
		ip.clickOnAProduct(driver, PRODUCTNAME);
		InventoryItemPage iip=new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();
		ip.clickOnCartContainer();
		CartPage cp=new CartPage(driver);
		String productInCart = cp.getItemName();
		if(productInCart.equals(PRODUCTNAME)) {
			System.out.println("pass");
			System.out.println(PRODUCTNAME);
		}
		else {
			System.out.println("fail");
		}
		ip.logoutofApp();
	}

	}


