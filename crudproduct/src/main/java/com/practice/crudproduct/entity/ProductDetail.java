package com.practice.crudproduct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDetail {
    @Id
    private Long id;

    private Long quantity;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Product product;

}