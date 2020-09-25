package com.fintech.practice.test;

import com.fintech.practice.config.AppConfig;
import com.fintech.practice.entity.Student;
import com.fintech.practice.entity.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Teacher teacher = (Teacher) context.getBean("teacher");
        teacher.doing();
        teacher.destroy();

        Student student = (Student) context.getBean("student");
        student.doing();
        teacher.destroy();
    }
}
