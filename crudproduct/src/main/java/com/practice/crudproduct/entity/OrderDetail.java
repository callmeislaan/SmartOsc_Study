package com.practice.crudproduct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@IdClass(OrderDetail.OrderDetailsId.class)
public class OrderDetail implements Serializable{

    @EmbeddedId
    private OrderDetailsId id;

    private Long quantity;
    private Double price;

    @JsonIgnore
    @MapsId("order")
    @ManyToOne
    private Order order;

    @MapsId("product")
    @ManyToOne
    private Product product;

    @Embeddable
    static class OrderDetailsId implements Serializable {
        private Long order;
        private Long product;
    }
}

