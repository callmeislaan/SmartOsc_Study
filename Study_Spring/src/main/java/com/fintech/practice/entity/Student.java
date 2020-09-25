package com.fintech.practice.entity;

import org.springframework.stereotype.Component;

@Component
public class Student extends Person implements Work{

    @Override
    public void doing() {
        System.out.println("learn");
    }
}
