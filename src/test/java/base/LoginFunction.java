package base;


public class LoginFunction extends BaseDriver {
	MainFunction mainFunc = new MainFunction();
	
	String emailForm = "//android.view.View/android.widget.EditText[1]";
	String passwordform = "//android.view.View/android.widget.EditText[2]";
	String loginBtn = "//*[@text='LOGIN']";
	String googleBtn = "//*[@text='GOOGLE']";
	String googleAccBtn = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]";
	String googleNameBtn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]";
	String hamburgerBtn = "//*[@text='Open navigation menu']";
	String filterBtn = "//*[@text='filter']";
	String homeBtn ="//android.view.View[3]/android.view.View[1]";
	String searchBtn = "//android.view.View[3]/android.view.View[2]";
	String notifBtn = "//android.view.View[3]/android.view.View[3]";
	
	
	public void verifyLoginPage() {		
		mainFunc.verifyEl(emailForm);
		mainFunc.verifyEl(passwordform);
		mainFunc.verifyEl(loginBtn);
		mainFunc.verifyEl(googleBtn);
	}

	public void inputEmail(String email) throws InterruptedException {
		mainFunc.input(emailForm, email);
	}
	
	public void inputPassword(String password) throws InterruptedException {
		mainFunc.input(passwordform, password);
	}
	
	public void pressLogin() {
		mainFunc.click(loginBtn);
	}
	
	public String pressGoogle() throws InterruptedException {
		mainFunc.click(googleBtn);
		Thread.sleep(3000);
		String form = driver.findElementByXPath(googleNameBtn).getText();
		mainFunc.click(googleAccBtn);
		return form;
	}
	
	public void warningMessage(String message) {
		String warning_text = "//*[@text='"+message+"']";
		mainFunc.verifyEl(warning_text);
	}
	
	public void verifyHomePage() {
		mainFunc.verifyEl(hamburgerBtn);
		mainFunc.verifyEl(filterBtn);
		mainFunc.verifyEl(homeBtn);
		mainFunc.verifyEl(searchBtn);
		mainFunc.verifyEl(notifBtn);
	}
	
	public void welcome() {
		String welcome_message = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View";
		mainFunc.verifyEl(welcome_message);
	}
}
