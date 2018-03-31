package Login;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Login {
	static By login= By.id("com.myswaasth:id/loginTxt");
	static By email= By.id("com.myswaasth:id/emailMobileEditTxt");
	static By password= By.id("com.myswaasth:id/passwordEditTxt");
	static By login_btn= By.id("com.myswaasth:id/loginTxt");
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
		driver.findElement(login).click();
	}
	@AfterMethod
	public void quitDriver()
	{
		driver.closeApp();
        driver.quit();
        driver = null;
	}
	@Test(priority=2)
	public void valid_login()
	{
		driver.findElement(email).sendKeys("7500355112");
		driver.findElement(password).sendKeys("8826277650");
		driver.findElement(login_btn).click();
	}
	
	@Test(priority=1)
	public void invalid_login()
	{
		driver.findElement(email).sendKeys("7577547574");
		driver.findElement(password).sendKeys("123456");
		driver.findElement(login_btn).click();
		String error_msg=driver.findElement(By.id("com.myswaasth:id/textinput_error")).getText();
		Assert.assertEquals("Please Enter your Registered Mobile Number", error_msg);
	}
}
