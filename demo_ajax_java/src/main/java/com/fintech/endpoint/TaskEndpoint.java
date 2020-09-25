package com.fintech.endpoint;

import com.fintech.dto.TaskDTO;
import com.fintech.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/api_v1/task")
public class TaskEndpoint {
    @Autowired
    TaskService taskService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO save(@Valid @RequestBody TaskDTO taskDTO) {
        return new TaskDTO(taskService.save(taskDTO.toEntity()));
    }

}
