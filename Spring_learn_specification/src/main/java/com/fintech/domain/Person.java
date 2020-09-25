package com.fintech.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstName;
    private String lastName;
    private Date dob;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
