package PageClasses;

import Base.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    protected WebDriver driver;
    private String URL = "login";
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isOpen(){
        return isOpen(URL);
    }
}
