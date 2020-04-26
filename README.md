Appium TestNG POM Framework for Amazon shopping app 

Tools Pre-requisites :
1.Node.js
2.Appium server started
3.Android device attached and discoverable :adb devices
4.Maven 

App Pre-requisites :

1.User should be already logged-in to the amazon app for first time
2.USA Address should be selected default address
3.Assuming card details are updated and ready for selection

How to use :
  
   1. Checkout the master branch
   2. Convert project as maven project
   3. Run command mvn clean install
   4. Change device name capability as per the connected android device in Controller.java
   5. Run appium command in the background
   6. Run the com.amazon.tests.TestAmazonFlow.java as TestNG test
   
Frameworks used :
1.POM
2.Log4j
3.TestNG
4.Appium
