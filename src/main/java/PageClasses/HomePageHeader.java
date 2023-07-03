package PageClasses;

import org.openqa.selenium.WebDriver;

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

    public LoginPage clickLoginBtn() {
        if (isDisplayed(ALERT, "Logout Successfull")) {
            waitDisappearAndClick(ALERT, 20, "Logout successfully alert", LOGIN, "LOGIN BTN");
        } else {
            elementClick(LOGIN, "LOGIN btn");
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
