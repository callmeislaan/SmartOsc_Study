package com.fintech.service;

import com.fintech.domain.Person;
import com.fintech.domain.Status;
import com.fintech.repository.PersonRepositoryJpa;
import com.fintech.repository.TaskRepository;
import com.fintech.specification.PersonSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepositoryJpa personRepository;
    @Autowired
    TaskRepository taskRepository;

    private PersonSpecification personSpecification;

    public Person findPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findByNameAndStatus(String name, String status) {
        personSpecification = PersonSpecification.spec();
        Optional.ofNullable(name).ifPresent(personSpecification::byName);
        Optional.ofNullable(status).ifPresent(s -> personSpecification.byStatus(Status.valueOf(s)));
        return personRepository.findAll(personSpecification.build());
    }
}
