package base;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RatingToApplicantFunction extends BaseDriver {
    MainFunction mainFunction = new MainFunction();
    Statement stmt = null;

    String pastTab = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]";
    String firstEventBox = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View";
    String rateUserBtn = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button";
    String fourStar = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5]";
    String submitBtn = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[7]";
    String widgetRating = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View";
    String ratingSuccessfullyRecordedMessage = "Your rating has been successfully recorded.";
    String myEventMenu = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]";

    public void clickMyEventMenu(){
        mainFunction.click(myEventMenu);
    }
    public void clickPastTab() {
        mainFunction.click(pastTab);
    }

    public void clickEventBox() {
        mainFunction.click(firstEventBox);
    }

    public void clickRateUserButton() {
        mainFunction.scrollUntilFindText("Rate User");
        mainFunction.click(rateUserBtn);
    }

    public void clickStar() {
        mainFunction.click(fourStar);
    }

    public void clickSubmit() {
        mainFunction.click(submitBtn);
    }

    public void clickRated() {
        mainFunction.click(rateUserBtn);
    }

    public void checkSuccessfullyRatingAtTheWidgetRating() {
        mainFunction.assertText(widgetRating, ratingSuccessfullyRecordedMessage);
    }


    public void deleteRatingFromDB() throws SQLException, ClassNotFoundException {
        Connection con = mainFunction.setupDB();
        stmt = con.createStatement();
        stmt.execute("DELETE FROM ratings WHERE created_by = 'filter2@email.com'");
        con.close();
    }
}
