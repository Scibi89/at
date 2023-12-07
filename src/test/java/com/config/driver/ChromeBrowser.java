/* (C)2022 */
package com.config.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

class ChromeBrowser {

    private static final List<String> NO_HEADLESS_ARGUMENT_LIST =
            Arrays.asList(
                    "--no-sandbox",
                    "--disable-infobars",
                    "--disable-notifications",
                    "--disable-dev-shm-usage",
                    "--remote-allow-origins=*",
                    "start-maximized",
                    "--disable-extensions",
                    "--disable-gpu",
                    "--disable-in-process-stack-traces",
                    "--log-level=3");

    private ChromeBrowser() {
        throw new IllegalStateException("This class should not be instantiated!");
    }

    private static ChromeOptions getOptions() {
        final ChromeOptions options = new ChromeOptions();
        NO_HEADLESS_ARGUMENT_LIST.forEach(options::addArguments);

        return options;
    }

    static WebDriver setupDriver() {
        final ChromeOptions options = ChromeBrowser.getOptions();

        return new ChromeDriver(options);
    }
}
