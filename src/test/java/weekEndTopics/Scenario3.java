package weekEndTopics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3 {
/*
 * Scenario 3:
Navigate to VTiger App
Navigate to Oranizations page
capture all the organization names and prnt in console. 
 * 
 * 
 * 
 */
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		List<WebElement> ogrs = driver.findElements(By.xpath("//a[@title='Organizations']"));
		int count=0;
		for(WebElement allOrg: ogrs) {
			
		System.out.println(allOrg.getText());
		count++;
		}
		
		System.out.println(count);

	}

}
