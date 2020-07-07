package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class UpdateEventFunction extends BaseDriver{
	 MainFunction mainFunc = new MainFunction();
	 Actions action = new Actions(driver);
	 WebDriverWait wait = new WebDriverWait(driver, 10000);

	 
	String eventTitle= "//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.EditText[1]";
//	String eventCity= "//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.EditText[2]";
	String eventCity= "//*[contains(@text,'City')]";
	String eventDate ="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]";
	String eventstartTime ="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]";
	String eventendTime ="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[3]";
	String eventAge= "//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[4]";
	String eventGender ="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.Button[1]";
	String eventGenderB ="//*[@text='Both']";
//	String eventaddInfo ="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.EditText[2]";
	String eventaddInfo = "//*[contains(@text,'Additional Info')]";
	
 	String Filter="//*[@text='filter']"; 
	String ASC="//*[@text='Date of event (ASC)']"; 
	String firstEvent="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]";

	String Menu="//*[@text='Open navigation menu']";
	String MyEvent="//*[@text='My Events']"; 
	String EditEvent="//*[@text='EDIT']"; 
	String XEventDate="//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.Button[1]";
	String XEventendTime = "//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.widget.Button[1]";
	String XeventstartTime = "//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.Button[1]";
	String T12 = "//*[@text='12']";
	String T13 = "//*[@text='1']";
	String Year="//*[@text='2020']";
	String Y2021="//*[@text='2021']";

	String SaveEvent="//*[@text='SAVE']"; 
	String Male="//*[@text='Male']"; 
	String Both="//*[@text='Both']"; 
	String OK="//*[@text='OK']";
	String PM="//*[@text='PM']";
	
	String successMessage="//*[@text='Your event is successfully updated']";
	
	String texttitle ="";
	String textcity = "";
	String date = "";
	String startTime= "";
	String endTime= "";
	String Age= "";
	String Gender= "";
	String Additional= "";

	public void goToMyEvent() throws InterruptedException {
		mainFunc.click(Menu);
		mainFunc.click(MyEvent);
		mainFunc.waitElement(firstEvent);
		mainFunc.click(Filter);
		mainFunc.click(ASC);
		}
	
	 public void clickFirstEvent() throws InterruptedException {
		mainFunc.click(firstEvent);
	    }
	 
	 public void clickButtonEdit() throws InterruptedException {
		mainFunc.click(EditEvent);
		mainFunc.waitElement(eventTitle);
	    }
	 
	 public void editEventCity() throws InterruptedException {
		mainFunc.clear(eventCity);
		mainFunc.input(eventCity,"nocity");
		textcity = driver.findElement((By.xpath(eventCity))).getText();
	    }

	 public void editEventTitle() throws InterruptedException {
		MobileElement EventTitle = driver.findElement((By.xpath(eventTitle)));
		mainFunc.click(eventTitle);
	   
	    int maxTitle = EventTitle.getText().length();
	    if (maxTitle > 33){
	    	for (int i = 0; i < 14; i++) {
	    		action.click(EventTitle).sendKeys(Keys.BACK_SPACE).perform();
	    		}
	    	}
	    
		action.click(EventTitle).sendKeys("event updated").perform();
		texttitle = EventTitle.getText();
	    }
	 
	 public void editEventDate() throws InterruptedException {
	    mainFunc.click(XEventDate);
	    mainFunc.click(eventDate);
	    mainFunc.click(Year);
	    mainFunc.click(Y2021);
	    mainFunc.click(OK);
		date = driver.findElement((By.xpath(eventDate))).getText();
	 }

	 public void editStartTime() throws InterruptedException {
	    mainFunc.click(XeventstartTime);
	    mainFunc.click(eventstartTime);
	    mainFunc.click(T12);
	    mainFunc.click(PM);
	    mainFunc.click(OK);
		startTime= driver.findElement((By.xpath(eventstartTime))).getText();
	}
	 
	 public void editEndTime() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(!driver.findElements(By.xpath(XEventendTime)).isEmpty()) {
		    mainFunc.click(XEventendTime);
		    mainFunc.click(eventendTime);
		    mainFunc.click(T13);
		    mainFunc.click(PM);
		    mainFunc.click(OK);
			}
		endTime= driver.findElement(By.xpath(eventendTime)).getText();
	 }
	 
	 public void editRangeAge() throws InterruptedException {
		MobileElement EventAge = driver.findElement(By.xpath(eventAge));
		int xAxisStartPoint = EventAge.getLocation().getX();
		int yAxis = EventAge.getLocation().getY();
		int moveTo=xAxisStartPoint+200;
		new TouchAction(driver).longPress(PointOption.point(xAxisStartPoint,yAxis)).moveTo(PointOption.point(moveTo,yAxis)).release().perform();
		Age=EventAge.getText();
		}
	 
	 public void editGender() throws InterruptedException {
		MobileElement EventGender = driver.findElement((By.xpath(eventGender)));
		String gender = EventGender.getText();
		if (gender.equals("Both")){
			EventGender.click();
			mainFunc.waitElement(Male);
			mainFunc.click(Male);
			}
		else {
			EventGender.click();
			mainFunc.waitElement(Both);
			mainFunc.click(Both);
		}
		Gender=EventGender.getText();
		}
		
	 public void editAdditionalInfo() throws InterruptedException {
		mainFunc.input(eventaddInfo, "tambahan");
		Additional =  driver.findElement(By.xpath(eventaddInfo)).getText();
		driver.hideKeyboard();
		}
	 
	 public void clickButtonSave() throws InterruptedException {
		mainFunc.click(SaveEvent);
		}
	 
	 public void eventUpdated() throws InterruptedException {
		mainFunc.waitElement(successMessage);
		}
	 
	 public void checkUpdatedData() throws InterruptedException {
		mainFunc.click(EditEvent);
		mainFunc.assertText(eventTitle, texttitle);
		mainFunc.assertText(eventCity, textcity);
		mainFunc.assertText(eventDate, date);
		mainFunc.assertText(eventstartTime, startTime);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(!driver.findElements(By.xpath(XEventendTime)).isEmpty()) {
			mainFunc.assertText(eventendTime, endTime);
			}
		mainFunc.assertText(eventAge, Age);
        mainFunc.scrollUntilFindText("SAVE");
		mainFunc.assertText(eventGender, Gender);
		mainFunc.assertText(eventaddInfo, Additional);
		}
}
