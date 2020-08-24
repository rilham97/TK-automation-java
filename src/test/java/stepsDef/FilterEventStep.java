package stepsDef;

import java.text.ParseException;

import base.FilterEventFunction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterEventStep {
    FilterEventFunction filterEventFunction = new FilterEventFunction();
    @When("User click magnifying glass icon")
    public void user_click_magnifying_glass_icon() throws ParseException {
    	filterEventFunction.clickSearchBtn();
        filterEventFunction.verifySearchEventScreen();
    }

    @When("User click filter button")
    public void user_click_filter_button() {
        filterEventFunction.clickFilterButton();
        filterEventFunction.verifyFilterScreen();
    }

    @When("User set the range age")
    public void user_set_the_range_age() {
        filterEventFunction.setRangeAge();
    }

    @When("User select the creator gender with {string}")
    public void user_select_the_creator_gender_with(String gender) {
    	filterEventFunction.clickGender(gender);
    }

    @When("User select the start date")
    public void user_select_the_start_date() throws ParseException, InterruptedException {
    	filterEventFunction.selectStartDate("10/04/2021");
    }

    @When("User select the end date")
    public void user_select_the_end_date() throws ParseException, InterruptedException {
    	filterEventFunction.selectEndDate("10/04/2022");
    }

    @When("User select the start time")
    public void user_select_the_start_time() {
    	filterEventFunction.selectStartTime();
    }

    @When("User select the end time")
    public void user_select_the_end_time() {
    	filterEventFunction.selectEndTime();
    }

    @When("User input the city with {string}")
    public void user_input_the_city_with(String cityName) throws InterruptedException {
    	filterEventFunction.inputCity(cityName);
    }

    @When("User tap apply button")
    public void user_tap_apply_button() {
    	filterEventFunction.clickApply();
    }

    @Then("Sorting menu popup will be disappeared")
    public void sorting_menu_popup_will_be_disappeared() {
    	filterEventFunction.verifySearchEventScreen();
    }

    @Then("Filtered event with city {string} will be displayed")
    public void filtered_event_will_be_displayed(String cityName) {
    	filterEventFunction.verifyEvent(cityName);
    }
}
