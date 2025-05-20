package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.FileUtility;

public class AddTocart {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver =new FirefoxDriver();
		
		FileUtility A=new FileUtility();
		String URL = A.readDataFromPropertyFile("url");
		String USERNAME = A.readDataFromPropertyFile("username");
		String PASSWORD = A.readDataFromPropertyFile("password");
		String PRODUCT=A.readDataFromExcel("Products", 1, 2);

		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		WebElement ele1 = driver.findElement(By.xpath("//div[.='"+PRODUCT+"']"));
		String str1 = ele1.getText();
		ele1.click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.id("shopping_cart_container")).click();
		Thread.sleep(3000);
		WebElement ele2 = driver.findElement(By.xpath("//div[@class='cart_item_label']/a/div"));
		String str2 = ele2.getText();
		if(str1.equals(str2)) {
			System.out.println(str1+"  "+"Item added in cart correctly");
		}
		else {
			System.out.println("something wrong");
		}
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
	}

}
