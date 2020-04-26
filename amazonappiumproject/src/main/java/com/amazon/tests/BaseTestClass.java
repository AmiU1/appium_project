package com.amazon.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.amazon.helper.BaseClass;
import com.amazon.helper.Controller;
import com.amazon.pages.HomePage;
import com.amazon.pages.HomePageClass;
import com.amazon.pages.LoginPage;
import com.amazon.pages.LoginPageClass;
import com.amazon.pages.PaymentsPage;
import com.amazon.pages.PaymentsPageClass;
import com.amazon.pages.ProductPage;
import com.amazon.pages.ProductPageClass;

/*
this class create new instances of the appium server and creates objects for the page classes
 
*/


public class BaseTestClass extends BaseClass {

	protected LoginPage loginPage;
	protected HomePage 	homePage;
	protected ProductPage  productPage;
	protected PaymentsPage  paymentPage;

	@BeforeSuite
	public void setUp() throws Exception {
		Controller.instance.start();
		switch (Controller.executionOS) {
		case ANDROID:
		loginPage = new LoginPageClass(driver());
		homePage = new  HomePageClass(driver());
		productPage = new ProductPageClass(driver());
		paymentPage = new PaymentsPageClass(driver());
		break;

		}
	}

	@AfterSuite
	public void tearDown() {
		Controller.instance.stop();
	}
}

