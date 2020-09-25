package com.fintech.service;

import com.fintech.domain.Person;
import com.fintech.repository.PersonRepository;
import com.fintech.specification.PersonSpecification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    final
    PersonRepository personRepository;

    final
    PersonSpecification personSpecification;

    public PersonService(PersonRepository personRepository, PersonSpecification personSpecification) {
        this.personRepository = personRepository;
        this.personSpecification = personSpecification;
    }

    public List<Person> find(String name, String status) {
        Optional.ofNullable(name).ifPresent(personSpecification::byName);
        Optional.ofNullable(status).ifPresent(s -> personSpecification.byStatus(Person.Status.valueOf(s)));
        return personRepository.findAll(personSpecification.build());
    }
}
