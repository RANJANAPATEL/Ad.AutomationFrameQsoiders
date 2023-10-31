package contactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactsInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(genericUtility.ListenersImplementation.class)
public class CreateContact extends BaseClass{
	@Test(groups = "SmokeSuite")
	public void contactCreate() throws Exception {


		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);

	HomePage hp =new HomePage(driver);
	hp.clickOnContactsLink();
	Reporter.log("Clicked on contact Link");;
	
	ContactsPage cp = new ContactsPage(driver);
	cp.clickOnCreateContactLookUpImg();
	Reporter.log("Clicked creat contact look up image");
	
	CreateNewContactPage cpcn = new CreateNewContactPage(driver);
	cpcn.createNewContact(LASTNAME);
	Reporter.log("contact created successfully");
	
	ContactsInformationPage cip = new ContactsInformationPage(driver);
	  String contactHeader = cip.getHeaderText();
	  Reporter.log("Header Captured");
	  
	Assert.assertTrue(contactHeader.contains(LASTNAME));
	Reporter.log("Header Validated");
	  
		System.out.println(contactHeader);
		
	}
	@Test
	public void demo() {
		System.out.println("demo");
	}
	

}
