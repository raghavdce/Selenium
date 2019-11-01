package com.mindtree.wait.advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlerts {
	WebDriver driver;

	public void invokeBrowser(String URL) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(-30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);

	}

	public void switchToAlerts() {
		invokeBrowser("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		//driver.
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.tagName("button")).click();
		Alert myAlert = driver.switchTo().alert();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myAlert.accept();

	}

}
