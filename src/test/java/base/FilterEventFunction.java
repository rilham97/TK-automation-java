package base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FilterEventFunction extends BaseDriver {
    MainFunction mainFunction = new MainFunction();

    private String searchBtn = "//android.view.View[3]/android.view.View[2]";
    private String searchEventTitle = "//*[@text='Search Event']";
    private String filterBtn = "//*[@text='Filter']";
    private String filterTitle = "//*[@text='Filters']";
    private String resetBtn = "//*[@text='Reset']";
    private String genderForm = "//*[@text='Both']";
    private String ageSeekBar = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]";
    private String currentDateForm;
    private String endDateForm  ;
    private String startTime00 = "//android.widget.ScrollView/android.view.View[13]";
    private String startTime12 = "//android.widget.ScrollView/android.view.View[14]";
    private String startTime18 = "//android.widget.ScrollView/android.view.View[15]";
    private String endTime00 = "//android.widget.ScrollView/android.view.View[17]";
    private String endTime12 = "//android.widget.ScrollView/android.view.View[18]";
    private String endTime18 = "//android.widget.ScrollView/android.view.View[19]";
    private String cityForm = "//*[@text='Type here']";
    private String applyBtn = "//*[@text='Apply']";
    private String okBtn = "//*[@text='OK']";
    private String currentYear;
    private String year2021 = "//*[@text='2021']";
    private String year2022 = "//*[@text='2022']";
    private String firstEvent = "//android.view.View[2]/android.view.View/android.view.View[1]/android.view.View";

    public void clickSearchBtn() {
    	mainFunction.click(searchBtn);
    }
    public void verifySearchEventScreen(){
        mainFunction.verifyEl(searchEventTitle);
    }

    public void clickFilterButton(){
        mainFunction.verifyEl(filterBtn);
        mainFunction.click(filterBtn);
    }
    public void verifyFilterScreen(){
        mainFunction.scrollTo("Anywhere");
        mainFunction.verifyEl(filterTitle);
        mainFunction.verifyEl(resetBtn);
        mainFunction.click(resetBtn);
        mainFunction.verifyEl(applyBtn);
    }

    public void setRangeAge(){
        MobileElement seekBar = driver.findElement(By.xpath(ageSeekBar));
        TouchAction touchAction = new TouchAction(driver);
        int start = seekBar.getLocation().getX();
        int end = seekBar.getSize().getWidth();
        int y = seekBar.getLocation().getY();
        int moveTo = (int) (end * 0.2);
        touchAction.longPress(PointOption.point(start, y)).moveTo(PointOption.point(moveTo, y)).release().perform();
    }

    public void clickGender(String gender) {
        String selectedGender = "//*[@text='"+gender+"']";
        mainFunction.click(genderForm);
        mainFunction.click(selectedGender);
    }

    public void getCurrentYear() throws ParseException{
    	String dateAppium = driver.getDeviceTime();
    	String dates = dateAppium.substring(0, dateAppium.indexOf("T"));
    	// Convert to Date Format From String to Date
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	Date year = formatter.parse(dates);
        // From the Converted date to the required format eg : "yyyy"        
    	SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy");
    	currentYear = formatter2.format(year);
    	currentYear = "//*[@text='"+currentYear+"']";
    }
    
    public void getCurrentDate() throws ParseException{
    	String dateAppium = driver.getDeviceTime();
    	String dates = dateAppium.substring(0, dateAppium.indexOf("T"));
    	// Convert to Date Format From String to Date
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = formatter.parse(dates);
        // From the Converted date to the required format eg : "dd-MM-yyyy"
    	SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
    	String currentDate = formatter1.format(date);
    	currentDateForm = "//*[@text='"+currentDate+"']";
    }
    public void selectStartDate() throws ParseException{
    	getCurrentDate();
    	getCurrentYear();
    	mainFunction.click(currentDateForm);
    	mainFunction.click(currentYear);
        mainFunction.click(year2021);
        mainFunction.click(okBtn);
    }

    public void selectEndDate() throws ParseException{
    	//End Date form always next three month from start date.
    	String dateAppium = driver.getDeviceTime();
    	String dates = dateAppium.substring(0, dateAppium.indexOf("T"));
    	System.out.println(dates);
    	// Convert to Date Format From String to Date
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = formatter.parse(dates);
    	//function to add 3 months
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	c.add(Calendar.DATE, 90);
    	
        // From the Converted date to the required format eg : "dd-MM-yyyy"
    	SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
    	String endDate = formatter1.format(c.getTime());
    	System.out.println(endDate);
    	endDateForm = "//*[@text='"+endDate+"']";
        mainFunction.click(endDateForm);
    	mainFunction.click(currentYear);
        mainFunction.click(year2022);
        mainFunction.click(okBtn);
    }

    public void selectStartTime(){
        mainFunction.click(startTime12);
        mainFunction.click(startTime18);
    }

    public void selectEndTime(){
        mainFunction.click(endTime00);
        mainFunction.click(endTime12);
    }

    public void inputCity(String cityName) throws InterruptedException {
        mainFunction.input(cityForm,cityName);
    }

    public void clickApply(){
        mainFunction.click(applyBtn);
    }
    
    public void verifyEvent(String cityName) {
    	mainFunction.assertText(firstEvent, cityName);
    }
}
