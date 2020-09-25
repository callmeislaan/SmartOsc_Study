package com.fintech.repository;

import com.fintech.domain.Person;
import com.fintech.domain.Status;
import com.fintech.specification.PersonSpecification;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@SpringBootTest
public class PersonRepositoryTest {
//
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    PersonRepositoryJpa personRepositoryJpa;
//
//    Person person;
//
//    @BeforeEach
//    public void init() {
//        person = new Person();
//        person.setFirstName("phuoc");
//        person.setLastName("hoang");
//        person.setSalary(10000D);
//        person.setStatus(Status.ACTIVE);
//        person.setTasks(new ArrayList<>());
//        personRepositoryJpa.save(person);
//    }
//
//    @Test
//    public void shouldSavePersonReturnThatPerson() {
//        person = new Person();
//        person.setFirstName("nguyen");
//        person.setLastName("hoa");
//        person.setSalary(10000D);
//        person.setStatus(Status.ACTIVE);
//        person.setTasks(new ArrayList<>());
//        personRepositoryJpa.save(person);
//        Person personResult = personRepositoryJpa.findById(1l).orElse(null);
////        assertEquals(personResult, person);
//    }
//
//    @Test
//    public void shouldFindAllPersonReturnEmpty() {
//        Person personLocal = new Person();
//        personLocal.setFirstName("nguyen");
//        personLocal.setLastName("hoa");
//        personLocal.setSalary(10000D);
//        personLocal.setStatus(Status.ACTIVE);
//        personLocal.setTasks(new ArrayList<>());
//        personRepositoryJpa.save(personLocal);
//
//        List<Person> persons = personRepositoryJpa.findAll();
//        assertEquals(2, persons.size());
////        assertEquals(person, persons.get(0));
////        assertEquals(personLocal, persons.get(1));
//    }
//
//    @Test
//    public void shouldFindPersonByNameAndStatusReturnThatPerson() {
//        String name = "phuoc";
//        String status = "ACTIVE";
//
//        PersonSpecification personSpecification = PersonSpecification.spec();
//        Optional.of(name).ifPresent(personSpecification::byName);
//        Optional.of(status).ifPresent(s -> personSpecification.byStatus(Status.valueOf(s)));
//        List<Person> personList = personRepositoryJpa.findAll(personSpecification.build());
////        assertEquals(personList.get(0), person);
//    }
}
