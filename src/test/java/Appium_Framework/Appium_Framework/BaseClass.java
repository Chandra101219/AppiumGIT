package Appium_Framework.Appium_Framework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import Appium_Framework.PageObjects.android.CartPage;
import Appium_Framework.PageObjects.android.FormPage;
import Appium_Framework.PageObjects.android.ProductCatalogue;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService server;
	FormPage fp;
	ProductCatalogue productCata;
	CartPage cartPage;
	
	@BeforeClass
	public void serverConfig() throws MalformedURLException, URISyntaxException {
		
//Server code	
		server = new AppiumServiceBuilder()
  	            .withAppiumJS(new File("C://Users//CHANDRA.C//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
  	            .withIPAddress("192.168.1.10") // Corrected IP address format
  	            .usingPort(4723)
  	            .build();
  	   	server.start();
  	        
  	       
// Set up UiAutomator2 options for the Android driver
  	   	UiAutomator2Options options = new UiAutomator2Options();
  	    options.setDeviceName("AndroidDevice");
  	    options.setApp("D://eclipse-workspace//Appium//Appium//src//test//java//resources//General-Store.apk");
  	    
  	    options.setAutoGrantPermissions(true); 

  	    	
// Create the Android driver
  	    driver = new AndroidDriver(new URI("http://192.168.1.10:4723").toURL(), options);
  	    
  	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  	    
  	    fp = new FormPage(driver);
  	    productCata = new ProductCatalogue(driver);
  	    cartPage = new CartPage(driver);
	}

	
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}
	
	public void scrollToEndAction()
	{
		boolean canScrollMore;
		do
		{
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			    
			));
		}while(canScrollMore);
	}
	
	
	public void swipeAction(WebElement container,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)container).getId(),
			 
			    "direction", direction,
			    "percent", 0.75
			));
		
		
	}
	public void scrollToProd(String text) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", text);
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		server.stop();
	}
	
	
	

}
