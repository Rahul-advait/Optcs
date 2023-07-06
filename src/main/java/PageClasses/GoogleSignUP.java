package PageClasses;

import Base.BasePage;
import Utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GoogleSignUP extends BasePage {

    private final String EMAIL = "cssSelector=>input[type='email']";
    private final String EMAIL_NEXT = "cssSelector=>#identifierNext .VfPpkd-vQzf8d";
    private final String PASS = "cssSelector=>input[type='password']";
    private final String PASS_NEXT = "cssSelector=>#passwordNext .VfPpkd-vQzf8d";
    private final String GOOGLE_PAGE = "xpath=>//div[@innertext='Sign in with Google']";

    protected WebDriver driver;


    public GoogleSignUP(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterValidCred() {
        String parentWindow = driver.getWindowHandle();

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (!windowHandle.equals(parentWindow)) {
                System.out.println("Inside loop " + driver.getCurrentUrl());
                break;
            }
            System.out.println(driver.getCurrentUrl());
        }

        sendData(EMAIL, Constants.GOOGLE_EMAIL, "Google Email Field", true);
        waitAndClick(EMAIL_NEXT, 10, "Email Next Btn");

        WebElement passField = waitForElement(PASS, 15, "Password field");
        sendData(passField, Constants.GOOGLE_PASS, "Google Pass Field", true);
        waitAndClick(PASS_NEXT, 10, "Password Next Btn");

        driver.switchTo().window(parentWindow);

        System.out.println(driver.getTitle());


    }

}
