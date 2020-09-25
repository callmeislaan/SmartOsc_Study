package com.fintech.stackjava.spring_aop;

import org.springframework.aop.ThrowsAdvice;

public class DemoAfterThrowAdvice implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("throw advice method: " );
    }
}
