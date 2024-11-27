package com.myTest;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class NotepadTest {

	public static WindowsDriver driver=null;


	@BeforeClass
	public void setup()  {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("app","C:\\Windows\\System32\\notepad.exe");


		try {
			driver=new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void cleanup() throws MalformedURLException {
		driver.quit();
		
	}
	
	@Test
	public void checkHelpAboutTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("File")).click();
		driver.findElement(By.name("New tab")).click();
		driver.findElement(By.name("Text editor")).sendKeys("Hello i am started to learn desktop automation");
		driver.findElement(By.name("Text editor")).sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.BACK_SPACE);
		driver.findElement(By.name("Edit")).click();
		driver.findElement(By.name("Time/Date")).click();
		driver.findElement(By.name("File")).click();
		driver.findElement(By.name("Save")).click();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@AutomationId='FileNameControlHost']/Edit[@ClassName='Edit'][@Name='File name:']").sendKeys(Keys.chord(Keys.CONTROL,"a"),"hello");
		driver.findElement(By.name("Save")).click();

		
	}
	
   





}


