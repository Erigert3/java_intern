package com.example.training;

import com.example.training.entity.User;
import com.example.training.repository.UserRepository;
import com.example.training.util.Util;
import jakarta.persistence.EntityManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        /*Properties configuration = loadConfiguration();

        String prefix = configuration.getProperty("greeting.prefix");
        String environment = configuration.getProperty("environment.name");
        String name = args.length > 0 ? args[0] : "student";

        GreetingService service = new GreetingService();

        System.out.println(service.greet(prefix, name));
        System.out.println("Build environment: " + environment);
    }

    private static Properties loadConfiguration() {
        Properties properties = new Properties();

        try (InputStream input = Main.class.getResourceAsStream(
                "/application.properties")) {

            if (input == null) {
                throw new IllegalStateException(
                        "application.properties was not found"
                );
            }

            properties.load(input);
            return properties;
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Could not load application.properties",
                    exception
            );
        }*/

    }
}
