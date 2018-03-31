package APPOINTMENTS;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Consult_Live.Consultation;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Symptoms {
		static By symptoms_option= By.id("com.myswaasth:id/mysymptomText");
		static By rotate=By.id("com.myswaasth:id/button_rotate");
		static By Gender=By.id("com.myswaasth:id/button_gender");
		static By all_symptoms= By.xpath("//*[@text='All Symptoms']");
		static By symptom1=By.xpath("//*[@text='Abnormal breathing sounds']");
		static By symptom2=By.xpath("//android.widget.LinearLayout[@index='1']");
		static By search =By.id("com.myswaasth:id/all_symptom_search_ET");
		static By bookmark=By.id("com.myswaasth:id/bookmark");
		static By consult_with_doctor=By.id("com.myswaasth:id/consultDocTV");
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
			driver.findElement(By.id("com.myswaasth:id/selfHelpButton")).click();
			
		}
		@AfterMethod
		public void quitDriver()
		{
			driver.closeApp();
	        driver.quit();
	        driver = null;
		}
		@Test(priority=1)
		public void symptom1_details() throws InterruptedException
		{
			driver.findElement(symptoms_option).click();
			driver.findElement(rotate).click();
			driver.findElement(Gender).click();
			driver.findElement(all_symptoms).click();
			driver.findElement(symptom1).click();
			Thread.sleep(6000);
			driver.findElement(bookmark).click();
			Thread.sleep(6000);
		}
		@Test(priority=2)
		public void consultWithDoctor() throws InterruptedException
		{
			driver.findElement(symptoms_option).click();
			driver.findElement(all_symptoms).click();
			driver.findElement(symptom1).click();
			Thread.sleep(6000);
			driver.findElement(consult_with_doctor).click();
			Consultation consult = new Consultation();
			consult.Text_consult(driver);
		}
		@Test(priority=3)
		public void symptom2_details() throws InterruptedException
		{
			driver.findElement(symptoms_option).click();
			driver.findElement(all_symptoms).click();
			driver.findElement(search).sendKeys("Headache after trauma");
			Thread.sleep(3000);
			driver.findElement(symptom2).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//android.widget.LinearLayout[@index='3']")).click();
			Thread.sleep(5000);
		}

}
