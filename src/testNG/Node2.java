package testNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Node2 {
	
	WebDriver driver;
  @Test
  public void f() {
	  try {
			DesiredCapabilities capabilites = DesiredCapabilities.firefox();
			  capabilites.setBrowserName("firefox");
			  capabilites.setPlatform(Platform.WIN8_1);
			  driver = new RemoteWebDriver(new URL("http://192.168.0.106:5555/wd/hub"), capabilites);
			  driver.manage().deleteAllCookies();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			  driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			  driver.get("http://www.snapdeal.com");
			  try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
  }
}
