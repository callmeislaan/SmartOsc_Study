package com.fintech.service;

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

    public Person getById(Long id) {
        return personDAO.getById(id).orElse(null);
    }

    public Person add(Person person) {
        return personDAO.add(person).orElse(null);
    }
}
