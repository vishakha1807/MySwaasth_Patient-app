package Health_Feed;

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
import io.appium.java_client.android.AndroidKeyCode;

public class Latest_HealthFeed {
	static By article=By.xpath("//android.widget.ImageView[@index='0']");
	static By bookmark=By.id("com.myswaasth:id/bookmark");
	static By profile_btn=By.id("com.myswaasth:id/iv_profile");
	static By bookmarked_article=By.id("com.myswaasth:id/bookmarkedArticleTxt");
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
		driver.findElement(By.id("com.myswaasth:id/healthArticlesButton")).click();
		
	}
	@AfterMethod
	public void quitDriver()
	{
		driver.closeApp();
        driver.quit();
        driver = null;
	}
	
	@Test(priority=1)
	public void firstAid_bookmared() throws InterruptedException
	{
		driver.findElement(article).click();
		Thread.sleep(6000);
		driver.findElement(bookmark).click();
		Thread.sleep(6000);
		String actualTitle=driver.findElement(By.id("com.myswaasth:id/tv_posttitle")).getText();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(5000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(5000);
		driver.findElement(profile_btn).click();
		scroll("Bookmarked Articles");
		driver.findElement(bookmarked_article).click();
		Thread.sleep(8000);
		String expectedTitle=driver.findElement(By.id("com.myswaasth:id/savedInfoNameCTV")).getText();
		Thread.sleep(5000);
		Assert.assertEquals(actualTitle, expectedTitle);
		}
	
	@Test(priority=2)
	public void firstAid_unbookmarked() throws InterruptedException
	{
		driver.findElement(article).click();
		Thread.sleep(6000);
		driver.findElement(bookmark).click();
		Thread.sleep(6000);
		String actualTitle=driver.findElement(By.id("com.myswaasth:id/tv_posttitle")).getText();
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(5000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(5000);
		driver.findElement(profile_btn).click();
		scroll("Bookmarked Articles");
		driver.findElement(bookmarked_article).click();
		Thread.sleep(8000);
		String expectedTitle=driver.findElement(By.id("com.myswaasth:id/not_added_CTV")).getText();
		Thread.sleep(5000);
		Assert.assertNotEquals(actualTitle, expectedTitle);
		}
	}

