package com.practice.crudproduct.repository;

import com.practice.crudproduct.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Order, Long> {
    Order getByTotalPrice(Double totalPrice);
}
