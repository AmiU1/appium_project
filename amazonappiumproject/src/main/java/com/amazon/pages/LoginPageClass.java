package com.amazon.pages;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.amazon.pages.LoginPage;



public class LoginPageClass extends Helper implements LoginPage {
	
	
			

	@FindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button")
	public MobileElement signInButton;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText")
			
	public MobileElement emailLogin;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.widget.Button")
	public MobileElement continueButton;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[8]/android.view.View[2]/android.widget.EditText\n" + 
			"")
	public MobileElement password;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[8]/android.view.View[11]/android.view.View/android.widget.Button\n" + 
			"")
	public MobileElement signIn;
	

	@FindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	public MobileElement signInSkipButton;

	
		
	public LoginPageClass(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	public void loginToAmazonApp(String userName, String passWord) throws InterruptedException {

		{
			
			Thread.sleep(2000);
			waitTillElementVisiblity(signInSkipButton);
			clickElement(signInSkipButton);
		
//			waitTillElementVisiblity(emailLogin);
//			inputString(emailLogin, userName);
//			waitTillElementVisiblity(continueButton);
//			clickElement(continueButton);
//			waitTillElementVisible(password);
//			inputString(password, passWord);
//			waitTillElementVisible(signIn);
//			clickElement(signIn);
//			
		}
	}

	

}
