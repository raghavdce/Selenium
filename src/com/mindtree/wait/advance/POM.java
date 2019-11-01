package com.mindtree.wait.advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM {

	WebDriver driver;
	WebDriverWait expWait;

	public void signIn() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.get("https://www.barnesandnoble.com/");
		driver.findElement(By.id("userNameInput")).sendKeys("Mindtree\\M1030042");
		driver.findElement(By.id("passwordInput")).sendKeys("Rumble@37");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.className("icon-close-modal")).click();
		driver.findElement(By.id("signInLink")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Sign in or Create an Account']")));
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		userName.sendKeys("raghavdce@gmail.com");
		password.sendKeys("Welcome@123");
		String email = userName.getAttribute("value");
		System.out.println(email);
		String password1 = password.getAttribute("value");
		System.out.println(password1);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div[4]/div/div/button")).submit();
		driver.findElement(By.linkText("Books")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(365,1225)", "");
		driver.findElement(By.linkText("Biography")).click();
		WebElement s1 = driver.findElement(By.xpath("//*[@id=\"main-content\"]/header/h1/span[2]/span[2]"));
		WebElement s2 = driver.findElement(By.xpath("//*[@id=\"hotBooksWithDesc_Bestsellers\"]/header/h2"));
		if (s1.isDisplayed()) {
			if (s2.isDisplayed()) {
				String a = s1.getText();
				String b = s2.getText();
				System.out.println(a);
				System.out.println(b);
			}

		} else {
			System.out.println("No Such Text is Available");
		}
		driver.close();

	}
	

	public static void main(String[] args) {

		POM signInObj = new POM();
		signInObj.signIn();

	}

}
