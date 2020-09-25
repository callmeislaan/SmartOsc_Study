package com.fintech.service;

import com.fintech.domain.Person;
import com.fintech.domain.Task;
import com.fintech.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TaskServiceTest {

    private MockMvc mockMvc;

    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskService taskService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(taskService).build();
    }

    @Test
    public void shouldSaveTaskSuccess() {
        Task task = new Task(1L, "lau nha", "ngay", new Person());
        when(taskRepository.save(any())).thenReturn(task);
        Task taskResult = taskService.save(task);
        assertEquals(task, taskResult);
    }
}