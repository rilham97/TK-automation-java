package stepsDef;

import base.LoginFunction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginEmailStep {
	LoginFunction login = new LoginFunction();
	
	@Given("User has accessed Login page")
	public void user_has_accessed_Login_page() {
		login.verifyLoginPage(); 
	}

	@When("User input valid email with {string}")
	public void user_input_valid_email_with(String string) throws InterruptedException {
	    login.inputEmail(string);

	}

	@And("User input valid password with {string}")
	public void user_input_valid_password_with(String string) throws InterruptedException {
	    login.inputPassword(string);
	}
	
	@When("User fill email form with {string}")
	public void user_fill_email_form_with(String string) throws InterruptedException {
	    login.inputEmail(string);

	}

	@And("User fill password form with {string}")
	public void user_fill_password_form_with(String string) throws InterruptedException {
		login.inputPassword(string);

	}


	@And("User click on Login button")
	public void user_click_on_Login_button() {
	    login.pressLogin();

	}

	@Then("User should be directed to home screen")
	public void user_should_be_directed_to_home_screen() {
	    login.verifyHomePage();

	}

	@And("Welcome message will be shown")
	public void welcomeMessage_will_be_shown() {
	    login.welcome();

	}

	@Then("User should failed to home screen")
	public void user_should_failed_to_home_screen() {
		login.verifyLoginPage();

	}

	@And("User should recieve error message {string} on login screen")
	public void user_should_recieve_error_message_on_login_screen(String string) {
	    login.warningMessage(string);

	}
	
	@When("Set the internet connection on the user's device to be disconnected")
	public void set_the_internet_connection_on_the_user_s_device_to_be_disconnected() {
	    System.out.println("Still Progress");

	}

	@Then("Popup notification about internet connection is disconnected will be displayed")
	public void notification_about_internet_connection_is_disconnected_will_be_displayed() {
		System.out.println("Still Progress");

	}

}
