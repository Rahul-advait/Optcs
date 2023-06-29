package Utilities;

import java.util.Random;

public class Constants {
    public static final String BASE_URL = "https://optcs-frontend.itechnolabs.tech/";
    public static final String USER_DIRECTORY = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String DRIVERS_DIRECTORY = "//drivers//";
    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    public static final String IE = "ie";
    public static final String GECKO_DRIVER_KEY = "webdriver.gecko.driver";
    public static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
    public static final String IE_DRIVER_KEY = "webdriver.ie.driver";
    public static final String GECKO_DRIVER_VALUE = "geckodriver";
    public static final String CHROME_DRIVER_VALUE = "chromedriver";
    public static final String IE_DRIVER_VALUE = "IEDriverServer";
    public static final String DEFAULT_NAME = RandomData.generateRandomName(10);
    public static final String DEFAULT_EMAIL = RandomData.generateRandomEmail(10);
    public static final String DEFAULT_PASSWORD = RandomData.generateRandomPassword(12);
    public static final String COMPANY_NAME = RandomData.generateRandomName(12);
    public static final String DEFAULT_WORK_EMAIL = RandomData.generateRandomWorkEmail(10);
    public static final String TOTAL_EMP =  Integer.toString(RandomData.random.nextInt(1000));
    public static final String COMPANY_DOMAIN = RandomData.generateRandomName(10);
    public static final String DEFAULT_USERNAME = RandomData.generateRandomUsername(8);
}