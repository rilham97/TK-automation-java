package stepsDef;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import base.LoginFunction;
import base.MainFunction;
import base.UpdateProfileFunction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import base.ImageResizeFunction;

public class ImageResize {
	UpdateProfileFunction UpdateProfileFunction = new UpdateProfileFunction();
	ImageResizeFunction ImageResizeFunction = new ImageResizeFunction();
	String email= "string@mail.com";
	String password= "Password!2";
	


	@Then("Change success")
	public void change_success() {
		UpdateProfileFunction.verifySnackBar();
	}
	
	@Then("Check photo size")
	public void check_photo_size() throws ClassNotFoundException, MalformedURLException, SQLException {
		ImageResizeFunction.checkSize();
		ImageResizeFunction.resetPP(email,password);
	}
}
