package Complete_Profile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
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
	static By smoking=By.xpath("//android.widget.RelativeLayout[@index='0']");
	static By food=By.xpath("//android.widget.RelativeLayout[@index='1']");
	static By activity_level=By.xpath("//android.widget.RelativeLayout[@index='2']");
	static By alcohol_consumption=By.xpath("//android.widget.RelativeLayout[@index='3']");
	static By allergies=By.xpath("//android.widget.RelativeLayout[@index='4']");
	static By surgeries=By.xpath("//android.widget.RelativeLayout[@index='5']");
	static By chronic_disesaes=By.xpath("//android.widget.RelativeLayout[@index='6']");
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
		
	}
	@AfterMethod
	public void quitDriver()
	{
		driver.closeApp();
        driver.quit();
        driver = null;
	}
	
//	@Test(priority=1)
//	public void select_gender() throws InterruptedException
//	{
//		driver.findElement(complete_profile_btn).click();
//		Thread.sleep(5000);
//		driver.findElement(gender).click();
//		driver.findElement(By.id("com.myswaasth:id/tv_female")).click();
//		String female=driver.findElement(By.id("com.myswaasth:id/tv_female")).getText();
//		driver.findElement(By.id("com.myswaasth:id/rl_done")).click();
//		String verify=driver.findElement(By.id("com.myswaasth:id/tv_gender")).getText();
//		Assert.assertTrue(female.equalsIgnoreCase(verify));
//	}
	@Test(priority=1)
	public void select_DOB() throws InterruptedException
	{
		driver.findElement(complete_profile_btn).click();
		Thread.sleep(5000);
		scroll("Date of birth");
		System.out.println("Now starts");
		driver.findElement(DOB).click();
		Thread.sleep(8000);
		System.out.println("Now starts");
		List<MobileElement> edittext = driver.findElements(By.xpath("//android.widget.Button"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		edittext.get(0).click();
		Thread.sleep(8000);
		System.out.println("Now stpppparts");
//		driver.findElement(By.id("com.myswaasth:id/tv_female")).click();
//		String female=driver.findElement(By.id("com.myswaasth:id/tv_female")).getText();
//		driver.findElement(By.id("com.myswaasth:id/rl_done")).click();
//		String verify=driver.findElement(By.id("com.myswaasth:id/tv_gender")).getText();
//		Assert.assertTrue(female.equalsIgnoreCase(verify));
	}
//	@Test(priority=1)
//	public void select_bloodGroup() throws InterruptedException
//	{
//		driver.findElement(complete_profile_btn).click();
//		Thread.sleep(5000);
//		driver.findElement(gender).click();
//		driver.findElement(By.id("com.myswaasth:id/tv_female")).click();
//		String female=driver.findElement(By.id("com.myswaasth:id/tv_female")).getText();
//		driver.findElement(By.id("com.myswaasth:id/rl_done")).click();
//		String verify=driver.findElement(By.id("com.myswaasth:id/tv_gender")).getText();
//		Assert.assertTrue(female.equalsIgnoreCase(verify));
//	}
//	@Test(priority=1)
//	public void select_height() throws InterruptedException
//	{
//		driver.findElement(complete_profile_btn).click();
//		Thread.sleep(5000);
//		driver.findElement(gender).click();
//		driver.findElement(By.id("com.myswaasth:id/tv_female")).click();
//		String female=driver.findElement(By.id("com.myswaasth:id/tv_female")).getText();
//		driver.findElement(By.id("com.myswaasth:id/rl_done")).click();
//		String verify=driver.findElement(By.id("com.myswaasth:id/tv_gender")).getText();
//		Assert.assertTrue(female.equalsIgnoreCase(verify));
//	}
//	@Test(priority=1)
//	public void select_weight() throws InterruptedException
//	{
//		driver.findElement(complete_profile_btn).click();
//		Thread.sleep(5000);
//		driver.findElement(gender).click();
//		driver.findElement(By.id("com.myswaasth:id/tv_female")).click();
//		String female=driver.findElement(By.id("com.myswaasth:id/tv_female")).getText();
//		driver.findElement(By.id("com.myswaasth:id/rl_done")).click();
//		String verify=driver.findElement(By.id("com.myswaasth:id/tv_gender")).getText();
//		Assert.assertTrue(female.equalsIgnoreCase(verify));
//	}
}
