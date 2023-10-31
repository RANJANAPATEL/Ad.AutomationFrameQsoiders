package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchChrome {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8888");

	}

}
