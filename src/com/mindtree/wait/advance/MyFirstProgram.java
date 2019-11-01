package com.mindtree.wait.advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstProgram {

	WebDriver driver;

	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void loginToFacebook() {
		driver.get("http://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys("raghavdce@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("password");
		driver.findElement(By.id("u_0_0")).click();

	}

	public static void main(String[] args) {
		
		MyFirstProgram obj = new MyFirstProgram();
		obj.OpenBrowser();
		obj.loginToFacebook();
		
		
	}
}
