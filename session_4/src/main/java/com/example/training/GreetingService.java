package com.example.training;

import org.apache.commons.lang3.StringUtils;

public class GreetingService {

    public String greet(String prefix, String name) {
        String safePrefix = StringUtils.defaultIfBlank(prefix, "Hello");
        String safeName = StringUtils.defaultIfBlank(name, "Guest");

        return safePrefix + ", " + StringUtils.capitalize(safeName) + "!";
    }
}
