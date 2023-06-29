package PageClasses;

import Base.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
