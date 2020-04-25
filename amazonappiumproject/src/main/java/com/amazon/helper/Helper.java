package com.amazon.helper;



import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

//
//import static io.appium.java_client.touch.offset.PointOption.point;
//import static java.time.Duration.ofMillis;
//import static java.time.Duration.ofSeconds;
//import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class Helper {

	//wait for maximum 30 seconds before any operation
	WebDriverWait wait = new WebDriverWait(Controller.instance.driver, 60);

	protected String getPageSource() {
		return Controller.instance.driver.getPageSource();
	}
	
	protected void switchFrame(MobileElement mobileElement) {
		Controller.instance.driver.switchTo().frame(mobileElement);
	}
	
	protected void enterText(MobileElement mobileElement,String stringToBeEntered) {
		mobileElement.sendKeys(stringToBeEntered);	}
	

	protected void inputString(MobileElement mobileElement, String stringToBeEntered) {
		mobileElement = waitTillElementVisible(mobileElement);
		mobileElement.sendKeys(stringToBeEntered);
		Controller.instance.driver.hideKeyboard();
	}

	protected void clickElement(MobileElement mobileElement) {
		mobileElement = waitTillElementVisible(mobileElement);
		mobileElement.click();
	}

	protected String getAttribute(MobileElement mobileElement, String attr) {
		mobileElement = waitTillElementVisible(mobileElement);
		return mobileElement.getAttribute(attr);
	}

	protected void goBack() {
		Controller.instance.driver.navigate().back();
	}

	protected boolean isVisible(MobileElement mobileElement) {

		boolean status = false;
		try {
			mobileElement = waitTillElementVisible(mobileElement);
			status = true;
		} catch (Exception e) {

		}
		return status;
	}

	protected MobileElement waitTillElementVisible(MobileElement mobileElement) {
		return (MobileElement) wait.until(ExpectedConditions.visibilityOf(mobileElement));

	}
	
	public void waitTillElementVisiblity(MobileElement mobileElement) {
		wait.until(ExpectedConditions.visibilityOf(mobileElement));

	}
	
	public MobileElement scrollToAnElement() {
		return(MobileElement) Controller.instance.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
    ".scrollIntoView(new UiSelector().textContains(\"Samsung UN65RU7300FXZA Curved\"));"));
	}
	
//	public void swipetToBottom()
//	{
//		
//		Dimension dim = Controller.instance.driver.manage().window().getSize();
//		int height = dim.getHeight();
//		int width = dim.getWidth();
//		int x = width/2;
//		int top_y = (int)(height*0.80);
//		int bottom_y = (int)(height*0.20);
//		System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
//		TouchAction ts = new TouchAction(Controller.instance.driver);
//		ts.press(x, top_y).moveTo(x, bottom_y).release().perform();
//}
	
	public MobileElement scrollToBottom()
	{
		return(MobileElement) Controller.instance.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
			    ".scrollIntoView(new UiSelector().textContains(\"Secure transaction\"));"));
    }
	
	public MobileElement scrollToPlaceOrder()
	{
		return(MobileElement) Controller.instance.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
			    ".scrollIntoView(new UiSelector().textContains(\"Estimated delivery\"));"));
    }
	
	
	
	
}
