package base;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class MainFunction extends BaseDriver {
	BaseDriver base = new BaseDriver();	

	public void verifyEl(String element) {
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElementByXPath(element);
		}catch (NoSuchElementException e) {
			Assert.fail("Element "+element+" is not found");
		}
		Assert.assertTrue((driver.findElementByXPath(element)).isDisplayed());
	}

	public void assertText(String element, String text) {
		MobileElement form = (MobileElement) driver.findElementByXPath(element);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(form.getText().contains(text)); 
	}

	public void input(String element, String text) throws InterruptedException {
		Actions action = new Actions(driver);
		MobileElement form = (MobileElement) driver.findElementByXPath(element);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		form.click();
		Thread.sleep(1000);


		//mengecek sampai keyboard-nya ada
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.isKeyboardShown();
		action.sendKeys(text).perform();
		driver.hideKeyboard();
		//Assert.assertTrue(form.getText().contains(key)); 
	}

	public void click(String element) {
		try {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			MobileElement btn = (MobileElement) driver.findElementByXPath(element);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if(btn.isEnabled()) {
				btn.click();
			}			
		}
		catch (NoSuchElementException  e) {
			System.out.println("Error on Page: button cannot clicked");
		}
	}

	public void clear(String element) {
		Actions act = new Actions(driver);
		//Press long
		MobileElement form = driver.findElementByXPath(element);
		new TouchAction(driver).longPress(longPressOptions().withElement(element(form)).withDuration(Duration.ofMillis(1000))).release().perform();

		//Choose select all
		String select_all = "//*[@text='SELECT ALL']";
		click(select_all);
		act.sendKeys(Keys.DELETE).perform();
	}

	public void scrollTo(String text) {
		try {
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
		} catch (Exception e) {
			System.out.println("We got an error scrolling!");
		}
	}

	public void pushFile(String pathFile) throws IOException {
		driver.pushFile("/storage/emulated/0/download/image_automation.jpg", new File(pathFile));
	}

}