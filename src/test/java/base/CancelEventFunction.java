package base;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DBCall;

public class CancelEventFunction extends BaseDriver {
	
	MainFunction mainFunc = new MainFunction();
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 10000);
	Statement stmt = null;
	
	String Cancel = "//*[@text='CANCEL EVENT']";
	String Yes="//*[@text='Yes']"; 
	String ConfirmPopup="//*[@text='Are you sure you want to cancel this event? You cannot undo this action']";
	String SuccessCancel="//*[@text='You have successfully cancel your event']"; 
	String Canceled="//*[contains(@text,'You have canceled this event')]";
	String sqlQuery = "UPDATE event SET cancelled = 'false' WHERE event_id= 327;";


	
	
	public void clickButtonCancel() throws InterruptedException {
		mainFunc.scrollUntilFindText("CANCEL EVENT");
		mainFunc.click(Cancel);
		}
	
	public void confirmCancel() throws InterruptedException {
		mainFunc.waitElement(ConfirmPopup);
		mainFunc.click(Yes);
		}
	
	
	public void verifyCancel() throws InterruptedException, ClassNotFoundException, SQLException {
		mainFunc.waitElement(SuccessCancel);
		mainFunc.waitElement(Canceled);
		DBCall.executeSQLQuery(sqlQuery);
		}
}
