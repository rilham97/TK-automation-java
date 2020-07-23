package base;

import utilities.APIcall;
import utilities.DBCall;

import java.util.HashMap;
import java.util.Map;

public class NotifEventApplicantFunction {
    MainFunction mainFunction = new MainFunction();
    //index = 0 means the newest notification, because located on top list
    String notifAccepted = "//*[contains(@text,'Your event application was accepted') and (@index =0)]";
    String notifCanceled = "//*[contains(@text,'Your event application was cancelled') and (@index =0)]";
    String notifRejected = "//*[contains(@text,'Your event application was rejected') and (@index =0)]";
    String notifEventCanceled = "//*[contains(@text,'The Event that you have applied was canceled') and (@index =0)]";
    String notifEventEdited = "//*[contains(@text,'The Event info that you have applied was edited') and (@index =0)]";
    //Edit event param
    String titleField = "Jessica Marriage Kuy";
    String cityField = "Gresik, Jawa Timur, Indonesia";
    String startDateTimeField = "10-02-2021 04:00";
    String finishDateTimeField = "10-02-2021 06:00";
    String minimumAgeField = "20";
    String maximumAgeField = "150";
    String companionGenderField = "B";
    String additionalInfoField = "Updated by Rama";

    public void verifyNotifAccepted() {
        mainFunction.verifyEl(notifAccepted);
        mainFunction.click(notifAccepted);
    }

    public void verifyNotifCanceled() {
        mainFunction.verifyEl(notifCanceled);
        mainFunction.click(notifCanceled);
    }

    public void verifyNotifRejected() {
        mainFunction.verifyEl(notifRejected);
        mainFunction.click(notifRejected);
    }

    public void verifyNotifEventCanceled(){
        mainFunction.verifyEl(notifEventCanceled);
        mainFunction.click(notifEventCanceled);
    }

    public void verifyNotifEdited(){
    	mainFunction.verifyEl(notifEventEdited);
    	mainFunction.click(notifEventEdited);
    }

    public void acceptApplicant(String email, String password, int applicantId){
        APIcall.login(email,password);
        APIcall.acceptApplicant(applicantId);
    }

    public void cancelApplicant(String email, String password, int applicantId){
        APIcall.login(email,password);
        APIcall.cancelApplicant(applicantId);
    }

    public void rejectApplicant(String email, String password, int applicantId){
        APIcall.login(email,password);
        APIcall.rejectApplicant(applicantId);
    }

    public void cancelEvent(String email, String password, int eventId){
        APIcall.login(email,password);
        APIcall.cancelEvent(eventId);
    }

    public void editEvent(String email, String password, int eventId){
        APIcall.login(email,password);
        //Choosing map as object because eventId is int but other params are string
        Map<String,Object> requestBody = new HashMap<>();
        requestBody.put("eventId", eventId);
        requestBody.put("title", titleField);
        requestBody.put("startDateTime", startDateTimeField);
        requestBody.put("finishDateTime", finishDateTimeField);
        requestBody.put("minimumAge", minimumAgeField);
        requestBody.put("maximumAge", maximumAgeField);
        requestBody.put("companionGender", companionGenderField);
        requestBody.put("city", cityField);
        requestBody.put("additionalInfo", additionalInfoField);

        APIcall.editEvent(requestBody);

    }

    public void resetToApplied(int applicantId){
        String sqlQuery = "UPDATE applicants SET data_state = 'ACTIVE', status = 'APPLIED' WHERE id = "+applicantId+";";
        DBCall.executeSQLQuery(sqlQuery);
    }

    public void resetToAccepted(int applicantId){
        String sqlQuery = "UPDATE applicants SET data_state = 'ACTIVE', status = 'ACCEPTED' WHERE id =  "+applicantId+";";
        DBCall.executeSQLQuery(sqlQuery);
    }


    public void resetCancelEvent(int eventId){
        String sqlQuery = "UPDATE event set cancelled = 'false' WHERE event_id =  "+eventId+";";
        DBCall.executeSQLQuery(sqlQuery);
    }
}
