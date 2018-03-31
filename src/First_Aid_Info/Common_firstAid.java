package First_Aid_Info;

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

public class Common_firstAid {
	static By search=By.id("com.myswaasth:id/first_aid_common_search_ET");
	static By desease=By.xpath("//android.widget.LinearLayout[@index='1']");
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
		driver.findElement(By.id("com.myswaasth:id/firstAidButton")).click();
		
	}
	@AfterMethod
	public void quitDriver()
	{
		driver.closeApp();
        driver.quit();
        driver = null;
	}
	@Test
	public void firstAid() throws InterruptedException
	{
		driver.findElement(search).sendKeys("food");
		driver.findElement(desease).click();
		Thread.sleep(6000);
	}
}
