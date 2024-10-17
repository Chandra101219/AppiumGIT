package ios;

import org.testng.Assert;
import org.testng.annotations.Test;

import Appium_Framework.PageObjects.ios.AlertViews;
import io.appium.java_client.ios.IOSDriver;

public class TestCase extends IOSBaseClass{
	
	
	public TestCase(IOSDriver driver) {
		super(driver);
	}

	@Test
	public void IOSBasicsTest()
	{
		//Xpath, classname, IOS, iosClassCHain, IOSPredicateString, accessibility id, id
		
		homePage.selectAlertViews();
		alertViews.fillTextLabel("hello");
		String actualMessage = alertViews.getConfirmMessage();
		Assert.assertEquals(actualMessage, "A message should be a short, complete sentence.");

	
		
	}
}
