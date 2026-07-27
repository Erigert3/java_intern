package com.example.springbasics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("email")
public class EmailNotificationService implements NotificationService{

    @Value("${notification.prefix}")
    private String prefix;

    @Override
    public void send(String message) {
        System.out.println(prefix + "Sending Email Notification: " + message);
    }
}
