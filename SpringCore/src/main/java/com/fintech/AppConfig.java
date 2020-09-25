package com.fintech;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import sun.nio.cs.StandardCharsets;

import javax.activation.DataSource;

@Configuration
public class AppConfig {
    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/languages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
