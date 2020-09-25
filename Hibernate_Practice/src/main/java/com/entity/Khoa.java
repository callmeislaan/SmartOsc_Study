package com.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class Khoa implements Serializable {
    private String maCK;
    private int nam;
}
