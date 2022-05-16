package com.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.context.annotation.Bean;

@ProxyCucumberScope
@Retention(RetentionPolicy.RUNTIME)
@Bean
public @interface StoryProxyBean {}
