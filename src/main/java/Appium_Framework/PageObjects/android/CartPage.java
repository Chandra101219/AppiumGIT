package Appium_Framework.PageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class CartPage extends AndroidActions{
	
	AndroidDriver driver;
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);		
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productPrices;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	private List<WebElement> productName;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsandcond;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement acceptButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;

	public List<WebElement> getProductPrices()
	{
		return productPrices;	
	}
	
	public double getProductsSum()
	{
		int count = productPrices.size();
		
		System.out.println(count);
		double totalSum =0;
		
		for(int i =0; i< count; i++)
		{		
			String productname = productName.get(i).getText();
			
			String amountString =productPrices.get(i).getText();
			
			Double productPrice = getFormattedAmount(amountString);
			
			totalSum = totalSum + productPrice;
			
			System.out.println("Price of the " + productname + ": "+ productPrice);
				
		}
		System.out.println("Total Sum of Products: " + totalSum);
		return totalSum;
	}
	
	public Double getTotalAmountDisplayed()
	{
		Double displayedAmount = getFormattedAmount(totalAmount.getText());
		System.out.println("Displayed Total Amount: " + displayedAmount);
		return getFormattedAmount(totalAmount.getText());
	}
	
	public Double getFormattedAmount(String amount)
	{
		Double formattedPrice = Double.parseDouble(amount.substring(1));
		return formattedPrice;
		
	}
	
	public void acceptTermsConditions()
	{
		longPressAction(termsandcond);
		acceptButton.click();
	}
	

	public void submitOrder()
	{
		checkBox.click();
		proceed.click();
	}

	


}
