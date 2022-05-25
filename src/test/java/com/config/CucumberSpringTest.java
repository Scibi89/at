package com.config;

import com.example.at.AtApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AtApplication.class, loader = SpringBootContextLoader.class)
@Import(GlobalConfig.class)
public class CucumberSpringTest {
    public CucumberSpringTest() {}

    @ComponentScan("com.functional")
    public static class Configuration {}
}
