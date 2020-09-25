package com.fintech.practice.config;

import com.fintech.practice.entity.Person;
import com.fintech.practice.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.fintech.practice.entity"})
public class AppConfig {

}
