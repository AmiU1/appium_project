package com.amazon.pages;

import java.awt.AWTException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;

import com.amazon.helper.Controller;
import com.amazon.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import utils.readJson;


public class HomePageClass extends Helper implements HomePage {
		
		
	ITestResult testContext;
	
	@FindBy(xpath = "//android.widget.EditText[@text='What are you looking for?']")
	public MobileElement search;
	
	@FindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	public MobileElement elementOne;
		
	@FindBy(xpath = "//android.widget.TextView[@text='65 inch tv']")
	public MobileElement selectListTv;

	@FindBy(xpath = "//*[@resource-id='search']//android.view.View[72]")
	public MobileElement selectTv;
	
	

		public HomePageClass(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
			 
		}
		
		
		public void homePageTest() throws InterruptedException,AWTException {
			try {
			logger.info("Verifying homepage");
			Thread.sleep(5000);
			Assert.assertEquals(true, isPageLoaded(search));
			waitTillElementVisiblity(search);
			clickElement(search);	
			Thread.sleep(5000);
			waitTillElementVisiblity(elementOne);
			Thread.sleep(5000);
			inputString(elementOne, readJson.jsonInstance.readJsonData("tv"));
			Thread.sleep(5000);
			waitTillElementVisiblity(selectListTv);
			Thread.sleep(3000);
			clickElement(selectListTv);
			Thread.sleep(2000);
			scroll(readJson.jsonInstance.readJsonData("scrollIdenifier_homepage"));
			Thread.sleep(2000);
			Tap();
			Thread.sleep(3000);
			logger.info("Verified homepage successfully");
			}
			catch(Exception e)
			{	
				e.printStackTrace();
				testContext.setStatus(ITestResult.FAILURE);
				Controller.instance.stop();
				
			
			}
		
		}

}
