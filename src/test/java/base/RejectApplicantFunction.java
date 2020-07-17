package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.DBCall;

public class RejectApplicantFunction extends BaseDriver{
	MainFunction mainFunc = new MainFunction();
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 10000);
//	Connection con;
	Statement stmt = null;
	//	public ResultSet resultSet = null;

	    

		String Filter="//*[@text='filter']"; 
		String DESC="//*[@text='Date of event (DESC)']"; 
		String Reject="//*[@text='Reject']"; 
		String Accept="//*[(@text='Accept') and (@clickable='false')]"; 

		String RejectPopup="//*[@text='Are you sure you want to reject this user? You cannot accept this user after you reject them.']"; 
		String Yes="//*[@text='Yes']"; 
		String sqlQuery = "UPDATE applicants SET status = 'APPLIED' WHERE id= 282;";

		
		public void sortEventDesc() throws InterruptedException {
			DBCall.executeSQLQuery(sqlQuery);
			mainFunc.click(Filter);
			mainFunc.click(DESC);
			}
		
		public void clickButtonReject() throws InterruptedException {
			mainFunc.scrollUntilFindText("EDIT");
			mainFunc.click(Reject);
			}
		
		public void confirmReject() throws InterruptedException {
			mainFunc.waitElement(RejectPopup);
			mainFunc.click(Yes);
			}
		
		public void verifyReject() throws InterruptedException, ClassNotFoundException, SQLException {
			mainFunc.waitElement(Accept);
			DBCall.executeSQLQuery(sqlQuery);
			}
}

