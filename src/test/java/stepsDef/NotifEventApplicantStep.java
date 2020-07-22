package stepsDef;

import base.LoginFunction;
import base.NotifEventApplicantFunction;
import base.NotifEventCreatorFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

public class NotifEventApplicantStep {
    LoginFunction loginFunction = new LoginFunction();
    NotifEventCreatorFunction notifEventCreatorFunction = new NotifEventCreatorFunction();
    NotifEventApplicantFunction notifEventApplicantFunction = new NotifEventApplicantFunction();

    String emailApplicant;
    String passwordApplicant;
    String emailCreator;
    String passwordCreator;
    int applicantId = 545;
    int eventId = 432;

    @Given("Applicant has access the home screen")
    public void applicant_has_access_the_home_screen(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        emailApplicant = list.get(0).get("email");
        passwordApplicant = list.get(0).get("password");
        loginFunction.verifyLoginPage();
        loginFunction.inputEmail(emailApplicant);
        loginFunction.inputPassword(passwordApplicant);
        loginFunction.pressLogin();
        notifEventCreatorFunction.verifyBeforeNotif();
    }

    @When("Event creator accept the application")
    public void event_creator_accept_the_application(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        emailCreator = list.get(0).get("email");
        passwordCreator = list.get(0).get("password");

        //Reset the database first before accept using API
        notifEventApplicantFunction.resetToApplied(applicantId);
        //Send API to accept
        notifEventApplicantFunction.acceptApplicant(emailCreator,passwordCreator,applicantId);
    }

    @When("Applicant click bell icon")
    public void applicant_click_bell_icon() {
        notifEventCreatorFunction.clickBell();
        notifEventCreatorFunction.verifyNotifPage();
    }

    @Then("Get notification for their applications if event creator successfully accept the application")
    public void get_notification_for_their_applications_if_event_creator_successfully_accept_the_application() {
        notifEventApplicantFunction.verifyNotifAccepted();
    }

    @When("Event creator cancel the acceptance")
    public void event_creator_cancel_the_acceptance(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        emailCreator = list.get(0).get("email");
        passwordCreator = list.get(0).get("password");
        
        //Reset the database first before cancel using API
        notifEventApplicantFunction.resetToAccepted(applicantId);
        //Send API to cancel
        notifEventApplicantFunction.cancelApplicant(emailCreator,passwordCreator,applicantId);
    }

    @Then("Get notification for their applications if event creator successfully cancel the acceptance")
    public void get_notification_for_their_applications_if_event_creator_successfully_cancel_the_acceptance() {
        notifEventApplicantFunction.verifyNotifCanceled();
    }

    @When("Event creator reject the application")
    public void event_creator_reject_the_application(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        emailCreator = list.get(0).get("email");
        passwordCreator = list.get(0).get("password");
        
        //Reset the database first before reject using API
        notifEventApplicantFunction.resetToApplied(applicantId);
        //Send API to reject
        notifEventApplicantFunction.rejectApplicant(emailCreator,passwordCreator,applicantId);
    }

    @Then("Get notification for their applications if event creator successfully reject the application")
    public void get_notification_for_their_applications_if_event_creator_successfully_reject_the_application() {
        notifEventApplicantFunction.verifyNotifRejected();
    }

    @When("Event creator cancel the event")
    public void event_creator_cancel_the_event(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        emailCreator = list.get(0).get("email");
        passwordCreator = list.get(0).get("password");
        
    	//Reset the database applicant to applied status first
    	notifEventApplicantFunction.resetToApplied(applicantId);
    	//Send API to cancel the event
        notifEventApplicantFunction.cancelEvent(emailCreator,passwordCreator,eventId);
        //Switch Reset DB for the last to prevent another scenario should still working
        notifEventApplicantFunction.resetCancelEvent(eventId);
    }

    @Then("Get notification for their applications if event creator successfully cancel the event")
    public void get_notification_for_their_applications_if_event_creator_successfully_cancel_the_event() {
        notifEventApplicantFunction.verifyNotifEventCanceled();
    }

    @When("Event creator edit the event")
    public void event_creator_edit_the_event(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        emailCreator = list.get(0).get("email");
        passwordCreator = list.get(0).get("password");
        //Send API to edit the event
        notifEventApplicantFunction.editEvent(emailCreator,passwordCreator,eventId);
    }

    @Then("Get notification for their applications if event creator successfully edit the event")
    public void get_notification_for_their_applications_if_event_creator_successfully_edit_the_event() {
        notifEventApplicantFunction.verifyNotifEdited();
    }
}