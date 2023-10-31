package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class ClickLogin {
public static void main(String args[]) throws IOException
{
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	
	

	JavaUtility jUtil = new JavaUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	driver.get(URL);
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println(BROWSER+" launched");
	}
	else if(BROWSER.equalsIgnoreCase("Firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		System.out.println(BROWSER+" launched");
	}
	else if(BROWSER.equalsIgnoreCase("Edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		System.out.println(BROWSER+" launched");
	}
	else
	{
		System.out.println("Invalid Browser Name");
	}
	
	wUtil.maximizeWindow(driver);
	wUtil.waitForpageLoad(driver);
	
	//Step 4: Load the URL
	driver.get(URL);
	//Step 5 : login to application
	LoginPage lp = new LoginPage(driver);
	lp.getUserNameEdt().sendKeys(USERNAME);
	lp.getPasswordEdt().sendKeys(PASSWORD);
	lp.getLoginBtn().click();
}


}
