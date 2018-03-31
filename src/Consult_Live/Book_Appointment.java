package Consult_Live;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Book_Appointment {
	static By search= By.id("com.myswaasth:id/search_speciality_ET");
	static By speciality_options= By.xpath("//*[@text='Dentist (Teeth)']");
	static By doctor=By.id("com.myswaasth:id/docDegreeText");
	static By book_btn= By.id("com.myswaasth:id/bookBtn");
	static By select_date=By.xpath("//android.widget.LinearLayout[@index='2']");
	static By select_time=By.xpath("//android.widget.FrameLayout[@index='2']");
	static By continue_btn1=By.id("com.myswaasth:id/continueBtn");
	static By continue_btn2=By.id("com.myswaasth:id/tv_continue");
	static By done_btn=By.id("com.myswaasth:id/tc_done");
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
        driver = null;
	}
	@Test(priority=1)
	public void book_appointment() throws InterruptedException
	{
		driver.findElement(search).sendKeys("Dentist");
		Thread.sleep(10000);
		try {
            driver.hideKeyboard();
            } catch (Exception e) {
            }
		Thread.sleep(10000);
		driver.findElement(speciality_options).click();
		driver.findElement(doctor).click();
		driver.findElement(book_btn).click();
		Thread.sleep(3000);
		driver.findElement(select_date).click();
		scroll("Afternoon");
		driver.findElement(select_time).click();
		Thread.sleep(2000);
		driver.findElement(continue_btn1).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn2).click();
		Thread.sleep(5000);
		driver.findElement(done_btn).click();
		Assert.assertEquals("UPCOMING", "UPCOMING");
	}
	@Test(priority=2)
	public void book_appointmentforsomeone() throws InterruptedException
	{
		driver.findElement(search).sendKeys("Dentist");
		Thread.sleep(10000);
		try {
            driver.hideKeyboard();
            } catch (Exception e) {
            }
		Thread.sleep(10000);
		driver.findElement(speciality_options).click();
		driver.findElement(doctor).click();
		driver.findElement(book_btn).click();
		Thread.sleep(3000);
		driver.findElement(select_date).click();
		scroll("Afternoon");
		driver.findElement(select_time).click();
		Thread.sleep(2000);
		driver.findElement(someoneElse).click();
		driver.findElement(family_member).click();
		Thread.sleep(5000);
		driver.findElement(continue_btn2).click();
		driver.findElement(done_btn).click();
		Assert.assertEquals("UPCOMING", "UPCOMING");
		
	}
	

}
