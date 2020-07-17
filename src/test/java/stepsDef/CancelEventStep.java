package stepsDef;

import java.sql.SQLException;

import base.CancelEventFunction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBCall;

public class CancelEventStep {
	CancelEventFunction createEventFunction = new CancelEventFunction();
	String sqlQuery = "UPDATE event SET cancelled = 'false' WHERE event_id= 327;";

	
	
	
	@When("User click on button Cancel")
	public void user_click_on_button_Cancel() throws InterruptedException {
		DBCall.executeSQLQuery(sqlQuery);
		createEventFunction.clickButtonCancel();
	}

	@When("User confirm the Cancelation")
	public void user_confirm_the_Cancelation() throws InterruptedException {
		createEventFunction.confirmCancel();
;
	}

	@Then("Event canceled")
	public void event_canceled() throws InterruptedException, ClassNotFoundException, SQLException {
		createEventFunction.verifyCancel();
	}
}
