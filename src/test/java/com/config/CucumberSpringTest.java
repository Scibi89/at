package com.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = GlobalConfig.class)
public class CucumberSpringTest {

    @ComponentScan("com.functional")
    public static class Configuration {}
}

// @ContextConfiguration(classes = SpringIntegrationTestBase.Configuration.class)
// @CucumberContextConfiguration
// public class SpringIntegrationTestBase {
//
//
// }
