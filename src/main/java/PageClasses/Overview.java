package PageClasses;

import Base.BasePage;
import org.openqa.selenium.WebDriver;

public class Overview extends BasePage {
    protected WebDriver driver;
    private String PROFILE = "cssSelector=>[alt='avtar']";
    private String SIGN_OUT = "cssSelector=>.dropdown-menu.show > a:nth-of-type(4)";
    private String LOGIN_ALERT = "cssSelector=>div[role='alert'] > div";

    public Overview(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isOpen() {
        String URL = "overview";
        return isOpen(URL);
    }

    public HomePageHeader logout() {
        waitDisappearAndClick(LOGIN_ALERT, 20, "lOGIN ALERT", PROFILE, "Profile icon");
        waitAndClick(SIGN_OUT, 10, "Sign out Btn");
        return new HomePageHeader(driver);
    }
}
