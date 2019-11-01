package com.mindtree.autoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Youtube {
	
	//.//*[@id='myElement']/div[2]/div[1]
	
	WebDriver driver;

	public void downloadFileUsingAutoIT() {
			
			
				System.setProperty("webdriver.chrome.driver",
						"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get("http://cinema.dinamalar.com/tamil_cinema_video.php?id=119198&ta=T");
				driver.findElement(By.xpath(".//*[@id='myElement']/div[2]/div[1]")).click();
			

	}

	public static void main(String[] args) {
		Youtube obj = new Youtube();
		obj.downloadFileUsingAutoIT();

	}

}
