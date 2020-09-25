package com.fintech.soap_task.service;

import com.fintech.soap_task.modal.Task;
import com.fintech.soap_task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public List<Task> getAllByOrderByPriorityDesc() {
        return taskRepository.findAllByOrderByPriorityDesc();
    }
}
