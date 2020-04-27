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


public abstract class BaseTestClass extends BaseClass {

	protected LoginPageClass loginPage;
	protected HomePageClass 	homePage;
	protected ProductPageClass  productPage;
	protected PaymentsPageClass  paymentPage;

	@BeforeSuite
	public void setUp() throws Exception {
		Controller.instance.start();
		switch (Controller.executionOS) {
		case ANDROID:
		loginPage = new LoginPageClass(driver());
    	productPage = new ProductPageClass(driver());
		paymentPage = new PaymentsPageClass(driver());
		homePage = new  HomePageClass(driver());
		break;

		}
	}

	@AfterSuite
	public void tearDown() {
		Controller.instance.stop();
	}
}

