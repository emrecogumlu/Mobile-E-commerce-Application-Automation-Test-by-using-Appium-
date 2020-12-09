import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecom_testcase_4 extends base_ecommerce{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		//TEST SCENARIO : Validate the total Amount displayed in the checkout page matches with sum of products amounts selected for shopping (buy 2 products).
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Argentina" + "\").instance(0))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Your Name");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click(); // it's still zero because after clicking for the first time there is only one "ADD TO CART" button left.
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver, 8);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productName")));
				
		Thread.sleep(4000);
		
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		float sum = 0;
		
		for(int i=0 ; i<count ; i++) 
		{
			String amountText = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			float amountTextFloat = getAmount(amountText);
			sum+=amountTextFloat;
		}
	
		
		String totalAmountText =driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		float totalAmountTextFloat = getAmount(totalAmountText);
		
		
		Assert.assertEquals(sum, totalAmountTextFloat);
		

	}

	
	public static float getAmount(String theString) 
	{
		theString = theString.replace("$", "");
		float theStringFloat = Float.parseFloat(theString);
		return theStringFloat;
		
	}
}
