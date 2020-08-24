package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class CreateEventFunction extends BaseDriver {
    MainFunction mainFunc = new MainFunction();
    Actions action = new Actions(driver);

    String createEventIcon = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.Button";
    String title = "//*[@text='Event Title']";
    String cityPath = "//*[@text='City']";
    String eventDate = "//*[@text='Event Date']";
    String nextMonth = "//*[contains(@text, 'Next month')]";
    String date = "//*[contains(@text, '16')]";
    String okCalender = "//*[@text='OK']";
    String startTime = "//*[@text='Start Time']";
    String starHour = "//*[@text='7']";
    String headerMinutes = "//android.widget.SeekBar[2]";
    String minutes = "//*[@text='00']";
    String pm = "//*[@text='PM']";
    String okTime = "//android.widget.Button[2]";
    String endTime = "//*[@text='End Time']";
    String endHour = "//*[@text='8']";
    String t19 = "//*[@text='19']";
    String t20 = "//*[@text='20']";
    String seekBarPath = "//android.view.View[4]";
    String gender = "//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.Button[1]";
    String both = "//*[@text='Both']";
    String additionalInfo = "//*[@text='Additional Info']";
    String hamburger_btn = "//*[@text='Open navigation menu']";
    String filter_btn = "//*[@text='filter']";
    String home_btn = "//android.view.View[3]/android.view.View[1]";
    String search_btn = "//android.view.View[3]/android.view.View[2]";
    String notif_btn = "//android.view.View[3]/android.view.View[3]";
    String createEventButton = "//*[@text='CREATE EVENT']";
    String snackBarEventCreated = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[3]";

    String editDate ="//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[1]";
    String dateField ="//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText";
    String ok = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[3]";
    public void clickCreateEventIcon() {
        mainFunc.click(createEventIcon);
    }

    public void inputTitle(String userInput) throws InterruptedException {
        mainFunc.input(title, userInput);
    }

    public void inputCity(String userInput) throws InterruptedException {
        mainFunc.input(cityPath, userInput);

//        MobileElement city = driver.findElement(By.xpath(cityPath));
//        action.click(city).perform();
//        Thread.sleep(3000);
//        action.sendKeys(userInput).perform();
//        Thread.sleep(3000);
    }

    public void setAge() throws InterruptedException {
        MobileElement seekBar = driver.findElement(By.xpath(seekBarPath));
        TouchAction touchAction = new TouchAction(driver);
        int start = seekBar.getLocation().getX();
        int end = seekBar.getSize().getWidth();
        int y = seekBar.getLocation().getY();
        int moveTo = (int) (end * 0.7);
        touchAction.longPress(PointOption.point(start, y)).moveTo(PointOption.point(moveTo, y)).release().perform();
        Thread.sleep(3000);
    }

    public void inputEventDate() throws InterruptedException {
        mainFunc.click(eventDate);
        mainFunc.click(nextMonth);
        mainFunc.click(date);
        mainFunc.click(okCalender);
    }

    public void inputDate(String userInput) throws InterruptedException {
        mainFunc.click(eventDate);
        mainFunc.click(editDate);
        mainFunc.clear(dateField);
        mainFunc.input(dateField,userInput);
        mainFunc.click(ok);
    }

    public void selectCitySuggestion() throws InterruptedException {
        MobileElement index = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]"));
        String text = index.getText();
        if (text.equalsIgnoreCase("No Items Found!")) {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(PointOption.point(376, 545)).perform();
            Thread.sleep(3000);
        } else {
            action.click(index).perform();
        }
    }

    public void inputStartTime() {
        mainFunc.click(startTime);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        if (driver.findElements(By.xpath(pm)).isEmpty()) {
            mainFunc.click(t19);
            mainFunc.click(minutes);
            mainFunc.click(okTime);
        } else {
            mainFunc.click(starHour);
            mainFunc.click(headerMinutes);
            mainFunc.click(minutes);
            mainFunc.click(pm);
            mainFunc.click(okTime);
        }
    }

    public void inputEndTime() {
        mainFunc.click(endTime);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        if (driver.findElements(By.xpath(pm)).isEmpty()) {
            mainFunc.click(t20);
            mainFunc.click(minutes);
            mainFunc.click(okTime);
        } else {
            mainFunc.click(endHour);
            mainFunc.click(headerMinutes);
            mainFunc.click(minutes);
            mainFunc.click(pm);
            mainFunc.click(okTime);
        }

    }

    public void selectGender() {
        mainFunc.click(gender);
        mainFunc.click(both);
    }

    public void inputAdditionalInfo(String userInput) throws InterruptedException {
        mainFunc.input(additionalInfo, userInput);
    }

    public void verifyHomePage() {
        mainFunc.verifyEl(hamburger_btn);
        mainFunc.verifyEl(filter_btn);
        mainFunc.verifyEl(home_btn);
        mainFunc.verifyEl(search_btn);
        mainFunc.verifyEl(notif_btn);
    }

    public void clickCreateEventButton() {
        mainFunc.click(createEventButton);
    }

    public void verifyEventIsCreated() {
        mainFunc.verifyEl(snackBarEventCreated);
    }

}
