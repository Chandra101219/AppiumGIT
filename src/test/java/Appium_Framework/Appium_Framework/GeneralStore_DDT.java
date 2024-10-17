package Appium_Framework.Appium_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class GeneralStore_DDT extends BaseClass{
	
	@Test
	
	public void fillFormDetails() throws InterruptedException {
		
		//country dropdown
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Austria\"]")).click();
		
		//name textbox
		
		/*driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/nameField\")")).sendKeys("Chandra");
		driver.hideKeyboard();*/
		
		//gender radio button
		
		WebElement radiobutton1 = driver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Male\"]"));
		WebElement radiobutton2 = driver.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\"]"));
		
		if (radiobutton1.getAttribute("enabled").equals("false")) {
			radiobutton1.click();
	    }
		
		//lets shop button
		
		driver.findElement(By.className("android.widget.Button")).click();
		
		Thread.sleep(3000);
		
		//toast message
		
		String errormsg = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name"); //("//android.widget.Toast")[1])
		
		Assert.assertEquals(errormsg, "Please enter your na");
		
		
	}
}