package com.fintech.dao;

import com.fintech.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Optional<Person> getById(Long id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Person.class, id));
    }

    public Optional<Person> add(Person person) {
        sessionFactory.getCurrentSession().save(person);
        return Optional.ofNullable(person);
    }
}
