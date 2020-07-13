package base;

import utilities.DBCall;

public class CreatePassFunction extends BaseDriver {
	MainFunction MainFunction = new MainFunction();
	LoginFunction LoginFunction = new LoginFunction();
	
	private String passwordForm = "//*[@text='New Password']";
	private String confirmPassForm = "//*[@text='Confirm Password']";
	private String createPassBtn = "//*[@text='CREATE PASSWORD']";
	private String passwordUpdateNotif = "//*[@text='Your password already updated']";
	private String okBtn = "//*[@text='OK']";

	public void inputPass(String password) throws InterruptedException {
		MainFunction.input(passwordForm, password);
	}

	public void inputConfirmpass(String confirmPass) throws InterruptedException{
		MainFunction.input(confirmPassForm, confirmPass);
	}

	public void clickCreatePassBtn() {
		MainFunction.click(createPassBtn);
	}

	public void resetGmailData(String gmail) {
		String sqlQuery = "UPDATE users SET password_hashed = NULL WHERE email = '"+gmail+"';";
		DBCall.executeSQLQuery(sqlQuery);
		
	}
	public void successUpdatePasswordScreen() {
		MainFunction.verifyEl(passwordUpdateNotif);
		MainFunction.verifyEl(okBtn);
	}

}
