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
	
	@FindBy(xpath = "//android.view.View[@index='39']")
	public MobileElement selectTv;
	

		public HomePageClass(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
			 
		}

		
		public void homePageTest() throws InterruptedException,AWTException {
			 System.out.println("----1-----");
			Thread.sleep(6000);
			waitTillElementVisiblity(search);
			clickElement(search);	
			System.out.println("----2-----");
			Thread.sleep(6000);
			waitTillElementVisiblity(elementOne);
			 System.out.println("----3-----");
			 Thread.sleep(6000);
			inputString(elementOne, "65 inch tv");
			Thread.sleep(6000);
			waitTillElementVisiblity(selectListTv);
			Thread.sleep(3000);
			clickElement(selectListTv);
			 System.out.println("----4-----");
			Thread.sleep(3000);
			System.out.println(scrollToAnElementByIndex());
			Thread.sleep(3000);
			scrollToAnElementByIndex().click();
		
		}

}
