package com.fintech.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Long age;
    private Double salary;
//    @DateTimeFormat(pattern="dd-MM-yyyy")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE(1), INACTIVE(-1);

        Integer value;

        Status(Integer i) {
            this.value = i;
        }

        public static Status getStatusByValue(Integer value) {
            for (Status status : Status.values()) {
                if (status.value.equals(value)) return status;
            }
            throw new IllegalArgumentException("Status is not exist!");
        }

        public static List<String> getAllStatusName() {
            return Stream.of(Status.values()).map(Status::name).collect(Collectors.toList());
        }
    }



}
