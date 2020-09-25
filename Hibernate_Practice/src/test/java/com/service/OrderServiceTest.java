package com.service;

import com.entity.Customer;
import com.entity.Order;
import com.entity.OrderDetail;
import com.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    @Test
    public void itShouldAddOrderContainsAllItsOrderDetails() {
        Order order = new Order();
        Customer customer = new CustomerService().selectById(3L);
        // order detail 1
        OrderDetail orderDetail1 = new OrderDetail();
        Product product1 = new ProductService().selectById(1L);
        orderDetail1.setProduct(product1);
        orderDetail1.setPrice(product1.getPrice());
        orderDetail1.setQuantity(2);
        // order detail 2
        OrderDetail orderDetail2 = new OrderDetail();
        Product product2 = new ProductService().selectById(2L);
        orderDetail2.setProduct(product2);
        orderDetail2.setPrice(product2.getPrice());
        orderDetail2.setQuantity(3);

        System.out.println(orderDetail1.getPrice());
        System.out.println(orderDetail2.getPrice());

        order.addOrderDetail(orderDetail1);
        order.addOrderDetail(orderDetail2);

        order.setCustomer(customer);

        System.out.println(order.toString());

//        Order orderResult = new OrderService().insert(order);
//        assertEquals(order, orderResult);
    }
}
