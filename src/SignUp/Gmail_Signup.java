package SignUp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Gmail_Signup {
	static By signup= By.id("com.myswaasth:id/signUpTxt");
	static By google_btn=By.id("com.myswaasth:id/googleSignUpTxt");
	static By account_popup=By.id("com.google.android.gms:id/title");
	static By select_account=By.id("com.google.android.gms:id/account_display_name");
	static By mobile=By.id("com.myswaasth:id/tv_mobilenumber");
	static By otp=By.id("com.myswaasth:id/et_otp");
	static By done=By.id("com.myswaasth:id/doneTxt");

	AppiumDriver driver;
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
	@Test
	public void signup_fb() throws InterruptedException
	{
		try {
            driver.hideKeyboard();
            } catch (Exception e) {
            }
		driver.findElement(google_btn).click();
		Thread.sleep(2000);
		if(driver.findElement(account_popup).isDisplayed())
		{
			driver.findElement(select_account).click();
		}
		else
		{
		Thread.sleep(5000);
		}
//		WebElement popup = null;
//		try
//		{
//			popup=driver.findElement(select_account);
//		}
//		catch (Exception e) {
//			
//		}
//		if (popup != null) 
//		{ 
//			Actions actions=new Actions(driver);
//			actions.moveToElement(popup).perform(); 
//			Thread.sleep(6000); 
//			}
		Thread.sleep(10000);
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
