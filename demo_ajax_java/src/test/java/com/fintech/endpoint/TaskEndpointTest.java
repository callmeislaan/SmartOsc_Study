package com.fintech.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fintech.domain.Person;
import com.fintech.domain.Task;
import com.fintech.dto.TaskDTO;
import com.fintech.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
public class TaskEndpointTest {

    private MockMvc mockMvc;

    @Mock
    TaskService taskService;

    @InjectMocks
    TaskEndpoint taskEndpoint;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(taskEndpoint)
                .build();
    }

    @Test
    public void shouldSaveTaskReturnThatTaskSaved() throws Exception {
        Task task = new Task();
        task.setName("di lam");
        task.setDescription("ngay");
        task.setPerson(new Person());

        when(taskService.save(any())).thenReturn(task);

        mockMvc.perform(post("/api_v1/task/save")
                .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new TaskDTO(task))))
                .andExpect(jsonPath("$.name").value("di lam"))
                .andExpect(jsonPath("$.description").value("ngay"));

    }
}
