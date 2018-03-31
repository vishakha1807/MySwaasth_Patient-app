package Consult_Live;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Consultation {
	static By search= By.id("com.myswaasth:id/search_speciality_ET");
	static By speciality_options= By.xpath("//*[@text='Dentist (Teeth)']");
	static By select_consult= By.xpath("//*[@text='Consult']");
	static By doctor=By.id("com.myswaasth:id/docDegreeText");
	static By consult_btn= By.id("com.myswaasth:id/consultBtn");
	static By continue_btn1=By.id("com.myswaasth:id/continueBtn");
	static By continue_btn2=By.id("com.myswaasth:id/tv_continue");
	static By someoneElse=By.id("com.myswaasth:id/ll_someoneelse");
	static By family_member=By.id("com.myswaasth:id/iv_profile");
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
		driver.findElement(By.id("com.myswaasth:id/consultOnlineButton")).click();
		
	}
	@AfterMethod
	public void quitDriver()
	{
		driver.closeApp();
        driver.quit();
      //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      //email.get(0).clear();
        driver = null;
	}
	@Test(priority=1)
	public void Text_consult(AppiumDriver driver) throws InterruptedException
	{
		driver.findElement(search).sendKeys("Dentist");
		Thread.sleep(10000);
		try {
            driver.hideKeyboard();
            } catch (Exception e) {
            }
		Thread.sleep(10000);
		driver.findElement(speciality_options).click();
		driver.findElement(select_consult).click();
		driver.findElement(doctor).click();
		driver.findElement(consult_btn).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Text Consult']")).click();
		driver.findElement(continue_btn1).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn2).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn2).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn1).click();
	}
	@Test(priority=2)
	public void Phone_consult(AppiumDriver driver) throws InterruptedException
	{
		driver.findElement(search).sendKeys("Dentist");
		Thread.sleep(10000);
		try {
            driver.hideKeyboard();
            } catch (Exception e) {
            }
		Thread.sleep(10000);
		driver.findElement(speciality_options).click();
		driver.findElement(select_consult).click();
		driver.findElement(doctor).click();
		driver.findElement(consult_btn).click();
		Thread.sleep(3000);
		scroll("Phone Consult");
		driver.findElement(By.xpath("//*[@text='Phone Consult']")).click();
		driver.findElement(continue_btn1).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn2).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn2).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn1).click();
		
	}
	@Test(priority=3)
	public void video_consult(AppiumDriver driver) throws InterruptedException
	{
		driver.findElement(search).sendKeys("Dentist");
		Thread.sleep(10000);
		try {
            driver.hideKeyboard();
            } catch (Exception e) {
            }
		Thread.sleep(10000);
		driver.findElement(speciality_options).click();
		driver.findElement(select_consult).click();
		driver.findElement(doctor).click();
		driver.findElement(consult_btn).click();
		Thread.sleep(3000);
		scroll("Video Consult");
		driver.findElement(By.xpath("//*[@text='Video Consult']")).click();
		driver.findElement(continue_btn1).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn2).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn2).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn1).click();
		
	}
	@Test(priority=4)
	public void Text_consultforsomeone(AppiumDriver driver) throws InterruptedException
	{
		driver.findElement(search).sendKeys("Dentist");
		Thread.sleep(10000);
		try {
            driver.hideKeyboard();
            } catch (Exception e) {
            }
		Thread.sleep(10000);
		driver.findElement(speciality_options).click();
		driver.findElement(select_consult).click();
		driver.findElement(doctor).click();
		driver.findElement(consult_btn).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Text Consult']")).click();
		driver.findElement(someoneElse).click();
		driver.findElement(family_member).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn2).click();
		driver.findElement(continue_btn2).click();
		driver.findElement(continue_btn1).click();
	}
	@Test(priority=5)
	public void Phone_consultforsomeone(AppiumDriver driver) throws InterruptedException
	{
		driver.findElement(search).sendKeys("Dentist");
		Thread.sleep(10000);
		try {
            driver.hideKeyboard();
            } catch (Exception e) {
            }
		Thread.sleep(10000);
		driver.findElement(speciality_options).click();
		driver.findElement(select_consult).click();
		driver.findElement(doctor).click();
		driver.findElement(consult_btn).click();
		Thread.sleep(3000);
		scroll("Phone Consult");
		driver.findElement(By.xpath("//*[@text='Phone Consult']")).click();
		driver.findElement(someoneElse).click();
		driver.findElement(family_member).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn2).click();
		driver.findElement(continue_btn2).click();
		driver.findElement(continue_btn1).click();
		
	}
	@Test(priority=6)
	public void video_consultforsomeone(AppiumDriver driver) throws InterruptedException
	{
		driver.findElement(search).sendKeys("Dentist");
		Thread.sleep(10000);
		try {
            driver.hideKeyboard();
            } catch (Exception e) {
            }
		Thread.sleep(10000);
		driver.findElement(speciality_options).click();
		driver.findElement(select_consult).click();
		driver.findElement(doctor).click();
		driver.findElement(consult_btn).click();
		Thread.sleep(3000);
		scroll("Video Consult");
		driver.findElement(By.xpath("//*[@text='Video Consult']")).click();
		driver.findElement(someoneElse).click();
		driver.findElement(family_member).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn2).click();
		driver.findElement(continue_btn2).click();
		driver.findElement(continue_btn1).click();
		
	}
	
}
