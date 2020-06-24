package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.BaseDriver;
import page.LoginPage;

public class LoginEmailTest {
	BaseDriver driver = new BaseDriver();
	LoginPage login = new LoginPage();
	
	@Given("User has accessed Login page")
	public void user_has_accessed_Login_page() {
		driver.setUp();
		login.verify_loginPage(); 
	}

	@When("User input valid email with {string}")
	public void user_input_valid_email_with(String string) {
	    login.input_email(string);

	}

	@And("User input valid password with {string}")
	public void user_input_valid_password_with(String string) {
	    login.input_password(string);
	}
	
	@When("User fill email form with {string}")
	public void user_fill_email_form_with(String string) {
	    login.input_email(string);

	}

	@And("User fill password form with {string}")
	public void user_fill_password_form_with(String string) {
		login.input_password(string);

	}


	@And("User click on Login button")
	public void user_click_on_Login_button() {
	    login.press_login();

	}

	@Then("User should be directed to home screen")
	public void user_should_be_directed_to_home_screen() {
	    login.verify_homePage();

	}

	@And("Welcome message will be shown")
	public void welcome_message_will_be_shown() {
	    login.welcome();

	}

	@Then("User should failed to home screen")
	public void user_should_failed_to_home_screen() {
		login.verify_loginPage();

	}

	@And("User should recieve error message {string} on login screen")
	public void user_should_recieve_error_message_on_login_screen(String string) {
	    login.warning_message(string);

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
