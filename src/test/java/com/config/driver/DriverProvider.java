package com.config.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import jakarta.annotation.PreDestroy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class DriverProvider {

    private final Logger logger = LogManager.getLogger(getClass());

    private WebDriver driver;
    private final Dimension hdResolution = new Dimension(1280, 720);

    public WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            setupChromeDriver();
            setupDriverAdditionalParameters();
            driver.manage().window().setSize(hdResolution);
            logger.info("Started chrome");
        }

        return driver;
    }

    private void setupDriverAdditionalParameters() {
        driver.manage().deleteAllCookies();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage()
                .timeouts()
                .implicitlyWait(DriverConfig.MAX_OBJECT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage()
                .timeouts()
                .pageLoadTimeout(DriverConfig.MAX_PAGE_LOAD_TIME, TimeUnit.SECONDS);
    }

    private void setupChromeDriver() {
        driver = ChromeBrowser.setupDriver();
    }

    @PreDestroy
    public void closeDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
            logger.info("Closed chrome driver");
            driver = null;
        }
    }
}
