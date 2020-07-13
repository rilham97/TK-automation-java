package base;

import utilities.DBCall;

public class RegisterFunction extends BaseDriver{
	MainFunction mainFunc = new MainFunction();
	PopUpFunction popUp = new PopUpFunction();
	
	//Register New Account Screen
	private String createBtn = "//*[@text='CREATE ACCOUNT']";
	private String fullNameForm = "//*[@text='Full Name']";
	private String dobForm = "//*[@text='Date of Birth']";
	private String genderBtn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.Button[1]";
	private String emailForm = "//*[@text='Email']";
	private String passwordForm = "//*[@text='Password']";
	private String confirmpassForm = "//*[@text='Confirm Password']";
	private String tncCheckbox = "//android.widget.CheckBox";
	private String tncBtn = "//*[@text='Term And Condition']";
	//Optional Information Screen
	private String optionalTitle = "User Optional Information";
	private String cameraBtn = "//android.view.View/android.widget.Button[1]";
	private String cityBtn = "//*[@text='City']";
	private String aboutForm = "//*[@text='About Me']";
	private String interest = "//*[@text='Interest']";
	private String skipBtn = "//*[@text='Skip']";
	//Warning message
	private String warnEmail = "//*[@text='Please fill the valid email format']";
	private String warnPass = "//*[@text='Password should contain at least 1 numeric and 1 special character']";
	private String warnConfrimPass = "//*[@text='Your passwords are not match']";

	public void verifyCreateAccountPage() {
		//mainFunc.verifyEl(createBtn);
		mainFunc.verifyEl(fullNameForm);
		mainFunc.verifyEl(dobForm);
		mainFunc.verifyEl(genderBtn);
		mainFunc.verifyEl(emailForm);
		mainFunc.verifyEl(passwordForm);
		mainFunc.verifyEl(confirmpassForm);
		mainFunc.verifyEl(tncCheckbox);
		mainFunc.verifyEl(tncBtn);	
	}
	
	public void inputFullname(String fullName) throws InterruptedException {
		mainFunc.input(fullNameForm, fullName);
	}
	
	public void inputDob(String year) {
		mainFunc.click(dobForm);
		popUp.setYearBirth(year);
	}
	
	public void inputGender(String gender) {
		mainFunc.click(genderBtn);
		String selectGender = "//*[@text='"+gender+"']";
		mainFunc.click(selectGender);
	}
	
	public void inputEmail(String email) throws InterruptedException {
		mainFunc.input(emailForm, email);
	}
	
	public void inputPass(String password) throws InterruptedException {
		mainFunc.input(passwordForm, password);
	}
	
	public void inputConfirmpass(String confirmPass) throws InterruptedException{
		mainFunc.input(confirmpassForm, confirmPass);
	}
	
	public void clickTnc() {
		mainFunc.click(tncCheckbox);
	}
	
	public void clickCreateAcc() {
		mainFunc.click(createBtn);
	}
	
	public void verifyOptionalInformation() {
		mainFunc.verifyEl(optionalTitle);
		mainFunc.verifyEl(cameraBtn);
		mainFunc.verifyEl(cityBtn);
		mainFunc.verifyEl(aboutForm);
		mainFunc.verifyEl(interest);
		mainFunc.verifyEl(skipBtn);
	}
	
	public void clickSkip() {
		mainFunc.click(skipBtn);
	}
	
	public void deleteUser(String email) {
		String sqlQuery =  "UPDATE profile SET data_state = 'DELETED' WHERE full_name = 'Automation Account 1';"
				+ "UPDATE users SET data_state = 'DELETED' WHERE email = '"+email+"';";
		DBCall.executeSQLQuery(sqlQuery);
	}
	
	public void warnEmailFormat() {
		mainFunc.waitElement(warnEmail);
	}
	public void warnPassFormat() {
		mainFunc.verifyEl(warnPass);
	}
	public void warnConfirmPassFormat() {
		mainFunc.verifyEl(warnConfrimPass);
	}

}
