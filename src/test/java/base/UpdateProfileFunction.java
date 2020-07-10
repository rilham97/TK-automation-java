package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class UpdateProfileFunction extends BaseDriver{
	MainFunction mainFunc = new MainFunction();
	PopUpFunction popUp = new PopUpFunction();

	private String myProfileBtn = "//*[@text='My Profile']";
	private String editProfileBtn = "//*[@text='EDIT PROFILE']";
	private String photoBtn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.Button[1]";
	private String galery = "//*[@text='Choose from Gallery']";
	private String downloadsBtn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView";
	private String image = "//*[@text='image_automation.jpg']";
	private String cityForm = "//*[contains(@text, 'City')]";
	private String aboutMeForm = "//*[contains(@text, 'About Me')]";
	private String interestForm = "//*[contains(@text, 'Interest')]";
	private String saveBtn = "//*[@text='SAVE']";
	private String updateSnackBar = "//*[@text='Your profile is updated']";

	public void clickMyProfile() {
		mainFunc.click(myProfileBtn);
	}

	public void clickEditProfile() {
		mainFunc.scrollTo("EDIT");
		mainFunc.click(editProfileBtn);
	}

	public void verifyEditProfilePage() {
		mainFunc.verifyEl(cityForm);
		mainFunc.verifyEl(aboutMeForm);
		mainFunc.verifyEl(interestForm);
		mainFunc.verifyEl(saveBtn);
	}

	public void inputCity(String city) throws InterruptedException {
		mainFunc.clear(cityForm);
		mainFunc.input(cityForm, city);
	}

	public void inputAboutMe(String aboutMe) throws InterruptedException {
		mainFunc.clear(aboutMeForm);
		mainFunc.input(aboutMeForm, aboutMe);
	}

	public void inputInterest(String interest) throws InterruptedException {
		mainFunc.clear(interestForm);
		mainFunc.input(interestForm, interest);
	}

	public void clickSave() {
		mainFunc.click(saveBtn);
	}

	public void verifySnackBar() {
		mainFunc.verifyEl(updateSnackBar);
	}

	public void selectImage(String pathFile) throws IOException, InterruptedException {
		mainFunc.pushFile(pathFile);
		mainFunc.click(photoBtn);
		mainFunc.click(galery);
		driver.findElementByAccessibilityId("Show roots").click();
		Thread.sleep(2000);
		mainFunc.click(downloadsBtn);
		mainFunc.click(image);
	}
}
