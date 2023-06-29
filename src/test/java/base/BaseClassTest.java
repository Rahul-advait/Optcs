package base;

import PageClasses.HomePageHeader;
import PageClasses.RegisterPage;
import Utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClassTest {
    public WebDriver driver;

    protected HomePageHeader header;
    protected RegisterPage registerPage;
    @BeforeClass
    public void beforeSetUp() {
        driver = WebDriverFactory.getInstance().getDriver("chrome");
        String baseURL = Constants.BASE_URL;
        driver.get(baseURL);
        header = new HomePageHeader(driver);
        registerPage = header.clickRegisterBtn();
    }

    @BeforeMethod
    public void methodSetUp() {
        CheckPoint.clearHashMap();
    }

    @AfterClass
    public void tearDown() {
        WebDriverFactory.getInstance().quitDriver();
    }
}
