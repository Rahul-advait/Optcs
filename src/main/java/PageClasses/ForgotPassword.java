package PageClasses;

import Base.BasePage;
import Utilities.Constants;
import Utilities.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword extends BasePage {
    protected WebDriver driver;
    private String EMAIL = "cssSelector=>input#email";
    private String SUBMIT = "cssSelector=>.login_btn";
    private String URL = "forgot-password";
    private String ALERT = "cssSelector=>.Toastify__toast-body div";
    private String SUCCESS_NOTIFICATION = "Reset password link has been sent to your email-id";

    private String ERROR_NOTIFICATION = "Email Id is not registered";

    public ForgotPassword(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isOpen() {
        return isOpen(URL);
    }

    public boolean enterValidEmail() {
        sendData(EMAIL, Constants.VALID_EMAIL, "Valid Email Address");
        elementClick(SUBMIT, "Submit Btn");
        WebElement element = waitForElement(ALERT, 10, "Alert");
        String notification = element.getText();
        System.out.println(notification);
        return Util.verifyTextMatch(notification, SUCCESS_NOTIFICATION);
    }

    public boolean enterInvalidEmail() {
        sendData(EMAIL, Constants.INVALID_EMAIL, "Valid Email Address");
        elementClick(SUBMIT, "Submit Btn");
        WebElement element = waitForElement(ALERT, 10, "Alert");
        String notification = element.getText();
        System.out.println(notification);
        return Util.verifyTextMatch(notification, ERROR_NOTIFICATION);
    }
}
