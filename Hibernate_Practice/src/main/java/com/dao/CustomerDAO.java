package com.dao;

import com.entity.Customer;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class CustomerDAO extends CrudDAO<Customer, Long> {
    public CustomerDAO(Session session) {
        this.session = session;
    }

    @Override
    public Optional<Set<Customer>> selectAll() {
        return Optional.of(
                new HashSet<Customer>(session.createQuery("from customer", Customer.class).list()));
    }

    @Override
    public Optional<Customer> selectById(Long id) {
        return Optional.ofNullable(session.get(Customer.class, id));
    }
}
