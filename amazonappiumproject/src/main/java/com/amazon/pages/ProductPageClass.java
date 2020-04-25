package com.amazon.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.helper.Helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPageClass extends Helper implements ProductPage {

	private String title="";
	
	@FindBy(xpath = "//*[@resource-id='title_feature_div']")
	public MobileElement feature_title;
	
	
	public ProductPageClass(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
			 
		}
	
	public void productPageTest() throws InterruptedException {
		Thread.sleep(2000);
		title=feature_title.getText();
	//	Assert.g
		
		
	}

}
