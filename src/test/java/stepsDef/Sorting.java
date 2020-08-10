package stepsDef;

import base.CancelApplicationFunction;
import base.LoginFunction;
import base.SortingFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Sorting {
    LoginFunction loginFunction = new LoginFunction();
    SortingFunction sortingFunction = new SortingFunction();
    CancelApplicationFunction cancelApplicationFunction = new CancelApplicationFunction();

    @Given("user in the home screen")
    public void user_in_the_home_screen() throws InterruptedException {
        loginFunction.verifyLoginPage();
        loginFunction.inputEmail("filter1@email.com");
        loginFunction.inputPassword("Filter1!");
        loginFunction.pressLogin();
        loginFunction.verifyHomePage();
    }

    @When("click on hamburger menu")
    public void click_on_burger_menu() {
        cancelApplicationFunction.clickHamburgerButton();
    }

    @When("click on my event")
    public void click_on_my_event() {
        cancelApplicationFunction.clickAppliedEvents();
    }

    @When("click on sorting icon")
    public void click_on_sorting_icon() {
        sortingFunction.clickSortingMenu();
    }

    @When("click on {string} function")
    public void click_on_function(String inputUser) {
        sortingFunction.clickSortingFunction(inputUser);
    }

    @Then("user successfully {string} the event")
    public void user_successfully_sort_the_event(String inputUser) {
        sortingFunction.compareData(inputUser);
    }

}
