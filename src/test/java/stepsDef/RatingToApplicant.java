package stepsDef;

import base.CancelApplicationFunction;
import base.LoginFunction;
import base.RatingToApplicantFunction;
import base.RatingToEventCreatorFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

public class RatingToApplicant {
    LoginFunction loginFunction = new LoginFunction();
    RatingToEventCreatorFunction ratingToEventCreatorFunction = new RatingToEventCreatorFunction();
    CancelApplicationFunction cancelApplicationFunction = new CancelApplicationFunction();
    RatingToApplicantFunction ratingToApplicant = new RatingToApplicantFunction();

    @Given("user already in my event screen")
    public void user_already_in_my_event_screen() throws InterruptedException, SQLException, ClassNotFoundException {
        loginFunction.verifyLoginPage();
        loginFunction.inputEmail("filter2@email.com");
        loginFunction.inputPassword("Filter2!");
        loginFunction.pressLogin();
        loginFunction.verifyHomePage();

        ratingToEventCreatorFunction.setDateTo24HourAgoDB();
        cancelApplicationFunction.clickHamburgerButton();
        ratingToApplicant.clickMyEventMenu();
    }

    @When("user click on past tab at my event screen")
    public void user_click_on_past_tab_at_my_event_screen() {
        ratingToApplicant.clickPastTab();
    }

    @When("user click on the event box")
    public void user_click_on_the_event_box() {
        ratingToApplicant.clickEventBox();
    }

    @When("click on rate user button")
    public void click_on_rate_user_button() {
        ratingToApplicant.clickRateUserButton();
    }

    @When("click on one of the stars")
    public void click_on_one_of_the_stars() {
        ratingToApplicant.clickStar();
    }

    @When("user click on submit button")
    public void user_click_on_submit_button() {
        ratingToApplicant.clickSubmit();
    }

    @When("user click on rated button")
    public void user_click_on_rated_button() {
        ratingToApplicant.clickRated();
    }

    @Then("message user successfully give a rating will be display")
    public void message_user_successfully_give_a_rating_will_be_display() throws SQLException, ClassNotFoundException {
        ratingToApplicant.checkSuccessfullyRatingAtTheWidgetRating();
        ratingToApplicant.deleteRatingFromDB();
    }
}
