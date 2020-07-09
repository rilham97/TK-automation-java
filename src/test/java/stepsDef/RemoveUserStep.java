package stepsDef;

import base.LoginFunction;
import base.RemoveUserFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

public class RemoveUserStep {
    LoginFunction loginFunction = new LoginFunction();
    RemoveUserFunction removeUserFunction = new RemoveUserFunction();

    @Given("User in the home screen")
    public void user_in_the_home_screen() throws InterruptedException {
        loginFunction.verifyLoginPage();
        loginFunction.inputEmail("remove@gmail.com");
        loginFunction.inputPassword("R3move!");
        loginFunction.pressLogin();
        loginFunction.verifyHomePage();
    }

    @When("User click hamburger button")
    public void user_click_hamburger_button() {
       removeUserFunction.clickHamburgerButton();
    }

    @When("User click on my account menu")
    public void user_click_on_my_account_menu() {
        removeUserFunction.clickMyAccount();
    }

    @When("Click on delete account")
    public void click_on_delete_account() {
        removeUserFunction.clickDeleteAccount();
    }

    @When("Click on continue button from the popup confirmation")
    public void click_on_continue_button_from_the_popup_confirmation() {
        removeUserFunction.clickContinue();
    }

    @Then("User directed to login screen")
    public void user_directed_to_login_screen() {
        removeUserFunction.verifyLoginScreen();
    }

    @Then("User can't login with the account that already removed")
    public void user_can_t_login_with_the_account_that_already_removed() throws InterruptedException, SQLException, ClassNotFoundException {
        loginFunction.verifyLoginPage();
        loginFunction.inputEmail("remove@gmail.com");
        loginFunction.inputPassword("R3move!");
        loginFunction.pressLogin();
        removeUserFunction.checkIncorrectEmailPassword();
        removeUserFunction.setActiveDeletedUser();
    }

}
