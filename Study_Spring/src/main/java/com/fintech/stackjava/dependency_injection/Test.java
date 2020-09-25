package com.fintech.stackjava.dependency_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("dependencyConfig.xml");
        HelloWorld helloWorld1 = (HelloWorld) context.getBean("helloWorld1");
        HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld2");

        helloWorld1.print();
        helloWorld2.print();
    }
}
