package com.fintech.o7planing.config;

import com.fintech.o7planing.impl.Vietnamese;
import com.fintech.o7planing.lang.Language;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.fintech.o7planing.bean"})
public class AppConfiguration {
    @Bean(name = "language")
    public Language getLanguage() {
        return new Vietnamese();
    }
}
