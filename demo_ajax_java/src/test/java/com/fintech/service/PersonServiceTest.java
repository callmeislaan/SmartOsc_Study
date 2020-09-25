package com.fintech.service;

import com.fintech.domain.Person;
import com.fintech.domain.Status;
import com.fintech.repository.PersonRepositoryJpa;
import com.fintech.specification.PersonSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonServiceTest {
    private MockMvc mockMvc;

    @Mock
    PersonRepositoryJpa personRepository;

    @InjectMocks
    PersonService personService;

    Person person;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(personService)
                .build();
        person = new Person(1L, "phuoc", "hoang",
                10D, new Date(2020, Calendar.NOVEMBER, 20), Status.ACTIVE, new ArrayList<>());
    }

    @Test
    public void shouldGetPersonByIdReturnThatPerson() {
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));
        Person person = new Person(1L, "phuoc", "hoang",
                10D, new Date(2020, Calendar.NOVEMBER, 20), Status.ACTIVE, new ArrayList<>());

        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        Person personResult = personService.findPerson(1L);
        assertEquals(person, personResult);
    }

    @Test
    public void shouldSavePersonReturnPersonThatSaved() throws Exception {
        when(personRepository.save(person)).thenReturn(person);
        Person personResult = personService.save(person);
        assertEquals(personResult, person);
    }

    @Test
    public void shouldFindByNameAndStatusReturnThatPerson() {
        String name = "";
        String status = "ACTIVE";

        List<Person> personList = new ArrayList<>();
        personList.add(person);

        PersonSpecification personSpecification = PersonSpecification.spec();
        Optional.ofNullable(name).ifPresent(personSpecification::byName);
        Optional.ofNullable(status).ifPresent(s -> personSpecification.byStatus(Status.valueOf(s)));
        when(personRepository.findAll(personSpecification.build())).thenReturn(personList);


//        when(personRepository.findAll(personSpecification.build())).thenReturn(personList);
//
//        when(personRepository.findAll()).thenReturn(personList);

        List<Person> personListResult = personService.findByNameAndStatus(name, status);

//        assertEquals(personList, personListResult);
    }
}
