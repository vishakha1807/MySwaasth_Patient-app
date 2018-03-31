package Login;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SignUp.OnBoarding;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Fb_Login {
	static By signup= By.id("com.myswaasth:id/signUpTxt");
	static By login= By.id("com.myswaasth:id/loginTxt");
	static By fb_btn=By.id("com.myswaasth:id/facebookLoginTxt");
//	static By email=By.xpath("//android.widget.RelativeLayout[@index='1']");
	static By password=By.xpath("//android.widget.RelativeLayout[@index='2']");
	static By fblogin_btn=By.xpath("//*[@text='LOG IN']");
	static By mobile=By.id("com.myswaasth:id/tv_mobilenumber");
	static By otp=By.id("com.myswaasth:id/et_otp");
	static By done=By.id("com.myswaasth:id/doneTxt");
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
	
	@Test
	public void login_fb() throws InterruptedException
	{
		try {
            driver.hideKeyboard();
            } catch (Exception e) {
            }
		driver.findElement(fb_btn).click();
		Thread.sleep(2000);
		List<MobileElement> email = driver.findElements(By.xpath("//android.widget.EditText[@text='Email or Phone']"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		email.get(0).sendKeys("dummy2singh@gmail.com");
		List<MobileElement> edittext = driver.findElements(By.xpath("//android.widget.EditText"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		edittext.get(1).sendKeys("dummy2singh@");
		driver.findElement(password).sendKeys("dummy2singh@");
		driver.findElement(fblogin_btn).click();
		Thread.sleep(5000);
		driver.findElement(mobile).sendKeys("6754587575");
		driver.findElement(signup).click();
		Thread.sleep(5000);
		driver.findElement(otp).sendKeys("");
		Thread.sleep(8000);
		driver.findElement(done).click();
		OnBoarding on=new OnBoarding();
		on.upload_from_gallery(driver);
		on.select_gender(driver);
		on.DOB(driver);
		on.bloodType(driver);
		on.height(driver);
		on.weight(driver);
		on.location(driver);
	}
}
