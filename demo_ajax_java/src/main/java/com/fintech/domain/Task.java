package com.fintech.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{NotBlank.task.name}")
    private String name;
    @NotBlank(message = "{NotBlank.task.description}")
    @Lob
    private String description;

    @JsonIgnore
    @ManyToOne
    private Person person;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Task task = (Task) o;
//        return Objects.equals(id, task.id) &&
//                Objects.equals(name, task.name) &&
//                Objects.equals(description, task.description) &&
//                Objects.equals(person, task.person);
//    }
}
