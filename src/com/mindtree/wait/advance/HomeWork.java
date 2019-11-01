package com.mindtree.wait.advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWork {
	
	WebDriver driver;
	Select dropDown;

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.flipkart.com");
		homeWork();
			}
	
	public void homeWork() {
		driver.findElement(By.className("_1QZ6fC")).click();
		driver.findElement(By.className("_3ZgIXy")).click();
	}

	public static void main(String[] args) {
		HomeWork obj = new HomeWork();
		obj.invokeBrowser();

	}

}
