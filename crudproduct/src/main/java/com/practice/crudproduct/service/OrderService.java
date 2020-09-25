package com.practice.crudproduct.service;

import com.practice.crudproduct.entity.Order;
import com.practice.crudproduct.exception.OrderNotFoundException;
import com.practice.crudproduct.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements CrudService<Order, Long> {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findById(Long aLong) {
        return orderRepository.findById(aLong).orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public void deleteById(Long aLong) {
        orderRepository.deleteById(aLong);
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
