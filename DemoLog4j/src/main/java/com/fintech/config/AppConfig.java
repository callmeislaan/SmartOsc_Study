package com.fintech.config;

import com.fintech.aspect.LogAspect;
import com.fintech.controller.DemoLog4jServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.fintech")
public class AppConfig {
    @Bean(name = "demo")
    public DemoLog4jServlet getDemo() {
        return new DemoLog4jServlet();
    }

    @Bean(name = "aspect")
    public LogAspect getLogAspect() {
        return new LogAspect();
    }
}
