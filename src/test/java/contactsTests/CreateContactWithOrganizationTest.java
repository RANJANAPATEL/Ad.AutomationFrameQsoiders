package contactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import objectRepository.CreateNewOrganization;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.Organizations;

public class CreateContactWithOrganizationTest extends BaseClass
{

	@Test(groups = "RegressionSuite")
	public void CreateContactWithOrgTest() throws Exception {


	
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
	
		//Step 6: click on Organization
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		Organizations  op = new Organizations(driver);
				op.clickonOrganizationLookUpImg();
				
	CreateNewOrganization  cnop = new CreateNewOrganization (driver);
	cnop.createNewOrganization(ORGNAME);
	
	OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	String orgHeader = oip.getHeaderText();
	Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
	
	hp.clickOnContactsLink();
	
	ContactsPage cp = new ContactsPage(driver);
	cp.clickOnCreateContactLookUpImg();
	
	CreateNewContactPage cncp = new CreateNewContactPage(driver);
	cncp.createNewContact(driver, LASTNAME, ORGNAME);
	
	ContactsInformationPage cip = new ContactsInformationPage(driver);
	String contactHeader = cip.getHeaderText();
	
	Assert.assertTrue(contactHeader.contains(LASTNAME));
	System.out.println(contactHeader);
	
	
}
}
