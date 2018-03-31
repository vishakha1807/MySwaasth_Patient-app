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

public class Additional_Info {
	static By profile_btn=By.id("com.myswaasth:id/iv_profile");
	static By complete_profile_btn=By.id("com.myswaasth:id/completeProfile");
	static By additional_btn=By.xpath("//*[@text='Additional']");
	static By smoking=By.id("com.myswaasth:id/tv_smoke");
	static By food=By.xpath("//android.widget.RelativeLayout[@index='1']");
	static By activity_level=By.xpath("//android.widget.RelativeLayout[@index='2']");
	static By alcohol_consumption=By.xpath("//android.widget.RelativeLayout[@index='3']");
	static By allergies=By.xpath("//android.widget.RelativeLayout[@index='4']");
	static By surgeries=By.xpath("//android.widget.RelativeLayout[@index='5']");
	static By chronic_disesaes=By.xpath("//android.widget.RelativeLayout[@index='6']");
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
		driver.findElement(additional_btn).click();
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
	public void smoking_habit() throws InterruptedException
	{
		driver.findElement(smoking).click();
		driver.findElement(By.id("com.myswaasth:id/tv_ocassionaly")).click();
		String actualText=driver.findElement(By.id("com.myswaasth:id/tv_ocassionaly")).getText();
		driver.findElement(done_btn).click();
		String expectedText=driver.findElement(By.id("com.myswaasth:id/tv_smoke")).getText();
		Thread.sleep(5000);
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));
		driver.findElement(completeSave).click();
		Thread.sleep(5000);
	}
	@Test(priority=2)
	public void food_preference() throws InterruptedException
	{
		driver.findElement(food).click();
		driver.findElement(By.id("com.myswaasth:id/tv_inevereat")).click();
		String actualText=driver.findElement(By.id("com.myswaasth:id/tv_inevereat")).getText();
		driver.findElement(done_btn).click();
		String expectedText=driver.findElement(By.id("com.myswaasth:id/tv_food")).getText();
		Thread.sleep(5000);
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));
		driver.findElement(completeSave).click();
		Thread.sleep(5000);
	}
	@Test(priority=3)
	public void activity_Level() throws InterruptedException
	{
		driver.findElement(activity_level).click();
		driver.findElement(By.id("com.myswaasth:id/tv_onetotwo")).click();
		String actualText=driver.findElement(By.id("com.myswaasth:id/tv_onetotwo")).getText();
		driver.findElement(done_btn).click();
		String expectedText=driver.findElement(By.id("com.myswaasth:id/tv_activityLevel")).getText();
		Thread.sleep(5000);
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));
		driver.findElement(completeSave).click();
		Thread.sleep(5000);
	}
	@Test(priority=4)
	public void Alcohol_consumption() throws InterruptedException
	{
		driver.findElement(alcohol_consumption).click();
		driver.findElement(By.id("com.myswaasth:id/tv_drinkoccasionaly")).click();
		String actualText=driver.findElement(By.id("com.myswaasth:id/tv_drinkoccasionaly")).getText();
		driver.findElement(done_btn).click();
		String expectedText=driver.findElement(By.id("com.myswaasth:id/tv_alcoholConsumption")).getText();
		Thread.sleep(5000);
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));
		driver.findElement(completeSave).click();
		Thread.sleep(5000);
	}
	@Test(priority=5)
	public void alleries_type() throws InterruptedException
	{
		driver.findElement(allergies).click();
		driver.findElement(By.id("com.myswaasth:id/tv_addIllness")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Food Allergy']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Skin Allergy']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Dust Allergy']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Pet Allergy']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.myswaasth:id/tv_done")).click();
		Thread.sleep(5000);
		List<MobileElement> editText = driver.findElements(By.id("com.myswaasth:id/tv_inflatertext"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String actualText1=editText.get(0).getText();
		String actualText2=editText.get(1).getText();
		String actualText3=editText.get(2).getText();
		String actualText4=editText.get(3).getText();
		String actualText=" "+actualText1+", "+actualText2+", "+actualText3+", "+actualText4+" ";
		Thread.sleep(5000);
		driver.findElement(done_btn).click();
		Thread.sleep(5000);
		String expectedText=driver.findElement(By.id("com.myswaasth:id/tv_allergy")).getText();
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));
		driver.findElement(completeSave).click();
		Thread.sleep(5000);
	}
	@Test(priority=6)
	public void surgeries_type() throws InterruptedException
	{
		scroll("Surgeries");
		driver.findElement(surgeries).click();
		driver.findElement(By.id("com.myswaasth:id/tv_addIllness")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='General Surgery']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Breast Surgery']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Hand Surgery']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.myswaasth:id/tv_done")).click();
		Thread.sleep(5000);
		List<MobileElement> editText = driver.findElements(By.id("com.myswaasth:id/tv_inflatertext"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String actualText1=editText.get(0).getText();
		String actualText2=editText.get(1).getText();
		String actualText3=editText.get(2).getText();
		String actualText=" "+actualText1+", "+actualText2+", "+actualText3+" ";
		Thread.sleep(5000);
		driver.findElement(done_btn).click();
		Thread.sleep(5000);
		String expectedText=driver.findElement(By.id("com.myswaasth:id/tv_surgery")).getText();
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));
		driver.findElement(completeSave).click();
		Thread.sleep(5000);
	}
	
	@Test(priority=7)
	public void chronicDiseases_type() throws InterruptedException
	{
		scroll("Chronic Diseases");
		driver.findElement(chronic_disesaes).click();
		driver.findElement(By.id("com.myswaasth:id/tv_no")).click();
		Thread.sleep(5000);
		driver.findElement(chronic_disesaes).click();
		driver.findElement(By.id("com.myswaasth:id/tv_yes")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@text='Blood Clot']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.myswaasth:id/tv_done")).click();
		Thread.sleep(5000);
		List<MobileElement> editText = driver.findElements(By.id("com.myswaasth:id/tv_inflatertext"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String actualText1=editText.get(0).getText();
		String actualText=" "+actualText1+" ";
		Thread.sleep(5000);
		driver.findElement(done_btn).click();
		Thread.sleep(5000);
		String expectedText=driver.findElement(By.id("com.myswaasth:id/tv_chronicDeseases")).getText();
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));
		driver.findElement(completeSave).click();
		Thread.sleep(5000);
	}
	
	
}
