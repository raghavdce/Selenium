package testNG;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataproviders {

	WebDriver driver;

	@Test(dataProvider = "ABC")
	public void loginToFacebook(String email, String Password) {
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(Password);
		driver.findElement(By.id("loginbutton")).submit();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@DataProvider(name = "ABC")
	public Object[][] passValues(Method m) {
		Object[][] value = null;
		if (m.getName().equals("loginToFacebook")) {
			value = new Object[][] { { "raghavdce@gmail.com", "password@11" }, { "sharanya09@gmail.com", "password" } };
		}
		return value;
	}
}