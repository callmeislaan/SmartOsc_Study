package com.fintech.repository;

import com.fintech.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskRepositoryTest {

//    @Autowired
//    TaskRepository taskRepository;
//
//    @Test
//    public void shouldSaveTaskSuccess() {
//        Task task = new Task();
//        task.setName("lau nha");
//        task.setDescription("2 lan");
//        taskRepository.save(task);
//        List<Task> taskResult = taskRepository.findAll();
//        assertEquals(taskResult.get(0), task);
//    }
}
