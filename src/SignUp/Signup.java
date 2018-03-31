package SignUp;

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
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Signup {
	static AppiumDriverLocalService appiumService; 
	static String appiumServiceUrl;
	static By signup= By.id("com.myswaasth:id/signUpTxt");
	static By fullname= By.id("com.myswaasth:id/userNameEditTxt");
	static By email= By.id("com.myswaasth:id/emailEditTxt");
	static By password= By.id("com.myswaasth:id/passwordEditTxt");
	static By mobileno= By.id("com.myswaasth:id/mobileEditTxt");
	AppiumDriver driver;
	public void scroll(String str) {
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+str.toString() +"\").instance(0))"));
	}
//	@BeforeTest
//	public void startAppium()
//	{
//		AppiumServiceBuilder builder = new AppiumServiceBuilder().withAppiumJS(new File("/usr/lib/node_modules/appium/build/lib/main.js")); 
//		appiumService = builder.build(); 
//		appiumService.start();
//	}
//	@AfterTest
//	public void stopAppium()
//	{
//		appiumService.stop();
//	}
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
		driver.findElement(signup).click();
	}
	@AfterMethod
	public void quitDriver()
	{
		driver.closeApp();
        driver.quit();
        driver = null;
	}
	@Test(priority=5)
	public void signup_positivetest() throws InterruptedException, MalformedURLException {
		driver.findElement(fullname).sendKeys("vishakha");
		scroll("Mobile number");
		driver.findElement(email).sendKeys("vishakhagupta.innotical@gmail.com");
		driver.findElement(password).sendKeys("123456");
		driver.findElement(mobileno).sendKeys("6989585486");
		driver.findElement(signup).click();
		Thread.sleep(6000);
		driver.findElement(By.id("com.myswaasth:id/et_otp")).sendKeys("");
		Thread.sleep(8000);
		driver.findElement(By.id("com.myswaasth:id/doneTxt")).click();
		
		OnBoarding on=new OnBoarding();
		on.upload_from_gallery(driver);
		on.select_gender(driver);
		on.DOB(driver);
		on.bloodType(driver);
		on.height(driver);
		on.weight(driver);
		on.location(driver);
	}
	
	@Test(priority=1)
	public void signup_negativetest1() throws InterruptedException, MalformedURLException {
		driver.findElement(fullname).sendKeys("vishakha123");
		Assert.assertEquals("Please enter valid name",driver.findElement(By.id("com.myswaasth:id/textinput_error")).isDisplayed());
		scroll("Mobile number");
		driver.findElement(email).sendKeys("vish65783@gmail.com");
		driver.findElement(password).sendKeys("123456");
		driver.findElement(mobileno).sendKeys("3588588965");
		driver.findElement(signup).click();
			
	}
	@Test(priority=2)
	public void signup_negativetest2() throws InterruptedException, MalformedURLException {
		driver.findElement(fullname).sendKeys("vishakha");
		scroll("Mobile number");
		driver.findElement(email).sendKeys("vishakha1807");
		Assert.assertEquals("Please enter valid email id", driver.findElement(By.id("com.myswaasth:id/textinput_error")).isDisplayed());
		driver.findElement(password).sendKeys("123456");
		driver.findElement(mobileno).sendKeys("5336324642");
		driver.findElement(signup).click();
	}
	@Test(priority=3)
	public void signup_negativetest3() throws InterruptedException, MalformedURLException {
		driver.findElement(fullname).sendKeys("vishakha");
		scroll("Mobile number");
		driver.findElement(email).sendKeys("vishakha768676@gmail.com");
		driver.findElement(password).sendKeys("12");
		Assert.assertEquals("Use at least 6 characters", driver.findElement(By.id("com.myswaasth:id/textinput_error")).isDisplayed());
		driver.findElement(mobileno).sendKeys("5643256350");
		driver.findElement(signup).click();
	}
	@Test(priority=4)
	public void signup_negativetest4() throws InterruptedException, MalformedURLException {
		driver.findElement(fullname).sendKeys("vishakha");
		scroll("Mobile number");
		driver.findElement(email).sendKeys("vishakha78967@gmail.com");
		driver.findElement(password).sendKeys("123456");
		driver.findElement(mobileno).sendKeys("767766749");
		Assert.assertEquals("Please enter valid mobile number", driver.findElement(By.id("com.myswaasth:id/textinput_error")).isDisplayed());
		driver.findElement(signup).click();
		
	}
}
	

