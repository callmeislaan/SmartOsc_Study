package com.fintech.soap_task.modal;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(value = EnumType.ORDINAL)
    private Priority priority;

    private Long personId;

    public enum Priority {
        secondary(0), info(1), success(2), warning(3), danger(4);
        Priority(int i) {
        }
    }
}
