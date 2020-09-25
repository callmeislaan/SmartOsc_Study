package com.fintech.stackjava.spring_aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class DemoAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) {
        System.out.println("after running: " + method.getName());
    }
}
