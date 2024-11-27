package com.myTest;

import java.awt.Desktop;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.powerBI.utils.Browser;

import io.appium.java_client.windows.WindowsDriver;

public class PowerBITest {
	
	public static WindowsDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = Browser.lanchBrowser();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		 Browser.closeBrowser();
	}
	
	@Test
	public void powerBI() throws InterruptedException {
		Reporter.log("Start Reports");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElementByName("Blank report").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//Button[@ClassName='splitPrimaryButton root-269'][@Name='Get data']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//Button[@Name='Connect']//Text[@Name='Connect']").click();
		driver.findElementByXPath("//ListItem[@ClassName='UIItem'][@Name='dataDrivenExcel']").click();
		driver.findElementByXPath("//SplitButton[@ClassName='Button'][@Name='Open']").click();
		Thread.sleep(3000);
		WebElement ele=driver.findElementByName("Level 2, Sheet1");
		Actions action=new Actions(driver);
		action.doubleClick(ele).build().perform();
		driver.findElementByXPath("//Button[@Name='Load'][@AutomationId='idLoadButton']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//Group[@ClassName='container']").click();
		Thread.sleep(5000);
		WebElement element=driver.findElementByName("Sheet1");
		action.click(element).build().perform();
		//driver.findElementByXPath("//*[@Name='Numeric Field AGE']//Group[@ClassName='pbi-tree-node-checkbox ng-star-inserted']").click();
		driver.findElementByXPath("//Group[@ClassName='pbi-tree-node-checkbox ng-star-inserted']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//Group[@ClassName='pbi-tree-node-checkbox ng-star-inserted'])[2]").click();
		driver.findElementByXPath("//*[@Name='Clustered column chart']//Image").click();
		driver.findElementByXPath("//*[@ClassName='vcPopOutBtn'][@Name='Focus mode']").click();
		driver.findElementByXPath("//Button[@Name='Save'][@AutomationId='save']").click();
		driver.findElementByXPath("//Group[@ClassName='mat-form-field-flex ng-tns-c2794762957-0']").sendKeys("Haripriya1.powerBI");
		driver.findElementByXPath("//Button[@Name='Save'][@AutomationId='okButton']").click();
		Reporter.log("close reports");
		}
 
}
