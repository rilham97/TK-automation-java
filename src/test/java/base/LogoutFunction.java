package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class LogoutFunction extends BaseDriver {

	MainFunction mainFunc = new MainFunction();
	String logoutBtn = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]";
	String yesConfirmation = "//*[@text='Yes']";

	public void clickDrawerMenu() throws InterruptedException {
		MobileElement buttonDrawer = driver.findElement(By.xpath("//*[@text='Open navigation menu']"));
		buttonDrawer.click();
		Thread.sleep(3000);
	}

	public void clickLogout(){
		mainFunc.click(logoutBtn);
	}

	public void clickYesOnPopupConfirmation(){
		mainFunc.click(yesConfirmation);
	}

}
