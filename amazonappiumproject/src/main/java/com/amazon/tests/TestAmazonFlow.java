package com.amazon.tests;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;



public class TestAmazonFlow extends BaseTestClass {
	
	
	static Logger log = Logger.getLogger(TestAmazonFlow.class.getName());
	private String userEmail = "kumar.amithe90@gmail.com";
	private String userPassword = "justrock1";
		
//	@Test(priority=1)
//	public void verifyLogin() throws InterruptedException {
//		log.info("Executing Login");
//		loginPage.loginToAmazonApp(userEmail, userPassword);
//		}
	
	
	@Test(priority=1)
	
	public void verifyHomePageTest() throws InterruptedException, AWTException  {
		log.info("Executing home");
		homePage.homePageTest();
	}
}
	
