package base;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplyEventFunction extends BaseDriver {
    MainFunction mainFunc = new MainFunction();
    Statement stmt = null;

    String searchIcon = "//android.view.View/android.view.View[3]/android.view.View[2]";
    String theFirstEventBox = "//android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View";
    String applyToEventBtn = "//android.view.View[2]/android.view.View/android.view.View/android.widget.Button";
    String okBtn = "//*[@text='OK']";
    String applyToEvent = "Apply to Event";
    String cancelApplication = "Cancel Applications";
    String widgetEvent = "//android.view.View/android.view.View[2]/android.view.View/android.view.View";
    String messageSuccessApply = "You have applied to this event";

    public void clickSearchIcon() {
        mainFunc.click(searchIcon);
    }

    public void clickEventBox() {
        mainFunc.click(theFirstEventBox);
    }

    public void clickApplyToEventBtn() {
        mainFunc.scrollUntilFindText(applyToEvent);
        mainFunc.click(applyToEventBtn);
    }

    public void clickOkBtn(){
        mainFunc.click(okBtn);
    }

    public void verifySuccessApplyMessage(){
        mainFunc.assertText(widgetEvent, messageSuccessApply);
    }

    public void setDataStateApplicantsToDeleted() throws SQLException, ClassNotFoundException {
        Connection con = mainFunc.setupDB();
        stmt = con.createStatement();
        stmt.execute("UPDATE applicants SET data_state = 'DELETED' WHERE user_id = 490;");
        con.close();
    }

}
