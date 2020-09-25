package com.practice.crudproduct.service;

import com.practice.crudproduct.entity.OrderDetail;
import com.practice.crudproduct.exception.OrderDetailsNotFoundException;
import com.practice.crudproduct.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService implements CrudService<OrderDetail, Long> {
@Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailsRepository.save(orderDetail);
    }

    @Override
    public OrderDetail findById(Long aLong) {
        return orderDetailsRepository.findById(aLong).orElseThrow(OrderDetailsNotFoundException::new);
    }

    @Override
    public void deleteById(Long aLong) {
        orderDetailsRepository.deleteById(aLong);
    }

    @Override
    public void delete(OrderDetail orderDetail) {
        orderDetailsRepository.delete(orderDetail);
    }
}
