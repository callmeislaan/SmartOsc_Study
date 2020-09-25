package com.fintech.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{NotBlank.person.firstName}")
    private String firstName;
    @NotBlank(message = "{NotBlank.person.lastName}")
    private String lastName;
    @JsonFormat
    private Double salary;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Objects.equals(id, person.id) &&
//                Objects.equals(firstName, person.firstName) &&
//                Objects.equals(lastName, person.lastName) &&
//                Objects.equals(salary, person.salary) &&
//                Objects.equals(dob, person.dob) &&
//                status == person.status &&
//                Objects.equals(tasks, person.tasks);
//    }
}
