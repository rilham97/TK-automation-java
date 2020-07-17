package stepsDef;

import base.LoginFunction;
import base.MainFunction;
import base.PopUpFunction;
import base.RegisterFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterEmailStep {	
	LoginFunction login = new LoginFunction();
	RegisterFunction register = new RegisterFunction();
	PopUpFunction popUp = new PopUpFunction();

	@Given("User has accessed Create Account page")
	public void user_has_accessed_Create_Account_page() {
		login.verifyLoginPage();
		register.clickCreateAcc();	
		register.verifyCreateAccountPage();
	}

	@When("User input valid Full Name with {string}")
	public void user_input_valid_Full_Name_with(String string) throws InterruptedException {
		register.inputFullname(string);
	}

	@When("Input date of birth")
	public void input_date_of_birth() {
		register.inputDob("1996");
	}

	@When("Choose {string} gender")
	public void choose_gender(String string) {
		register.inputGender(string);
	}

	@When("Input valid Email with {string}")
	public void input_valid_Email_with(String string) throws InterruptedException {
		register.inputEmail(string);
	}

	@When("Fill password form with {string}")
	public void fill_password_form_with(String string) throws InterruptedException {
		register.inputPass(string);
	}

	@When("Confirm password form with {string}")
	public void confirm_password_form_with(String string) throws InterruptedException {
		register.inputConfirmpass(string);
	}

	@When("Click T&C checkbox")
	public void click_T_C_checkbox() {
		register.clickTnc();
	}

	@When("Tap Create Account password")
	public void tap_Create_Account_password() {
		register.clickCreateAcc();
	}

	@When("Tap OK button")
	public void OK_button() {
		popUp.clickOk();
	}
	
	@Then("User should be directed to home screen using own email {string}")
	public void user_should_be_directed_to_home_screen_using_own_email(String email) {
	    login.verifyHomePage();
	    register.deleteUser(email);
	}

	@When("Skip fill the additional info form")
	public void skip_fill_the_additional_info_form() {
		register.clickSkip();
	}

	@Then("User should receive error message email on register screen")
	public void user_should_receive_error_message_email_on_register_screen() {
		register.warnEmailFormat();
	}

	@Then("User should receive error message password on register screen")
	public void user_should_receive_error_message_password_on_register_screen() {
		register.warnPassFormat();
	}
}
