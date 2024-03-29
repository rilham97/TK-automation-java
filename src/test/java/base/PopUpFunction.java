package base;

import java.time.LocalDate;
import java.util.Calendar;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.cucumber.java.it.Date;

public class PopUpFunction extends BaseDriver {
	MainFunction mainFunc = new MainFunction();
	// Confirmation	

	private String yesBtn = "//*[@text='Yes']";
	private String noBtn = "//*[@text='No']";
	private String okBtn = "//*[@text='OK']";
	private String cancelBtn = "//*[@text='CANCEL']";
	// Internet Connection
	private String disconnectNotif = "//*[@text='There is no internet connection']";

	// Date PopUp	
	private String yearBtn = "//*[@text='Switch to input']";

	public void clickYes() {
		mainFunc.click(yesBtn);
	}

	public void clickNo() {
		mainFunc.click(noBtn);
	}

	public void clickOk() {
		mainFunc.click(okBtn);
	}

	public void clickCancel() {
		mainFunc.click(cancelBtn);
	}

	public void disconnectConnection() {
		mainFunc.verifyEl(disconnectNotif);;
	}

//	public static String getCurrentYear() {
//	    int year = LocalDate.now().getYear();
//	    yearBtn = String.format("//*[@text='%02d']", year);
//		return yearBtn;
//	}
	
	public void setYearBirth(String year) throws InterruptedException {
		mainFunc.click(yearBtn);
//		mainFunc.scrollTo(year);
//		mainFunc.click("//*[@text='"+year+"']");
		mainFunc.input(yearBtn, "12/01/1992");
		clickOk();
	}
}
