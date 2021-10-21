package testNG;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAsserts {

	WebDriver driver;
	SoftAssert s_assert;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Raghav\\201-training\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	/*@AfterMethod
	public void closeBrowser() {
		try {
			Thread.sleep(3000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	@Test
	public void f() {
		driver.get("http://www.flipkart.com");
		driver.findElement(By.xpath("//button[contains(text(),'X')]")).click();
		String title = driver.getTitle();
		Assert.assertEquals("flipkart", title);
		driver.findElement(By.linkText("Trending Fashion")).click();
	}

	@Test
	public void g() {
		driver.get("http://www.flipkart.com");
		driver.findElement(By.name("UserName")).sendKeys("Username");
		driver.findElement(By.name("Password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		String title = driver.getTitle();
		s_assert = new SoftAssert();
		s_assert.assertEquals("flipkart", title);
		driver.findElement(By.linkText("Trending Fashion")).click();
		s_assert.assertAll();
	}
}
