package practice;

		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.edge.EdgeDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

		public class CreateOrganization { 
			public static void main(String args[]) throws Exception
			{
				//Step 1: Create all the required Objects
						JavaUtility jUtil = new JavaUtility();
						ExcelFileUtility eUtil = new ExcelFileUtility();
						PropertyFileUtility pUtil = new PropertyFileUtility();
						WebDriverUtility wUtil = new WebDriverUtility();
						WebDriver driver = null;
						
						//Step 2: Read The Required Data
						String BROWSER = pUtil.readDataFromPropertyFile("browser");
						String URL = pUtil.readDataFromPropertyFile("url");
						String USERNAME = pUtil.readDataFromPropertyFile("username");
						String PASSWORD = pUtil.readDataFromPropertyFile("password");
						
						String ORGNAME = eUtil.readDataFromExcel("Orgnization", 1, 2)+jUtil.getRandomNumber();
						System.out.println(ORGNAME);
						//Step 3: Launch the browser
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
						
						
						Thread.sleep(2000);
					//Step 6: Navigate to Organizations link
						driver.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")).click();

						//Actions actions = new Actions(driver);
						WebElement ele = driver.findElement(By.xpath("//span[.=' MARKETING']"));
						//actions.moveToElement(ele).build().perform();
						wUtil.mouseHoverAction(driver, ele);
						
						//Step 7: Click on Create Organization 
						Thread.sleep(2000);
						driver.findElement(By.xpath("//span[.=' Organizations']")).click();
						//Step 7: Create Organization with mandatory information
						driver.findElement(By.xpath("//button[@id='Accounts_listView_basicAction_LBL_ADD_RECORD']")).click();
						driver.findElement(By.cssSelector("[name='accountname']")).sendKeys(ORGNAME);
						//Step 8: save
						driver.findElement(By.cssSelector("button[type='submit']")).click();
						//Step 9: Validate
					String orgHeader = driver.findElement(By.cssSelector("[class='accountname']")).getText();
					System.out.println(orgHeader);
					if(orgHeader.contains(ORGNAME))
					{
						System.out.println("pass");
					}
					else
					{
						System.out.println("fail");
					}
					driver.close();
			
					
					
					
					


	}

}
