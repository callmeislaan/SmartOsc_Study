package com.fintech.o7planing.Test;

import com.fintech.o7planing.bean.GreetingService;
import com.fintech.o7planing.bean.MyComponent;
import com.fintech.o7planing.config.AppConfiguration;
import com.fintech.o7planing.lang.Language;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        System.out.println("----------");
        Language language = (Language) context.getBean("language");

        System.out.println("Bean language: " + language);
        System.out.println("Call language.sayBye(): " + language.getBye());

        System.out.println("-----------");

        GreetingService service = (GreetingService) context.getBean("greetingService");

        service.sayGreeting();

        System.out.println("-------------");
        MyComponent myComponent = (MyComponent) context.getBean("myComponent");

        myComponent.showAppInfo();
    }
}
