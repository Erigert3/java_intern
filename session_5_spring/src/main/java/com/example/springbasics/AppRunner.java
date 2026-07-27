package com.example.springbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private NotificationManager notificationManager;

    @Override
    public void run(String... args) throws Exception {
        notificationManager.notifyUser("Welcome to Spring!");
    }
}
