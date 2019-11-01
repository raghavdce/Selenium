package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class PageTitlePrint {
	WebDriver driver;

	@Test
	public void printPage() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\\\MediaFiles\\\\Training\\\\201-Selenium\\\\Drivers\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
		for (int i = 0; i < 5; i++) {
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.dropbox.com/");
			String Title = driver.getTitle();
			System.out.println(Title);
			driver.quit();
		}
	}

}
