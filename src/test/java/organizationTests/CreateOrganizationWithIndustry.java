package organizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class CreateOrganizationWithIndustry {
	@Test
	public void organizationCreateWithIndustry() throws Exception {
		
	// Step 1: Create all the required Objects
	JavaUtility jUtil = new JavaUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	WebDriver driver = null;

	// Step 2: Read The Required Data
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3) + jUtil.getRandomNumber();
	String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
	String INDUSTRY = eUtil.readDataFromExcel("Organization", 7, 3);
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
	
	//Step 5: Login To Application
	LoginPage lp = new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);

	//Step 6: click on Organization
	HomePage hp = new HomePage(driver);
	hp.clickOnOrganizationLink();
	
	Organizations  op = new Organizations(driver);
	op.clickonOrganizationLookUpImg();
	
CreateNewOrganization  cnop = new CreateNewOrganization (driver);
cnop.createNewOrganizatioWithIndustry(ORGNAME, INDUSTRY);
OrganizationInformationPage oip = new OrganizationInformationPage(driver);
String orgHeader = oip.getHeaderText();
if(orgHeader.contains(ORGNAME))
{
System.out.println(orgHeader);
System.out.println("Organization Created");
}
else
{
System.out.println("FAIL");
}

hp.logoutofApp(driver);

driver.quit();
}

}
