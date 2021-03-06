package com.amazon.pages;



import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import com.amazon.helper.Controller;
import com.amazon.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.amazon.pages.LoginPage;



public  class LoginPageClass extends Helper  {
	
	

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

			public LoginPage login = (String userName, String passWord) -> {
			try {
			logger.info("Verifying loginpage");
			Thread.sleep(2000);
			waitTillElementVisiblity(signInSkipButton);
			if(isVisible(signInButton))
			{
			clickElement(signInSkipButton);
			}
//			waitTillElementVisiblity(emailLogin);
//			inputString(emailLogin, userName);
//			waitTillElementVisiblity(continueButton);
//			clickElement(continueButton);
//			waitTillElementVisible(password);
//			inputString(password, passWord);
//			waitTillElementVisible(signIn);
//			clickElement(signIn);
			logger.info("Verified loginpage successfully");
			}
			catch(Exception e)
			{
				
				testContext.setStatus(ITestResult.FAILURE);
				logger.error("Couldnt verify loginPage due to :"+e.getMessage());
				Controller.instance.stop();
			}
		
	};

	

}
