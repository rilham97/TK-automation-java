package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utilities.PropertiesReader;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseDriver {
	public static AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	
	public void setUp() {	
		System.out.println("Turn On the driver");
		DesiredCapabilities caps = new DesiredCapabilities();
		if(PropertiesReader.readProperty("deviceName") != null) {
			caps.setCapability("deviceName", PropertiesReader.readProperty("deviceName"));
		}
		if(PropertiesReader.readProperty("deviceid") != null) {
			caps.setCapability("deviceid", PropertiesReader.readProperty("deviceId")); //DeviceId from "adb devices" command
		}
		if(PropertiesReader.readProperty("udid") != null) {
			caps.setCapability("udid", PropertiesReader.readProperty("udid"));
		}
		if(PropertiesReader.readProperty("deviceid") != null) {
			caps.setCapability("platformName", PropertiesReader.readProperty("platformName"));
		}
		if(PropertiesReader.readProperty("platformVersion") != null) {
			caps.setCapability("platformVersion", PropertiesReader.readProperty("platformVersion"));
		}
		if(PropertiesReader.readProperty("automationName") != null) {
			caps.setCapability("automationName", PropertiesReader.readProperty("automationName"));
		}
		caps.setCapability("appPackage", PropertiesReader.readProperty("appPackage"));
		caps.setCapability("appActivity",PropertiesReader.readProperty("appActivity"));
		caps.setCapability("noReset",false);
		caps.setCapability("skipUnlock",true);
		//grant access gallery
		caps.setCapability("autoGrantPermissions", true);
		//disable keyboard
		caps.setCapability("unicodeKeyboard", false);
		caps.setCapability("resetKeyboard", false);
		//set driver
		try {
			driver = new AndroidDriver<MobileElement>(new URL(PropertiesReader.readProperty("appiumService")),caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void tearDown() {
		System.out.println("Turn Off the driver");
		if (driver != null) {
			driver.quit();
		}
	}

}
