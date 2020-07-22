package stepsDef;

import base.LoginFunction;
import base.MainFunction;
import base.NotifEventCreatorFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class NotifEventCreatorStep {
    LoginFunction loginFunction = new LoginFunction();
    NotifEventCreatorFunction notifEventCreatorFunction = new NotifEventCreatorFunction();
    MainFunction mainFunction = new MainFunction();

    String emailCreator;
    String passwordCreator;
   	String emailApplicant;
	String passwordApplicant;
	int eventIdApplied = 431;
	int eventIdCanceled = 432;

    @Given("Event Creator has access the home screen")
    public void event_Creator_has_access_the_home_screen(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        emailCreator = list.get(0).get("email");
        passwordCreator = list.get(0).get("password");
        loginFunction.verifyLoginPage();
        loginFunction.inputEmail(emailCreator);
        loginFunction.inputPassword(passwordCreator);
        loginFunction.pressLogin();
        notifEventCreatorFunction.verifyBeforeNotif();
    }

    @When("Other user apply to the event")
    public void other_user_apply_to_the_event(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        emailApplicant = list.get(0).get("email");
        passwordApplicant = list.get(0).get("password");
        
        //Reset the database first before accept using API
        notifEventCreatorFunction.resetToDelete(eventIdApplied,emailApplicant);
        //Send API to apply an event
    	notifEventCreatorFunction.applyEvent(emailApplicant, passwordApplicant, eventIdApplied);
    }

    @When("Event Creator click bell icon")
    public void event_Creator_click_bell_icon() {
    	notifEventCreatorFunction.clickBell();
    	notifEventCreatorFunction.verifyNotifPage();
    }

    @Then("Get notification for their created event if other user successfully applying to the event")
    public void get_notification_for_their_created_event_if_other_user_successfully_applying_to_the_event() {
    	notifEventCreatorFunction.verifyNotifApplied();
    }
    
    @Then("The number of notification icons will increasing")
    public void the_number_of_notification_icons_will_increasing() {
    	notifEventCreatorFunction.verifyAfterNotif();
    	notifEventCreatorFunction.checkIncreasing();
    }
    
    @When("Other user cancel application to the event")
    public void other_user_cancel_application_to_the_event(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        emailApplicant = list.get(0).get("email");
        passwordApplicant = list.get(0).get("password");
        
    	notifEventCreatorFunction.cancelApplicationEvent(emailApplicant,passwordApplicant, eventIdCanceled);
    }

    @Then("Get notification for their created event if other user successfully cancel application to the event")
    public void get_notification_for_their_created_event_if_other_user_successfully_cancel_application_to_the_event() {
    	notifEventCreatorFunction.verifyNotifCanceled();
    	notifEventCreatorFunction.resetToActive(eventIdCanceled, emailApplicant);
    }

    @When("The user minimize the application")
    public void the_user_minimize_the_application() {
        mainFunction.minimizeApplication();
        try {
            Thread.sleep(3000);                
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @When("Open notification tray from own device")
    public void open_notification_tray_from_own_device() {
        mainFunction.openNotifications();
    }

}