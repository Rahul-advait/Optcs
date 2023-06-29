package Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage extends CustomDriver {
    protected static final Logger log = LogManager.getLogger(CustomDriver.class.getName());
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean verifyTitle(String expectedTitle) {
        return driver.getTitle().equalsIgnoreCase(expectedTitle);
    }

    public boolean isOpen(String url) {
        log.info("Checking to see if current url contains " + url);

        long timeoutInSeconds = 10;
        long pollingIntervalInMilliseconds = 500;
        long endTime = System.currentTimeMillis() + timeoutInSeconds * 1000;

        while (System.currentTimeMillis() < endTime) {
            if (driver.getCurrentUrl().contains(url)) {
                return true;
            }
            try {
                Thread.sleep(pollingIntervalInMilliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error("Thread Intercepted");
                log.error(e.getMessage());
            }
        }

        log.error("Timeout exceeded. Expected URL to contain: " + url);
        return false;
    }
}


