package com.amazon.helper;

import io.appium.java_client.AppiumDriver;

	public abstract class BaseClass {

		protected AppiumDriver<?> driver() {
			
			return Controller.instance.driver;
			
		}
	}


