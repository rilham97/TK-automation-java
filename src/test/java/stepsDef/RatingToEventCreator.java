package stepsDef;

import base.CancelApplicationFunction;
import base.LoginFunction;
import base.RatingToEventCreatorFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

public class RatingToEventCreator {
    LoginFunction loginFunction = new LoginFunction();
    CancelApplicationFunction cancelApplicationFunction = new CancelApplicationFunction();
    RatingToEventCreatorFunction ratingToEventCreatorFunction = new RatingToEventCreatorFunction();

    @Given("User already in the applied screen")
    public void user_already_in_the_applied_screen() throws InterruptedException, SQLException, ClassNotFoundException {
        loginFunction.verifyLoginPage();
        loginFunction.inputEmail("filter1@email.com");
        loginFunction.inputPassword("Filter1!");
        loginFunction.pressLogin();
        loginFunction.verifyHomePage();
        ratingToEventCreatorFunction.setDateTo24HourAgoDB();

        cancelApplicationFunction.clickHamburgerButton();
        cancelApplicationFunction.clickAppliedEvents();
    }

    @When("click on past tab")
    public void click_on_past_tab() {
        ratingToEventCreatorFunction.clickPastTab();
    }

    @When("select the event box")
    public void select_the_event_box() {
        ratingToEventCreatorFunction.clickEventBox();
    }

    @When("click on button rate user")
    public void click_on_button_rate_user() {
        ratingToEventCreatorFunction.clickRateUserButton();
    }

    @When("click on one of the star")
    public void click_on_one_of_the_star() {
        ratingToEventCreatorFunction.clickStar();
    }

    @When("click on button submit")
    public void click_on_button_submit() {
        ratingToEventCreatorFunction.clickSubmit();
    }

    @Then("user successfully give rating to event creator")
    public void user_successfully_give_rating_to_event_creator() {
        ratingToEventCreatorFunction.checkLabelSuccessfullyRatingAtDetailEvent();
    }

    @Then("click on see rating from you")
    public void click_on_see_rating_from_you() throws SQLException, ClassNotFoundException {
        ratingToEventCreatorFunction.clickSeeRatingFromYou();
        ratingToEventCreatorFunction.checkSuccessfullyRatingAtTheWidgetRating();
        ratingToEventCreatorFunction.deleteRatingFromDB();
    }

}
