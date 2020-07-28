package base;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.cucumber.messages.internal.com.google.common.collect.ImmutableMap;

public class MainFunction extends BaseDriver {

    public void verifyEl(String element) {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElementByXPath(element);
        } catch (NoSuchElementException e) {
            Assert.fail("Element " + element + " is not found");
        }
        Assert.assertTrue((driver.findElementByXPath(element)).isDisplayed());
    }

    public void assertText(String element, String text) {
        MobileElement form = (MobileElement) driver.findElementByXPath(element);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(form.getText().contains(text));
    }

    public String getTextFromElement(String element){
        String text="";
        MobileElement form = driver.findElementByXPath(element);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        text = form.getText();
        return text ;
    }

    public void input(String element, String text) throws InterruptedException {
        Actions action = new Actions(driver);
        MobileElement form = (MobileElement) driver.findElementByXPath(element);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        form.click();
        Thread.sleep(1000);
        //Wait until keyboard is shown
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.isKeyboardShown();
        action.sendKeys(text).perform();
        //Hide the keyboard
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Go"));
        //		driver.hideKeyboard();

    }

    public void click(String element) {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            MobileElement btn = driver.findElementByXPath(element);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            if (btn.isEnabled()) {
                btn.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error on Page: button cannot clicked");
        }
    }

    public void clear(String element) {
        Actions act = new Actions(driver);
        //Press long
        MobileElement form = driver.findElementByXPath(element);
        new TouchAction(driver).longPress(longPressOptions().withElement(element(form)).withDuration(Duration.ofMillis(1000))).release().perform();
        //Choose select all
        String select_all = "//*[@text='SELECT ALL']";
        click(select_all);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        act.sendKeys(Keys.DELETE).perform();
    }

    public void scrollTo(String text) {
        try {
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))");
        } catch (Exception e) {
            System.out.println("We got an error scrolling!");
        }
    }

    public void pushFile(String pathFile) throws IOException {
        driver.pushFile("/storage/emulated/0/automation/image_automation.jpg", new File(pathFile));
    }

    public void scrollUntilFindText(String text) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));"));
    }

    public void waitElement(String element) {
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }

    public void waitElementInvisible(String element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Boolean bool = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
        System.out.println(bool);
    }

    public void minimizeApplication() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
    }

    public void openNotifications(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.openNotifications();
    }

    public Connection setupDB() throws ClassNotFoundException, SQLException {
        Connection con;
        String dbUrl = "jdbc:postgresql://chippermitrais.ddns.net:5432/postgres";
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(dbUrl, "postgres", "92JjTEb5CYmqkr");
        return con;
    }
}