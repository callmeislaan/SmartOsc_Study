package com.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode
public class Tien {
    @EmbeddedId
    private Khoa khoa;
    private Long von;
}
