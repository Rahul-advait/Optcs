package base;

import Base.CustomDriver;
import PageClasses.HomePageHeader;
import PageClasses.RegisterPage;
import Utilities.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseClassTest {
    protected static final Logger log = LogManager.getLogger(CustomDriver.class.getName());
    public WebDriver driver;

    protected HomePageHeader header;
    protected RegisterPage registerPage;

    @BeforeClass
    public void beforeSetUp() {
        driver = WebDriverFactory.getInstance().getDriver("chrome");
        String baseURL = Constants.BASE_URL;
        NetworkDevTools networkDevTools = new NetworkDevTools(driver);
        networkDevTools.getNetworkResponse();
        driver.get(baseURL);
        header = new HomePageHeader(driver);
    }
    @AfterClass
    public void tearDown() {
        WebDriverFactory.getInstance().quitDriver();
    }
}
