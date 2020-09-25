package com.fintech.practice.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person implements Work{
    private String name;
    @Autowired
    private Address address;

    @Override
    public void doing() {

    }

    @Override
    public void init() {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
