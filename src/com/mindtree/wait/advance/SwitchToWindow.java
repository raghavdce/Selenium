package com.mindtree.wait.advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchToWindow {

	WebDriver driver;
	String parentWindow, childWindow;
	WebElement myWindow;

	public void invokeBrowser(String url) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Raghav\\201-training\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);

	}

	public void switchToFrames() throws Exception {
		invokeBrowser("https://www.w3schools.com/js/tryit.asp?filename=tryjs_openwindow");
		driver.findElement(By.id("submitButton")).click();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//input[@value=\"Open Window\"]")).click();
		parentWindow = driver.getWindowHandle().toString();
		childWindow = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(childWindow);
		driver.findElement(By.partialLinkText("Try it Yourself")).click();
		driver.switchTo().window(parentWindow);
		Thread.sleep(3000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//input[@value=\"Open Window\"]")).click();
		//driver.close();
		
	}
	

}
