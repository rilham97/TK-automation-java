package base;

public class RemoveUserFunction extends BaseDriver {
    MainFunction mainFunc = new MainFunction();
    LoginFunction loginFunction = new LoginFunction();

    String hamburger_btn = "//*[@text='Open navigation menu']";
    String myAccount = "//*[@text='My Account']";
    String deleteAccount = "//*[@text='DELETE ACCOUNT']";
    String cont = "//*[@text='Continue']";
    String popupIncorrectEmailPass = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View";

    public void clickHamburgerButton(){
        mainFunc.click(hamburger_btn);
    }

    public void clickMyAccount(){
        mainFunc.click(myAccount);
    }

    public void clickDeleteAccount(){
        mainFunc.click(deleteAccount);
    }

    public void clickContinue(){
        mainFunc.click(cont);
    }

    public void verifyHomeScreen(){
        loginFunction.verifyLoginPage();
    }

    public void checkIncorrectEmailPassword(){
        mainFunc.verifyEl(popupIncorrectEmailPass);
    }

}
