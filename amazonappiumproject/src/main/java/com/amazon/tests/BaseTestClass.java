package com.amazon.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.amazon.helper.BaseClass;
import com.amazon.helper.Controller;
import com.amazon.pages.HomePage;
import com.amazon.pages.HomePageClass;
import com.amazon.pages.LoginPage;
import com.amazon.pages.LoginPageClass;




public class BaseTestClass extends BaseClass {

	protected LoginPage loginPage;
	protected HomePage homePage;
	

	@BeforeSuite
	public void setUp() throws Exception {
		Controller.instance.start();
		switch (Controller.executionOS) {
		case ANDROID:
		loginPage = new LoginPageClass(driver());
		homePage = new  HomePageClass(driver());
		break;

		}
	}

	@AfterSuite
	public void tearDown() {
		//Controller.instance.stop();
	}
}

