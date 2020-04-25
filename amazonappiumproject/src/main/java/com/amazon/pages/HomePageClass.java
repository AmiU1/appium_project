package com.amazon.pages;

import java.awt.AWTException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;


public class HomePageClass extends Helper implements HomePage {
	
	
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
			
			Thread.sleep(6000);
			waitTillElementVisiblity(search);
			clickElement(search);	
			Thread.sleep(6000);
			waitTillElementVisiblity(elementOne);
			Thread.sleep(6000);
			inputString(elementOne, "65 inch tv");
			Thread.sleep(6000);
			waitTillElementVisiblity(selectListTv);
			Thread.sleep(3000);
			clickElement(selectListTv);
			Thread.sleep(4000);
			scrollToAnElement().click();
			Thread.sleep(4000);
			clickElement(selectTv);
		
		}

}
