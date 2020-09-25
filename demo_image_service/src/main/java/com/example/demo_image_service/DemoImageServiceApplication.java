package com.example.demo_image_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoImageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoImageServiceApplication.class, args);
    }

}
