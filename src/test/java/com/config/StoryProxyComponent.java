package com.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.stereotype.Component;

@ProxyCucumberScope
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface StoryProxyComponent {

}
