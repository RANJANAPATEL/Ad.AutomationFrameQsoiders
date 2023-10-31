package organizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
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

public class CreateOrganization extends BaseClass {
	@Test
	public void organizationCreate() throws Exception {
		
		
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3) + jUtil.getRandomNumber();		
		
				HomePage hp = new HomePage(driver);
				hp.clickOnOrganizationLink();
				
				Organizations  op = new Organizations(driver);
				op.clickonOrganizationLookUpImg();
				
	CreateNewOrganization  cnop = new CreateNewOrganization (driver);
	cnop.createNewOrganization(ORGNAME);
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
	
	
	
	}

}
