package base;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RatingToEventCreatorFunction extends BaseDriver {
    MainFunction mainFunction = new MainFunction();
    Statement stmt = null;

    String pastTab = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]";
    String firstEventBox = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View";
    String rateUserBtn = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.Button";
    String fourStar = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5]";
    String submitBtn = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[7]";
    String seeRatingFromYouBtn = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.Button";
    String widgetDetailEvent = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View";
    String youAlreadyGiveTheRating = "You already given the rating";
    String widgetRating = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View";
    String ratingSuccessfullyRecordedMessage = "Your rating has been successfully recorded.";

    public void clickPastTab() {
        mainFunction.click(pastTab);
    }

    public void clickEventBox(){
        mainFunction.click(firstEventBox);
    }

    public void clickRateUserButton(){
        mainFunction.click(rateUserBtn);
    }

    public void clickStar(){
        mainFunction.click(fourStar);
    }

    public void clickSubmit(){
        mainFunction.click(submitBtn);
    }

    public void clickSeeRatingFromYou(){
        mainFunction.click(seeRatingFromYouBtn);
    }

    public void checkLabelSuccessfullyRatingAtDetailEvent(){
        mainFunction.assertText(widgetDetailEvent, youAlreadyGiveTheRating);
    }

    public void checkSuccessfullyRatingAtTheWidgetRating(){
        mainFunction.assertText(widgetRating, ratingSuccessfullyRecordedMessage);
    }

    public void setDateTo24HourAgoDB() throws SQLException, ClassNotFoundException {
        Connection con = mainFunction.setupDB();
        stmt = con.createStatement();
        stmt.execute("UPDATE event SET start_date_time = '"+getYesterdayDateString()+".00' WHERE event_id = 429;");
        con.close();
    }

    public void deleteRatingFromDB() throws SQLException, ClassNotFoundException {
        Connection con = mainFunction.setupDB();
        stmt = con.createStatement();
        stmt.execute("DELETE FROM ratings WHERE created_by = 'filter1@email.com'");
        con.close();
    }

    private  Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
    private String getYesterdayDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(yesterday());
    }






}
