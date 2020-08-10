package base;

import org.testng.Assert;

public class SortingFunction extends BaseDriver {

    MainFunction mainFunction = new MainFunction();
    String sortingMenu = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]";
    //The data test 1 for Newest Created event & Date of Event DESC
    String dataTest1 = "F\n" +
            "Filter1\n" +
            "Test Filter 6\n" +
            "Jakarta\n" +
            "21-09-2021\n" +
            "19:00\n" +
            "Created at 16 Jul 2020, 10:51\n" +
            "F\n" +
            "Filter1\n" +
            "Test Filter 5\n" +
            "Jakarta\n" +
            "20-09-2021\n" +
            "19:00\n" +
            "Created at 16 Jul 2020, 10:46\n" +
            "F\n" +
            "Filter1\n" +
            "Test Filter 4\n" +
            "Jakarta\n" +
            "19-09-2021\n" +
            "19:00\n" +
            "Created at 16 Jul 2020, 10:43\n";

    //The data test 2 for Oldest Created event & Date of Event ASC
    String dataTest2 = "F\n" +
            "Filter1\n" +
            "Test Filter 1\n" +
            "Jakarta\n" +
            "16-09-2021\n" +
            "19:00\n" +
            "Created at 16 Jul 2020, 10:03\n" +
            "F\n" +
            "Filter1\n" +
            "Test Filter 2\n" +
            "Jakarta\n" +
            "17-09-2021\n" +
            "19:00\n" +
            "Created at 16 Jul 2020, 10:19\n" +
            "F\n" +
            "Filter1\n" +
            "Test Filter 3\n" +
            "Jakarta\n" +
            "18-09-2021\n" +
            "19:00\n" +
            "Created at 16 Jul 2020, 10:25\n";

    public void clickSortingMenu() {
        mainFunction.click(sortingMenu);
    }

    public void clickSortingFunction(String inputUser) {
        String sortingMethod = "//*[@text='" + inputUser + "']";
        mainFunction.click(sortingMethod);
    }

    public String getDataTextFromEventBox() {
        String eventBoxText = "";
        for (int i = 1; i <= 3; i++) {
            String row = Integer.toString(i);
            String EventBox = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[" + row + "]/android.view.View";
            eventBoxText += mainFunction.getTextFromElement(EventBox) + "\n";
        }
        return eventBoxText;
    }

    public void compareData(String inputUser) {
        String dataTesting = "";
        String actualData = getDataTextFromEventBox();

        if (inputUser.equalsIgnoreCase("Newest created event")) {
            dataTesting = dataTest1;
        } else if (inputUser.equalsIgnoreCase("Oldest created event")) {
            dataTesting = dataTest2;
        } else if (inputUser.equalsIgnoreCase("Date of event (ASC)")) {
            dataTesting = dataTest2;
        } else {
            dataTesting = dataTest1;
        }

        Assert.assertEquals(actualData, dataTesting);
    }

}
