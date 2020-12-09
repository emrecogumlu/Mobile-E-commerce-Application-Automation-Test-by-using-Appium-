import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecom_testcase_2 extends base_ecommerce{

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//THE TEST SCENARIO : After logging in to the system, check the purchase page functionalities (add 3 products to the cart).
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Belgium" + "\").instance(0))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Belgium']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Your Name");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"));");
		
		int a = 0;
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Converse All Star\").instance(0))"));
		
		int counter = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0; i<counter; i++) 
		{
			String myText = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(myText.equalsIgnoreCase("Converse All Star")) 
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				a++;
				break;
			}
			
		}
		
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
		
		int counter2 = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0; i<counter2; i++) 
		{
			String myText = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(myText.equalsIgnoreCase("Jordan 6 Rings")) 
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				a++;
				break;
			}
			
		}
		
		
		
driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"PG 3\").instance(0))"));
		
		int counter3 = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0; i<counter3; i++) 
		{
			String myText = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(myText.equalsIgnoreCase("PG 3")) 
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				a++;
				break;
			}
			
		}
		
		String theText = driver.findElementById("com.androidsample.generalstore:id/counterText").getText();
		
		int myNum = Integer.parseInt(theText);
		
		Assert.assertEquals(a, myNum); // It checks the equality of the number of clicks on the "Add to cart" button and the number of products in the upper right cart.
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		

	}

}
