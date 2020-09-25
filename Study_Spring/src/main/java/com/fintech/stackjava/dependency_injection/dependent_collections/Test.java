package com.fintech.stackjava.dependency_injection.dependent_collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("dependentCollections.xml");
        Person person1 = (Person) context.getBean("person");
        person1.print();

        Person person2 = (Person) context.getBean("person2");
        person2.print();

    }
}
