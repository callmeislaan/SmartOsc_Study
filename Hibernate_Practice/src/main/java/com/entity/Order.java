package com.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalPrice = 0D;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetailSet = new HashSet<>();

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetail.setOrder(this);
        this.totalPrice += orderDetail.getQuantity()*orderDetail.getPrice();
        this.orderDetailSet.add(orderDetail);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer +
                ", orderDetailSet=" + orderDetailSet +
                '}';
    }
}
