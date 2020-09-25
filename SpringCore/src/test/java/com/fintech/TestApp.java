package com.fintech;




import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
class TestApp {
    @Autowired
    MessageSource messageSource;

    @Test
    public void getResourceBundle() {
        Customer customer = new Customer();
        String name = messageSource.getMessage("name", null, new Locale("en"));
        customer.setName(name);

        assertThat(customer.getName()).isEqualTo("James Bond");
    }
}
