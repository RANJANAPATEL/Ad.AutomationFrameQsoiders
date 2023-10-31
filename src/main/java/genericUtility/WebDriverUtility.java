package genericUtility;	
	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.google.common.io.Files;

	public class WebDriverUtility {
		
		public void maximizeWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		public void minimizedWindow(WebDriver driver)
		{
			driver.manage().window().minimize();
		}
		
		public void waitForpageLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		public void waitForElementToBeVisible(WebDriver driver,WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			
					
		}
		public void waitForElementToBeClickable(WebDriver driver,WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
					
		}
		public void handleDropDown(WebElement element, int index)
		{
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		public void handleDropDown(WebElement element, String value)
		{
			Select sel = new Select(element);
			sel.selectByValue(value);
		}
		public void handleDropDown( String text,WebElement element)
		{
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		public void dropAndDrop(WebDriver driver,WebElement drag, WebElement drop)
		{
			Actions act = new Actions(driver);
			act.clickAndHold(drag).release(drop);
		}
		public void dropAndDrop(WebElement drag,WebDriver driver, WebElement drop)
		{
			Actions act = new Actions(driver);
			act.dragAndDrop(drag, drop);
		}
		
		
		/**
		 * This method will perform mouse hovering action
		 * 
		 * @param driver
		 * @param element
		 */
		public void mouseHoverAction(WebDriver driver,WebElement element)
		{
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		/**
		 * This method will move the cursor bases on offset and click on web page
		 * @param driver
		 */
		public void moveAndClick(WebDriver driver)
		{
			Actions act = new Actions(driver);
			act.moveByOffset(10,10).click().perform();
		}
		/**
		 * This method will perform rightclick
		 * @param driver
		 */
		public void rightClickAction(WebDriver driver)
		{
			Actions act = new Actions(driver);
			act.contextClick().perform();
		}
		/**
		 * This method will perform drag and drop operation
		 * @param driver
		 * @param scrEle
		 * @param dstEle
		 */
		public void dropAndDropAction(WebDriver driver, WebElement scrEle,WebElement dstEle )
		{
			Actions act = new Actions(driver);
			act.dragAndDrop(scrEle, dstEle);
		}
		/**
		 * This method will handle from by index
		 * @param driver
		 * @param scrEle
		 * @param dstEle
		 */
		public void switchToFrame(WebDriver driver,int index )
		{
			driver.switchTo().frame(index);
		}
		/**
		 * This method will handle frame by Name or Id
		 * @param driver
		 * @param NameOrID
		 */
		public void switchToFrame(WebDriver driver,String NameOrID )
		{
			driver.switchTo().frame(NameOrID);
		}
		/**
		 * This method will handle frame by Web Element
		 * @param driver
		 * @param element
		 */
		public void switchToFrame(WebDriver driver,WebElement element)
		{
			driver.switchTo().frame(element);
		}
		/**
		 * This method will scroll up by 500 units
		 * @param driver
		 */
		public void javaScriptUpScroll(WebDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)", "");
		}
		/**
		 * This method will scroll down by 500 units
		 * @param driver
		 */
		public void javaScriptDownScroll(WebDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,-500)", "");
		}
		/**
		 * This method will accept the alert popup
		 * @param driver
		 */
		
		public void alertAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		/**
		 * This method will cacel the alert popup
		 * @param driver
		 */
		public void alertCancel(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		/**
		 * This method will fetch the alert text and return it to caller 
		 * @param driver
		 * @return
		 */
		public String alerGetText(WebDriver driver)
		{
			return driver.switchTo().alert().getText();
		}
		
		public void getWindowHandle(WebDriver driver, WebElement element) {
			
		}
		
		
		public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
						File src = ts.getScreenshotAs(OutputType.FILE); //temporary location
						File dst = new File("./ScreenShot"+screenshotName+".png");
						Files.copy(src, dst);
						return dst.getAbsolutePath();
															
		}
		
		/**
		 * 
		 * @param driver
		 * @param parentWinTitle
		 */
		public void switchToWindow( WebDriver driver, String parentWinTitle)
		{
				// step 1: get all the windowIDs
						Set<String> allWinIDs = driver.getWindowHandles();
						
						for(String winID : allWinIDs)
						{
								String actTitle = driver.switchTo().window(winID).getTitle();
								
								if(actTitle.contains(parentWinTitle))
								{
									break;
								}
						}
		}
		
		

	}


