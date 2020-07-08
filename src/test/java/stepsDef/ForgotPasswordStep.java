package stepsDef;

import base.ForgotPasswordFunction;
import base.LoginFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordStep {
    LoginFunction loginFunction = new LoginFunction();
    ForgotPasswordFunction forgotPasswordFunction = new ForgotPasswordFunction();

    @Given("User in the login page")
    public void user_in_the_login_page() {
        loginFunction.verifyLoginPage();
    }

    @When("User click on forgot password button")
    public void user_click_on_forgot_password_button() {
        forgotPasswordFunction.clickForgotPassword();
    }

    @When("User input registered {string} address")
    public void user_input_registered_address(String email) throws InterruptedException {
        forgotPasswordFunction.inputEmail(email);
    }

    @When("User click on send button")
    public void user_click_on_send_button() {
        forgotPasswordFunction.clickSend();
        forgotPasswordFunction.clickOkOnPopUpInfo();
    }

    @When("User input verification code with {string}")
    public void user_input_verification_code_with(String verificationCode) throws InterruptedException {
        forgotPasswordFunction.inputVerificationCode(verificationCode);
    }

    @When("User input new password with {string}")
    public void user_input_new_password_with(String newPassword) throws InterruptedException {
        forgotPasswordFunction.inputNewPassword(newPassword);
    }

    @When("User input confirm password with {string}")
    public void user_input_confirm_password_with(String confirmPassword) throws InterruptedException {
        forgotPasswordFunction.inputConfirmPassword(confirmPassword);
    }

    @When("User click on reset password")
    public void user_click_on_reset_password() {
        forgotPasswordFunction.clickResetPasswordBtn();
        forgotPasswordFunction.clickOkOnPopUpInfo();
    }

    @Then("User successfully reset the password")
    public void user_successfully_reset_the_password() {
        loginFunction.verifyLoginPage();
    }

    @Then("User successfully login with {string} and {string}")
    public void user_successfully_login_with_and(String email, String newPassword) throws InterruptedException {
        loginFunction.inputEmail(email);
        loginFunction.inputPassword(newPassword);
        loginFunction.pressLogin();
        loginFunction.verifyHomePage();
    }

}
