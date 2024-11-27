package com.myTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import io.appium.java_client.windows.WindowsDriver;


public class MaheshCode {

public static WindowsDriver driver;
	
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deciceName", "WindowsPc");
		
		try {
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void ckeckHelpAboutNowTest() {
		driver.findElementByName("View").click();
		driver.findElementByName("Word wrap").click();
	}
}
