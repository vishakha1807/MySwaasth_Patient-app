package Complete_Profile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Profile {
	static By profile_btn=By.id("com.myswaasth:id/iv_profile");
	static By complete_profile_btn=By.id("com.myswaasth:id/completeProfile");
	static By gender=By.xpath("//android.widget.RelativeLayout[@index='4']");
	static By DOB=By.xpath("//android.widget.RelativeLayout[@index='5']");
	static By blood_grp=By.xpath("//android.widget.RelativeLayout[@index='6']");
	static By height=By.xpath("//android.widget.RelativeLayout[@index='7']");
	static By weight=By.xpath("//android.widget.RelativeLayout[@index='8']");
	static By location=By.xpath("//android.widget.RelativeLayout[@index='9']");
	static By done_btn=By.id("com.myswaasth:id/rl_done");
	static By completeSave=By.id("com.myswaasth:id/ll_completeProfile");
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
		driver.findElement(profile_btn).click();
		driver.findElement(complete_profile_btn).click();
		Thread.sleep(5000);
	}
	@AfterMethod
	public void quitDriver()
	{
		driver.closeApp();
        driver.quit();
        driver = null;
	}
	
	@Test(priority=1)
	public void select_gender() throws InterruptedException
	{
		driver.findElement(gender).click();
		driver.findElement(By.id("com.myswaasth:id/tv_female")).click();
		String female=driver.findElement(By.id("com.myswaasth:id/tv_female")).getText();
		driver.findElement(done_btn).click();
		String verify=driver.findElement(By.id("com.myswaasth:id/tv_gender")).getText();
		Assert.assertTrue(female.equalsIgnoreCase(verify));
		driver.findElement(completeSave).click();
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void select_DOB() throws InterruptedException
	{
		scroll("Date of birth");
		driver.findElement(DOB).click();
		Thread.sleep(8000);
		List<MobileElement> edittext = driver.findElements(By.xpath("//android.widget.Button"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		edittext.get(0).click();
		Thread.sleep(8000);
	}
	@Test(priority=3)
	public void select_bloodGroup() throws InterruptedException
	{
		scroll("Blood group");
		driver.findElement(blood_grp).click();
		driver.findElement(By.id("com.myswaasth:id/tv_bp")).click();
		String Actualbloodgrp=driver.findElement(By.id("com.myswaasth:id/tv_bp")).getText();
		Thread.sleep(5000);
		driver.findElement(done_btn).click();
		Thread.sleep(5000);
		String verify=driver.findElement(By.id("com.myswaasth:id/tv_bloodgroup")).getText();
		Assert.assertTrue(Actualbloodgrp.equalsIgnoreCase(verify));
		Thread.sleep(5000);
		driver.findElement(completeSave).click();
		Thread.sleep(5000);
	}
	@Test(priority=4)
	public void select_height() throws InterruptedException
	{
		scroll("Height");
		driver.findElement(height).click();
		List<MobileElement> pick = driver.findElements(By.className("android.widget.EditText"));
		pick.get(0).click();
		pick.get(1).sendKeys("5");
		driver.findElement(done_btn).click();
	}
	@Test(priority=5)
	public void select_weight() throws InterruptedException
	{
		scroll("Weight");
		driver.findElement(weight).click();
		List<MobileElement> edittext = driver.findElements(By.xpath("//android.widget.Button"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		edittext.get(0).click();
		Thread.sleep(8000);
		driver.findElement(done_btn).click();
	}
	@Test(priority=6)
	public void select_location() throws InterruptedException
	{
		scroll("Location");
		driver.findElement(location).click();
		driver.findElement(By.id("com.myswaasth:id/tv_getCurrentLocation")).click();
		String getActualLocation=driver.findElement(By.id("com.myswaasth:id/tv_locationtext")).getText();
		Thread.sleep(4000);
		driver.findElement(done_btn).click();
		String expectedLocation=driver.findElement(By.id("com.myswaasth:id/tv_location")).getText();
		Assert.assertTrue(getActualLocation.equalsIgnoreCase(expectedLocation));
		driver.findElement(completeSave).click();
	Thread.sleep(5000);
	}
	
	
}
