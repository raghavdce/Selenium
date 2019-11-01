import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAlerts {

	WebDriver driver;

	public void invokeBrowser(String url) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().to(url);
		driver.findElement(By.id("userNameInput")).sendKeys("M1030042@mindtree.com");
		driver.findElement(By.id("passwordInput")).sendKeys("Rumble@44");
		driver.findElement(By.id("submitButton")).click();
	}
	
	public void switchAlerts() {
		invokeBrowser("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.switchTo().frame("iframeResult");
		WebDriverWait expWait = new WebDriverWait(driver, 20);
		//expWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-carousel-goto-nextpage")));
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));
		driver.findElement(By.tagName("button")).click();
		Alert myAlert = driver.switchTo().alert();
		myAlert.accept();
	}

}
