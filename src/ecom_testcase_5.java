import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;

public class ecom_testcase_5 extends base_ecommerce{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
		
	//TEST SCENARIO: 5)	Validate mobile gestures working for links (long press) and navigate to web view and verify if user can do operations on Web view and can navigate back to Native app if needed.
	
	AndroidDriver<AndroidElement> driver = Capabilities();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
	driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Name");
	driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
	TouchAction t = new TouchAction(driver);
	
	WebElement conditions = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	
	t.longPress(longPressOptions().withElement(element(conditions)).withDuration(ofSeconds(1))).release().perform();
	
	String theText = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
	
	Assert.assertEquals("Terms Of Conditions", theText);
	
	WebElement close = driver.findElement(By.id("android:id/button1"));
	
	t.tap(tapOptions().withElement(element(close))).perform();
	
	
	
	WebElement check = driver.findElement(By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']"));
	
	t.tap(tapOptions().withElement(element(check))).perform();
	
	
	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	
	Thread.sleep(7000);
	
//	Set<String> contexts = driver.getContextHandles();
//	
//	for(String contextName : contexts) 
//	{
//		System.out.println(contextName);
//	}
	
	driver.context("WEBVIEW_com.androidsample.generalstore");
	driver.findElement(By.name("q")).sendKeys("eksi");
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div:nth-child(1) > div.KJDcUb > a > div.PpBGzd.YcUVQe.MUxGbd.v0nnCb > div")).click();
    driver.findElement(By.name("q")).sendKeys("mustafa kemal atatürk");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	driver.findElement(By.cssSelector("#topic > div.clearfix.sub-title-container > div.sub-title-menu > span > a:nth-child(1)")).click();
	
	Thread.sleep(10000);
	
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
	Thread.sleep(7000);
	
	driver.context("NATIVE_APP");
	
	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"));");
	driver.findElement(By.xpath("//android.widget.TextView[@text='Antarctica']")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("New Name");
	driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	driver.closeApp();
	
	
	

	}

}
