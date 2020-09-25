package com.fintech.service;

import com.fintech.controller.PersonController;
import com.fintech.dao.PersonDAO;
import com.fintech.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {
    @Autowired
    PersonDAO personDAO;

    public Person addPerson(Person person) {
        return personDAO.addPerson(person).orElseThrow(() -> new PersonController.PersonNotFoundException("exception"));
    }

    public Person getPerson(Long id) {
        return personDAO.getPerson(id)
                .orElseThrow(() -> new PersonController.PersonNotFoundException("person with id = " + id + " not found"));
    }
}
