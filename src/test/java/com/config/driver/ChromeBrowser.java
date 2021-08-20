package com.config.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class ChromeBrowser {

  private static final Logger LOGGER = LogManager.getLogger(ChromeBrowser.class);
  private static final List<String> NO_HEADLESS_ARGUMENT_LIST =
      Arrays.asList("--disable-infobars", "--disable-notifications");

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
    LOGGER.info(
        "Chrome webdriver version: {}", WebDriverManager.chromedriver().getDownloadedVersion());

    return new ChromeDriver(options);
  }

}
