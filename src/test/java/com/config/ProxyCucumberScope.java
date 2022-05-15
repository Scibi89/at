package com.config;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Retention(RetentionPolicy.RUNTIME)
@Scope(value = SCOPE_CUCUMBER_GLUE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public @interface ProxyCucumberScope {}
