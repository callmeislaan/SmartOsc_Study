package com.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "order_detail")
@Getter
@Setter
public class OrderDetail implements Serializable {
    @Id
    @ManyToOne
    private Order order;
    @Id
    @ManyToOne
    private Product product;
    private Double price;
    private Integer quantity;

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
        return "OrderDetail{" +
                "order=" + order +
                ", product=" + product +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
