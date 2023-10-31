package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreateNewOrganization  extends WebDriverUtility {
	
	@FindBy(name ="accountname")
	private WebElement orgNameEdt;
	
	@FindBy (name ="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(name ="accounttype")
	private WebElement typeDropDown;
	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createNewOrganizatioWithIndustry(String ORGNAME, String INDUSTRY)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown, INDUSTRY);
		saveBtn.click();
	}
	public void createNewOrganization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
		
	}

}
