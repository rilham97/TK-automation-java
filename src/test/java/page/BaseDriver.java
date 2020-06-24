package page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseDriver {
  public static AndroidDriver<MobileElement> driver;
  public WebDriverWait wait;

  public void setUp() {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "MI 8 SE");
		caps.setCapability("deviceid", "ccbcab1"); //DeviceId from "adb devices" command
//		caps.setCapability("udid", "emulator-5554");
		
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10.0");
		caps.setCapability("skipUnlock",true);
		caps.setCapability("appPackage", "com.mitrais.teman_kondangan");
		caps.setCapability("appActivity","com.mitrais.teman_kondangan.MainActivity");
		caps.setCapability("noReset",false);

		//grant access gallery
		caps.setCapability("autoGrantPermissions", true);
		//disable keyboard
		caps.setCapability("unicodeKeyboard", false);
		caps.setCapability("resetKeyboard", false);

		//set driver
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

}
