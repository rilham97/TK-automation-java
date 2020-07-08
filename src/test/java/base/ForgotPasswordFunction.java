package base;

public class ForgotPasswordFunction extends BaseDriver {
    MainFunction mainFunction = new MainFunction();

    String forgotPassword = "//*[@text='FORGOT PASSWORD']";
    String emailField = "//android.view.View[2]/android.view.View/android.widget.EditText";
    String sendBtn = "//*[@text='SEND']";
    String okInfo = "//*[@text='OK']";
    String verificationCodeField = "//*[@text='Verification Code']";
    String newPasswordField ="//*[@text='New Password']";
    String confirmPasswordField = "//*[@text='Confirm Password']";
    String resetPasswordBtn = "//*[@text='RESET PASSWORD']";

    public void clickForgotPassword(){
        mainFunction.click(forgotPassword);
    }

    public void inputEmail(String userInput) throws InterruptedException {
        mainFunction.input(emailField, userInput);
    }

    public void clickSend(){
        mainFunction.click(sendBtn);
    }

    public void clickOkOnPopUpInfo(){
        mainFunction.click(okInfo);
    }

    public void inputVerificationCode(String userInput) throws InterruptedException {
        mainFunction.input(verificationCodeField,userInput);
    }

    public void inputNewPassword(String userInput) throws InterruptedException {
        mainFunction.input(newPasswordField,userInput);
    }

    public void inputConfirmPassword(String userInput) throws InterruptedException {
        mainFunction.input(confirmPasswordField, userInput);
    }

    public void clickResetPasswordBtn(){
        mainFunction.click(resetPasswordBtn);
    }

}
