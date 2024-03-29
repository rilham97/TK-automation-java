package stepsDef;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import base.LoginFunction;
import base.MainFunction;
import base.UpdateProfileFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateProfileStep {
	UpdateProfileFunction UpdateProfileFunction = new UpdateProfileFunction();
	LoginFunction login = new LoginFunction();

	String email;
	String password;
	
	@Given("User has access the home screen")
	public void user_has_access_the_home_screen(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
	    email = list.get(0).get("email");
	    password = list.get(0).get("password");
		login.verifyLoginPage();
	    login.inputEmail(email);
	    login.inputPassword(password);
	    login.pressLogin();
	}
	
	@When("Tab My Profile button")
	public void tab_My_Profile_button() {
		UpdateProfileFunction.clickMyProfile();
	}

	@When("Press Edit Profile button")
	public void press_Edit_Profile_button() {
		UpdateProfileFunction.clickEditProfile();
	}

	@When("Choose photo {string} from gallery")
	public void choose_photo_from_gallery(String pathFile) throws IOException, InterruptedException {
		UpdateProfileFunction.selectImage(pathFile);

	}

	@When("Fill {string} in form City")
	public void fill_in_form_City(String string) throws InterruptedException {
		UpdateProfileFunction.inputCity(string);
	}

	@When("Fill {string} in form About Me")
	public void fill_in_form_About_Me(String string) throws InterruptedException {
		UpdateProfileFunction.inputAboutMe(string);
	}

	@When("Fill {string} in form Interest")
	public void fill_in_form_Interest(String string) throws InterruptedException {
		UpdateProfileFunction.inputInterest(string);
	}

	@When("Click button save")
	public void click_button_save() {
		UpdateProfileFunction.clickSave();
	}

	@Then("User profile is changed")
	public void user_profile_is_changed() {
		UpdateProfileFunction.verifySnackBar();
		UpdateProfileFunction.verifyUpdate();
		UpdateProfileFunction.resetProfile(email,password);
	}
}
