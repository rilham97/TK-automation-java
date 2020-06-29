package base;

public class LoginFunction extends BaseDriver {
	MainFunction mainFunc = new MainFunction();
	
	String Email_form = "//android.view.View/android.widget.EditText[1]";
	String Password_form = "//android.view.View/android.widget.EditText[2]";
	String Login_btn = "//*[@text='LOGIN']";
	String hamburger_btn = "//*[@text='Open navigation menu']";
	String filter_btn = "//*[@text='filter']";
	String home_btn ="//android.view.View[3]/android.view.View[1]";
	String search_btn = "//android.view.View[3]/android.view.View[2]";
	String notif_btn = "//android.view.View[3]/android.view.View[3]";
	
	public void verifyLoginPage() {		
		mainFunc.verifyEl(Email_form);
		mainFunc.verifyEl(Password_form);
		mainFunc.verifyEl(Login_btn);
	}

	public void inputEmail(String email) throws InterruptedException {
		mainFunc.input(Email_form, email);

	}
	
	public void inputPassword(String password) throws InterruptedException {
		mainFunc.input(Password_form, password);
	}
	
	public void pressLogin() {
		mainFunc.click(Login_btn);
	}
	
	public void warningMessage(String message) {
		String warning_text = "//*[@text='"+message+"']";
		mainFunc.verifyEl(warning_text);
	}
	
	public void verifyHomePage() {
		mainFunc.verifyEl(hamburger_btn);
		mainFunc.verifyEl(filter_btn);
		mainFunc.verifyEl(home_btn);
		mainFunc.verifyEl(search_btn);
		mainFunc.verifyEl(notif_btn);
	}
	
	public void welcome() {
		String welcome_message = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View";
		mainFunc.verifyEl(welcome_message);
	}
}























