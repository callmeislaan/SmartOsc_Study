package com.fintech.o7planing.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    @Autowired
    private MyRepository repository;

    public void showAppInfo() {
        System.out.println("Now is: " + repository.getSystemDateTime());
        System.out.println("App name: " + repository.getAppName());
    }
}
