/* (C)2022 */
package com.functional.pages;

import com.config.StoryProxyComponent;
import com.config.driver.DriverProvider;
import org.springframework.beans.factory.annotation.Value;

@StoryProxyComponent
public class PageOpener {

    @Value("${main.shoping.url.address}")
    private String mainPageUrl;

    private final DriverProvider driverProvider;

    public PageOpener(final DriverProvider driverProvider) {
        this.driverProvider = driverProvider;
    }

    public void openMainPage() {
        driverProvider.getDriver().get(mainPageUrl);
    }
}
