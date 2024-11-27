package com.myTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class ChromeTest {
	public static WindowsDriver driver;
	
	@BeforeClass
	public void setup() {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("app", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		try {
			driver=new WindowsDriver(new URL("http://127.0.0.1:4723"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void chrome() {
		driver.findElement(By.name("Open Person 1 profile")).click();
		driver.switchTo().frame("backgroundImage");
		WebElement ele=driver.findElement(By.tagName("ntp-app"));
		WebElement shadowIframe=ele.findElement(By.cssSelector("ntp-iframe#oneGoogleBar"));
		driver.switchTo().frame(shadowIframe);
		WebElement ele1=driver.findElement(By.cssSelector("ntp-logo#logo"));
		boolean flag=ele1.isDisplayed();
		System.out.println(flag);
		driver.switchTo().defaultContent();
		
		

	}

}
