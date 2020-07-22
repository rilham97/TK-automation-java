package base;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import utilities.APIcall;
import utilities.DBCall;

import java.util.concurrent.TimeUnit;

public class NotifEventCreatorFunction extends BaseDriver {
	MainFunction mainFunction = new MainFunction();

	static String bellIcon = "//android.view.View[3]/android.view.View[3]";
	String noitfTitle = "//*[@text='Notification']";
	String markAsReadBtn = "//*[@text='Mark All As Read']";
	String notifApplied = "//*[contains(@text,'Someone applied to your event') and (@index =0)]";
	String notifCanceled = "//*[contains(@text,'Someone cancel application to your event') and (@index =0)]";
	int numberBell1 = 0;
	int numberBell2 = 0 ;

	public void clickBell() {
		mainFunction.click(bellIcon);
	}

	public void verifyNotifPage() {
		mainFunction.verifyEl(noitfTitle);
		mainFunction.verifyEl(markAsReadBtn);
	}

	public void verifyNotifApplied() {
		mainFunction.verifyEl(notifApplied);
		mainFunction.click(notifApplied);
	}
	
	public void verifyNotifCanceled() {
		mainFunction.verifyEl(notifCanceled);
		mainFunction.click(notifCanceled);
	}

	public void verifyBeforeNotif() {
		//Get the string
		String bell = driver.findElementByXPath(bellIcon).getText();
		//Parse the first string before \n
		bell = bell.substring(0, bell.indexOf("\n"));
		//if not have number then number = 0
		if (bell.equals("Notification")) {
			bell = "0";
		}
		//if have comma then get the value of number
		numberBell1 = Integer.parseInt(bell);
	}

	public void verifyAfterNotif() {
		//Get the string
		String bell = driver.findElementByXPath(bellIcon).getText();
		//Parse the first string before \n
		bell = bell.substring(0, bell.indexOf("\n"));
		//if not have number then number = 0
		if (bell.equals("Notification")) {
			bell = "0";
		}
		//if have comma then get the value of number
		numberBell2 = Integer.parseInt(bell);
	}  

	public void applyEvent(String email, String password, int eventId) {
		APIcall.login(email,password);
		APIcall.applyEvent(eventId);
	}
	
	public void cancelApplicationEvent(String email, String password, int eventId) {
		APIcall.login(email,password);
		APIcall.cancelApplicationEvent(eventId);
	}

	public void checkIncreasing() {
		try {
			assertTrue(numberBell2>numberBell1);}
		catch (AssertionError e) {
			System.out.println("Notification isn't increasing");
		}
	}

	public void resetApply(int event_id, String email) {
		String sqlQuery = "UPDATE applicants SET data_state = 'DELETED' WHERE data_state = 'ACTIVE' and event_id = "+event_id+" and created_by = '"+email+"';";
		DBCall.executeSQLQuery(sqlQuery);
	}
	
	public void resetCancelApplication(int event_id, String email) {
		String sqlQuery = "UPDATE applicants SET data_state = 'ACTIVE' WHERE data_state = 'DELETED' and event_id = "+event_id+" and created_by = '"+email+"';";
		DBCall.executeSQLQuery(sqlQuery);
	}

}
