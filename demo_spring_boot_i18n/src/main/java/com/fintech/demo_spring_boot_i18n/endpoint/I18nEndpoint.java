package com.fintech.demo_spring_boot_i18n.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class I18nEndpoint {

    @Autowired
    MessageSource messageSource;

    @GetMapping(value = "/")
    public String getI18n() {
        return messageSource.getMessage("country", null, LocaleContextHolder.getLocale());
    }
}
