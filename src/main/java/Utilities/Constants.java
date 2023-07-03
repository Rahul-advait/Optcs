package Utilities;

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
    public static final String VALID_EMAIL = "rahulsingh@yopmail.com";
    public static final String VALID_PASSWORD = "1@RahulSingh";
    public static final String INVALID_PASSWORD = "Test@123";
    public static final String INVALID_EMAIL = "rahulsingh123123@yopmail.com";

    public static String getDefaultName() {
        return RandomData.generateRandomName(10);
    }

    public static String getDefaultEmail() {
        return RandomData.generateRandomEmail(10);
    }

    public static String getDefaultPassword() {
        return RandomData.generateRandomPassword(12);
    }

    public static String getCompanyName() {
        return RandomData.generateRandomName(12);
    }

    public static String getDefaultWorkEmail() {
        return RandomData.generateRandomWorkEmail(10);
    }

    public static String getTotalEmp() {
        return Integer.toString(RandomData.random.nextInt(1000));
    }

    public static String getCompanyDomain() {
        return RandomData.generateRandomName(10);
    }

    public static String getDefaultUsername() {
        return RandomData.generateRandomUsername(8);
    }
}