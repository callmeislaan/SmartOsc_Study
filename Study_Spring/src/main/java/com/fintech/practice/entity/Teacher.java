package com.fintech.practice.entity;

import org.springframework.stereotype.Component;

@Component
public class Teacher extends Person{
    @Override
    public void doing() {
        System.out.println("teach");
    }
}
