package com.mindtree.wait.advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestWait {

	WebDriver driver;
	WebDriverWait expWait;

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.amazon.in");
		testExpWait();

	}

	public void testExpWait() {
		expWait = new WebDriverWait(driver, 15);
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-carousel-goto-nextpage")));
		driver.findElement(By.className("a-carousel-goto-nextpage")).click();
		// driver.quit();

	}

	public static void main(String[] args) {

		TestWait obj = new TestWait();
		obj.invokeBrowser();

	}

}
