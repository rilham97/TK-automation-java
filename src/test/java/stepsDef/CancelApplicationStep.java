package stepsDef;

import base.CancelApplicationFunction;
import base.LoginFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

public class CancelApplicationStep {
    LoginFunction loginFunction = new LoginFunction();
    CancelApplicationFunction cancelApplicationFunction = new CancelApplicationFunction();

    @Given("User login and already in the home screen")
    public void user_login_and_already_in_the_home_screen() throws InterruptedException, SQLException, ClassNotFoundException {
        loginFunction.verifyLoginPage();
        loginFunction.inputEmail("apply@gmail.com");
        loginFunction.inputPassword("Apply1!");
        loginFunction.pressLogin();
        loginFunction.verifyHomePage();
        cancelApplicationFunction.setDataStateApplicantsToActiveApplied();
    }

    @When("User click on hamburger button")
    public void user_click_on_hamburger_button() {
        cancelApplicationFunction.clickHamburgerButton();
    }

    @When("User click on applied events")
    public void user_click_on_applied_events() {
        cancelApplicationFunction.clickAppliedEvents();
    }

    @When("User click an event box")
    public void user_click_an_event_box() {
        cancelApplicationFunction.clickEventBox();
    }

    @When("User cancel application")
    public void user_cancel_application() {
        cancelApplicationFunction.clickCancelApplication();
    }

    @When("User confirm the cancel application")
    public void user_confirm_the_cancel_application() {
        cancelApplicationFunction.clickOkBtn();
    }

    @Then("User successfully cancel the application")
    public void user_successfully_cancel_the_application() {
        cancelApplicationFunction.verifyCanceledApplicationMessage();
    }
}
