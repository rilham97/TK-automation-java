package stepsDef;

import base.LoginFunction;
import base.LogoutFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStep {
    LoginFunction loginFunction = new LoginFunction();
    LogoutFunction logoutFunction = new LogoutFunction();

    @Given("user already in the home screen")
    public void user_already_in_the_home_screen() throws InterruptedException {
        loginFunction.verifyLoginPage();
        loginFunction.inputEmail("ron@email.com");
        loginFunction.inputPassword("Ron@123!");
        loginFunction.pressLogin();
        loginFunction.verifyHomePage();
    }

    @When("user click drawer button")
    public void user_click_drawer_button() throws InterruptedException {
        logoutFunction.clickDrawerMenu();
    }

    @When("user click logout button")
    public void user_click_logout_button() {
        logoutFunction.clickLogout();
    }

    @When("user click yes on pop up confirmation")
    public void user_click_yes_on_pop_up_confirmation() {
        logoutFunction.clickYesOnPopupConfirmation();
    }

    @Then("user back to login page")
    public void user_back_to_login_page() {
        loginFunction.verifyLoginPage();
    }
    //logout
}
