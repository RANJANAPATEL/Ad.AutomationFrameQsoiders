package weekEndTopics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * * Scenario 1:
Navigate to VTiger App
Navigate to Oranizations page
check on all the check boxes
 * 
 * 
 */
public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@name='selected_id']"));
		for(WebElement ch: checkbox) {
			
			ch.click();
		}

	}

}
