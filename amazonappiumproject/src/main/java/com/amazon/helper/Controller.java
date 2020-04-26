package com.amazon.helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
/*
 this class is controller class which has all the necessary setups and configurations required to start the 
 appium server with capabilities.
  
 */

public class Controller {

	public static OS executionOS = OS.ANDROID;

	public enum OS {
		ANDROID
	}

	public static Controller instance = new Controller();
	public AppiumDriver<?> driver;

	public void start() throws MalformedURLException {
		if (driver != null) {
			return;
		}
		switch (executionOS) {
		case ANDROID:
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/app/Android");
			File app = new File(appDir, "Amazon_shopping.apk");	
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", "Pixel_XL_API_28");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("newCommandTimeout", "40000");
			capabilities.setCapability("udid", "emulator-5554");
			capabilities.setCapability("platformVersion", "9.0");
			capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
			capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
			capabilities.setCapability("skipDeviceInitialization", true);
			capabilities.setCapability("skipServerInstallation", true);
			capabilities.setCapability("noReset", true);
			driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
			break;
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void stop() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
