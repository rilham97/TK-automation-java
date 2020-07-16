package stepsDef;

import java.sql.SQLException;

import base.CreatePassFunction;
import base.LoginFunction;
import base.PopUpFunction;
import base.RemoveUserFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatePassStep {
	LoginFunction loginFunction = new LoginFunction();
	RemoveUserFunction removeUserFunction = new RemoveUserFunction();
	CreatePassFunction createPassFunction = new CreatePassFunction();
	PopUpFunction popUpFunction = new PopUpFunction();
	String googleEmail;
	
	@Given("User already sign in using google account")
	public void user_already_sign_in_using_google_account() throws InterruptedException {
		googleEmail = loginFunction.pressGoogle();
		System.out.println(googleEmail);
		loginFunction.verifyHomePage();
	}

	@When("Tap My account button")
	public void tap_My_account_button() {
		removeUserFunction.clickMyAccount();
	}

	@When("Fill password form with {string} and confirm password form with {string}")
	public void fill_pasword_form_with_and_confirm_password_form_with(String password, String confirmPass) throws InterruptedException {
		createPassFunction.inputPass(password);
		createPassFunction.inputConfirmpass(confirmPass);
	}

	@When("Tap create password button")
	public void tap_create_password_button() {
		createPassFunction.clickCreatePassBtn();
	}

	@When("Tap Ok button on popup confirmation")
	public void tap_Ok_button_on_popup_confirmation() {
		popUpFunction.clickOk();
	}

	@Then("Success notification about password has created will be displayed")
	public void success_notification_about_password_has_created_will_be_displayed(){
		createPassFunction.successUpdatePasswordScreen();
		createPassFunction.resetGmailData(googleEmail);
	}
}
