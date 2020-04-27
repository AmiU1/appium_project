package com.amazon.pages;

import java.util.List;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import com.amazon.helper.Controller;
import com.amazon.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.readJson;

public  class PaymentsPageClass extends Helper  {
	

	
	@FindBy(xpath = "(//*[@resource-id='spc-orders']//android.view.View[@index='3'])[3]")
	public MobileElement checkout_description;
	
	@FindBy(xpath = "(//*[@resource-id='spc-orders']//android.view.View[@index='6'])[3]")
	public MobileElement checkout_price;
	
	@FindBys(@FindBy(xpath="//*[@resource-id='spc-orders']//android.view.View"))
    public List<MobileElement> AllData;
	
	@FindBy(xpath = "(//android.view.View[@text='Important message']")
	public MobileElement label_identifier;
	
	
	
	public PaymentsPageClass(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
			 
		}
	//lambda expression calling interface PaymentPage
		public PaymentsPage payment = () -> {
		try {
		logger.info("Verifying payment page");
		Thread.sleep(4000);
		Assert.assertEquals(true, isPageLoaded(label_identifier));
		scroll(readJson.jsonInstance.readJsonData("scrollIdenifier_paymentpage"));
		Thread.sleep(4000);
		Assert.assertEquals(checkout_description.getText(),ProductPageClass.title);
		Assert.assertEquals(checkout_price.getText(),ProductPageClass.price);
		logger.info("Verified payment page successfully");
		}
		catch(Exception e)
		{
				testContext.setStatus(ITestResult.FAILURE);
				logger.error("Couldnt verify loginPage due to :"+e.getMessage());
				Assert.fail();
		}
		
	};


}
