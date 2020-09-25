package com.service;

import com.dao.OrderDAO;
import com.entity.Order;
import com.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public class OrderService {
    private final Session session = HibernateUtil.getSession();
    private final OrderDAO orderDAO = new OrderDAO(session);

    public Order insert(Order t) {
        Transaction transaction = null;
        Optional<Order> optionalOrder = Optional.empty();
        try {
            transaction = session.beginTransaction();
            optionalOrder = orderDAO.insert(t);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return optionalOrder.orElseThrow(() -> new OrderException("insert field!"));
    }

    public static class OrderException extends RuntimeException{
        public OrderException(String message) {
            super(message);
        }
    }
}
