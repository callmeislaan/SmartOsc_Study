package com.fintech.dto;

import com.fintech.domain.Person;
import com.fintech.domain.Task;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class TaskDTO {

    @NotBlank(message = "{NotBlank.task.name}")
    private String name;

    @NotBlank(message = "{NotBlank.task.description}")
    private String description;

    private Long id;
    private Long personId;

    public TaskDTO() {
    }

    public TaskDTO(Task task) {
        this.name = task.getName();
        this.id = task.getId();
        this.description = task.getDescription();
        this.personId = task.getPerson().getId();
    }

    public Task toEntity() {
        Task task = new Task();
        task.setName(this.name);
        Person person = new Person();
        person.setId(personId);
        task.setPerson(person);
        task.setDescription(this.description);
        return task;
    }
}
