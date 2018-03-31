package SignUp;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;


public class OnBoarding{
	static By continue_btn= By.id("com.myswaasth:id/tv_continue");
	static By upload_btn=By.id("com.myswaasth:id/tv_gallery");
	static By take_photo=By.id("com.myswaasth:id/tv_camera");
	static By next_btn=By.xpath("//*[@text='NEXT']");
	static By skip=By.id("com.myswaasth:id/tv_skip");
	static By female=By.id("com.myswaasth:id/tv_female");
	static By male=By.id("com.myswaasth:id/tv_male");
	static By neuter=By.id("com.myswaasth:id/tv_neuter");
	static By date_picker=By.xpath("//android.widget.NumberPicker[@index='0']");
	static By month_picker=By.xpath("//android.widget.NumberPicker[@index='1']");
	static By year_picker=By.xpath("//android.widget.NumberPicker[@index='2']");
	static By currentLocation=By.xpath("com.myswaasth:id/tv_getCurrentLocation");

	
	public void upload_from_gallery(AppiumDriver driver)
	{
		driver.findElement(By.id("com.myswaasth:id/tv_continue")).click();
		driver.findElement(upload_btn).click();
		driver.findElement(By.xpath("//*[@index='0']")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
		driver.findElement(next_btn).click();
	}
	
	public void select_gender(AppiumDriver driver)
	{
		driver.findElement(female).click();
	}
	
	public void DOB(AppiumDriver driver)
	{
		driver.findElement(next_btn).click();
	}
	
	public void bloodType(AppiumDriver driver)
	{
		driver.findElement(By.id("com.myswaasth:id/tv_abp")).click();
		driver.findElement(next_btn).click();
	}
	public void height(AppiumDriver driver)
	{
		driver.findElement(next_btn).click();
	}
	public void weight(AppiumDriver driver)
	{
		driver.findElement(next_btn).click();
	}
	
	
	public void location(AppiumDriver driver) throws InterruptedException
	{
		driver.findElement(currentLocation).click();
		if(driver.findElement(By.id("com.android.packageinstaller:id/desc_container")).isDisplayed()==true)
			driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		else
		driver.findElement(next_btn).click();
		driver.findElement(continue_btn).click();
		driver.findElement(skip).click();
		driver.findElement(skip).click();
		driver.findElement(skip).click();
		driver.findElement(skip).click();
		driver.findElement(skip).click();
		Thread.sleep(10000);
	}

}
