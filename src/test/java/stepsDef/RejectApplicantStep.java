package stepsDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

import base.LoginFunction;
import base.MainFunction;
import base.RejectApplicantFunction;

public class RejectApplicantStep {
	LoginFunction loginFunction = new LoginFunction();
	RejectApplicantFunction rejectEventFunction = new RejectApplicantFunction();
    MainFunction mainFunction = new MainFunction();
    
	@Given("User login and in the home screen")
	public void user_login_and_in_the_home_screen() throws InterruptedException {
		 loginFunction.verifyLoginPage();
         loginFunction.inputEmail("string@mail.com");
         loginFunction.inputPassword("Password!2");
         loginFunction.pressLogin();
         loginFunction.verifyHomePage();
	}

	@Given("User sort event based on Event Date \\(DESC)")
	public void user_sort_event_based_on_Event_Date_DESC() throws InterruptedException {
		rejectEventFunction.sortEventDesc();
	}

	@When("User click on button Reject")
	public void user_click_on_button_Reject() throws InterruptedException{
		rejectEventFunction.clickButtonReject();
	}

	@When("User confirm the rejection")
	public void user_confirm_the_rejection() throws InterruptedException {
		rejectEventFunction.confirmReject();

	}

	@Then("Applicant is rejected")
	public void applicant_is_rejected() throws InterruptedException, ClassNotFoundException, SQLException {
		rejectEventFunction.verifyReject();
	}
}
