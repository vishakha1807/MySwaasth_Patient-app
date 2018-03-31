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

public class Medication {
	static By medication_option= By.id("com.myswaasth:id/myMedicationsText");
	static By medication=By.xpath("//android.widget.LinearLayout[@index='1']");
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
		driver.findElement(medication_option).click();
		driver.findElement(medication).click();
		Thread.sleep(3000);
		driver.findElement(bookmark).click();
		Thread.sleep(6000);
		File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File("/home/aj/Desktop/MySwaasth/medications/about.png"));
		Thread.sleep(3000);
		scroll("Before to use");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='1']")).click();
		Thread.sleep(3000);
		File file2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file2, new File("/home/aj/Desktop/MySwaasth/medications/beforetouse.png"));
		Thread.sleep(3000);
		scroll("How to use");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='2']")).click();
		Thread.sleep(3000);
		File file3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file3, new File("/home/aj/Desktop/MySwaasth/medications/How_to_use.png"));
		Thread.sleep(3000);
		scroll("Getting the most");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='3']")).click();
		Thread.sleep(3000);
		File file4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file4, new File("/home/aj/Desktop/MySwaasth/medications/Getting_the_most.png"));
		Thread.sleep(3000);
		scroll("Can cause problem");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='4']")).click();
		Thread.sleep(3000);
		File file5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file5, new File("/home/aj/Desktop/MySwaasth/medications/Can_cause_problem.png"));
		Thread.sleep(3000);
		scroll("Medicine Type");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='5']")).click();
		Thread.sleep(3000);
		File file6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file6, new File("/home/aj/Desktop/MySwaasth/medications/Medicine_Type.png"));
		Thread.sleep(3000);
		scroll("Used for");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='6']")).click();
		Thread.sleep(3000);
		File file7 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file7, new File("/home/aj/Desktop/MySwaasth/medications/Used_for.png"));
		Thread.sleep(3000);
		scroll("How to store");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='7']")).click();
		Thread.sleep(3000);
		File file8 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file8, new File("/home/aj/Desktop/MySwaasth/medications/How_to_store.png"));
		Thread.sleep(3000);
		scroll("Medicine availed as");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='8']")).click();
		Thread.sleep(3000);
		File file9 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file9, new File("/home/aj/Desktop/MySwaasth/medications/Medicine_availed.png"));
		Thread.sleep(3000);
		scroll("Brands");
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='9']")).click();
		Thread.sleep(3000);
		File file10 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file10, new File("/home/aj/Desktop/MySwaasth/medications/Brands.png"));
		Thread.sleep(3000);
	}
}
