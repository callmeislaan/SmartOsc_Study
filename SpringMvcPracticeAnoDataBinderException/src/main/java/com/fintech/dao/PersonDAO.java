package com.fintech.dao;

import com.fintech.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class PersonDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Optional<Person> addPerson(Person person) {
        sessionFactory.getCurrentSession().save(person);
        return Optional.ofNullable(person);
    }

    public Optional<Person> getPerson(Long id) {
        return sessionFactory.getCurrentSession().byId(Person.class).loadOptional(id);
    }
}
