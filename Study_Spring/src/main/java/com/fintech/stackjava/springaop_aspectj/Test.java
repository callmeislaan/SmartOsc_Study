package com.fintech.stackjava.springaop_aspectj;

import com.fintech.stackjava.spring_aop.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("springAOPAndAspectJ.xml");
        Hello hello = (Hello) context.getBean("hello");
        hello.method1();
        System.out.println();
        hello.method2();
    }
}
