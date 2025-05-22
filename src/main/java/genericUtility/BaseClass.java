package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.InventoryPage;
import ObjectRepository.LoginPage;

public class BaseClass {
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public FileUtility fUtil = new FileUtility();
	
	public WebDriver driver;
	public static WebDriver sdriver;

	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("======= Database Connection succesful =======");
	}
	//BeforeTest is added when we using Distributed parallel execution
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String pValue*/) throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		driver =new EdgeDriver();
		//driver = new ChromeDriver();

		/*if(pValue.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(pValue.equals("Firefox")){
		driver = new FirefoxDriver();
		}
		else {
			driver = new FirefoxDriver();
	
		}*/
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitltyWait(driver);
		driver.get(URL);
		sdriver=driver;
		System.out.println("======= Browser launch succesful =======");
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("======= Login To App succesful =======");
	}

	@AfterMethod(alwaysRun=true)
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutofApp();
		
		System.out.println("======= Logout of App succesful =======");
	}
	//AfterTest is added when we using Distributed parallel execution
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("======= Browser closure succesful =======");
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("======= Database Closure succesful =======");
	}
}
