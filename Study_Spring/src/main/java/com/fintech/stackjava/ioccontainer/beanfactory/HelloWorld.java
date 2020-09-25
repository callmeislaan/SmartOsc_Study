package com.fintech.stackjava.ioccontainer.beanfactory;

import org.springframework.context.annotation.Bean;

public class HelloWorld {
    private String messenger;

    public void getMessenger() {
        System.out.println("Print: " + this.messenger);
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }
}
