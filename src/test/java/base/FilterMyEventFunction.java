package base;

public class FilterMyEventFunction extends BaseDriver {
    MainFunction mainFunction = new MainFunction();
    String filterIcon = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[3]";
    String firstEventBox = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View";
    String secondEventBox = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View";
    String pastTab = "//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]";

    public void clickFilterIcon() {
        mainFunction.click(filterIcon);
    }

    public void clickFilterMethod(String inputUser) {
        String filterMethod = "//*[@text='" + inputUser + "']";
        mainFunction.click(filterMethod);
    }

    public void verifyEventBoxStatus(String inputUser) {
        mainFunction.assertText(firstEventBox, inputUser);
        mainFunction.assertText(secondEventBox, inputUser);
    }

    public void clickPastTab() {
        mainFunction.click(pastTab);
    }
}
