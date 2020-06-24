package page;

public class LoginPage extends BaseDriver {
	BaseDriver base = new BaseDriver();
	MainFeature feature = new MainFeature();
	
	public void verify_loginPage() {
		String Email_form = "//android.view.View/android.widget.EditText[2]";
		String Password_form = "//*[@text='Password']";
		String Login_btn = "//*[@text='LOGIN']";
		
		feature.verifyEl(Email_form);
		feature.verifyEl(Password_form);
		feature.verifyEl(Login_btn);
	}
	
	public void input_email(String email) {
		String Email_form = "//*[@text='Email']";
		feature.input(Email_form, email);
		//feature.assertText(Email_form, email);
	}
	
	public void input_password(String password) {
		String Password_form = "//*[@text='Password']";
		feature.input(Password_form, password);
	}
	
	public void press_login() {
		String Login_btn = "//*[@text='LOGIN']";
		feature.click(Login_btn);
	}
	
	public void warning_message(String message) {
		String warning_text = "//*[@text='"+message+"']";
		feature.verifyEl(warning_text);
	}
	
	public void verify_homePage() {
		String hamburger_btn = "//*[@text='Open navigation menu']";
		String filter_btn = "//*[@text='filter']";
		String home_btn ="//android.view.View[3]/android.view.View[1]";
		String search_btn = "//android.view.View[3]/android.view.View[2]";
		String notif_btn = "//android.view.View[3]/android.view.View[3]";
		
		feature.verifyEl(hamburger_btn);
		feature.verifyEl(filter_btn);
		feature.verifyEl(home_btn);
		feature.verifyEl(search_btn);
		feature.verifyEl(notif_btn);
	}
	
	public void welcome() {
		String welcome_message = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View";
		feature.verifyEl(welcome_message);
	}
}
