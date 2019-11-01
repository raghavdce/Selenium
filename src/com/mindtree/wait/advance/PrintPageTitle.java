package com.mindtree.wait.advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintPageTitle {
	
	WebDriver driver;
	
	public void printpage() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\\\MediaFiles\\\\Training\\\\201-Selenium\\\\Drivers\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
		for (int i = 0; i<5; i++) {
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.dropbox.com/");
			String Title = driver.getTitle();
			System.out.println(Title);
			driver.quit();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintPageTitle obj = new PrintPageTitle();
		obj.printpage();

	}

}
