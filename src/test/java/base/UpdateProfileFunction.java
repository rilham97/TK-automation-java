package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import utilities.DBCall;

public class UpdateProfileFunction extends BaseDriver{
	MainFunction mainFunc = new MainFunction();
	PopUpFunction popUp = new PopUpFunction();

	private String myProfileBtn = "//*[@text='My Profile']";
	private String editProfileBtn = "//*[@text='EDIT PROFILE']";
	private String photoBtn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.Button[1]";
	private String galery = "//*[@text='Choose from Gallery']";
	private String folderImageBtn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]";
	private String folderAutomationBtn = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/com.google.android.material.card.MaterialCardView/android.widget.FrameLayout/android.widget.LinearLayout";
	private String image = "//*[@text='image_automation.jpg']";
	private String listView = "//android.widget.TextView[@content-desc=\"List view\"]";
	private String cityForm = "//*[contains(@text, 'City')]";
	private String aboutMeForm = "//*[contains(@text, 'About Me')]";
	private String interestForm = "//*[contains(@text, 'Interest')]";
	private String saveBtn = "//*[@text='SAVE']";
	private String updateSnackBar = "//*[@text='Your profile is updated']";
	
	private String textCity;
	private String textAboutMe;
	private String textInterest;

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
		textCity = driver.findElement((By.xpath(cityForm))).getText();
		
	}

	public void inputAboutMe(String aboutMe) throws InterruptedException {
		mainFunc.clear(aboutMeForm);
		mainFunc.input(aboutMeForm, aboutMe);
		textAboutMe = driver.findElement((By.xpath(aboutMeForm))).getText();
	}

	public void inputInterest(String interest) throws InterruptedException {
		mainFunc.clear(interestForm);
		mainFunc.input(interestForm, interest);
		textInterest = driver.findElement((By.xpath(interestForm))).getText();
	}

	public void clickSave() {
		mainFunc.click(saveBtn);
	}
	
	public void verifyUpdate() {
		mainFunc.scrollTo("EDIT");
		mainFunc.click(editProfileBtn);
		mainFunc.assertText(cityForm, textCity);
		mainFunc.assertText(aboutMeForm, textAboutMe);
		mainFunc.assertText(interestForm, textInterest);
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
		mainFunc.click(folderImageBtn);
		
		if(driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"List view\"]")).size() != 0){
			mainFunc.click(listView);
		}
		mainFunc.click(image);
	}
	
	public void resetProile() {
		String sqlQuery = "UPDATE profile SET city = 'Magelang, Jawa Tengah', about_me = 'Captain America', interest = 'Peggy Carter' WHERE last_modified_by = 'dummy5@mail.com';";
		DBCall.executeSQLQuery(sqlQuery);
	}
}
