package base;

public class LoginFunction extends BaseDriver {
	MainFunction feature = new MainFunction();
	
	String Email_form = "//android.view.View/android.widget.EditText[1]";
	String Password_form = "//android.view.View/android.widget.EditText[2]";
	String Login_btn = "//*[@text='LOGIN']";
	String hamburger_btn = "//*[@text='Open navigation menu']";
	String filter_btn = "//*[@text='filter']";
	String home_btn ="//android.view.View[3]/android.view.View[1]";
	String search_btn = "//android.view.View[3]/android.view.View[2]";
	String notif_btn = "//android.view.View[3]/android.view.View[3]";
	
	public void verifyLoginPage() {		
		feature.verifyEl(Email_form);
		feature.verifyEl(Password_form);
		feature.verifyEl(Login_btn);
	}
	
	public void inputEmail(String email) {
		feature.input(Email_form, email);
		//feature.assertText(Email_form, email);
	}
	
	public void inputPassword(String password) {
		feature.input(Password_form, password);
	}
	
	public void pressLogin() {
		feature.click(Login_btn);
	}
	
	public void warningMessage(String message) {
		String warning_text = "//*[@text='"+message+"']";
		feature.verifyEl(warning_text);
	}
	
	public void verifyHomePage() {
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
