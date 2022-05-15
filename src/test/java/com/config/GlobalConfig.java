/* (C)2022 */
package com.config;

import com.config.driver.DriverProvider;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@TestConfiguration
@ComponentScan({"com.functional"})
@PropertySource({"classpath:test.properties"})
public class GlobalConfig {

    @StoryProxyBean
    public DriverProvider driverFactory() {
        return new DriverProvider();
    }
}
