package com.user.userapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup {

    @Autowired
    private WebServerApplicationContext webServerApplicationContext;

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        int port = webServerApplicationContext.getWebServer().getPort();
        System.out.println("Application is running on port: " + port);
    }
}
