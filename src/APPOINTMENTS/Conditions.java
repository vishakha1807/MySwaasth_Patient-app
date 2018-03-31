package APPOINTMENTS;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Conditions {
	static By conditions_option= By.id("com.myswaasth:id/myConditionsText");
	static By condition=By.xpath("//android.widget.LinearLayout[@index='1']");
	static By getHelp=By.xpath("//*[@text='Get Help']");
	static By bookmark=By.id("com.myswaasth:id/bookmark");
	AppiumDriver driver;
	public void scroll(String str) {
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+str.toString() +"\").instance(0))"));
	}
	@BeforeMethod
	public void Launchapp() throws InterruptedException, MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "ZY223HXGCD"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		//caps.setCapability("app", AppPath);
		caps.setCapability("appPackage", "com.myswaasth");
		caps.setCapability("appActivity", "com.myswaasthv1.MainActivity");
		caps.setCapability("noReset", "true");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.id("com.myswaasth:id/selfHelpButton")).click();
		
	}
	@AfterMethod
	public void quitDriver()
	{
		driver.closeApp();
        driver.quit();
        driver = null;
	}
	@Test(priority=1)
	public void condition_details() throws InterruptedException, IOException
	{
		driver.findElement(conditions_option).click();
		driver.findElement(condition).click();
		Thread.sleep(3000);
		driver.findElement(bookmark).click();
		Thread.sleep(6000);
		File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File("/home/aj/Desktop/MySwaasth/conditions/description.png"));
		Thread.sleep(3000);
		scroll("Symptoms");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='1']")).click();
		Thread.sleep(3000);
		File file2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file2, new File("/home/aj/Desktop/MySwaasth/conditions/Symptoms.png"));
		Thread.sleep(3000);
		scroll("Test");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='2']")).click();
		Thread.sleep(3000);
		File file3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file3, new File("/home/aj/Desktop/MySwaasth/conditions/Test_description.png"));
		Thread.sleep(3000);
		scroll("Treatment");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='3']")).click();
		Thread.sleep(3000);
		File file4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file4, new File("/home/aj/Desktop/MySwaasth/conditions/Treatment.png"));
		Thread.sleep(3000);
		driver.findElement(getHelp).click();
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='2']")).click();
		Thread.sleep(6000);
		
	}
}
