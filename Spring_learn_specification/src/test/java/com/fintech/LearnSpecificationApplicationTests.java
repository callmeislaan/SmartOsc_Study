package com.fintech;

import com.fintech.domain.Person;
import com.fintech.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LearnSpecificationApplicationTests {

    @Autowired
    PersonService personService;

    @Test
    void itShouldGetPersonsByNameAndStatusReturnThosePersons() {
        String name = "phuoc";
        String status = null;
        List<Person> personList = personService.find(name, status);
        personList.forEach(System.out::println);
        assertEquals(2, personList.size());
    }

}
