package stepsDef;

import base.CancelApplicationFunction;
import base.FilterMyAppliedEventFunction;
import base.LoginFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterAppliedEventStep {
    LoginFunction loginFunction = new LoginFunction();
    CancelApplicationFunction cancelApplicationFunction = new CancelApplicationFunction();
    FilterMyAppliedEventFunction filterMyAppliedEventFunction = new FilterMyAppliedEventFunction();

    @Given("user already in the my applied event screen")
    public void user_already_in_the_my_applied_event_screen() throws InterruptedException {
        loginFunction.verifyLoginPage();
        loginFunction.inputEmail("filter2@email.com");
        loginFunction.inputPassword("Filter2!");
        loginFunction.pressLogin();
        loginFunction.verifyHomePage();

        cancelApplicationFunction.clickHamburgerButton();
        cancelApplicationFunction.clickAppliedEvents();
    }

    @When("user click on filter icon")
    public void user_click_on_filter_icon() {
        filterMyAppliedEventFunction.clickFilterIcon();
    }

    @When("user click on past tab")
    public void user_click_on_past_tab() {
        filterMyAppliedEventFunction.clickPastTab();
    }

    @When("click on one of {string} filter")
    public void click_on_one_of_filter(String inputUser) {
        filterMyAppliedEventFunction.clickFilterMethod(inputUser);
    }

    @Then("application will display only events with {string} status")
    public void application_will_display_only_events_with_status(String inputUser) {
        filterMyAppliedEventFunction.verifyEventBoxStatus(inputUser);
    }
}
