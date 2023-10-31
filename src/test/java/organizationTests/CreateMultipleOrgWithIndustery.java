package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganization;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.Organizations;

public class CreateMultipleOrgWithIndustery  {
	
	// Step 1: Create all the required Objects
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		WebDriver driver = null;
	
		@Test(dataProvider = "getData")
		
		
		public void createMultipleOrg(String ORG, String INDUSTRYNAME ) throws Exception {
			
			WebDriver driver = null;
			
			JavaUtility jUtil = new JavaUtility();
			ExcelFileUtility eUtil = new ExcelFileUtility();
			PropertyFileUtility pUtil = new PropertyFileUtility();
			WebDriverUtility wUtil = new WebDriverUtility();
			

			// Step 2: Read The Required Data
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String URL = pUtil.readDataFromPropertyFile("url");
			String USERNAME = pUtil.readDataFromPropertyFile("username");
			String PASSWORD = pUtil.readDataFromPropertyFile("password");
			
		String ORGNAME = ORG+jUtil.getRandomNumber();
		System.out.println(ORGNAME);

			// Step 3: Launch the browser
			if (BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println(BROWSER + " launched");
			} else if (BROWSER.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println(BROWSER + " launched");
			} else if (BROWSER.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println(BROWSER + " launched");
			} else {
				System.out.println("Invalid Browser Name");
			}

			wUtil.maximizeWindow(driver);
			wUtil.waitForpageLoad(driver);

			// Step 4: Load the URL
			driver.get(URL);

			
			
			
		}
		@DataProvider
		public Object[][] getData() throws EncryptedDocumentException, IOException{
			return eUtil.readMultipleData("MultipleOrganizations");
			
			
		}

		

}