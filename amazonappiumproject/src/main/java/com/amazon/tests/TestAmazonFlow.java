package com.amazon.tests;

import java.awt.AWTException;
import org.testng.annotations.Test;
import com.amazon.pages.*;
import com.amazon.pages.HomePageClass;

/*
this class is the main class which has all the test methods which will run in sequence using priority of testNG
 
*/

public  class TestAmazonFlow extends BaseTestClass {
	
			
//	@Test(priority=1)
//	public void verifyLogin() throws InterruptedException {
//		log.info("Executing Login");
//		login.loginToAmazonApp(userEmail, userPassword);
//		}
	
	
	@Test(priority=1)
	
	public void  verifyHomePageTest()   {
		homePage.home.homePageTest();
	}
	
	@Test(priority=2)
	
	public void verifyProductPageTest() throws InterruptedException  {
		productPage.products.productPageTest();
	}
	
	@Test(priority=3)
	
	public void verifyPaymentPageTest() throws InterruptedException  {
		paymentPage.payment.paymentPageTest();
	}
}
	
