package Appium_Framework.Appium_Framework;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;

public class GeneralStore_TC_1 extends BaseClass{

	/*@BeforeMethod
	public void getBackToHome() {
		
		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.SplashActivity");
		
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", 
			    ImmutableMap.of("intent", "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
  
	}*/
	
	@Test (priority=1)
	public void fillingForm() throws InterruptedException {
	
		fp.selectCountry("Austria");
		fp.enterName("Chandra");
		fp.selectGender("male");
		fp.clickLetsShop();	
		//ProductCatalogue productCata = fp.clickLetsShop();
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void addItemToCart() throws InterruptedException {

		productCata.clickAddToCart(0);
		productCata.clickAddToCart(0);
		
		productCata.clickOnCartIcon();
	
		Thread.sleep(2000);
	}
	

	@Test(priority=3)
	public void cartPage() throws InterruptedException {

		cartPage.getProductPrices();
		
		double totalSum = cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		
		Assert.assertEquals(totalSum, displayFormattedSum);
		
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();

		Thread.sleep(2000);
	}
	
	
}
