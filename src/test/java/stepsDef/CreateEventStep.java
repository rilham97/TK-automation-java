package stepsDef;

import base.CreateEventFunction;
import base.LoginFunction;
import base.MainFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateEventStep {
    LoginFunction loginFunction = new LoginFunction();
    CreateEventFunction createEventFunction = new CreateEventFunction();
    MainFunction mainFunction = new MainFunction();

    @Given("User already in the home screen")
    public void user_already_in_the_home_screen() throws InterruptedException {
        loginFunction.verifyLoginPage();
        loginFunction.inputEmail("ron@email.com");
        loginFunction.inputPassword("Ron@123!");
        loginFunction.pressLogin();
        loginFunction.verifyHomePage();
    }

    @When("User click on create event button icon")
    public void user_click_on_create_event_button_icon() throws InterruptedException {
        createEventFunction.clickCreateEventIcon();
    }

    @When("User input valid event title with {string}")
    public void user_input_valid_event_title_with(String userInput) throws InterruptedException {
        createEventFunction.inputTitle(userInput);
    }

    @When("User input valid city with {string}")
    public void user_input_valid_city_with(String userInput) throws InterruptedException {
        createEventFunction.inputCity(userInput);
        createEventFunction.selectCitySuggestion();
    }

    @When("User input valid event date")
    public void user_input_valid_event_date_with() throws InterruptedException {
        createEventFunction.inputEventDate();
    }

    @When("User input valid event start time")
    public void user_input_valid_event_start_time() {
        createEventFunction.inputStartTime();
    }

    @When("User input valid event end time")
    public void user_input_valid_event_end_time() {
        createEventFunction.inputEndTime();
    }

    @When("User set range age")
    public void user_set_range_age() throws InterruptedException {
        createEventFunction.setAge();
        mainFunction.scrollUntilFindText("CREATE EVENT");
    }

    @When("User set gender")
    public void user_set_gender() {
        createEventFunction.selectGender();
    }

    @When("User input valid additional info {string}")
    public void user_input_valid_additional_info(String userInput) throws InterruptedException {
        createEventFunction.inputAdditionalInfo(userInput);
    }

    @When("User click on button create event")
    public void user_click_on_button_create_event() {
        createEventFunction.clickCreateEventButton();
    }

    @Then("Event is created")
    public void event_is_created() {
        createEventFunction.verifyEventIsCreated();
    }

    @Then("User directed to home screen")
    public void user_directed_to_home_screen() {
        createEventFunction.verifyHomePage();
    }
}
