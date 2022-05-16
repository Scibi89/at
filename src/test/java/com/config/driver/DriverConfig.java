package com.config.driver;

public class DriverConfig {

    public static final int MAX_PAGE_LOAD_TIME = 15;
    public static final int MAX_OBJECT_TIMEOUT = 10;

    private DriverConfig() {
        throw new IllegalStateException("This class should not be instantiated!");
    }
}
