package com.practice.crudproduct.controller;

import com.practice.crudproduct.entity.OrderDetail;
import com.practice.crudproduct.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping("/save")
    public OrderDetail save(@RequestBody OrderDetail orderDetail) {
        return orderDetailsService.save(orderDetail);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody OrderDetail orderDetail) {
        orderDetailsService.delete(orderDetail);
    }

    @GetMapping("/find/{id}")
    public OrderDetail findById(@PathVariable String id) {
        return orderDetailsService.findById(Long.parseLong(id));
    }
}
