package APPOINTMENTS;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Consult_Live.Consultation;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class consult_online {
	static By consult_online=By.id("com.myswaasth:id/consultOnlineText");
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
	@Test
	public void textConsult() throws InterruptedException
	{
		scroll("Consult Online");
		driver.findElement(consult_online).click();
		Consultation consult = new Consultation();
		consult.Text_consult(driver);
	}
	@Test
	public void phoneConsult() throws InterruptedException
	{
		scroll("Consult Online");
		driver.findElement(consult_online).click();
		Consultation consult = new Consultation();
		consult.Phone_consult(driver);
	}
	@Test
	public void videoConsult() throws InterruptedException
	{
		scroll("Consult Online");
		driver.findElement(consult_online).click();
		Consultation consult = new Consultation();
		consult.video_consult(driver);
	}
}
