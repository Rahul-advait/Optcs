package PageClasses;

import Base.BasePage;
import Utilities.Constants;
import Utilities.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    protected WebDriver driver;
    private String FORGOT_PASS = "link=>Forgot your password?";
    private String EMAIL_NEXT = "cssSelector=>#identifierNext .VfPpkd-vQzf8d";
    private String EMAIL = "cssSelector=>input#email";
    private String PASSWORD = "cssSelector=>input#password";
    private String REMEMBER_BTN = "cssSelector=>.checkmark";
    private String LOGIN_BTN = "cssSelector=>form .login_btn";
    private String ALERT = "cssSelector=>.Toastify__toast-body div";
    private String GOOGLE_LOGIN_BTN = "cssSelector=>.google_continue.login_btn";
    private String GOOGLE_IMG = "cssSelector=>img[alt='google']";

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isOpen() {
        String URL = "login";
        return isOpen(URL);
    }

    private Overview login(String email, String password, boolean checkRememberMe) {
        sendData(EMAIL, email, "Email Address", true);
        sendData(PASSWORD, password, "Password", true);
        if (checkRememberMe) {
            elementClick(REMEMBER_BTN, "Remember Btn");
        }
        elementClick(LOGIN_BTN, "Login Btn", 10);
        return new Overview(driver);
    }

    public Overview login() {
        return login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD, false);
    }

    public Overview login(boolean checkRememberMe) {
        return login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD, checkRememberMe);
    }

    public Overview login(String invalidField) {
        String email = Constants.VALID_EMAIL;
        String password = Constants.VALID_PASSWORD;

        switch (invalidField.toLowerCase()) {
            case "email" -> email = Constants.INVALID_EMAIL;
            case "password" -> password = Constants.INVALID_PASSWORD;
            default -> {
                login(email, password, false);
            }
        }
        login(email, password, false);
        return new Overview(driver);
    }

    public boolean isAlertPresent(String expAlertMessage) {
        WebElement element = waitForElement(ALERT, 20, "Alert");
        String alertMessage = element.getAttribute("innerText");

        return isDisplayed(ALERT, "ALERT") || Util.verifyTextMatch(alertMessage, expAlertMessage);
    }

    public boolean checkAttributes() {
        String email = getElementAttributeValue(EMAIL, "value");
        boolean verifyEmail = Util.verifyTextMatch(email, Constants.VALID_EMAIL);
        log.info("Attribute found in email field " + verifyEmail);

        String pass = getElementAttributeValue(PASSWORD, "value");
        boolean verifyPass = Util.verifyTextMatch(email, Constants.VALID_PASSWORD);
        log.info("Attribute found in email field " + verifyPass);

        return verifyEmail && verifyPass;
    }

    public ForgotPassword clickForgotPasLink() {
        elementClick(FORGOT_PASS, "forgot password", 10);
        return new ForgotPassword(driver);
    }

    public GoogleSignUP clickGoogleSignUpBtn() {
        tryclickingForTime(GOOGLE_LOGIN_BTN, 2, "GOOGLE_LOGIN_BTN");
        log.info("Clicked: " + "Google signup btn");
        return new GoogleSignUP(driver);
    }

}
