package com.mindtree.wait.advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestKeyboardMouseEvents {

	WebDriver driver;
	Actions myAction;
	Action seriesOfActions;

	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		keyboardAction();
	}

	public void keyboardAction() {
		myAction = new Actions(driver);
		seriesOfActions = myAction.moveToElement(driver.findElement(By.id("email"))).click()
				.sendKeys("raghavdce@gmail.com")
				.moveToElement(driver.findElement(By.id("pass"))).click()
				.sendKeys("Rumble@11").sendKeys(Keys.ENTER).build();
		seriesOfActions.perform();
	}

	public static void main(String[] args) {
		TestKeyboardMouseEvents obj = new TestKeyboardMouseEvents();
		obj.openBrowser();
	}

}
