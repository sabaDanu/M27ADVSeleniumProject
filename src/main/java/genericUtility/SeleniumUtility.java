package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class consists of reusable methods related to
 *  selenium
 * tool
 */

public class SeleniumUtility {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimizedWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to addImplicit wait
	 * @param driver
	 */
	public void addImplicitltyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method is will wait for 10 seconds for particular element tobe visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is will wait for 10 seconds for particular element tobe clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handle drop-down by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method will handle drop down by visible text
	 * @param element
	 * @param text
	 */
	public void handleDropDown(WebElement element, String text)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * This method will handle drop down by value
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String value, WebElement element)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This method will perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform mouse ClickHold Action
	 * @param driver
	 * @param element
	 */
	public void ClickHold(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	}
	/**
	 * This method will perform mouse doubleClick action
	 * @param driver
	 * @param element
	 */
	public void DoubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will perform mouse RightClick action
	 * @param driver
	 * @param element
	 */

	public void RightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform mouse Drap and drop action
	 * @param driver
	 * @param element
	 */
	public void DragAndDrop(WebDriver driver,WebElement element1,WebElement element) {
		Actions act=new Actions(driver);
		act.dragAndDrop(element1, element).perform();
	}
	/**
	 * This method will perform mouse ScrolltoElement action
	 * @param driver
	 * @param element
	 */
	public void ScrolltoElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	}
	/**
	 * This method will handle frame by frameId
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver,int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * This method will handle frame by frameId
	 * @param driver
	 * @param frameNameorId
	 */
	public void handleFrame(WebDriver driver,String frameNameorId) {
		driver.switchTo().frame(frameNameorId);
	}
	/**
	 * This method will handle frame by frameId
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method will accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will dismiss alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will sendkeysinAlert alert popup
	 * @param driver
	 * @param text
	 */
	public void sendkeysInAlert(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	/**
	 * This method will Return text of alert popup
	 * @param driver
	 */
	public String getTextOfAlert(WebDriver driver) {
		String text = (driver.switchTo().alert().getText());
		return text;
	}
	/**
	 * This method will close window
	 * @param driver
	 */
	public void closeWindow(WebDriver driver) {
		driver.close();
	}
	/**
	 * This method will quit window
	 * @param driver
	 */
	public void quitWindow(WebDriver driver) {
		driver.quit();
	}
	/**
	 * This method will switch window
	 * @param driver
	 * @param referenceId
	 */
	public void switchWindow(WebDriver driver,String referenceId) {
		driver.switchTo().window(referenceId);
	}
	/**
	 * This method will handle window
	 * @param driver
	 */
	public String handlingWindow(WebDriver driver) {
		return driver.getWindowHandle();
	}
	/**
	 * This method will handle windows
	 * @param driver
	 */
	public Set<String> handlingWindows(WebDriver driver) {
		Set<String> str = driver.getWindowHandles();
		return str;
	}
	/**
	 * This method will capture screenshot and return the pathh
	 * to caller
	 * @param driver
	 * @param ScreenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver,String screenShotName) throws IOException {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dst = new File("C:\\Users\\sabap\\eclipse-workspace\\SeleniumProject\\Screenshot\\"+screenShotName+".png");
			FileHandler.copy(src, dst);
			return dst.getAbsolutePath();//for extend reports
	}

}
