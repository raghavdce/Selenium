package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCrossBrowser {

	WebDriver driver;

	@Test
	@Parameters("browser")
	public void runCrossBrowserTesting(String browser) {
		if (browser.equals("CRM")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("raghavdce@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("password");
		driver.findElement(By.id("loginbutton")).submit();
		driver.quit();

	}
}
