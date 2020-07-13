package stepsDef;

import base.ApplyEventFunction;
import base.LoginFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.sql.SQLException;


public class ApplyEventStep {
    LoginFunction loginFunction = new LoginFunction();
    ApplyEventFunction applyEventFunction = new ApplyEventFunction();

    @Given("User in the home screens")
    public void user_in_the_home_screens() throws InterruptedException {
        loginFunction.verifyLoginPage();
        loginFunction.inputEmail("apply@gmail.com");
        loginFunction.inputPassword("Apply1!");
        loginFunction.pressLogin();
        loginFunction.verifyHomePage();
    }

    @When("User click on search icon")
    public void user_click_on_search_icon() {
        applyEventFunction.clickSearchIcon();
    }

    @When("User click on an event box")
    public void user_click_on_an_event_box() {
        applyEventFunction.clickEventBox();
    }

    @When("User click on apply to event button")
    public void user_click_on_apply_to_event_button() {
        applyEventFunction.clickApplyToEventBtn();
    }

    @When("User click on button ok at the popup confirmation")
    public void user_click_on_button_ok_at_the_popup_confirmation() {
        applyEventFunction.clickOkBtn();
    }

    @Then("User successfully apply to event")
    public void user_successfully_apply_to_event() throws SQLException, ClassNotFoundException {
        applyEventFunction.verifySuccessApplyMessage();
        applyEventFunction.setDataStateApplicantsToDeleted();
    }

}
