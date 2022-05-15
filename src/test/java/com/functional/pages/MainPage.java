package com.functional.pages;

import com.config.StoryProxyComponent;
import com.config.driver.DriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@StoryProxyComponent
public class MainPage {

    private final DriverProvider driverProvider;

    @FindBy(className = "star-button-container")
    private WebElement starButtonContainer;

    public MainPage(final DriverProvider driverProvider) {
        PageFactory.initElements(driverProvider.getDriver(), this);
        this.driverProvider = driverProvider;
    }

    public boolean isPageOpen() {
        return starButtonContainer.isDisplayed();
    }
}
