package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageHeader extends HomePage {
    protected WebDriver driver;
    private String LOGIN = "link=>Login";
    private String REGISTER = "link=>Register";
    private String URL = "https://optcs-frontend.itechnolabs.tech/";
    private String ALERT = "cssSelector=>.Toastify__toast-body div";

    public HomePageHeader(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginPage clickLoginBtn1() {
        elementClick(LOGIN, "LOGIN btn");
        return new LoginPage(driver);
    }

    public LoginPage clickLoginBtn() {
        WebElement element = null;
        try {
            element = waitForElement(ALERT, 3, "Alert");
            log.info("ALERT is present");
            boolean flag = element.isDisplayed();
            log.info(flag);
            if (flag) {
                log.info("Alert is displayed");
                waitDisappearAndClick(ALERT, 20, "Alert", LOGIN, "LOGIN Btn");
            }
        } catch (Exception e) {
            log.info("Exception occured");
            elementClick(LOGIN, "Login");
        }
        return new LoginPage(driver);
    }

    public RegisterPage clickRegisterBtn() {
        elementClick(REGISTER, "Register btn");
        return new RegisterPage(driver);
    }

    public boolean isOpen() {
        return isExactlyOpen(URL);
    }

}
