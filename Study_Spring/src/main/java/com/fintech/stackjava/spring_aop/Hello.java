package com.fintech.stackjava.spring_aop;

public class Hello {
    public void method1() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("method 1");
    }
    public void method2() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("method 2");
    }
    public void method3() {
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("method 3");
        throw new IllegalArgumentException();
    }
}
