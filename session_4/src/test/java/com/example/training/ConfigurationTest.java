package com.example.training;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConfigurationTest {

    @Test
    void filteredConfigurationIsAvailable() throws Exception {
        try (InputStream input =
                     Main.class.getResourceAsStream(
                             "/application.properties")) {

            assertNotNull(input);

            Properties properties = new Properties();
            properties.load(input);

            assertFalse(
                    properties.getProperty(
                            "environment.name"
                    ).isBlank()
            );

            assertFalse(
                    properties.getProperty(
                            "greeting.prefix"
                    ).isBlank()
            );
        }
    }
}
