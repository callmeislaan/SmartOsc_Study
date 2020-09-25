package com.fintech;

import com.fintech.domain.Person;
import com.fintech.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LearnCriteriaApplicationTests {
    @Autowired
    PersonService personService;

//    @Test
//    public void itShouldSavePersonReturnThatPersonSaved() {
//        Person person = new Person();
//        person.setFirstName("phuoc");
//        person.setLastName("hoang");
//        person.setDob(new Date());
//        person.setStatus(Person.Status.ACTIVE);
//        Person personResult = personService.save(person);
//        assertEquals(person, personResult);
//    }

    @Test
    void itShouldFindAllPersonReturnAllPerson() {
        List<Person> person = personService.findAll();
        assertTrue(person.size() > 0);
    }

    @Test
    void itShouldFindPersonByNameReturnThatPerson() {
        String name = "hoang";
        List<Person> person = personService.findByName(name);
        System.out.println("size: " + person.size());
        assertTrue(person.size() > 0);
    }


    @Test
    void itShouldFindPersonByNameAndStatusReturnThatPerson() {
        String name = "ho";
        Person.Status status = Person.Status.ACTIVE;
        List<Person> persons = personService.findByNameAndStatus(name, status);
        assertEquals(2, persons.size());
    }

}
