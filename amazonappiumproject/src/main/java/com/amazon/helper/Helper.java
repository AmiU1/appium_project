package com.amazon.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

/*
this class contains all the required functions to perform different actions on the app
 
*/

public class Helper {
	
	public static Logger logger = LogManager.getLogger();
	public static ITestResult testContext;
	public MobileElement tempElement;
	public int Xcoordinate=0;
	public int Ycoordinate=0;
	
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
	
	protected void waitTillElementVisiblity(MobileElement mobileElement) {
		wait.until(ExpectedConditions.visibilityOf(mobileElement));

	}
	
	protected MobileElement scrollIntoView() {
		return(MobileElement) Controller.instance.driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
    ".scrollIntoView(new UiSelector().textContains(\"Samsung UN65RU7300FXZA Curved\"));"));
	}
	
	//check if page loaded
	public boolean isPageLoaded(MobileElement mobileElement) {
		return isVisible(mobileElement);
	}	
	
	public void Tap()
	{
		TouchAction a2 = new TouchAction(Controller.instance.driver);
		Xcoordinate=tempElement.getLocation().getX();
		Ycoordinate=tempElement.getLocation().getY();
		a2.tap(tempElement.getLocation().getX(),tempElement.getLocation().getY()).perform();
	}
	//scroll to element 
	public void scroll(String str) {
		tempElement= (MobileElement) Controller.instance.driver
                .findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+ str + "\").instance(0))"));
	}
	
	
	
}
