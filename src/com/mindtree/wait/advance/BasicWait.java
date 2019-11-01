package com.mindtree.wait.advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicWait {

	WebDriver driver;

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.amazon.in");
		navigatePages();
	}

	public void navigatePages() {
		driver.navigate().to("http://www.amazon.in");
		driver.findElement(By.id("nav-your-amazon")).click();
		driver.navigate().back();
		driver.navigate().forward();
	}

	public static void main(String[] args) {

		BasicWait obj = new BasicWait();
		obj.invokeBrowser();

	}

}
