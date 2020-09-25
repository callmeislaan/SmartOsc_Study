package com.fintech.service;

import com.fintech.domain.Person;
import com.fintech.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

//    public Person save(Person person) {
//        return personRepository.save(person);
//    }
//
//    public Person findById(Long id) {
//        return personRepository.findById(id);
//    }

    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }
//
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> findByNameAndStatus(String name, Person.Status status) {
        return personRepository.findByNameAndStatus(name, status);
    }
}
