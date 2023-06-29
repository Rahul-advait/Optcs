package PageClasses;

import org.openqa.selenium.WebDriver;

public class HomePageHeader extends HomePage {
    protected WebDriver driver;
    private String LOGIN = "link=>Login";
    private String REGISTER = "link=>Register";

    public HomePageHeader(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginPage clickLoginBtn() {
        elementClick(LOGIN, "LOGIN btn");
        return new LoginPage(driver);
    }

    public RegisterPage clickRegisterBtn() {
        elementClick(REGISTER, "Register btn");
        return new RegisterPage(driver);
    }


}
