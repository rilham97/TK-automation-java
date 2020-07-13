package base;

import io.appium.java_client.MobileElement;
import org.testng.Assert;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class CancelApplicationFunction extends BaseDriver {
    MainFunction mainFunction = new MainFunction();

    String hamburgerBtn = "//*[@text='Open navigation menu']";
    String appliedEventsBtn = "//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[4]";
    String theFirstEventBox = "//android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View";
    String cancelApplicationTxt = "Cancel Application";
    String cancelApplicationBtn = "//android.view.View[2]/android.view.View/android.view.View/android.widget.Button";
    String okBtn = "//*[@text='OK']";
    String widgetEvent = "//android.view.View/android.view.View[2]/android.view.View/android.view.View";
    String messageSuccessApply = "You have applied to this event";


    public void clickHamburgerButton() {
        mainFunction.click(hamburgerBtn);
    }

    public void clickAppliedEvents() {
        mainFunction.click(appliedEventsBtn);
    }

    public void clickEventBox() {
        mainFunction.click(theFirstEventBox);
    }

    public void clickCancelApplication() {
        mainFunction.scrollUntilFindText(cancelApplicationTxt);
        mainFunction.click(cancelApplicationBtn);
    }

    public void clickOkBtn() {
        mainFunction.click(okBtn);
    }

    public void verifyCanceledApplicationMessage(){
        MobileElement form = (MobileElement) driver.findElementByXPath(widgetEvent);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        boolean result = true;
        if (form.getText().contains(messageSuccessApply)){
            result = false;
        }
        Assert.assertTrue(result);
        System.out.println(result);
    }

    public void setDataStateApplicantsToActiveApplied() throws SQLException, ClassNotFoundException {
        Connection con = mainFunction.setupDB();
        Statement stmt = con.createStatement();
        stmt.execute("UPDATE applicants SET data_state = 'ACTIVE' WHERE user_id = 490 AND event_id = 398;");
        con.close();
    }


}
