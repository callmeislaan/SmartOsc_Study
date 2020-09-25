package com.fintech.stackjava.spring_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAll {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("springAOPConfig.xml");
        Hello hello = (Hello) context.getBean("helloProxy");
        hello.method1();
        System.out.println();
        hello.method2();
        System.out.println();
        hello.method3();
    }
}
