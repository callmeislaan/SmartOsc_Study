package com.practice.crudproduct.controller;

import com.practice.crudproduct.entity.Order;
import com.practice.crudproduct.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Order order) {
        orderService.delete(order);
    }

    @GetMapping("/find/{id}")
    public Order findById(@PathVariable String id) {
        return orderService.findById(Long.parseLong(id));
    }
}
