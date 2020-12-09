import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecom_testcase_1_1 extends base_ecommerce{

	public static void main(String[] args) throws MalformedURLException {
		
		
	AndroidDriver<AndroidElement> driver = Capabilities();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	// THE TEST SCENARIO: Check system behavior when country name and gender are selected but the name is not entered.
	
	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Argentina" + "\").instance(0))"));
	
	driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	
	driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	//Since we did not enter the name, there will be an error message. To see that: 
	String toastMessageString = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
	
	System.out.println(toastMessageString);
	
	Assert.assertEquals("Please enter your name", toastMessageString); //Actual validation
	
	

	}

}
