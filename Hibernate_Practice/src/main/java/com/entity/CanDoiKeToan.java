package com.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@EqualsAndHashCode
public class CanDoiKeToan {
    @EmbeddedId
    private Khoa khoa;

    @OneToOne(mappedBy = "khoa")
    private Tien tien;
}
