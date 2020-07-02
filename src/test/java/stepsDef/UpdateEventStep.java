package stepsDef;

import base.UpdateEventFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import base.LoginFunction;
import base.MainFunction;

public class UpdateEventStep {
	LoginFunction loginFunction = new LoginFunction();
    UpdateEventFunction updateEventFunction = new UpdateEventFunction();
    MainFunction mainFunction = new MainFunction();
    
    @Given("User already login and in the home screen")
    public void user_already_login_and_in_the_home_screen() throws InterruptedException {
    	 loginFunction.verifyLoginPage();
         loginFunction.inputEmail("string@mail.com");
         loginFunction.inputPassword("Password!2");
         loginFunction.pressLogin();
         loginFunction.verifyHomePage();
    }

    @Given("User go to My Event Screen")
    public void user_go_to_My_Event_Screen() throws InterruptedException {
        updateEventFunction.goToMyEvent();
    }

    @When("User click on the first event")
    public void user_click_on_the_first_event() throws InterruptedException {
    	updateEventFunction.clickFirstEvent();
    }

    @When("User click on button Edit")
    public void user_click_on_button_Edit() throws InterruptedException {
        mainFunction.scrollUntilFindText("EDIT");
        updateEventFunction.clickButtonEdit();
    }

    @When("User edit city")
    public void user_edit_city() throws InterruptedException {
    	updateEventFunction.editEventCity();
    }
    
    @When("User edit event title")
    public void user_edit_event_title() throws InterruptedException {
    	updateEventFunction.editEventTitle();
    }

    @When("User edit event date")
    public void user_edit_event_date() throws InterruptedException {
    	updateEventFunction.editEventDate();
    }

    @When("User edit event start time")
    public void user_edit_event_start_time() throws InterruptedException {
    	updateEventFunction.editStartTime();
    }

    @When("User edit event end time")
    public void user_edit_event_end_time() throws InterruptedException {
    	updateEventFunction.editEndTime();
    }

    @When("User edit range age")
    public void user_edit_range_age() throws InterruptedException {
    	updateEventFunction.editRangeAge();
        mainFunction.scrollUntilFindText("SAVE");

    }

    @When("User edit gender")
    public void user_edit_gender() throws InterruptedException {
    	updateEventFunction.editGender();
    }

    @When("User edit additional info")
    public void user_edit_additional_info() throws InterruptedException {
    	updateEventFunction.editAdditionalInfo();

    }

    @When("User click on button Save")
    public void user_click_on_button_Save() throws InterruptedException {
    	updateEventFunction.clickButtonSave();
    }

    @Then("Event is updated")
    public void event_is_updated() throws InterruptedException {
    	updateEventFunction.eventUpdated();
    }

    @Then("check the updated data")
    public void check_the_updated_data() throws InterruptedException {
        mainFunction.scrollUntilFindText("EDIT");
    	updateEventFunction.checkUpdatedData();

    }

}
