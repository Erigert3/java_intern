package com.example.springbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationManager {


    private NotificationService notificationService;

    public void notifyUser(String message){
        notificationService.send(message);
    }

    @Autowired
    public NotificationManager(@Qualifier("email") NotificationService notificationService){
        this.notificationService = notificationService;
    }
}
