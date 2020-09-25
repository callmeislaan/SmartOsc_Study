package com.fintech.stackjava.spring_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeforeAdvice {
    public static void main(String[] args) throws Exception{
        ApplicationContext context =
                new ClassPathXmlApplicationContext("springAOPConfig.xml");
        Hello hello = (Hello) context.getBean("helloProxy");
        hello.method1();
        hello.method2();
    }
}
