package com.practice.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person person = applicationContext.getBean("person", Person.class);
        Address address = applicationContext.getBean("address", Address.class);
        address.setCountry("Viet Nam");
        address.setProvince("Ha Noi");
        address.setDistrict("Nam Tu Liem");
        person.setName("peter");
        person.setAddress(address);
        System.out.println(person.getAddress());
        System.out.println(person.getName());
        int b = 1;
        long a = b + 1;
    }
}
