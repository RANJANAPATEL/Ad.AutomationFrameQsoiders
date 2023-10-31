package weekEndTopics;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5 {
/*
 * Scenario 5:
Navigate to Organizations page
click on 8th check box and capture the Organization name and delete that organization
 */
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[last()]")).click();
		 String org = driver.findElement(By.xpath("(//a[@title='Organizations'])[last()]")).getText();
		 System.out.println(org);
		 driver.findElement(By.xpath("(//a[text()='del'])[last()]")).click();
		 driver.switchTo().alert().accept();


	}

}
