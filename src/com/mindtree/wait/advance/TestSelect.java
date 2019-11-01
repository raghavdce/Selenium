package com.mindtree.wait.advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSelect {

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
		driver.get("http://www.amazon.in");
		testDropDown();
	}

	public void testDropDown() {
		WebElement dropDownSelect = driver.findElement(By.id("searchDropdownBox"));
		dropDown = new Select(dropDownSelect);
		dropDown.selectByVisibleText("Books");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Agni Sirugugal");
		driver.findElement(By.className("nav-input")).click();
	}

	public static void main(String[] args) {
		TestSelect obj = new TestSelect();
		obj.invokeBrowser();

	}

}
