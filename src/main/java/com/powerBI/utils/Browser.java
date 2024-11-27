package com.powerBI.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

public class Browser {
	public static WindowsDriver driver;

	public static WindowsDriver lanchBrowser() throws Exception {

		Desktop desktop=Desktop.getDesktop();
		desktop.open(new File("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"));
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("app", "C:\\Program Files\\Microsoft Power BI Desktop\\bin\\PBIDesktop.exe");
		
		try {
			driver=new WindowsDriver(new URL("http://127.0.0.1:4723"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void tackScreenShot(String imegename) throws Exception, Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(".//screnshot//" + imegename + "ExtentReportManager.png"));
	}
	
	 public static  void selectVisiblitiOfText(WebElement ele , String visibilitySelect) {
		 
		 Select select = new Select(ele);
		 List<WebElement> alloptions = select.getOptions();
		 for (WebElement eleopt : alloptions) {
			String Data = eleopt.getText();
			System.out.println(Data);
		}
		 select.selectByVisibleText(visibilitySelect);
	 }
	 
	 
	 public static String takeScreenShot() 
		{
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			String SrcFile=scrShot.getScreenshotAs(OutputType.BASE64);
			return SrcFile;
		}
	 
	 public static String capcturingPicture(String filename) throws IOException {
		File sourcefile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) ;
		File destinationFile = new File(System.getProperty("user.dir")+"//.ss//"+filename+".png");
		FileUtils.copyFile(sourcefile, destinationFile);
		return destinationFile.getAbsolutePath();
		 
	 }

	
}
