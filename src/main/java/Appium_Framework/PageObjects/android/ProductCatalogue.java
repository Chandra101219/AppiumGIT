package Appium_Framework.PageObjects.android;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class ProductCatalogue extends AndroidActions{
	
	AndroidDriver driver;
	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement carticon;
	
	public void clickAddToCart(int index) {
		
	/*	int proCount = addToCart.size();
		
		for(int i=0;i<proCount;i++){
			addToCart.get(i).click();
			scrollToNext(addToCart);
			
		}*/
	 
		addToCart.get(index).click();
	}
	public void clickOnCartIcon() {
		carticon.click();
	}

}
