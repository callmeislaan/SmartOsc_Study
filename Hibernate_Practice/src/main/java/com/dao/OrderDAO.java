package com.dao;

import com.entity.Order;
import org.hibernate.Session;

import java.util.Optional;

public class OrderDAO {
    private final Session session;

    public OrderDAO(Session session) {
        this.session = session;
    }

    public Optional<Order> insert(Order order) {
        session.persist(order);
        return Optional.ofNullable(order);
    }
}
