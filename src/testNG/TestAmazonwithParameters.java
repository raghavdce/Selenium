package testNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAmazonwithParameters {
	
	WebDriver driver;
	Select dropDown;
	
  @Test
  @Parameters({"category","searchBox"})
  public void f(String category, String searchBox) {
	  driver.get("http://www.amazon.in");
	  WebElement element = driver.findElement(By.id("searchDropdownBox"));
		dropDown = new Select(element);
		driver.findElement(By.id("searchDropdownBox")).click();
		dropDown.selectByVisibleText(category);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchBox);
		driver.findElement(By.className("nav-input")).submit();
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
