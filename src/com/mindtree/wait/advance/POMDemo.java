package com.mindtree.wait.advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class POMDemo {
	WebDriver mydriver;

	private WebElement signIn;
	private WebElement email;
	private WebElement password;
	private WebElement login;

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		mydriver = new ChromeDriver();
		mydriver.get("http://www.amazon.in");
		mydriver.manage().deleteAllCookies();
		mydriver.manage().window().maximize();
		mydriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mydriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public POMDemo(WebDriver driver) {
		mydriver = driver;
		signIn = driver.findElement(By.className("nav-line-2"));
		email = driver.findElement(By.id("ap_email"));
		password = driver.findElement(By.id("ap_password"));
		login = driver.findElement(By.id("signInSubmit"));

	}

	public void loginToAcc(String username, String password1) {
		signIn.click();
		email.clear();
		email.sendKeys(username);
		password.clear();
		password.sendKeys(password1);
		login.click();
	}

}
