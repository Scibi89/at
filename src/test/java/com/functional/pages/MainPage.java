package com.functional.pages;

import com.config.StoryProxyComponent;
import com.config.driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;

@StoryProxyComponent
public class MainPage {

    private final DriverProvider driverProvider;

    @Value("${main.shoping.url.address}")
    private String url;

    @FindBy(className = "star-button-container")
    private WebElement starButtonContainer;

    public MainPage(final DriverProvider driverProvider) {
        PageFactory.initElements(driverProvider.getDriver(), this);
        this.driverProvider = driverProvider;
    }

    public void open() {
        driverProvider.getDriver().get(url);
    }

    public boolean isPageOpen() {
        return starButtonContainer.isDisplayed();
    }
}
