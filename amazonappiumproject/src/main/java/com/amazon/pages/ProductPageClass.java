package com.amazon.pages;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import com.amazon.helper.Helper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.readJson;

public class ProductPageClass extends Helper implements ProductPage {
	 
	public String title="";
	public String price="";
	
	
	@FindBy(xpath = "//*[@resource-id='title_feature_div']//android.view.View")
	public MobileElement feature_title;
	
	@FindBy(xpath = "//*[@resource-id='newPitchPriceWrapper_feature_div']//android.view.View[2]")
	public MobileElement tv_price;
	
	@FindBy(xpath = "//*[@resource-id='newPitchPriceWrapper_feature_div']//android.view.View[3]")
	public MobileElement tv_Decimalprice;
	
		
	@FindBy(xpath = "//*[@resource-id='buyNow']")
	public MobileElement buyNow;
	
	@FindBy(xpath = "(//android.view.View[@index='2'])[2]")
	public MobileElement deliverToThisAddress;
	
	@FindBy(xpath = "(//android.view.View//android.widget.Button)[1]")
	public MobileElement continueButton;
	
	@FindBy(xpath = "(//*[@resource-id='address-select']//android.view.View[3]//android.view.View[1])[1]")
	public MobileElement selectAaddress;
	
	//android.widget.Button[@text='See All Buying Options']
	@FindBy(xpath = "//android.widget.Button[@text='See All Buying Options']")
	public MobileElement seeAllBuyingOptions;
		
	public ProductPageClass(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
			 
		}
	
	public void productPageTest() throws InterruptedException {
		try {
		logger.info("Verifying product page");
		Thread.sleep(7000);
		//if the product is not in stock and unavailable ,it will go back to search page and select other product
		if(isVisible(seeAllBuyingOptions))
		{
			goBack();
			Ycoordinate=Ycoordinate+400;
			Tap();
		}
		waitTillElementVisiblity(feature_title);
		Assert.assertEquals(true, isPageLoaded(feature_title));
		title=feature_title.getText();
		scroll(readJson.jsonInstance.readJsonData("scrollIdenifier_productpage"));
		Thread.sleep(3000);
		price="$".concat(tv_price.getText()).concat("."+tv_Decimalprice.getText());
		price=price.replaceAll(" ","");
		clickElement(buyNow);
		Thread.sleep(5000);
		clickElement(continueButton);
		logger.info("Verified product page successfully");
		}
		catch(Exception e)
		{
			Assert.fail();
			testContext.setStatus(ITestResult.FAILURE);
			logger.error("Couldnt verify product page due to :"+e.getMessage());
		}
		
		
	}

}
