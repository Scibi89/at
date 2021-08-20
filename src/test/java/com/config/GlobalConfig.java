package com.config;

import com.config.driver.DriverProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan({"com.functional"})
@PropertySource({"classpath:test.properties"})
public class GlobalConfig {

  @StoryProxyBean
  public DriverProvider driverFactory() {
    return new DriverProvider();
  }
}
