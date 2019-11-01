package testNG;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAnnotation {
	WebDriver driver;
	
	@BeforeClass
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");

	}

	@Test
	public void loginToFacebook() {
		driver.findElement(By.name("email")).sendKeys("raghavdce@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("password");
		driver.findElement(By.cssSelector("label#loginbutton")).click();
	}



	@AfterClass
	public void closeBrowser() {
		try {
			Thread.sleep(2000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
