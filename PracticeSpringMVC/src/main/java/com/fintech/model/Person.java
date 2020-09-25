package com.fintech.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
