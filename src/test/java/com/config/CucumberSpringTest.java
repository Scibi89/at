package com.config;

import static java.util.logging.Logger.*;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = GlobalConfig.class)
public class CucumberSpringTest {
    public CucumberSpringTest() {}

    @ComponentScan("com.functional")
    public static class Configuration {}
}
